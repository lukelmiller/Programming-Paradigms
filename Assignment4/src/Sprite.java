import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


class Sprite
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;
	 private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;

	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void update(Graphics g) {
        // Move the sprite
//		locationX = locationX + 1;
//		locationY = locationY + 1;
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
}