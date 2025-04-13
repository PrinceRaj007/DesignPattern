package StructuralDesignPattern.Decorator;

/* Component - Interface for already existing class
 * ConcreteComponent - Implementation of Component interface
 * Decorator - class implementing component to provide additional functionality on top of it, it has component object as composition
 * to do already defined func in components
 * */
public class DecoratorClient {

	public static void main(String[] args) {
		Coffee coffee =  new SimpleCoffee();
		System.out.println(coffee.getDescription());
		System.out.println("Coffee Price: " +coffee.getPrice());
		coffee = new MilkCoffeeDecorator(new SimpleCoffee());
		System.out.println(coffee.getDescription());
		System.out.println("Coffee Price: " +coffee.getPrice());
		coffee = new FrothCoffeeDecorator(new SimpleCoffee());
		System.out.println(coffee.getDescription());
		System.out.println("Coffee Price: " +coffee.getPrice());
		coffee = new MilkCoffeeDecorator(new CaramelizedCoffeeDecorator(new FrothCoffeeDecorator(new SimpleCoffee())));
		System.out.println(coffee.getDescription());
		System.out.println("Coffee Price: " +coffee.getPrice());
	}

}
interface Coffee{
	String getDescription();
	double getPrice();
}
class SimpleCoffee implements Coffee{

	@Override
	public String getDescription() {
		return "Simple Coffee";
	}

	@Override
	public double getPrice() {
		return 20.0;
	}
}
class MilkCoffeeDecorator implements Coffee{

	Coffee coffee;
	public MilkCoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}
	@Override
	public String getDescription() {
		return coffee.getDescription()+", Added Milk";
	}

	@Override
	public double getPrice() {
		return coffee.getPrice()+10.0;
	}
	
}
class CaramelizedCoffeeDecorator implements Coffee{
	
	Coffee coffee;
	public CaramelizedCoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}
	@Override
	public String getDescription() {
		return coffee.getDescription()+", Added caramel";
	}
	
	@Override
	public double getPrice() {
		return coffee.getPrice()+15.0;
	}
	
}
class FrothCoffeeDecorator implements Coffee{
	
	Coffee coffee;
	public FrothCoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}
	@Override
	public String getDescription() {
		return coffee.getDescription()+", Added Froth";
	}
	
	@Override
	public double getPrice() {
		return coffee.getPrice()+5.0;
	}
	
}