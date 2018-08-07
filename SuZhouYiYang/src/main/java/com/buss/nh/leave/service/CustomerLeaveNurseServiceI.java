package com.buss.nh.leave.service;
import com.buss.nh.leave.entity.CustomerLeaveNurseEntity;
import com.buss.nh.leave.entity.MoneyLeaveNurseEntity;
import com.buss.nh.leave.entity.CheckLeaveNurseEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerLeaveNurseServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerLeaveNurseEntity customerLeaveNurse,
	        List<MoneyLeaveNurseEntity> moneyLeaveNurseList,List<CheckLeaveNurseEntity> checkLeaveNurseList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerLeaveNurseEntity customerLeaveNurse,
	        List<MoneyLeaveNurseEntity> moneyLeaveNurseList,List<CheckLeaveNurseEntity> checkLeaveNurseList);
	public void delMain (CustomerLeaveNurseEntity customerLeaveNurse);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doLeave_sbtSql(CustomerLeaveNurseEntity t);
 	/**
	 * 自定义按钮-sql增强-同意
	 * @param id
	 * @return
	 */
	 public boolean doLeave_passSql(CustomerLeaveNurseEntity t,String userName);
 	/**
	 * 自定义按钮-sql增强-不同意
	 * @param id
	 * @return
	 */
	 public boolean doLeave_noSql(CustomerLeaveNurseEntity t,String userName);
 	/**
	 * 自定义按钮-sql增强-确认退住
	 * @param id
	 * @return
	 */
	 public boolean doLeave_confirmSql(CustomerLeaveNurseEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerLeaveNurseEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerLeaveNurseEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerLeaveNurseEntity t);
}
