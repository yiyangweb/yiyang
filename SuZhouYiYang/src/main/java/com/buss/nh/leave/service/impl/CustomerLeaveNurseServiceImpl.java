package com.buss.nh.leave.service.impl;
import com.buss.nh.leave.service.CustomerLeaveNurseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.nh.leave.entity.CustomerLeaveNurseEntity;
import com.buss.nh.leave.entity.MoneyLeaveNurseEntity;
import com.buss.nh.leave.entity.CheckLeaveNurseEntity;

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


@Service("customerLeaveNurseService")
@Transactional
public class CustomerLeaveNurseServiceImpl extends CommonServiceImpl implements CustomerLeaveNurseServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerLeaveNurseEntity)entity);
 	}
	
	public void addMain(CustomerLeaveNurseEntity customerLeaveNurse,
	        List<MoneyLeaveNurseEntity> moneyLeaveNurseList,List<CheckLeaveNurseEntity> checkLeaveNurseList){
			//保存主信息
			this.save(customerLeaveNurse);
		
			/**保存-相关费用*/
			for(MoneyLeaveNurseEntity moneyLeaveNurse:moneyLeaveNurseList){
				//外键设置
				moneyLeaveNurse.setLeaveId(customerLeaveNurse.getId());
				this.save(moneyLeaveNurse);
			}
			/**保存-检查情况*/
			for(CheckLeaveNurseEntity checkLeaveNurse:checkLeaveNurseList){
				//外键设置
				checkLeaveNurse.setLeaveId(customerLeaveNurse.getId());
				this.save(checkLeaveNurse);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerLeaveNurse);
	}

	
	public void updateMain(CustomerLeaveNurseEntity customerLeaveNurse,
	        List<MoneyLeaveNurseEntity> moneyLeaveNurseList,List<CheckLeaveNurseEntity> checkLeaveNurseList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerLeaveNurse.getId())){
			try {
				CustomerLeaveNurseEntity temp = findUniqueByProperty(CustomerLeaveNurseEntity.class, "id", customerLeaveNurse.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerLeaveNurse, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerLeaveNurse);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerLeaveNurse.getId();
		Object id1 = customerLeaveNurse.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-相关费用
	    String hql0 = "from MoneyLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    List<MoneyLeaveNurseEntity> moneyLeaveNurseOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-相关费用
		if(moneyLeaveNurseList!=null&&moneyLeaveNurseList.size()>0){
		for(MoneyLeaveNurseEntity oldE:moneyLeaveNurseOldList){
			boolean isUpdate = false;
				for(MoneyLeaveNurseEntity sendE:moneyLeaveNurseList){
					//需要更新的明细数据-相关费用
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-相关费用
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-相关费用
			for(MoneyLeaveNurseEntity moneyLeaveNurse:moneyLeaveNurseList){
				if(oConvertUtils.isEmpty(moneyLeaveNurse.getId())){
					//外键设置
					moneyLeaveNurse.setLeaveId(customerLeaveNurse.getId());
					this.save(moneyLeaveNurse);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-检查情况
	    String hql1 = "from CheckLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    List<CheckLeaveNurseEntity> checkLeaveNurseOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-检查情况
		if(checkLeaveNurseList!=null&&checkLeaveNurseList.size()>0){
		for(CheckLeaveNurseEntity oldE:checkLeaveNurseOldList){
			boolean isUpdate = false;
				for(CheckLeaveNurseEntity sendE:checkLeaveNurseList){
					//需要更新的明细数据-检查情况
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-检查情况
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-检查情况
			for(CheckLeaveNurseEntity checkLeaveNurse:checkLeaveNurseList){
				if(oConvertUtils.isEmpty(checkLeaveNurse.getId())){
					//外键设置
					checkLeaveNurse.setLeaveId(customerLeaveNurse.getId());
					this.save(checkLeaveNurse);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerLeaveNurse);
	}

	
	public void delMain(CustomerLeaveNurseEntity customerLeaveNurse) {
		//删除主表信息
		this.delete(customerLeaveNurse);
		//===================================================================================
		//获取参数
		Object id0 = customerLeaveNurse.getId();
		Object id1 = customerLeaveNurse.getId();
		//===================================================================================
		//删除-相关费用
	    String hql0 = "from MoneyLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    List<MoneyLeaveNurseEntity> moneyLeaveNurseOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(moneyLeaveNurseOldList);
		//===================================================================================
		//删除-检查情况
	    String hql1 = "from CheckLeaveNurseEntity where 1 = 1 AND lEAVE_ID = ? ";
	    List<CheckLeaveNurseEntity> checkLeaveNurseOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(checkLeaveNurseOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doLeave_sbtSql(CustomerLeaveNurseEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_leave_nurse set leave_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-同意
	 * @param id
	 * @return
	 */
	 public boolean doLeave_passSql(CustomerLeaveNurseEntity t,String userName){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_leave_nurse set leave_status = '3',audit='"+userName+"',audit_date=GETDATE(),audit_des='同意' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-不同意
	 * @param id
	 * @return
	 */
	 public boolean doLeave_noSql(CustomerLeaveNurseEntity t,String userName){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_leave_nurse set leave_status = '5',audit='"+userName+"',audit_date=GETDATE(),audit_des='不同意' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-确认退住
	 * @param id
	 * @return
	 */
	 public boolean doLeave_confirmSql(CustomerLeaveNurseEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_leave_nurse set leave_status = '4' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerLeaveNurseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerLeaveNurseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerLeaveNurseEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerLeaveNurseEntity t){
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
 		sql  = sql.replace("#{stayin_id}",String.valueOf(t.getStayinId()));
 		sql  = sql.replace("#{room_id}",String.valueOf(t.getRoomId()));
 		sql  = sql.replace("#{room_name}",String.valueOf(t.getRoomName()));
 		sql  = sql.replace("#{bed_id}",String.valueOf(t.getBedId()));
 		sql  = sql.replace("#{bed_name}",String.valueOf(t.getBedName()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{leave_status}",String.valueOf(t.getLeaveStatus()));
 		sql  = sql.replace("#{in_charge}",String.valueOf(t.getInCharge()));
 		sql  = sql.replace("#{deal_date}",String.valueOf(t.getDealDate()));
 		sql  = sql.replace("#{auditor}",String.valueOf(t.getAuditor()));
 		sql  = sql.replace("#{audit_date}",String.valueOf(t.getAuditDate()));
 		sql  = sql.replace("#{audit_des}",String.valueOf(t.getAuditDes()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}