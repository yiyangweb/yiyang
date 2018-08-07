package com.buss.nh.nurse.controller;
import com.buss.nh.nurse.entity.NurseRecordEntity;
import com.buss.nh.nurse.service.NurseRecordServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

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
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 护理记录
 * @author onlineGenerator
 * @date 2018-07-15 11:58:54
 * @version V1.0   
 *
 */
@Api(value="NurseRecord",description="护理记录",tags="nurseRecordController")
@Controller
@RequestMapping("/nurseRecordController")
public class NurseRecordController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NurseRecordController.class);

	@Autowired
	private NurseRecordServiceI nurseRecordService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 护理记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/nh/nurse/nurseRecordList");
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
	public void datagrid(NurseRecordEntity nurseRecord,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(NurseRecordEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, nurseRecord, request.getParameterMap());
		try{
		//自定义追加查询条件

		String query_roomName = request.getParameter("roomName");
		String query_customerName = request.getParameter("customerName");
		String query_charger = request.getParameter("charger");
		String query_recordDate_begin = request.getParameter("recordDate_begin");
		String query_recordDate_end = request.getParameter("recordDate_end");

		if(StringUtil.isNotEmpty(query_roomName)){
			cq.like("roomName","%"+query_roomName+"%");
		}
		if(StringUtil.isNotEmpty(query_customerName)){
			cq.like("customerName","%"+query_customerName+"%");
		}
		if(StringUtil.isNotEmpty(query_charger)){
			cq.like("charger","%"+query_charger+"%");
		}
		if(StringUtil.isNotEmpty(query_recordDate_begin)){
			cq.ge("recordDate", new SimpleDateFormat("yyyy-MM-dd").parse(query_recordDate_begin));
		}
		if(StringUtil.isNotEmpty(query_recordDate_end)){
			cq.le("recordDate", new SimpleDateFormat("yyyy-MM-dd").parse(query_recordDate_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.nurseRecordService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除护理记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(NurseRecordEntity nurseRecord, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		nurseRecord = systemService.getEntity(NurseRecordEntity.class, nurseRecord.getId());
		message = "护理记录删除成功";
		try{
			nurseRecordService.delete(nurseRecord);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "护理记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除护理记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "护理记录删除成功";
		try{
			for(String id:ids.split(",")){
				NurseRecordEntity nurseRecord = systemService.getEntity(NurseRecordEntity.class, 
				id
				);
				nurseRecordService.delete(nurseRecord);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "护理记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加护理记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(NurseRecordEntity nurseRecord, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "护理记录添加成功";
		nurseRecord.setJlStatus("1");
		try{
			nurseRecordService.save(nurseRecord);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "护理记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(nurseRecord);
		return j;
	}
	
	/**
	 * 更新护理记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(NurseRecordEntity nurseRecord, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "护理记录更新成功";
		NurseRecordEntity t = nurseRecordService.get(NurseRecordEntity.class, nurseRecord.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(nurseRecord, t);
			nurseRecordService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "护理记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[确认]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doNurse_sbt")
	@ResponseBody
	public AjaxJson doNurse_sbt(NurseRecordEntity nurseRecord, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "确认成功";
		NurseRecordEntity t = nurseRecordService.get(NurseRecordEntity.class, nurseRecord.getId());
		try{
			nurseRecordService.doNurse_sbtBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认失败";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 护理记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(NurseRecordEntity nurseRecord, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(nurseRecord.getId())) {
			nurseRecord = nurseRecordService.getEntity(NurseRecordEntity.class, nurseRecord.getId());
			req.setAttribute("nurseRecordPage", nurseRecord);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/nh/nurse/nurseRecord-add");
	}
	/**
	 * 护理记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(NurseRecordEntity nurseRecord, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(nurseRecord.getId())) {
			nurseRecord = nurseRecordService.getEntity(NurseRecordEntity.class, nurseRecord.getId());
			req.setAttribute("nurseRecordPage", nurseRecord);
		}
		return new ModelAndView("com/buss/nh/nurse/nurseRecord-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","nurseRecordController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(NurseRecordEntity nurseRecord,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(NurseRecordEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, nurseRecord, request.getParameterMap());
		List<NurseRecordEntity> nurseRecords = this.nurseRecordService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"护理记录");
		modelMap.put(NormalExcelConstants.CLASS,NurseRecordEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("护理记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,nurseRecords);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(NurseRecordEntity nurseRecord,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"护理记录");
    	modelMap.put(NormalExcelConstants.CLASS,NurseRecordEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("护理记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
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
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<NurseRecordEntity> listNurseRecordEntitys = ExcelImportUtil.importExcel(file.getInputStream(),NurseRecordEntity.class,params);
				for (NurseRecordEntity nurseRecord : listNurseRecordEntitys) {
					nurseRecordService.save(nurseRecord);
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
	 * 获取文件附件信息
	 * 
	 * @param id nurseRecord主键id
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
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="护理记录列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<NurseRecordEntity>> list() {
		List<NurseRecordEntity> listNurseRecords=nurseRecordService.getList(NurseRecordEntity.class);
		return Result.success(listNurseRecords);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取护理记录信息",notes="根据ID获取护理记录信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		NurseRecordEntity task = nurseRecordService.get(NurseRecordEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取护理记录信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建护理记录")
	public ResponseMessage<?> create(@ApiParam(name="护理记录对象")@RequestBody NurseRecordEntity nurseRecord, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<NurseRecordEntity>> failures = validator.validate(nurseRecord);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			nurseRecordService.save(nurseRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("护理记录信息保存失败");
		}
		return Result.success(nurseRecord);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新护理记录",notes="更新护理记录")
	public ResponseMessage<?> update(@ApiParam(name="护理记录对象")@RequestBody NurseRecordEntity nurseRecord) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<NurseRecordEntity>> failures = validator.validate(nurseRecord);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			nurseRecordService.saveOrUpdate(nurseRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新护理记录信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新护理记录信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除护理记录")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			nurseRecordService.deleteEntityById(NurseRecordEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("护理记录删除失败");
		}

		return Result.success();
	}
}
