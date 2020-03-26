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
		System.out.println("¡Ø Bit ÆíÀÇÁ¡ È¸¿ø°¡ÀÔÀ» È¯¿µ ÇÕ´Ï´Ù¡Ø");
		System.out.println("»ç¿ëÇÒ ¾ÆÀÌµğ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä ");
		System.out.println("(5~15ÀÚ »çÀÌÀÇ ¿µ¹® °ú ¼ıÀÚ¸¦ Á¶ÇÕÇØÁÖ¼¼¿ä.)");
		// Iterator<String> it = userMap.keySet().iterator();
		Set<String> keys = BitStoreUI.userMap.keySet();

		while (true) {
			String userID = sc.nextLine().trim();
			Pattern idPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[^!@#$%^*+=-])(?=.*[^°¡-ÆR])(?=.*[0-9]).{5,15}$");
			Matcher matcher1 = idPattern.matcher(userID);

			for (String key : keys) {
				if (key.equals(userID)) {
					System.out.println("ÀÌ¹Ì »ç¿ëÁßÀÎ ¾ÆÀÌµğÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
					IDCheck();
				}
			}
			if (!matcher1.matches()) {
				System.out.println("Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
				System.out.println("5~15ÀÚ ¿µ¹®°ú ¼ıÀÚ¸¦ Á¶ÇÕÇÏ¿© ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");

			} else {
				user.setUserID(userID);
				return;
			}
		}
	}

	public void pwCheck() {
		System.out.println("»ç¿ëÇÒ ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		System.out.println("(8~20ÀÚ »çÀÌÀÇ ¿µ¹® °ú ¼ıÀÚ,Æ¯¼ö¹®ÀÚ¸¦ Á¶ÇÕÇØÁÖ¼¼¿ä.)");
		while (true) {
			String userPwd = sc.nextLine().trim();
			Pattern pwPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$");
			Matcher matcher1 = pwPattern.matcher(userPwd);
			if (!matcher1.matches()) {
				System.out.println("Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
				System.out.println("8~20ÀÚ »çÀÌÀÇ ¿µ¹® °ú ¼ıÀÚ,Æ¯¼ö¹®ÀÚ¸¦ Á¶ÇÕÇØ ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			} else {
				user.setUserPwd(userPwd);
				return;
			}
		}
	}

	public void nameCheck() {
		System.out.println("È¸¿ø´ÔÀÇ ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		System.out.println("(2ÀÚ ÀÌ»óÀÇ ÇÑ±ÛÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä.)");
		while (true) {
			String userName = sc.nextLine().trim();
			Pattern pwPattern = Pattern.compile("^(?=.*[°¡-ÆR]).{2,20}$");
			Matcher matcher1 = pwPattern.matcher(userName);
			if (!matcher1.matches()) {
				System.out.println("Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
				System.out.println("2ÀÚ ÀÌ»óÀÇ ÇÑ±ÛÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			} else {
				user.setUserName(userName);
				return;
			}
		}
	}

	public void phoneCheck() {
		System.out.println("È¸¿ø´ÔÀÇ ÇÚµåÆù ¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		System.out.println("(010-0000-0000 Çü½ÄÀ¸·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.)");
		while (true) {
			String userPhone = sc.nextLine().trim();
			Pattern phonePattern = Pattern.compile("^01([0|1|0]?)-?([0-9]{3,4})-?([0-9]{4})$");

			Matcher matcher1 = phonePattern.matcher(userPhone);
			if (!matcher1.matches()) {
				System.out.println("Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
				System.out.println("010-0000-0000 Çü½ÄÀ¸·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
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
		user = new User(); // ÇÔ¼ö¸¦ È£ÃâÇÏ¸é user °´Ã¼ »ı¼º
		IDCheck();
		pwCheck();
		nameCheck();
		phoneCheck();
		user.setUserPoint(1000);
		BitStoreUI.userMap.put(user.getUserID(),user);
		userListWrite();

	}

}
