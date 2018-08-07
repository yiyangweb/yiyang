package com.buss.base.meter.service.impl;
import com.buss.base.meter.service.MeterInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.base.meter.entity.MeterInfoEntity;
import com.buss.base.meter.entity.MeterReadingRecordEntity;

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


@Service("meterInfoService")
@Transactional
public class MeterInfoServiceImpl extends CommonServiceImpl implements MeterInfoServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((MeterInfoEntity)entity);
 	}
	
	public void addMain(MeterInfoEntity meterInfo,
	        List<MeterReadingRecordEntity> meterReadingRecordList){
			//保存主信息
			this.save(meterInfo);
		
			/**保存-水电抄表记录*/
			for(MeterReadingRecordEntity meterReadingRecord:meterReadingRecordList){
				//外键设置
				meterReadingRecord.setMeterId(meterInfo.getId());
				this.save(meterReadingRecord);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(meterInfo);
	}

	
	public void updateMain(MeterInfoEntity meterInfo,
	        List<MeterReadingRecordEntity> meterReadingRecordList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(meterInfo.getId())){
			try {
				MeterInfoEntity temp = findUniqueByProperty(MeterInfoEntity.class, "id", meterInfo.getId());
				MyBeanUtils.copyBeanNotNull2Bean(meterInfo, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(meterInfo);
		}
		//===================================================================================
		//获取参数
		Object id0 = meterInfo.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-水电抄表记录
	    String hql0 = "from MeterReadingRecordEntity where 1 = 1 AND mETER_ID = ? ";
	    List<MeterReadingRecordEntity> meterReadingRecordOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-水电抄表记录
		if(meterReadingRecordList!=null&&meterReadingRecordList.size()>0){
		for(MeterReadingRecordEntity oldE:meterReadingRecordOldList){
			boolean isUpdate = false;
				for(MeterReadingRecordEntity sendE:meterReadingRecordList){
					//需要更新的明细数据-水电抄表记录
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-水电抄表记录
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-水电抄表记录
			for(MeterReadingRecordEntity meterReadingRecord:meterReadingRecordList){
				if(oConvertUtils.isEmpty(meterReadingRecord.getId())){
					//外键设置
					meterReadingRecord.setMeterId(meterInfo.getId());
					this.save(meterReadingRecord);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(meterInfo);
	}

	
	public void delMain(MeterInfoEntity meterInfo) {
		//删除主表信息
		this.delete(meterInfo);
		//===================================================================================
		//获取参数
		Object id0 = meterInfo.getId();
		//===================================================================================
		//删除-水电抄表记录
	    String hql0 = "from MeterReadingRecordEntity where 1 = 1 AND mETER_ID = ? ";
	    List<MeterReadingRecordEntity> meterReadingRecordOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(meterReadingRecordOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(MeterInfoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(MeterInfoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(MeterInfoEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,MeterInfoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{meter_type}",String.valueOf(t.getMeterType()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{description}",String.valueOf(t.getDescription()));
 		sql  = sql.replace("#{enabled}",String.valueOf(t.getEnabled()));
 		sql  = sql.replace("#{deleted}",String.valueOf(t.getDeleted()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{base_building_id}",String.valueOf(t.getBaseBuildingId()));
 		sql  = sql.replace("#{base_building_room_id}",String.valueOf(t.getBaseBuildingRoomId()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}