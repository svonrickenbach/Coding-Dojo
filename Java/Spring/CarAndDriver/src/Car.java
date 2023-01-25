
public class Car {
	
	private int gas = 10;
		
	public int getGasLevel() {
		return this.gas;
	}
	
	public void setGasLevel(int num) {
		this.gas = this.gas + num; 
		if(gas <= 0) {
		System.out.println("Game Over!");
		}
	}
}

