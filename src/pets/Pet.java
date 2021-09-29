package pets;

public class Pet {

	private String name;
	private int age;
	private String type;
	private String breed;
	
	
	//constructor
	public Pet(String name, int age, String type, String breed) {
		this.name = name;
		this.age = age;
		this.type = type;
		this.breed = breed;
	}
	
	//getter methods
	public String getName() { return name; }
	public int getAge() { return age; }
	public String getType() {return type; }
	public String getbreed() {return breed; }
	
	@Override
	public String toString() {
		return "A " + breed + " " + type + " called " + name + 
				" that is " + age + " years old.";
	}

	
}
