package com.buss.apt.feebill.controller;
import com.buss.apt.feebill.entity.FeeBillEntity;
import com.buss.apt.feebill.service.FeeBillServiceI;
import com.buss.apt.feebill.page.FeeBillPage;
import com.buss.apt.feebill.entity.CustomerFeeDesEntity;
import com.buss.apt.feebill.entity.PaymentListEntity;
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
 * @Description: 收费单
 * @author onlineGenerator
 * @date 2018-07-10 22:23:42
 * @version V1.0   
 *
 */
@Api(value="FeeBill",description="收费单",tags="feeBillController")
@Controller
@RequestMapping("/feeBillController")
public class FeeBillController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FeeBillController.class);

	@Autowired
	private FeeBillServiceI feeBillService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 收费单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list_create") //创建-收费单界面
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("dataurl", "feeBillController.do?datagrid");
		return new ModelAndView("com/buss/apt/feebill/feeBillList-create");
	}
	@RequestMapping(params = "list_audit")  //审核-收费单界面
	public ModelAndView list_audit(HttpServletRequest request) {
		request.setAttribute("dataurl", "feeBillController.do?datagrid");
		return new ModelAndView("com/buss/apt/feebill/feeBillList-audit");
	}
	@RequestMapping(params = "list_casher")   //收银-收费单界面
	public ModelAndView list_casher(HttpServletRequest request) {
		request.setAttribute("dataurl", "feeBillController.do?datagrid_shouyin");
		return new ModelAndView("com/buss/apt/feebill/feeBillList-casher");
	}
	@RequestMapping(params = "list_archive")//归档-收费单界面
	public ModelAndView list_archive(HttpServletRequest request) {
		request.setAttribute("dataurl", "feeBillController.do?datagrid_caiwu");
		return new ModelAndView("com/buss/apt/feebill/feeBillList-archive");
	}


	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "datagrid_souyin")
	public void datagrid_souyin(FeeBillEntity feeBill,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(FeeBillEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, feeBill);
		try{
			//自定义追加查询条件
			String query_no= request.getParameter("no");
			String query_name = request.getParameter("name");
			String query_customerName = request.getParameter("customerName");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_no)){
				cq.like("no","%"+query_no+"%");
			}
			if(StringUtil.isNotEmpty(query_name)){
				cq.like("name","%"+query_name+"%");
			}
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			cq.add(Restrictions.sqlRestriction("fb_status in ('3','4')"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.feeBillService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	@RequestMapping(params = "datagrid_caiwu")
	public void datagrid_caiwu(FeeBillEntity feeBill,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(FeeBillEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, feeBill);
		try{
			//自定义追加查询条件
			String query_no= request.getParameter("no");
			String query_name = request.getParameter("name");
			String query_customerName = request.getParameter("customerName");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_no)){
				cq.like("no","%"+query_no+"%");
			}
			if(StringUtil.isNotEmpty(query_name)){
				cq.like("name","%"+query_name+"%");
			}
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			cq.add(Restrictions.sqlRestriction("fb_status in ('3','4'.'5','6')"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.feeBillService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	@RequestMapping(params = "datagrid")
	public void datagrid(FeeBillEntity feeBill,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(FeeBillEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, feeBill);
		try{
			//自定义追加查询条件
			String query_no= request.getParameter("no");
			String query_name = request.getParameter("name");
			String query_customerName = request.getParameter("customerName");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_no)){
				cq.like("no","%"+query_no+"%");
			}
			if(StringUtil.isNotEmpty(query_name)){
				cq.like("name","%"+query_name+"%");
			}
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.feeBillService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除收费单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(FeeBillEntity feeBill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		feeBill = systemService.getEntity(FeeBillEntity.class, feeBill.getId());
		String message = "收费单删除成功";
		try{
			feeBillService.delMain(feeBill);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "收费单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除收费单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "收费单删除成功";
		try{
			for(String id:ids.split(",")){
				FeeBillEntity feeBill = systemService.getEntity(FeeBillEntity.class,
				id
				);
				feeBillService.delMain(feeBill);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "收费单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加收费单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(FeeBillEntity feeBill,FeeBillPage feeBillPage, HttpServletRequest request) {
		List<CustomerFeeDesEntity> customerFeeDesList =  feeBillPage.getCustomerFeeDesList();
		List<PaymentListEntity> paymentListList =  feeBillPage.getPaymentListList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			feeBillService.addMain(feeBill, customerFeeDesList,paymentListList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "收费单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新收费单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(FeeBillEntity feeBill,FeeBillPage feeBillPage, HttpServletRequest request) {
		List<CustomerFeeDesEntity> customerFeeDesList =  feeBillPage.getCustomerFeeDesList();
		List<PaymentListEntity> paymentListList =  feeBillPage.getPaymentListList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			feeBillService.updateMain(feeBill, customerFeeDesList,paymentListList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新收费单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 收费单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(FeeBillEntity feeBill, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(feeBill.getId())) {
			feeBill = feeBillService.getEntity(FeeBillEntity.class, feeBill.getId());
			req.setAttribute("feeBillPage", feeBill);
		}else{
			BillNumbers billNum = new BillNumbers();
			feeBill.setNo(billNum.commonNumber("FB0"));
			req.setAttribute("feeBillPage", feeBill);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/apt/feebill/feeBill-add");
	}
	
	/**
	 * 收费单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(FeeBillEntity feeBill, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(feeBill.getId())) {
			feeBill = feeBillService.getEntity(FeeBillEntity.class, feeBill.getId());
			req.setAttribute("feeBillPage", feeBill);
		}
		return new ModelAndView("com/buss/apt/feebill/feeBill-update");
	}
	
	
	/**
	 * 加载明细列表[收费详细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerFeeDesList")
	public ModelAndView customerFeeDesList(FeeBillEntity feeBill, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = feeBill.getId();
		//===================================================================================
		//查询-收费详细
	    String hql0 = "from CustomerFeeDesEntity where 1 = 1 AND fEE_BILL_ID = ? ";
	    try{
	    	List<CustomerFeeDesEntity> customerFeeDesEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("customerFeeDesList", customerFeeDesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/feebill/customerFeeDesList");
	}
	/**
	 * 加载明细列表[缴费详情]
	 * 
	 * @return
	 */
	@RequestMapping(params = "paymentListList")
	public ModelAndView paymentListList(FeeBillEntity feeBill, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = feeBill.getId();
		//===================================================================================
		//查询-缴费详情
	    String hql1 = "from PaymentListEntity where 1 = 1 AND bILL_ID = ? ";
	    try{
	    	List<PaymentListEntity> paymentListEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("paymentListList", paymentListEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/feebill/paymentListList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(FeeBillEntity feeBill,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(FeeBillEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, feeBill);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<FeeBillEntity> list=this.feeBillService.getListByCriteriaQuery(cq, false);
    	List<FeeBillPage> pageList=new ArrayList<FeeBillPage>();
        if(list!=null&&list.size()>0){
        	for(FeeBillEntity entity:list){
        		try{
        		FeeBillPage page=new FeeBillPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CustomerFeeDesEntity where 1 = 1 AND fEE_BILL_ID = ? ";
        	        List<CustomerFeeDesEntity> customerFeeDesEntityList = systemService.findHql(hql0,id0);
            		page.setCustomerFeeDesList(customerFeeDesEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from PaymentListEntity where 1 = 1 AND bILL_ID = ? ";
        	        List<PaymentListEntity> paymentListEntityList = systemService.findHql(hql1,id1);
            		page.setPaymentListList(paymentListEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"收费单");
        map.put(NormalExcelConstants.CLASS,FeeBillPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("收费单列表", "导出人:Jeecg",
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
				List<FeeBillPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), FeeBillPage.class, params);
				FeeBillEntity entity1=null;
				for (FeeBillPage page : list) {
					entity1=new FeeBillEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            feeBillService.addMain(entity1, page.getCustomerFeeDesList(),page.getPaymentListList());
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
		map.put(NormalExcelConstants.FILE_NAME,"收费单");
		map.put(NormalExcelConstants.CLASS,FeeBillPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("收费单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "feeBillController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCommit")
	@ResponseBody
	public AjaxJson doCommit(FeeBillEntity feeBill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		FeeBillEntity t = feeBillService.get(FeeBillEntity.class, feeBill.getId());
		try{
			feeBillService.doCommitSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-同意
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doOk_fee")
	@ResponseBody
	public AjaxJson doOk_fee(FeeBillEntity feeBill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "同意成功";
		FeeBillEntity t = feeBillService.get(FeeBillEntity.class, feeBill.getId());
		try{
			feeBillService.doOk_feeSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "同意失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-不同意
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doNo_fee")
	@ResponseBody
	public AjaxJson doNo_fee(FeeBillEntity feeBill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "不同意成功";
		FeeBillEntity t = feeBillService.get(FeeBillEntity.class, feeBill.getId());
		try{
			feeBillService.doNo_feeSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "不同意失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doReceive")
	@ResponseBody
	public AjaxJson doReceive(FeeBillEntity feeBill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "缴费成功";
		FeeBillEntity t = feeBillService.get(FeeBillEntity.class, feeBill.getId());
		try{
			feeBillService.doReceiveSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "缴费失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-归档
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doArchive")
	@ResponseBody
	public AjaxJson doArchive(FeeBillEntity feeBill, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "归档成功";
		FeeBillEntity t = feeBillService.get(FeeBillEntity.class, feeBill.getId());
		try{
			feeBillService.doArchiveSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "归档失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="收费单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<FeeBillPage>> list() {
		List<FeeBillEntity> list= feeBillService.getList(FeeBillEntity.class);
    	List<FeeBillPage> pageList=new ArrayList<FeeBillPage>();
        if(list!=null&&list.size()>0){
        	for(FeeBillEntity entity:list){
        		try{
        			FeeBillPage page=new FeeBillPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from CustomerFeeDesEntity where 1 = 1 AND fEE_BILL_ID = ? ";
	    			List<CustomerFeeDesEntity> customerFeeDesOldList = this.feeBillService.findHql(hql0,id0);
            		page.setCustomerFeeDesList(customerFeeDesOldList);
				     String hql1 = "from PaymentListEntity where 1 = 1 AND bILL_ID = ? ";
	    			List<PaymentListEntity> paymentListOldList = this.feeBillService.findHql(hql1,id1);
            		page.setPaymentListList(paymentListOldList);
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
	@ApiOperation(value="根据ID获取收费单信息",notes="根据ID获取收费单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		FeeBillEntity task = feeBillService.get(FeeBillEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取收费单信息为空");
		}
		FeeBillPage page = new FeeBillPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from CustomerFeeDesEntity where 1 = 1 AND fEE_BILL_ID = ? ";
			List<CustomerFeeDesEntity> customerFeeDesOldList = this.feeBillService.findHql(hql0,id0);
    		page.setCustomerFeeDesList(customerFeeDesOldList);
		    String hql1 = "from PaymentListEntity where 1 = 1 AND bILL_ID = ? ";
			List<PaymentListEntity> paymentListOldList = this.feeBillService.findHql(hql1,id1);
    		page.setPaymentListList(paymentListOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建收费单")
	public ResponseMessage<?> create(@ApiParam(name="收费单对象")@RequestBody FeeBillPage feeBillPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FeeBillPage>> failures = validator.validate(feeBillPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CustomerFeeDesEntity> customerFeeDesList =  feeBillPage.getCustomerFeeDesList();
		List<PaymentListEntity> paymentListList =  feeBillPage.getPaymentListList();
		
		FeeBillEntity feeBill = new FeeBillEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(feeBillPage,feeBill);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存收费单失败");
        }
		feeBillService.addMain(feeBill, customerFeeDesList,paymentListList);

		return Result.success(feeBill);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新收费单",notes="更新收费单")
	public ResponseMessage<?> update(@RequestBody FeeBillPage feeBillPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FeeBillPage>> failures = validator.validate(feeBillPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CustomerFeeDesEntity> customerFeeDesList =  feeBillPage.getCustomerFeeDesList();
		List<PaymentListEntity> paymentListList =  feeBillPage.getPaymentListList();
		
		FeeBillEntity feeBill = new FeeBillEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(feeBillPage,feeBill);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("收费单更新失败");
        }
		feeBillService.updateMain(feeBill, customerFeeDesList,paymentListList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除收费单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			FeeBillEntity feeBill = feeBillService.get(FeeBillEntity.class, id);
			feeBillService.delMain(feeBill);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("收费单删除失败");
		}

		return Result.success();
	}
}
