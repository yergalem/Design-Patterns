
public 
class Main {
	
	public static void main(String[] args) {
		
		Runnable obj = new SingletonTest();
		Runnable obj2 = new SingletonTest();
		
		new Thread(obj).start();
		new Thread(obj2).start();
	}
}