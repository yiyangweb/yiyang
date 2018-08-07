package com.buss.base.meter.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 水电基础数据
 * @author onlineGenerator
 * @date 2018-07-02 16:41:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "meter_info", schema = "")
@SuppressWarnings("serial")
public class MeterInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**计量设备编号*/
    @Excel(name="计量设备编号",width=15)
	private java.lang.String no;
	/**计量设备类型*/
    @Excel(name="计量设备类型",width=15,dicCode="meter_type")
	private java.lang.String meterType;
	/**计量设备名称*/
    @Excel(name="计量设备名称",width=15)
	private java.lang.String name;
	/**计量设备地址*/
    @Excel(name="计量设备地址",width=15)
	private java.lang.String address;
	/**计量设备表描述*/
    @Excel(name="计量设备表描述",width=15)
	private java.lang.String description;
	/**启用标记*/
	private java.lang.String enabled;
	/**删除标记*/
	private java.lang.String deleted;
	/**创建人*/
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
	/**楼栋名称*/
    @Excel(name="楼栋名称",width=15,dictTable ="base_building",dicCode ="id",dicText ="name")
	private java.lang.String baseBuildingId;
	/**房间名称*/
    @Excel(name="房间名称",width=15,dictTable ="base_building_room",dicCode ="id",dicText ="name")
	private java.lang.String baseBuildingRoomId;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计量设备编号
	 */
	
	@Column(name ="NO",nullable=true,length=50)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计量设备编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计量设备类型
	 */
	
	@Column(name ="METER_TYPE",nullable=true,length=2)
	public java.lang.String getMeterType(){
		return this.meterType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计量设备类型
	 */
	public void setMeterType(java.lang.String meterType){
		this.meterType = meterType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计量设备名称
	 */
	
	@Column(name ="NAME",nullable=true,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计量设备名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计量设备地址
	 */
	
	@Column(name ="ADDRESS",nullable=true,length=100)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计量设备地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计量设备表描述
	 */
	
	@Column(name ="DESCRIPTION",nullable=true,length=50)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计量设备表描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  启用标记
	 */
	
	@Column(name ="ENABLED",nullable=true,length=2)
	public java.lang.String getEnabled(){
		return this.enabled;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  启用标记
	 */
	public void setEnabled(java.lang.String enabled){
		this.enabled = enabled;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  删除标记
	 */
	
	@Column(name ="DELETED",nullable=true,length=2)
	public java.lang.String getDeleted(){
		return this.deleted;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  删除标记
	 */
	public void setDeleted(java.lang.String deleted){
		this.deleted = deleted;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	
	@Column(name ="CREATE_BY",nullable=true,length=50)
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
	
	@Column(name ="CREATE_DATE",nullable=true,length=3)
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
	
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
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
	
	@Column(name ="UPDATE_BY",nullable=true,length=50)
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
	
	@Column(name ="UPDATE_DATE",nullable=true,length=3)
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
	
	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
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
	
	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
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
	 *@return: java.lang.String  楼栋名称
	 */
	
	@Column(name ="BASE_BUILDING_ID",nullable=true,length=36)
	public java.lang.String getBaseBuildingId(){
		return this.baseBuildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋名称
	 */
	public void setBaseBuildingId(java.lang.String baseBuildingId){
		this.baseBuildingId = baseBuildingId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间名称
	 */
	
	@Column(name ="BASE_BUILDING_ROOM_ID",nullable=true,length=36)
	public java.lang.String getBaseBuildingRoomId(){
		return this.baseBuildingRoomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间名称
	 */
	public void setBaseBuildingRoomId(java.lang.String baseBuildingRoomId){
		this.baseBuildingRoomId = baseBuildingRoomId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARK",nullable=true,length=50)
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
	
}
