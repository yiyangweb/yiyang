package com.buss.sale.visit.entity;
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
 * @Description: 回访记录
 * @author onlineGenerator
 * @date 2018-07-10 14:01:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "mm_visitor_return", schema = "")
@SuppressWarnings("serial")
public class MmVisitorReturnEntity implements java.io.Serializable {
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
	/**回访编号*/
    @Excel(name="回访编号",width=15)
	private java.lang.String returnNo;
	/**被访客户*/
    @Excel(name="被访客户",width=15)
	private java.lang.String visitor;
	/**回访地点*/
    @Excel(name="回访地点",width=15)
	private java.lang.String place;
	/**回访方式*/
    @Excel(name="回访方式",width=15,dicCode="hf_type")
	private java.lang.String visitType;
	/**回访详情*/
    @Excel(name="回访详情",width=15)
	private java.lang.String visitDetail;
	/**回访人*/
    @Excel(name="回访人",width=15)
	private java.lang.String revisit;
	/**回访时间*/
    @Excel(name="回访时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date visitDate;
	/**来访记录id*/
	private java.lang.String recordId;
	
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
	 *@return: java.lang.String  回访编号
	 */
	
	@Column(name ="RETURN_NO",nullable=true,length=32)
	public java.lang.String getReturnNo(){
		return this.returnNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访编号
	 */
	public void setReturnNo(java.lang.String returnNo){
		this.returnNo = returnNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被访客户
	 */
	
	@Column(name ="VISITOR",nullable=true,length=50)
	public java.lang.String getVisitor(){
		return this.visitor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被访客户
	 */
	public void setVisitor(java.lang.String visitor){
		this.visitor = visitor;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回访地点
	 */
	
	@Column(name ="PLACE",nullable=true,length=32)
	public java.lang.String getPlace(){
		return this.place;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访地点
	 */
	public void setPlace(java.lang.String place){
		this.place = place;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回访方式
	 */
	
	@Column(name ="VISIT_TYPE",nullable=true,length=32)
	public java.lang.String getVisitType(){
		return this.visitType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访方式
	 */
	public void setVisitType(java.lang.String visitType){
		this.visitType = visitType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回访详情
	 */
	
	@Column(name ="VISIT_DETAIL",nullable=true,length=200)
	public java.lang.String getVisitDetail(){
		return this.visitDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访详情
	 */
	public void setVisitDetail(java.lang.String visitDetail){
		this.visitDetail = visitDetail;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回访人
	 */
	
	@Column(name ="REVISIT",nullable=true,length=32)
	public java.lang.String getRevisit(){
		return this.revisit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回访人
	 */
	public void setRevisit(java.lang.String revisit){
		this.revisit = revisit;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  回访时间
	 */
	
	@Column(name ="VISIT_DATE",nullable=true,length=32)
	public java.util.Date getVisitDate(){
		return this.visitDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  回访时间
	 */
	public void setVisitDate(java.util.Date visitDate){
		this.visitDate = visitDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来访记录id
	 */
	
	@Column(name ="RECORD_ID",nullable=true,length=32)
	public java.lang.String getRecordId(){
		return this.recordId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来访记录id
	 */
	public void setRecordId(java.lang.String recordId){
		this.recordId = recordId;
	}
	
}
