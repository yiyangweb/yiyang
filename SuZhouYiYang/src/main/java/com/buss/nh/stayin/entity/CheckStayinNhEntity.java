package com.buss.nh.stayin.entity;
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
 * @Description: 入住检查
 * @author onlineGenerator
 * @date 2018-06-24 12:41:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "check_stayin_nh", schema = "")
@SuppressWarnings("serial")
public class CheckStayinNhEntity implements java.io.Serializable {
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
	/**检查状态*/
	private java.lang.String status;
	/**编号*/
    @Excel(name="编号",width=15)
	private java.lang.String no;
	/**检查项目*/
    @Excel(name="检查项目",width=15)
	private java.lang.String name;
	/**属于*/
	private java.lang.String belongTo;
	/**检查人*/
    @Excel(name="检查人",width=15)
	private java.lang.String checkPerson;
	/**描述*/
    @Excel(name="描述",width=15)
	private java.lang.String description;
	/**完成时间*/
    @Excel(name="完成时间",width=15)
	private java.lang.Double endDate;
	/**附件*/
    @Excel(name="附件",width=15)
	private java.lang.String attribute;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String remark;
	/**入住id*/
	private java.lang.String inId;
	
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
	 *@return: java.lang.String  检查状态
	 */
	
	@Column(name ="STATUS",nullable=true,length=32)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查状态
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
	 *@return: java.lang.String  检查项目
	 */
	
	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查项目
	 */
	public void setName(java.lang.String name){
		this.name = name;
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
	 *@return: java.lang.String  检查人
	 */
	
	@Column(name ="CHECK_PERSON",nullable=true,length=32)
	public java.lang.String getCheckPerson(){
		return this.checkPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查人
	 */
	public void setCheckPerson(java.lang.String checkPerson){
		this.checkPerson = checkPerson;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  完成时间
	 */
	
	@Column(name ="END_DATE",nullable=true,length=32)
	public java.lang.Double getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  完成时间
	 */
	public void setEndDate(java.lang.Double endDate){
		this.endDate = endDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	
	@Column(name ="ATTRIBUTE",nullable=true,length=32)
	public java.lang.String getAttribute(){
		return this.attribute;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setAttribute(java.lang.String attribute){
		this.attribute = attribute;
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住id
	 */
	
	@Column(name ="IN_ID",nullable=true,length=32)
	public java.lang.String getInId(){
		return this.inId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住id
	 */
	public void setInId(java.lang.String inId){
		this.inId = inId;
	}
	
}