package StructuralDesignPattern.Proxy;

public class ProxyClient {

	public static void main(String[] args) {
		Image image1 = ImageFactory.getImage("profilePhoto.jpeg");
		Image image2 = ImageFactory.getImage("NaturalScene.jpeg");
		image1.displayImage();
		image1.displayImage();
		System.out.println();
		image2.displayImage();
	}

}
interface Image{
	void displayImage();
}
class RealImage implements Image{
	
	String name;
	public RealImage(String name) {
		this.name = name;
		loadImageFromDisk();
	}

	private void loadImageFromDisk() {
		System.out.println("Loading Image from Disk ....");
	}
	@Override
	public void displayImage() {
		System.out.println("Image Successfully Renderd !! ");
	}
	
}
class ProxyImage implements Image{

	String name;
	RealImage image;
	public ProxyImage(String name) {
		this.name = name;
	}
	@Override
	public void displayImage() {
		if(image==null) {
			image = new RealImage(name);
		}
		image.displayImage();
	}
	
}
class ImageFactory{
	public static Image getImage(String name) {
		return new ProxyImage(name);
	}
}