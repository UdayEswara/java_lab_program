package pack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
public class ClassFileOperations {

	void m1() throws Exception
	{
		FileInputStream f1 = new FileInputStream("E:\\text1.txt");
		int i;
		while((i=f1.read())!=-1)
		{
			System.out.print((char)i);
		}
		FileOutputStream f2 = new FileOutputStream("E:\\text2.txt");
		String str = " programming ";
		byte[] arr = str.getBytes();
		f2.write(arr);
		
		f1.close();
		f2.close();
	}
	
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

		ClassFileOperations opf = new ClassFileOperations();
		opf.m1();
	}

}
