
public abstract class Pet extends Animal{
	
	private String name;

	public Pet(int age, String name) {
		super(age);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
