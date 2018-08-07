package com.buss.sale.contract.service.impl;
import com.buss.sale.contract.service.CustomerContractServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.sale.contract.entity.CustomerContractEntity;
import com.buss.sale.contract.entity.ContractChargeListEntity;
import com.buss.sale.contract.entity.ChargeListEntity;
import com.buss.sale.contract.entity.CustomerContractSubEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("customerContractService")
@Transactional
public class CustomerContractServiceImpl extends CommonServiceImpl implements CustomerContractServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerContractEntity)entity);
 	}
	
	public void addMain(CustomerContractEntity customerContract,
	        List<ContractChargeListEntity> contractChargeListList,List<ChargeListEntity> chargeListList,List<CustomerContractSubEntity> customerContractSubList){
			//保存主信息
			this.save(customerContract);
		
			/**保存-收费列表*/
			for(ContractChargeListEntity contractChargeList:contractChargeListList){
				//外键设置
				contractChargeList.setContractId(customerContract.getId());
				this.save(contractChargeList);
			}
			/**保存-分期情况*/
			for(ChargeListEntity chargeList:chargeListList){
				//外键设置
				chargeList.setContractId(customerContract.getId());
				this.save(chargeList);
			}
			/**保存-附属合同*/
			for(CustomerContractSubEntity customerContractSub:customerContractSubList){
				//外键设置
				customerContractSub.setContractId(customerContract.getId());
				this.save(customerContractSub);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerContract);
	}

	
	public void updateMain(CustomerContractEntity customerContract,
	        List<ContractChargeListEntity> contractChargeListList,List<ChargeListEntity> chargeListList,List<CustomerContractSubEntity> customerContractSubList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerContract.getId())){
			try {
				CustomerContractEntity temp = findUniqueByProperty(CustomerContractEntity.class, "id", customerContract.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerContract, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerContract);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerContract.getId();
		Object id1 = customerContract.getId();
		Object id2 = customerContract.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-收费列表
	    String hql0 = "from ContractChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<ContractChargeListEntity> contractChargeListOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-收费列表
		if(contractChargeListList!=null&&contractChargeListList.size()>0){
		for(ContractChargeListEntity oldE:contractChargeListOldList){
			boolean isUpdate = false;
				for(ContractChargeListEntity sendE:contractChargeListList){
					//需要更新的明细数据-收费列表
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-收费列表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-收费列表
			for(ContractChargeListEntity contractChargeList:contractChargeListList){
				if(oConvertUtils.isEmpty(contractChargeList.getId())){
					//外键设置
					contractChargeList.setContractId(customerContract.getId());
					this.save(contractChargeList);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-分期情况
	    String hql1 = "from ChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<ChargeListEntity> chargeListOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-分期情况
		if(chargeListList!=null&&chargeListList.size()>0){
		for(ChargeListEntity oldE:chargeListOldList){
			boolean isUpdate = false;
				for(ChargeListEntity sendE:chargeListList){
					//需要更新的明细数据-分期情况
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-分期情况
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-分期情况
			for(ChargeListEntity chargeList:chargeListList){
				if(oConvertUtils.isEmpty(chargeList.getId())){
					//外键设置
					chargeList.setContractId(customerContract.getId());
					this.save(chargeList);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-附属合同
	    String hql2 = "from CustomerContractSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<CustomerContractSubEntity> customerContractSubOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-附属合同
		if(customerContractSubList!=null&&customerContractSubList.size()>0){
		for(CustomerContractSubEntity oldE:customerContractSubOldList){
			boolean isUpdate = false;
				for(CustomerContractSubEntity sendE:customerContractSubList){
					//需要更新的明细数据-附属合同
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-附属合同
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-附属合同
			for(CustomerContractSubEntity customerContractSub:customerContractSubList){
				if(oConvertUtils.isEmpty(customerContractSub.getId())){
					//外键设置
					customerContractSub.setContractId(customerContract.getId());
					this.save(customerContractSub);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerContract);
	}

	
	public void delMain(CustomerContractEntity customerContract) {
		//删除主表信息
		this.delete(customerContract);
		//===================================================================================
		//获取参数
		Object id0 = customerContract.getId();
		Object id1 = customerContract.getId();
		Object id2 = customerContract.getId();
		//===================================================================================
		//删除-收费列表
	    String hql0 = "from ContractChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<ContractChargeListEntity> contractChargeListOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(contractChargeListOldList);
		//===================================================================================
		//删除-分期情况
	    String hql1 = "from ChargeListEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<ChargeListEntity> chargeListOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(chargeListOldList);
		//===================================================================================
		//删除-附属合同
	    String hql2 = "from CustomerContractSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<CustomerContractSubEntity> customerContractSubOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(customerContractSubOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doMultiCommitSql(CustomerContractEntity t){
	 	//sql增强第1条 -- 更新合同表
	 	String sqlEnhance_1 ="update customer_contract set contract_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
		//sql增强第2条 -- 更新房间表
		 String sqlEnhance_2 ="update base_building_bed set status = '3' where id = '#{bed_id}'";
		 this.executeSql(replaceVal(sqlEnhance_2,t));
		 //更新顾客状态，签订和合同
		 String sqlEnhance_3 = " update customer_base set customer_status='3' where no='#{customer_no}'";
		 this.executeSql(replaceVal(sqlEnhance_3,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param id
	 * @return
	 */
	 public boolean doChargeSql(CustomerContractEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_contract set contract_status = '3' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerContractEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerContractEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerContractEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerContractEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{customer_id}",String.valueOf(t.getCustomerId()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{contract_type_id}",String.valueOf(t.getContractTypeId()));
 		sql  = sql.replace("#{is_instalments}",String.valueOf(t.getIsInstalments()));
 		sql  = sql.replace("#{num_of_periods}",String.valueOf(t.getNumOfPeriods()));
 		sql  = sql.replace("#{payment_status}",String.valueOf(t.getPaymentStatus()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{building_name}",String.valueOf(t.getBuildingName()));
 		sql  = sql.replace("#{room_id}",String.valueOf(t.getRoomId()));
 		sql  = sql.replace("#{room_name}",String.valueOf(t.getRoomName()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{sign_date}",String.valueOf(t.getSignDate()));
 		sql  = sql.replace("#{contract_status}",String.valueOf(t.getContractStatus()));
 		sql  = sql.replace("#{begin_date}",String.valueOf(t.getBeginDate()));
 		sql  = sql.replace("#{end_date}",String.valueOf(t.getEndDate()));
 		sql  = sql.replace("#{charger}",String.valueOf(t.getCharger()));
 		sql  = sql.replace("#{enabled}",String.valueOf(t.getEnabled()));
 		sql  = sql.replace("#{approved}",String.valueOf(t.getApproved()));
 		sql  = sql.replace("#{deleted}",String.valueOf(t.getDeleted()));
 		sql  = sql.replace("#{attach}",String.valueOf(t.getAttach()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}