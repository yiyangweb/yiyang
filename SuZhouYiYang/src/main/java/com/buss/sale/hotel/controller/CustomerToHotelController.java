package com.buss.sale.hotel.controller;

import com.buss.sale.hotel.entity.CustomerToHotelEntity;
import com.buss.sale.hotel.service.CustomerToHotelServiceI;
import com.buss.sale.hotel.page.CustomerToHotelPage;
import com.buss.sale.hotel.entity.ChargeListHotelEntity;
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
 * @Description: 酒店管理
 * @author onlineGenerator
 * @date 2018-06-04 14:57:08
 * @version V1.0   
 *
 */
@Api(value="CustomerToHotel",description="酒店管理",tags="customerToHotelController")
@Controller
@RequestMapping("/customerToHotelController")
public class CustomerToHotelController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerToHotelController.class);

	@Autowired
	private CustomerToHotelServiceI customerToHotelService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 酒店管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/sale/hotel/customerToHotelList");
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
	public void datagrid(CustomerToHotelEntity customerToHotel,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerToHotelEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerToHotel);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerToHotelService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除酒店管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerToHotelEntity customerToHotel, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerToHotel = systemService.getEntity(CustomerToHotelEntity.class, customerToHotel.getId());
		String message = "酒店管理删除成功";
		try{
			customerToHotelService.delMain(customerToHotel);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "酒店管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除酒店管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "酒店管理删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerToHotelEntity customerToHotel = systemService.getEntity(CustomerToHotelEntity.class,
				id
				);
				customerToHotelService.delMain(customerToHotel);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "酒店管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加酒店管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerToHotelEntity customerToHotel,CustomerToHotelPage customerToHotelPage, HttpServletRequest request) {
		List<ChargeListHotelEntity> chargeListHotelList =  customerToHotelPage.getChargeListHotelList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			customerToHotelService.addMain(customerToHotel, chargeListHotelList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "酒店管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新酒店管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerToHotelEntity customerToHotel,CustomerToHotelPage customerToHotelPage, HttpServletRequest request) {
		List<ChargeListHotelEntity> chargeListHotelList =  customerToHotelPage.getChargeListHotelList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerToHotelService.updateMain(customerToHotel, chargeListHotelList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新酒店管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 酒店管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerToHotelEntity customerToHotel, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerToHotel.getId())) {
			customerToHotel = customerToHotelService.getEntity(CustomerToHotelEntity.class, customerToHotel.getId());
			req.setAttribute("customerToHotelPage", customerToHotel);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerToHotel.setNo(billNum.commonNumber("CH0"));
			req.setAttribute("customerToHotelPage", customerToHotel);
		}
		return new ModelAndView("com/buss/sale/hotel/customerToHotel-add");
	}
	
	/**
	 * 酒店管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerToHotelEntity customerToHotel, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerToHotel.getId())) {
			customerToHotel = customerToHotelService.getEntity(CustomerToHotelEntity.class, customerToHotel.getId());
			req.setAttribute("customerToHotelPage", customerToHotel);
		}
		return new ModelAndView("com/buss/sale/hotel/customerToHotel-update");
	}
	
	
	/**
	 * 加载明细列表[收费列表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "chargeListHotelList")
	public ModelAndView chargeListHotelList(CustomerToHotelEntity customerToHotel, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerToHotel.getId();
		//===================================================================================
		//查询-收费列表
	    String hql0 = "from ChargeListHotelEntity where 1 = 1 AND cH_ID = ? ";
	    try{
	    	List<ChargeListHotelEntity> chargeListHotelEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("chargeListHotelList", chargeListHotelEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/sale/hotel/chargeListHotelList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerToHotelEntity customerToHotel,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerToHotelEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerToHotel);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerToHotelEntity> list=this.customerToHotelService.getListByCriteriaQuery(cq, false);
    	List<CustomerToHotelPage> pageList=new ArrayList<CustomerToHotelPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerToHotelEntity entity:list){
        		try{
        		CustomerToHotelPage page=new CustomerToHotelPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from ChargeListHotelEntity where 1 = 1 AND cH_ID = ? ";
        	        List<ChargeListHotelEntity> chargeListHotelEntityList = systemService.findHql(hql0,id0);
            		page.setChargeListHotelList(chargeListHotelEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"酒店管理");
        map.put(NormalExcelConstants.CLASS,CustomerToHotelPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("酒店管理列表", "导出人:Jeecg",
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
				List<CustomerToHotelPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerToHotelPage.class, params);
				CustomerToHotelEntity entity1=null;
				for (CustomerToHotelPage page : list) {
					entity1=new CustomerToHotelEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerToHotelService.addMain(entity1, page.getChargeListHotelList());
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
		map.put(NormalExcelConstants.FILE_NAME,"酒店管理");
		map.put(NormalExcelConstants.CLASS,CustomerToHotelPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("酒店管理列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerToHotelController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="酒店管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerToHotelPage>> list() {
		List<CustomerToHotelEntity> list= customerToHotelService.getList(CustomerToHotelEntity.class);
    	List<CustomerToHotelPage> pageList=new ArrayList<CustomerToHotelPage>();
        if(list!=null&&list.size()>0){
        	for(CustomerToHotelEntity entity:list){
        		try{
        			CustomerToHotelPage page=new CustomerToHotelPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
				     String hql0 = "from ChargeListHotelEntity where 1 = 1 AND cH_ID = ? ";
	    			List<ChargeListHotelEntity> chargeListHotelOldList = this.customerToHotelService.findHql(hql0,id0);
            		page.setChargeListHotelList(chargeListHotelOldList);
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
	@ApiOperation(value="根据ID获取酒店管理信息",notes="根据ID获取酒店管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerToHotelEntity task = customerToHotelService.get(CustomerToHotelEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取酒店管理信息为空");
		}
		CustomerToHotelPage page = new CustomerToHotelPage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
		    String hql0 = "from ChargeListHotelEntity where 1 = 1 AND cH_ID = ? ";
			List<ChargeListHotelEntity> chargeListHotelOldList = this.customerToHotelService.findHql(hql0,id0);
    		page.setChargeListHotelList(chargeListHotelOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建酒店管理")
	public ResponseMessage<?> create(@ApiParam(name="酒店管理对象")@RequestBody CustomerToHotelPage customerToHotelPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerToHotelPage>> failures = validator.validate(customerToHotelPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ChargeListHotelEntity> chargeListHotelList =  customerToHotelPage.getChargeListHotelList();
		
		CustomerToHotelEntity customerToHotel = new CustomerToHotelEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerToHotelPage,customerToHotel);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存酒店管理失败");
        }
		customerToHotelService.addMain(customerToHotel, chargeListHotelList);

		return Result.success(customerToHotel);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新酒店管理",notes="更新酒店管理")
	public ResponseMessage<?> update(@RequestBody CustomerToHotelPage customerToHotelPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerToHotelPage>> failures = validator.validate(customerToHotelPage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<ChargeListHotelEntity> chargeListHotelList =  customerToHotelPage.getChargeListHotelList();
		
		CustomerToHotelEntity customerToHotel = new CustomerToHotelEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerToHotelPage,customerToHotel);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("酒店管理更新失败");
        }
		customerToHotelService.updateMain(customerToHotel, chargeListHotelList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除酒店管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerToHotelEntity customerToHotel = customerToHotelService.get(CustomerToHotelEntity.class, id);
			customerToHotelService.delMain(customerToHotel);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("酒店管理删除失败");
		}

		return Result.success();
	}
}
