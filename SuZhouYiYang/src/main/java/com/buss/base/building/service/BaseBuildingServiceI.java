package com.buss.base.building.service;
import com.buss.base.building.entity.BaseBuildingEntity;
import com.buss.base.building.entity.BaseBuildingStoreyEntity;
import com.buss.base.building.entity.BaseBuildingRoomTypeEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BaseBuildingServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BaseBuildingEntity baseBuilding,
	        List<BaseBuildingStoreyEntity> baseBuildingStoreyList,List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BaseBuildingEntity baseBuilding,
	        List<BaseBuildingStoreyEntity> baseBuildingStoreyList,List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList);
	public void delMain (BaseBuildingEntity baseBuilding);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BaseBuildingEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BaseBuildingEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BaseBuildingEntity t);
}
