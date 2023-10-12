package pack2;

import java.util.ArrayList;

public class ClassSublist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1); arrayList.add(2); arrayList.add(3);
		arrayList.add(4); arrayList.add(5);
		
		for(int i=0;i<arrayList.size();i++)
		{
			for(int j=i+1;j<=arrayList.size();j++)
			{
				System.out.println(arrayList.subList(i, j));
			}
		}
	}

}
