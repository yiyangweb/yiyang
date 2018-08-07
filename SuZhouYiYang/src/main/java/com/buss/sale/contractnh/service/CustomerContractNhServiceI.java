package com.buss.sale.contractnh.service;
import com.buss.sale.contractnh.entity.CustomerContractNhEntity;
import com.buss.sale.contractnh.entity.ContractNhChargeListEntity;
import com.buss.sale.contractnh.entity.CustomerContractNhSubEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerContractNhServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerContractNhEntity customerContractNh,
	        List<ContractNhChargeListEntity> contractNhChargeListList,List<CustomerContractNhSubEntity> customerContractNhSubList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerContractNhEntity customerContractNh,
	        List<ContractNhChargeListEntity> contractNhChargeListList,List<CustomerContractNhSubEntity> customerContractNhSubList);
	public void delMain (CustomerContractNhEntity customerContractNh);
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(CustomerContractNhEntity t);
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param id
	 * @return
	 */
	 public boolean doChargeSql(CustomerContractNhEntity t);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerContractNhEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerContractNhEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerContractNhEntity t);
}
