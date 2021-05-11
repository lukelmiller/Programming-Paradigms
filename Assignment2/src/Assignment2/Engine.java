// LUKE MILLER
// ASSI 2
public class Engine {
	private String description;
	private int mpg;
	private int maxSpeed;
	
	Engine(String description, int mpg, int maxSpeed){
		if(description.length()==0) {
			this.description = "Generic engine";
		}
		else {
			this.description =description;
		}
		if(mpg<0) {
			this.mpg = 0;
		}
		else {
			this.mpg = mpg;
		}
		if(maxSpeed<0) {
			this.maxSpeed = 0;
		}
		else {
			this.maxSpeed = maxSpeed;
		}
	}
	
	public String getDescription() {
		String ret = description + " (MPG: " + mpg + ", Max speed: " + maxSpeed + ")";
		return ret;
	}
	public int getMpg() {
		return mpg; 
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
}
