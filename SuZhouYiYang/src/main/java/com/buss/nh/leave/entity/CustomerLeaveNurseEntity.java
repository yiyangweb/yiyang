package com.buss.nh.leave.entity;
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
 * @Description: 退住申请
 * @author onlineGenerator
 * @date 2018-07-15 21:32:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "customer_leave_nurse", schema = "")
@SuppressWarnings("serial")
public class CustomerLeaveNurseEntity implements java.io.Serializable {
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
	/**退住编号*/
    @Excel(name="退住编号",width=15)
	private java.lang.String no;
	/**入住id*/
	private java.lang.String stayinId;
	/**房间id*/
	private java.lang.String roomId;
	/**房间*/
    @Excel(name="房间",width=15,dictTable ="stayin_info_nh",dicCode ="stayinId,roomId,roomName,bedId,bedName,customerName,customerNo",dicText ="stayin_id,room_id,room_name,bed_id,bed_name,customer_name,customer_no")
	private java.lang.String roomName;
	/**床位id*/
	private java.lang.String bedId;
	/**床位*/
    @Excel(name="床位",width=15)
	private java.lang.String bedName;
	/**顾客姓名*/
    @Excel(name="顾客姓名",width=15)
	private java.lang.String customerName;
	/**顾客编号*/
	private java.lang.String customerNo;
	/**退住状态*/
	private java.lang.String leaveStatus;
	/**办理人*/
    @Excel(name="办理人",width=15)
	private java.lang.String inCharge;
	/**办理日期*/
    @Excel(name="办理日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date dealDate;
	/**审核人*/
	private java.lang.String auditor;
	/**审核日期*/
	private java.lang.String auditDate;
	/**审核详情*/
	private java.util.Date auditDes;
	
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
	 *@return: java.lang.String  退住编号
	 */
	
	@Column(name ="NO",nullable=true,length=32)
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退住编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住id
	 */
	
	@Column(name ="STAYIN_ID",nullable=true,length=32)
	public java.lang.String getStayinId(){
		return this.stayinId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入住id
	 */
	public void setStayinId(java.lang.String stayinId){
		this.stayinId = stayinId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间id
	 */
	
	@Column(name ="ROOM_ID",nullable=true,length=32)
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
	 *@return: java.lang.String  房间
	 */
	
	@Column(name ="ROOM_NAME",nullable=true,length=32)
	public java.lang.String getRoomName(){
		return this.roomName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间
	 */
	public void setRoomName(java.lang.String roomName){
		this.roomName = roomName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  床位id
	 */
	
	@Column(name ="BED_ID",nullable=true,length=32)
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
	 *@return: java.lang.String  床位
	 */
	
	@Column(name ="BED_NAME",nullable=true,length=32)
	public java.lang.String getBedName(){
		return this.bedName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  床位
	 */
	public void setBedName(java.lang.String bedName){
		this.bedName = bedName;
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
	 *@return: java.lang.String  退住状态
	 */
	
	@Column(name ="LEAVE_STATUS",nullable=true,length=32)
	public java.lang.String getLeaveStatus(){
		return this.leaveStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退住状态
	 */
	public void setLeaveStatus(java.lang.String leaveStatus){
		this.leaveStatus = leaveStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办理人
	 */
	
	@Column(name ="IN_CHARGE",nullable=true,length=32)
	public java.lang.String getInCharge(){
		return this.inCharge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办理人
	 */
	public void setInCharge(java.lang.String inCharge){
		this.inCharge = inCharge;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  办理日期
	 */
	
	@Column(name ="DEAL_DATE",nullable=true,length=32)
	public java.util.Date getDealDate(){
		return this.dealDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  办理日期
	 */
	public void setDealDate(java.util.Date dealDate){
		this.dealDate = dealDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	
	@Column(name ="AUDITOR",nullable=true,length=32)
	public java.lang.String getAuditor(){
		return this.auditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setAuditor(java.lang.String auditor){
		this.auditor = auditor;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核日期
	 */
	
	@Column(name ="AUDIT_DATE",nullable=true,length=32)
	public java.lang.String getAuditDate(){
		return this.auditDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核日期
	 */
	public void setAuditDate(java.lang.String auditDate){
		this.auditDate = auditDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核详情
	 */
	
	@Column(name ="AUDIT_DES",nullable=true,length=32)
	public java.util.Date getAuditDes(){
		return this.auditDes;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核详情
	 */
	public void setAuditDes(java.util.Date auditDes){
		this.auditDes = auditDes;
	}
	
}
