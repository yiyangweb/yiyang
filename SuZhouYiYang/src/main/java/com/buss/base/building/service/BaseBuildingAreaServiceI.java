package com.buss.base.building.service;
import com.buss.base.building.entity.BaseBuildingAreaEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BaseBuildingAreaServiceI extends CommonService{
	
 	public void delete(BaseBuildingAreaEntity entity) throws Exception;
 	
 	public Serializable save(BaseBuildingAreaEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BaseBuildingAreaEntity entity) throws Exception;
 	
}
