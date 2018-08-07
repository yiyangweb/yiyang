
package com.buss.apt.stayout.page;
import com.buss.apt.stayout.entity.CustomerOutRoomEntity;
import com.buss.apt.stayout.entity.CheckOutDesEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 退房管理
 * @author onlineGenerator
 * @date 2018-07-13 22:07:26
 * @version V1.0   
 *
 */
public class CustomerOutRoomPage implements java.io.Serializable {
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
	/**退房编号*/
    @Excel(name="退房编号")
	private java.lang.String no;
	/**入住id*/
	private java.lang.String stayinId;
	/**房间id*/
	private java.lang.String roomId;
	/**房间名称*/
    @Excel(name="房间名称")
	private java.lang.String roomName;
	/**顾客名称*/
    @Excel(name="顾客名称")
	private java.lang.String customerName;
	/**顾客编号*/
    @Excel(name="顾客编号")
	private java.lang.String customerNo;
	/**退房状态*/
	private java.lang.String outStatus;
	/**检查清单*/
	private java.lang.String checkInfo;
	/**是否换房*/
	private java.lang.String isChange;
	/**办理人*/
    @Excel(name="办理人")
	private java.lang.String inCharge;
	/**办理日期*/
    @Excel(name="办理日期",format = "yyyy-MM-dd")
	private java.util.Date dealDate;
	/**审核人*/
	private java.lang.String auditor;
	/**审核日期*/
	private java.util.Date auditDate;
	/**审核详情*/
	private java.lang.String auditDes;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	 *@return: java.lang.String  退房编号
	 */
	public java.lang.String getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退房编号
	 */
	public void setNo(java.lang.String no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入住id
	 */
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
	 *@return: java.lang.String  房间名称
	 */
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
	 *@return: java.lang.String  顾客名称
	 */
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
	 *@return: java.lang.String  退房状态
	 */
	public java.lang.String getOutStatus(){
		return this.outStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退房状态
	 */
	public void setOutStatus(java.lang.String outStatus){
		this.outStatus = outStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  检查清单
	 */
	public java.lang.String getCheckInfo(){
		return this.checkInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  检查清单
	 */
	public void setCheckInfo(java.lang.String checkInfo){
		this.checkInfo = checkInfo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否换房
	 */
	public java.lang.String getIsChange(){
		return this.isChange;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否换房
	 */
	public void setIsChange(java.lang.String isChange){
		this.isChange = isChange;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办理人
	 */
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */
	public java.util.Date getAuditDate(){
		return this.auditDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核日期
	 */
	public void setAuditDate(java.util.Date auditDate){
		this.auditDate = auditDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核详情
	 */
	public java.lang.String getAuditDes(){
		return this.auditDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核详情
	 */
	public void setAuditDes(java.lang.String auditDes){
		this.auditDes = auditDes;
	}

	/**保存-检查情况*/
    @ExcelCollection(name="检查情况")
	private List<CheckOutDesEntity> checkOutDesList = new ArrayList<CheckOutDesEntity>();
		public List<CheckOutDesEntity> getCheckOutDesList() {
		return checkOutDesList;
		}
		public void setCheckOutDesList(List<CheckOutDesEntity> checkOutDesList) {
		this.checkOutDesList = checkOutDesList;
		}
}
