
public class SingletonExample implements Runnable {

	private static SingletonExample uniqueInstance = null;//new SingletonExample() ;//null;
	private int data = 0;

	/**
	 * Returns a reference to the single instance. Creates the instance if it
	 * does not yet exist. (This is called lazy instantiation.)
	 */
	public static SingletonExample getInstance() {
		
			synchronized(SingletonExample.class) {
				if (uniqueInstance == null) {
			      uniqueInstance = new SingletonExample();
			}
			
		}
		
		return uniqueInstance;
	}
	
	public void Op() {
		System.out.println( System.identityHashCode(this));
	}
	
	@Override
	public void run() {
		System.out.println("Thread");
		SingletonExample obj  = getInstance();
		obj.Op();
	}

	/**
		* The Singleton Constructor. Note that it is private! No client
		can
		* instantiate a Singleton object directly!
		*/
		private SingletonExample() {
		}
	// Accessors and mutators here!
		
  /* public static void main(String[] args) {
	
	  // SingletonExample obj  = SingletonExample.getInstance();
	   
	   //obj.start();;
	   //new SingletonExample().start();
	   
	   Runnable obj = new SingletonExample();
		Runnable obj2 = new SingletonExample();
		
		new Thread(obj).start();
		new Thread(obj2).start();

	   
	   for (int i = 0; i < 2; i++) {
		   //obj.Op();
		
	}
  }*/
}

class SingletonTest implements Runnable {
	
	   @Override
		public void run() {
		    
		 System.out.println( System.identityHashCode( SingletonExample.getInstance() ) );
		 System.out.println( System.identityHashCode( SingletonExample.getInstance() ) );
			
		}
	}



