
public abstract class Cat extends Pet{

	private boolean isAHouseCat;
	
	public Cat(int age, String name, boolean isAHouseCat) {
		super(age, name);
		this.isAHouseCat = isAHouseCat;
	}

	public boolean isAHouseCat() {
		return isAHouseCat;
	}

	public void setAHouseCat(boolean isAHouseCat) {
		this.isAHouseCat = isAHouseCat;
	}

	public String speak()
	{
		return "Meoww";
	}
}
