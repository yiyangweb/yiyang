package com.buss.sale.hotel.service;
import com.buss.sale.hotel.entity.CustomerToHotelEntity;
import com.buss.sale.hotel.entity.ChargeListHotelEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CustomerToHotelServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomerToHotelEntity customerToHotel,
	        List<ChargeListHotelEntity> chargeListHotelList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomerToHotelEntity customerToHotel,
	        List<ChargeListHotelEntity> chargeListHotelList);
	public void delMain (CustomerToHotelEntity customerToHotel);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomerToHotelEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomerToHotelEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomerToHotelEntity t);
}
