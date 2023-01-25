
public class GiantBat extends Mammal {
	
	public GiantBat() {
		super(300);
	}
	
	public void flying() {
		System.out.println("Whooosh!");
		setEnergy(-50);
	}
	
	public void eatHumans() {
		System.out.println("AHHHHHHHHHH!");
		setEnergy(25);
	}
	
	public void attackTown() {
		System.out.println("AHHHHHH THE TOWNS ON FIRE!");
		setEnergy(-100);
	}
	
}
