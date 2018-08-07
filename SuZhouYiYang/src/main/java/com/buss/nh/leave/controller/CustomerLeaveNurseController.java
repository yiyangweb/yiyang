package com.buss.nh.leave.controller;
import com.buss.nh.leave.entity.CustomerLeaveNurseEntity;
import com.buss.nh.leave.service.CustomerLeaveNurseServiceI;
import com.buss.nh.leave.page.CustomerLeaveNursePage;
import com.buss.nh.leave.entity.MoneyLeaveNurseEntity;
import com.buss.nh.leave.entity.CheckLeaveNurseEntity;
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
 * @Description: 退住申请
 * @author onlineGenerator
 * @date 2018-07-15 21:32:24
 * @version V1.0   
 *
 */
@Api(value="CustomerLeaveNurse",description="退住申请",tags="customerLeaveNurseController")
@Controller
@RequestMapping("/customerLeaveNurseController")
public class CustomerLeaveNurseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomerLeaveNurseController.class);

	@Autowired
	private CustomerLeaveNurseServiceI customerLeaveNurseService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 退住申请列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/nh/leave/customerLeaveNurseList");
	}

	/**
	 * 退住审核列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "listManage")
	public ModelAndView listManage(HttpServletRequest request) {
		return new ModelAndView("com/buss/nh/leave/customerLeaveNurseManageList");
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
	public void datagrid(CustomerLeaveNurseEntity customerLeaveNurse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerLeaveNurseEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerLeaveNurse);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);

		try{
		//自定义追加查询条
			String query_customerName = request.getParameter("customerName");
			String query_roomName = request.getParameter("roomName");
			String query_no = request.getParameter("no");
			String query_leaveStatus = request.getParameter("leaveStatus");
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.add(Restrictions.sqlRestriction("customer_name like '%"+query_customerName+"%'"));
			}
			if(StringUtil.isNotEmpty(query_roomName)){
				cq.add(Restrictions.sqlRestriction("room_name like '%" +query_roomName+"%'"));
			}
			if(StringUtil.isNotEmpty(query_no)){
				cq.add(Restrictions.sqlRestriction("no like '%" +query_no+"%'"));
			}
			if(StringUtil.isNotEmpty(query_leaveStatus)){
				cq.add(Restrictions.sqlRestriction("leave_status = '" +query_leaveStatus+"'"));
			}
			cq.add(Restrictions.sqlRestriction("sys_company_Code = '" +cmpCode+"'"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerLeaveNurseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid2")
	public void datagrid2(CustomerLeaveNurseEntity customerLeaveNurse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CustomerLeaveNurseEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerLeaveNurse);
		TSUser user = ResourceUtil.getSessionUser();
		TSDepart dept = user.getCurrentDepart();
		String orgCode = dept.getOrgCode();
		String cmpCode = orgCode.substring(0,3);

		try{
			//自定义追加查询条
			String query_customerName = request.getParameter("customerName");
			String query_roomName = request.getParameter("roomName");
			String query_no = request.getParameter("no");
			String query_leaveStatus = request.getParameter("leaveStatus");
			cq.notEq("leaveStatus","1");
			if(StringUtil.isNotEmpty(query_customerName)){
				cq.add(Restrictions.sqlRestriction("customer_name like '%"+query_customerName+"%'"));
			}
			if(StringUtil.isNotEmpty(query_roomName)){
				cq.add(Restrictions.sqlRestriction("room_name like '%" +query_roomName+"%'"));
			}
			if(StringUtil.isNotEmpty(query_no)){
				cq.add(Restrictions.sqlRestriction("no like '%" +query_no+"%'"));
			}
			if(StringUtil.isNotEmpty(query_leaveStatus)){
				cq.add(Restrictions.sqlRestriction("leave_status = '" +query_leaveStatus+"'"));
			}
			cq.add(Restrictions.sqlRestriction("sys_company_Code = '" +cmpCode+"'"));
			cq.add(Restrictions.sqlRestriction("sys_company_Code = '" +cmpCode+"'"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.customerLeaveNurseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除退住申请
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		customerLeaveNurse = systemService.getEntity(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
		String message = "退住申请删除成功";

		try{
			customerLeaveNurseService.delMain(customerLeaveNurse);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退住申请删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除退住申请
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "退住申请删除成功";
		try{
			for(String id:ids.split(",")){
				CustomerLeaveNurseEntity customerLeaveNurse = systemService.getEntity(CustomerLeaveNurseEntity.class,
				id
				);
				customerLeaveNurseService.delMain(customerLeaveNurse);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "退住申请删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加退住申请
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CustomerLeaveNurseEntity customerLeaveNurse,CustomerLeaveNursePage customerLeaveNursePage, HttpServletRequest request) {
		List<MoneyLeaveNurseEntity> moneyLeaveNurseList =  customerLeaveNursePage.getMoneyLeaveNurseList();
		List<CheckLeaveNurseEntity> checkLeaveNurseList =  customerLeaveNursePage.getCheckLeaveNurseList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		customerLeaveNurse.setLeaveStatus("1");
		try{
			customerLeaveNurseService.addMain(customerLeaveNurse, moneyLeaveNurseList,checkLeaveNurseList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "退住申请添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新退住申请
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CustomerLeaveNurseEntity customerLeaveNurse,CustomerLeaveNursePage customerLeaveNursePage, HttpServletRequest request) {
		List<MoneyLeaveNurseEntity> moneyLeaveNurseList =  customerLeaveNursePage.getMoneyLeaveNurseList();
		List<CheckLeaveNurseEntity> checkLeaveNurseList =  customerLeaveNursePage.getCheckLeaveNurseList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			customerLeaveNurseService.updateMain(customerLeaveNurse, moneyLeaveNurseList,checkLeaveNurseList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新退住申请失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 退住申请新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerLeaveNurse.getId())) {
			customerLeaveNurse = customerLeaveNurseService.getEntity(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
			req.setAttribute("customerLeaveNursePage", customerLeaveNurse);
		}else{
			BillNumbers billNum = new BillNumbers();
			customerLeaveNurse.setNo(billNum.commonNumber("NI0"));
			req.setAttribute("customerLeaveNursePage", customerLeaveNurse);
		}
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("user", user);
		return new ModelAndView("com/buss/nh/leave/customerLeaveNurse-add");
	}
	
	/**
	 * 退住申请编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(customerLeaveNurse.getId())) {
			customerLeaveNurse = customerLeaveNurseService.getEntity(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
			req.setAttribute("customerLeaveNursePage", customerLeaveNurse);
		}
		return new ModelAndView("com/buss/nh/leave/customerLeaveNurse-update");
	}
	
	
	/**
	 * 加载明细列表[相关费用]
	 * 
	 * @return
	 */
	@RequestMapping(params = "moneyLeaveNurseList")
	public ModelAndView moneyLeaveNurseList(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = customerLeaveNurse.getId();
		//===================================================================================
		//查询-相关费用
	    String hql0 = "from MoneyLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    try{
	    	List<MoneyLeaveNurseEntity> moneyLeaveNurseEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("moneyLeaveNurseList", moneyLeaveNurseEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/nh/leave/moneyLeaveNurseList");
	}
	/**
	 * 加载明细列表[检查情况]
	 * 
	 * @return
	 */
	@RequestMapping(params = "checkLeaveNurseList")
	public ModelAndView checkLeaveNurseList(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = customerLeaveNurse.getId();
		//===================================================================================
		//查询-检查情况
	    String hql1 = "from CheckLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    try{
	    	List<CheckLeaveNurseEntity> checkLeaveNurseEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("checkLeaveNurseList", checkLeaveNurseEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/nh/leave/checkLeaveNurseList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(CustomerLeaveNurseEntity customerLeaveNurse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(CustomerLeaveNurseEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, customerLeaveNurse);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<CustomerLeaveNurseEntity> list=this.customerLeaveNurseService.getListByCriteriaQuery(cq, false);
    	List<CustomerLeaveNursePage> pageList=new ArrayList<CustomerLeaveNursePage>();
        if(list!=null&&list.size()>0){
        	for(CustomerLeaveNurseEntity entity:list){
        		try{
        		CustomerLeaveNursePage page=new CustomerLeaveNursePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from MoneyLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
        	        List<MoneyLeaveNurseEntity> moneyLeaveNurseEntityList = systemService.findHql(hql0,id0);
            		page.setMoneyLeaveNurseList(moneyLeaveNurseEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from CheckLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
        	        List<CheckLeaveNurseEntity> checkLeaveNurseEntityList = systemService.findHql(hql1,id1);
            		page.setCheckLeaveNurseList(checkLeaveNurseEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"退住申请");
        map.put(NormalExcelConstants.CLASS,CustomerLeaveNursePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("退住申请列表", "导出人:Jeecg",
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
				List<CustomerLeaveNursePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), CustomerLeaveNursePage.class, params);
				CustomerLeaveNurseEntity entity1=null;
				for (CustomerLeaveNursePage page : list) {
					entity1=new CustomerLeaveNurseEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            customerLeaveNurseService.addMain(entity1, page.getMoneyLeaveNurseList(),page.getCheckLeaveNurseList());
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
		map.put(NormalExcelConstants.FILE_NAME,"退住申请");
		map.put(NormalExcelConstants.CLASS,CustomerLeaveNursePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("退住申请列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "customerLeaveNurseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	/**
	 * 自定义按钮-sql增强-提交
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doLeave_sbt")
	@ResponseBody
	public AjaxJson doLeave_sbt(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "提交成功";
		CustomerLeaveNurseEntity t = customerLeaveNurseService.get(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
		try{
			customerLeaveNurseService.doLeave_sbtSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-同意
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doLeave_pass")
	@ResponseBody
	public AjaxJson doLeave_pass(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "同意成功";
		TSUser user = ResourceUtil.getSessionUser();
		CustomerLeaveNurseEntity t = customerLeaveNurseService.get(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
		try{
			customerLeaveNurseService.doLeave_passSql(t,user.getRealName());
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "同意失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-不同意
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doLeave_no")
	@ResponseBody
	public AjaxJson doLeave_no(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "不同意成功";
		TSUser user = ResourceUtil.getSessionUser();
		CustomerLeaveNurseEntity t = customerLeaveNurseService.get(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
		try{
			customerLeaveNurseService.doLeave_noSql(t,user.getRealName());
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "不同意失败";
		}
		j.setMsg(message);
		return j;
	}
 	/**
	 * 自定义按钮-sql增强-确认退住
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doLeave_confirm")
	@ResponseBody
	public AjaxJson doLeave_confirm(CustomerLeaveNurseEntity customerLeaveNurse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "确认退住成功";
		CustomerLeaveNurseEntity t = customerLeaveNurseService.get(CustomerLeaveNurseEntity.class, customerLeaveNurse.getId());
		try{
			customerLeaveNurseService.doLeave_confirmSql(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "确认退住失败";
		}
		j.setMsg(message);
		return j;
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="退住申请列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CustomerLeaveNursePage>> list() {
		List<CustomerLeaveNurseEntity> list= customerLeaveNurseService.getList(CustomerLeaveNurseEntity.class);
    	List<CustomerLeaveNursePage> pageList=new ArrayList<CustomerLeaveNursePage>();
        if(list!=null&&list.size()>0){
        	for(CustomerLeaveNurseEntity entity:list){
        		try{
        			CustomerLeaveNursePage page=new CustomerLeaveNursePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
					Object id0 = entity.getId();
					Object id1 = entity.getId();
				     String hql0 = "from MoneyLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    			List<MoneyLeaveNurseEntity> moneyLeaveNurseOldList = this.customerLeaveNurseService.findHql(hql0,id0);
            		page.setMoneyLeaveNurseList(moneyLeaveNurseOldList);
				     String hql1 = "from CheckLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    			List<CheckLeaveNurseEntity> checkLeaveNurseOldList = this.customerLeaveNurseService.findHql(hql1,id1);
            		page.setCheckLeaveNurseList(checkLeaveNurseOldList);
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
	@ApiOperation(value="根据ID获取退住申请信息",notes="根据ID获取退住申请信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CustomerLeaveNurseEntity task = customerLeaveNurseService.get(CustomerLeaveNurseEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取退住申请信息为空");
		}
		CustomerLeaveNursePage page = new CustomerLeaveNursePage();
		try {
			MyBeanUtils.copyBeanNotNull2Bean(task, page);
				Object id0 = task.getId();
				Object id1 = task.getId();
		    String hql0 = "from MoneyLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
			List<MoneyLeaveNurseEntity> moneyLeaveNurseOldList = this.customerLeaveNurseService.findHql(hql0,id0);
    		page.setMoneyLeaveNurseList(moneyLeaveNurseOldList);
		    String hql1 = "from CheckLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
			List<CheckLeaveNurseEntity> checkLeaveNurseOldList = this.customerLeaveNurseService.findHql(hql1,id1);
    		page.setCheckLeaveNurseList(checkLeaveNurseOldList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.success(page);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建退住申请")
	public ResponseMessage<?> create(@ApiParam(name="退住申请对象")@RequestBody CustomerLeaveNursePage customerLeaveNursePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerLeaveNursePage>> failures = validator.validate(customerLeaveNursePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MoneyLeaveNurseEntity> moneyLeaveNurseList =  customerLeaveNursePage.getMoneyLeaveNurseList();
		List<CheckLeaveNurseEntity> checkLeaveNurseList =  customerLeaveNursePage.getCheckLeaveNurseList();
		
		CustomerLeaveNurseEntity customerLeaveNurse = new CustomerLeaveNurseEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerLeaveNursePage,customerLeaveNurse);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("保存退住申请失败");
        }
		customerLeaveNurseService.addMain(customerLeaveNurse, moneyLeaveNurseList,checkLeaveNurseList);

		return Result.success(customerLeaveNurse);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新退住申请",notes="更新退住申请")
	public ResponseMessage<?> update(@RequestBody CustomerLeaveNursePage customerLeaveNursePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CustomerLeaveNursePage>> failures = validator.validate(customerLeaveNursePage);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		List<MoneyLeaveNurseEntity> moneyLeaveNurseList =  customerLeaveNursePage.getMoneyLeaveNurseList();
		List<CheckLeaveNurseEntity> checkLeaveNurseList =  customerLeaveNursePage.getCheckLeaveNurseList();
		
		CustomerLeaveNurseEntity customerLeaveNurse = new CustomerLeaveNurseEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(customerLeaveNursePage,customerLeaveNurse);
		}catch(Exception e){
            logger.info(e.getMessage());
            return Result.error("退住申请更新失败");
        }
		customerLeaveNurseService.updateMain(customerLeaveNurse, moneyLeaveNurseList,checkLeaveNurseList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除退住申请")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			CustomerLeaveNurseEntity customerLeaveNurse = customerLeaveNurseService.get(CustomerLeaveNurseEntity.class, id);
			customerLeaveNurseService.delMain(customerLeaveNurse);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("退住申请删除失败");
		}

		return Result.success();
	}
}
