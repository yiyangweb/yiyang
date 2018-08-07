package com.buss.apt.property.service;
import com.buss.apt.property.entity.PropertyManageEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PropertyManageServiceI extends CommonService{
	
 	public void delete(PropertyManageEntity entity) throws Exception;
 	
 	public Serializable save(PropertyManageEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PropertyManageEntity entity) throws Exception;
 	
}
