package com.buss.nh.stayin.service;
import com.buss.nh.stayin.entity.CustomerToNhEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CustomerToNhServiceI extends CommonService{
	
 	public void delete(CustomerToNhEntity entity) throws Exception;
 	
 	public Serializable save(CustomerToNhEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CustomerToNhEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[提交]业务处理
	 * @param id
	 * @return
	 */
	 public void doIn_sbtBus(CustomerToNhEntity t) throws Exception;
 	/**
	 * 自定义按钮-[确认入住]业务处理
	 * @param id
	 * @return
	 */
	 public void doIn_commitBus(CustomerToNhEntity t) throws Exception;
}
