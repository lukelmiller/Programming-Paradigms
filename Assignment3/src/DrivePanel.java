
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DrivePanel extends JPanel {
	int legs;
	int[] x = new int[10];
	int[] y = new int[10];
	DrivePanel(int legs, int[] x, int[] y) {
		this.legs = legs;
		this.x = x.clone();
		this.y = y.clone();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String temp ="";

		for(int i = 0; i<legs; i++) {
//			System.out.println("x[" +i +"] = "+x[i]);
//			System.out.println("y[" +i +"] = "+y[i]);
//			System.out.println("legs: " + legs);
			if(i==0) {
				g.drawLine(0, 600, x[i], 600-y[i]);
				temp = "("+x[i]+","+y[i]+")";
				g.drawString(temp, x[i]+10, 600-y[i]);
			}else {
				
				g.drawLine(x[i-1], 600-y[i-1], x[i], 600-y[i]);
				temp = "("+x[i]+","+y[i]+")";
				g.drawString(temp, x[i]+10, 600-y[i]);
			}
		}
	}
	

	
	

}
