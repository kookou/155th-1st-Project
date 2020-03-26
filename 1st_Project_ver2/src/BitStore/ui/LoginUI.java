package BitStore.ui;

import java.util.Scanner;

import BitStore.ui.admin.MemberUI;
import BitStore.ui.admin.ProductUI;
import BitStore.ui.user.BitStoreUI;
import BitStore.ui.user.UserUI;

public class LoginUI {
	private Scanner sc = null;
	private BoardUI boardUI;
	private BitStoreUI bitstoreUI;
	private MemberUI memberUI;
	private ProductUI productUI;
	private UserUI userUI;
	
	public LoginUI() {
		sc = new Scanner(System.in);
//		boardUI = new BoardUI(); // ���� - �Խ���
		bitstoreUI = new BitStoreUI(); // ����� - ������ �̿�
		memberUI = new MemberUI(); //������ - ȸ������
		productUI = new ProductUI(); //������ - ��ǰ����
		userUI = new UserUI(); //���� - �α��� 
	}

	// �������� ���
	public void admin() {
		while (true) {
			switch (adminMenu()) {
			case 1: // ȸ�� ����
				memberUI.admin();
				break;
			case 2: // ��ǰ ����
				productUI.admin();
				break;
			case 3: //�Խ���
				boardUI.commonBoard();
				break;
			case 4: // �α׾ƿ�
				userUI.service();
				//�α׾ƿ��� BitStore�� �ִ� currentLoginUser null�� �ʱ�ȭ �߰�
			case 0:
				quit();
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	// ������� ���
	public void user() {
		UserUI user = new UserUI();
		while (true) {
			switch (userMenu()) {
			case 1: //������ �̿�
				bitstoreUI.user();
				break;
			case 2:  // �Խ���
				boardUI.commonBoard();
				break;
			case 3: // ȸ������ ����
				//UserŬ������ updateUser(User) : boolean ȣ��
				break;
			case 4: // �α׾ƿ�
				userUI.service();
				//�α׾ƿ��� BitStore�� �ִ� currentLoginUser null�� �ʱ�ȭ �߰�
			case 0:
				quit();
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	private void quit() {
		System.out.println("�ȳ��� ������^^!");
		System.exit(0);
	}

	private int adminMenu() {
		System.out.println("-----------------");
		System.out.println("1. ȸ������");
		System.out.println("2. ��ǰ����");
		System.out.println("3. �Խ���");
		System.out.println("4. �α׾ƿ�");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}

	private int userMenu() {
		System.out.println("-----------------");
		System.out.println("1. ������ �̿�");
		System.out.println("2. �Խ���");
		System.out.println("3. ȸ������ ����");
		System.out.println("4. �α׾ƿ�");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}
}
