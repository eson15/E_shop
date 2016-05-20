package cn.it.shop.model;

import java.io.Serializable;
/*
 * 商城到易宝支付发送的信息，封装为实体
 * */
public class SendData implements Serializable {

	private static final long serialVersionUID = -6304103739907145812L;
	
	private String p0_Cmd;
	private String p1_MerId;
	private String p2_Order;
	private String p3_Amt;
	private String p4_Cur;
	private String p5_Pid;
	private String p6_Pcat;
	private String p7_Pdesc;
	private String p8_Url;
	private String p9_SAF;
	private String pa_MP;
	private String pd_FrpId;
	private String pr_NeedResponse;

	public String getP0_Cmd() {
		return p0_Cmd;
	}
	public void setP0_Cmd(String p0Cmd) {
		p0_Cmd = p0Cmd;
	}
	public String getP1_MerId() {
		return p1_MerId;
	}
	public void setP1_MerId(String p1MerId) {
		p1_MerId = p1MerId;
	}
	public String getP2_Order() {
		return p2_Order;
	}
	public void setP2_Order(String p2Order) {
		p2_Order = p2Order;
	}
	public String getP3_Amt() {
		return p3_Amt;
	}
	public void setP3_Amt(String p3Amt) {
		p3_Amt = p3Amt;
	}
	public String getP4_Cur() {
		return p4_Cur;
	}
	public void setP4_Cur(String p4Cur) {
		p4_Cur = p4Cur;
	}
	public String getP5_Pid() {
		return p5_Pid;
	}
	public void setP5_Pid(String p5Pid) {
		p5_Pid = p5Pid;
	}
	public String getP6_Pcat() {
		return p6_Pcat;
	}
	public void setP6_Pcat(String p6Pcat) {
		p6_Pcat = p6Pcat;
	}
	public String getP7_Pdesc() {
		return p7_Pdesc;
	}
	public void setP7_Pdesc(String p7Pdesc) {
		p7_Pdesc = p7Pdesc;
	}
	public String getP8_Url() {
		return p8_Url;
	}
	public void setP8_Url(String p8Url) {
		p8_Url = p8Url;
	}
	public String getP9_SAF() {
		return p9_SAF;
	}
	public void setP9_SAF(String p9SAF) {
		p9_SAF = p9SAF;
	}
	public String getPa_MP() {
		return pa_MP;
	}
	public void setPa_MP(String paMP) {
		pa_MP = paMP;
	}
	public String getPd_FrpId() {
		return pd_FrpId;
	}
	public void setPd_FrpId(String pdFrpId) {
		pd_FrpId = pdFrpId;
	}
	public String getPr_NeedResponse() {
		return pr_NeedResponse;
	}
	public void setPr_NeedResponse(String prNeedResponse) {
		pr_NeedResponse = prNeedResponse;
	}
}
