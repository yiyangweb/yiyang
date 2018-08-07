package com.buss.base.contract.service;
import com.buss.base.contract.entity.ValueAddedServiceTypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ValueAddedServiceTypeServiceI extends CommonService{
	
 	public void delete(ValueAddedServiceTypeEntity entity) throws Exception;
 	
 	public Serializable save(ValueAddedServiceTypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ValueAddedServiceTypeEntity entity) throws Exception;
 	
}
