package com.buss.sale.customer.service.impl;
import com.buss.sale.customer.service.CustomerBaseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.sale.customer.entity.CustomerBaseEntity;
import com.buss.sale.customer.entity.CustomerProfileEntity;
import com.buss.sale.customer.entity.CustomerRelativesEntity;
import com.buss.sale.customer.entity.CustomerEducatioinEntity;
import com.buss.sale.customer.entity.CustomerJobEntity;
import com.buss.sale.customer.entity.CustomerCommonChargeEntity;

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


@Service("customerBaseService")
@Transactional
public class CustomerBaseServiceImpl extends CommonServiceImpl implements CustomerBaseServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerBaseEntity)entity);
 	}
	
	public void addMain(CustomerBaseEntity customerBase,
	        List<CustomerProfileEntity> customerProfileList,List<CustomerRelativesEntity> customerRelativesList,List<CustomerEducatioinEntity> customerEducatioinList,List<CustomerJobEntity> customerJobList,List<CustomerCommonChargeEntity> customerCommonChargeList){
			//保存主信息
			this.save(customerBase);
		
			/**保存-详细信息*/
			for(CustomerProfileEntity customerProfile:customerProfileList){
				//外键设置
				customerProfile.setCustomerId(customerBase.getId());
				this.save(customerProfile);
			}
			/**保存-亲属关系*/
			for(CustomerRelativesEntity customerRelatives:customerRelativesList){
				//外键设置
				customerRelatives.setCustomerId(customerBase.getId());
				this.save(customerRelatives);
			}
			/**保存-教育情况*/
			for(CustomerEducatioinEntity customerEducatioin:customerEducatioinList){
				//外键设置
				customerEducatioin.setCustomerId(customerBase.getId());
				this.save(customerEducatioin);
			}
			/**保存-工作经历*/
			for(CustomerJobEntity customerJob:customerJobList){
				//外键设置
				customerJob.setCustomerId(customerBase.getId());
				this.save(customerJob);
			}
			/**保存-周期收费*/
			for(CustomerCommonChargeEntity customerCommonCharge:customerCommonChargeList){
				//外键设置
				customerCommonCharge.setCustomerId(customerBase.getId());
				this.save(customerCommonCharge);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerBase);
	}

	
	public void updateMain(CustomerBaseEntity customerBase,
	        List<CustomerProfileEntity> customerProfileList,List<CustomerRelativesEntity> customerRelativesList,List<CustomerEducatioinEntity> customerEducatioinList,List<CustomerJobEntity> customerJobList,List<CustomerCommonChargeEntity> customerCommonChargeList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerBase.getId())){
			try {
				CustomerBaseEntity temp = findUniqueByProperty(CustomerBaseEntity.class, "id", customerBase.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerBase, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerBase);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerBase.getId();
		Object id1 = customerBase.getId();
		Object id2 = customerBase.getId();
		Object id3 = customerBase.getId();
		Object id4 = customerBase.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-详细信息
	    String hql0 = "from CustomerProfileEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerProfileEntity> customerProfileOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-详细信息
		if(customerProfileList!=null&&customerProfileList.size()>0){
		for(CustomerProfileEntity oldE:customerProfileOldList){
			boolean isUpdate = false;
				for(CustomerProfileEntity sendE:customerProfileList){
					//需要更新的明细数据-详细信息
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-详细信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-详细信息
			for(CustomerProfileEntity customerProfile:customerProfileList){
				if(oConvertUtils.isEmpty(customerProfile.getId())){
					//外键设置
					customerProfile.setCustomerId(customerBase.getId());
					this.save(customerProfile);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-亲属关系
	    String hql1 = "from CustomerRelativesEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerRelativesEntity> customerRelativesOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-亲属关系
		if(customerRelativesList!=null&&customerRelativesList.size()>0){
		for(CustomerRelativesEntity oldE:customerRelativesOldList){
			boolean isUpdate = false;
				for(CustomerRelativesEntity sendE:customerRelativesList){
					//需要更新的明细数据-亲属关系
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-亲属关系
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-亲属关系
			for(CustomerRelativesEntity customerRelatives:customerRelativesList){
				if(oConvertUtils.isEmpty(customerRelatives.getId())){
					//外键设置
					customerRelatives.setCustomerId(customerBase.getId());
					this.save(customerRelatives);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-教育情况
	    String hql2 = "from CustomerEducatioinEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerEducatioinEntity> customerEducatioinOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-教育情况
		if(customerEducatioinList!=null&&customerEducatioinList.size()>0){
		for(CustomerEducatioinEntity oldE:customerEducatioinOldList){
			boolean isUpdate = false;
				for(CustomerEducatioinEntity sendE:customerEducatioinList){
					//需要更新的明细数据-教育情况
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-教育情况
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-教育情况
			for(CustomerEducatioinEntity customerEducatioin:customerEducatioinList){
				if(oConvertUtils.isEmpty(customerEducatioin.getId())){
					//外键设置
					customerEducatioin.setCustomerId(customerBase.getId());
					this.save(customerEducatioin);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-工作经历
	    String hql3 = "from CustomerJobEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerJobEntity> customerJobOldList = this.findHql(hql3,id3);
		//2.筛选更新明细数据-工作经历
		if(customerJobList!=null&&customerJobList.size()>0){
		for(CustomerJobEntity oldE:customerJobOldList){
			boolean isUpdate = false;
				for(CustomerJobEntity sendE:customerJobList){
					//需要更新的明细数据-工作经历
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-工作经历
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-工作经历
			for(CustomerJobEntity customerJob:customerJobList){
				if(oConvertUtils.isEmpty(customerJob.getId())){
					//外键设置
					customerJob.setCustomerId(customerBase.getId());
					this.save(customerJob);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-周期收费
	    String hql4 = "from CustomerCommonChargeEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerCommonChargeEntity> customerCommonChargeOldList = this.findHql(hql4,id4);
		//2.筛选更新明细数据-周期收费
		if(customerCommonChargeList!=null&&customerCommonChargeList.size()>0){
		for(CustomerCommonChargeEntity oldE:customerCommonChargeOldList){
			boolean isUpdate = false;
				for(CustomerCommonChargeEntity sendE:customerCommonChargeList){
					//需要更新的明细数据-周期收费
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-周期收费
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-周期收费
			for(CustomerCommonChargeEntity customerCommonCharge:customerCommonChargeList){
				if(oConvertUtils.isEmpty(customerCommonCharge.getId())){
					//外键设置
					customerCommonCharge.setCustomerId(customerBase.getId());
					this.save(customerCommonCharge);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerBase);
	}

	
	public void delMain(CustomerBaseEntity customerBase) {
		//删除主表信息
		this.delete(customerBase);
		//===================================================================================
		//获取参数
		Object id0 = customerBase.getId();
		Object id1 = customerBase.getId();
		Object id2 = customerBase.getId();
		Object id3 = customerBase.getId();
		Object id4 = customerBase.getId();
		//===================================================================================
		//删除-详细信息
	    String hql0 = "from CustomerProfileEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerProfileEntity> customerProfileOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(customerProfileOldList);
		//===================================================================================
		//删除-亲属关系
	    String hql1 = "from CustomerRelativesEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerRelativesEntity> customerRelativesOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(customerRelativesOldList);
		//===================================================================================
		//删除-教育情况
	    String hql2 = "from CustomerEducatioinEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerEducatioinEntity> customerEducatioinOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(customerEducatioinOldList);
		//===================================================================================
		//删除-工作经历
	    String hql3 = "from CustomerJobEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerJobEntity> customerJobOldList = this.findHql(hql3,id3);
		this.deleteAllEntitie(customerJobOldList);
		//===================================================================================
		//删除-周期收费
	    String hql4 = "from CustomerCommonChargeEntity where 1 = 1 AND cUSTOMER_ID = ? ";
	    List<CustomerCommonChargeEntity> customerCommonChargeOldList = this.findHql(hql4,id4);
		this.deleteAllEntitie(customerCommonChargeOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-确认提交
	 * @param id
	 * @return
	 */
	 public boolean doCustomersbtSql(CustomerBaseEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_base set customer_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerBaseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerBaseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerBaseEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerBaseEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{id_card_no}",String.valueOf(t.getIdCardNo()));
 		sql  = sql.replace("#{customer_status}",String.valueOf(t.getCustomerStatus()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}