package Builder;

class BuilderClient {
	public static void main(String[] args) {
		User user = User.getBuilder().name("Prince").address("Bangalore").age("25").build();
		System.out.println(user);
	}
}
class User{
	String name;
	String address;
	String age;
	User(UserBuilder builder){
		name = builder.name;
		address = builder.address;
		age = builder.age;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getAge() {
		return age;
	}
	public static UserBuilder getBuilder() {
		return new UserBuilder();
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	static class UserBuilder{
		String name;
		String address;
		String age;
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		public UserBuilder age(String age) {
			this.age = age;
			return this;
		} 
		public User build() {
			return new User(this);
		}
	}
}