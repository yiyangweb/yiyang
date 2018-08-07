package com.buss.base.building.controller;
import com.buss.base.building.dao.BuildingMinidaoDao;
import com.buss.base.building.entity.BaseBuildingEntity;
import com.buss.base.building.service.BaseBuildingServiceI;
import com.buss.base.building.page.BaseBuildingPage;
import com.buss.base.building.entity.BaseBuildingStoreyEntity;
import com.buss.base.building.entity.BaseBuildingRoomTypeEntity;

import java.util.*;
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
 * @Description: 建筑物信息
 * @author onlineGenerator
 * @date 2018-07-02 13:31:39
 * @version V1.0   
 *
 */
@Api(value="BaseBuilding",description="建筑物信息",tags="baseBuildingController")
@Controller
@RequestMapping("/baseBuildingController")
public class BaseBuildingController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseBuildingController.class);

	@Autowired
	private BaseBuildingServiceI baseBuildingService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private BuildingMinidaoDao buildingMinidaoDao;

	/**
	 * 建筑物信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/base/building/baseBuildingList");
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
	public void datagrid(BaseBuildingEntity baseBuilding,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BaseBuildingEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baseBuilding);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.baseBuildingService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除建筑物信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BaseBuildingEntity baseBuilding, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		baseBuilding = systemService.getEntity(BaseBuildingEntity.class, baseBuilding.getId());
		String message = "建筑物信息删除成功";
		try{
			baseBuildingService.delMain(baseBuilding);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "建筑物信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除建筑物信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "建筑物信息删除成功";
		try{
			for(String id:ids.split(",")){
				BaseBuildingEntity baseBuilding = systemService.getEntity(BaseBuildingEntity.class,
				id
				);
				baseBuildingService.delMain(baseBuilding);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "建筑物信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加建筑物信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BaseBuildingEntity baseBuilding,BaseBuildingPage baseBuildingPage, HttpServletRequest request) {
		List<BaseBuildingStoreyEntity> baseBuildingStoreyList =  baseBuildingPage.getBaseBuildingStoreyList();
		List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList =  baseBuildingPage.getBaseBuildingRoomTypeList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			baseBuildingService.addMain(baseBuilding, baseBuildingStoreyList,baseBuildingRoomTypeList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "建筑物信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新建筑物信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BaseBuildingEntity baseBuilding,BaseBuildingPage baseBuildingPage, HttpServletRequest request) {
		List<BaseBuildingStoreyEntity> baseBuildingStoreyList =  baseBuildingPage.getBaseBuildingStoreyList();
		List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList =  baseBuildingPage.getBaseBuildingRoomTypeList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			baseBuildingService.updateMain(baseBuilding, baseBuildingStoreyList,baseBuildingRoomTypeList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新建筑物信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 建筑物信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BaseBuildingEntity baseBuilding, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseBuilding.getId())) {
			baseBuilding = baseBuildingService.getEntity(BaseBuildingEntity.class, baseBuilding.getId());
			req.setAttribute("baseBuildingPage", baseBuilding);
		}else{
			BillNumbers billNum = new BillNumbers();
			baseBuilding.setNo(billNum.commonNumber("BB0"));
			req.setAttribute("baseBuildingPage", baseBuilding);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/base/building/baseBuilding-add");

	}
	
	/**
	 * 建筑物信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BaseBuildingEntity baseBuilding, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseBuilding.getId())) {
			baseBuilding = baseBuildingService.getEntity(BaseBuildingEntity.class, baseBuilding.getId());
			req.setAttribute("baseBuildingPage", baseBuilding);
		}
		return new ModelAndView("com/buss/base/building/baseBuilding-update");
	}
	
	
	/**
	 * 加载明细列表[建筑物楼层信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "baseBuildingStoreyList")
	public ModelAndView baseBuildingStoreyList(BaseBuildingEntity baseBuilding, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = baseBuilding.getId();
		//===================================================================================
		//查询-建筑物楼层信息
	    String hql0 = "from BaseBuildingStoreyEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    try{
	    	List<BaseBuildingStoreyEntity> baseBuildingStoreyEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("baseBuildingStoreyList", baseBuildingStoreyEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/base/building/baseBuildingStoreyList");
	}
	/**
	 * 加载明细列表[建筑物房间类型]
	 * 
	 * @return
	 */
	@RequestMapping(params = "baseBuildingRoomTypeList")
	public ModelAndView baseBuildingRoomTypeList(BaseBuildingEntity baseBuilding, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = baseBuilding.getId();
		//===================================================================================
		//查询-建筑物房间类型
	    String hql1 = "from BaseBuildingRoomTypeEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    try{
	    	List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("baseBuildingRoomTypeList", baseBuildingRoomTypeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/base/building/baseBuildingRoomTypeList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(BaseBuildingEntity baseBuilding,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(BaseBuildingEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baseBuilding);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BaseBuildingEntity> list=this.baseBuildingService.getListByCriteriaQuery(cq, false);
    	List<BaseBuildingPage> pageList=new ArrayList<BaseBuildingPage>();
        if(list!=null&&list.size()>0){
        	for(BaseBuildingEntity entity:list){
        		try{
        		BaseBuildingPage page=new BaseBuildingPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BaseBuildingStoreyEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
        	        List<BaseBuildingStoreyEntity> baseBuildingStoreyEntityList = systemService.findHql(hql0,id0);
            		page.setBaseBuildingStoreyList(baseBuildingStoreyEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from BaseBuildingRoomTypeEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
        	        List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeEntityList = systemService.findHql(hql1,id1);
            		page.setBaseBuildingRoomTypeList(baseBuildingRoomTypeEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"建筑物信息");
        map.put(NormalExcelConstants.CLASS,BaseBuildingPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("建筑物信息列表", "导出人:Jeecg",
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
				List<BaseBuildingPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BaseBuildingPage.class, params);
				BaseBuildingEntity entity1=null;
				for (BaseBuildingPage page : list) {
					entity1=new BaseBuildingEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            baseBuildingService.addMain(entity1, page.getBaseBuildingStoreyList(),page.getBaseBuildingRoomTypeList());
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
		map.put(NormalExcelConstants.FILE_NAME,"建筑物信息");
		map.put(NormalExcelConstants.CLASS,BaseBuildingPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("建筑物信息列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "baseBuildingController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="建筑物信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BaseBuildingPage>> list() {
		List<BaseBuildingEntity> list= baseBuildingService.getList(BaseBuildingEntity.class);
    	List<BaseBuildingPage> pageList=new ArrayList<BaseBuildingPage>();
        if(list!=null&&list.size()>0){
        	for(BaseBuildingEntity entity:list){
        		try{
        			BaseBuildingPage page=new BaseBuildingPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from BaseBuildingStoreyEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    			List<BaseBuildingStoreyEntity> baseBuildingStoreyOldList = this.baseBuildingService.findHql(hql0,id0);
            		page.setBaseBuildingStoreyList(baseBuildingStoreyOldList);
				     String hql1 = "from BaseBuildingRoomTypeEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    			List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeOldList = this.baseBuildingService.findHql(hql1,id1);
            		page.setBaseBuildingRoomTypeList(baseBuildingRoomTypeOldList);
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
	@ApiOperation(value="根据ID获取建筑物信息信息",notes="根据ID获取建筑物信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BaseBuildingEntity task = baseBuildingService.get(BaseBuildingEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取建筑物信息信息为空");
		}
		BaseBuildingPage page = new BaseBuildingPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from BaseBuildingStoreyEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
			List<BaseBuildingStoreyEntity> baseBuildingStoreyOldList = this.baseBuildingService.findHql(hql0,id0);
    		page.setBaseBuildingStoreyList(baseBuildingStoreyOldList);
		    String hql1 = "from BaseBuildingRoomTypeEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
			List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeOldList = this.baseBuildingService.findHql(hql1,id1);
    		page.setBaseBuildingRoomTypeList(baseBuildingRoomTypeOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建建筑物信息")
	public ResponseMessage<?> create(@ApiParam(name="建筑物信息对象")@RequestBody BaseBuildingPage baseBuildingPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaseBuildingPage>> failures = validator.validate(baseBuildingPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BaseBuildingStoreyEntity> baseBuildingStoreyList =  baseBuildingPage.getBaseBuildingStoreyList();
		List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList =  baseBuildingPage.getBaseBuildingRoomTypeList();
		
		BaseBuildingEntity baseBuilding = new BaseBuildingEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(baseBuildingPage,baseBuilding);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存建筑物信息失败");
        }
		baseBuildingService.addMain(baseBuilding, baseBuildingStoreyList,baseBuildingRoomTypeList);

		return Result.success(baseBuilding);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新建筑物信息",notes="更新建筑物信息")
	public ResponseMessage<?> update(@RequestBody BaseBuildingPage baseBuildingPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaseBuildingPage>> failures = validator.validate(baseBuildingPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BaseBuildingStoreyEntity> baseBuildingStoreyList =  baseBuildingPage.getBaseBuildingStoreyList();
		List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList =  baseBuildingPage.getBaseBuildingRoomTypeList();
		
		BaseBuildingEntity baseBuilding = new BaseBuildingEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(baseBuildingPage,baseBuilding);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("建筑物信息更新失败");
        }
		baseBuildingService.updateMain(baseBuilding, baseBuildingStoreyList,baseBuildingRoomTypeList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除建筑物信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BaseBuildingEntity baseBuilding = baseBuildingService.get(BaseBuildingEntity.class, id);
			baseBuildingService.delMain(baseBuilding);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("建筑物信息删除失败");
		}

		return Result.success();
	}

	/**
	 *下拉联动数据---楼栋和楼层联动
	 */
	@RequestMapping(params="regionSelect",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> buildingselect(HttpServletRequest req) {
		logger.info("----楼栋和楼层联动-----");
		String building_id=req.getParameter("building_id");
		String searchvalue=req.getParameter("searchvalue");
		if(building_id != "" && building_id != null) {
			if(searchvalue.equals("story")){ //根据楼栋id查找楼层
				//logger.info("----根据楼栋id查找楼层-----");
				return buildingMinidaoDao.getStoreyList(building_id);
			} else if(searchvalue.equals("room")){ //根据楼栋id查找房间
				//logger.info("----根据楼栋id查找房间-----");
				return buildingMinidaoDao.getRoomList(building_id);
			} else if(searchvalue.equals("roomtype")){ //根据楼栋id查找房间类型
				//logger.info("----根据楼栋id查找房间类型-----");
				return buildingMinidaoDao.getRoomTypeList(building_id);
			}else{
				//logger.info("----空查询-----");
				return new ArrayList<Map<String, String>>();
			}
		}else{
			//logger.info("----查找楼栋-----");
			return buildingMinidaoDao.getBuildinglist();
		}
	}

}
