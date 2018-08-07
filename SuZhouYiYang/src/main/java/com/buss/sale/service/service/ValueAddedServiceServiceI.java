package com.buss.sale.service.service;
import com.buss.sale.service.entity.ValueAddedServiceEntity;
import com.buss.sale.service.entity.ChargeListServiceEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ValueAddedServiceServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ValueAddedServiceEntity valueAddedService,
	        List<ChargeListServiceEntity> chargeListServiceList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ValueAddedServiceEntity valueAddedService,
	        List<ChargeListServiceEntity> chargeListServiceList);
	public void delMain (ValueAddedServiceEntity valueAddedService);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(ValueAddedServiceEntity t);
 	/**
	 * 自定义按钮-sql增强-完成
	 * @param id
	 * @return
	 */
	 public boolean doCompleteSql(ValueAddedServiceEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ValueAddedServiceEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ValueAddedServiceEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ValueAddedServiceEntity t);
}
