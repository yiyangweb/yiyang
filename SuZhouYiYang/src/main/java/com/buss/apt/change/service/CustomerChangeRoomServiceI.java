package com.buss.apt.change.service;
import com.buss.apt.change.entity.CustomerChangeRoomEntity;
import com.buss.apt.change.entity.CheckChangeDesEntity;
import com.buss.apt.change.entity.ChangeRoomFeeEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerChangeRoomServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerChangeRoomEntity customerChangeRoom,
	        List<CheckChangeDesEntity> checkChangeDesList,List<ChangeRoomFeeEntity> changeRoomFeeList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerChangeRoomEntity customerChangeRoom,
	        List<CheckChangeDesEntity> checkChangeDesList,List<ChangeRoomFeeEntity> changeRoomFeeList);
	public void delMain (CustomerChangeRoomEntity customerChangeRoom);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(CustomerChangeRoomEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerChangeRoomEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerChangeRoomEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerChangeRoomEntity t);
}
