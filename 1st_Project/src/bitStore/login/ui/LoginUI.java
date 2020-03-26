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
				System.out.println(userMap.get(key).toString()); //추후삭제
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
			System.out.println("※ Bit 편의점 로그인※");
			System.out.println("아이디를 입력해주세요 : ");
			String userID = sc.nextLine().trim();

			if (!BitStoreUI.userMap.containsKey(userID)) {
				System.out.println("해당하는 ID가 없습니다.");
				loginCheck();
			} else if (BitStoreUI.userMap.containsKey(userID)) {
				System.out.println("비밀번호를 입력해주세요 : ");
				String userPwd = sc.nextLine().trim();
				if (BitStoreUI.userMap.get(userID).getUserPwd().equals(userPwd)) {
					System.out.println("Bit 편의점에 로그인 되었습니다.");
					currentLoginUser = BitStoreUI.userMap.get(userID);
					break;
				} else {
					System.out.println("Password를 확인해 주세요");
				}
			}
			
		}
	}

	@Override
	public void service() {
		loginCheck();
	}
}
