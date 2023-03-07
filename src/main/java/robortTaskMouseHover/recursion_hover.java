package robortTaskMouseHover;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class recursion_hover {


	static void recursionHover() throws AWTException, InterruptedException {


		Robot r=new Robot();
		Point point = MouseInfo.getPointerInfo().getLocation();

		int mouseX = point.x;
		int mouseY = point.y;

		int x = 0;
		int a=0;
		int changeX=mouseX;
		task1:	while (true)
		{
//			if (mouseX > 0 && mouseX < mouseX && mouseY >0 && mouseY <mouseY) {




				r.mouseMove(changeX,mouseY);
				System.out.println(changeX+","+mouseY);
				changeX=changeX+2;
				System.err.println(x);
				x++;
				Thread.sleep(5000);
				if (changeX==mouseX+60)
				{
					changeX= changeX -60;
					
					++a;
					System.err.println("Round : "+a);
					if (a==2) 
					{
						break task1;
					}				
				}
			}
		}

//	}
	public static void main(String[] args) throws AWTException, InterruptedException {
		recursion_hover.recursionHover();
	}

}
