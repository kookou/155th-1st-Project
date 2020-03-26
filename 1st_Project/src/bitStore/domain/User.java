package bitStore.domain;

import java.io.Serializable;

public class User implements Serializable {
	private String userID; //회원 ID
	private String userPwd; //회원 비밀번호
	private String userName; //회원명
	private String userPhone; //회원 핸드폰번호
	private int userPoint; //회원이 가지고있는 point
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	@Override
	public String toString() {
		return "회원님의 정보는 [ID : " + userID + ", PassWord : " + userPwd + ", 이름 : " + userName + ", 핸드폰 번호 : "
				+ userPhone + ", 포인트 : " + userPoint + "]" + "입니다.";
	}
}
