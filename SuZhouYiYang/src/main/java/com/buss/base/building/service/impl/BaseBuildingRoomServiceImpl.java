package com.buss.base.building.service.impl;
import com.buss.base.building.service.BaseBuildingRoomServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.base.building.entity.BaseBuildingRoomEntity;
import com.buss.base.building.entity.BaseBuildingBedEntity;

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


@Service("baseBuildingRoomService")
@Transactional
public class BaseBuildingRoomServiceImpl extends CommonServiceImpl implements BaseBuildingRoomServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BaseBuildingRoomEntity)entity);
 	}
	
	public void addMain(BaseBuildingRoomEntity baseBuildingRoom,
	        List<BaseBuildingBedEntity> baseBuildingBedList){
			//保存主信息
			this.save(baseBuildingRoom);
		
			/**保存-建筑物床位信息*/
			for(BaseBuildingBedEntity baseBuildingBed:baseBuildingBedList){
				//外键设置
				baseBuildingBed.setBaseBuildingRoomId(baseBuildingRoom.getId());
				this.save(baseBuildingBed);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(baseBuildingRoom);
	}

	
	public void updateMain(BaseBuildingRoomEntity baseBuildingRoom,
	        List<BaseBuildingBedEntity> baseBuildingBedList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(baseBuildingRoom.getId())){
			try {
				BaseBuildingRoomEntity temp = findUniqueByProperty(BaseBuildingRoomEntity.class, "id", baseBuildingRoom.getId());
				MyBeanUtils.copyBeanNotNull2Bean(baseBuildingRoom, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(baseBuildingRoom);
		}
		//===================================================================================
		//获取参数
		Object id0 = baseBuildingRoom.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-建筑物床位信息
	    String hql0 = "from BaseBuildingBedEntity where 1 = 1 AND bASE_BUILDING_ROOM_ID = ? ";
	    List<BaseBuildingBedEntity> baseBuildingBedOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-建筑物床位信息
		if(baseBuildingBedList!=null&&baseBuildingBedList.size()>0){
		for(BaseBuildingBedEntity oldE:baseBuildingBedOldList){
			boolean isUpdate = false;
				for(BaseBuildingBedEntity sendE:baseBuildingBedList){
					//需要更新的明细数据-建筑物床位信息
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-建筑物床位信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-建筑物床位信息
			for(BaseBuildingBedEntity baseBuildingBed:baseBuildingBedList){
				if(oConvertUtils.isEmpty(baseBuildingBed.getId())){
					//外键设置
					baseBuildingBed.setBaseBuildingRoomId(baseBuildingRoom.getId());
					this.save(baseBuildingBed);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(baseBuildingRoom);
	}

	
	public void delMain(BaseBuildingRoomEntity baseBuildingRoom) {
		//删除主表信息
		this.delete(baseBuildingRoom);
		//===================================================================================
		//获取参数
		Object id0 = baseBuildingRoom.getId();
		//===================================================================================
		//删除-建筑物床位信息
	    String hql0 = "from BaseBuildingBedEntity where 1 = 1 AND bASE_BUILDING_ROOM_ID = ? ";
	    List<BaseBuildingBedEntity> baseBuildingBedOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(baseBuildingBedOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BaseBuildingRoomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BaseBuildingRoomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BaseBuildingRoomEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BaseBuildingRoomEntity t){
 		sql  = sql.replace("#{base_building_id}",String.valueOf(t.getBaseBuildingId()));
 		sql  = sql.replace("#{base_building_storey_id}",String.valueOf(t.getBaseBuildingStoreyId()));
 		sql  = sql.replace("#{base_building_room_type_id}",String.valueOf(t.getBaseBuildingRoomTypeId()));
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{manager}",String.valueOf(t.getManager()));
 		sql  = sql.replace("#{keeper}",String.valueOf(t.getKeeper()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{description}",String.valueOf(t.getDescription()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{belong_to}",String.valueOf(t.getBelongTo()));
 		sql  = sql.replace("#{enabled}",String.valueOf(t.getEnabled()));
 		sql  = sql.replace("#{approved}",String.valueOf(t.getApproved()));
 		sql  = sql.replace("#{deleted}",String.valueOf(t.getDeleted()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{base_building_area_id}",String.valueOf(t.getBaseBuildingAreaId()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}