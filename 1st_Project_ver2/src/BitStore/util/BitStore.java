package BitStore.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BitStore.domain.BoardVO;
import BitStore.domain.ProductVO;
import BitStore.domain.UserVO;

public class BitStore {
	public static Map<String, UserVO> userList = new HashMap<>();
	public static Map<Integer, ProductVO> productList = new HashMap<>();
	public static Map<Integer, ProductVO> discardProductList = new HashMap<>();
	public static Map<Integer, BoardVO> boardList = new HashMap<>();
	public static UserVO currentLoginUser;
	private Scanner sc;
	private UserVO user;

	public BitStore() {
		sc = new Scanner(System.in);
	}

	public void join() {
		user = new UserVO();
		checkID();
		checkPwd();
		System.out.println("È¸¿ø´ÔÀÇ ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		user.setUserName(sc.nextLine().trim());
		checkPhone();
		user.setUserPoint(1000);
		System.out.println("È¸¿ø´ÔÀÇ ÀÜ¾×À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		user.setMoney(Integer.parseInt(sc.nextLine().trim()));
		checkPoint();
		user.setOrderList(null);
		userList.put(user.getID(), user);
		writeUserList();

	}

	public void checkID() {
		System.out.println("¡Ø Bit ÆíÀÇÁ¡ È¸¿ø°¡ÀÔÀ» È¯¿µ ÇÕ´Ï´Ù¡Ø");
		System.out.println("»ç¿ëÇÒ ¾ÆÀÌµğ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä ");
		System.out.println("(5~15ÀÚ »çÀÌÀÇ ¿µ¹® °ú ¼ıÀÚ¸¦ Á¶ÇÕÇØÁÖ¼¼¿ä.)");
		Set<String> keys = userList.keySet();

		while (true) {
			String userID = sc.nextLine().trim();
			Pattern idPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[^!@#$%^*+=-])(?=.*[^°¡-ÆR])(?=.*[0-9]).{5,15}$");
			Matcher matcher1 = idPattern.matcher(userID);

			for (String key : keys) {
				if (key.equals(userID)) {
					System.out.println("ÀÌ¹Ì »ç¿ëÁßÀÎ ¾ÆÀÌµğÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
					checkID();
				}
			}
			if (!matcher1.matches()) {
				System.out.println("Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
				System.out.println("5~15ÀÚ ¿µ¹®°ú ¼ıÀÚ¸¦ Á¶ÇÕÇÏ¿© ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");

			} else {
				user.setID(userID);
				return;
			}
		}
	}

	public void checkPwd() {
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
				user.setPwd(userPwd);
				return;
			}
		}
	}

	public void checkPhone() {
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
	public void checkPoint(){
		System.out.println("ÇÒÀÎÄ«µå¸¦ ¼ÒÁöÇÏ¼Ì´Ù¸é 1¹øÀ» ¾ø´Ù¸é 2¹øÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		while (true) {
			if (sc.nextLine().equals("1")) {
				user.setDiscount(true);
				break;
			} else if (sc.nextLine().equals("2")) {
				user.setDiscount(false);
				break;
			} else {
				System.out.println("Àß¸øÀÔ·Â ÇÏ¼Ì½À´Ï´Ù.");
			}
		}
	}

	public void writeUserList() {
		String filename = "UserList.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);
			out.writeObject(userList);

			out.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void login() {
		String filename = "UserList.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ins = null;

		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ins = new ObjectInputStream(bis);
			userList = (HashMap) ins.readObject();

			Set<String> keys = userList.keySet();
			for (String key : keys) {
				System.out.println(userList.get(key).toString()); //ÃßÈÄ»èÁ¦
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
			System.out.println("¡Ø Bit ÆíÀÇÁ¡ ·Î±×ÀÎ¡Ø");
			System.out.println("¾ÆÀÌµğ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä : ");
			String userID = sc.nextLine().trim();

			if (!userList.containsKey(userID)) {
				System.out.println("ÇØ´çÇÏ´Â ID°¡ ¾ø½À´Ï´Ù.");
				login();
			} else if (userList.containsKey(userID)) {
				System.out.println("ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä : ");
				String userPwd = sc.nextLine().trim();
				if (userList.get(userID).getPwd().equals(userPwd)) {
					System.out.println("Bit ÆíÀÇÁ¡¿¡ ·Î±×ÀÎ µÇ¾ú½À´Ï´Ù.");
					break;
				} else {
					System.out.println("Password¸¦ È®ÀÎÇØ ÁÖ¼¼¿ä");
				}
			}
		}

	}

	public void logout() {

	}

	public String findID(String userName, String userPhone) {
		return "ID";
	}

	public String findPwd(String ID, String userName) {
		return "pwd";
	}

	public void readUserList() {

	}

	public void readProductList() {

	}

	public void readDiscardProductList() {

	}

	public void readBoardList() {

	}
}
