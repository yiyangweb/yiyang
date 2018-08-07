package com.buss.sale.visit.controller;
import com.buss.sale.visit.entity.MmVisitorRecordEntity;
import com.buss.sale.visit.service.MmVisitorRecordServiceI;
import com.buss.sale.visit.page.MmVisitorRecordPage;
import com.buss.sale.visit.entity.MmVisitorReturnEntity;
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
 * @Description: 来访者登记信息
 * @author onlineGenerator
 * @date 2018-07-10 14:01:18
 * @version V1.0   
 *
 */
@Api(value="MmVisitorRecord",description="来访者登记信息",tags="mmVisitorRecordController")
@Controller
@RequestMapping("/mmVisitorRecordController")
public class MmVisitorRecordController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MmVisitorRecordController.class);

	@Autowired
	private MmVisitorRecordServiceI mmVisitorRecordService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 来访者登记信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/sale/visit/mmVisitorRecordList");
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
	public void datagrid(MmVisitorRecordEntity mmVisitorRecord,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MmVisitorRecordEntity.class, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, mmVisitorRecord);
		try{
			//自定义追加查询条件
			String query_name = request.getParameter("customerName");
			String query_sex = request.getParameter("sex");
			String query_intentionLevel = request.getParameter("intentionLevel");
			cq.eq("sysCompanyCode",cmpCode);
			if(StringUtil.isNotEmpty(query_name)){
				cq.like("customerName","%"+query_name+"%");
			}
			if(StringUtil.isNotEmpty(query_sex)){
				cq.eq("sex",query_sex);
			}
			if(StringUtil.isNotEmpty(query_intentionLevel)){
				cq.eq("intentionLevel",query_intentionLevel);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.mmVisitorRecordService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除来访者登记信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		mmVisitorRecord = systemService.getEntity(MmVisitorRecordEntity.class, mmVisitorRecord.getId());
		String message = "来访者登记信息删除成功";
		try{
			mmVisitorRecordService.delMain(mmVisitorRecord);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "来访者登记信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除来访者登记信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "来访者登记信息删除成功";
		try{
			for(String id:ids.split(",")){
				MmVisitorRecordEntity mmVisitorRecord = systemService.getEntity(MmVisitorRecordEntity.class,
				id
				);
				mmVisitorRecordService.delMain(mmVisitorRecord);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "来访者登记信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加来访者登记信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MmVisitorRecordEntity mmVisitorRecord,MmVisitorRecordPage mmVisitorRecordPage, HttpServletRequest request) {
		List<MmVisitorReturnEntity> mmVisitorReturnList =  mmVisitorRecordPage.getMmVisitorReturnList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			mmVisitorRecordService.addMain(mmVisitorRecord, mmVisitorReturnList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "来访者登记信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新来访者登记信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MmVisitorRecordEntity mmVisitorRecord,MmVisitorRecordPage mmVisitorRecordPage, HttpServletRequest request) {
		List<MmVisitorReturnEntity> mmVisitorReturnList =  mmVisitorRecordPage.getMmVisitorReturnList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			mmVisitorRecordService.updateMain(mmVisitorRecord, mmVisitorReturnList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新来访者登记信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 来访者登记信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(mmVisitorRecord.getId())) {
			mmVisitorRecord = mmVisitorRecordService.getEntity(MmVisitorRecordEntity.class, mmVisitorRecord.getId());
			req.setAttribute("mmVisitorRecordPage", mmVisitorRecord);
		}else{
			BillNumbers billNum = new BillNumbers();
			mmVisitorRecord.setRecordNo(billNum.commonNumber("VR0"));
			req.setAttribute("mmVisitorRecordPage", mmVisitorRecord);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/sale/visit/mmVisitorRecord-add");
	}
	
	/**
	 * 来访者登记信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(mmVisitorRecord.getId())) {
			mmVisitorRecord = mmVisitorRecordService.getEntity(MmVisitorRecordEntity.class, mmVisitorRecord.getId());
			req.setAttribute("mmVisitorRecordPage", mmVisitorRecord);
		}
		return new ModelAndView("com/buss/sale/visit/mmVisitorRecord-update");
	}
	
	
	/**
	 * 加载明细列表[回访记录]
	 * 
	 * @return
	 */
	@RequestMapping(params = "mmVisitorReturnList")
	public ModelAndView mmVisitorReturnList(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = mmVisitorRecord.getId();
		//===================================================================================
		//查询-回访记录
	    String hql0 = "from MmVisitorReturnEntity where 1 = 1 AND rECORD_ID = ? ";
	    try{
	    	List<MmVisitorReturnEntity> mmVisitorReturnEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("mmVisitorReturnList", mmVisitorReturnEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/visit/mmVisitorReturnList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MmVisitorRecordEntity mmVisitorRecord,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MmVisitorRecordEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, mmVisitorRecord);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MmVisitorRecordEntity> list=this.mmVisitorRecordService.getListByCriteriaQuery(cq, false);
    	List<MmVisitorRecordPage> pageList=new ArrayList<MmVisitorRecordPage>();
        if(list!=null&&list.size()>0){
        	for(MmVisitorRecordEntity entity:list){
        		try{
        		MmVisitorRecordPage page=new MmVisitorRecordPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MmVisitorReturnEntity where 1 = 1 AND rECORD_ID = ? ";
        	        List<MmVisitorReturnEntity> mmVisitorReturnEntityList = systemService.findHql(hql0,id0);
            		page.setMmVisitorReturnList(mmVisitorReturnEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"来访者登记信息");
        map.put(NormalExcelConstants.CLASS,MmVisitorRecordPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("来访者登记信息列表", "导出人:Jeecg",
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
				List<MmVisitorRecordPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MmVisitorRecordPage.class, params);
				MmVisitorRecordEntity entity1=null;
				for (MmVisitorRecordPage page : list) {
					entity1=new MmVisitorRecordEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            mmVisitorRecordService.addMain(entity1, page.getMmVisitorReturnList());
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
		map.put(NormalExcelConstants.FILE_NAME,"来访者登记信息");
		map.put(NormalExcelConstants.CLASS,MmVisitorRecordPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("来访者登记信息列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "mmVisitorRecordController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-确认提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doVisitsbt")
	@ResponseBody
	public AjaxJson doVisitsbt(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "确认提交成功";
		MmVisitorRecordEntity t = mmVisitorRecordService.get(MmVisitorRecordEntity.class, mmVisitorRecord.getId());
		try{
			mmVisitorRecordService.doVisitsbtSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-确认入住
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doVisitput")
	@ResponseBody
	public AjaxJson doVisitput(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "确认入住成功";
		MmVisitorRecordEntity t = mmVisitorRecordService.get(MmVisitorRecordEntity.class, mmVisitorRecord.getId());
		try{
			mmVisitorRecordService.doVisitputSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认入住失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-确认放弃
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doVisitputout")
	@ResponseBody
	public AjaxJson doVisitputout(MmVisitorRecordEntity mmVisitorRecord, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "确认放弃成功";
		MmVisitorRecordEntity t = mmVisitorRecordService.get(MmVisitorRecordEntity.class, mmVisitorRecord.getId());
		try{
			mmVisitorRecordService.doVisitputoutSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认放弃失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="来访者登记信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MmVisitorRecordPage>> list() {
		List<MmVisitorRecordEntity> list= mmVisitorRecordService.getList(MmVisitorRecordEntity.class);
    	List<MmVisitorRecordPage> pageList=new ArrayList<MmVisitorRecordPage>();
        if(list!=null&&list.size()>0){
        	for(MmVisitorRecordEntity entity:list){
        		try{
        			MmVisitorRecordPage page=new MmVisitorRecordPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MmVisitorReturnEntity where 1 = 1 AND rECORD_ID = ? ";
	    			List<MmVisitorReturnEntity> mmVisitorReturnOldList = this.mmVisitorRecordService.findHql(hql0,id0);
            		page.setMmVisitorReturnList(mmVisitorReturnOldList);
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
	@ApiOperation(value="根据ID获取来访者登记信息信息",notes="根据ID获取来访者登记信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MmVisitorRecordEntity task = mmVisitorRecordService.get(MmVisitorRecordEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取来访者登记信息信息为空");
		}
		MmVisitorRecordPage page = new MmVisitorRecordPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MmVisitorReturnEntity where 1 = 1 AND rECORD_ID = ? ";
			List<MmVisitorReturnEntity> mmVisitorReturnOldList = this.mmVisitorRecordService.findHql(hql0,id0);
    		page.setMmVisitorReturnList(mmVisitorReturnOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建来访者登记信息")
	public ResponseMessage<?> create(@ApiParam(name="来访者登记信息对象")@RequestBody MmVisitorRecordPage mmVisitorRecordPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MmVisitorRecordPage>> failures = validator.validate(mmVisitorRecordPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MmVisitorReturnEntity> mmVisitorReturnList =  mmVisitorRecordPage.getMmVisitorReturnList();
		
		MmVisitorRecordEntity mmVisitorRecord = new MmVisitorRecordEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(mmVisitorRecordPage,mmVisitorRecord);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存来访者登记信息失败");
        }
		mmVisitorRecordService.addMain(mmVisitorRecord, mmVisitorReturnList);

		return Result.success(mmVisitorRecord);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新来访者登记信息",notes="更新来访者登记信息")
	public ResponseMessage<?> update(@RequestBody MmVisitorRecordPage mmVisitorRecordPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MmVisitorRecordPage>> failures = validator.validate(mmVisitorRecordPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MmVisitorReturnEntity> mmVisitorReturnList =  mmVisitorRecordPage.getMmVisitorReturnList();
		
		MmVisitorRecordEntity mmVisitorRecord = new MmVisitorRecordEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(mmVisitorRecordPage,mmVisitorRecord);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("来访者登记信息更新失败");
        }
		mmVisitorRecordService.updateMain(mmVisitorRecord, mmVisitorReturnList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除来访者登记信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MmVisitorRecordEntity mmVisitorRecord = mmVisitorRecordService.get(MmVisitorRecordEntity.class, id);
			mmVisitorRecordService.delMain(mmVisitorRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("来访者登记信息删除失败");
		}

		return Result.success();
	}
}
