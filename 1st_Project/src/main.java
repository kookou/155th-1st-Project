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
		
		System.out.println("비밀번호를 입력하세요");
		user.setUserPwd(sc.nextLine());
		System.out.println("이름을 입력하세요");
		user.setUserName(sc.nextLine());
		System.out.println("핸드폰 번호를 입력하세요");
		user.setUserPhone(sc.nextLine()); //user class 의 ID setter 함수의 파라메터로 입력받은 값을 set 해줌
		user.setUserPoint(1000); // 최초 가입시 부여되는 포인트
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
						System.out.println("해당하는 ID가 이미 등록되어 있습니다. (5~15자 영문과 숫자를 조합해 주세요.)");
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
