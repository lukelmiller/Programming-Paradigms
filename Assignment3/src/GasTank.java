// LUKE MILLER
// ASSI 3
public class GasTank {
	private int capacity;
	private double level;
	
	GasTank(int capacity){
		if(capacity > 0) {
			this.capacity = capacity;
		}
		else {
			this.capacity = 0;
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	public double getLevel() {
		return level;
	}
	public void setLevel(double levelIn) {
		if(levelIn < 0) {
			level = 0;
		}
		else if(levelIn > capacity) {
			level = capacity;
		}
		else {
			level = levelIn;
		}
	}
	
}

