package com.buss.sale.contract.entity;
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
 * @date 2018-07-15 15:27:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "contract_charge_list", schema = "")
@SuppressWarnings("serial")
public class ContractChargeListEntity implements java.io.Serializable {
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
	private java.lang.String bpmStatus;
	/**收费编号*/
    @Excel(name="收费编号",width=15)
	private java.lang.String no;
	/**收费名称*/
    @Excel(name="收费名称",width=15,dictTable ="charge_type_one_popup",dicCode ="name,description,type",dicText ="name,description,type")
	private java.lang.String name;
	/**收费描述*/
    @Excel(name="收费描述",width=15)
	private java.lang.String description;
	/**收费价格*/
    @Excel(name="收费价格",width=15)
	private java.lang.String price;
	/**收费类型*/
    @Excel(name="收费类型",width=15,dicCode="sf_mode")
	private java.lang.String type;
	/**用途*/
    @Excel(name="用途",width=15,dicCode="sf_purpose")
	private java.lang.String chargePurpose;
	/**是否缴费*/
    @Excel(name="是否缴费",width=15,dicCode="dev_flag")
	private java.lang.String status;
	/**收费部门*/
	private java.lang.String belongDept;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String remark;
	/**合同id*/
	private java.lang.String contractId;
	/**收费类型ID*/
	private java.lang.String chargeTypeId;
	
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
	
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
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
	
	@Column(name ="NAME",nullable=true,length=36)
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
	
	@Column(name ="DESCRIPTION",nullable=true,length=36)
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
	 *@return: java.lang.String  收费价格
	 */
	
	@Column(name ="PRICE",nullable=true,length=32)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费价格
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费类型
	 */
	
	@Column(name ="TYPE",nullable=true,length=36)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用途
	 */
	
	@Column(name ="CHARGE_PURPOSE",nullable=true,length=36)
	public java.lang.String getChargePurpose(){
		return this.chargePurpose;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用途
	 */
	public void setChargePurpose(java.lang.String chargePurpose){
		this.chargePurpose = chargePurpose;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否缴费
	 */
	
	@Column(name ="STATUS",nullable=true,length=36)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否缴费
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费部门
	 */
	
	@Column(name ="BELONG_DEPT",nullable=true,length=36)
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
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="REMARK",nullable=true,length=36)
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
	 *@return: java.lang.String  合同id
	 */
	
	@Column(name ="CONTRACT_ID",nullable=true,length=36)
	public java.lang.String getContractId(){
		return this.contractId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同id
	 */
	public void setContractId(java.lang.String contractId){
		this.contractId = contractId;
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
	
}
