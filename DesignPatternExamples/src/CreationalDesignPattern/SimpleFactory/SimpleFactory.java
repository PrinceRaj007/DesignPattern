package CreationalDesignPattern.SimpleFactory;

class SimpleFactoryClient {
	public static void main(String[] args) {
		Shape shape1 = ShapeFactory.getShape("circle");
		shape1.draw();
		Shape shape2 = ShapeFactory.getShape("rectangle");
		shape2.draw();
	}
}
interface Shape{
	void draw();
}
class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println(" !! Drawing Circle !!");
	}
	
}
class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println(" !! Drawing Rectangle !!");
	}
	
}
class ShapeFactory{
	public static Shape getShape(String shape) {
		if("circle".equalsIgnoreCase(shape)) {
			return new Circle();
		}else if("rectangle".equalsIgnoreCase(shape)) {
			return new Rectangle();
		}else {
			throw new IllegalArgumentException();
		}
	}
}