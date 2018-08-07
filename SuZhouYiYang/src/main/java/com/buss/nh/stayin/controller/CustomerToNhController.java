package com.buss.nh.stayin.controller;
import com.buss.nh.stayin.entity.CustomerToNhEntity;
import com.buss.nh.stayin.service.CustomerToNhServiceI;
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

/**   
 * @Title: Controller  
 * @Description: 护理院入住
 * @author onlineGenerator
 * @date 2018-07-14 22:12:12
 * @version V1.0   
 *
 */
@Api(value="CustomerToNh",description="护理院入住",tags="customerToNhController")
@Controller
@RequestMapping("/customerToNhController")
public class CustomerToNhController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerToNhController.class);

	@Autowired
	private CustomerToNhServiceI customerToNhService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 护理院入住列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/nh/stayin/customerToNhList");
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
	public void datagrid(CustomerToNhEntity customerToNh,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerToNhEntity.class, dataGrid);
		//查询条件组装器
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);

		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerToNh, request.getParameterMap());
		try{
		//自定义追加查询条件

			String query_customerName = request.getParameter("customerName");
			String query_roomName = request.getParameter("roomName");
			String query_sex = request.getParameter("sex");
			String query_nurseLevel = request.getParameter("nurseLevel");
			//System.out.println(query_sex+","+query_nurseLevel);

			if(StringUtil.isNotEmpty(query_customerName)){
				cq.add(Restrictions.sqlRestriction("customer_name like '%"+query_customerName+"%'"));
			}
			if(StringUtil.isNotEmpty(query_roomName)){
				cq.add(Restrictions.sqlRestriction("room_name like '%" +query_roomName+"%'"));
			}
			if(StringUtil.isNotEmpty(query_sex)){
				cq.add(Restrictions.sqlRestriction("sex = '" +query_sex+"'"));
			}
			if(StringUtil.isNotEmpty(query_nurseLevel)){
				cq.add(Restrictions.sqlRestriction("nurse_level = '" +query_nurseLevel+"'"));
			}
			cq.add(Restrictions.sqlRestriction("sys_company_Code = '" +cmpCode+"'"));
			//System.out.println(cmpCode);



		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerToNhService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除护理院入住
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerToNhEntity customerToNh, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		customerToNh = systemService.getEntity(CustomerToNhEntity.class, customerToNh.getId());
		message = "护理院入住删除成功";
		try{
			customerToNhService.delete(customerToNh);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "护理院入住删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除护理院入住
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "护理院入住删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerToNhEntity customerToNh = systemService.getEntity(CustomerToNhEntity.class, 
				id
				);
				customerToNhService.delete(customerToNh);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "护理院入住删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加护理院入住
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerToNhEntity customerToNh, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "护理院入住添加成功";
		customerToNh.setCrStatus("1");
		try{
			customerToNhService.save(customerToNh);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "护理院入住添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新护理院入住
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerToNhEntity customerToNh, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "护理院入住更新成功";
		CustomerToNhEntity t = customerToNhService.get(CustomerToNhEntity.class, customerToNh.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(customerToNh, t);
			customerToNhService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "护理院入住更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[提交]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doIn_sbt")
	@ResponseBody
	public AjaxJson doIn_sbt(CustomerToNhEntity customerToNh, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交成功";
		CustomerToNhEntity t = customerToNhService.get(CustomerToNhEntity.class, customerToNh.getId());
		try{
			customerToNhService.doIn_sbtBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-[确认入住]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doIn_commit")
	@ResponseBody
	public AjaxJson doIn_commit(CustomerToNhEntity customerToNh, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "确认入住成功";
		CustomerToNhEntity t = customerToNhService.get(CustomerToNhEntity.class, customerToNh.getId());
		try{
			customerToNhService.doIn_commitBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认入住失败";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 护理院入住新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerToNhEntity customerToNh, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerToNh.getId())) {
			customerToNh = customerToNhService.getEntity(CustomerToNhEntity.class, customerToNh.getId());
			req.setAttribute("customerToNhPage", customerToNh);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerToNh.setNo(billNum.commonNumber("NI0"));
			req.setAttribute("customerToNhPage", customerToNh);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/nh/stayin/customerToNh-add");
	}
	/**
	 * 护理院入住编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerToNhEntity customerToNh, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerToNh.getId())) {
			customerToNh = customerToNhService.getEntity(CustomerToNhEntity.class, customerToNh.getId());
			req.setAttribute("customerToNhPage", customerToNh);
		}
		return new ModelAndView("com/buss/nh/stayin/customerToNh-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","customerToNhController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(CustomerToNhEntity customerToNh,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(CustomerToNhEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerToNh, request.getParameterMap());
		List<CustomerToNhEntity> customerToNhs = this.customerToNhService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"护理院入住");
		modelMap.put(NormalExcelConstants.CLASS,CustomerToNhEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("护理院入住列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,customerToNhs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(CustomerToNhEntity customerToNh,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"护理院入住");
    	modelMap.put(NormalExcelConstants.CLASS,CustomerToNhEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("护理院入住列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<CustomerToNhEntity> listCustomerToNhEntitys = ExcelImportUtil.importExcel(file.getInputStream(),CustomerToNhEntity.class,params);
				for (CustomerToNhEntity customerToNh : listCustomerToNhEntitys) {
					customerToNhService.save(customerToNh);
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
	@ApiOperation(value="护理院入住列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerToNhEntity>> list() {
		List<CustomerToNhEntity> listCustomerToNhs=customerToNhService.getList(CustomerToNhEntity.class);
		return Result.success(listCustomerToNhs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取护理院入住信息",notes="根据ID获取护理院入住信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerToNhEntity task = customerToNhService.get(CustomerToNhEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取护理院入住信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建护理院入住")
	public ResponseMessage<?> create(@ApiParam(name="护理院入住对象")@RequestBody CustomerToNhEntity customerToNh, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerToNhEntity>> failures = validator.validate(customerToNh);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			customerToNhService.save(customerToNh);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("护理院入住信息保存失败");
		}
		return Result.success(customerToNh);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新护理院入住",notes="更新护理院入住")
	public ResponseMessage<?> update(@ApiParam(name="护理院入住对象")@RequestBody CustomerToNhEntity customerToNh) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerToNhEntity>> failures = validator.validate(customerToNh);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			customerToNhService.saveOrUpdate(customerToNh);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新护理院入住信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新护理院入住信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除护理院入住")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			customerToNhService.deleteEntityById(CustomerToNhEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("护理院入住删除失败");
		}

		return Result.success();
	}
}
