
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Gets here is left mouse button was clicked
			int x = (int)MouseInfo.getPointerInfo().getLocation().getX();
			int y = (int)MouseInfo.getPointerInfo().getLocation().getY()-50;
			model.setModel(x, y);
		} else if (SwingUtilities.isRightMouseButton(e))  {
			// Gets here if right mouse button was clicked
			model.refill();
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

