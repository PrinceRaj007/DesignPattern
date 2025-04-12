package Singleton;

public class SingletonThreadUnsafe {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		System.out.println(obj1);
		System.out.println(obj2);
	}

}
class Singleton{
	private static Singleton instance;
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
}
