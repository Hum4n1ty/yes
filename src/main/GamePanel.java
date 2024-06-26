package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	int FPS = 60;
	Thread gameThread;
	public KeyHandler keyH = new KeyHandler(this);
	public Player player1 = new Player(this, keyH);
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	final int screen_Width = dim.width;
	final int screen_Height = dim.height;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screen_Width, screen_Height));
		this.setBackground(Color.BLACK);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void run() {
		
		double drawInterval = 1000000000/FPS; // 0.03333333 sec
		double nextDrawTime = System.nanoTime() + drawInterval;
		while(gameThread != null) {
			
			// update information such as ant positions
			update();

			// redraw sim with updated information
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void update() {
		
		player1.update();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		player1.draw(g2);
		
		g2.dispose();
	}

}
