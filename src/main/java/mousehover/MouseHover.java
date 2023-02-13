package mousehover;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;

public class MouseHover {
    public static void main(String[] args) throws Exception {
        // Create an instance of the Robot class
    	
    	Thread.sleep(10000);
        Robot robot = new Robot();
        
        // Get the screen dimensions
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        int screenWidth = gc.getBounds().width;
        int screenHeight = gc.getBounds().height;
        
        System.err.println("screenWidth:"+screenWidth+"::"+screenHeight+":screenHeight");
        
        /*******************Get the screen dimensions method 2*****************************************************************************/
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int height = dimension.height;
        int width = dimension.width;
        
        System.err.println("width:"+width+"::"+height+":height");
     
        
        // Move the mouse from left to right and from top to bottom over the entire screen
       task: for (int x = 0; x < screenWidth; x += 25) {
            for (int y = 0; y < screenHeight; y += 10) {
                robot.mouseMove(x, y);
                Thread.sleep(20);
                if (x==2000) {
                	 break task;
				}
               
            }
        }
    }
}
