package robortTaskMouseHover;

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

		int x = 0;
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
			if (changeY >= 0 && changeY <= mouseY+20 ) {
				r.mouseMove(mouseX,changeY);
				System.out.println(mouseX+","+changeY);
				changeY+=2;
				System.err.println(y);
				y++;
				Thread.sleep(5000);

			} else {
				break task2;
			}



		}
		/*
		for (int mouseX1 = 1075; mouseX1 >= 0 && mouseX1<= mouseY; mouseX1++)
		{
			for (int mouseY1 = 0; mouseY1 >= 0 && mouseY1<= mouseY; mouseY1++) 
			{
				r.mouseMove(mouseX1,mouseY1);

				Thread.sleep(5000);
			}

		}*/


	}

}

