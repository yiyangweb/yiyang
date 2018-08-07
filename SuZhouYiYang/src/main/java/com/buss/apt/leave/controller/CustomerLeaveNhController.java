package com.buss.apt.leave.controller;
import com.buss.apt.leave.entity.CustomerLeaveNhEntity;
import com.buss.apt.leave.service.CustomerLeaveNhServiceI;
import com.buss.apt.leave.page.CustomerLeaveNhPage;
import com.buss.apt.leave.entity.CheckLeaveNhEntity;
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
 * @Description: 退住管理
 * @author onlineGenerator
 * @date 2018-07-05 21:14:49
 * @version V1.0   
 *
 */
@Api(value="CustomerLeaveNh",description="退住管理",tags="customerLeaveNhController")
@Controller
@RequestMapping("/customerLeaveNhController")
public class CustomerLeaveNhController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerLeaveNhController.class);

	@Autowired
	private CustomerLeaveNhServiceI customerLeaveNhService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 退住管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/apt/leave/customerLeaveNhList");
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
	public void datagrid(CustomerLeaveNhEntity customerLeaveNh,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerLeaveNhEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerLeaveNh);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerLeaveNhService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除退住管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerLeaveNhEntity customerLeaveNh, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerLeaveNh = systemService.getEntity(CustomerLeaveNhEntity.class, customerLeaveNh.getId());
		String message = "退住管理删除成功";
		try{
			customerLeaveNhService.delMain(customerLeaveNh);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退住管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除退住管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "退住管理删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerLeaveNhEntity customerLeaveNh = systemService.getEntity(CustomerLeaveNhEntity.class,
				id
				);
				customerLeaveNhService.delMain(customerLeaveNh);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "退住管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加退住管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerLeaveNhEntity customerLeaveNh,CustomerLeaveNhPage customerLeaveNhPage, HttpServletRequest request) {
		List<CheckLeaveNhEntity> checkLeaveNhList =  customerLeaveNhPage.getCheckLeaveNhList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			customerLeaveNhService.addMain(customerLeaveNh, checkLeaveNhList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退住管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新退住管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerLeaveNhEntity customerLeaveNh,CustomerLeaveNhPage customerLeaveNhPage, HttpServletRequest request) {
		List<CheckLeaveNhEntity> checkLeaveNhList =  customerLeaveNhPage.getCheckLeaveNhList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerLeaveNhService.updateMain(customerLeaveNh, checkLeaveNhList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新退住管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 退住管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerLeaveNhEntity customerLeaveNh, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerLeaveNh.getId())) {
			customerLeaveNh = customerLeaveNhService.getEntity(CustomerLeaveNhEntity.class, customerLeaveNh.getId());
			req.setAttribute("customerLeaveNhPage", customerLeaveNh);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerLeaveNh.setNo(billNum.commonNumber("CL"));
			req.setAttribute("customerLeaveNhPage", customerLeaveNh);
		}
		return new ModelAndView("com/buss/apt/leave/customerLeaveNh-add");
	}
	
	/**
	 * 退住管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerLeaveNhEntity customerLeaveNh, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerLeaveNh.getId())) {
			customerLeaveNh = customerLeaveNhService.getEntity(CustomerLeaveNhEntity.class, customerLeaveNh.getId());
			req.setAttribute("customerLeaveNhPage", customerLeaveNh);
		}
		return new ModelAndView("com/buss/apt/leave/customerLeaveNh-update");
	}
	
	
	/**
	 * 加载明细列表[检查列表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "checkLeaveNhList")
	public ModelAndView checkLeaveNhList(CustomerLeaveNhEntity customerLeaveNh, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerLeaveNh.getId();
		//===================================================================================
		//查询-检查列表
	    String hql0 = "from CheckLeaveNhEntity where 1 = 1 AND tZ_ID = ? ";
	    try{
	    	List<CheckLeaveNhEntity> checkLeaveNhEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("checkLeaveNhList", checkLeaveNhEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/apt/leave/checkLeaveNhList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerLeaveNhEntity customerLeaveNh,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerLeaveNhEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerLeaveNh);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerLeaveNhEntity> list=this.customerLeaveNhService.getListByCriteriaQuery(cq, false);
    	List<CustomerLeaveNhPage> pageList=new ArrayList<CustomerLeaveNhPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerLeaveNhEntity entity:list){
        		try{
        		CustomerLeaveNhPage page=new CustomerLeaveNhPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from CheckLeaveNhEntity where 1 = 1 AND tZ_ID = ? ";
        	        List<CheckLeaveNhEntity> checkLeaveNhEntityList = systemService.findHql(hql0,id0);
            		page.setCheckLeaveNhList(checkLeaveNhEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"退住管理");
        map.put(NormalExcelConstants.CLASS,CustomerLeaveNhPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("退住管理列表", "导出人:Jeecg",
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
				List<CustomerLeaveNhPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerLeaveNhPage.class, params);
				CustomerLeaveNhEntity entity1=null;
				for (CustomerLeaveNhPage page : list) {
					entity1=new CustomerLeaveNhEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerLeaveNhService.addMain(entity1, page.getCheckLeaveNhList());
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
		map.put(NormalExcelConstants.FILE_NAME,"退住管理");
		map.put(NormalExcelConstants.CLASS,CustomerLeaveNhPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("退住管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerLeaveNhController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="退住管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerLeaveNhPage>> list() {
		List<CustomerLeaveNhEntity> list= customerLeaveNhService.getList(CustomerLeaveNhEntity.class);
    	List<CustomerLeaveNhPage> pageList=new ArrayList<CustomerLeaveNhPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerLeaveNhEntity entity:list){
        		try{
        			CustomerLeaveNhPage page=new CustomerLeaveNhPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from CheckLeaveNhEntity where 1 = 1 AND tZ_ID = ? ";
	    			List<CheckLeaveNhEntity> checkLeaveNhOldList = this.customerLeaveNhService.findHql(hql0,id0);
            		page.setCheckLeaveNhList(checkLeaveNhOldList);
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
	@ApiOperation(value="根据ID获取退住管理信息",notes="根据ID获取退住管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerLeaveNhEntity task = customerLeaveNhService.get(CustomerLeaveNhEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取退住管理信息为空");
		}
		CustomerLeaveNhPage page = new CustomerLeaveNhPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from CheckLeaveNhEntity where 1 = 1 AND tZ_ID = ? ";
			List<CheckLeaveNhEntity> checkLeaveNhOldList = this.customerLeaveNhService.findHql(hql0,id0);
    		page.setCheckLeaveNhList(checkLeaveNhOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建退住管理")
	public ResponseMessage<?> create(@ApiParam(name="退住管理对象")@RequestBody CustomerLeaveNhPage customerLeaveNhPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerLeaveNhPage>> failures = validator.validate(customerLeaveNhPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckLeaveNhEntity> checkLeaveNhList =  customerLeaveNhPage.getCheckLeaveNhList();
		
		CustomerLeaveNhEntity customerLeaveNh = new CustomerLeaveNhEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerLeaveNhPage,customerLeaveNh);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存退住管理失败");
        }
		customerLeaveNhService.addMain(customerLeaveNh, checkLeaveNhList);

		return Result.success(customerLeaveNh);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新退住管理",notes="更新退住管理")
	public ResponseMessage<?> update(@RequestBody CustomerLeaveNhPage customerLeaveNhPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerLeaveNhPage>> failures = validator.validate(customerLeaveNhPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<CheckLeaveNhEntity> checkLeaveNhList =  customerLeaveNhPage.getCheckLeaveNhList();
		
		CustomerLeaveNhEntity customerLeaveNh = new CustomerLeaveNhEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerLeaveNhPage,customerLeaveNh);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("退住管理更新失败");
        }
		customerLeaveNhService.updateMain(customerLeaveNh, checkLeaveNhList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除退住管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerLeaveNhEntity customerLeaveNh = customerLeaveNhService.get(CustomerLeaveNhEntity.class, id);
			customerLeaveNhService.delMain(customerLeaveNh);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("退住管理删除失败");
		}

		return Result.success();
	}
}
