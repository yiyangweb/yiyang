package com.buss.base.building.entity;
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
 * @Description: 房间类型
 * @author onlineGenerator
 * @date 2018-07-07 16:50:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "base_building_room_type", schema = "")
@SuppressWarnings("serial")
public class BaseBuildingRoomTypeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**房间类型编号*/
    @Excel(name="房间类型编号",width=15)
	private java.lang.String no;
	/**类型名称*/
    @Excel(name="类型名称",width=15)
	private java.lang.String name;
	/**床位数量*/
    @Excel(name="床位数量",width=15)
	private java.lang.Integer numberOfBed;
	/**房型面积*/
    @Excel(name="房型面积",width=15,dicCode="room_area")
	private java.lang.String roomArea;
	/**房屋朝向*/
    @Excel(name="房屋朝向",width=15,dicCode="room_turn")
	private java.lang.String orientation;
	/**类型描述*/
    @Excel(name="类型描述",width=15)
	private java.lang.String description;
	/**短期计费单价*/
    @Excel(name="短期计费单价",width=15)
	private java.lang.String shortPrice;
	/**长期计费单价*/
    @Excel(name="长期计费单价",width=15)
	private java.lang.String longPrice;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String remark;
	/**类型*/
    @Excel(name="类型",width=15,dicCode="build_type")
	private java.lang.String type;
	/**类型从属*/
	private java.lang.String belongTo;
	/**启用标记*/
	private java.lang.String enabled;
	/**审核标记*/
	private java.lang.String approved;
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
	/**建筑ID*/
	private java.lang.String baseBuildingId;
	
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
	 *@return: java.lang.String  房间类型编号
	 */
	
	@Column(name ="NO",nullable=true,length=50)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间类型编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型名称
	 */
	
	@Column(name ="NAME",nullable=true,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  床位数量
	 */
	
	@Column(name ="NUMBER_OF_BED",nullable=true,length=4)
	public java.lang.Integer getNumberOfBed(){
		return this.numberOfBed;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  床位数量
	 */
	public void setNumberOfBed(java.lang.Integer numberOfBed){
		this.numberOfBed = numberOfBed;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房型面积
	 */
	
	@Column(name ="ROOM_AREA",nullable=true,length=5)
	public java.lang.String getRoomArea(){
		return this.roomArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房型面积
	 */
	public void setRoomArea(java.lang.String roomArea){
		this.roomArea = roomArea;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋朝向
	 */
	
	@Column(name ="ORIENTATION",nullable=true,length=10)
	public java.lang.String getOrientation(){
		return this.orientation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋朝向
	 */
	public void setOrientation(java.lang.String orientation){
		this.orientation = orientation;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型描述
	 */
	
	@Column(name ="DESCRIPTION",nullable=true,length=50)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  短期计费单价
	 */
	
	@Column(name ="SHORT_PRICE",nullable=true,length=32)
	public java.lang.String getShortPrice(){
		return this.shortPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  短期计费单价
	 */
	public void setShortPrice(java.lang.String shortPrice){
		this.shortPrice = shortPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  长期计费单价
	 */
	
	@Column(name ="LONG_PRICE",nullable=true,length=32)
	public java.lang.String getLongPrice(){
		return this.longPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  长期计费单价
	 */
	public void setLongPrice(java.lang.String longPrice){
		this.longPrice = longPrice;
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	
	@Column(name ="TYPE",nullable=true,length=2)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型从属
	 */
	
	@Column(name ="BELONG_TO",nullable=true,length=36)
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型从属
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
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
	 *@return: java.lang.String  审核标记
	 */
	
	@Column(name ="APPROVED",nullable=true,length=2)
	public java.lang.String getApproved(){
		return this.approved;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核标记
	 */
	public void setApproved(java.lang.String approved){
		this.approved = approved;
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
	 *@return: java.lang.String  建筑ID
	 */
	
	@Column(name ="BASE_BUILDING_ID",nullable=true,length=36)
	public java.lang.String getBaseBuildingId(){
		return this.baseBuildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  建筑ID
	 */
	public void setBaseBuildingId(java.lang.String baseBuildingId){
		this.baseBuildingId = baseBuildingId;
	}
	
}
