package com.buss.sale.customer.service;
import com.buss.sale.customer.entity.CustomerBaseEntity;
import com.buss.sale.customer.entity.CustomerProfileEntity;
import com.buss.sale.customer.entity.CustomerRelativesEntity;
import com.buss.sale.customer.entity.CustomerEducatioinEntity;
import com.buss.sale.customer.entity.CustomerJobEntity;
import com.buss.sale.customer.entity.CustomerCommonChargeEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerBaseServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerBaseEntity customerBase,
	        List<CustomerProfileEntity> customerProfileList,List<CustomerRelativesEntity> customerRelativesList,List<CustomerEducatioinEntity> customerEducatioinList,List<CustomerJobEntity> customerJobList,List<CustomerCommonChargeEntity> customerCommonChargeList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerBaseEntity customerBase,
	        List<CustomerProfileEntity> customerProfileList,List<CustomerRelativesEntity> customerRelativesList,List<CustomerEducatioinEntity> customerEducatioinList,List<CustomerJobEntity> customerJobList,List<CustomerCommonChargeEntity> customerCommonChargeList);
	public void delMain (CustomerBaseEntity customerBase);
	
 	/**
	 * 自定义按钮-sql增强-确认提交
	 * @param id
	 * @return
	 */
	 public boolean doCustomersbtSql(CustomerBaseEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerBaseEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerBaseEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerBaseEntity t);
}
