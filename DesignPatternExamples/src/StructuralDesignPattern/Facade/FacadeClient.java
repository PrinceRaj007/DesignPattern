package StructuralDesignPattern.Facade;

/* It is used when Client has to deal with lots of interface and classes. This Design Pattern encapsulates all the interaction 
 * into one place and provides a simple interface for the client to interact with
 * */
public class FacadeClient {

	public static void main(String[] args) {
		ComputerFacade facade = new ComputerFacade();
		facade.startComputer();
	}

}

class CPU {
	public void startCpu() {
		System.out.println("Starting CPU ....");
	}
	public void stopCpu() {
		System.out.println("Stopping CPU ....");
	}
	public void execute(){
		System.out.println("Executing CPU commands ...");
	}
}
class OS{
	public void boot() {
		System.out.println("Booting OS ...");
	}
}
class RAM{
	public void load() {
		System.out.println("Loading RAM ...");
	}
}
class HardDisk{
	public void mount() {
		System.out.println("Mounting Hard Disk ...");
	}
}
class ComputerFacade{
	CPU cpu;
	OS os;
	RAM ram;
	HardDisk hardDisk;
	public ComputerFacade() {
		
		cpu = new CPU();
		os =  new OS();
		ram = new RAM();
		hardDisk = new HardDisk();
		
	}
	public void startComputer() {
		System.out.println("Starting computer system:");
		cpu.startCpu();
		os.boot();
		ram.load();
		hardDisk.mount();
		cpu.execute();
		System.out.println("Computer ready to use!");
	}
}