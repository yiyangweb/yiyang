
package com.buss.sale.service.page;
import com.buss.sale.service.entity.ValueAddedServiceEntity;
import com.buss.sale.service.entity.ChargeListServiceEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 增值服务
 * @author onlineGenerator
 * @date 2018-07-15 14:31:21
 * @version V1.0   
 *
 */
public class ValueAddedServicePage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**服务编号*/
    @Excel(name="服务编号")
	private java.lang.String serviceId;
	/**顾客姓名*/
    @Excel(name="顾客姓名")
	private java.lang.String customerName;
	/**房间号*/
    @Excel(name="房间号")
	private java.lang.String customerRoomName;
	/**床位号*/
	private java.lang.String customerBedName;
	/**服务类型*/
    @Excel(name="服务类型")
	private java.lang.String serviceType;
	/**服务说明*/
    @Excel(name="服务说明")
	private java.lang.String serviceDetail;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String remark;
	/**顾客ID*/
	private java.lang.String customerId;
	/**房间ID*/
	private java.lang.String customerRoomId;
	/**床位ID*/
	private java.lang.String customerBedId;
	/**所属*/
	private java.lang.String belongTo;
	/**状态*/
	private java.lang.String status;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务编号
	 */
	public java.lang.String getServiceId(){
		return this.serviceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务编号
	 */
	public void setServiceId(java.lang.String serviceId){
		this.serviceId = serviceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客姓名
	 */
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客姓名
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间号
	 */
	public java.lang.String getCustomerRoomName(){
		return this.customerRoomName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间号
	 */
	public void setCustomerRoomName(java.lang.String customerRoomName){
		this.customerRoomName = customerRoomName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  床位号
	 */
	public java.lang.String getCustomerBedName(){
		return this.customerBedName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位号
	 */
	public void setCustomerBedName(java.lang.String customerBedName){
		this.customerBedName = customerBedName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务类型
	 */
	public java.lang.String getServiceType(){
		return this.serviceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务类型
	 */
	public void setServiceType(java.lang.String serviceType){
		this.serviceType = serviceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务说明
	 */
	public java.lang.String getServiceDetail(){
		return this.serviceDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务说明
	 */
	public void setServiceDetail(java.lang.String serviceDetail){
		this.serviceDetail = serviceDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客ID
	 */
	public java.lang.String getCustomerId(){
		return this.customerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客ID
	 */
	public void setCustomerId(java.lang.String customerId){
		this.customerId = customerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间ID
	 */
	public java.lang.String getCustomerRoomId(){
		return this.customerRoomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间ID
	 */
	public void setCustomerRoomId(java.lang.String customerRoomId){
		this.customerRoomId = customerRoomId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  床位ID
	 */
	public java.lang.String getCustomerBedId(){
		return this.customerBedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位ID
	 */
	public void setCustomerBedId(java.lang.String customerBedId){
		this.customerBedId = customerBedId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属
	 */
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}

	/**保存-收费列表*/
    @ExcelCollection(name="收费列表")
	private List<ChargeListServiceEntity> chargeListServiceList = new ArrayList<ChargeListServiceEntity>();
		public List<ChargeListServiceEntity> getChargeListServiceList() {
		return chargeListServiceList;
		}
		public void setChargeListServiceList(List<ChargeListServiceEntity> chargeListServiceList) {
		this.chargeListServiceList = chargeListServiceList;
		}
}
