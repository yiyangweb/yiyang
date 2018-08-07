package com.buss.sale.service.service.impl;
import com.buss.sale.service.service.ValueAddedServiceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.sale.service.entity.ValueAddedServiceEntity;
import com.buss.sale.service.entity.ChargeListServiceEntity;

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


@Service("valueAddedServiceService")
@Transactional
public class ValueAddedServiceServiceImpl extends CommonServiceImpl implements ValueAddedServiceServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ValueAddedServiceEntity)entity);
 	}
	
	public void addMain(ValueAddedServiceEntity valueAddedService,
	        List<ChargeListServiceEntity> chargeListServiceList){
			//保存主信息
			this.save(valueAddedService);
		
			/**保存-收费列表*/
			for(ChargeListServiceEntity chargeListService:chargeListServiceList){
				//外键设置
				chargeListService.setServiceId(valueAddedService.getId());
				this.save(chargeListService);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(valueAddedService);
	}

	
	public void updateMain(ValueAddedServiceEntity valueAddedService,
	        List<ChargeListServiceEntity> chargeListServiceList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(valueAddedService.getId())){
			try {
				ValueAddedServiceEntity temp = findUniqueByProperty(ValueAddedServiceEntity.class, "id", valueAddedService.getId());
				MyBeanUtils.copyBeanNotNull2Bean(valueAddedService, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(valueAddedService);
		}
		//===================================================================================
		//获取参数
		Object id0 = valueAddedService.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-收费列表
	    String hql0 = "from ChargeListServiceEntity where 1 = 1 AND sERVICE_ID = ? ";
	    List<ChargeListServiceEntity> chargeListServiceOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-收费列表
		if(chargeListServiceList!=null&&chargeListServiceList.size()>0){
		for(ChargeListServiceEntity oldE:chargeListServiceOldList){
			boolean isUpdate = false;
				for(ChargeListServiceEntity sendE:chargeListServiceList){
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
			for(ChargeListServiceEntity chargeListService:chargeListServiceList){
				if(oConvertUtils.isEmpty(chargeListService.getId())){
					//外键设置
					chargeListService.setServiceId(valueAddedService.getId());
					this.save(chargeListService);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(valueAddedService);
	}

	
	public void delMain(ValueAddedServiceEntity valueAddedService) {
		//删除主表信息
		this.delete(valueAddedService);
		//===================================================================================
		//获取参数
		Object id0 = valueAddedService.getId();
		//===================================================================================
		//删除-收费列表
	    String hql0 = "from ChargeListServiceEntity where 1 = 1 AND sERVICE_ID = ? ";
	    List<ChargeListServiceEntity> chargeListServiceOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(chargeListServiceOldList);
	}
	
 	/**
	 * 自定义按钮-sql增强-提交
	 * @param id
	 * @return
	 */
	 public boolean doCommitSql(ValueAddedServiceEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update value_added_service set status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	/**
	 * 自定义按钮-sql增强-完成
	 * @param id
	 * @return
	 */
	 public boolean doCompleteSql(ValueAddedServiceEntity t){
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update value_added_service set status = '4' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	return true;
	 }
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ValueAddedServiceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ValueAddedServiceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ValueAddedServiceEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ValueAddedServiceEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{service_id}",String.valueOf(t.getServiceId()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_room_name}",String.valueOf(t.getCustomerRoomName()));
 		sql  = sql.replace("#{customer_bed_name}",String.valueOf(t.getCustomerBedName()));
 		sql  = sql.replace("#{service_type}",String.valueOf(t.getServiceType()));
 		sql  = sql.replace("#{service_detail}",String.valueOf(t.getServiceDetail()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{customer_id}",String.valueOf(t.getCustomerId()));
 		sql  = sql.replace("#{customer_room_id}",String.valueOf(t.getCustomerRoomId()));
 		sql  = sql.replace("#{customer_bed_id}",String.valueOf(t.getCustomerBedId()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}