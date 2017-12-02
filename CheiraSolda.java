package cheirasolda;
import robocode.*;

//Libraries added
import java.util.Random;
import java.awt.*;

//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * CheiraSolda - a robot by (your name here)
 */
public class CheiraSolda extends AdvancedRobot
{
	/**
	 * run: CheiraSolda's default behavior
	 */
	int contBack = 0;
	
	public void run() {
		// Initialization of the robot should be put here
		
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setBodyColor(new Color(0, 200, 0));
		setGunColor(new Color(0, 150, 50));
		setRadarColor(new Color(0, 100, 100));
		setBulletColor(new Color(255, 255, 100));
		setScanColor(new Color(255, 200, 200));
		
		Random rand = new Random();
		int  n = rand.nextInt(2);
		
		// Robot main loop
		while(true) {
		//body movement
			if (n==0) {
				setTurnRight(90);
				ahead(100);
			}
			else {
				setTurnLeft(90);
				ahead(100);
			}
				
			n = rand.nextInt(2);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(10);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		execute();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		if(contBack<5){
			back(50);
			contBack++;
		}
		else if(contBack<=10) {
			execute();
			contBack++;
		}
		else
			contBack=0;
	}	
}
