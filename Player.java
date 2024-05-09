package main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entities {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.solidAreaDefaultX = 25;
		this.solidAreaDefaultY = 25;
		this.id = 1;
		this.x = 100;
		this.y = 100;
		this.spd = 5;
		this.keyH = keyH;
		
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
		
		g2.fillRect(this.x, this.y, this.solidAreaDefaultX, this.solidAreaDefaultY);
		
	}
	
}
