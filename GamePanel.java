package packaged;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import java.util.Random;



public class GamePanel extends JPanel implements ActionListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3320866452400429080L;
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 30;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final  int DELAY = 75;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
    final int x2[] = new int[GAME_UNITS];
    final int y2[] = new int[GAME_UNITS];
    // y2 and x2 is the lazer being spawned
int bodyParts= 6; 


int applesEaten;



int bombsEaten = 0;
int lives = 1;


int appleX;
int appleY; 


int changeColor = 0;
int bombX;
int bombY;
int DPX; //double points
int DPY; //double points
int DPfor = 1;
int bomb2X;
int bomb2Y;
int DPint;


int lazerX;
int lazerY;
// lazerX and Y is the thing that needs to be collected by snake for
// lazer to stop

char button = 'F';
char tapped = 'E';
char swap = 'Q';
char direction = 'L';


int bombRandom = 1;
boolean running = false; 
Timer timer;
Random random;
Random random2;
boolean playing = true;
	int z = 0;
	boolean addNew = true;
	boolean addNew2 = true;
	boolean addNew3 = true;
	boolean addNew4 = true;
	boolean addNew5 = true;
	boolean addNew6 = true;
	boolean addNewDP = true;
	boolean addNewDP2 = true;
	boolean addNewDP3 = true;
	boolean addNewDP4 = true;
	boolean addNewDP5 = true;
	boolean addNewDP6 = true;
	boolean DPFix = true;
	boolean DPFix2 = true;
	boolean DPFix3 = true;
	boolean DPFix4 = true;
	boolean DPFix5 = true;
	int changeKeys = 0;
	
	int appleCountPrint = 0;
	int appleCountPrint2 = 0;
	
	boolean DP1 = true;
	
	

GamePanel(){
	
	
	
	
	random = new Random();
	this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	this.setBackground(Color.BLACK);
	this.setFocusable(true);
	this.addKeyListener(new MyKeyAdapter());
	
	

	
	startGame();
	
	
	
}

public void lazer() {
	if (bombsEaten == 10) {
		
		if (y[0] > 300) {
		lazerX = 570;
		lazerY = 570;
		}
		else if (y[0] < 300) {
			lazerX = 570;
			lazerY = 0;
			
		}
	}
	
	
}



public void lazerCheck() {
	if(x[0] == x2[0] && y[0] == y2[0]) {
		running = false;
	}
	
	
}

	public static void main (String []args ) {
	
			
			
				
			
			
		
		}
	

	
	public void removeDoublePoints() {
		DPfor = 1;
		DPX = 700;
		DPY = 700;
		 DP1 = false;
	}
	
	public void newDoublePoints() {
		DP1 = true;
		Math.random();
		double randomNumber = Math.random();
		randomNumber = randomNumber*10;
		int randomInt = (int)randomNumber;
		
		if (DPfor == 1) {
		for(int i = randomInt; i == randomInt; i++) {
			//30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540 570 
			
			if(i == 1) {
				DPX = 30;
				DPY = 540;
			}if(i == 2) {
				DPX = 30;
				DPY = 120;
			}if(i == 3) {
				DPX = 540;
				DPY = 90;
			}if(i == 4) {
				DPX = 180;
				DPY = 540;
			}if(i == 5) {
				DPX = 30;
				DPY = 330;
			}if(i == 6) {
				DPX = 360;
				DPY = 30;
			}if(i == 7) {
				DPX = 420;
				DPY = 30;
			}
			if(i == 8) {
				DPX = 480;
				DPY = 510;
			}
			if(i == 9) {
				DPX = 60;
				DPY = 540;
			}
			
			
		}
		DPfor++;
		}
		
		
		
	}
	
	
	
	
	
	
	public void doublePointsCheck() {
	
		//player 1
		if((x[0] == DPX) && (y[0] == DPY)) {
			bodyParts += 2;
			applesEaten += 2;
		
			appleCountPrint += 2;
			System.out.println("Player  Has Eaten A Special Apple! Apple Count:  " + appleCountPrint );
			removeDoublePoints();
		}
		
		
		//player 2

	}
	
	
	
	
	
	
	public void startGame() {

		
		x[0] = 570;
		y[0] = 570;
		
		newApple();
		newBomb();
		newBomb2();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
		
		
		
	}
	
	
	
	
	
	public void checkApple() {
	
			
//player 1
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
			appleCountPrint++;
			System.out.println("Player  Has Eaten An Apple! Apple Count:  " + appleCountPrint );
		}
		
	
		
		
				
			}
	
	
	
	
	
	
	
	
	
	public void newApple() {
		
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		
		
	}
	
	
	

	
public void newBomb() {
	bombX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
	bombY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
}
public void newBomb2() {
	bomb2X = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
	bomb2Y = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
}

 
	public void checkBomb(){
		
	//player 1	
		if((x[0] == bombX) && (y[0] == bombY)) {
	
			System.out.println("Player  Has Stepped An A Bomb! (1) " );
			running = false;
			
		}
		if((x[0] == bomb2X) && (y[0] == bomb2Y)) {
		
			System.out.println("Player  Has Stepped An A Bomb! (2) " );
			running = false;
		
		}
		
		if 					   (bombX == 120 && bombY == 570 || bombX == 150 && bombY == 570 || bombX == 180 && bombY == 570 ||
								bombX == 210 && bombY == 240 || bombX == 270 && bombY == 570 || bombX == 300 && bombY == 570 ||
								bombX == 330 && bombY == 570 || bombX == 360 && bombY == 570 || bombX == 390 && bombY == 570 ||
								bombX == 420 && bombY == 570 || bombX == 450 && bombY == 570 || bombX == 480 && bombY == 570 || 
								bombX == 510 && bombY == 570 || bombX == 540 && bombY == 570 || bombX == 570 && bombY == 570)
		{
		
			newBomb();
		
			
		}
				
		
		if 	   (bomb2X == 120 && bomb2Y == 570 || bomb2X == 150 && bomb2Y == 570 || bomb2X == 180 && bomb2Y == 570 ||
				bomb2X == 210 && bomb2Y == 240 || bomb2X == 270 && bomb2Y == 570 || bomb2X == 300 && bomb2Y == 570 ||
				bomb2X == 330 && bomb2Y == 570 || bomb2X == 360 && bomb2Y == 570 || bomb2X == 390 && bomb2Y == 570 ||
				bomb2X == 420 && bomb2Y == 570 || bomb2X == 450 && bomb2Y == 570 || bomb2X == 480 && bomb2Y == 570 || 
				bomb2X == 510 && bomb2Y == 570 || bomb2X == 540 && bomb2Y == 570 || bomb2X == 570 && bomb2Y == 570)
{

newBomb2();


}
	}
			
	
		
	

	
	
	
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		draw(g);
		
		
	}
	
	
	
	
	



	
	public void draw(Graphics g) {
	if (running == false) {
		gameOver(g);
	}
		
		//if running start
		if (running) {
		g.setColor(Color.pink);
		g.fillRect(x2[0], y2[0], UNIT_SIZE, UNIT_SIZE);
		g.setColor(Color.white);
		g.fillOval(lazerX, lazerY, UNIT_SIZE, UNIT_SIZE);
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		g.setColor(Color.cyan);
		g.fillOval(bombX, bombY, UNIT_SIZE, UNIT_SIZE);
		g.setColor(Color.cyan);
		g.fillOval(bomb2X, bomb2Y, UNIT_SIZE, UNIT_SIZE);
		g.setColor(Color.magenta);
		g.fillOval(DPX, DPY, UNIT_SIZE, UNIT_SIZE);
		for(int i = 0; i< bodyParts;i++) {
			if(i == 0) {
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15 || i == 17 || i == 19 || i == 21 || i == 23 
					|| i == 25 || i == 27 || i == 29 || i == 31 || 
					i == 33 || i == 35 || i == 37 || i == 39 || i == 41 
					|| i == 41 || i == 43 || i == 45 || i == 47 || i == 49 || i == 51 || i == 53 || i == 55 || i == 57 || i == 59 || i == 61 || i == 63 ) {
				g.setColor(new Color(0,160,0)); 
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			else {
				g.setColor(new Color(30,180,0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			if(appleX == bombX && appleY == bombY ) {
				newApple();
			}
			if(appleX == bomb2X && appleY == bomb2Y ) {
				newApple();
			}
			if(DPX == appleX && DPY == appleY) {
				newApple();
			}
			if(DPX == bombX && DPY == bombY) {
				newDoublePoints();
			}	
			if(DPX == bomb2X && DPY == bomb2Y) {
				newDoublePoints();
			}
		}
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten))/2 , g.getFont().getSize());
	
		//&& DPFix
		//&& DPFix2
		//&& DPFix2
		//&& DPFix3
		//&& DPFix4
		if (applesEaten == 2 || applesEaten == 11 || applesEaten == 15 || applesEaten == 25  || applesEaten == 31 ) {
			DP1 = true;
		}
		
		else {
			DP1 = false;
		}
		
		
		
		
	
			if(DP1 != true) {
				DPX = 700;
				DPY = 700;
			}
			else {
				newDoublePoints();
				DPFix = false;
			}
			
		}
		
		
		
		
		
	if (applesEaten == 35) {
gameWon(g);


	}
		if(applesEaten == 3 && addNewDP || applesEaten == 12 && addNewDP2 || applesEaten == 17 && addNewDP3 || applesEaten == 26 && addNewDP4 || applesEaten == 32 && addNewDP5)
		{
		
		if (applesEaten == 3) {
			newDoublePoints();
			System.out.println("Player Has Missed Double Points");
				addNewDP = false;
		}
		else if (applesEaten == 12) {
			newDoublePoints();
			System.out.println("Player Has Missed Double Points");
				addNewDP2 = false;
		}
		else if (applesEaten == 17) {
			newDoublePoints();
			System.out.println("Player Has Missed Double Points");
		
			addNewDP3 = false;
		}
		else if (applesEaten == 26) {
			newDoublePoints();
			System.out.println("Player Has Missed Double Points");
			addNewDP4 = false;
		}
		else if (applesEaten == 32) {
			newDoublePoints();
			System.out.println("Player Has Missed Double Points");
				addNewDP5 = false;
		}
		else {
			removeDoublePoints();
		}
		
		
		
		if (applesEaten != 3 || applesEaten != 12 || applesEaten != 17 || applesEaten != 26 || applesEaten != 32) {
			removeDoublePoints();	
		}
		}
			if (applesEaten == 5  && addNew || applesEaten == 10  && addNew2 || applesEaten == 15  && addNew3 || applesEaten == 20  && addNew4 || applesEaten == 25  && addNew5 || applesEaten == 30  && addNew6) {
				
				{
					
			   
				
				
				if (applesEaten == 5) {
					
					newBomb();
						newBomb2();
					addNew = false;
				}
				if (applesEaten == 10) {
					 newBomb();
						newBomb2();
					addNew2 = false;
				}
				if (applesEaten == 15) {
					 newBomb();
					
						newBomb2();	
					addNew3 = false;
				}
				if (applesEaten == 20) {
					
					newBomb();
						newBomb2();
					addNew4 = false;
				}
				if (applesEaten == 25) {
					 newBomb();
						newBomb2();
					addNew5 = false;
				}
				if (applesEaten == 30) {
					
					newBomb();
						newBomb2();
					addNew6 = false;
				}
				
											
			}
			}
			
			
	

			
		
		
		

			
		
		
		
	
		
		
		
		
		
	

		}	

//draw end
	
	
	
	
public void gameWon(Graphics g) {
		
		//game over text
		
		g.setColor(Color.green);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Winner!", (SCREEN_WIDTH - metrics.stringWidth("Winner!"))/2 , SCREEN_HEIGHT/2);
		
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free", Font.BOLD, 45));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Play Again? Press F!", (SCREEN_WIDTH - metrics1.stringWidth("Play Again? Press F!"))/2 , SCREEN_HEIGHT/3);
	
		g.setColor(Color.cyan);
		g.setFont(new Font("Ink Free", Font.BOLD, 30));
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		g.drawString("To Continue Collect Another Apple!", (SCREEN_WIDTH - metrics3.stringWidth("To Continue Collect Another Apple!"))/2 , SCREEN_HEIGHT/5);
		
		
		
	}
	
	
	
	
public void gameOver(Graphics g) {
		
		//game over text
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2 , SCREEN_HEIGHT/2);
		
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free", Font.BOLD, 45));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Play Again? Press F!", (SCREEN_WIDTH - metrics1.stringWidth("Play Again? Press F!"))/2 , SCREEN_HEIGHT/3);
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + applesEaten))/2 , g.getFont().getSize());
		
		
		}
	
	
	
	
	//end graphics g
	
	
	
	public void move() {
	
		for(int i = bodyParts; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
			
		}
		
		
		
		
		switch(direction) {
		case 'U':
		y[0] = y[0] - UNIT_SIZE;
		break;
		
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
			
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
			
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
			
			
			
		}
		
		
	}
	
//	public void randomDeathMessage() {
//	
//		Math.random();
//		double randomNumber = Math.random();
//		randomNumber = randomNumber*5;
//		int randomInt = (int)randomNumber;
//		
//		
//		for(int i = randomInt; i == randomInt; i++) {
//			if (i == 1) {
//				String death1 = ("Cought Themself");
//			}
//			
//	}
//	}
	
	
	
	public void checkCollisions() {

		
		
		//checks if head collides with body
	for(int i1 = bodyParts; i1 > 0; i1--) {
		if((x[0] == x[i1] && y[0] == y[i1])) {
			running = false;
			
		}
	
		if(DP1) {
		if((x[0] == DPX && y[0] == DPY)) {
			doublePointsCheck();
			DP1 = false;
		}
		}
	if (x[i1] == bombX && y[i1] == bombY || x[i1] == bomb2X && y[i1] == bomb2Y ) {
		
		if (lives == 1) {
			System.out.println("Player Has Stepped On A Bomb!");
			running = false;
			
		}
		else {
			System.out.println("Player Has Stepped On A Bomb!");
			lives--;
		}
	
	
	}
	
	}
		
		
		
		
	
		// GAME IS NOT 600x600 IT IS 570x570
	
		if(x[0] < 0 ) {
			running = false;
			System.out.println("Player Has Hit The Left Border");
		}
		
		//right border
		if(x[0] > 570) {
			running = false;
			System.out.println("Player Has Hit The Right Border");
		}
		
		
		if(y[0] < 0) {
			running = false;
			System.out.println("Player Has Hit The Top Border");
		}
	
		//check if head touches bottom border
		if(y[0] > 570) {
			running = false;
			System.out.println("Player Has Hit The Bottom Border");
		}
		if(!running) {
			timer.stop();
		}
		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	public void changeColorVoid() {
		if (changeColor == 1 || changeColor == 3 || changeColor == 5 || changeColor == 7 || changeColor == 9 || changeColor == 11 || changeColor == 13 || changeColor == 15 || changeColor == 17  ) {
			setBackground(Color.WHITE);
changeColor++;
		}
		else if (changeColor == 0 || changeColor == 2 || changeColor == 4 || changeColor == 6 || changeColor == 8 || changeColor == 10 || changeColor == 12 || changeColor == 14 || changeColor == 16 || changeColor == 18  ) {
			setBackground(Color.BLACK);
			changeColor++;
		}
		else {
			setBackground(Color.BLACK);
			changeColor++;
		}
		
	}
	
	
	
	
	
	
	
		
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
			checkBomb();
			
		}
		repaint();
		
	}
	
	
	
public class MyKeyAdapter extends KeyAdapter{

	
	
	
	
public void keyPressed(KeyEvent e) {
	
	switch(e.getKeyCode()) {
	case KeyEvent.VK_LEFT:
		if(direction != 'R') {
			direction = 'L';
		}
		break;
		
		
	case KeyEvent.VK_RIGHT:
		if(direction != 'L') {
			direction = 'R';
		}
		break;

	case KeyEvent.VK_UP:
		if(direction != 'D') {
			direction = 'U';
		}
		break;
		
	case KeyEvent.VK_DOWN:
		if(direction != 'U') {
			direction = 'D';
		}
		break;
	case KeyEvent.VK_F:
		
		
		new GameFrame();
			
		
		break;
	case KeyEvent.VK_E:
		if (changeColor == 1 || changeColor == 3 || changeColor == 5 || changeColor == 7 || changeColor == 9 || changeColor == 11 || changeColor == 13 || changeColor == 15 || changeColor == 17 || changeColor == 19 ) {
			setBackground(Color.ORANGE);
			
			
			
changeColor++;
		}
		else if (changeColor == 0 || changeColor == 2 || changeColor == 4 || changeColor == 6 || changeColor == 8 || changeColor == 10 || changeColor == 12 || changeColor == 14 || changeColor == 16 || changeColor == 18  ) {
			setBackground(Color.BLACK);

			
			
			changeColor++;
		}
		else {
			setBackground(Color.BLACK);
			
			
			
			
			changeColor++;
		}
		
		
		
		break;	
	                                                                                                                                                                        
		
}
}
}
}

