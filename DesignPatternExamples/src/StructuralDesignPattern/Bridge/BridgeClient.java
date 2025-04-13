package StructuralDesignPattern.Bridge;

/*Implementor - Interface having method for its child classes
 * ConcreteImplemetor - Actual class of implementor defining all methods in interface
 * Abstraction - Abstraction class of what client wants to do
 * RefineAbstraction -  Extends Abstraction to give solid implementation of abstraction method using implementor
*/
public class BridgeClient {
	public static void main(String[] args) {
		Abstraction abstractObj = new RefinedAbstractionClass(new ConcreteImplementorA());
		abstractObj.completeOperation();
	}
}
interface Implementor{
	void operation1();
	void operation2();
	void operation3();
}
class ConcreteImplementorA implements Implementor{

	@Override
	public void operation1() {
		System.out.println(" Opertaion 1 Completed !!");
	}

	@Override
	public void operation2() {
		System.out.println(" Opertaion 2 Completed !!");
	}

	@Override
	public void operation3() {
		System.out.println(" Opertaion 3 Completed !!");
	}
	
}
abstract class Abstraction{
	Implementor implementor;
	public Abstraction(Implementor implementor) {
		this.implementor = implementor;
	}
	abstract public void completeOperation();
}
class RefinedAbstractionClass extends Abstraction{

	public RefinedAbstractionClass(Implementor implementor) {
		super(implementor);
	}

	@Override
	public void completeOperation() {
		implementor.operation1();
		implementor.operation2();
		implementor.operation3();
		System.out.println(" Operation Completed Successfully !!");
	}
	
}