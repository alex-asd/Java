
public class Dog extends Pet{
	
	private String breed;
	
	
	public Dog(int age, String name, String breed) {
		super(age, name);
		this.breed = breed;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	@Override
	public String speak() 
	{
		return "Woof";
	}

}
