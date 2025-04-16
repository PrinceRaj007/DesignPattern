package BehavioralDesignPattern.Command;

public class CommandClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Television tv = new Television();
		Remote remoteControl = new Remote(new TurnOnCommand(tv));
		remoteControl.pressButton();
		remoteControl = new Remote(new IncreaseVolumeCommand(tv));
		remoteControl.pressButton();
		remoteControl.pressButton();
		remoteControl.pressButton();
		remoteControl.pressButton();
		remoteControl = new Remote(new TurnOffCommand(tv));
		remoteControl.pressButton();
	}

}
// Receiver
class Television{
	int vol;
	public void turnOn() {
		System.out.println("Turning ON Tv");
	}
	public void turnOff() {
		System.out.println("Turning OFF Tv");
	}
	public void increaseVolume() {
		vol++;
		System.out.println("Increasing volume to "+vol);
	}
	public void decreaseVolume() {
		vol--;
		System.out.println("Decresing volume to "+vol);
	}
}
//Command
interface Command{
	public void execute();
}
class TurnOnCommand implements Command{
	Television tv;
	public TurnOnCommand(Television tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.turnOn();
	}
}
class TurnOffCommand implements Command{
	Television tv;
	public TurnOffCommand(Television tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.turnOff();
	}
}
class IncreaseVolumeCommand implements Command{
	Television tv;
	public IncreaseVolumeCommand(Television tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.increaseVolume();
	}
}
class DecreaseVolumeCommand implements Command{
	Television tv;
	public DecreaseVolumeCommand(Television tv) {
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.decreaseVolume();
	}
}
//Invoker
class Remote{
	Command command;

	public Remote(Command command) {
		this.command = command;
	}
	public void pressButton() {
		command.execute();
	}
}