package com.buss.base.check.controller;
import com.buss.base.check.entity.CheckListTypeEntity;
import com.buss.base.check.service.CheckListTypeServiceI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 入退住准备内容类型
 * @author onlineGenerator
 * @date 2018-05-15 10:08:06
 * @version V1.0   
 *
 */
@Api(value="CheckListType",description="入退住准备内容类型",tags="checkListTypeController")
@Controller
@RequestMapping("/checkListTypeController")
public class CheckListTypeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CheckListTypeController.class);

	@Autowired
	private CheckListTypeServiceI checkListTypeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 入退住准备内容类型列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/apt.check/checkListTypeList");
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
	public void datagrid(CheckListTypeEntity checkListType,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CheckListTypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, checkListType, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.checkListTypeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除入退住准备内容类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CheckListTypeEntity checkListType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		checkListType = systemService.getEntity(CheckListTypeEntity.class, checkListType.getId());
		message = "入退住准备内容类型删除成功";
		try{
			checkListTypeService.delete(checkListType);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入退住准备内容类型删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除入退住准备内容类型
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入退住准备内容类型删除成功";
		try{
			for(String id:ids.split(",")){
				CheckListTypeEntity checkListType = systemService.getEntity(CheckListTypeEntity.class, 
				id
				);
				checkListTypeService.delete(checkListType);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入退住准备内容类型删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加入退住准备内容类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CheckListTypeEntity checkListType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入退住准备内容类型添加成功";
		try{
			checkListTypeService.save(checkListType);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入退住准备内容类型添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新入退住准备内容类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CheckListTypeEntity checkListType, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "入退住准备内容类型更新成功";
		CheckListTypeEntity t = checkListTypeService.get(CheckListTypeEntity.class, checkListType.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(checkListType, t);
			checkListTypeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "入退住准备内容类型更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 入退住准备内容类型新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CheckListTypeEntity checkListType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(checkListType.getId())) {
			checkListType = checkListTypeService.getEntity(CheckListTypeEntity.class, checkListType.getId());
			req.setAttribute("checkListTypePage", checkListType);
		}
		return new ModelAndView("com/buss/apt.check/checkListType-add");
	}
	/**
	 * 入退住准备内容类型编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CheckListTypeEntity checkListType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(checkListType.getId())) {
			checkListType = checkListTypeService.getEntity(CheckListTypeEntity.class, checkListType.getId());
			req.setAttribute("checkListTypePage", checkListType);
		}
		return new ModelAndView("com/buss/apt.check/checkListType-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","checkListTypeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(CheckListTypeEntity checkListType,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(CheckListTypeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, checkListType, request.getParameterMap());
		List<CheckListTypeEntity> checkListTypes = this.checkListTypeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"入退住准备内容类型");
		modelMap.put(NormalExcelConstants.CLASS,CheckListTypeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("入退住准备内容类型列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,checkListTypes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(CheckListTypeEntity checkListType,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"入退住准备内容类型");
    	modelMap.put(NormalExcelConstants.CLASS,CheckListTypeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("入退住准备内容类型列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<CheckListTypeEntity> listCheckListTypeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),CheckListTypeEntity.class,params);
				for (CheckListTypeEntity checkListType : listCheckListTypeEntitys) {
					checkListTypeService.save(checkListType);
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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="入退住准备内容类型列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CheckListTypeEntity>> list() {
		List<CheckListTypeEntity> listCheckListTypes=checkListTypeService.getList(CheckListTypeEntity.class);
		return Result.success(listCheckListTypes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取入退住准备内容类型信息",notes="根据ID获取入退住准备内容类型信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CheckListTypeEntity task = checkListTypeService.get(CheckListTypeEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取入退住准备内容类型信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建入退住准备内容类型")
	public ResponseMessage<?> create(@ApiParam(name="入退住准备内容类型对象")@RequestBody CheckListTypeEntity checkListType, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CheckListTypeEntity>> failures = validator.validate(checkListType);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			checkListTypeService.save(checkListType);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入退住准备内容类型信息保存失败");
		}
		return Result.success(checkListType);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新入退住准备内容类型",notes="更新入退住准备内容类型")
	public ResponseMessage<?> update(@ApiParam(name="入退住准备内容类型对象")@RequestBody CheckListTypeEntity checkListType) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CheckListTypeEntity>> failures = validator.validate(checkListType);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			checkListTypeService.saveOrUpdate(checkListType);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新入退住准备内容类型信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新入退住准备内容类型信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除入退住准备内容类型")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			checkListTypeService.deleteEntityById(CheckListTypeEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入退住准备内容类型删除失败");
		}

		return Result.success();
	}
}
