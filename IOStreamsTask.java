package pack2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOStreamsTask {

	void textFile() throws Exception
	{
		FileInputStream ir = new FileInputStream("D:\\Java Lab Programs\\Lab7\\input.txt");
		FileOutputStream or = new FileOutputStream("D:\\Java Lab Programs\\Lab7\\output.txt");
		
		int data;
		while((data=ir.read())!=-1)
		{
			or.write(data);
		}
		System.out.println("Text file successfully copy");
		ir.close();
		or.close();
	}
	void imageFile() throws Exception
	{
		FileInputStream ir = new FileInputStream("D:\\Java Lab Programs\\Lab7\\website.jpg");
		FileOutputStream or = new FileOutputStream("D:\\Java Lab Programs\\Lab7\\output.jpg");
		
		int data;
		while((data=ir.read())!=-1)
		{
			or.write(data);
		}
		System.out.println("Image file successfully copy");
		ir.close();
		or.close();
	}
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

		IOStreamsTask ios = new IOStreamsTask();
		ios.textFile();
		ios.imageFile();
	}

}
