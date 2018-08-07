package com.buss.sale.customer.controller;
import com.buss.sale.customer.entity.CustomerBaseEntity;
import com.buss.sale.customer.service.CustomerBaseServiceI;
import com.buss.sale.customer.page.CustomerBasePage;
import com.buss.sale.customer.entity.CustomerProfileEntity;
import com.buss.sale.customer.entity.CustomerRelativesEntity;
import com.buss.sale.customer.entity.CustomerEducatioinEntity;
import com.buss.sale.customer.entity.CustomerJobEntity;
import com.buss.sale.customer.entity.CustomerCommonChargeEntity;
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

/**   
 * @Title: Controller
 * @Description: 客户信息
 * @author onlineGenerator
 * @date 2018-07-09 14:45:50
 * @version V1.0   
 *
 */
@Api(value="CustomerBase",description="客户信息",tags="customerBaseController")
@Controller
@RequestMapping("/customerBaseController")
public class CustomerBaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerBaseController.class);

	@Autowired
	private CustomerBaseServiceI customerBaseService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 客户信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("dataurl", "customerBaseController.do?datagriduser");
		return new ModelAndView("com/buss/sale/customer/customerBaseList");
	}
	/**
	 * 客户信息列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listmanager")
	public ModelAndView listmanager(HttpServletRequest request) {
		request.setAttribute("dataurl", "customerBaseController.do?datagrid");
		return new ModelAndView("com/buss/sale/customer/customerBaseList");
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
	public void datagriduser(CustomerBaseEntity customerBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerBaseEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerBase);
		try{
            //自定义追加查询条件
            String query_name = request.getParameter("name");
            String query_idCardNo = request.getParameter("idCardNo");
            String query_sex = request.getParameter("sex");
            String query_age_begin = request.getParameter("age_begin");
            String query_age_end = request.getParameter("age_end");
            cq.eq("sysCompanyCode",cmpCode);
            if(StringUtil.isNotEmpty(query_name)){
                cq.like("name","%"+query_name+"%");
            }
            if(StringUtil.isNotEmpty(query_idCardNo)){
                cq.like("idCardNo","%"+query_idCardNo+"%");
            }
            if(StringUtil.isNotEmpty(query_sex)){
                cq.eq("sex",query_sex);
            }
            if(StringUtil.isNotEmpty(query_age_begin)){
                cq.add(Restrictions.sqlRestriction("age >= "+query_age_begin));
            }
            if(StringUtil.isNotEmpty(query_age_end)){
                cq.add(Restrictions.sqlRestriction("age <= "+query_age_end));
            }
			cq.add(Restrictions.sqlRestriction("customer_status in ('1','2','3')"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
        cq.add();
		this.customerBaseService.getDataGridReturn(cq, true);
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
	public void datagrid(CustomerBaseEntity customerBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerBaseEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerBase);
		try{
			//自定义追加查询条件
			String query_name = request.getParameter("name");
			String query_idCardNo = request.getParameter("idCardNo");
			String query_sex = request.getParameter("sex");
			String query_age_begin = request.getParameter("age_begin");
			String query_age_end = request.getParameter("age_end");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_name)){
				cq.like("name","%"+query_name+"%");
			}
			if(StringUtil.isNotEmpty(query_idCardNo)){
				cq.like("idCardNo","%"+query_idCardNo+"%");
			}
			if(StringUtil.isNotEmpty(query_sex)){
				cq.eq("sex",query_sex);
			}
			if(StringUtil.isNotEmpty(query_age_begin)){
				cq.add(Restrictions.sqlRestriction("age >= "+query_age_begin));
			}
			if(StringUtil.isNotEmpty(query_age_end)){
				cq.add(Restrictions.sqlRestriction("age <= "+query_age_end));
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerBaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除客户信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerBaseEntity customerBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerBase = systemService.getEntity(CustomerBaseEntity.class, customerBase.getId());
		String message = "客户信息删除成功";
		try{
			customerBaseService.delMain(customerBase);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除客户信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "客户信息删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerBaseEntity customerBase = systemService.getEntity(CustomerBaseEntity.class,
				id
				);
				customerBaseService.delMain(customerBase);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客户信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加客户信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerBaseEntity customerBase,CustomerBasePage customerBasePage, HttpServletRequest request) {
		List<CustomerProfileEntity> customerProfileList =  customerBasePage.getCustomerProfileList();
		List<CustomerRelativesEntity> customerRelativesList =  customerBasePage.getCustomerRelativesList();
		List<CustomerEducatioinEntity> customerEducatioinList =  customerBasePage.getCustomerEducatioinList();
		List<CustomerJobEntity> customerJobList =  customerBasePage.getCustomerJobList();
		List<CustomerCommonChargeEntity> customerCommonChargeList =  customerBasePage.getCustomerCommonChargeList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			customerBaseService.addMain(customerBase, customerProfileList,customerRelativesList,customerEducatioinList,customerJobList,customerCommonChargeList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新客户信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerBaseEntity customerBase,CustomerBasePage customerBasePage, HttpServletRequest request) {
		List<CustomerProfileEntity> customerProfileList =  customerBasePage.getCustomerProfileList();
		List<CustomerRelativesEntity> customerRelativesList =  customerBasePage.getCustomerRelativesList();
		List<CustomerEducatioinEntity> customerEducatioinList =  customerBasePage.getCustomerEducatioinList();
		List<CustomerJobEntity> customerJobList =  customerBasePage.getCustomerJobList();
		List<CustomerCommonChargeEntity> customerCommonChargeList =  customerBasePage.getCustomerCommonChargeList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerBaseService.updateMain(customerBase, customerProfileList,customerRelativesList,customerEducatioinList,customerJobList,customerCommonChargeList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新客户信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 客户信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerBaseEntity customerBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerBase.getId())) {
			customerBase = customerBaseService.getEntity(CustomerBaseEntity.class, customerBase.getId());
			req.setAttribute("customerBasePage", customerBase);
		}else {
			BillNumbers billNum = new BillNumbers();
			customerBase.setNo(billNum.commonNumber("CB0"));
			req.setAttribute("customerBasePage", customerBase);
		}
		return new ModelAndView("com/buss/sale/customer/customerBase-add");
	}
	
	/**
	 * 客户信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerBaseEntity customerBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerBase.getId())) {
			customerBase = customerBaseService.getEntity(CustomerBaseEntity.class, customerBase.getId());
			req.setAttribute("customerBasePage", customerBase);
		}
		return new ModelAndView("com/buss/sale/customer/customerBase-update");
	}
	
	
	/**
	 * 加载明细列表[详细信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerProfileList")
	public ModelAndView customerProfileList(CustomerBaseEntity customerBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerBase.getId();
		//===================================================================================
		//查询-详细信息
	    String hql0 = "from CustomerProfileEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    try{
	    	List<CustomerProfileEntity> customerProfileEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("customerProfileList", customerProfileEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/customer/customerProfileList");
	}
	/**
	 * 加载明细列表[亲属关系]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerRelativesList")
	public ModelAndView customerRelativesList(CustomerBaseEntity customerBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = customerBase.getId();
		//===================================================================================
		//查询-亲属关系
	    String hql1 = "from CustomerRelativesEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    try{
	    	List<CustomerRelativesEntity> customerRelativesEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("customerRelativesList", customerRelativesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/customer/customerRelativesList");
	}
	/**
	 * 加载明细列表[教育情况]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerEducatioinList")
	public ModelAndView customerEducatioinList(CustomerBaseEntity customerBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = customerBase.getId();
		//===================================================================================
		//查询-教育情况
	    String hql2 = "from CustomerEducatioinEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    try{
	    	List<CustomerEducatioinEntity> customerEducatioinEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("customerEducatioinList", customerEducatioinEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/customer/customerEducatioinList");
	}
	/**
	 * 加载明细列表[工作经历]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerJobList")
	public ModelAndView customerJobList(CustomerBaseEntity customerBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id3 = customerBase.getId();
		//===================================================================================
		//查询-工作经历
	    String hql3 = "from CustomerJobEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    try{
	    	List<CustomerJobEntity> customerJobEntityList = systemService.findHql(hql3,id3);
			req.setAttribute("customerJobList", customerJobEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/customer/customerJobList");
	}
	/**
	 * 加载明细列表[周期收费]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerCommonChargeList")
	public ModelAndView customerCommonChargeList(CustomerBaseEntity customerBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id4 = customerBase.getId();
		//===================================================================================
		//查询-周期收费
	    String hql4 = "from CustomerCommonChargeEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    try{
	    	List<CustomerCommonChargeEntity> customerCommonChargeEntityList = systemService.findHql(hql4,id4);
			req.setAttribute("customerCommonChargeList", customerCommonChargeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/customer/customerCommonChargeList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerBaseEntity customerBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerBaseEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerBase);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerBaseEntity> list=this.customerBaseService.getListByCriteriaQuery(cq, false);
    	List<CustomerBasePage> pageList=new ArrayList<CustomerBasePage>();
        if(list!=null&&list.size()>0){
        	for(CustomerBaseEntity entity:list){
        		try{
        		CustomerBasePage page=new CustomerBasePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CustomerProfileEntity where 1 = 1 AND cUSTOMER_ID = ? ";
        	        List<CustomerProfileEntity> customerProfileEntityList = systemService.findHql(hql0,id0);
            		page.setCustomerProfileList(customerProfileEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from CustomerRelativesEntity where 1 = 1 AND cUSTOMER_ID = ? ";
        	        List<CustomerRelativesEntity> customerRelativesEntityList = systemService.findHql(hql1,id1);
            		page.setCustomerRelativesList(customerRelativesEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from CustomerEducatioinEntity where 1 = 1 AND cUSTOMER_ID = ? ";
        	        List<CustomerEducatioinEntity> customerEducatioinEntityList = systemService.findHql(hql2,id2);
            		page.setCustomerEducatioinList(customerEducatioinEntityList);
            	    Object id3 = entity.getId();
				    String hql3 = "from CustomerJobEntity where 1 = 1 AND cUSTOMER_ID = ? ";
        	        List<CustomerJobEntity> customerJobEntityList = systemService.findHql(hql3,id3);
            		page.setCustomerJobList(customerJobEntityList);
            	    Object id4 = entity.getId();
				    String hql4 = "from CustomerCommonChargeEntity where 1 = 1 AND cUSTOMER_ID = ? ";
        	        List<CustomerCommonChargeEntity> customerCommonChargeEntityList = systemService.findHql(hql4,id4);
            		page.setCustomerCommonChargeList(customerCommonChargeEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"客户信息");
        map.put(NormalExcelConstants.CLASS,CustomerBasePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("客户信息列表", "导出人:Jeecg",
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
				List<CustomerBasePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerBasePage.class, params);
				CustomerBaseEntity entity1=null;
				for (CustomerBasePage page : list) {
					entity1=new CustomerBaseEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerBaseService.addMain(entity1, page.getCustomerProfileList(),page.getCustomerRelativesList(),page.getCustomerEducatioinList(),page.getCustomerJobList(),page.getCustomerCommonChargeList());
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
		map.put(NormalExcelConstants.FILE_NAME,"客户信息");
		map.put(NormalExcelConstants.CLASS,CustomerBasePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("客户信息列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerBaseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-确认提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCustomersbt")
	@ResponseBody
	public AjaxJson doCustomersbt(CustomerBaseEntity customerBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "确认提交成功";
		CustomerBaseEntity t = customerBaseService.get(CustomerBaseEntity.class, customerBase.getId());
		try{
			customerBaseService.doCustomersbtSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="客户信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerBasePage>> list() {
		List<CustomerBaseEntity> list= customerBaseService.getList(CustomerBaseEntity.class);
    	List<CustomerBasePage> pageList=new ArrayList<CustomerBasePage>();
        if(list!=null&&list.size()>0){
        	for(CustomerBaseEntity entity:list){
        		try{
        			CustomerBasePage page=new CustomerBasePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
					Object id3 = entity.getId();
					Object id4 = entity.getId();
				     String hql0 = "from CustomerProfileEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    			List<CustomerProfileEntity> customerProfileOldList = this.customerBaseService.findHql(hql0,id0);
            		page.setCustomerProfileList(customerProfileOldList);
				     String hql1 = "from CustomerRelativesEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    			List<CustomerRelativesEntity> customerRelativesOldList = this.customerBaseService.findHql(hql1,id1);
            		page.setCustomerRelativesList(customerRelativesOldList);
				     String hql2 = "from CustomerEducatioinEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    			List<CustomerEducatioinEntity> customerEducatioinOldList = this.customerBaseService.findHql(hql2,id2);
            		page.setCustomerEducatioinList(customerEducatioinOldList);
				     String hql3 = "from CustomerJobEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    			List<CustomerJobEntity> customerJobOldList = this.customerBaseService.findHql(hql3,id3);
            		page.setCustomerJobList(customerJobOldList);
				     String hql4 = "from CustomerCommonChargeEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    			List<CustomerCommonChargeEntity> customerCommonChargeOldList = this.customerBaseService.findHql(hql4,id4);
            		page.setCustomerCommonChargeList(customerCommonChargeOldList);
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
	@ApiOperation(value="根据ID获取客户信息信息",notes="根据ID获取客户信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerBaseEntity task = customerBaseService.get(CustomerBaseEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取客户信息信息为空");
		}
		CustomerBasePage page = new CustomerBasePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
				Object id3 = task.getId();
				Object id4 = task.getId();
		    String hql0 = "from CustomerProfileEntity where 1 = 1 AND cUSTOMER_ID = ? ";
			List<CustomerProfileEntity> customerProfileOldList = this.customerBaseService.findHql(hql0,id0);
    		page.setCustomerProfileList(customerProfileOldList);
		    String hql1 = "from CustomerRelativesEntity where 1 = 1 AND cUSTOMER_ID = ? ";
			List<CustomerRelativesEntity> customerRelativesOldList = this.customerBaseService.findHql(hql1,id1);
    		page.setCustomerRelativesList(customerRelativesOldList);
		    String hql2 = "from CustomerEducatioinEntity where 1 = 1 AND cUSTOMER_ID = ? ";
			List<CustomerEducatioinEntity> customerEducatioinOldList = this.customerBaseService.findHql(hql2,id2);
    		page.setCustomerEducatioinList(customerEducatioinOldList);
		    String hql3 = "from CustomerJobEntity where 1 = 1 AND cUSTOMER_ID = ? ";
			List<CustomerJobEntity> customerJobOldList = this.customerBaseService.findHql(hql3,id3);
    		page.setCustomerJobList(customerJobOldList);
		    String hql4 = "from CustomerCommonChargeEntity where 1 = 1 AND cUSTOMER_ID = ? ";
			List<CustomerCommonChargeEntity> customerCommonChargeOldList = this.customerBaseService.findHql(hql4,id4);
    		page.setCustomerCommonChargeList(customerCommonChargeOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建客户信息")
	public ResponseMessage<?> create(@ApiParam(name="客户信息对象")@RequestBody CustomerBasePage customerBasePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerBasePage>> failures = validator.validate(customerBasePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CustomerProfileEntity> customerProfileList =  customerBasePage.getCustomerProfileList();
		List<CustomerRelativesEntity> customerRelativesList =  customerBasePage.getCustomerRelativesList();
		List<CustomerEducatioinEntity> customerEducatioinList =  customerBasePage.getCustomerEducatioinList();
		List<CustomerJobEntity> customerJobList =  customerBasePage.getCustomerJobList();
		List<CustomerCommonChargeEntity> customerCommonChargeList =  customerBasePage.getCustomerCommonChargeList();
		
		CustomerBaseEntity customerBase = new CustomerBaseEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerBasePage,customerBase);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存客户信息失败");
        }
		customerBaseService.addMain(customerBase, customerProfileList,customerRelativesList,customerEducatioinList,customerJobList,customerCommonChargeList);

		return Result.success(customerBase);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新客户信息",notes="更新客户信息")
	public ResponseMessage<?> update(@RequestBody CustomerBasePage customerBasePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerBasePage>> failures = validator.validate(customerBasePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CustomerProfileEntity> customerProfileList =  customerBasePage.getCustomerProfileList();
		List<CustomerRelativesEntity> customerRelativesList =  customerBasePage.getCustomerRelativesList();
		List<CustomerEducatioinEntity> customerEducatioinList =  customerBasePage.getCustomerEducatioinList();
		List<CustomerJobEntity> customerJobList =  customerBasePage.getCustomerJobList();
		List<CustomerCommonChargeEntity> customerCommonChargeList =  customerBasePage.getCustomerCommonChargeList();
		
		CustomerBaseEntity customerBase = new CustomerBaseEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerBasePage,customerBase);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("客户信息更新失败");
        }
		customerBaseService.updateMain(customerBase, customerProfileList,customerRelativesList,customerEducatioinList,customerJobList,customerCommonChargeList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除客户信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerBaseEntity customerBase = customerBaseService.get(CustomerBaseEntity.class, id);
			customerBaseService.delMain(customerBase);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户信息删除失败");
		}

		return Result.success();
	}
}
