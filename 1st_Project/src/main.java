import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Set;

import bitStore.domain.User;

public class main {

	public static void main(String[] args) {
		HashMap<String,User> joinmap = new HashMap<String,User>();
		joinmap.put("akdk3030",new User());
		
		System.out.println("��й�ȣ�� �Է��ϼ���");
		user.setUserPwd(sc.nextLine());
		System.out.println("�̸��� �Է��ϼ���");
		user.setUserName(sc.nextLine());
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ���");
		user.setUserPhone(sc.nextLine()); //user class �� ID setter �Լ��� �Ķ���ͷ� �Է¹��� ���� set ����
		user.setUserPoint(1000); // ���� ���Խ� �ο��Ǵ� ����Ʈ
		joinMap.put(user.getUserID(), user);
		
		for(int i = 0; i <joinMap.size(); i++){
			System.out.println(joinMap.toString());
			
			
			String filename = "UserList.txt";
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			ObjectInputStream in = null;
			try {
				fis = new FileInputStream(filename);
				bis = new BufferedInputStream(fis);
				in = new ObjectInputStream(bis);
				userMap = (HashMap) in.readObject();
				Set<String> set = userMap.keySet();
				for (String checkID : set) {
					String ID = userMap.get(checkID).getUserID();
					if(ID == userID){
						System.out.println("�ش��ϴ� ID�� �̹� ��ϵǾ� �ֽ��ϴ�. (5~15�� ������ ���ڸ� ������ �ּ���.)");
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					in.close();
					bis.close();
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		

		

	}

}
