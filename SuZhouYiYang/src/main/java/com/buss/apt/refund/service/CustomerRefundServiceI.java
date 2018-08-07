package com.buss.apt.refund.service;
import com.buss.apt.refund.entity.CustomerRefundEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CustomerRefundServiceI extends CommonService{
	
 	public void delete(CustomerRefundEntity entity) throws Exception;
 	
 	public Serializable save(CustomerRefundEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CustomerRefundEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[提交]业务处理
	 * @param id
	 * @return
	 */
	 public void doCommitBus(CustomerRefundEntity t) throws Exception;
 	/**
	 * 自定义按钮-[同意]业务处理
	 * @param id
	 * @return
	 */
	 public void doAgreeBus(CustomerRefundEntity t) throws Exception;
 	/**
	 * 自定义按钮-[不同意]业务处理
	 * @param id
	 * @return
	 */
	 public void doDisagreeBus(CustomerRefundEntity t) throws Exception;
 	/**
	 * 自定义按钮-[缴费]业务处理
	 * @param id
	 * @return
	 */
	 public void doReceiveBus(CustomerRefundEntity t) throws Exception;
 	/**
	 * 自定义按钮-[归档]业务处理
	 * @param id
	 * @return
	 */
	 public void doArchiveBus(CustomerRefundEntity t) throws Exception;
}
