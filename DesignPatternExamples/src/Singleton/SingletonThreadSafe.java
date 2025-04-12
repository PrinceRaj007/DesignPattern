package Singleton;

public class SingletonThreadSafe {

	public static void main(String[] args) {
		SingletonThreadSafeClass obj1 = SingletonThreadSafeClass.getInstance();
		SingletonThreadSafeClass obj2 = SingletonThreadSafeClass.getInstance();
		System.out.println(obj1);
		System.out.println(obj2);
		SingletonThreadSafeClassWithVolatile obj3 = SingletonThreadSafeClassWithVolatile.getInstance();
		SingletonThreadSafeClassWithVolatile obj4 = SingletonThreadSafeClassWithVolatile.getInstance();
		System.out.println(obj3);
		System.out.println(obj4);
		SingletonThreadSafeClassWithSync obj5 = SingletonThreadSafeClassWithSync.getInstance();
		SingletonThreadSafeClassWithSync obj6 = SingletonThreadSafeClassWithSync.getInstance();
		System.out.println(obj5);
		System.out.println(obj6);
	}

}

class SingletonThreadSafeClass {

	private SingletonThreadSafeClass() {
	}

	// Inner helper class
	public static class SingletonInnerClass {
		private static final SingletonThreadSafeClass INSTANCE = new SingletonThreadSafeClass();
	}

	public static SingletonThreadSafeClass getInstance() {
		return SingletonInnerClass.INSTANCE;
	}
}

class SingletonThreadSafeClassWithVolatile {
	public static volatile SingletonThreadSafeClassWithVolatile instance;

	private SingletonThreadSafeClassWithVolatile() {
	}

	public static SingletonThreadSafeClassWithVolatile getInstance() {
		if (instance == null) {
			synchronized (SingletonThreadSafeClassWithVolatile.class) {
				if (instance == null) {
					instance = new SingletonThreadSafeClassWithVolatile();
				}
			}
		}
		return instance;
	}
}

class SingletonThreadSafeClassWithSync {
	
	public static volatile SingletonThreadSafeClassWithSync instance;
	
	private SingletonThreadSafeClassWithSync() {
	}
	public static synchronized SingletonThreadSafeClassWithSync getInstance() {
		if (instance == null) {
			instance = new SingletonThreadSafeClassWithSync();
		}
		return instance;
	}
}