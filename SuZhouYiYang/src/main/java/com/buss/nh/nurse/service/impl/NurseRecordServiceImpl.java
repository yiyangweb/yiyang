package com.buss.nh.nurse.service.impl;
import com.buss.nh.nurse.service.NurseRecordServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.nh.nurse.entity.NurseRecordEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("nurseRecordService")
@Transactional
public class NurseRecordServiceImpl extends CommonServiceImpl implements NurseRecordServiceI {

	
 	public void delete(NurseRecordEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(NurseRecordEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(NurseRecordEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	/**
	 * 自定义按钮-[确认]业务处理
	 * @param id
	 * @return
	 */
	 public void doNurse_sbtBus(NurseRecordEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update nurse_record set jl_status='2'   where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(NurseRecordEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(NurseRecordEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(NurseRecordEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(NurseRecordEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bed_id", t.getBedId());
		map.put("room_name", t.getRoomName());
		map.put("bed_name", t.getBedName());
		map.put("customer_name", t.getCustomerName());
		map.put("customer_no", t.getCustomerNo());
		map.put("record_date", t.getRecordDate());
		map.put("jl_status", t.getJlStatus());
		map.put("blood_pressure", t.getBloodPressure());
		map.put("pulse", t.getPulse());
		map.put("animal_heat", t.getAnimalHeat());
		map.put("breath", t.getBreath());
		map.put("is_oxygen", t.getIsOxygen());
		map.put("take_medicine", t.getTakeMedicine());
		map.put("mental_help", t.getMentalHelp());
		map.put("charger", t.getCharger());
		map.put("handover_des", t.getHandoverDes());
		map.put("attachment", t.getAttachment());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,NurseRecordEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bed_id}",String.valueOf(t.getBedId()));
 		sql  = sql.replace("#{room_name}",String.valueOf(t.getRoomName()));
 		sql  = sql.replace("#{bed_name}",String.valueOf(t.getBedName()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{record_date}",String.valueOf(t.getRecordDate()));
 		sql  = sql.replace("#{jl_status}",String.valueOf(t.getJlStatus()));
 		sql  = sql.replace("#{blood_pressure}",String.valueOf(t.getBloodPressure()));
 		sql  = sql.replace("#{pulse}",String.valueOf(t.getPulse()));
 		sql  = sql.replace("#{animal_heat}",String.valueOf(t.getAnimalHeat()));
 		sql  = sql.replace("#{breath}",String.valueOf(t.getBreath()));
 		sql  = sql.replace("#{is_oxygen}",String.valueOf(t.getIsOxygen()));
 		sql  = sql.replace("#{take_medicine}",String.valueOf(t.getTakeMedicine()));
 		sql  = sql.replace("#{mental_help}",String.valueOf(t.getMentalHelp()));
 		sql  = sql.replace("#{charger}",String.valueOf(t.getCharger()));
 		sql  = sql.replace("#{handover_des}",String.valueOf(t.getHandoverDes()));
 		sql  = sql.replace("#{attachment}",String.valueOf(t.getAttachment()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("nurse_record",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}