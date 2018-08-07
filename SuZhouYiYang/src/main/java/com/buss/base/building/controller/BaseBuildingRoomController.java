package com.buss.base.building.controller;
import com.buss.base.building.dao.BuildingRoomMinidaoDao;
import com.buss.base.building.entity.BaseBuildingRoomEntity;
import com.buss.base.building.service.BaseBuildingRoomServiceI;
import com.buss.base.building.page.BaseBuildingRoomPage;
import com.buss.base.building.entity.BaseBuildingBedEntity;
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
 * @Description: 建筑物房间信息
 * @author onlineGenerator
 * @date 2018-05-23 15:38:15
 * @version V1.0   
 *
 */
@Api(value="BaseBuildingRoom",description="建筑物房间信息",tags="baseBuildingRoomController")
@Controller
@RequestMapping("/baseBuildingRoomController")
public class BaseBuildingRoomController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseBuildingRoomController.class);

	@Autowired
	private BaseBuildingRoomServiceI baseBuildingRoomService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private BuildingRoomMinidaoDao buildingRoomMinidaoDao;
	/**
	 * 建筑物房间信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/base/building/baseBuildingRoomList");
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
	public void datagrid(BaseBuildingRoomEntity baseBuildingRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BaseBuildingRoomEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baseBuildingRoom);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.baseBuildingRoomService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除建筑物房间信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BaseBuildingRoomEntity baseBuildingRoom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		baseBuildingRoom = systemService.getEntity(BaseBuildingRoomEntity.class, baseBuildingRoom.getId());
		String message = "建筑物房间信息删除成功";
		try{
			baseBuildingRoomService.delMain(baseBuildingRoom);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "建筑物房间信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除建筑物房间信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "建筑物房间信息删除成功";
		try{
			for(String id:ids.split(",")){
				BaseBuildingRoomEntity baseBuildingRoom = systemService.getEntity(BaseBuildingRoomEntity.class,
				id
				);
				baseBuildingRoomService.delMain(baseBuildingRoom);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "建筑物房间信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加建筑物房间信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BaseBuildingRoomEntity baseBuildingRoom,BaseBuildingRoomPage baseBuildingRoomPage, HttpServletRequest request) {
		List<BaseBuildingBedEntity> baseBuildingBedList =  baseBuildingRoomPage.getBaseBuildingBedList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			baseBuildingRoomService.addMain(baseBuildingRoom, baseBuildingBedList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "建筑物房间信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新建筑物房间信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BaseBuildingRoomEntity baseBuildingRoom,BaseBuildingRoomPage baseBuildingRoomPage, HttpServletRequest request) {
		List<BaseBuildingBedEntity> baseBuildingBedList =  baseBuildingRoomPage.getBaseBuildingBedList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			baseBuildingRoomService.updateMain(baseBuildingRoom, baseBuildingBedList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新建筑物房间信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 建筑物房间信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BaseBuildingRoomEntity baseBuildingRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseBuildingRoom.getId())) {
			baseBuildingRoom = baseBuildingRoomService.getEntity(BaseBuildingRoomEntity.class, baseBuildingRoom.getId());
			req.setAttribute("baseBuildingRoomPage", baseBuildingRoom);
		}else{
			BillNumbers billNum = new BillNumbers();
			baseBuildingRoom.setNo(billNum.commonNumber("BR0"));
			req.setAttribute("baseBuildingRoomPage", baseBuildingRoom);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/base/building/baseBuildingRoom-add");
	}
	
	/**
	 * 建筑物房间信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BaseBuildingRoomEntity baseBuildingRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseBuildingRoom.getId())) {
			baseBuildingRoom = baseBuildingRoomService.getEntity(BaseBuildingRoomEntity.class, baseBuildingRoom.getId());
			req.setAttribute("baseBuildingRoomPage", baseBuildingRoom);
		}
		return new ModelAndView("com/buss/base/building/baseBuildingRoom-update");
	}
	
	
	/**
	 * 加载明细列表[建筑物床位信息]
	 * 
	 * @return
	 */
	@RequestMapping(params = "baseBuildingBedList")
	public ModelAndView baseBuildingBedList(BaseBuildingRoomEntity baseBuildingRoom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = baseBuildingRoom.getId();
		//===================================================================================
		//查询-建筑物床位信息
	    String hql0 = "from BaseBuildingBedEntity where 1 = 1 AND bASE_BUILDING_ROOM_ID = ? ";
	    try{
	    	List<BaseBuildingBedEntity> baseBuildingBedEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("baseBuildingBedList", baseBuildingBedEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/base/building/baseBuildingBedList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(BaseBuildingRoomEntity baseBuildingRoom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(BaseBuildingRoomEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, baseBuildingRoom);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<BaseBuildingRoomEntity> list=this.baseBuildingRoomService.getListByCriteriaQuery(cq, false);
    	List<BaseBuildingRoomPage> pageList=new ArrayList<BaseBuildingRoomPage>();
        if(list!=null&&list.size()>0){
        	for(BaseBuildingRoomEntity entity:list){
        		try{
        		BaseBuildingRoomPage page=new BaseBuildingRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from BaseBuildingBedEntity where 1 = 1 AND bASE_BUILDING_ROOM_ID = ? ";
        	        List<BaseBuildingBedEntity> baseBuildingBedEntityList = systemService.findHql(hql0,id0);
            		page.setBaseBuildingBedList(baseBuildingBedEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"建筑物房间信息");
        map.put(NormalExcelConstants.CLASS,BaseBuildingRoomPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("建筑物房间信息列表", "导出人:Jeecg",
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
				List<BaseBuildingRoomPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), BaseBuildingRoomPage.class, params);
				BaseBuildingRoomEntity entity1=null;
				for (BaseBuildingRoomPage page : list) {
					entity1=new BaseBuildingRoomEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            baseBuildingRoomService.addMain(entity1, page.getBaseBuildingBedList());
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
		map.put(NormalExcelConstants.FILE_NAME,"建筑物房间信息");
		map.put(NormalExcelConstants.CLASS,BaseBuildingRoomPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("建筑物房间信息列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "baseBuildingRoomController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="建筑物房间信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BaseBuildingRoomPage>> list() {
		List<BaseBuildingRoomEntity> list= baseBuildingRoomService.getList(BaseBuildingRoomEntity.class);
    	List<BaseBuildingRoomPage> pageList=new ArrayList<BaseBuildingRoomPage>();
        if(list!=null&&list.size()>0){
        	for(BaseBuildingRoomEntity entity:list){
        		try{
        			BaseBuildingRoomPage page=new BaseBuildingRoomPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from BaseBuildingBedEntity where 1 = 1 AND bASE_BUILDING_ROOM_ID = ? ";
	    			List<BaseBuildingBedEntity> baseBuildingBedOldList = this.baseBuildingRoomService.findHql(hql0,id0);
            		page.setBaseBuildingBedList(baseBuildingBedOldList);
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
	@ApiOperation(value="根据ID获取建筑物房间信息信息",notes="根据ID获取建筑物房间信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BaseBuildingRoomEntity task = baseBuildingRoomService.get(BaseBuildingRoomEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取建筑物房间信息信息为空");
		}
		BaseBuildingRoomPage page = new BaseBuildingRoomPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from BaseBuildingBedEntity where 1 = 1 AND bASE_BUILDING_ROOM_ID = ? ";
			List<BaseBuildingBedEntity> baseBuildingBedOldList = this.baseBuildingRoomService.findHql(hql0,id0);
    		page.setBaseBuildingBedList(baseBuildingBedOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建建筑物房间信息")
	public ResponseMessage<?> create(@ApiParam(name="建筑物房间信息对象")@RequestBody BaseBuildingRoomPage baseBuildingRoomPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaseBuildingRoomPage>> failures = validator.validate(baseBuildingRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BaseBuildingBedEntity> baseBuildingBedList =  baseBuildingRoomPage.getBaseBuildingBedList();
		
		BaseBuildingRoomEntity baseBuildingRoom = new BaseBuildingRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(baseBuildingRoomPage,baseBuildingRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存建筑物房间信息失败");
        }
		baseBuildingRoomService.addMain(baseBuildingRoom, baseBuildingBedList);

		return Result.success(baseBuildingRoom);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新建筑物房间信息",notes="更新建筑物房间信息")
	public ResponseMessage<?> update(@RequestBody BaseBuildingRoomPage baseBuildingRoomPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BaseBuildingRoomPage>> failures = validator.validate(baseBuildingRoomPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<BaseBuildingBedEntity> baseBuildingBedList =  baseBuildingRoomPage.getBaseBuildingBedList();
		
		BaseBuildingRoomEntity baseBuildingRoom = new BaseBuildingRoomEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(baseBuildingRoomPage,baseBuildingRoom);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("建筑物房间信息更新失败");
        }
		baseBuildingRoomService.updateMain(baseBuildingRoom, baseBuildingBedList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除建筑物房间信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			BaseBuildingRoomEntity baseBuildingRoom = baseBuildingRoomService.get(BaseBuildingRoomEntity.class, id);
			baseBuildingRoomService.delMain(baseBuildingRoom);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("建筑物房间信息删除失败");
		}

		return Result.success();
	}

	/**
	 * 房间信息一览 界面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "getInfo",method = RequestMethod.GET)
	public ModelAndView getInfo(HttpServletRequest req) {
		req.setAttribute("type", "");//TODO 类型：公寓或者护理院
		return new ModelAndView("com/buss/base/building/baseBuildingRoomInfo");
	}

	@RequestMapping(params="getRoomInfoData",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> getRoomInfoData(HttpServletRequest req) {
		String building_id = req.getParameter("building_id");
		return buildingRoomMinidaoDao.getRoomInfoData(building_id);
	}
	@RequestMapping(params="getPeopleInfoData",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> getPeopleInfoData(HttpServletRequest req) {
		String building_id = req.getParameter("building_id");
		return buildingRoomMinidaoDao.getPeopleInfoData(building_id);
	}

	/**
	 * 房间信息详情 界面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "getDetails",method = RequestMethod.GET)
	public ModelAndView getInfo(BaseBuildingRoomEntity baseBuildingRoom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseBuildingRoom.getId())) {
			baseBuildingRoom = baseBuildingRoomService.getEntity(BaseBuildingRoomEntity.class, baseBuildingRoom.getId());
			req.setAttribute("baseBuildingRoomPage", baseBuildingRoom);
		}
		return new ModelAndView("com/buss/base/building/baseBuildingRoomDetails");
	}

}
