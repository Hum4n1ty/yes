package main;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window {

	public static GamePanel gp = new GamePanel();
	
	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		final int screen_Width = dim.width;
		final int screen_Height = dim.height;
		
		JFrame window = new JFrame();
		window.setSize(screen_Width, screen_Height);
		window.setResizable(false);
		window.setUndecorated(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(Frame.MAXIMIZED_BOTH);
		window.setTitle("YES!!");
		
		window.add(gp);
		window.setVisible(true);

	}

}
