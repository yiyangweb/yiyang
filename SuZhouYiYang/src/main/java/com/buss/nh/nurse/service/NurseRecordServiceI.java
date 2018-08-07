package com.buss.nh.nurse.service;
import com.buss.nh.nurse.entity.NurseRecordEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface NurseRecordServiceI extends CommonService{
	
 	public void delete(NurseRecordEntity entity) throws Exception;
 	
 	public Serializable save(NurseRecordEntity entity) throws Exception;
 	
 	public void saveOrUpdate(NurseRecordEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[确认]业务处理
	 * @param id
	 * @return
	 */
	 public void doNurse_sbtBus(NurseRecordEntity t) throws Exception;
}
