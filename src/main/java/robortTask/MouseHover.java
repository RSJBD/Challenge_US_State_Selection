package robortTask;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.text.BreakIterator;


public class MouseHover {

	public static void main(String[] args) throws AWTException, InterruptedException {

		Robot r=new Robot();
		Point point = MouseInfo.getPointerInfo().getLocation();

		int mouseX = point.x;
		int mouseY = point.y;
		//		for (int y = 0; y < args.length; y++) {
		//			r.mouseMove(mouseX, y);
		//			
		//		}
		//		for (int x = 0; x < args.length; x++) {
		//			r.mouseMove(x,mouseY);
		//		}

	/*	int x = 0;
		int changeX=mouseX;
		task1:	while (true)
		{

			r.mouseMove(changeX,mouseY);
			System.out.println(changeX+","+mouseY);
			changeX=changeX+2;
			System.err.println(x);
			x++;
			Thread.sleep(5000);
			if (changeX==mouseX+20)
			{
				break task1;	
			}
		}
int o=0;
		int y = 0;
		int changeY=mouseY;
		task2:	while (true)
		{ 
			if (changeY >= 0 && changeY <= changeY+20 ) {
				r.mouseMove(mouseX,changeY);
				System.out.println(mouseX+","+changeY);
				changeY=changeY+2;
				System.err.println(y);
				y++;
				Thread.sleep(5000);
				
			} else {
				break task2;
			}

			

		}*/

		for (int value = 5; value >= 0 && value <= 1000 || value<= 1080; value++) {
		    System.out.println(value);
		}


	}

}

