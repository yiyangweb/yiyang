package com.buss.apt.stayout.service.impl;
import com.buss.apt.stayout.service.CustomerOutRoomServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.apt.stayout.entity.CustomerOutRoomEntity;
import com.buss.apt.stayout.entity.CheckOutDesEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("customerOutRoomService")
@Transactional
public class CustomerOutRoomServiceImpl extends CommonServiceImpl implements CustomerOutRoomServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerOutRoomEntity)entity);
 	}
	
	public void addMain(CustomerOutRoomEntity customerOutRoom,
	        List<CheckOutDesEntity> checkOutDesList){
			//保存主信息
			this.save(customerOutRoom);
		
			/**保存-检查情况*/
			for(CheckOutDesEntity checkOutDes:checkOutDesList){
				//外键设置
				checkOutDes.setOtId(customerOutRoom.getId());
				this.save(checkOutDes);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerOutRoom);
	}

	
	public void updateMain(CustomerOutRoomEntity customerOutRoom,
	        List<CheckOutDesEntity> checkOutDesList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerOutRoom.getId())){
			try {
				CustomerOutRoomEntity temp = findUniqueByProperty(CustomerOutRoomEntity.class, "id", customerOutRoom.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerOutRoom, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerOutRoom);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerOutRoom.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-检查情况
	    String hql0 = "from CheckOutDesEntity where 1 = 1 AND oT_ID = ? ";
	    List<CheckOutDesEntity> checkOutDesOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-检查情况
		if(checkOutDesList!=null&&checkOutDesList.size()>0){
		for(CheckOutDesEntity oldE:checkOutDesOldList){
			boolean isUpdate = false;
				for(CheckOutDesEntity sendE:checkOutDesList){
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
			for(CheckOutDesEntity checkOutDes:checkOutDesList){
				if(oConvertUtils.isEmpty(checkOutDes.getId())){
					//外键设置
					checkOutDes.setOtId(customerOutRoom.getId());
					this.save(checkOutDes);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerOutRoom);
	}

	
	public void delMain(CustomerOutRoomEntity customerOutRoom) {
		//删除主表信息
		this.delete(customerOutRoom);
		//===================================================================================
		//获取参数
		Object id0 = customerOutRoom.getId();
		//===================================================================================
		//删除-检查情况
	    String hql0 = "from CheckOutDesEntity where 1 = 1 AND oT_ID = ? ";
	    List<CheckOutDesEntity> checkOutDesOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(checkOutDesOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doOut_putSql(CustomerOutRoomEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_out_room set out_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-同意退房
	 * @param id
	 * @return
	 */
	 public boolean doOut_passSql(CustomerOutRoomEntity t,String auditor,String now){
	 	//sql修改退房单状态未已退房
	 	String sqlEnhance_1 ="update customer_out_room set out_status = '3',auditor='"+auditor+"',audit_date=GETDATE(),audit_des='同意' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));

	 	//sql修改房间状态
		 String sqlEnhance_2 ="update base_building_room set status = '1' where  id = '#{room_id}' ";
		 this.executeSql(replaceVal(sqlEnhance_2,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-退回
	 * @param id
	 * @return
	 */
	 public boolean doOut_returnSql(CustomerOutRoomEntity t,String auditor,String now){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_out_room set out_status = '4' ,auditor='"+auditor+"',audit_date=GETDATE(),audit_des='不同意' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerOutRoomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerOutRoomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerOutRoomEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerOutRoomEntity t){
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
 		sql  = sql.replace("#{out_status}",String.valueOf(t.getOutStatus()));
 		sql  = sql.replace("#{check_info}",String.valueOf(t.getCheckInfo()));
 		sql  = sql.replace("#{is_change}",String.valueOf(t.getIsChange()));
 		sql  = sql.replace("#{in_charge}",String.valueOf(t.getInCharge()));
 		sql  = sql.replace("#{deal_date}",String.valueOf(t.getDealDate()));
 		sql  = sql.replace("#{auditor}",String.valueOf(t.getAuditor()));
 		sql  = sql.replace("#{audit_date}",String.valueOf(t.getAuditDate()));
 		sql  = sql.replace("#{audit_des}",String.valueOf(t.getAuditDes()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}