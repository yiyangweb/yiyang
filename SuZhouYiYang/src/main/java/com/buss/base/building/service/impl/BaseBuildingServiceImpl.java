package com.buss.base.building.service.impl;
import com.buss.base.building.service.BaseBuildingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.base.building.entity.BaseBuildingEntity;
import com.buss.base.building.entity.BaseBuildingStoreyEntity;
import com.buss.base.building.entity.BaseBuildingRoomTypeEntity;

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


@Service("baseBuildingService")
@Transactional
public class BaseBuildingServiceImpl extends CommonServiceImpl implements BaseBuildingServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BaseBuildingEntity)entity);
 	}
	
	public void addMain(BaseBuildingEntity baseBuilding,
	        List<BaseBuildingStoreyEntity> baseBuildingStoreyList,List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList){
			//保存主信息
			this.save(baseBuilding);
		
			/**保存-建筑物楼层信息*/
			for(BaseBuildingStoreyEntity baseBuildingStorey:baseBuildingStoreyList){
				//外键设置
				baseBuildingStorey.setBaseBuildingId(baseBuilding.getId());
				this.save(baseBuildingStorey);
			}
			/**保存-建筑物房间类型*/
			for(BaseBuildingRoomTypeEntity baseBuildingRoomType:baseBuildingRoomTypeList){
				//外键设置
				baseBuildingRoomType.setBaseBuildingId(baseBuilding.getId());
				this.save(baseBuildingRoomType);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(baseBuilding);
	}

	
	public void updateMain(BaseBuildingEntity baseBuilding,
	        List<BaseBuildingStoreyEntity> baseBuildingStoreyList,List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(baseBuilding.getId())){
			try {
				BaseBuildingEntity temp = findUniqueByProperty(BaseBuildingEntity.class, "id", baseBuilding.getId());
				MyBeanUtils.copyBeanNotNull2Bean(baseBuilding, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(baseBuilding);
		}
		//===================================================================================
		//获取参数
		Object id0 = baseBuilding.getId();
		Object id1 = baseBuilding.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-建筑物楼层信息
	    String hql0 = "from BaseBuildingStoreyEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    List<BaseBuildingStoreyEntity> baseBuildingStoreyOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-建筑物楼层信息
		if(baseBuildingStoreyList!=null&&baseBuildingStoreyList.size()>0){
		for(BaseBuildingStoreyEntity oldE:baseBuildingStoreyOldList){
			boolean isUpdate = false;
				for(BaseBuildingStoreyEntity sendE:baseBuildingStoreyList){
					//需要更新的明细数据-建筑物楼层信息
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-建筑物楼层信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-建筑物楼层信息
			for(BaseBuildingStoreyEntity baseBuildingStorey:baseBuildingStoreyList){
				if(oConvertUtils.isEmpty(baseBuildingStorey.getId())){
					//外键设置
					baseBuildingStorey.setBaseBuildingId(baseBuilding.getId());
					this.save(baseBuildingStorey);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-建筑物房间类型
	    String hql1 = "from BaseBuildingRoomTypeEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-建筑物房间类型
		if(baseBuildingRoomTypeList!=null&&baseBuildingRoomTypeList.size()>0){
		for(BaseBuildingRoomTypeEntity oldE:baseBuildingRoomTypeOldList){
			boolean isUpdate = false;
				for(BaseBuildingRoomTypeEntity sendE:baseBuildingRoomTypeList){
					//需要更新的明细数据-建筑物房间类型
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-建筑物房间类型
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-建筑物房间类型
			for(BaseBuildingRoomTypeEntity baseBuildingRoomType:baseBuildingRoomTypeList){
				if(oConvertUtils.isEmpty(baseBuildingRoomType.getId())){
					//外键设置
					baseBuildingRoomType.setBaseBuildingId(baseBuilding.getId());
					this.save(baseBuildingRoomType);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(baseBuilding);
	}

	
	public void delMain(BaseBuildingEntity baseBuilding) {
		//删除主表信息
		this.delete(baseBuilding);
		//===================================================================================
		//获取参数
		Object id0 = baseBuilding.getId();
		Object id1 = baseBuilding.getId();
		//===================================================================================
		//删除-建筑物楼层信息
	    String hql0 = "from BaseBuildingStoreyEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    List<BaseBuildingStoreyEntity> baseBuildingStoreyOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(baseBuildingStoreyOldList);
		//===================================================================================
		//删除-建筑物房间类型
	    String hql1 = "from BaseBuildingRoomTypeEntity where 1 = 1 AND bASE_BUILDING_ID = ? ";
	    List<BaseBuildingRoomTypeEntity> baseBuildingRoomTypeOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(baseBuildingRoomTypeOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BaseBuildingEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BaseBuildingEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BaseBuildingEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BaseBuildingEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{no}",String.valueOf(t.getNo()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{description}",String.valueOf(t.getDescription()));
 		sql  = sql.replace("#{manager}",String.valueOf(t.getManager()));
 		sql  = sql.replace("#{keeper}",String.valueOf(t.getKeeper()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
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
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}