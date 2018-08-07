package com.buss.base.contract.service;
import com.buss.base.contract.entity.ContractTypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ContractTypeServiceI extends CommonService{
	
 	public void delete(ContractTypeEntity entity) throws Exception;
 	
 	public Serializable save(ContractTypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ContractTypeEntity entity) throws Exception;
 	
}
