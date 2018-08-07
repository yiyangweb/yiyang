package com.buss.sale.contract.service;
import com.buss.sale.contract.entity.CustomerContractEntity;
import com.buss.sale.contract.entity.ContractChargeListEntity;
import com.buss.sale.contract.entity.ChargeListEntity;
import com.buss.sale.contract.entity.CustomerContractSubEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerContractServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerContractEntity customerContract,
	        List<ContractChargeListEntity> contractChargeListList,List<ChargeListEntity> chargeListList,List<CustomerContractSubEntity> customerContractSubList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerContractEntity customerContract,
	        List<ContractChargeListEntity> contractChargeListList,List<ChargeListEntity> chargeListList,List<CustomerContractSubEntity> customerContractSubList);
	public void delMain (CustomerContractEntity customerContract);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doMultiCommitSql(CustomerContractEntity t);
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param id
	 * @return
	 */
	 public boolean doChargeSql(CustomerContractEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerContractEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerContractEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerContractEntity t);
}
