package com.buss.sale.hotel.service.impl;
import com.buss.sale.hotel.service.CustomerToHotelServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.sale.hotel.entity.CustomerToHotelEntity;
import com.buss.sale.hotel.entity.ChargeListHotelEntity;

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


@Service("customerToHotelService")
@Transactional
public class CustomerToHotelServiceImpl extends CommonServiceImpl implements CustomerToHotelServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomerToHotelEntity)entity);
 	}
	
	public void addMain(CustomerToHotelEntity customerToHotel,
	        List<ChargeListHotelEntity> chargeListHotelList){
			//保存主信息
			this.save(customerToHotel);
		
			/**保存-收费列表*/
			for(ChargeListHotelEntity chargeListHotel:chargeListHotelList){
				//外键设置
				chargeListHotel.setChId(customerToHotel.getId());
				this.save(chargeListHotel);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(customerToHotel);
	}

	
	public void updateMain(CustomerToHotelEntity customerToHotel,
	        List<ChargeListHotelEntity> chargeListHotelList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(customerToHotel.getId())){
			try {
				CustomerToHotelEntity temp = findUniqueByProperty(CustomerToHotelEntity.class, "id", customerToHotel.getId());
				MyBeanUtils.copyBeanNotNull2Bean(customerToHotel, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(customerToHotel);
		}
		//===================================================================================
		//获取参数
		Object id0 = customerToHotel.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-收费列表
	    String hql0 = "from ChargeListHotelEntity where 1 = 1 AND cH_ID = ? ";
	    List<ChargeListHotelEntity> chargeListHotelOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-收费列表
		if(chargeListHotelList!=null&&chargeListHotelList.size()>0){
		for(ChargeListHotelEntity oldE:chargeListHotelOldList){
			boolean isUpdate = false;
				for(ChargeListHotelEntity sendE:chargeListHotelList){
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
			for(ChargeListHotelEntity chargeListHotel:chargeListHotelList){
				if(oConvertUtils.isEmpty(chargeListHotel.getId())){
					//外键设置
					chargeListHotel.setChId(customerToHotel.getId());
					this.save(chargeListHotel);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(customerToHotel);
	}

	
	public void delMain(CustomerToHotelEntity customerToHotel) {
		//删除主表信息
		this.delete(customerToHotel);
		//===================================================================================
		//获取参数
		Object id0 = customerToHotel.getId();
		//===================================================================================
		//删除-收费列表
	    String hql0 = "from ChargeListHotelEntity where 1 = 1 AND cH_ID = ? ";
	    List<ChargeListHotelEntity> chargeListHotelOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(chargeListHotelOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerToHotelEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerToHotelEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerToHotelEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomerToHotelEntity t){
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
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{customer_id}",String.valueOf(t.getCustomerId()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{cr_status}",String.valueOf(t.getCrStatus()));
 		sql  = sql.replace("#{room_id}",String.valueOf(t.getRoomId()));
 		sql  = sql.replace("#{in_charge}",String.valueOf(t.getInCharge()));
 		sql  = sql.replace("#{in_date}",String.valueOf(t.getInDate()));
 		sql  = sql.replace("#{out_charge}",String.valueOf(t.getOutCharge()));
 		sql  = sql.replace("#{out_date}",String.valueOf(t.getOutDate()));
 		sql  = sql.replace("#{remarks}",String.valueOf(t.getRemarks()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}