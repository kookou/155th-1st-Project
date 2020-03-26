package bitStore.login.ui;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import bitStore.BaseUI;
import bitStore.BitStoreUI;
import bitStore.domain.User;
import bitStore.login.util.LoginJoinUtil;

public class LoginUI extends BaseUI {
	private LoginJoinUtil util;
	public static HashMap<String, User> userMap;
	private Scanner sc;
	public static User currentLoginUser;

	public LoginUI(LoginJoinUtil util) {
		this.util = util;
		sc = new Scanner(System.in);
	}

	public void loginCheck() {
		String filename = "UserList.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ins = null;

		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ins = new ObjectInputStream(bis);
			userMap = (HashMap) ins.readObject();

			Set<String> keys = userMap.keySet();
			for (String key : keys) {
				System.out.println(userMap.get(key).toString()); //���Ļ���
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ins.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		while (true) {
			System.out.println("�� Bit ������ �α��Ρ�");
			System.out.println("���̵� �Է����ּ��� : ");
			String userID = sc.nextLine().trim();

			if (!BitStoreUI.userMap.containsKey(userID)) {
				System.out.println("�ش��ϴ� ID�� �����ϴ�.");
				loginCheck();
			} else if (BitStoreUI.userMap.containsKey(userID)) {
				System.out.println("��й�ȣ�� �Է����ּ��� : ");
				String userPwd = sc.nextLine().trim();
				if (BitStoreUI.userMap.get(userID).getUserPwd().equals(userPwd)) {
					System.out.println("Bit �������� �α��� �Ǿ����ϴ�.");
					currentLoginUser = BitStoreUI.userMap.get(userID);
					break;
				} else {
					System.out.println("Password�� Ȯ���� �ּ���");
				}
			}
			
		}
	}

	@Override
	public void service() {
		loginCheck();
	}
}
