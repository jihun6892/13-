import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class VibratingLabel extends JFrame {
	public VibratingLabel() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("진동레이블"); //레이블 안에 글자추가
		c.add(label);
		
		setSize(300,300);
		setLocation(500,500);
		setVisible(true);
		
		VibratingThread vt = new VibratingThread(label); //진동하는 레이블
		vt.start();
	}
	class VibratingThread extends Thread implements Runnable{
		JLabel la;
		public VibratingThread(JLabel la) {this.la = la;}
		public void run() {
			Random r = new Random();
			int x = la.getX();
			int y = la.getY();
			
			while(true) {
				try {
					Thread.sleep(10); //10ms 간격으로 sleep() 사용
				} catch(InterruptedException e) {return;}
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x+r.nextInt(5)*sign;
				if(r.nextBoolean()) sign = -1;
				else sign = -1;
				int tmpY = y+r.nextInt(5)*sign;
				la.setLocation(tmpX,tmpY);
			}
			
		}
	}
    public static void main(String[] args) {
    	new VibratingLabel();
    }
}
