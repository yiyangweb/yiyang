package com.buss.sale.service.controller;
import com.buss.sale.service.entity.ValueAddedServiceEntity;
import com.buss.sale.service.service.ValueAddedServiceServiceI;
import com.buss.sale.service.page.ValueAddedServicePage;
import com.buss.sale.service.entity.ChargeListServiceEntity;
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
 * @Description: 增值服务
 * @author onlineGenerator
 * @date 2018-07-15 14:35:47
 * @version V1.0   
 *
 */
@Api(value="ValueAddedService",description="增值服务",tags="valueAddedServiceController")
@Controller
@RequestMapping("/valueAddedServiceController")
public class ValueAddedServiceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ValueAddedServiceController.class);

	@Autowired
	private ValueAddedServiceServiceI valueAddedServiceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 增值服务列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list") //公寓
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("type", "1");
		request.setAttribute("dataurl", "valueAddedServiceController.do?datagrid");
		return new ModelAndView("com/buss/sale/service/valueAddedServiceList");
	}
	@RequestMapping(params = "listnh") //护理院
	public ModelAndView listnh(HttpServletRequest request) {
		request.setAttribute("type", "2");
		request.setAttribute("dataurl", "valueAddedServiceController.do?datagridnh");
		return new ModelAndView("com/buss/sale/service/valueAddedServiceList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid") //查询公寓
	public void datagrid(ValueAddedServiceEntity valueAddedService,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ValueAddedServiceEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, valueAddedService);
		try{
			//自定义追加查询条件
			String query_serviceId = request.getParameter("serviceId");
			String query_customerName = request.getParameter("customerName");
			String query_customerRoomName = request.getParameter("customerRoomName");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_serviceId)){
				cq.like("serviceId","%"+query_serviceId+"%");
			}
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			if(StringUtil.isNotEmpty(query_customerRoomName)){
				cq.like("customerRoomName","%"+query_customerRoomName+"%");
			}
			cq.add(Restrictions.sqlRestriction("belong_to = '1'"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.valueAddedServiceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagridnh") //查询公寓
	public void datagridnh(ValueAddedServiceEntity valueAddedService,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ValueAddedServiceEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, valueAddedService);
		try{
			//自定义追加查询条件
			String query_serviceId = request.getParameter("serviceId");
			String query_customerName = request.getParameter("customerName");
			String query_customerRoomName = request.getParameter("customerRoomName");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_serviceId)){
				cq.like("serviceId","%"+query_serviceId+"%");
			}
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.like("customerName","%"+query_customerName+"%");
			}
			if(StringUtil.isNotEmpty(query_customerRoomName)){
				cq.like("customerRoomName","%"+query_customerRoomName+"%");
			}
			cq.add(Restrictions.sqlRestriction("belong_to = '2'"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.valueAddedServiceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除增值服务
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ValueAddedServiceEntity valueAddedService, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		valueAddedService = systemService.getEntity(ValueAddedServiceEntity.class, valueAddedService.getId());
		String message = "增值服务删除成功";
		try{
			valueAddedServiceService.delMain(valueAddedService);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "增值服务删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除增值服务
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "增值服务删除成功";
		try{
			for(String id:ids.split(",")){
				ValueAddedServiceEntity valueAddedService = systemService.getEntity(ValueAddedServiceEntity.class,
				id
				);
				valueAddedServiceService.delMain(valueAddedService);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "增值服务删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加增值服务
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ValueAddedServiceEntity valueAddedService,ValueAddedServicePage valueAddedServicePage, HttpServletRequest request) {
		List<ChargeListServiceEntity> chargeListServiceList =  valueAddedServicePage.getChargeListServiceList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			valueAddedServiceService.addMain(valueAddedService, chargeListServiceList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "增值服务添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新增值服务
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ValueAddedServiceEntity valueAddedService,ValueAddedServicePage valueAddedServicePage, HttpServletRequest request) {
		List<ChargeListServiceEntity> chargeListServiceList =  valueAddedServicePage.getChargeListServiceList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			valueAddedServiceService.updateMain(valueAddedService, chargeListServiceList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新增值服务失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 增值服务新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ValueAddedServiceEntity valueAddedService, HttpServletRequest req) {
		String type = req.getParameter("type");
		if (StringUtil.isNotEmpty(valueAddedService.getId())) {
			valueAddedService = valueAddedServiceService.getEntity(ValueAddedServiceEntity.class, valueAddedService.getId());
			req.setAttribute("valueAddedServicePage", valueAddedService);
		}else{
			BillNumbers billNum = new BillNumbers();
			valueAddedService.setServiceId(billNum.commonNumber("AS0"));
			req.setAttribute("valueAddedServicePage", valueAddedService);
		}
		req.setAttribute("type", type);
		return new ModelAndView("com/buss/sale/service/valueAddedService-add");
	}
	
	/**
	 * 增值服务编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ValueAddedServiceEntity valueAddedService, HttpServletRequest req) {
		String type = req.getParameter("type");
		if (StringUtil.isNotEmpty(valueAddedService.getId())) {
			valueAddedService = valueAddedServiceService.getEntity(ValueAddedServiceEntity.class, valueAddedService.getId());
			req.setAttribute("valueAddedServicePage", valueAddedService);
		}
		req.setAttribute("type", type);
		return new ModelAndView("com/buss/sale/service/valueAddedService-update");
	}
	
	
	/**
	 * 加载明细列表[收费列表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "chargeListServiceList")
	public ModelAndView chargeListServiceList(ValueAddedServiceEntity valueAddedService, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = valueAddedService.getId();
		//===================================================================================
		//查询-收费列表
	    String hql0 = "from ChargeListServiceEntity where 1 = 1 AND sERVICE_ID = ? ";
	    try{
	    	List<ChargeListServiceEntity> chargeListServiceEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("chargeListServiceList", chargeListServiceEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/service/chargeListServiceList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(ValueAddedServiceEntity valueAddedService,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(ValueAddedServiceEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, valueAddedService);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<ValueAddedServiceEntity> list=this.valueAddedServiceService.getListByCriteriaQuery(cq, false);
    	List<ValueAddedServicePage> pageList=new ArrayList<ValueAddedServicePage>();
        if(list!=null&&list.size()>0){
        	for(ValueAddedServiceEntity entity:list){
        		try{
        		ValueAddedServicePage page=new ValueAddedServicePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ChargeListServiceEntity where 1 = 1 AND sERVICE_ID = ? ";
        	        List<ChargeListServiceEntity> chargeListServiceEntityList = systemService.findHql(hql0,id0);
            		page.setChargeListServiceList(chargeListServiceEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"增值服务");
        map.put(NormalExcelConstants.CLASS,ValueAddedServicePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("增值服务列表", "导出人:Jeecg",
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
				List<ValueAddedServicePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), ValueAddedServicePage.class, params);
				ValueAddedServiceEntity entity1=null;
				for (ValueAddedServicePage page : list) {
					entity1=new ValueAddedServiceEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            valueAddedServiceService.addMain(entity1, page.getChargeListServiceList());
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
		map.put(NormalExcelConstants.FILE_NAME,"增值服务");
		map.put(NormalExcelConstants.CLASS,ValueAddedServicePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("增值服务列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "valueAddedServiceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCommit")
	@ResponseBody
	public AjaxJson doCommit(ValueAddedServiceEntity valueAddedService, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		ValueAddedServiceEntity t = valueAddedServiceService.get(ValueAddedServiceEntity.class, valueAddedService.getId());
		try{
			valueAddedServiceService.doCommitSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-完成
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doComplete")
	@ResponseBody
	public AjaxJson doComplete(ValueAddedServiceEntity valueAddedService, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "完成成功";
		ValueAddedServiceEntity t = valueAddedServiceService.get(ValueAddedServiceEntity.class, valueAddedService.getId());
		try{
			valueAddedServiceService.doCompleteSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "完成失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="增值服务列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<ValueAddedServicePage>> list() {
		List<ValueAddedServiceEntity> list= valueAddedServiceService.getList(ValueAddedServiceEntity.class);
    	List<ValueAddedServicePage> pageList=new ArrayList<ValueAddedServicePage>();
        if(list!=null&&list.size()>0){
        	for(ValueAddedServiceEntity entity:list){
        		try{
        			ValueAddedServicePage page=new ValueAddedServicePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ChargeListServiceEntity where 1 = 1 AND sERVICE_ID = ? ";
	    			List<ChargeListServiceEntity> chargeListServiceOldList = this.valueAddedServiceService.findHql(hql0,id0);
            		page.setChargeListServiceList(chargeListServiceOldList);
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
	@ApiOperation(value="根据ID获取增值服务信息",notes="根据ID获取增值服务信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		ValueAddedServiceEntity task = valueAddedServiceService.get(ValueAddedServiceEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取增值服务信息为空");
		}
		ValueAddedServicePage page = new ValueAddedServicePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ChargeListServiceEntity where 1 = 1 AND sERVICE_ID = ? ";
			List<ChargeListServiceEntity> chargeListServiceOldList = this.valueAddedServiceService.findHql(hql0,id0);
    		page.setChargeListServiceList(chargeListServiceOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建增值服务")
	public ResponseMessage<?> create(@ApiParam(name="增值服务对象")@RequestBody ValueAddedServicePage valueAddedServicePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ValueAddedServicePage>> failures = validator.validate(valueAddedServicePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ChargeListServiceEntity> chargeListServiceList =  valueAddedServicePage.getChargeListServiceList();
		
		ValueAddedServiceEntity valueAddedService = new ValueAddedServiceEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(valueAddedServicePage,valueAddedService);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存增值服务失败");
        }
		valueAddedServiceService.addMain(valueAddedService, chargeListServiceList);

		return Result.success(valueAddedService);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新增值服务",notes="更新增值服务")
	public ResponseMessage<?> update(@RequestBody ValueAddedServicePage valueAddedServicePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<ValueAddedServicePage>> failures = validator.validate(valueAddedServicePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ChargeListServiceEntity> chargeListServiceList =  valueAddedServicePage.getChargeListServiceList();
		
		ValueAddedServiceEntity valueAddedService = new ValueAddedServiceEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(valueAddedServicePage,valueAddedService);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("增值服务更新失败");
        }
		valueAddedServiceService.updateMain(valueAddedService, chargeListServiceList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除增值服务")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			ValueAddedServiceEntity valueAddedService = valueAddedServiceService.get(ValueAddedServiceEntity.class, id);
			valueAddedServiceService.delMain(valueAddedService);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("增值服务删除失败");
		}

		return Result.success();
	}
}
