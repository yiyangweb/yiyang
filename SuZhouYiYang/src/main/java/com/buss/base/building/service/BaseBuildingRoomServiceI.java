package com.buss.base.building.service;
import com.buss.base.building.entity.BaseBuildingRoomEntity;
import com.buss.base.building.entity.BaseBuildingBedEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BaseBuildingRoomServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BaseBuildingRoomEntity baseBuildingRoom,
	        List<BaseBuildingBedEntity> baseBuildingBedList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BaseBuildingRoomEntity baseBuildingRoom,
	        List<BaseBuildingBedEntity> baseBuildingBedList);
	public void delMain (BaseBuildingRoomEntity baseBuildingRoom);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BaseBuildingRoomEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BaseBuildingRoomEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BaseBuildingRoomEntity t);
}
