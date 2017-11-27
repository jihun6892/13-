import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class CircleMove extends JFrame { //원 생성하기
	public CircleMove() {
		setTitle("원이 랜덤한 위치로 이동");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		final MyPanel panel = new MyPanel();
		setContentPane(panel);
		
		setSize(300,300);
		setVisible(true);
	}		


public class MyPanel extends JPanel {
	public MyPanel() {
		new Thread (new Runnable() {
			public void run() {
				try {
					while(true) {
						repaint();
						Thread.sleep(400); //400ms 간격으로 원 생성
					}
				} catch(Exception e) {return;}
			}
		}).start();
	}
	public void paintComponent(Graphics g) { //랜덤으로 원위치 변경
		Random r = new Random();
		int x = r.nextInt(getWidth()-50);
		int y = r.nextInt(getHeight()-50);
		g.clearRect(0,0,getWidth(),getHeight());
		g.drawOval(x,y,50,50);		
	 }
    }
    public static void main(String[] args) {
    	  new CircleMove();
      }
    }
   