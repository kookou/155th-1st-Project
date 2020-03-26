package bitStore.user.ui;

import java.util.Scanner;

import bitStore.BaseUI;
import bitStore.login.ui.LoginUI;


public class FindIDPwdUI extends BaseUI{
	private Scanner sc;
	public FindIDPwdUI(){
		sc = new Scanner(System.in);
	}
	
	public void FindID(){
		System.out.println("찾고 싶은 아이디의 이름을 입력해주세요");
		String userName = sc.nextLine().trim();
		for(int i = 0; i < LoginUI.currentLoginUser.getUserName().length(); i++){
			
		}
		while(true){
			
		}
	}
	
	
	@Override
	public void service() {
		
	}
	

}
