package com.buss.apt.feebill.service.impl;
import com.buss.apt.feebill.service.FeeBillServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.apt.feebill.entity.FeeBillEntity;
import com.buss.apt.feebill.entity.CustomerFeeDesEntity;
import com.buss.apt.feebill.entity.PaymentListEntity;

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


@Service("feeBillService")
@Transactional
public class FeeBillServiceImpl extends CommonServiceImpl implements FeeBillServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((FeeBillEntity)entity);
 	}
	
	public void addMain(FeeBillEntity feeBill,
	        List<CustomerFeeDesEntity> customerFeeDesList,List<PaymentListEntity> paymentListList){
			//保存主信息
			this.save(feeBill);
		
			/**保存-收费详细*/
			for(CustomerFeeDesEntity customerFeeDes:customerFeeDesList){
				//外键设置
				customerFeeDes.setFeeBillId(feeBill.getId());
				this.save(customerFeeDes);
			}
			/**保存-缴费详情*/
			for(PaymentListEntity paymentList:paymentListList){
				//外键设置
				paymentList.setBillId(feeBill.getId());
				this.save(paymentList);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(feeBill);
	}

	
	public void updateMain(FeeBillEntity feeBill,
	        List<CustomerFeeDesEntity> customerFeeDesList,List<PaymentListEntity> paymentListList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(feeBill.getId())){
			try {
				FeeBillEntity temp = findUniqueByProperty(FeeBillEntity.class, "id", feeBill.getId());
				MyBeanUtils.copyBeanNotNull2Bean(feeBill, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(feeBill);
		}
		//===================================================================================
		//获取参数
		Object id0 = feeBill.getId();
		Object id1 = feeBill.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-收费详细
	    String hql0 = "from CustomerFeeDesEntity where 1 = 1 AND fEE_BILL_ID = ? ";
	    List<CustomerFeeDesEntity> customerFeeDesOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-收费详细
		if(customerFeeDesList!=null&&customerFeeDesList.size()>0){
		for(CustomerFeeDesEntity oldE:customerFeeDesOldList){
			boolean isUpdate = false;
				for(CustomerFeeDesEntity sendE:customerFeeDesList){
					//需要更新的明细数据-收费详细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-收费详细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-收费详细
			for(CustomerFeeDesEntity customerFeeDes:customerFeeDesList){
				if(oConvertUtils.isEmpty(customerFeeDes.getId())){
					//外键设置
					customerFeeDes.setFeeBillId(feeBill.getId());
					this.save(customerFeeDes);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-缴费详情
	    String hql1 = "from PaymentListEntity where 1 = 1 AND bILL_ID = ? ";
	    List<PaymentListEntity> paymentListOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-缴费详情
		if(paymentListList!=null&&paymentListList.size()>0){
		for(PaymentListEntity oldE:paymentListOldList){
			boolean isUpdate = false;
				for(PaymentListEntity sendE:paymentListList){
					//需要更新的明细数据-缴费详情
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-缴费详情
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-缴费详情
			for(PaymentListEntity paymentList:paymentListList){
				if(oConvertUtils.isEmpty(paymentList.getId())){
					//外键设置
					paymentList.setBillId(feeBill.getId());
					this.save(paymentList);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(feeBill,paymentListList);
	}

	
	public void delMain(FeeBillEntity feeBill) {
		//删除主表信息
		this.delete(feeBill);
		//===================================================================================
		//获取参数
		Object id0 = feeBill.getId();
		Object id1 = feeBill.getId();
		//===================================================================================
		//删除-收费详细
	    String hql0 = "from CustomerFeeDesEntity where 1 = 1 AND fEE_BILL_ID = ? ";
	    List<CustomerFeeDesEntity> customerFeeDesOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(customerFeeDesOldList);
		//===================================================================================
		//删除-缴费详情
	    String hql1 = "from PaymentListEntity where 1 = 1 AND bILL_ID = ? ";
	    List<PaymentListEntity> paymentListOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(paymentListOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(FeeBillEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update fee_bill set fb_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-同意
	 * @param id
	 * @return
	 */
	 public boolean doOk_feeSql(FeeBillEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update fee_bill set fb_status = '3' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-不同意
	 * @param id
	 * @return
	 */
	 public boolean doNo_feeSql(FeeBillEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update fee_bill set fb_status = '6' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-缴费
	 * @param id
	 * @return
	 */
	 public boolean doReceiveSql(FeeBillEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update fee_bill set fb_status = '4' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-归档
	 * @param id
	 * @return
	 */
	 public boolean doArchiveSql(FeeBillEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update fee_bill set fb_status = '5' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(FeeBillEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(FeeBillEntity t,List<PaymentListEntity> paymentListList){

 		Double total = Double.valueOf(t.getTotalFee());
		Double moneyList = 0.0;
		for(PaymentListEntity payment:paymentListList) {
			moneyList += Double.valueOf(payment.getMoney());
		}
		if(total.equals(moneyList)){ //价格总和对
			String sqlEnhance_1 ="update fee_bill set fb_status = '4' where id = '#{id}'";
			this.executeSql(replaceVal(sqlEnhance_1,t));
			//更新公寓合同状态
			String sqlEnhance_2 ="update customer_contract set contract_status = '3' where '#{fee_origin_type}' = '1' and '#{belong_to}'  = '1' and id = '#{fee_origin_id}'";
			this.executeSql(replaceVal(sqlEnhance_2,t));
			//更新护理院合同状态
			String sqlEnhance_3 ="update customer_contract_nh set contract_status = '3' where '#{fee_origin_type}' = '1' and '#{belong_to}'  = '2' and id = '#{fee_origin_id}'";
			this.executeSql(replaceVal(sqlEnhance_3,t));
		}
 		return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(FeeBillEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,FeeBillEntity t){
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
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{total_fee}",String.valueOf(t.getTotalFee()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{belong_dept}",String.valueOf(t.getBelongDept()));
 		sql  = sql.replace("#{fb_status}",String.valueOf(t.getFbStatus()));
 		sql  = sql.replace("#{charger}",String.valueOf(t.getCharger()));
 		sql  = sql.replace("#{deal_date}",String.valueOf(t.getDealDate()));
 		sql  = sql.replace("#{auditor}",String.valueOf(t.getAuditor()));
 		sql  = sql.replace("#{auditor_date}",String.valueOf(t.getAuditorDate()));
 		sql  = sql.replace("#{auditor_des}",String.valueOf(t.getAuditorDes()));
 		sql  = sql.replace("#{remarks}",String.valueOf(t.getRemarks()));
		sql  = sql.replace("#{fee_origin_type}",String.valueOf(t.getFeeOriginType()));
		sql  = sql.replace("#{fee_origin_id}",String.valueOf(t.getFeeOriginId()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}