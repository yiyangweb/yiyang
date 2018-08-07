package com.buss.base.check.controller;
import com.buss.base.check.entity.CheckInoutChecklistEntity;
import com.buss.base.check.service.CheckInoutChecklistServiceI;
import com.buss.base.check.page.CheckInoutChecklistPage;
import com.buss.base.check.entity.CheckListTypeEntity;
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

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller
 * @Description: 入退住检查项目清单
 * @author onlineGenerator
 * @date 2018-07-02 16:04:33
 * @version V1.0   
 *
 */
@Api(value="CheckInoutChecklist",description="入退住检查项目清单",tags="checkInoutChecklistController")
@Controller
@RequestMapping("/checkInoutChecklistController")
public class CheckInoutChecklistController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CheckInoutChecklistController.class);

	@Autowired
	private CheckInoutChecklistServiceI checkInoutChecklistService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;

	/**
	 * 入退住检查项目清单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/base/check/checkInoutChecklistList");
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
	public void datagrid(CheckInoutChecklistEntity checkInoutChecklist,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CheckInoutChecklistEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, checkInoutChecklist);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.checkInoutChecklistService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除入退住检查项目清单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CheckInoutChecklistEntity checkInoutChecklist, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		checkInoutChecklist = systemService.getEntity(CheckInoutChecklistEntity.class, checkInoutChecklist.getId());
		String message = "入退住检查项目清单删除成功";
		try{
			checkInoutChecklistService.delMain(checkInoutChecklist);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入退住检查项目清单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除入退住检查项目清单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "入退住检查项目清单删除成功";
		try{
			for(String id:ids.split(",")){
				CheckInoutChecklistEntity checkInoutChecklist = systemService.getEntity(CheckInoutChecklistEntity.class,
				id
				);
				checkInoutChecklistService.delMain(checkInoutChecklist);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "入退住检查项目清单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加入退住检查项目清单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CheckInoutChecklistEntity checkInoutChecklist,CheckInoutChecklistPage checkInoutChecklistPage, HttpServletRequest request) {
		List<CheckListTypeEntity> checkListTypeList =  checkInoutChecklistPage.getCheckListTypeList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			checkInoutChecklistService.addMain(checkInoutChecklist, checkListTypeList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "入退住检查项目清单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(checkInoutChecklist);
		return j;
	}
	/**
	 * 更新入退住检查项目清单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CheckInoutChecklistEntity checkInoutChecklist,CheckInoutChecklistPage checkInoutChecklistPage, HttpServletRequest request) {
		List<CheckListTypeEntity> checkListTypeList =  checkInoutChecklistPage.getCheckListTypeList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			checkInoutChecklistService.updateMain(checkInoutChecklist, checkListTypeList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新入退住检查项目清单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 入退住检查项目清单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CheckInoutChecklistEntity checkInoutChecklist, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(checkInoutChecklist.getId())) {
			checkInoutChecklist = checkInoutChecklistService.getEntity(CheckInoutChecklistEntity.class, checkInoutChecklist.getId());
			req.setAttribute("checkInoutChecklistPage", checkInoutChecklist);
		}else{
			BillNumbers billNum = new BillNumbers();
			checkInoutChecklist.setNo(billNum.commonNumber("CL0"));
			req.setAttribute("checkInoutChecklistPage", checkInoutChecklist);
		}
		return new ModelAndView("com/buss/base/check/checkInoutChecklist-add");
	}
	
	/**
	 * 入退住检查项目清单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CheckInoutChecklistEntity checkInoutChecklist, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(checkInoutChecklist.getId())) {
			checkInoutChecklist = checkInoutChecklistService.getEntity(CheckInoutChecklistEntity.class, checkInoutChecklist.getId());
			req.setAttribute("checkInoutChecklistPage", checkInoutChecklist);
		}
		return new ModelAndView("com/buss/base/check/checkInoutChecklist-update");
	}
	
	
	/**
	 * 加载明细列表[入退住准备内容类型]
	 * 
	 * @return
	 */
	@RequestMapping(params = "checkListTypeList")
	public ModelAndView checkListTypeList(CheckInoutChecklistEntity checkInoutChecklist, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = checkInoutChecklist.getId();
		//===================================================================================
		//查询-入退住准备内容类型
	    String hql0 = "from CheckListTypeEntity where 1 = 1 AND cHECKOUT_LIST_ID = ? ";
	    try{
	    	List<CheckListTypeEntity> checkListTypeEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("checkListTypeList", checkListTypeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/base/check/checkListTypeList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CheckInoutChecklistEntity checkInoutChecklist,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CheckInoutChecklistEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, checkInoutChecklist);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CheckInoutChecklistEntity> list=this.checkInoutChecklistService.getListByCriteriaQuery(cq, false);
    	List<CheckInoutChecklistPage> pageList=new ArrayList<CheckInoutChecklistPage>();
        if(list!=null&&list.size()>0){
        	for(CheckInoutChecklistEntity entity:list){
        		try{
        		CheckInoutChecklistPage page=new CheckInoutChecklistPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CheckListTypeEntity where 1 = 1 AND cHECKOUT_LIST_ID = ? ";
        	        List<CheckListTypeEntity> checkListTypeEntityList = systemService.findHql(hql0,id0);
            		page.setCheckListTypeList(checkListTypeEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"入退住检查项目清单");
        map.put(NormalExcelConstants.CLASS,CheckInoutChecklistPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("入退住检查项目清单列表", "导出人:Jeecg",
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
				List<CheckInoutChecklistPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CheckInoutChecklistPage.class, params);
				CheckInoutChecklistEntity entity1=null;
				for (CheckInoutChecklistPage page : list) {
					entity1=new CheckInoutChecklistEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            checkInoutChecklistService.addMain(entity1, page.getCheckListTypeList());
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
		map.put(NormalExcelConstants.FILE_NAME,"入退住检查项目清单");
		map.put(NormalExcelConstants.CLASS,CheckInoutChecklistPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("入退住检查项目清单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "checkInoutChecklistController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="入退住检查项目清单列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CheckInoutChecklistPage>> list() {
		List<CheckInoutChecklistEntity> list= checkInoutChecklistService.getList(CheckInoutChecklistEntity.class);
    	List<CheckInoutChecklistPage> pageList=new ArrayList<CheckInoutChecklistPage>();
        if(list!=null&&list.size()>0){
        	for(CheckInoutChecklistEntity entity:list){
        		try{
        			CheckInoutChecklistPage page=new CheckInoutChecklistPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from CheckListTypeEntity where 1 = 1 AND cHECKOUT_LIST_ID = ? ";
	    			List<CheckListTypeEntity> checkListTypeOldList = this.checkInoutChecklistService.findHql(hql0,id0);
            		page.setCheckListTypeList(checkListTypeOldList);
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
	@ApiOperation(value="根据ID获取入退住检查项目清单信息",notes="根据ID获取入退住检查项目清单信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CheckInoutChecklistEntity task = checkInoutChecklistService.get(CheckInoutChecklistEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取入退住检查项目清单信息为空");
		}
		CheckInoutChecklistPage page = new CheckInoutChecklistPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from CheckListTypeEntity where 1 = 1 AND cHECKOUT_LIST_ID = ? ";
			List<CheckListTypeEntity> checkListTypeOldList = this.checkInoutChecklistService.findHql(hql0,id0);
    		page.setCheckListTypeList(checkListTypeOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建入退住检查项目清单")
	public ResponseMessage<?> create(@ApiParam(name="入退住检查项目清单对象")@RequestBody CheckInoutChecklistPage checkInoutChecklistPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CheckInoutChecklistPage>> failures = validator.validate(checkInoutChecklistPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckListTypeEntity> checkListTypeList =  checkInoutChecklistPage.getCheckListTypeList();
		
		CheckInoutChecklistEntity checkInoutChecklist = new CheckInoutChecklistEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(checkInoutChecklistPage,checkInoutChecklist);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存入退住检查项目清单失败");
        }
		checkInoutChecklistService.addMain(checkInoutChecklist, checkListTypeList);

		return Result.success(checkInoutChecklist);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新入退住检查项目清单",notes="更新入退住检查项目清单")
	public ResponseMessage<?> update(@RequestBody CheckInoutChecklistPage checkInoutChecklistPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CheckInoutChecklistPage>> failures = validator.validate(checkInoutChecklistPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckListTypeEntity> checkListTypeList =  checkInoutChecklistPage.getCheckListTypeList();
		
		CheckInoutChecklistEntity checkInoutChecklist = new CheckInoutChecklistEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(checkInoutChecklistPage,checkInoutChecklist);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("入退住检查项目清单更新失败");
        }
		checkInoutChecklistService.updateMain(checkInoutChecklist, checkListTypeList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除入退住检查项目清单")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CheckInoutChecklistEntity checkInoutChecklist = checkInoutChecklistService.get(CheckInoutChecklistEntity.class, id);
			checkInoutChecklistService.delMain(checkInoutChecklist);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("入退住检查项目清单删除失败");
		}

		return Result.success();
	}
	/**
	 * 获取文件附件信息
	 * 
	 * @param id checkInoutChecklist主键id
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
