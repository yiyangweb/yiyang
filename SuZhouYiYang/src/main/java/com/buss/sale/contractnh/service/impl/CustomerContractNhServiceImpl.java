package com.buss.sale.contractnh.service.impl;
import com.buss.sale.contractnh.service.CustomerContractNhServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.sale.contractnh.entity.CustomerContractNhEntity;
import com.buss.sale.contractnh.entity.ContractNhChargeListEntity;
import com.buss.sale.contractnh.entity.CustomerContractNhSubEntity;

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


@Service("customerContractNhService")
@Transactional
public class CustomerContractNhServiceImpl extends CommonServiceImpl implements CustomerContractNhServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerContractNhEntity)entity);
 	}
	
	public void addMain(CustomerContractNhEntity customerContractNh,
	        List<ContractNhChargeListEntity> contractNhChargeListList,List<CustomerContractNhSubEntity> customerContractNhSubList){
			//保存主信息
			this.save(customerContractNh);
		
			/**保存-收费列表*/
			for(ContractNhChargeListEntity contractNhChargeList:contractNhChargeListList){
				//外键设置
				contractNhChargeList.setContractNhId(customerContractNh.getId());
				this.save(contractNhChargeList);
			}
			/**保存-附属合同*/
			for(CustomerContractNhSubEntity customerContractNhSub:customerContractNhSubList){
				//外键设置
				customerContractNhSub.setContractId(customerContractNh.getId());
				this.save(customerContractNhSub);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerContractNh);
	}

	
	public void updateMain(CustomerContractNhEntity customerContractNh,
	        List<ContractNhChargeListEntity> contractNhChargeListList,List<CustomerContractNhSubEntity> customerContractNhSubList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerContractNh.getId())){
			try {
				CustomerContractNhEntity temp = findUniqueByProperty(CustomerContractNhEntity.class, "id", customerContractNh.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerContractNh, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerContractNh);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerContractNh.getId();
		Object id1 = customerContractNh.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-收费列表
	    String hql0 = "from ContractNhChargeListEntity where 1 = 1 AND cONTRACT_NH_ID = ? ";
	    List<ContractNhChargeListEntity> contractNhChargeListOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-收费列表
		if(contractNhChargeListList!=null&&contractNhChargeListList.size()>0){
		for(ContractNhChargeListEntity oldE:contractNhChargeListOldList){
			boolean isUpdate = false;
				for(ContractNhChargeListEntity sendE:contractNhChargeListList){
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
			for(ContractNhChargeListEntity contractNhChargeList:contractNhChargeListList){
				if(oConvertUtils.isEmpty(contractNhChargeList.getId())){
					//外键设置
					contractNhChargeList.setContractNhId(customerContractNh.getId());
					this.save(contractNhChargeList);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-附属合同
	    String hql1 = "from CustomerContractNhSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<CustomerContractNhSubEntity> customerContractNhSubOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-附属合同
		if(customerContractNhSubList!=null&&customerContractNhSubList.size()>0){
		for(CustomerContractNhSubEntity oldE:customerContractNhSubOldList){
			boolean isUpdate = false;
				for(CustomerContractNhSubEntity sendE:customerContractNhSubList){
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
			for(CustomerContractNhSubEntity customerContractNhSub:customerContractNhSubList){
				if(oConvertUtils.isEmpty(customerContractNhSub.getId())){
					//外键设置
					customerContractNhSub.setContractId(customerContractNh.getId());
					this.save(customerContractNhSub);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerContractNh);
	}

	
	public void delMain(CustomerContractNhEntity customerContractNh) {
		//删除主表信息
		this.delete(customerContractNh);
		//===================================================================================
		//获取参数
		Object id0 = customerContractNh.getId();
		Object id1 = customerContractNh.getId();
		//===================================================================================
		//删除-收费列表
	    String hql0 = "from ContractNhChargeListEntity where 1 = 1 AND cONTRACT_NH_ID = ? ";
	    List<ContractNhChargeListEntity> contractNhChargeListOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(contractNhChargeListOldList);
		//===================================================================================
		//删除-附属合同
	    String hql1 = "from CustomerContractNhSubEntity where 1 = 1 AND cONTRACT_ID = ? ";
	    List<CustomerContractNhSubEntity> customerContractNhSubOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(customerContractNhSubOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(CustomerContractNhEntity t){
		 //sql增强第1条 -- 更新合同表
		 String sqlEnhance_1 ="update customer_contract_nh set contract_status = '2' where id = '#{id}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
		 //sql增强第2条 -- 更新房间表
		 String sqlEnhance_2 ="update base_building_bed set status = '3' where id = '#{bed_id}'";
		 this.executeSql(replaceVal(sqlEnhance_2,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param id
	 * @return
	 */
	 public boolean doChargeSql(CustomerContractNhEntity t){
		 //sql增强第1条
		 String sqlEnhance_1 ="update customer_contract_nh set contract_status = '3' where id = '#{id}'";
		 this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerContractNhEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerContractNhEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerContractNhEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerContractNhEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{contract_status}",String.valueOf(t.getContractStatus()));
 		sql  = sql.replace("#{customer_id}",String.valueOf(t.getCustomerId()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{begin_date}",String.valueOf(t.getBeginDate()));
 		sql  = sql.replace("#{end_date}",String.valueOf(t.getEndDate()));
 		sql  = sql.replace("#{sign_date}",String.valueOf(t.getSignDate()));
 		sql  = sql.replace("#{payment_status}",String.valueOf(t.getPaymentStatus()));
 		sql  = sql.replace("#{enabled}",String.valueOf(t.getEnabled()));
 		sql  = sql.replace("#{approved}",String.valueOf(t.getApproved()));
 		sql  = sql.replace("#{deleted}",String.valueOf(t.getDeleted()));
 		sql  = sql.replace("#{charger}",String.valueOf(t.getCharger()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{room_id}",String.valueOf(t.getRoomId()));
 		sql  = sql.replace("#{bed_id}",String.valueOf(t.getBedId()));
 		sql  = sql.replace("#{building_name}",String.valueOf(t.getBuildingName()));
 		sql  = sql.replace("#{room_name}",String.valueOf(t.getRoomName()));
 		sql  = sql.replace("#{bed_name}",String.valueOf(t.getBedName()));
 		sql  = sql.replace("#{unit_price}",String.valueOf(t.getUnitPrice()));
 		sql  = sql.replace("#{nurse_level}",String.valueOf(t.getNurseLevel()));
 		sql  = sql.replace("#{nurse_charge}",String.valueOf(t.getNurseCharge()));
 		sql  = sql.replace("#{attach}",String.valueOf(t.getAttach()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}