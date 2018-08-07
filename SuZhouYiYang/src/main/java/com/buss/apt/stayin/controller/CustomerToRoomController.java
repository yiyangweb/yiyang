package com.buss.apt.stayin.controller;
import com.buss.apt.stayin.entity.CustomerToRoomEntity;
import com.buss.apt.stayin.service.CustomerToRoomServiceI;
import com.buss.apt.stayin.page.CustomerToRoomPage;
import com.buss.apt.stayin.entity.CheckListDesEntity;
import com.buss.apt.stayin.entity.CustomerTrainInfoEntity;
import com.buss.apt.stayin.entity.CustomerRoomDesEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.utils.BillNumbers;
import org.apache.log4j.Logger;
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
 * @Description: 入住管理
 * @author onlineGenerator
 * @date 2018-07-15 17:06:39
 * @version V1.0   
 *
 */
@Api(value="CustomerToRoom",description="入住管理",tags="customerToRoomController")
@Controller
@RequestMapping("/customerToRoomController")
public class CustomerToRoomController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerToRoomController.class);

	@Autowired
	private CustomerToRoomServiceI customerToRoomService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 入住管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/apt/stayin/customerToRoomList");
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
	public void datagrid(CustomerToRoomEntity customerToRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerToRoomEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerToRoom);
		try{
			//自定义追加查询条件
			String query_customerName = request.getParameter("customerName");
			String query_customerNo = request.getParameter("customerNo");
			String query_buildingName = request.getParameter("buildingName");
			String query_roomName = request.getParameter("roomName");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			if(StringUtil.isNotEmpty(query_customerNo)){
				cq.like("customerNo","%"+query_customerNo+"%");
			}
			if(StringUtil.isNotEmpty(query_buildingName)){
				cq.like("buildingName","%"+query_buildingName+"%");
			}
			if(StringUtil.isNotEmpty(query_roomName)){
				cq.like("roomName","%"+query_roomName+"%");
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerToRoomService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除入住管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerToRoomEntity customerToRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerToRoom = systemService.getEntity(CustomerToRoomEntity.class, customerToRoom.getId());
		String message = "入住管理删除成功";
		try{
			customerToRoomService.delMain(customerToRoom);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入住管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除入住管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "入住管理删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerToRoomEntity customerToRoom = systemService.getEntity(CustomerToRoomEntity.class,
				id
				);
				customerToRoomService.delMain(customerToRoom);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入住管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加入住管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerToRoomEntity customerToRoom,CustomerToRoomPage customerToRoomPage, HttpServletRequest request) {
		List<CheckListDesEntity> checkListDesList =  customerToRoomPage.getCheckListDesList();
		List<CustomerTrainInfoEntity> customerTrainInfoList =  customerToRoomPage.getCustomerTrainInfoList();
		List<CustomerRoomDesEntity> customerRoomDesList =  customerToRoomPage.getCustomerRoomDesList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			customerToRoomService.addMain(customerToRoom, checkListDesList,customerTrainInfoList,customerRoomDesList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入住管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新入住管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerToRoomEntity customerToRoom,CustomerToRoomPage customerToRoomPage, HttpServletRequest request) {
		List<CheckListDesEntity> checkListDesList =  customerToRoomPage.getCheckListDesList();
		List<CustomerTrainInfoEntity> customerTrainInfoList =  customerToRoomPage.getCustomerTrainInfoList();
		List<CustomerRoomDesEntity> customerRoomDesList =  customerToRoomPage.getCustomerRoomDesList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerToRoomService.updateMain(customerToRoom, checkListDesList,customerTrainInfoList,customerRoomDesList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新入住管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 入住管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerToRoomEntity customerToRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerToRoom.getId())) {
			customerToRoom = customerToRoomService.getEntity(CustomerToRoomEntity.class, customerToRoom.getId());
			req.setAttribute("customerToRoomPage", customerToRoom);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerToRoom.setNo(billNum.commonNumber("SI0"));
			req.setAttribute("customerToRoomPage", customerToRoom);
		}
        TSUser user = ResourceUtil.getSessionUser();
        req.setAttribute("user", user);
		return new ModelAndView("com/buss/apt/stayin/customerToRoom-add");
	}
	
	/**
	 * 入住管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerToRoomEntity customerToRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerToRoom.getId())) {
			customerToRoom = customerToRoomService.getEntity(CustomerToRoomEntity.class, customerToRoom.getId());
			req.setAttribute("customerToRoomPage", customerToRoom);
		}
		return new ModelAndView("com/buss/apt/stayin/customerToRoom-update");
	}
	
	
	/**
	 * 加载明细列表[入住检查]
	 * 
	 * @return
	 */
	@RequestMapping(params = "checkListDesList")
	public ModelAndView checkListDesList(CustomerToRoomEntity customerToRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerToRoom.getId();
		//===================================================================================
		//查询-入住检查
	    String hql0 = "from CheckListDesEntity where 1 = 1 AND cR_ID = ? ";
	    try{
	    	List<CheckListDesEntity> checkListDesEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("checkListDesList", checkListDesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/stayin/checkListDesList");
	}
	/**
	 * 加载明细列表[入住培训]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerTrainInfoList")
	public ModelAndView customerTrainInfoList(CustomerToRoomEntity customerToRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = customerToRoom.getId();
		//===================================================================================
		//查询-入住培训
	    String hql1 = "from CustomerTrainInfoEntity where 1 = 1 AND cR_ID = ? ";
	    try{
	    	List<CustomerTrainInfoEntity> customerTrainInfoEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("customerTrainInfoList", customerTrainInfoEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/stayin/customerTrainInfoList");
	}
	/**
	 * 加载明细列表[入住情况]
	 * 
	 * @return
	 */
	@RequestMapping(params = "customerRoomDesList")
	public ModelAndView customerRoomDesList(CustomerToRoomEntity customerToRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = customerToRoom.getId();
		//===================================================================================
		//查询-入住情况
	    String hql2 = "from CustomerRoomDesEntity where 1 = 1 AND iN_ID = ? ";
	    try{
	    	List<CustomerRoomDesEntity> customerRoomDesEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("customerRoomDesList", customerRoomDesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/stayin/customerRoomDesList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerToRoomEntity customerToRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerToRoomEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerToRoom);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerToRoomEntity> list=this.customerToRoomService.getListByCriteriaQuery(cq, false);
    	List<CustomerToRoomPage> pageList=new ArrayList<CustomerToRoomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerToRoomEntity entity:list){
        		try{
        		CustomerToRoomPage page=new CustomerToRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CheckListDesEntity where 1 = 1 AND cR_ID = ? ";
        	        List<CheckListDesEntity> checkListDesEntityList = systemService.findHql(hql0,id0);
            		page.setCheckListDesList(checkListDesEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from CustomerTrainInfoEntity where 1 = 1 AND cR_ID = ? ";
        	        List<CustomerTrainInfoEntity> customerTrainInfoEntityList = systemService.findHql(hql1,id1);
            		page.setCustomerTrainInfoList(customerTrainInfoEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from CustomerRoomDesEntity where 1 = 1 AND iN_ID = ? ";
        	        List<CustomerRoomDesEntity> customerRoomDesEntityList = systemService.findHql(hql2,id2);
            		page.setCustomerRoomDesList(customerRoomDesEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"入住管理");
        map.put(NormalExcelConstants.CLASS,CustomerToRoomPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("入住管理列表", "导出人:Jeecg",
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
				List<CustomerToRoomPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerToRoomPage.class, params);
				CustomerToRoomEntity entity1=null;
				for (CustomerToRoomPage page : list) {
					entity1=new CustomerToRoomEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerToRoomService.addMain(entity1, page.getCheckListDesList(),page.getCustomerTrainInfoList(),page.getCustomerRoomDesList());
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
		map.put(NormalExcelConstants.FILE_NAME,"入住管理");
		map.put(NormalExcelConstants.CLASS,CustomerToRoomPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("入住管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerToRoomController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCommit")
	@ResponseBody
	public AjaxJson doCommit(CustomerToRoomEntity customerToRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		CustomerToRoomEntity t = customerToRoomService.get(CustomerToRoomEntity.class, customerToRoom.getId());
		try{
			customerToRoomService.doCommitSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-确认入住
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doConfirm")
	@ResponseBody
	public AjaxJson doConfirm(CustomerToRoomEntity customerToRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "确认入住成功";
		CustomerToRoomEntity t = customerToRoomService.get(CustomerToRoomEntity.class, customerToRoom.getId());
		try{
			customerToRoomService.doConfirmSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认入住失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="入住管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerToRoomPage>> list() {
		List<CustomerToRoomEntity> list= customerToRoomService.getList(CustomerToRoomEntity.class);
    	List<CustomerToRoomPage> pageList=new ArrayList<CustomerToRoomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerToRoomEntity entity:list){
        		try{
        			CustomerToRoomPage page=new CustomerToRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
					Object id2 = entity.getId();
				     String hql0 = "from CheckListDesEntity where 1 = 1 AND cR_ID = ? ";
	    			List<CheckListDesEntity> checkListDesOldList = this.customerToRoomService.findHql(hql0,id0);
            		page.setCheckListDesList(checkListDesOldList);
				     String hql1 = "from CustomerTrainInfoEntity where 1 = 1 AND cR_ID = ? ";
	    			List<CustomerTrainInfoEntity> customerTrainInfoOldList = this.customerToRoomService.findHql(hql1,id1);
            		page.setCustomerTrainInfoList(customerTrainInfoOldList);
				     String hql2 = "from CustomerRoomDesEntity where 1 = 1 AND iN_ID = ? ";
	    			List<CustomerRoomDesEntity> customerRoomDesOldList = this.customerToRoomService.findHql(hql2,id2);
            		page.setCustomerRoomDesList(customerRoomDesOldList);
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
	@ApiOperation(value="根据ID获取入住管理信息",notes="根据ID获取入住管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerToRoomEntity task = customerToRoomService.get(CustomerToRoomEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取入住管理信息为空");
		}
		CustomerToRoomPage page = new CustomerToRoomPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
				Object id2 = task.getId();
		    String hql0 = "from CheckListDesEntity where 1 = 1 AND cR_ID = ? ";
			List<CheckListDesEntity> checkListDesOldList = this.customerToRoomService.findHql(hql0,id0);
    		page.setCheckListDesList(checkListDesOldList);
		    String hql1 = "from CustomerTrainInfoEntity where 1 = 1 AND cR_ID = ? ";
			List<CustomerTrainInfoEntity> customerTrainInfoOldList = this.customerToRoomService.findHql(hql1,id1);
    		page.setCustomerTrainInfoList(customerTrainInfoOldList);
		    String hql2 = "from CustomerRoomDesEntity where 1 = 1 AND iN_ID = ? ";
			List<CustomerRoomDesEntity> customerRoomDesOldList = this.customerToRoomService.findHql(hql2,id2);
    		page.setCustomerRoomDesList(customerRoomDesOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建入住管理")
	public ResponseMessage<?> create(@ApiParam(name="入住管理对象")@RequestBody CustomerToRoomPage customerToRoomPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerToRoomPage>> failures = validator.validate(customerToRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckListDesEntity> checkListDesList =  customerToRoomPage.getCheckListDesList();
		List<CustomerTrainInfoEntity> customerTrainInfoList =  customerToRoomPage.getCustomerTrainInfoList();
		List<CustomerRoomDesEntity> customerRoomDesList =  customerToRoomPage.getCustomerRoomDesList();
		
		CustomerToRoomEntity customerToRoom = new CustomerToRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerToRoomPage,customerToRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存入住管理失败");
        }
		customerToRoomService.addMain(customerToRoom, checkListDesList,customerTrainInfoList,customerRoomDesList);

		return Result.success(customerToRoom);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新入住管理",notes="更新入住管理")
	public ResponseMessage<?> update(@RequestBody CustomerToRoomPage customerToRoomPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerToRoomPage>> failures = validator.validate(customerToRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckListDesEntity> checkListDesList =  customerToRoomPage.getCheckListDesList();
		List<CustomerTrainInfoEntity> customerTrainInfoList =  customerToRoomPage.getCustomerTrainInfoList();
		List<CustomerRoomDesEntity> customerRoomDesList =  customerToRoomPage.getCustomerRoomDesList();
		
		CustomerToRoomEntity customerToRoom = new CustomerToRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerToRoomPage,customerToRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("入住管理更新失败");
        }
		customerToRoomService.updateMain(customerToRoom, checkListDesList,customerTrainInfoList,customerRoomDesList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除入住管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerToRoomEntity customerToRoom = customerToRoomService.get(CustomerToRoomEntity.class, id);
			customerToRoomService.delMain(customerToRoom);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入住管理删除失败");
		}

		return Result.success();
	}
}
