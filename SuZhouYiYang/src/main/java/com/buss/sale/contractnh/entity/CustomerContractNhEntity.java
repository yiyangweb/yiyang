package com.buss.sale.contractnh.entity;
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
 * @Description: 签订合同记录
 * @author onlineGenerator
 * @date 2018-07-15 12:03:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_contract_nh", schema = "")
@SuppressWarnings("serial")
public class CustomerContractNhEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登陆名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登陆名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**合同状态*/
	private java.lang.String contractStatus;
	/**顾客id*/
	private java.lang.String customerId;
	/**顾客名称*/
    @Excel(name="顾客名称",width=15,dictTable ="customer_base",dicCode ="customerId,customerName,customerNo",dicText ="id,name,no")
	private java.lang.String customerName;
	/**顾客编号*/
    @Excel(name="顾客编号",width=15)
	private java.lang.String customerNo;
	/**合同编号*/
    @Excel(name="合同编号",width=15)
	private java.lang.String no;
	/**所属*/
    @Excel(name="所属",width=15,dicCode="cs_status")
	private java.lang.String belongTo;
	/**生效日期*/
    @Excel(name="生效日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date beginDate;
	/**截止日期*/
    @Excel(name="截止日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date endDate;
	/**签订日期*/
    @Excel(name="签订日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date signDate;
	/**付款进度*/
    @Excel(name="付款进度",width=15)
	private java.lang.String paymentStatus;
	/**enabled*/
	private java.lang.String enabled;
	/**approved*/
	private java.lang.String approved;
	/**deleted*/
	private java.lang.String deleted;
	/**负责人*/
    @Excel(name="负责人",width=15)
	private java.lang.String charger;
	/**楼栋id*/
	private java.lang.String buildingId;
	/**房间id*/
	private java.lang.String roomId;
	/**床位id*/
	private java.lang.String bedId;
	/**楼栋名称*/
    @Excel(name="楼栋名称",width=15,dictTable ="empty_bed_info",dicCode ="buildingId,buildingName,roomId,roomName,bedId,bedName,unitPrice",dicText ="building_id,building_name,room_id,room_name,bed_id,bed_name,price")
	private java.lang.String buildingName;
	/**房间名称*/
    @Excel(name="房间名称",width=15)
	private java.lang.String roomName;
	/**床位名称*/
    @Excel(name="床位名称",width=15)
	private java.lang.String bedName;
	/**床位费*/
    @Excel(name="床位费",width=15)
	private java.lang.String unitPrice;
	/**护理等级*/
    @Excel(name="护理等级",width=15,dictTable ="nurse_level_info",dicCode ="nurseLevel,nurseCharge",dicText ="name,charge_standard")
	private java.lang.String nurseLevel;
	/**护理费*/
    @Excel(name="护理费",width=15)
	private java.lang.String nurseCharge;
	/**附件*/
    @Excel(name="附件",width=15)
	private java.lang.String attach;
	/**是否为包房*/
	@Excel(name="所属",width=15,dicCode="dev_flag")
	private java.lang.String isChartered;

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
	 *@return: java.lang.String  创建人名称
	 */
	
	@Column(name ="CREATE_NAME",nullable=true,length=50)
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
	 *@return: java.lang.String  创建人登陆名称
	 */
	
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登陆名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	
	@Column(name ="CREATE_DATE",nullable=true,length=8)
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
	 *@return: java.lang.String  更新人登陆名称
	 */
	
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登陆名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	
	@Column(name ="UPDATE_DATE",nullable=true,length=8)
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
	 *@return: java.lang.String  合同状态
	 */
	
	@Column(name ="CONTRACT_STATUS",nullable=true,length=32)
	public java.lang.String getContractStatus(){
		return this.contractStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同状态
	 */
	public void setContractStatus(java.lang.String contractStatus){
		this.contractStatus = contractStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客id
	 */
	
	@Column(name ="CUSTOMER_ID",nullable=true,length=36)
	public java.lang.String getCustomerId(){
		return this.customerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客id
	 */
	public void setCustomerId(java.lang.String customerId){
		this.customerId = customerId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客名称
	 */
	
	@Column(name ="CUSTOMER_NAME",nullable=true,length=32)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客名称
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客编号
	 */
	
	@Column(name ="CUSTOMER_NO",nullable=true,length=32)
	public java.lang.String getCustomerNo(){
		return this.customerNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客编号
	 */
	public void setCustomerNo(java.lang.String customerNo){
		this.customerNo = customerNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */
	
	@Column(name ="NO",nullable=true,length=32)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属
	 */
	
	@Column(name ="BELONG_TO",nullable=true,length=32)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生效日期
	 */
	
	@Column(name ="BEGIN_DATE",nullable=true,length=8)
	public java.util.Date getBeginDate(){
		return this.beginDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生效日期
	 */
	public void setBeginDate(java.util.Date beginDate){
		this.beginDate = beginDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  截止日期
	 */
	
	@Column(name ="END_DATE",nullable=true,length=8)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  截止日期
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订日期
	 */
	
	@Column(name ="SIGN_DATE",nullable=true,length=8)
	public java.util.Date getSignDate(){
		return this.signDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签订日期
	 */
	public void setSignDate(java.util.Date signDate){
		this.signDate = signDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款进度
	 */
	
	@Column(name ="PAYMENT_STATUS",nullable=true,length=32)
	public java.lang.String getPaymentStatus(){
		return this.paymentStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款进度
	 */
	public void setPaymentStatus(java.lang.String paymentStatus){
		this.paymentStatus = paymentStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  enabled
	 */
	
	@Column(name ="ENABLED",nullable=true,length=2)
	public java.lang.String getEnabled(){
		return this.enabled;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  enabled
	 */
	public void setEnabled(java.lang.String enabled){
		this.enabled = enabled;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  approved
	 */
	
	@Column(name ="APPROVED",nullable=true,length=2)
	public java.lang.String getApproved(){
		return this.approved;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  approved
	 */
	public void setApproved(java.lang.String approved){
		this.approved = approved;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  deleted
	 */
	
	@Column(name ="DELETED",nullable=true,length=2)
	public java.lang.String getDeleted(){
		return this.deleted;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  deleted
	 */
	public void setDeleted(java.lang.String deleted){
		this.deleted = deleted;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人
	 */
	
	@Column(name ="CHARGER",nullable=true,length=32)
	public java.lang.String getCharger(){
		return this.charger;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责人
	 */
	public void setCharger(java.lang.String charger){
		this.charger = charger;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼栋id
	 */
	
	@Column(name ="BUILDING_ID",nullable=true,length=36)
	public java.lang.String getBuildingId(){
		return this.buildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋id
	 */
	public void setBuildingId(java.lang.String buildingId){
		this.buildingId = buildingId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间id
	 */
	
	@Column(name ="ROOM_ID",nullable=true,length=36)
	public java.lang.String getRoomId(){
		return this.roomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间id
	 */
	public void setRoomId(java.lang.String roomId){
		this.roomId = roomId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  床位id
	 */
	
	@Column(name ="BED_ID",nullable=true,length=36)
	public java.lang.String getBedId(){
		return this.bedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位id
	 */
	public void setBedId(java.lang.String bedId){
		this.bedId = bedId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼栋名称
	 */
	
	@Column(name ="BUILDING_NAME",nullable=true,length=32)
	public java.lang.String getBuildingName(){
		return this.buildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋名称
	 */
	public void setBuildingName(java.lang.String buildingName){
		this.buildingName = buildingName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间名称
	 */
	
	@Column(name ="ROOM_NAME",nullable=true,length=32)
	public java.lang.String getRoomName(){
		return this.roomName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间名称
	 */
	public void setRoomName(java.lang.String roomName){
		this.roomName = roomName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  床位名称
	 */
	
	@Column(name ="BED_NAME",nullable=true,length=32)
	public java.lang.String getBedName(){
		return this.bedName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位名称
	 */
	public void setBedName(java.lang.String bedName){
		this.bedName = bedName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  床位费
	 */
	
	@Column(name ="UNIT_PRICE",nullable=true,length=32)
	public java.lang.String getUnitPrice(){
		return this.unitPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位费
	 */
	public void setUnitPrice(java.lang.String unitPrice){
		this.unitPrice = unitPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  护理等级
	 */
	
	@Column(name ="NURSE_LEVEL",nullable=true,length=36)
	public java.lang.String getNurseLevel(){
		return this.nurseLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  护理等级
	 */
	public void setNurseLevel(java.lang.String nurseLevel){
		this.nurseLevel = nurseLevel;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  护理费
	 */
	
	@Column(name ="NURSE_CHARGE",nullable=true,length=32)
	public java.lang.String getNurseCharge(){
		return this.nurseCharge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  护理费
	 */
	public void setNurseCharge(java.lang.String nurseCharge){
		this.nurseCharge = nurseCharge;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	
	@Column(name ="ATTACH",nullable=true,length=100)
	public java.lang.String getAttach(){
		return this.attach;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setAttach(java.lang.String attach){
		this.attach = attach;
	}

	@Column(name ="IS_CHARTERED",nullable=true,length=100)
	public String getIsChartered() { return isChartered; }

	public void setIsChartered(String isChartered) { this.isChartered = isChartered; }
}
