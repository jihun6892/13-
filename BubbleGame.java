import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BubbleGame extends JFrame{
	public BubbleGame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300,300);	
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new BubbleGame();
	}
}
class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(null);
		// 클릭하면 버블 생성
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();
			}
		});
	}	
	class BubbleThread extends Thread {
		JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("images/target.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble); // GamePanel에 add()
			repaint();
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX();
				int y = bubble.getY() - 5; // 버블의 y 좌표를 -5씩함으로써 이동
				
				
				if(y < 0) {
					remove(bubble);
					repaint();
					return; 
				}
				// 버블의 현재 위치를 설정
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}