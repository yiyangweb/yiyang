package com.buss.sale.contract.controller;
import com.buss.sale.contract.entity.CustomerContractEntity;
import com.buss.sale.contract.service.CustomerContractServiceI;
import com.buss.sale.contract.page.CustomerContractPage;
import com.buss.sale.contract.entity.ContractChargeListEntity;
import com.buss.sale.contract.entity.ChargeListEntity;
import com.buss.sale.contract.entity.CustomerContractSubEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.utils.BillNumbers;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller
 * @Description: 签订合同记录
 * @author onlineGenerator
 * @date 2018-07-15 10:11:18
 * @version V1.0   
 *
 */
@Api(value="CustomerContract",description="签订合同记录",tags="customerContractController")
@Controller
@RequestMapping("/customerContractController")
public class CustomerContractController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerContractController.class);

	@Autowired
	private CustomerContractServiceI customerContractService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;

	/**
	 * 签订合同记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
        request.setAttribute("dataurl", "customerContractController.do?datagriduser");
		return new ModelAndView("com/buss/sale/contract/customerContractList");
	}
    /**
     * 签订合同记录列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "listmanager")
    public ModelAndView listmanager(HttpServletRequest request) {
        request.setAttribute("dataurl", "customerContractController.do?datagrid");
        return new ModelAndView("com/buss/sale/contract/customerContractList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     * @param user
     */
    @RequestMapping(params = "datagriduser") //非管理员权限
    public void datagriduser(CustomerContractEntity customerContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(CustomerContractEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
        //查询条件组装器
        //org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerContract);
        try{
			//自定义追加查询条件
			String query_customerName = request.getParameter("customerName");
			String query_no = request.getParameter("no");
			String query_buildingName = request.getParameter("buildingName");
			String query_roomName = request.getParameter("roomName");
			String query_isInstalments = request.getParameter("isInstalments");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			if(StringUtil.isNotEmpty(query_no)){
				cq.like("no","%"+query_no+"%");
			}
			if(StringUtil.isNotEmpty(query_buildingName)){
				cq.like("buildingName","%"+query_buildingName+"%");
			}
			if(StringUtil.isNotEmpty(query_roomName)){
				cq.like("roomName","%"+query_roomName+"%");
			}
			if(StringUtil.isNotEmpty(query_isInstalments)){
				cq.eq("isInstalments",query_isInstalments);
			}
			cq.add(Restrictions.sqlRestriction("contract_status in ('1','2')"));
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.customerContractService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CustomerContractEntity customerContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerContractEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerContract);
		try{
			//自定义追加查询条件
			String query_customerName = request.getParameter("customerName");
			String query_no = request.getParameter("no");
			String query_buildingName = request.getParameter("buildingName");
			String query_roomName = request.getParameter("roomName");
			String query_isInstalments = request.getParameter("isInstalments");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			if(StringUtil.isNotEmpty(query_no)){
				cq.like("no","%"+query_no+"%");
			}
			if(StringUtil.isNotEmpty(query_buildingName)){
				cq.like("buildingName","%"+query_buildingName+"%");
			}
			if(StringUtil.isNotEmpty(query_roomName)){
				cq.like("roomName","%"+query_roomName+"%");
			}
			if(StringUtil.isNotEmpty(query_isInstalments)){
				cq.eq("isInstalments",query_isInstalments);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerContractService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除签订合同记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerContractEntity customerContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerContract = systemService.getEntity(CustomerContractEntity.class, customerContract.getId());
		String message = "签订合同记录删除成功";
		try{
			customerContractService.delMain(customerContract);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "签订合同记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除签订合同记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "签订合同记录删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerContractEntity customerContract = systemService.getEntity(CustomerContractEntity.class,
				id
				);
				customerContractService.delMain(customerContract);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "签订合同记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加签订合同记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerContractEntity customerContract,CustomerContractPage customerContractPage, HttpServletRequest request) {
		List<ContractChargeListEntity> contractChargeListList =  customerContractPage.getContractChargeListList();
		List<ChargeListEntity> chargeListList =  customerContractPage.getChargeListList();
		List<CustomerContractSubEntity> customerContractSubList =  customerContractPage.getCustomerContractSubList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			customerContractService.addMain(customerContract, contractChargeListList,chargeListList,customerContractSubList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "签订合同记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(customerContract);
		return j;
	}
	/**
	 * 更新签订合同记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerContractEntity customerContract,CustomerContractPage customerContractPage, HttpServletRequest request) {
		List<ContractChargeListEntity> contractChargeListList =  customerContractPage.getContractChargeListList();
		List<ChargeListEntity> chargeListList =  customerContractPage.getChargeListList();
		List<CustomerContractSubEntity> customerContractSubList =  customerContractPage.getCustomerContractSubList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerContractService.updateMain(customerContract, contractChargeListList,chargeListList,customerContractSubList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新签订合同记录失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 签订合同记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerContractEntity customerContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerContract.getId())) {
			customerContract = customerContractService.getEntity(CustomerContractEntity.class, customerContract.getId());
			req.setAttribute("customerContractPage", customerContract);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerContract.setNo(billNum.commonNumber("CC0"));
			req.setAttribute("customerContractPage", customerContract);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/sale/contract/customerContract-add");
	}
	
	/**
	 * 签订合同记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerContractEntity customerContract, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerContract.getId())) {
			customerContract = customerContractService.getEntity(CustomerContractEntity.class, customerContract.getId());
			req.setAttribute("customerContractPage", customerContract);
		}
		return new ModelAndView("com/buss/sale/contract/customerContract-update");
	}
	
	
	/**
	 * 加载明细列表[合同收费列表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "contractChargeListList")
	public ModelAndView contractChargeListList(CustomerContractEntity customerContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerContract.getId();
		//===================================================================================
		//查询-合同收费列表
	    String hql0 = "from ContractChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    try{
	    	List<ContractChargeListEntity> contractChargeListEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("contractChargeListList", contractChargeListEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/contract/contractChargeListList");
	}
	/**
	 * 加载明细列表[分期情况]
	 * 
	 * @return
	 */
	@RequestMapping(params = "chargeListList")
	public ModelAndView chargeListList(CustomerContractEntity customerContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = customerContract.getId();
		//===================================================================================
		//查询-分期情况
	    String hql1 = "from ChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    try{
	    	List<ChargeListEntity> chargeListEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("chargeListList", chargeListEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/contract/chargeListList");
	}
	/**
	 * 加载明细列表[附属合同]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerContractSubList")
	public ModelAndView customerContractSubList(CustomerContractEntity customerContract, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = customerContract.getId();
		//===================================================================================
		//查询-附属合同
	    String hql2 = "from CustomerContractSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    try{
	    	List<CustomerContractSubEntity> customerContractSubEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("customerContractSubList", customerContractSubEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/contract/customerContractSubList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerContractEntity customerContract,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerContractEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerContract);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerContractEntity> list=this.customerContractService.getListByCriteriaQuery(cq, false);
    	List<CustomerContractPage> pageList=new ArrayList<CustomerContractPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerContractEntity entity:list){
        		try{
        		CustomerContractPage page=new CustomerContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ContractChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
        	        List<ContractChargeListEntity> contractChargeListEntityList = systemService.findHql(hql0,id0);
            		page.setContractChargeListList(contractChargeListEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from ChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
        	        List<ChargeListEntity> chargeListEntityList = systemService.findHql(hql1,id1);
            		page.setChargeListList(chargeListEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from CustomerContractSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
        	        List<CustomerContractSubEntity> customerContractSubEntityList = systemService.findHql(hql2,id2);
            		page.setCustomerContractSubList(customerContractSubEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"签订合同记录");
        map.put(NormalExcelConstants.CLASS,CustomerContractPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("签订合同记录列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<CustomerContractPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerContractPage.class, params);
				CustomerContractEntity entity1=null;
				for (CustomerContractPage page : list) {
					entity1=new CustomerContractEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerContractService.addMain(entity1, page.getContractChargeListList(),page.getChargeListList(),page.getCustomerContractSubList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			return j;
	}
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"签订合同记录");
		map.put(NormalExcelConstants.CLASS,CustomerContractPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("签订合同记录列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "customerContractController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doMultiCommit")
	@ResponseBody
	public AjaxJson doMultiCommit(CustomerContractEntity customerContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		CustomerContractEntity t = customerContractService.get(CustomerContractEntity.class, customerContract.getId());
		try{
			customerContractService.doMultiCommitSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCharge")
	@ResponseBody
	public AjaxJson doCharge(CustomerContractEntity customerContract, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "缴费成功";
		CustomerContractEntity t = customerContractService.get(CustomerContractEntity.class, customerContract.getId());
		try{
			customerContractService.doChargeSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "缴费失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="签订合同记录列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerContractPage>> list() {
		List<CustomerContractEntity> list= customerContractService.getList(CustomerContractEntity.class);
    	List<CustomerContractPage> pageList=new ArrayList<CustomerContractPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerContractEntity entity:list){
        		try{
        			CustomerContractPage page=new CustomerContractPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
				     String hql0 = "from ContractChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    			List<ContractChargeListEntity> contractChargeListOldList = this.customerContractService.findHql(hql0,id0);
            		page.setContractChargeListList(contractChargeListOldList);
				     String hql1 = "from ChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    			List<ChargeListEntity> chargeListOldList = this.customerContractService.findHql(hql1,id1);
            		page.setChargeListList(chargeListOldList);
				     String hql2 = "from CustomerContractSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    			List<CustomerContractSubEntity> customerContractSubOldList = this.customerContractService.findHql(hql2,id2);
            		page.setCustomerContractSubList(customerContractSubOldList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
		return Result.success(pageList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取签订合同记录信息",notes="根据ID获取签订合同记录信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerContractEntity task = customerContractService.get(CustomerContractEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取签订合同记录信息为空");
		}
		CustomerContractPage page = new CustomerContractPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from ContractChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
			List<ContractChargeListEntity> contractChargeListOldList = this.customerContractService.findHql(hql0,id0);
    		page.setContractChargeListList(contractChargeListOldList);
		    String hql1 = "from ChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
			List<ChargeListEntity> chargeListOldList = this.customerContractService.findHql(hql1,id1);
    		page.setChargeListList(chargeListOldList);
		    String hql2 = "from CustomerContractSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
			List<CustomerContractSubEntity> customerContractSubOldList = this.customerContractService.findHql(hql2,id2);
    		page.setCustomerContractSubList(customerContractSubOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建签订合同记录")
	public ResponseMessage<?> create(@ApiParam(name="签订合同记录对象")@RequestBody CustomerContractPage customerContractPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerContractPage>> failures = validator.validate(customerContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ContractChargeListEntity> contractChargeListList =  customerContractPage.getContractChargeListList();
		List<ChargeListEntity> chargeListList =  customerContractPage.getChargeListList();
		List<CustomerContractSubEntity> customerContractSubList =  customerContractPage.getCustomerContractSubList();
		
		CustomerContractEntity customerContract = new CustomerContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerContractPage,customerContract);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存签订合同记录失败");
        }
		customerContractService.addMain(customerContract, contractChargeListList,chargeListList,customerContractSubList);

		return Result.success(customerContract);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新签订合同记录",notes="更新签订合同记录")
	public ResponseMessage<?> update(@RequestBody CustomerContractPage customerContractPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerContractPage>> failures = validator.validate(customerContractPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ContractChargeListEntity> contractChargeListList =  customerContractPage.getContractChargeListList();
		List<ChargeListEntity> chargeListList =  customerContractPage.getChargeListList();
		List<CustomerContractSubEntity> customerContractSubList =  customerContractPage.getCustomerContractSubList();
		
		CustomerContractEntity customerContract = new CustomerContractEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerContractPage,customerContract);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("签订合同记录更新失败");
        }
		customerContractService.updateMain(customerContract, contractChargeListList,chargeListList,customerContractSubList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除签订合同记录")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerContractEntity customerContract = customerContractService.get(CustomerContractEntity.class, id);
			customerContractService.delMain(customerContract);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("签订合同记录删除失败");
		}

		return Result.success();
	}
	/**
	 * 获取文件附件信息
	 * 
	 * @param id customerContract主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
}
