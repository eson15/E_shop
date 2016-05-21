package cn.it.shop.model;

import java.io.Serializable;

public class BackData implements Serializable {

	private static final long serialVersionUID = -4943843257769211397L;
	
	private String r0_Cmd;
	private String p1_MerId;
	private String r1_Code;
	private String r2_TrxId;
	private String r3_Amt;
	private String r4_Cur;
	private String r5_Pid;
	private String r6_Order;
	private String r7_Uid;
	private String r8_MP;
	private String r9_BType;
	private String hmac;
	 
	@Override
	public String toString() {
		return "BackData [r0_Cmd=" + r0_Cmd + ", p1_MerId=" + p1_MerId
				+ ", r1_Code=" + r1_Code + ", r2_TrxId=" + r2_TrxId
				+ ", r3_Amt=" + r3_Amt + ", r4_Cur=" + r4_Cur + ", r5_Pid="
				+ r5_Pid + ", r6_Order=" + r6_Order + ", r7_Uid=" + r7_Uid
				+ ", r8_MP=" + r8_MP + ", r9_BType=" + r9_BType + ", hmac="
				+ hmac + "]";
	}
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	public String getR0_Cmd() {
		return r0_Cmd;
	}
	public void setR0_Cmd(String r0Cmd) {
		r0_Cmd = r0Cmd;
	}
	public String getP1_MerId() {
		return p1_MerId;
	}
	public void setP1_MerId(String p1MerId) {
		p1_MerId = p1MerId;
	}
	public String getR1_Code() {
		return r1_Code;
	}
	public void setR1_Code(String r1Code) {
		r1_Code = r1Code;
	}
	public String getR2_TrxId() {
		return r2_TrxId;
	}
	public void setR2_TrxId(String r2TrxId) {
		r2_TrxId = r2TrxId;
	}
	public String getR3_Amt() {
		return r3_Amt;
	}
	public void setR3_Amt(String r3Amt) {
		r3_Amt = r3Amt;
	}
	public String getR4_Cur() {
		return r4_Cur;
	}
	public void setR4_Cur(String r4Cur) {
		r4_Cur = r4Cur;
	}
	public String getR5_Pid() {
		return r5_Pid;
	}
	public void setR5_Pid(String r5Pid) {
		r5_Pid = r5Pid;
	}
	public String getR6_Order() {
		return r6_Order;
	}
	public void setR6_Order(String r6Order) {
		r6_Order = r6Order;
	}
	public String getR7_Uid() {
		return r7_Uid;
	}
	public void setR7_Uid(String r7Uid) {
		r7_Uid = r7Uid;
	}
	public String getR8_MP() {
		return r8_MP;
	}
	public void setR8_MP(String r8MP) {
		r8_MP = r8MP;
	}
	public String getR9_BType() {
		return r9_BType;
	}
	public void setR9_BType(String r9BType) {
		r9_BType = r9BType;
	}
}
