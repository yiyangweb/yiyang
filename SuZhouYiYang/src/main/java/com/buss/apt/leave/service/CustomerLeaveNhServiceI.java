package com.buss.apt.leave.service;
import com.buss.apt.leave.entity.CustomerLeaveNhEntity;
import com.buss.apt.leave.entity.CheckLeaveNhEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerLeaveNhServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerLeaveNhEntity customerLeaveNh,
	        List<CheckLeaveNhEntity> checkLeaveNhList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerLeaveNhEntity customerLeaveNh,
	        List<CheckLeaveNhEntity> checkLeaveNhList);
	public void delMain (CustomerLeaveNhEntity customerLeaveNh);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerLeaveNhEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerLeaveNhEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerLeaveNhEntity t);
}
