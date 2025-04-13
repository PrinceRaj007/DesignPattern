package StructuralDesignPattern.FlyWeight;

import java.util.HashMap;

/* 
 * This pattern is used when we have to deal with lots of objects having some shared properties which doesn't change(intrinsic )
 *  and some property that might change (extrinsic). we create separate class(Flyweight) for intrinsic props and shared its object to all the context on the other hand 
 *  class for extrinsic properties are created which is passed by the client itself to carry out the functionality.
 *  Flyweight - Interface for flyweight & provides method to receive extrinsic values  
 *  Concrete Flyweight - class implementing Flyweight having only intrinsic properties
 *  Flyweight Factory - take care of providing the objects of flyweight and cache it.
 *  */
public class FlyWeightClient {

	public static void main(String[] args) {
		CircleFactory factory  = new CircleFactory();
		Shape circle = factory.getCircle("red");
		circle.draw(2, 3);
		circle = factory.getCircle("red");
		circle.draw(6, 3);
		circle = factory.getCircle("red");
		circle.draw(5, 2);
		Shape circle2 = factory.getCircle("blue");
		circle2.draw(25, 31);
		circle2 = factory.getCircle("blue");
		circle2.draw(17, 13);
		circle2 = factory.getCircle("blue");
		circle2.draw(54, 22);
	}

}
interface Shape{
	void draw(int x, int y);
}
class Circle implements Shape{
	String color; //intrinsic prop
	int radius = 5; // intrinsic prop
	public Circle(String color) {
		this.color = color;
	}
	
	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing CIRCLE [ Raius: "+radius+", X: "+x+", Y: "+y+", Color: "+color+" ] ");
	}
	
}
class CircleFactory{
	HashMap<String, Shape> circleMap = new HashMap<>();
	public Shape getCircle(String color) {
		return circleMap.computeIfAbsent(color, c->{ System.out.println("Creating a new CIRCLE of color: "+c); return new Circle(color); });
	}
}
