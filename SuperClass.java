package pack;

class HillStations
{
	void location()
	{
		System.out.println("This location() method is for Parent class");
	}
	void famousFor()
	{
		System.out.println("This famousFor() method is for Parent class");
	}
}

class Manali extends HillStations
{
	@Override
	public void location()
	{
		System.out.println("Manali is located in high altitude");
	}
	@Override
	public void famousFor()
	{
		System.out.println("Manali is famous for Valley");
	}
}

class Mussoorie extends HillStations
{
	@Override
	public void location()
	{
		System.out.println("Mussoorie is a hill station");
	}
	@Override
	public void famousFor()
	{
		System.out.println("Mussoorie is famous for cool climate");
	}
}

class Gulmarg extends HillStations
{
	@Override
	public void location()
	{
		System.out.println("Gulmarg is a hill station");
	}
	@Override
	public void famousFor()
	{
		System.out.println("Gulmarg is famous for snow covered lands");
	}
}


public class SuperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Parent Class 
		HillStations hs = new HillStations();
		hs.location();
		hs.famousFor();
		System.out.println();
		
		HillStations manali = new Manali();
		manali.location();
		manali.famousFor();
		System.out.println();
		
		HillStations mussoorie = new Mussoorie();
		mussoorie.location();
		mussoorie.famousFor();
		System.out.println();
		
		HillStations gulmarg = new Gulmarg();
		gulmarg.location();
		gulmarg.famousFor();
		System.out.println();
		
		//call the location() and famousFor() method by the all subClass
		System.out.println("====================================");
		Manali manaliSub = new Manali();
		manaliSub.location();
		manaliSub.famousFor();
		System.out.println();
		
		Mussoorie mussoorieSub = new Mussoorie();
		mussoorieSub.location();
		mussoorieSub.famousFor();
		System.out.println();
		
		Gulmarg gulmargSub = new Gulmarg();
		gulmargSub.location();
		gulmargSub.famousFor();
		System.out.println();
	}

}
