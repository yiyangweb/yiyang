package com.buss.base.check.service;
import com.buss.base.check.entity.CheckListTypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CheckListTypeServiceI extends CommonService{
	
 	public void delete(CheckListTypeEntity entity) throws Exception;
 	
 	public Serializable save(CheckListTypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CheckListTypeEntity entity) throws Exception;
 	
}
