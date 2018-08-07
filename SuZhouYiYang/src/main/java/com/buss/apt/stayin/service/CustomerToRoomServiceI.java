package com.buss.apt.stayin.service;
import com.buss.apt.stayin.entity.CustomerToRoomEntity;
import com.buss.apt.stayin.entity.CheckListDesEntity;
import com.buss.apt.stayin.entity.CustomerTrainInfoEntity;
import com.buss.apt.stayin.entity.CustomerRoomDesEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerToRoomServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerToRoomEntity customerToRoom,
	        List<CheckListDesEntity> checkListDesList,List<CustomerTrainInfoEntity> customerTrainInfoList,List<CustomerRoomDesEntity> customerRoomDesList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerToRoomEntity customerToRoom,
	        List<CheckListDesEntity> checkListDesList,List<CustomerTrainInfoEntity> customerTrainInfoList,List<CustomerRoomDesEntity> customerRoomDesList);
	public void delMain (CustomerToRoomEntity customerToRoom);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(CustomerToRoomEntity t);
 	/**
	 * 自定义按钮-sql增强-确认入住
	 * @param id
	 * @return
	 */
	 public boolean doConfirmSql(CustomerToRoomEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerToRoomEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerToRoomEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerToRoomEntity t);
}
