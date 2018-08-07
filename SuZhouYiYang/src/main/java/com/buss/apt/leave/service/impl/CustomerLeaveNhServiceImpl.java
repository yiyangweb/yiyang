package com.buss.apt.leave.service.impl;
import com.buss.apt.leave.service.CustomerLeaveNhServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.apt.leave.entity.CustomerLeaveNhEntity;
import com.buss.apt.leave.entity.CheckLeaveNhEntity;

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


@Service("customerLeaveNhService")
@Transactional
public class CustomerLeaveNhServiceImpl extends CommonServiceImpl implements CustomerLeaveNhServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerLeaveNhEntity)entity);
 	}
	
	public void addMain(CustomerLeaveNhEntity customerLeaveNh,
	        List<CheckLeaveNhEntity> checkLeaveNhList){
			//保存主信息
			this.save(customerLeaveNh);
		
			/**保存-检查列表*/
			for(CheckLeaveNhEntity checkLeaveNh:checkLeaveNhList){
				//外键设置
				checkLeaveNh.setTzId(customerLeaveNh.getId());
				this.save(checkLeaveNh);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerLeaveNh);
	}

	
	public void updateMain(CustomerLeaveNhEntity customerLeaveNh,
	        List<CheckLeaveNhEntity> checkLeaveNhList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerLeaveNh.getId())){
			try {
				CustomerLeaveNhEntity temp = findUniqueByProperty(CustomerLeaveNhEntity.class, "id", customerLeaveNh.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerLeaveNh, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerLeaveNh);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerLeaveNh.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-检查列表
	    String hql0 = "from CheckLeaveNhEntity where 1 = 1 AND tZ_ID = ? ";
	    List<CheckLeaveNhEntity> checkLeaveNhOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-检查列表
		if(checkLeaveNhList!=null&&checkLeaveNhList.size()>0){
		for(CheckLeaveNhEntity oldE:checkLeaveNhOldList){
			boolean isUpdate = false;
				for(CheckLeaveNhEntity sendE:checkLeaveNhList){
					//需要更新的明细数据-检查列表
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-检查列表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-检查列表
			for(CheckLeaveNhEntity checkLeaveNh:checkLeaveNhList){
				if(oConvertUtils.isEmpty(checkLeaveNh.getId())){
					//外键设置
					checkLeaveNh.setTzId(customerLeaveNh.getId());
					this.save(checkLeaveNh);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerLeaveNh);
	}

	
	public void delMain(CustomerLeaveNhEntity customerLeaveNh) {
		//删除主表信息
		this.delete(customerLeaveNh);
		//===================================================================================
		//获取参数
		Object id0 = customerLeaveNh.getId();
		//===================================================================================
		//删除-检查列表
	    String hql0 = "from CheckLeaveNhEntity where 1 = 1 AND tZ_ID = ? ";
	    List<CheckLeaveNhEntity> checkLeaveNhOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(checkLeaveNhOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerLeaveNhEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerLeaveNhEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerLeaveNhEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerLeaveNhEntity t){
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