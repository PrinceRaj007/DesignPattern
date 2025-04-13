package StructuralDesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/* This design pattern is used when we find any tree like hierarchy structure.
 * Component - An interface which provides contract for Leaf and Composite Classes
 * Leaf Class - A Class which implements component interface 
 * Composite Class - A class which implements component interface and has Leaf class (Use its interface) as composite members 
 * and also provides additional functionality to add and remove leafs from composite object
 * */
public class CompositeClient {

	public static void main(String[] args) {
		Directory root = new Directory("Root");
		root.addFile(new File("image1.jpg", 500));
		root.addFile(new File("image2.jpg", 500));
		root.addFile(new Directory("Documents"));
		Directory dir1 = new Directory("Downloads");
		dir1.addFile(new File("Resume.docx", 1024));
		dir1.addFile(new File("TaxCalculation.xls", 512));
		dir1.addFile(new File("profile_pic.jpg", 2048));
		root.addFile(dir1);
		root.dispaly("");
	}

}
interface FileSystem{
	void dispaly(String indent);
	int getSize();
}
class File implements FileSystem{

	private String name;
	private int size;
	public File(String name,int size) {
		this.name = name;
		this.size = size;
	}
	@Override
	public void dispaly(String indent) {
				System.out.println(indent+ "File: "+name+" (Size: "+size+" bytes)");
	}

	@Override
	public int getSize() {
		return size;
	}
	
}
class Directory implements FileSystem{
	private String name;
	List<FileSystem> list = new ArrayList<>();
	
	public Directory(String name) {
		this.name = name;
	}
	public void addFile(FileSystem file) {
		list.add(file);
	}
	public void removeFile(File file) {
		list.remove(file);
	}
	@Override
	public void dispaly(String indent) {
		System.out.println(indent+"Directory: "+name+" (Size: "+getSize()+" bytes)");
		list.stream().forEach(file->file.dispaly(indent+"\t"));
	}

	@Override
	public int getSize() {
		int totalSize = 0;
		for(FileSystem file: list) {
			totalSize+=file.getSize();
		}
		return totalSize;
	}
	
}

