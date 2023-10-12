package pack2;

class InterThread
{
	int amount = 1000;
	synchronized void withdraw(int amount) throws InterruptedException
	{
		
		if(this.amount>=amount)
		{
			this.amount -= amount;
			System.out.println("Withdraw is completed");
			System.out.println("Available Balance is : "+this.amount);
		}
		else
		{
			System.out.println("Insufficient balance : waiting for deposit ");
			wait();
			this.amount -= amount;
			System.out.println("Withdraw is completed");
			System.out.println("Available Balance is : "+this.amount);
		}
	}
	synchronized void deposit(int amount)
    {
	   	 this.amount += amount;
	   	 System.out.println("Deposit Completed");
	   	 notify();
   	 
    }
}

public class InterThreadCommunication 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		InterThread it = new InterThread();
		new Thread() 
		{
			public void run()
			{
				try {
						it.withdraw(5000);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				try {
					it.deposit(10000);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}

}
