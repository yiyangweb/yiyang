package com.buss.nh.stayin.service.impl;
import com.buss.nh.stayin.service.CustomerToNhServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.nh.stayin.entity.CustomerToNhEntity;
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

@Service("customerToNhService")
@Transactional
public class CustomerToNhServiceImpl extends CommonServiceImpl implements CustomerToNhServiceI {

	
 	public void delete(CustomerToNhEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(CustomerToNhEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(CustomerToNhEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	/**
	 * 自定义按钮-[提交]业务处理
	 * @param id
	 * @return
	 */
	 public void doIn_sbtBus(CustomerToNhEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_to_nh set cr_status = '2' where id = '#{id}'";
	 	this.executeSql(replaceVal(sqlEnhance_1,t));

	 	//sql回写顾客状态
	 	String sqlEnhance_2 ="update customer_base set customer_status = '4' where no = '#{customer_no}'";
	 	this.executeSql(replaceVal(sqlEnhance_2,t));


	 	//回写房间状态
	 	String sqlEnhance_3 ="update base_building_room set status = '2' where id = '#{room_id}'";
	 	this.executeSql(replaceVal(sqlEnhance_3,t));

	 	//回写床位状态
	 	String sqlEnhance_4 ="update base_building_bed set status = '2' where id = '#{bed_id}'";
		 this.executeSql(replaceVal(sqlEnhance_4,t));
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
	 }
 	/**
	 * 自定义按钮-[确认入住]业务处理
	 * @param id
	 * @return
	 */
	 public void doIn_commitBus(CustomerToNhEntity t) throws Exception{
	 	//-----------------sql增强 start----------------------------
	 	//sql增强第1条
	 	String sqlEnhance_1 ="update customer_to_nh set cr_status = '3' where id = '#{id}'";
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
	private void doAddBus(CustomerToNhEntity t) throws Exception{
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
	private void doUpdateBus(CustomerToNhEntity t) throws Exception{
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
	private void doDelBus(CustomerToNhEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(CustomerToNhEntity t){
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
		map.put("no", t.getNo());
		map.put("customer_id", t.getCustomerId());
		map.put("customer_name", t.getCustomerName());
		map.put("customer_no", t.getCustomerNo());
		map.put("bed_name", t.getBedName());
		map.put("sex", t.getSex());
		map.put("contract_no", t.getContractNo());
		map.put("nurse_level", t.getNurseLevel());
		map.put("building_id", t.getBuildingId());
		map.put("building_name", t.getBuildingName());
		map.put("room_id", t.getRoomId());
		map.put("room_name", t.getRoomName());
		map.put("bed_id", t.getBedId());
		map.put("cr_status", t.getCrStatus());
		map.put("in_charge", t.getInCharge());
		map.put("in_date", t.getInDate());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,CustomerToNhEntity t){
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
 		sql  = sql.replace("#{customer_id}",String.valueOf(t.getCustomerId()));
 		sql  = sql.replace("#{customer_name}",String.valueOf(t.getCustomerName()));
 		sql  = sql.replace("#{customer_no}",String.valueOf(t.getCustomerNo()));
 		sql  = sql.replace("#{bed_name}",String.valueOf(t.getBedName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{contract_no}",String.valueOf(t.getContractNo()));
 		sql  = sql.replace("#{nurse_level}",String.valueOf(t.getNurseLevel()));
 		sql  = sql.replace("#{building_id}",String.valueOf(t.getBuildingId()));
 		sql  = sql.replace("#{building_name}",String.valueOf(t.getBuildingName()));
 		sql  = sql.replace("#{room_id}",String.valueOf(t.getRoomId()));
 		sql  = sql.replace("#{room_name}",String.valueOf(t.getRoomName()));
 		sql  = sql.replace("#{bed_id}",String.valueOf(t.getBedId()));
 		sql  = sql.replace("#{cr_status}",String.valueOf(t.getCrStatus()));
 		sql  = sql.replace("#{in_charge}",String.valueOf(t.getInCharge()));
 		sql  = sql.replace("#{in_date}",String.valueOf(t.getInDate()));
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
					javaInter.execute("customer_to_nh",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}