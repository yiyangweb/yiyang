package com.buss.base.nurse.service;
import com.buss.base.nurse.entity.NurseLevelInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface NurseLevelInfoServiceI extends CommonService{
	
 	public void delete(NurseLevelInfoEntity entity) throws Exception;
 	
 	public Serializable save(NurseLevelInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(NurseLevelInfoEntity entity) throws Exception;
 	
}
