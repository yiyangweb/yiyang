package com.buss.apt.feebill.entity;
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
 * @Description: 收费详细
 * @author onlineGenerator
 * @date 2018-07-10 20:52:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_fee_des", schema = "")
@SuppressWarnings("serial")
public class CustomerFeeDesEntity implements java.io.Serializable {
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
	/**顾客编号*/
    @Excel(name="顾客编号",width=15,dictTable ="customer_base",dicCode ="customerNo,customerName",dicText ="no,name")
	private java.lang.String customerNo;
	/**顾客姓名*/
    @Excel(name="顾客姓名",width=15)
	private java.lang.String customerName;
	/**收费编号*/
    @Excel(name="收费编号",width=15)
	private java.lang.String chargeNo;
	/**收费项目*/
    @Excel(name="收费项目",width=15,dictTable ="charge_type",dicCode ="id",dicText ="name")
	private java.lang.String chargeName;
	/**费用*/
    @Excel(name="费用",width=15)
	private java.lang.Double fee;
	/**收费用途*/
    @Excel(name="收费用途",width=15,dicCode="sf_purpose")
	private java.lang.String chargePurpose;
	/**属于*/
    @Excel(name="属于",width=15,dicCode="cs_status")
	private java.lang.String belongTo;
	/**费用状态*/
	private java.lang.String fdStatus;
	/**收费说明*/
    @Excel(name="收费说明",width=15)
	private java.lang.String feeDes;
	/**计费日期*/
	private java.util.Date feeDate;
	/**收费来源id*/
	private java.lang.String feeOriginId;
	/**计费人*/
    @Excel(name="计费人",width=15)
	private java.lang.String countPerson;
	/**生成时间*/
    @Excel(name="生成时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date countDate;
	/**收费人*/
    @Excel(name="收费人",width=15)
	private java.lang.String charger;
	/**收费日期*/
    @Excel(name="收费日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date chargeDate;
	/**收费单id*/
	private java.lang.String feeBillId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
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
	
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  顾客姓名
	 */
	
	@Column(name ="CUSTOMER_NAME",nullable=true,length=32)
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
	 *@return: java.lang.String  收费编号
	 */
	
	@Column(name ="CHARGE_NO",nullable=true,length=32)
	public java.lang.String getChargeNo(){
		return this.chargeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费编号
	 */
	public void setChargeNo(java.lang.String chargeNo){
		this.chargeNo = chargeNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目
	 */
	
	@Column(name ="CHARGE_NAME",nullable=true,length=32)
	public java.lang.String getChargeName(){
		return this.chargeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目
	 */
	public void setChargeName(java.lang.String chargeName){
		this.chargeName = chargeName;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  费用
	 */
	
	@Column(name ="FEE",nullable=true,length=32)
	public java.lang.Double getFee(){
		return this.fee;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  费用
	 */
	public void setFee(java.lang.Double fee){
		this.fee = fee;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费用途
	 */
	
	@Column(name ="CHARGE_PURPOSE",nullable=true,length=32)
	public java.lang.String getChargePurpose(){
		return this.chargePurpose;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费用途
	 */
	public void setChargePurpose(java.lang.String chargePurpose){
		this.chargePurpose = chargePurpose;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  属于
	 */
	
	@Column(name ="BELONG_TO",nullable=true,length=32)
	public java.lang.String getBelongTo(){
		return this.belongTo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  属于
	 */
	public void setBelongTo(java.lang.String belongTo){
		this.belongTo = belongTo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用状态
	 */
	
	@Column(name ="FD_STATUS",nullable=true,length=32)
	public java.lang.String getFdStatus(){
		return this.fdStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用状态
	 */
	public void setFdStatus(java.lang.String fdStatus){
		this.fdStatus = fdStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费说明
	 */
	
	@Column(name ="FEE_DES",nullable=true,length=200)
	public java.lang.String getFeeDes(){
		return this.feeDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费说明
	 */
	public void setFeeDes(java.lang.String feeDes){
		this.feeDes = feeDes;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费日期
	 */
	
	@Column(name ="FEE_DATE",nullable=true,length=32)
	public java.util.Date getFeeDate(){
		return this.feeDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费日期
	 */
	public void setFeeDate(java.util.Date feeDate){
		this.feeDate = feeDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费来源id
	 */
	
	@Column(name ="FEE_ORIGIN_ID",nullable=true,length=36)
	public java.lang.String getFeeOriginId(){
		return this.feeOriginId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费来源id
	 */
	public void setFeeOriginId(java.lang.String feeOriginId){
		this.feeOriginId = feeOriginId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费人
	 */
	
	@Column(name ="COUNT_PERSON",nullable=true,length=32)
	public java.lang.String getCountPerson(){
		return this.countPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费人
	 */
	public void setCountPerson(java.lang.String countPerson){
		this.countPerson = countPerson;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生成时间
	 */
	
	@Column(name ="COUNT_DATE",nullable=true,length=32)
	public java.util.Date getCountDate(){
		return this.countDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生成时间
	 */
	public void setCountDate(java.util.Date countDate){
		this.countDate = countDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费人
	 */
	
	@Column(name ="CHARGER",nullable=true,length=32)
	public java.lang.String getCharger(){
		return this.charger;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费人
	 */
	public void setCharger(java.lang.String charger){
		this.charger = charger;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费日期
	 */
	
	@Column(name ="CHARGE_DATE",nullable=true,length=32)
	public java.util.Date getChargeDate(){
		return this.chargeDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费日期
	 */
	public void setChargeDate(java.util.Date chargeDate){
		this.chargeDate = chargeDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费单id
	 */
	
	@Column(name ="FEE_BILL_ID",nullable=true,length=36)
	public java.lang.String getFeeBillId(){
		return this.feeBillId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费单id
	 */
	public void setFeeBillId(java.lang.String feeBillId){
		this.feeBillId = feeBillId;
	}
	
}
