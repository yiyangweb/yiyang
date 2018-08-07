package com.buss.base.meter.service;
import com.buss.base.meter.entity.MeterInfoEntity;
import com.buss.base.meter.entity.MeterReadingRecordEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface MeterInfoServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(MeterInfoEntity meterInfo,
	        List<MeterReadingRecordEntity> meterReadingRecordList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(MeterInfoEntity meterInfo,
	        List<MeterReadingRecordEntity> meterReadingRecordList);
	public void delMain (MeterInfoEntity meterInfo);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MeterInfoEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MeterInfoEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MeterInfoEntity t);
}
