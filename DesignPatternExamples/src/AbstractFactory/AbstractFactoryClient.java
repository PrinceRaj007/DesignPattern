package AbstractFactory;

class AbstractFactoryClient {
	public static void main(String[] args) {
		renderGUI(new DarkGUIFactory());
		renderGUI(new LightGUIFactory());
	}
	public static void renderGUI(GUIFactory factory) {
		Button button = factory.createButton();
		Checkbox checkbox = factory.createCehckbox();
		button.renderButton();
		checkbox.renderCheckbox();
	}
}
interface Button{
	void renderButton();
}
class DarkButton implements Button{

	@Override
	public void renderButton() {
		System.out.println("Rendering Dark theme Button...");
	}
}
class LightButton implements Button{

	@Override
	public void renderButton() {
		System.out.println("Rendering Light theme Button...");
	}
	
}
interface Checkbox{
	void renderCheckbox();
}
class DarkCheckbox implements Checkbox{

	@Override
	public void renderCheckbox() {
		System.out.println("Rendering Dark theme Checkbox...");
	}
}
class LightCheckbox implements Checkbox{
	
	@Override
	public void renderCheckbox() {
		System.out.println("Rendering Light theme Checkbox...");
	}
}
interface GUIFactory{
	Button createButton();
	Checkbox createCehckbox();
}
class DarkGUIFactory implements GUIFactory{

	@Override
	public Button createButton() {
		return new DarkButton();
	}
	@Override
	public Checkbox createCehckbox() {
		return new DarkCheckbox();
	}
}
class LightGUIFactory implements GUIFactory{
	
	@Override
	public Button createButton() {
		return new LightButton();
	}
	@Override
	public Checkbox createCehckbox() {
		return new LightCheckbox();
	}
}
