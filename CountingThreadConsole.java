import java.util.Scanner;

public class CountingThreadConsole {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); // 어떤 키라도 입력되기를 기다림
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start(); // 지름 main()은 종료하지만, 스레드 th는 살아 있음
		
	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++) //1~10 사이의 숫자 출력
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
