package com.buss.sale.customer.entity;
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
 * @Description: 周期收费
 * @author onlineGenerator
 * @date 2018-07-09 14:45:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_common_charge", schema = "")
@SuppressWarnings("serial")
public class CustomerCommonChargeEntity implements java.io.Serializable {
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
	/**流程状态*/
	private java.lang.String status;
	/**编号*/
    @Excel(name="编号",width=15)
	private java.lang.String no;
	/**收费编号*/
    @Excel(name="收费编号",width=15,dictTable ="charge_type_not_one_pop",dicCode ="no,name,description,mode,belongdeptcode",dicText ="charge_no,name,description,mode,belong_dept")
	private java.lang.String chargeNo;
	/**收费项目*/
    @Excel(name="收费项目",width=15)
	private java.lang.String name;
	/**描述*/
    @Excel(name="描述",width=15)
	private java.lang.String description;
	/**价格*/
    @Excel(name="价格",width=15)
	private java.lang.String unitPrice;
	/**模式*/
    @Excel(name="模式",width=15,dicCode="sf_mode")
	private java.lang.String mode;
	/**生效时间*/
    @Excel(name="生效时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date beginDate;
	/**截止时间*/
    @Excel(name="截止时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date endDate;
	/**收费部门*/
	private java.lang.String belongDept;
	/**顾客id*/
	private java.lang.String customerId;
	/**来源id*/
	private java.lang.String originId;
	/**来源*/
	private java.lang.String originName;
	
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
	 *@return: java.lang.String  流程状态
	 */
	
	@Column(name ="STATUS",nullable=true,length=32)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Column(name ="NO",nullable=true,length=32)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
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
	
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	
	@Column(name ="DESCRIPTION",nullable=true,length=32)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价格
	 */
	
	@Column(name ="UNIT_PRICE",nullable=true,length=32)
	public java.lang.String getUnitPrice(){
		return this.unitPrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价格
	 */
	public void setUnitPrice(java.lang.String unitPrice){
		this.unitPrice = unitPrice;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模式
	 */
	
	@Column(name ="MODE",nullable=true,length=32)
	public java.lang.String getMode(){
		return this.mode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模式
	 */
	public void setMode(java.lang.String mode){
		this.mode = mode;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生效时间
	 */
	
	@Column(name ="BEGIN_DATE",nullable=true,length=32)
	public java.util.Date getBeginDate(){
		return this.beginDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生效时间
	 */
	public void setBeginDate(java.util.Date beginDate){
		this.beginDate = beginDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  截止时间
	 */
	
	@Column(name ="END_DATE",nullable=true,length=32)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  截止时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费部门
	 */
	
	@Column(name ="BELONG_DEPT",nullable=true,length=32)
	public java.lang.String getBelongDept(){
		return this.belongDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费部门
	 */
	public void setBelongDept(java.lang.String belongDept){
		this.belongDept = belongDept;
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
	 *@return: java.lang.String  来源id
	 */
	
	@Column(name ="ORIGIN_ID",nullable=true,length=36)
	public java.lang.String getOriginId(){
		return this.originId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源id
	 */
	public void setOriginId(java.lang.String originId){
		this.originId = originId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源
	 */
	
	@Column(name ="ORIGIN_NAME",nullable=true,length=32)
	public java.lang.String getOriginName(){
		return this.originName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源
	 */
	public void setOriginName(java.lang.String originName){
		this.originName = originName;
	}
	
}
