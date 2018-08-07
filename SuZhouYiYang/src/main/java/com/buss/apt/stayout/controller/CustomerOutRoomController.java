package com.buss.apt.stayout.controller;
import com.buss.apt.stayout.entity.CustomerOutRoomEntity;
import com.buss.apt.stayout.service.CustomerOutRoomServiceI;
import com.buss.apt.stayout.page.CustomerOutRoomPage;
import com.buss.apt.stayout.entity.CheckOutDesEntity;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.utils.BillNumbers;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
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
 * @Description: 退房管理
 * @author onlineGenerator
 * @date 2018-07-13 22:07:26
 * @version V1.0   
 *
 */
@Api(value="CustomerOutRoom",description="退房管理",tags="customerOutRoomController")
@Controller
@RequestMapping("/customerOutRoomController")
public class CustomerOutRoomController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerOutRoomController.class);

	@Autowired
	private CustomerOutRoomServiceI customerOutRoomService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 退房管理列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/apt/stayout/customerOutRoomList");
	}
	/**
	 * 退房审核列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "manageList")
	public ModelAndView manageList(HttpServletRequest request) {
		return new ModelAndView("com/buss/apt/stayout/customerOutRoomManageList");
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
	public void datagrid(CustomerOutRoomEntity customerOutRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerOutRoomEntity.class, dataGrid);
		//查询条件组装器
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//System.out.println(cmpCode);
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerOutRoom);
		try{
		//自定义追加查询条件
        String query_outNo = request.getParameter("no");
        String query_customerName = request.getParameter("customerName");
			String query_roomName = request.getParameter("roomName");
		String query_dealDate_begin = request.getParameter("dealDate_begin");
		String query_dealDate_end = request.getParameter("dealDate_end");
		cq.eq("sysCompanyCode",cmpCode);
		if(StringUtil.isNotEmpty(query_outNo)){
			cq.like("no","%"+query_outNo+"%");
		}
		if(StringUtil.isNotEmpty(query_customerName)){
			cq.like("customerName","%"+query_customerName+"%");
		}
		if(StringUtil.isNotEmpty(query_roomName)){
				cq.like("roomName","%"+query_roomName+"%");
		}

		if(StringUtil.isNotEmpty(query_dealDate_begin)){
			cq.ge("dealDate", new SimpleDateFormat("yyyy-MM-dd").parse(query_dealDate_begin));
		}
		if(StringUtil.isNotEmpty(query_dealDate_end)){
			cq.le("dealDate", new SimpleDateFormat("yyyy-MM-dd").parse(query_dealDate_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerOutRoomService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	@RequestMapping(params = "datagrid2")
	public void datagrid2(CustomerOutRoomEntity customerOutRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerOutRoomEntity.class, dataGrid);
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerOutRoom);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		try{
			//自定义追加查询条件
			String query_outNo = request.getParameter("no");
			String query_customerName = request.getParameter("customerName");
			String query_dealDate_begin = request.getParameter("dealDate_begin");
			String query_dealDate_end = request.getParameter("dealDate_end");
			cq.notEq("outStatus","1");
			cq.eq("sysCompanyCode",cmpCode);
			//cq.in("out_status", new String[]{"1","2","3","4"});
			if(StringUtil.isNotEmpty(query_outNo)){
				cq.like("no","%"+query_outNo+"%");
			}
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}

			if(StringUtil.isNotEmpty(query_dealDate_begin)){
				cq.ge("dealDate", new SimpleDateFormat("yyyy-MM-dd").parse(query_dealDate_begin));
			}
			if(StringUtil.isNotEmpty(query_dealDate_end)){
				cq.le("dealDate", new SimpleDateFormat("yyyy-MM-dd").parse(query_dealDate_end));
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerOutRoomService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除退房管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerOutRoomEntity customerOutRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerOutRoom = systemService.getEntity(CustomerOutRoomEntity.class, customerOutRoom.getId());
		String message = "退房管理删除成功";
		try{
			customerOutRoomService.delMain(customerOutRoom);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退房管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除退房管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "退房管理删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerOutRoomEntity customerOutRoom = systemService.getEntity(CustomerOutRoomEntity.class,
				id
				);
				customerOutRoomService.delMain(customerOutRoom);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "退房管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加退房管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerOutRoomEntity customerOutRoom,CustomerOutRoomPage customerOutRoomPage, HttpServletRequest request) {
		List<CheckOutDesEntity> checkOutDesList =  customerOutRoomPage.getCheckOutDesList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		customerOutRoom.setOutStatus("1");
		try{
			customerOutRoomService.addMain(customerOutRoom, checkOutDesList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退房管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新退房管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerOutRoomEntity customerOutRoom,CustomerOutRoomPage customerOutRoomPage, HttpServletRequest request) {
		List<CheckOutDesEntity> checkOutDesList =  customerOutRoomPage.getCheckOutDesList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerOutRoomService.updateMain(customerOutRoom, checkOutDesList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新退房管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 退房管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerOutRoomEntity customerOutRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerOutRoom.getId())) {
			customerOutRoom = customerOutRoomService.getEntity(CustomerOutRoomEntity.class, customerOutRoom.getId());
			req.setAttribute("customerOutRoomPage", customerOutRoom);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerOutRoom.setNo(billNum.commonNumber("SO0"));
			req.setAttribute("customerOutRoomPage", customerOutRoom);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/apt/stayout/customerOutRoom-add");
	}
	
	/**
	 * 退房管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerOutRoomEntity customerOutRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerOutRoom.getId())) {
			customerOutRoom = customerOutRoomService.getEntity(CustomerOutRoomEntity.class, customerOutRoom.getId());
			req.setAttribute("customerOutRoomPage", customerOutRoom);
		}
		return new ModelAndView("com/buss/apt/stayout/customerOutRoom-update");
	}
	
	
	/**
	 * 加载明细列表[检查情况]
	 * 
	 * @return
	 */
	@RequestMapping(params = "checkOutDesList")
	public ModelAndView checkOutDesList(CustomerOutRoomEntity customerOutRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerOutRoom.getId();
		//===================================================================================
		//查询-检查情况
	    String hql0 = "from CheckOutDesEntity where 1 = 1 AND oT_ID = ? ";
	    try{
	    	List<CheckOutDesEntity> checkOutDesEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("checkOutDesList", checkOutDesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/stayout/checkOutDesList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerOutRoomEntity customerOutRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerOutRoomEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerOutRoom);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerOutRoomEntity> list=this.customerOutRoomService.getListByCriteriaQuery(cq, false);
    	List<CustomerOutRoomPage> pageList=new ArrayList<CustomerOutRoomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerOutRoomEntity entity:list){
        		try{
        		CustomerOutRoomPage page=new CustomerOutRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CheckOutDesEntity where 1 = 1 AND oT_ID = ? ";
        	        List<CheckOutDesEntity> checkOutDesEntityList = systemService.findHql(hql0,id0);
            		page.setCheckOutDesList(checkOutDesEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"退房管理");
        map.put(NormalExcelConstants.CLASS,CustomerOutRoomPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("退房管理列表", "导出人:Jeecg",
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
				List<CustomerOutRoomPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerOutRoomPage.class, params);
				CustomerOutRoomEntity entity1=null;
				for (CustomerOutRoomPage page : list) {
					entity1=new CustomerOutRoomEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerOutRoomService.addMain(entity1, page.getCheckOutDesList());
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
		map.put(NormalExcelConstants.FILE_NAME,"退房管理");
		map.put(NormalExcelConstants.CLASS,CustomerOutRoomPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("退房管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerOutRoomController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doOut_put")
	@ResponseBody
	public AjaxJson doOut_put(CustomerOutRoomEntity customerOutRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		CustomerOutRoomEntity t = customerOutRoomService.get(CustomerOutRoomEntity.class, customerOutRoom.getId());
		try{
			customerOutRoomService.doOut_putSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-同意退房
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doOut_pass")
	@ResponseBody
	public AjaxJson doOut_pass(CustomerOutRoomEntity customerOutRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "同意退房成功";
		CustomerOutRoomEntity t = customerOutRoomService.get(CustomerOutRoomEntity.class, customerOutRoom.getId());
		TSUser user = ResourceUtil.getSessionUser();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			customerOutRoomService.doOut_passSql(t,user.getRealName(),sdf.format(now));
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "同意退房失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-退回
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doOut_return")
	@ResponseBody
	public AjaxJson doOut_return(CustomerOutRoomEntity customerOutRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "退回成功";
		TSUser user = ResourceUtil.getSessionUser();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CustomerOutRoomEntity t = customerOutRoomService.get(CustomerOutRoomEntity.class, customerOutRoom.getId());
		try{
			customerOutRoomService.doOut_returnSql(t,user.getRealName(),sdf.format(now));
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退回失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="退房管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerOutRoomPage>> list() {
		List<CustomerOutRoomEntity> list= customerOutRoomService.getList(CustomerOutRoomEntity.class);
    	List<CustomerOutRoomPage> pageList=new ArrayList<CustomerOutRoomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerOutRoomEntity entity:list){
        		try{
        			CustomerOutRoomPage page=new CustomerOutRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from CheckOutDesEntity where 1 = 1 AND oT_ID = ? ";
	    			List<CheckOutDesEntity> checkOutDesOldList = this.customerOutRoomService.findHql(hql0,id0);
            		page.setCheckOutDesList(checkOutDesOldList);
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
	@ApiOperation(value="根据ID获取退房管理信息",notes="根据ID获取退房管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerOutRoomEntity task = customerOutRoomService.get(CustomerOutRoomEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取退房管理信息为空");
		}
		CustomerOutRoomPage page = new CustomerOutRoomPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from CheckOutDesEntity where 1 = 1 AND oT_ID = ? ";
			List<CheckOutDesEntity> checkOutDesOldList = this.customerOutRoomService.findHql(hql0,id0);
    		page.setCheckOutDesList(checkOutDesOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建退房管理")
	public ResponseMessage<?> create(@ApiParam(name="退房管理对象")@RequestBody CustomerOutRoomPage customerOutRoomPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerOutRoomPage>> failures = validator.validate(customerOutRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckOutDesEntity> checkOutDesList =  customerOutRoomPage.getCheckOutDesList();
		
		CustomerOutRoomEntity customerOutRoom = new CustomerOutRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerOutRoomPage,customerOutRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存退房管理失败");
        }
		customerOutRoomService.addMain(customerOutRoom, checkOutDesList);

		return Result.success(customerOutRoom);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新退房管理",notes="更新退房管理")
	public ResponseMessage<?> update(@RequestBody CustomerOutRoomPage customerOutRoomPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerOutRoomPage>> failures = validator.validate(customerOutRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckOutDesEntity> checkOutDesList =  customerOutRoomPage.getCheckOutDesList();
		
		CustomerOutRoomEntity customerOutRoom = new CustomerOutRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerOutRoomPage,customerOutRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("退房管理更新失败");
        }
		customerOutRoomService.updateMain(customerOutRoom, checkOutDesList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除退房管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerOutRoomEntity customerOutRoom = customerOutRoomService.get(CustomerOutRoomEntity.class, id);
			customerOutRoomService.delMain(customerOutRoom);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("退房管理删除失败");
		}

		return Result.success();
	}
}
