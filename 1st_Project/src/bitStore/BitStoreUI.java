package bitStore;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bitStore.domain.User;
import bitStore.login.ui.JoinUI;
import bitStore.login.ui.LoginUI;
import bitStore.login.util.LoginJoinUtil;
import bitStore.user.ui.FindIDPwdUI;

public class BitStoreUI {
	public static Map<String, User> userMap = new HashMap<String, User>();
	
	public BitStoreUI(){
		String filename = "UserList.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ins = null;

		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ins = new ObjectInputStream(bis);
			userMap = (HashMap)ins.readObject(); 

			Set<String> keys = userMap.keySet();
			for (String key : keys) {
				System.out.println(userMap.get(key).toString());//���Ļ���
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
		
	}
	
	private LoginJoinUtil util = new LoginJoinUtil();
	private Scanner sc = new Scanner(System.in);
	public void service() {
		BaseUI ui = null;
		while (true) {
			switch (menu()) {
			case 1: ui = new JoinUI(util);   break;
			case 2: ui = new LoginUI(util); break;
			case 3: ui = new FindIDPwdUI(); break;
			case 4: ui = new FindIDPwdUI(); break;
			case 0: quit();
			}
			ui.service();
		}
	}

	private void quit() {
		System.out.println("�ȳ��� ������.");
		System.exit(0);
	}

	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("3. ���̵� ã��");
		System.out.println("4. ��й�ȣ ã��");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}
}
