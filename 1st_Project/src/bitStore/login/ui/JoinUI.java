package bitStore.login.ui;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bitStore.BaseUI;
import bitStore.BitStoreUI;
import bitStore.domain.User;
import bitStore.login.util.LoginJoinUtil;

public class JoinUI extends BaseUI {
	private LoginJoinUtil util;
	// public static HashMap<String, User> userMap;
	private Scanner sc;
	private User user;
	

	public JoinUI(LoginJoinUtil util) {
		this.util = util;
		sc = new Scanner(System.in);
	}

	public void IDCheck() {
		System.out.println("�� Bit ������ ȸ�������� ȯ�� �մϴ١�");
		System.out.println("����� ���̵� �Է����ּ��� ");
		System.out.println("(5~15�� ������ ���� �� ���ڸ� �������ּ���.)");
		// Iterator<String> it = userMap.keySet().iterator();
		Set<String> keys = BitStoreUI.userMap.keySet();

		while (true) {
			String userID = sc.nextLine().trim();
			Pattern idPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[^!@#$%^*+=-])(?=.*[^��-�R])(?=.*[0-9]).{5,15}$");
			Matcher matcher1 = idPattern.matcher(userID);

			for (String key : keys) {
				if (key.equals(userID)) {
					System.out.println("�̹� ������� ���̵��Դϴ�. �ٽ� �Է��� �ּ���");
					IDCheck();
				}
			}
			if (!matcher1.matches()) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("5~15�� ������ ���ڸ� �����Ͽ� �ٽ� �Է��� �ּ���");

			} else {
				user.setUserID(userID);
				return;
			}
		}
	}

	public void pwCheck() {
		System.out.println("����� ��й�ȣ�� �Է����ּ���.");
		System.out.println("(8~20�� ������ ���� �� ����,Ư�����ڸ� �������ּ���.)");
		while (true) {
			String userPwd = sc.nextLine().trim();
			Pattern pwPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$");
			Matcher matcher1 = pwPattern.matcher(userPwd);
			if (!matcher1.matches()) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("8~20�� ������ ���� �� ����,Ư�����ڸ� ������ �ٽ� �Է��� �ּ���.");
			} else {
				user.setUserPwd(userPwd);
				return;
			}
		}
	}

	public void nameCheck() {
		System.out.println("ȸ������ �̸��� �Է��� �ּ���.");
		System.out.println("(2�� �̻��� �ѱ��� �Է����ּ���.)");
		while (true) {
			String userName = sc.nextLine().trim();
			Pattern pwPattern = Pattern.compile("^(?=.*[��-�R]).{2,20}$");
			Matcher matcher1 = pwPattern.matcher(userName);
			if (!matcher1.matches()) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("2�� �̻��� �ѱ��� �Է����ּ���.");
			} else {
				user.setUserName(userName);
				return;
			}
		}
	}

	public void phoneCheck() {
		System.out.println("ȸ������ �ڵ��� ��ȣ�� �Է��� �ּ���.");
		System.out.println("(010-0000-0000 �������� �Է��� �ּ���.)");
		while (true) {
			String userPhone = sc.nextLine().trim();
			Pattern phonePattern = Pattern.compile("^01([0|1|0]?)-?([0-9]{3,4})-?([0-9]{4})$");

			Matcher matcher1 = phonePattern.matcher(userPhone);
			if (!matcher1.matches()) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("010-0000-0000 �������� �Է��� �ּ���.");
			} else {
				user.setUserPhone(userPhone);
				return;
			}
		}
	}

	public void userListWrite() {

		String filename = "UserList.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);
			out.writeObject(BitStoreUI.userMap);

			out.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service() {
		user = new User(); // �Լ��� ȣ���ϸ� user ��ü ����
		IDCheck();
		pwCheck();
		nameCheck();
		phoneCheck();
		user.setUserPoint(1000);
		BitStoreUI.userMap.put(user.getUserID(),user);
		userListWrite();

	}

}
