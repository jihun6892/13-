import java.util.Scanner;

public class CountingThreadConsole {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine(); // � Ű�� �ԷµǱ⸦ ��ٸ�
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start(); // ���� main()�� ����������, ������ th�� ��� ����
		
	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++) //1~10 ������ ���� ���
			System.out.print(i + " ");
		System.out.println();
		System.out.println("������ ����");
	}
}
