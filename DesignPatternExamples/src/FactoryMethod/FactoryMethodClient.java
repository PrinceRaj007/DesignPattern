package FactoryMethod;

public class FactoryMethodClient {
	public static void main(String[] args) {
		drawShape(new CircleFactory());
		drawShape(new RectangleFactory());
	}
	public static void drawShape(ShapeFactory factory) {
		Shape shape = factory.createShape();
		shape.draw();
	}
}
interface Shape{
	void draw();
}
class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Drawing CIRCLE !!");
	}
	
}
class Rectangle implements Shape{
	
	@Override
	public void draw() {
		System.out.println("Drawing RECTANGLE !!");
	}
	
}
interface ShapeFactory{
	Shape createShape();
}
class CircleFactory implements ShapeFactory{

	@Override
	public Shape createShape() {
		return new Circle();
	}
	
}
class RectangleFactory implements ShapeFactory{
	
	@Override
	public Shape createShape() {
		return new Rectangle();
	}
	
}