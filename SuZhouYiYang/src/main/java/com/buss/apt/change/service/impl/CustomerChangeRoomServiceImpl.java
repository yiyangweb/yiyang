package com.buss.apt.change.service.impl;
import com.buss.apt.change.service.CustomerChangeRoomServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.apt.change.entity.CustomerChangeRoomEntity;
import com.buss.apt.change.entity.CheckChangeDesEntity;
import com.buss.apt.change.entity.ChangeRoomFeeEntity;

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


@Service("customerChangeRoomService")
@Transactional
public class CustomerChangeRoomServiceImpl extends CommonServiceImpl implements CustomerChangeRoomServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerChangeRoomEntity)entity);
 	}
	
	public void addMain(CustomerChangeRoomEntity customerChangeRoom,
	        List<CheckChangeDesEntity> checkChangeDesList,List<ChangeRoomFeeEntity> changeRoomFeeList){
			//保存主信息
			this.save(customerChangeRoom);
		
			/**保存-换房检查*/
			for(CheckChangeDesEntity checkChangeDes:checkChangeDesList){
				//外键设置
				checkChangeDes.setJhId(customerChangeRoom.getId());
				this.save(checkChangeDes);
			}
			/**保存-退缴费情况*/
			for(ChangeRoomFeeEntity changeRoomFee:changeRoomFeeList){
				//外键设置
				changeRoomFee.setChangeId(customerChangeRoom.getId());
				this.save(changeRoomFee);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerChangeRoom);
	}

	
	public void updateMain(CustomerChangeRoomEntity customerChangeRoom,
	        List<CheckChangeDesEntity> checkChangeDesList,List<ChangeRoomFeeEntity> changeRoomFeeList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerChangeRoom.getId())){
			try {
				CustomerChangeRoomEntity temp = findUniqueByProperty(CustomerChangeRoomEntity.class, "id", customerChangeRoom.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerChangeRoom, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerChangeRoom);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerChangeRoom.getId();
		Object id1 = customerChangeRoom.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-换房检查
	    String hql0 = "from CheckChangeDesEntity where 1 = 1 AND jH_ID = ? ";
	    List<CheckChangeDesEntity> checkChangeDesOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-换房检查
		if(checkChangeDesList!=null&&checkChangeDesList.size()>0){
		for(CheckChangeDesEntity oldE:checkChangeDesOldList){
			boolean isUpdate = false;
				for(CheckChangeDesEntity sendE:checkChangeDesList){
					//需要更新的明细数据-换房检查
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-换房检查
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-换房检查
			for(CheckChangeDesEntity checkChangeDes:checkChangeDesList){
				if(oConvertUtils.isEmpty(checkChangeDes.getId())){
					//外键设置
					checkChangeDes.setJhId(customerChangeRoom.getId());
					this.save(checkChangeDes);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-退缴费情况
	    String hql1 = "from ChangeRoomFeeEntity where 1 = 1 AND cHANGE_ID = ? ";
	    List<ChangeRoomFeeEntity> changeRoomFeeOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-退缴费情况
		if(changeRoomFeeList!=null&&changeRoomFeeList.size()>0){
		for(ChangeRoomFeeEntity oldE:changeRoomFeeOldList){
			boolean isUpdate = false;
				for(ChangeRoomFeeEntity sendE:changeRoomFeeList){
					//需要更新的明细数据-退缴费情况
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-退缴费情况
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-退缴费情况
			for(ChangeRoomFeeEntity changeRoomFee:changeRoomFeeList){
				if(oConvertUtils.isEmpty(changeRoomFee.getId())){
					//外键设置
					changeRoomFee.setChangeId(customerChangeRoom.getId());
					this.save(changeRoomFee);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerChangeRoom);
	}

	
	public void delMain(CustomerChangeRoomEntity customerChangeRoom) {
		//删除主表信息
		this.delete(customerChangeRoom);
		//===================================================================================
		//获取参数
		Object id0 = customerChangeRoom.getId();
		Object id1 = customerChangeRoom.getId();
		//===================================================================================
		//删除-换房检查
	    String hql0 = "from CheckChangeDesEntity where 1 = 1 AND jH_ID = ? ";
	    List<CheckChangeDesEntity> checkChangeDesOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(checkChangeDesOldList);
		//===================================================================================
		//删除-退缴费情况
	    String hql1 = "from ChangeRoomFeeEntity where 1 = 1 AND cHANGE_ID = ? ";
	    List<ChangeRoomFeeEntity> changeRoomFeeOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(changeRoomFeeOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(CustomerChangeRoomEntity t){
	 	//sql增强第1条 -- 修改换房状态
	 	String sqlEnhance_1 ="update customer_change_room set status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
		//sql增强第2条 -- 锁定房间状态
		String sqlEnhance_2 ="update base_building_room set status = '5' where id = '#{new_room_id}'";
		this.executeSql(replaceVal(sqlEnhance_2,t));
		 /**
		String sqlEnhance_3 = "select ((select sum(cast(fee_num as [float])) from change_room_fee where change_id ='#{id}' and fee_type = 2)" +
				"- (select sum(cast(fee_num as [float])) from change_room_fee where change_id ='#{id}' and fee_type = 1))";
		List<Float> result = this.findHql(sqlEnhance_3);

		String uuid = UUID.randomUUID().toString();

		if(result.get(0) > 0){ //收费单
			//sql增强第4条 -- 生成收费单
			String sqlEnhance_4 ="INSERT into fee_bill" +
					"(id,create_name,create_by,create_date,update_name,update_by,update_date,sys_org_code,sys_company_code,[no],name," +
					"customer_no,customer_name,belong_to,belong_dept,fb_status,fee_origin_type,fee_origin_id,total_fee)" +
					"select '' id, create_name, create_by, GETDATE() create_date, update_name, update_by, GETDATE() update_date, sys_org_code, sys_company_code, dbo.fun_bill_no('FB') no, '公寓换房缴费' name, " +
					"customer_no, customer_name, belong_to, sys_org_code, '2' fb_status,'3' fee_origin_type,cr.id fee_origin_id, CAST("+result.get(0)+" as [varchar])" +
					"FROM customer_change_room cr";
			this.executeSql(replaceVal(sqlEnhance_4,t));
			//sql增强第5条 -- 生成收费单收费列表
			String sqlEnhance_5 ="";//TODO
			this.executeSql(replaceVal(sqlEnhance_5,t));
		}else if(result.get(0) < 0){ //退费单
			//sql增强第6条 -- 生成退费单
			String sqlEnhance_6 ="";//TODO
			this.executeSql(replaceVal(sqlEnhance_6,t));
		}else{ //直接换房成功
			//TODO
		}*/
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerChangeRoomEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerChangeRoomEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerChangeRoomEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerChangeRoomEntity t){
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
 		sql  = sql.replace("#{origin_id}",String.valueOf(t.getOriginId()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{origin_room_id}",String.valueOf(t.getOriginRoomId()));
 		sql  = sql.replace("#{origin_room}",String.valueOf(t.getOriginRoom()));
 		sql  = sql.replace("#{origin_building_id}",String.valueOf(t.getOriginBuildingId()));
 		sql  = sql.replace("#{origin_building_name}",String.valueOf(t.getOriginBuildingName()));
 		sql  = sql.replace("#{new_room_id}",String.valueOf(t.getNewRoomId()));
 		sql  = sql.replace("#{new_room_name}",String.valueOf(t.getNewRoomName()));
 		sql  = sql.replace("#{new_building_id}",String.valueOf(t.getNewBuildingId()));
 		sql  = sql.replace("#{new_building_name}",String.valueOf(t.getNewBuildingName()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{in_charge}",String.valueOf(t.getInCharge()));
 		sql  = sql.replace("#{deal_date}",String.valueOf(t.getDealDate()));
 		sql  = sql.replace("#{auditor}",String.valueOf(t.getAuditor()));
 		sql  = sql.replace("#{audit_date}",String.valueOf(t.getAuditDate()));
 		sql  = sql.replace("#{audit_des}",String.valueOf(t.getAuditDes()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}