package bitStore.domain;

import java.io.Serializable;

public class User implements Serializable {
	private String userID; //ȸ�� ID
	private String userPwd; //ȸ�� ��й�ȣ
	private String userName; //ȸ����
	private String userPhone; //ȸ�� �ڵ�����ȣ
	private int userPoint; //ȸ���� �������ִ� point
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
		return "ȸ������ ������ [ID : " + userID + ", PassWord : " + userPwd + ", �̸� : " + userName + ", �ڵ��� ��ȣ : "
				+ userPhone + ", ����Ʈ : " + userPoint + "]" + "�Դϴ�.";
	}
}
