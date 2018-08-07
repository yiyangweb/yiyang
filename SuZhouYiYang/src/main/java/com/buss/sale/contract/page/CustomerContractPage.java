
package com.buss.sale.contract.page;
import com.buss.sale.contract.entity.CustomerContractEntity;
import com.buss.sale.contract.entity.ContractChargeListEntity;
import com.buss.sale.contract.entity.ChargeListEntity;
import com.buss.sale.contract.entity.CustomerContractSubEntity;

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
 * @Description: 签订合同记录
 * @author onlineGenerator
 * @date 2018-07-15 15:27:34
 * @version V1.0   
 *
 */
public class CustomerContractPage implements java.io.Serializable {
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
	/**客户id*/
	private java.lang.String customerId;
	/**客户名称*/
    @Excel(name="客户名称")
	private java.lang.String customerName;
	/**客户编号*/
    @Excel(name="客户编号")
	private java.lang.String customerNo;
	/**合同编号*/
    @Excel(name="合同编号")
	private java.lang.String no;
	/**所属*/
    @Excel(name="所属")
	private java.lang.String belongTo;
	/**合同类型*/
    @Excel(name="合同类型")
	private java.lang.String contractTypeId;
	/**是否分期*/
    @Excel(name="是否分期")
	private java.lang.String isInstalments;
	/**分期期数*/
    @Excel(name="分期期数")
	private java.lang.String numOfPeriods;
	/**付款进度*/
    @Excel(name="付款进度")
	private java.lang.String paymentStatus;
	/**楼栋id*/
	private java.lang.String buildingId;
	/**楼栋*/
    @Excel(name="楼栋")
	private java.lang.String buildingName;
	/**房间id*/
	private java.lang.String roomId;
	/**房间*/
    @Excel(name="房间")
	private java.lang.String roomName;
	/**房费*/
    @Excel(name="房费")
	private java.lang.String price;
	/**签订日期*/
    @Excel(name="签订日期",format = "yyyy-MM-dd")
	private java.util.Date signDate;
	/**合同状态*/
	private java.lang.String contractStatus;
	/**生效日期*/
    @Excel(name="生效日期",format = "yyyy-MM-dd")
	private java.util.Date beginDate;
	/**截止日期*/
    @Excel(name="截止日期",format = "yyyy-MM-dd")
	private java.util.Date endDate;
	/**负责人*/
    @Excel(name="负责人")
	private java.lang.String charger;
	/**启用标记*/
	private java.lang.String enabled;
	/**审核标记*/
	private java.lang.String approved;
	/**删除标记*/
	private java.lang.String deleted;
	/**附件*/
    @Excel(name="附件")
	private java.lang.String attach;
	
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
	 *@return: java.lang.String  客户id
	 */
	public java.lang.String getCustomerId(){
		return this.customerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户id
	 */
	public void setCustomerId(java.lang.String customerId){
		this.customerId = customerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编号
	 */
	public java.lang.String getCustomerNo(){
		return this.customerNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编号
	 */
	public void setCustomerNo(java.lang.String customerNo){
		this.customerNo = customerNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同编号
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同类型
	 */
	public java.lang.String getContractTypeId(){
		return this.contractTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同类型
	 */
	public void setContractTypeId(java.lang.String contractTypeId){
		this.contractTypeId = contractTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否分期
	 */
	public java.lang.String getIsInstalments(){
		return this.isInstalments;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否分期
	 */
	public void setIsInstalments(java.lang.String isInstalments){
		this.isInstalments = isInstalments;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分期期数
	 */
	public java.lang.String getNumOfPeriods(){
		return this.numOfPeriods;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分期期数
	 */
	public void setNumOfPeriods(java.lang.String numOfPeriods){
		this.numOfPeriods = numOfPeriods;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款进度
	 */
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
	 *@return: java.lang.String  楼栋id
	 */
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
	 *@return: java.lang.String  楼栋
	 */
	public java.lang.String getBuildingName(){
		return this.buildingName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼栋
	 */
	public void setBuildingName(java.lang.String buildingName){
		this.buildingName = buildingName;
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
	 *@return: java.lang.String  房间
	 */
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
	 *@return: java.lang.String  房费
	 */
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房费
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签订日期
	 */
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
	 *@return: java.lang.String  合同状态
	 */
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生效日期
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  负责人
	 */
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
	 *@return: java.lang.String  启用标记
	 */
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
	 *@return: java.lang.String  附件
	 */
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

	/**保存-收费列表*/
    @ExcelCollection(name="收费列表")
	private List<ContractChargeListEntity> contractChargeListList = new ArrayList<ContractChargeListEntity>();
		public List<ContractChargeListEntity> getContractChargeListList() {
		return contractChargeListList;
		}
		public void setContractChargeListList(List<ContractChargeListEntity> contractChargeListList) {
		this.contractChargeListList = contractChargeListList;
		}
	/**保存-分期情况*/
    @ExcelCollection(name="分期情况")
	private List<ChargeListEntity> chargeListList = new ArrayList<ChargeListEntity>();
		public List<ChargeListEntity> getChargeListList() {
		return chargeListList;
		}
		public void setChargeListList(List<ChargeListEntity> chargeListList) {
		this.chargeListList = chargeListList;
		}
	/**保存-附属合同*/
    @ExcelCollection(name="附属合同")
	private List<CustomerContractSubEntity> customerContractSubList = new ArrayList<CustomerContractSubEntity>();
		public List<CustomerContractSubEntity> getCustomerContractSubList() {
		return customerContractSubList;
		}
		public void setCustomerContractSubList(List<CustomerContractSubEntity> customerContractSubList) {
		this.customerContractSubList = customerContractSubList;
		}
}
