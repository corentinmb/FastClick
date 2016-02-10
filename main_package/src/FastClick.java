import java.awt.*;
import java.awt.event.InputEvent;

public class FastClick {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot r = new Robot();
        Point souris;
        Color current;
        Color red = new Color(189,27,40);
        Color green = new Color(67,211,88);
        Color blue = new Color(48,115,199);
        boolean firstOccurence = false;
        int count=0;

        while(count != 5) {
            souris = MouseInfo.getPointerInfo().getLocation();
            current = getColorAt(r, souris.x, souris.y);
            //System.out.println(current);

            if(current.equals(green) && !firstOccurence) {
                Thread.sleep(50);
                count++;
                Click(r);
                firstOccurence = true;
                //System.out.println("GREEN");
            }

            if(current.equals(blue) && firstOccurence) {
                Click(r);
                firstOccurence = false;
                //System.out.println("GREEN");
            }
        }
    }

    public static Color getColorAt(Robot robot, int x, int y) throws AWTException {
        return robot.getPixelColor(x,y);
    }

    public static void Click(Robot robot){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease((InputEvent.BUTTON1_MASK));
    }
}

// RED 189 27 40
// GREEN 67 211 88
// BLUE 48 115 199