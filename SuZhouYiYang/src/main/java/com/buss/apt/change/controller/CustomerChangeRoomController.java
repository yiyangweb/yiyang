package com.buss.apt.change.controller;
import com.buss.apt.change.entity.CustomerChangeRoomEntity;
import com.buss.apt.change.service.CustomerChangeRoomServiceI;
import com.buss.apt.change.page.CustomerChangeRoomPage;
import com.buss.apt.change.entity.CheckChangeDesEntity;
import com.buss.apt.change.entity.ChangeRoomFeeEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.utils.BillNumbers;
import org.apache.log4j.Logger;
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
 * @Description: 换房管理
 * @author onlineGenerator
 * @date 2018-07-22 17:24:20
 * @version V1.0   
 *
 */
@Api(value="CustomerChangeRoom",description="换房管理",tags="customerChangeRoomController")
@Controller
@RequestMapping("/customerChangeRoomController")
public class CustomerChangeRoomController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerChangeRoomController.class);

	@Autowired
	private CustomerChangeRoomServiceI customerChangeRoomService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 换房管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/apt/change/customerChangeRoomList");
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
	public void datagrid(CustomerChangeRoomEntity customerChangeRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerChangeRoomEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerChangeRoom);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerChangeRoomService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除换房管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerChangeRoomEntity customerChangeRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerChangeRoom = systemService.getEntity(CustomerChangeRoomEntity.class, customerChangeRoom.getId());
		String message = "换房管理删除成功";
		try{
			customerChangeRoomService.delMain(customerChangeRoom);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "换房管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除换房管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "换房管理删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerChangeRoomEntity customerChangeRoom = systemService.getEntity(CustomerChangeRoomEntity.class,
				id
				);
				customerChangeRoomService.delMain(customerChangeRoom);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "换房管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加换房管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerChangeRoomEntity customerChangeRoom,CustomerChangeRoomPage customerChangeRoomPage, HttpServletRequest request) {
		List<CheckChangeDesEntity> checkChangeDesList =  customerChangeRoomPage.getCheckChangeDesList();
		List<ChangeRoomFeeEntity> changeRoomFeeList =  customerChangeRoomPage.getChangeRoomFeeList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			customerChangeRoomService.addMain(customerChangeRoom, checkChangeDesList,changeRoomFeeList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "换房管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新换房管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerChangeRoomEntity customerChangeRoom,CustomerChangeRoomPage customerChangeRoomPage, HttpServletRequest request) {
		List<CheckChangeDesEntity> checkChangeDesList =  customerChangeRoomPage.getCheckChangeDesList();
		List<ChangeRoomFeeEntity> changeRoomFeeList =  customerChangeRoomPage.getChangeRoomFeeList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerChangeRoomService.updateMain(customerChangeRoom, checkChangeDesList,changeRoomFeeList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新换房管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 换房管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerChangeRoomEntity customerChangeRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerChangeRoom.getId())) {
			customerChangeRoom = customerChangeRoomService.getEntity(CustomerChangeRoomEntity.class, customerChangeRoom.getId());
			req.setAttribute("customerChangeRoomPage", customerChangeRoom);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerChangeRoom.setNo(billNum.commonNumber("CR0"));
			req.setAttribute("customerChangeRoomPage", customerChangeRoom);
		}
		return new ModelAndView("com/buss/apt/change/customerChangeRoom-add");
	}
	
	/**
	 * 换房管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerChangeRoomEntity customerChangeRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerChangeRoom.getId())) {
			customerChangeRoom = customerChangeRoomService.getEntity(CustomerChangeRoomEntity.class, customerChangeRoom.getId());
			req.setAttribute("customerChangeRoomPage", customerChangeRoom);
		}
		return new ModelAndView("com/buss/apt/change/customerChangeRoom-update");
	}
	
	
	/**
	 * 加载明细列表[换房检查]
	 * 
	 * @return
	 */
	@RequestMapping(params = "checkChangeDesList")
	public ModelAndView checkChangeDesList(CustomerChangeRoomEntity customerChangeRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerChangeRoom.getId();
		//===================================================================================
		//查询-换房检查
	    String hql0 = "from CheckChangeDesEntity where 1 = 1 AND jH_ID = ? ";
	    try{
	    	List<CheckChangeDesEntity> checkChangeDesEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("checkChangeDesList", checkChangeDesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/change/checkChangeDesList");
	}
	/**
	 * 加载明细列表[退缴费情况]
	 * 
	 * @return
	 */
	@RequestMapping(params = "changeRoomFeeList")
	public ModelAndView changeRoomFeeList(CustomerChangeRoomEntity customerChangeRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = customerChangeRoom.getId();
		//===================================================================================
		//查询-退缴费情况
	    String hql1 = "from ChangeRoomFeeEntity where 1 = 1 AND cHANGE_ID = ? ";
	    try{
	    	List<ChangeRoomFeeEntity> changeRoomFeeEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("changeRoomFeeList", changeRoomFeeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/change/changeRoomFeeList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerChangeRoomEntity customerChangeRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerChangeRoomEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerChangeRoom);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerChangeRoomEntity> list=this.customerChangeRoomService.getListByCriteriaQuery(cq, false);
    	List<CustomerChangeRoomPage> pageList=new ArrayList<CustomerChangeRoomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerChangeRoomEntity entity:list){
        		try{
        		CustomerChangeRoomPage page=new CustomerChangeRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CheckChangeDesEntity where 1 = 1 AND jH_ID = ? ";
        	        List<CheckChangeDesEntity> checkChangeDesEntityList = systemService.findHql(hql0,id0);
            		page.setCheckChangeDesList(checkChangeDesEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from ChangeRoomFeeEntity where 1 = 1 AND cHANGE_ID = ? ";
        	        List<ChangeRoomFeeEntity> changeRoomFeeEntityList = systemService.findHql(hql1,id1);
            		page.setChangeRoomFeeList(changeRoomFeeEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"换房管理");
        map.put(NormalExcelConstants.CLASS,CustomerChangeRoomPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("换房管理列表", "导出人:Jeecg",
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
				List<CustomerChangeRoomPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerChangeRoomPage.class, params);
				CustomerChangeRoomEntity entity1=null;
				for (CustomerChangeRoomPage page : list) {
					entity1=new CustomerChangeRoomEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerChangeRoomService.addMain(entity1, page.getCheckChangeDesList(),page.getChangeRoomFeeList());
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
		map.put(NormalExcelConstants.FILE_NAME,"换房管理");
		map.put(NormalExcelConstants.CLASS,CustomerChangeRoomPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("换房管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerChangeRoomController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCommit")
	@ResponseBody
	public AjaxJson doCommit(CustomerChangeRoomEntity customerChangeRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		CustomerChangeRoomEntity t = customerChangeRoomService.get(CustomerChangeRoomEntity.class, customerChangeRoom.getId());
		try{
			customerChangeRoomService.doCommitSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="换房管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerChangeRoomPage>> list() {
		List<CustomerChangeRoomEntity> list= customerChangeRoomService.getList(CustomerChangeRoomEntity.class);
    	List<CustomerChangeRoomPage> pageList=new ArrayList<CustomerChangeRoomPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerChangeRoomEntity entity:list){
        		try{
        			CustomerChangeRoomPage page=new CustomerChangeRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from CheckChangeDesEntity where 1 = 1 AND jH_ID = ? ";
	    			List<CheckChangeDesEntity> checkChangeDesOldList = this.customerChangeRoomService.findHql(hql0,id0);
            		page.setCheckChangeDesList(checkChangeDesOldList);
				     String hql1 = "from ChangeRoomFeeEntity where 1 = 1 AND cHANGE_ID = ? ";
	    			List<ChangeRoomFeeEntity> changeRoomFeeOldList = this.customerChangeRoomService.findHql(hql1,id1);
            		page.setChangeRoomFeeList(changeRoomFeeOldList);
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
	@ApiOperation(value="根据ID获取换房管理信息",notes="根据ID获取换房管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerChangeRoomEntity task = customerChangeRoomService.get(CustomerChangeRoomEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取换房管理信息为空");
		}
		CustomerChangeRoomPage page = new CustomerChangeRoomPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from CheckChangeDesEntity where 1 = 1 AND jH_ID = ? ";
			List<CheckChangeDesEntity> checkChangeDesOldList = this.customerChangeRoomService.findHql(hql0,id0);
    		page.setCheckChangeDesList(checkChangeDesOldList);
		    String hql1 = "from ChangeRoomFeeEntity where 1 = 1 AND cHANGE_ID = ? ";
			List<ChangeRoomFeeEntity> changeRoomFeeOldList = this.customerChangeRoomService.findHql(hql1,id1);
    		page.setChangeRoomFeeList(changeRoomFeeOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建换房管理")
	public ResponseMessage<?> create(@ApiParam(name="换房管理对象")@RequestBody CustomerChangeRoomPage customerChangeRoomPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerChangeRoomPage>> failures = validator.validate(customerChangeRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckChangeDesEntity> checkChangeDesList =  customerChangeRoomPage.getCheckChangeDesList();
		List<ChangeRoomFeeEntity> changeRoomFeeList =  customerChangeRoomPage.getChangeRoomFeeList();
		
		CustomerChangeRoomEntity customerChangeRoom = new CustomerChangeRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerChangeRoomPage,customerChangeRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存换房管理失败");
        }
		customerChangeRoomService.addMain(customerChangeRoom, checkChangeDesList,changeRoomFeeList);

		return Result.success(customerChangeRoom);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新换房管理",notes="更新换房管理")
	public ResponseMessage<?> update(@RequestBody CustomerChangeRoomPage customerChangeRoomPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerChangeRoomPage>> failures = validator.validate(customerChangeRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckChangeDesEntity> checkChangeDesList =  customerChangeRoomPage.getCheckChangeDesList();
		List<ChangeRoomFeeEntity> changeRoomFeeList =  customerChangeRoomPage.getChangeRoomFeeList();
		
		CustomerChangeRoomEntity customerChangeRoom = new CustomerChangeRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerChangeRoomPage,customerChangeRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("换房管理更新失败");
        }
		customerChangeRoomService.updateMain(customerChangeRoom, checkChangeDesList,changeRoomFeeList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除换房管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerChangeRoomEntity customerChangeRoom = customerChangeRoomService.get(CustomerChangeRoomEntity.class, id);
			customerChangeRoomService.delMain(customerChangeRoom);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("换房管理删除失败");
		}

		return Result.success();
	}
}
