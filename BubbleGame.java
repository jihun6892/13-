import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BubbleGame extends JFrame{
	public BubbleGame() {
		setTitle("���� ����");
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
		// Ŭ���ϸ� ���� ����
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
			add(bubble); // GamePanel�� add()
			repaint();
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX();
				int y = bubble.getY() - 5; // ������ y ��ǥ�� -5�������ν� �̵�
				
				
				if(y < 0) {
					remove(bubble);
					repaint();
					return; 
				}
				// ������ ���� ��ġ�� ����
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