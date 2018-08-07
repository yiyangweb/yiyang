package com.buss.apt.stayin.service.impl;
import com.buss.apt.stayin.service.CustomerToRoomServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.apt.stayin.entity.CustomerToRoomEntity;
import com.buss.apt.stayin.entity.CheckListDesEntity;
import com.buss.apt.stayin.entity.CustomerTrainInfoEntity;
import com.buss.apt.stayin.entity.CustomerRoomDesEntity;

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


@Service("customerToRoomService")
@Transactional
public class CustomerToRoomServiceImpl extends CommonServiceImpl implements CustomerToRoomServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerToRoomEntity)entity);
 	}
	
	public void addMain(CustomerToRoomEntity customerToRoom,
	        List<CheckListDesEntity> checkListDesList,List<CustomerTrainInfoEntity> customerTrainInfoList,List<CustomerRoomDesEntity> customerRoomDesList){
			//保存主信息
			this.save(customerToRoom);
		
			/**保存-入住检查*/
			for(CheckListDesEntity checkListDes:checkListDesList){
				//外键设置
				checkListDes.setCrId(customerToRoom.getId());
				this.save(checkListDes);
			}
			/**保存-入住培训*/
			for(CustomerTrainInfoEntity customerTrainInfo:customerTrainInfoList){
				//外键设置
				customerTrainInfo.setCrId(customerToRoom.getId());
				this.save(customerTrainInfo);
			}
			/**保存-入住情况*/
			for(CustomerRoomDesEntity customerRoomDes:customerRoomDesList){
				//外键设置
				customerRoomDes.setInId(customerToRoom.getId());
				this.save(customerRoomDes);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerToRoom);
	}

	
	public void updateMain(CustomerToRoomEntity customerToRoom,
	        List<CheckListDesEntity> checkListDesList,List<CustomerTrainInfoEntity> customerTrainInfoList,List<CustomerRoomDesEntity> customerRoomDesList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerToRoom.getId())){
			try {
				CustomerToRoomEntity temp = findUniqueByProperty(CustomerToRoomEntity.class, "id", customerToRoom.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerToRoom, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerToRoom);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerToRoom.getId();
		Object id1 = customerToRoom.getId();
		Object id2 = customerToRoom.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-入住检查
	    String hql0 = "from CheckListDesEntity where 1 = 1 AND cR_ID = ? ";
	    List<CheckListDesEntity> checkListDesOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-入住检查
		if(checkListDesList!=null&&checkListDesList.size()>0){
		for(CheckListDesEntity oldE:checkListDesOldList){
			boolean isUpdate = false;
				for(CheckListDesEntity sendE:checkListDesList){
					//需要更新的明细数据-入住检查
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-入住检查
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-入住检查
			for(CheckListDesEntity checkListDes:checkListDesList){
				if(oConvertUtils.isEmpty(checkListDes.getId())){
					//外键设置
					checkListDes.setCrId(customerToRoom.getId());
					this.save(checkListDes);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-入住培训
	    String hql1 = "from CustomerTrainInfoEntity where 1 = 1 AND cR_ID = ? ";
	    List<CustomerTrainInfoEntity> customerTrainInfoOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-入住培训
		if(customerTrainInfoList!=null&&customerTrainInfoList.size()>0){
		for(CustomerTrainInfoEntity oldE:customerTrainInfoOldList){
			boolean isUpdate = false;
				for(CustomerTrainInfoEntity sendE:customerTrainInfoList){
					//需要更新的明细数据-入住培训
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-入住培训
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-入住培训
			for(CustomerTrainInfoEntity customerTrainInfo:customerTrainInfoList){
				if(oConvertUtils.isEmpty(customerTrainInfo.getId())){
					//外键设置
					customerTrainInfo.setCrId(customerToRoom.getId());
					this.save(customerTrainInfo);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-入住情况
	    String hql2 = "from CustomerRoomDesEntity where 1 = 1 AND iN_ID = ? ";
	    List<CustomerRoomDesEntity> customerRoomDesOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-入住情况
		if(customerRoomDesList!=null&&customerRoomDesList.size()>0){
		for(CustomerRoomDesEntity oldE:customerRoomDesOldList){
			boolean isUpdate = false;
				for(CustomerRoomDesEntity sendE:customerRoomDesList){
					//需要更新的明细数据-入住情况
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-入住情况
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-入住情况
			for(CustomerRoomDesEntity customerRoomDes:customerRoomDesList){
				if(oConvertUtils.isEmpty(customerRoomDes.getId())){
					//外键设置
					customerRoomDes.setInId(customerToRoom.getId());
					this.save(customerRoomDes);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerToRoom);
	}

	
	public void delMain(CustomerToRoomEntity customerToRoom) {
		//删除主表信息
		this.delete(customerToRoom);
		//===================================================================================
		//获取参数
		Object id0 = customerToRoom.getId();
		Object id1 = customerToRoom.getId();
		Object id2 = customerToRoom.getId();
		//===================================================================================
		//删除-入住检查
	    String hql0 = "from CheckListDesEntity where 1 = 1 AND cR_ID = ? ";
	    List<CheckListDesEntity> checkListDesOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(checkListDesOldList);
		//===================================================================================
		//删除-入住培训
	    String hql1 = "from CustomerTrainInfoEntity where 1 = 1 AND cR_ID = ? ";
	    List<CustomerTrainInfoEntity> customerTrainInfoOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(customerTrainInfoOldList);
		//===================================================================================
		//删除-入住情况
	    String hql2 = "from CustomerRoomDesEntity where 1 = 1 AND iN_ID = ? ";
	    List<CustomerRoomDesEntity> customerRoomDesOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(customerRoomDesOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(CustomerToRoomEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_to_room set cr_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-确认入住
	 * @param id
	 * @return
	 */
	 public boolean doConfirmSql(CustomerToRoomEntity t){
	 	//sql增强第1条  -- 更新入住表
	 	String sqlEnhance_1 ="update customer_to_room set cr_status = '3' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
		//sql增强第2条  -- 更新房间表
		String sqlEnhance_2 ="update base_building_room set status =('#{stayin_type}'+1) where id = '#{room_id}'";
		this.executeSql(replaceVal(sqlEnhance_2,t));
	 	//sql增强第3条  -- 更新顾客表
	 	String sqlEnhance_3 ="update customer_base set customer_status = '4' where id in (select customer_id from customer_room_des where id = '#{id}')";
	 	this.executeSql(replaceVal(sqlEnhance_3,t));
	 	//sql增强第4条  -- 更新来访表
	 	String sqlEnhance_4 ="update mm_visitor_record set visit_status = '4' where customer_no in (select b.no from customer_room_des a left join customer_base b on a.customer_id = b.id where a.in_id = '#{id}')";
	 	this.executeSql(replaceVal(sqlEnhance_4,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerToRoomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerToRoomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerToRoomEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerToRoomEntity t){
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
 		sql  = sql.replace("#{contract_no}",String.valueOf(t.getContractNo()));
 		sql  = sql.replace("#{customer_id}",String.valueOf(t.getCustomerId()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{building_name}",String.valueOf(t.getBuildingName()));
 		sql  = sql.replace("#{room_id}",String.valueOf(t.getRoomId()));
 		sql  = sql.replace("#{room_name}",String.valueOf(t.getRoomName()));
 		sql  = sql.replace("#{check_info}",String.valueOf(t.getCheckInfo()));
 		sql  = sql.replace("#{cr_status}",String.valueOf(t.getCrStatus()));
 		sql  = sql.replace("#{train_status}",String.valueOf(t.getTrainStatus()));
 		sql  = sql.replace("#{stayin_type}",String.valueOf(t.getStayinType()));
 		sql  = sql.replace("#{in_charge}",String.valueOf(t.getInCharge()));
 		sql  = sql.replace("#{in_date}",String.valueOf(t.getInDate()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}