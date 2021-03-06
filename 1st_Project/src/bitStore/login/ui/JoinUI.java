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
		System.out.println("※ Bit 편의점 회원가입을 환영 합니다※");
		System.out.println("사용할 아이디를 입력해주세요 ");
		System.out.println("(5~15자 사이의 영문 과 숫자를 조합해주세요.)");
		// Iterator<String> it = userMap.keySet().iterator();
		Set<String> keys = BitStoreUI.userMap.keySet();

		while (true) {
			String userID = sc.nextLine().trim();
			Pattern idPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[^!@#$%^*+=-])(?=.*[^가-힣])(?=.*[0-9]).{5,15}$");
			Matcher matcher1 = idPattern.matcher(userID);

			for (String key : keys) {
				if (key.equals(userID)) {
					System.out.println("이미 사용중인 아이디입니다. 다시 입력해 주세요");
					IDCheck();
				}
			}
			if (!matcher1.matches()) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("5~15자 영문과 숫자를 조합하여 다시 입력해 주세요");

			} else {
				user.setUserID(userID);
				return;
			}
		}
	}

	public void pwCheck() {
		System.out.println("사용할 비밀번호를 입력해주세요.");
		System.out.println("(8~20자 사이의 영문 과 숫자,특수문자를 조합해주세요.)");
		while (true) {
			String userPwd = sc.nextLine().trim();
			Pattern pwPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$");
			Matcher matcher1 = pwPattern.matcher(userPwd);
			if (!matcher1.matches()) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("8~20자 사이의 영문 과 숫자,특수문자를 조합해 다시 입력해 주세요.");
			} else {
				user.setUserPwd(userPwd);
				return;
			}
		}
	}

	public void nameCheck() {
		System.out.println("회원님의 이름을 입력해 주세요.");
		System.out.println("(2자 이상의 한글을 입력해주세요.)");
		while (true) {
			String userName = sc.nextLine().trim();
			Pattern pwPattern = Pattern.compile("^(?=.*[가-힣]).{2,20}$");
			Matcher matcher1 = pwPattern.matcher(userName);
			if (!matcher1.matches()) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("2자 이상의 한글을 입력해주세요.");
			} else {
				user.setUserName(userName);
				return;
			}
		}
	}

	public void phoneCheck() {
		System.out.println("회원님의 핸드폰 번호를 입력해 주세요.");
		System.out.println("(010-0000-0000 형식으로 입력해 주세요.)");
		while (true) {
			String userPhone = sc.nextLine().trim();
			Pattern phonePattern = Pattern.compile("^01([0|1|0]?)-?([0-9]{3,4})-?([0-9]{4})$");

			Matcher matcher1 = phonePattern.matcher(userPhone);
			if (!matcher1.matches()) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("010-0000-0000 형식으로 입력해 주세요.");
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
		user = new User(); // 함수를 호출하면 user 객체 생성
		IDCheck();
		pwCheck();
		nameCheck();
		phoneCheck();
		user.setUserPoint(1000);
		BitStoreUI.userMap.put(user.getUserID(),user);
		userListWrite();

	}

}
