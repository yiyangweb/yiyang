package com.buss.apt.stayout.service;
import com.buss.apt.stayout.entity.CustomerOutRoomEntity;
import com.buss.apt.stayout.entity.CheckOutDesEntity;

import java.util.Date;
import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerOutRoomServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerOutRoomEntity customerOutRoom,
	        List<CheckOutDesEntity> checkOutDesList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerOutRoomEntity customerOutRoom,
	        List<CheckOutDesEntity> checkOutDesList);
	public void delMain (CustomerOutRoomEntity customerOutRoom);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doOut_putSql(CustomerOutRoomEntity t);
 	/**
	 * 自定义按钮-sql增强-同意退房
	 * @param id
	 * @return
	 */
	 public boolean doOut_passSql(CustomerOutRoomEntity t,String auditor,String now);
 	/**
	 * 自定义按钮-sql增强-退回
	 * @param id
	 * @return
	 */
	 public boolean doOut_returnSql(CustomerOutRoomEntity t,String auditor,String now);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerOutRoomEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerOutRoomEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerOutRoomEntity t);
}
