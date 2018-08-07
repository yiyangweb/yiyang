package com.buss.sale.hotel.entity;
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
 * @Description: 收费列表
 * @author onlineGenerator
 * @date 2018-07-01 22:17:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "charge_list_hotel", schema = "")
@SuppressWarnings("serial")
public class ChargeListHotelEntity implements java.io.Serializable {
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
	/**收费编号*/
    @Excel(name="收费编号",width=15)
	private java.lang.String no;
	/**收费名称*/
    @Excel(name="收费名称",width=15,dictTable ="charge_type_popup",dicCode ="no,name",dicText ="no,name")
	private java.lang.String name;
	/**收费描述*/
    @Excel(name="收费描述",width=15)
	private java.lang.String description;
	/**价格*/
    @Excel(name="价格",width=15)
	private java.lang.String unitPrice;
	/**收费模式*/
    @Excel(name="收费模式",width=15,dicCode="sf_mode")
	private java.lang.String mode;
	/**酒店管理ID*/
	private java.lang.String chId;
	/**收费类型ID*/
	private java.lang.String chargeTypeId;
	/**收费部门代码*/
	private java.lang.String belongDept;
	/**收费部门名称*/
    @Excel(name="收费部门名称",width=15)
	private java.lang.String belongDeptName;
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
	 *@return: java.lang.String  收费编号
	 */
	
	@Column(name ="NO",nullable=true,length=32)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费名称
	 */
	
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费描述
	 */
	
	@Column(name ="DESCRIPTION",nullable=true,length=32)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费描述
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
	 *@return: java.lang.String  收费模式
	 */
	
	@Column(name ="MODE",nullable=true,length=32)
	public java.lang.String getMode(){
		return this.mode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费模式
	 */
	public void setMode(java.lang.String mode){
		this.mode = mode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  酒店管理ID
	 */
	
	@Column(name ="CH_ID",nullable=true,length=36)
	public java.lang.String getChId(){
		return this.chId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  酒店管理ID
	 */
	public void setChId(java.lang.String chId){
		this.chId = chId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费类型ID
	 */
	
	@Column(name ="CHARGE_TYPE_ID",nullable=true,length=36)
	public java.lang.String getChargeTypeId(){
		return this.chargeTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费类型ID
	 */
	public void setChargeTypeId(java.lang.String chargeTypeId){
		this.chargeTypeId = chargeTypeId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费部门代码
	 */
	
	@Column(name ="BELONG_DEPT",nullable=true,length=32)
	public java.lang.String getBelongDept(){
		return this.belongDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费部门代码
	 */
	public void setBelongDept(java.lang.String belongDept){
		this.belongDept = belongDept;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费部门名称
	 */
	
	@Column(name ="BELONG_DEPT_NAME",nullable=true,length=32)
	public java.lang.String getBelongDeptName(){
		return this.belongDeptName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费部门名称
	 */
	public void setBelongDeptName(java.lang.String belongDeptName){
		this.belongDeptName = belongDeptName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARK",nullable=true,length=32)
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
