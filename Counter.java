public class Counter extends Thread {
    
    private int count;
    private int work;
    public Counter (int j) { super("Counter" + j);}

    public int getWork() { return work;}
    public int getCount() { return count;}
    
    public void run () {
	count = 0;
	work = 0;

	// Put thread to sleep to let Scheduler get started.
	try {
	    sleep(10);
	} catch(InterruptedException e)
	{System.out.println("Counter: " + e);}

	// Thread counts to 20, with delay loop to slow it down.
	while (count < 20) {
	    if (work >= 500000) {

		System.out.println("\t " + getName()
				   + " (priority = " + getPriority() + ")"
				   + ": count = " 
				   + count);

		count = count + 1;
		work = 0;
	    }
            // this is the place to check if this thread 
	    //      should really be running -- use sleep()
	    work = work + 1;
	}
	System.out.println ("\t " + getName() + " DONE!");
    }
    
}
