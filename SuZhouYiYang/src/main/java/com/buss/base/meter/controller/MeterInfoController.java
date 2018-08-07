package com.buss.base.meter.controller;
import com.buss.base.meter.entity.MeterInfoEntity;
import com.buss.base.meter.service.MeterInfoServiceI;
import com.buss.base.meter.page.MeterInfoPage;
import com.buss.base.meter.entity.MeterReadingRecordEntity;
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
 * @Description: 水电基础数据
 * @author onlineGenerator
 * @date 2018-07-02 16:41:17
 * @version V1.0   
 *
 */
@Api(value="MeterInfo",description="水电基础数据",tags="meterInfoController")
@Controller
@RequestMapping("/meterInfoController")
public class MeterInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MeterInfoController.class);

	@Autowired
	private MeterInfoServiceI meterInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 水电基础数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/base/meter/meterInfoList");
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
	public void datagrid(MeterInfoEntity meterInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(MeterInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, meterInfo);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.meterInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除水电基础数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(MeterInfoEntity meterInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		meterInfo = systemService.getEntity(MeterInfoEntity.class, meterInfo.getId());
		String message = "水电基础数据删除成功";
		try{
			meterInfoService.delMain(meterInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "水电基础数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除水电基础数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "水电基础数据删除成功";
		try{
			for(String id:ids.split(",")){
				MeterInfoEntity meterInfo = systemService.getEntity(MeterInfoEntity.class,
				id
				);
				meterInfoService.delMain(meterInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "水电基础数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加水电基础数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(MeterInfoEntity meterInfo,MeterInfoPage meterInfoPage, HttpServletRequest request) {
		List<MeterReadingRecordEntity> meterReadingRecordList =  meterInfoPage.getMeterReadingRecordList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			meterInfoService.addMain(meterInfo, meterReadingRecordList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "水电基础数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新水电基础数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(MeterInfoEntity meterInfo,MeterInfoPage meterInfoPage, HttpServletRequest request) {
		List<MeterReadingRecordEntity> meterReadingRecordList =  meterInfoPage.getMeterReadingRecordList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			meterInfoService.updateMain(meterInfo, meterReadingRecordList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新水电基础数据失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 水电基础数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(MeterInfoEntity meterInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(meterInfo.getId())) {
			meterInfo = meterInfoService.getEntity(MeterInfoEntity.class, meterInfo.getId());
			req.setAttribute("meterInfoPage", meterInfo);
		}else{
			BillNumbers billNum = new BillNumbers();
			meterInfo.setNo(billNum.commonNumber("MI0"));
			req.setAttribute("meterInfoPage", meterInfo);
		}
		return new ModelAndView("com/buss/base/meter/meterInfo-add");
	}
	
	/**
	 * 水电基础数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(MeterInfoEntity meterInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(meterInfo.getId())) {
			meterInfo = meterInfoService.getEntity(MeterInfoEntity.class, meterInfo.getId());
			req.setAttribute("meterInfoPage", meterInfo);
		}
		return new ModelAndView("com/buss/base/meter/meterInfo-update");
	}
	
	
	/**
	 * 加载明细列表[水电抄表记录]
	 * 
	 * @return
	 */
	@RequestMapping(params = "meterReadingRecordList")
	public ModelAndView meterReadingRecordList(MeterInfoEntity meterInfo, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = meterInfo.getId();
		//===================================================================================
		//查询-水电抄表记录
	    String hql0 = "from MeterReadingRecordEntity where 1 = 1 AND mETER_ID = ? ";
	    try{
	    	List<MeterReadingRecordEntity> meterReadingRecordEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("meterReadingRecordList", meterReadingRecordEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/base/meter/meterReadingRecordList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(MeterInfoEntity meterInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(MeterInfoEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, meterInfo);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<MeterInfoEntity> list=this.meterInfoService.getListByCriteriaQuery(cq, false);
    	List<MeterInfoPage> pageList=new ArrayList<MeterInfoPage>();
        if(list!=null&&list.size()>0){
        	for(MeterInfoEntity entity:list){
        		try{
        		MeterInfoPage page=new MeterInfoPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MeterReadingRecordEntity where 1 = 1 AND mETER_ID = ? ";
        	        List<MeterReadingRecordEntity> meterReadingRecordEntityList = systemService.findHql(hql0,id0);
            		page.setMeterReadingRecordList(meterReadingRecordEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"水电基础数据");
        map.put(NormalExcelConstants.CLASS,MeterInfoPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("水电基础数据列表", "导出人:Jeecg",
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
				List<MeterInfoPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), MeterInfoPage.class, params);
				MeterInfoEntity entity1=null;
				for (MeterInfoPage page : list) {
					entity1=new MeterInfoEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            meterInfoService.addMain(entity1, page.getMeterReadingRecordList());
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
		map.put(NormalExcelConstants.FILE_NAME,"水电基础数据");
		map.put(NormalExcelConstants.CLASS,MeterInfoPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("水电基础数据列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "meterInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="水电基础数据列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<MeterInfoPage>> list() {
		List<MeterInfoEntity> list= meterInfoService.getList(MeterInfoEntity.class);
    	List<MeterInfoPage> pageList=new ArrayList<MeterInfoPage>();
        if(list!=null&&list.size()>0){
        	for(MeterInfoEntity entity:list){
        		try{
        			MeterInfoPage page=new MeterInfoPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from MeterReadingRecordEntity where 1 = 1 AND mETER_ID = ? ";
	    			List<MeterReadingRecordEntity> meterReadingRecordOldList = this.meterInfoService.findHql(hql0,id0);
            		page.setMeterReadingRecordList(meterReadingRecordOldList);
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
	@ApiOperation(value="根据ID获取水电基础数据信息",notes="根据ID获取水电基础数据信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		MeterInfoEntity task = meterInfoService.get(MeterInfoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取水电基础数据信息为空");
		}
		MeterInfoPage page = new MeterInfoPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from MeterReadingRecordEntity where 1 = 1 AND mETER_ID = ? ";
			List<MeterReadingRecordEntity> meterReadingRecordOldList = this.meterInfoService.findHql(hql0,id0);
    		page.setMeterReadingRecordList(meterReadingRecordOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建水电基础数据")
	public ResponseMessage<?> create(@ApiParam(name="水电基础数据对象")@RequestBody MeterInfoPage meterInfoPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MeterInfoPage>> failures = validator.validate(meterInfoPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MeterReadingRecordEntity> meterReadingRecordList =  meterInfoPage.getMeterReadingRecordList();
		
		MeterInfoEntity meterInfo = new MeterInfoEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(meterInfoPage,meterInfo);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存水电基础数据失败");
        }
		meterInfoService.addMain(meterInfo, meterReadingRecordList);

		return Result.success(meterInfo);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新水电基础数据",notes="更新水电基础数据")
	public ResponseMessage<?> update(@RequestBody MeterInfoPage meterInfoPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<MeterInfoPage>> failures = validator.validate(meterInfoPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MeterReadingRecordEntity> meterReadingRecordList =  meterInfoPage.getMeterReadingRecordList();
		
		MeterInfoEntity meterInfo = new MeterInfoEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(meterInfoPage,meterInfo);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("水电基础数据更新失败");
        }
		meterInfoService.updateMain(meterInfo, meterReadingRecordList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除水电基础数据")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			MeterInfoEntity meterInfo = meterInfoService.get(MeterInfoEntity.class, id);
			meterInfoService.delMain(meterInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("水电基础数据删除失败");
		}

		return Result.success();
	}
}
