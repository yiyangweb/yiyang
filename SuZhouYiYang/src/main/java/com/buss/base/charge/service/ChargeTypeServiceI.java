package com.buss.base.charge.service;
import com.buss.base.charge.entity.ChargeTypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChargeTypeServiceI extends CommonService{
	
 	public void delete(ChargeTypeEntity entity) throws Exception;
 	
 	public Serializable save(ChargeTypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChargeTypeEntity entity) throws Exception;
 	
}
