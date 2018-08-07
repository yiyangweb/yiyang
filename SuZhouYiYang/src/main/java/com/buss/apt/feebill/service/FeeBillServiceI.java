package com.buss.apt.feebill.service;
import com.buss.apt.feebill.entity.FeeBillEntity;
import com.buss.apt.feebill.entity.CustomerFeeDesEntity;
import com.buss.apt.feebill.entity.PaymentListEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface FeeBillServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(FeeBillEntity feeBill,
	        List<CustomerFeeDesEntity> customerFeeDesList,List<PaymentListEntity> paymentListList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(FeeBillEntity feeBill,
	        List<CustomerFeeDesEntity> customerFeeDesList,List<PaymentListEntity> paymentListList);
	public void delMain (FeeBillEntity feeBill);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(FeeBillEntity t);
 	/**
	 * 自定义按钮-sql增强-同意
	 * @param id
	 * @return
	 */
	 public boolean doOk_feeSql(FeeBillEntity t);
 	/**
	 * 自定义按钮-sql增强-不同意
	 * @param id
	 * @return
	 */
	 public boolean doNo_feeSql(FeeBillEntity t);
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param id
	 * @return
	 */
	 public boolean doReceiveSql(FeeBillEntity t);
 	/**
	 * 自定义按钮-sql增强-归档
	 * @param id
	 * @return
	 */
	 public boolean doArchiveSql(FeeBillEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(FeeBillEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(FeeBillEntity t,List<PaymentListEntity> paymentListList);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(FeeBillEntity t);
}
