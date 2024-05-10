package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entities {
	
	GamePanel gp;
	KeyHandler keyH;
	BufferedImage image;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.solidAreaDefaultX = 50;
		this.solidAreaDefaultY = 30;
		this.id = 1;
		this.x = 100;
		this.y = 100;
		this.spd = 5;
		this.keyH = keyH;
		try {
		image = ImageIO.read(getClass().getResourceAsStream("/sprites/ships/Fighter.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		if (keyH.upPressed == true) {
			this.y -= spd;
		}
		else if (keyH.leftPressed == true) {
			this.x -= spd;
		}
		else if (keyH.downPressed == true) {
			this.y += spd;
		}
		else if (keyH.rightPressed == true) {
			this.x += spd;
		}
		else {
			
		}
		
	}

	public void draw(Graphics g2) {
		
		g2.setColor(new Color(255, 255, 255, 255));
		
		g2.drawImage(image, this.x, this.y, this.solidAreaDefaultX, this.solidAreaDefaultX, null);
		//g2.fillRect(this.x, this.y, this.solidAreaDefaultX, this.solidAreaDefaultX);
		
	}
	
}
