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
	
	public boolean overlaps(Sprite s) {
		if(locationX <= s.getX() && locationX+60>=s.getX() && locationY <= s.getY() && locationY+60>=s.getY()) {
			return true;
		}
		if(s.getX()<=locationX && s.getX()+60>=locationX && s.getX()<=locationY && s.getY()+60>=locationY) {
			return true;
		}
		if(locationX<=s.getX() && locationX+60>=s.getX() && locationY<=s.getY()+60 && locationY+60>=s.getY()+60) {
			return true; 
		}
		if(s.getX()<=locationX && s.getX()+60>=locationX && s.getY()<=locationY+60 && s.getY()+60>=locationY+60) {
			return true;
		}
		return false;
	}
	
	public void updateState(int width, int height) {
		
	}
	
	public void updateImage(Graphics g) {
        // Move the sprite
//		locationX = locationX + 1;
//		locationY = locationY + 1;
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
}