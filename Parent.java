public class Parent {

      public static void main (String args[]) {
      
         Counter counter1 = new Counter(1);
         Counter counter2 = new Counter(2);

	 Scheduler CPUScheduler = new Scheduler();
	 CPUScheduler.start();
	 
	 counter1.start();
	 CPUScheduler.addThread(counter1);
         counter2.start();
	 CPUScheduler.addThread(counter2);

	 // Make Parent wait for children to finish
	 try {
	     counter1.join();
	     counter2.join();
	 }
	 catch (InterruptedException e) { System.out.println(e);}

	 // Now that Counter threads are finished, terminate the Scheduler
	 CPUScheduler.finish();
         System.out.println("\nParent is Done!\n");
	 
      }

}
