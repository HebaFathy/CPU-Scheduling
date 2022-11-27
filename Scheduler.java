import java.util.*;

public class Scheduler extends Thread
{
    public Scheduler() {  // Constructor without specified time slice
	timeSlice = DEFAULT_TIME_SLICE;
	queue = new Vector();
    }

    public Scheduler(int quantum) { // Constructor for specified time slice
	timeSlice = quantum;
	queue = new Vector();
    }

    public void addThread(Thread t) {
	// Nonrunning threads have priority 2 to keep them from running
	t.setPriority(2);
	queue.addElement(t);
    }

    public void finish() {
	done = true;
    }

    private void schedulerSleep() {
	try {
	    Thread.sleep(timeSlice);     //why??
	} catch(InterruptedException e)
	    {System.out.println("Scheduler: " + e);}
    }

    public void run() {
	Thread current = null;

	// Set Scheduler to have high priority so it will run when it's awake
	this.setPriority(6);

	while (!done) {
	    // get the next thread
	    if (!queue.isEmpty()) {
		// Proceed only if there is an available thread
		current = (Thread) queue.firstElement();

		// Make sure that the thread is still there and alive
		if ( (current != null) && (current.isAlive()) ) {
		    // If so, start it up,
		    System.out.println("Starting " + current.getName()
				       + " Count = "
				       + ((Counter) current).getCount()
				       + "; work = "
				       + ((Counter) current).getWork());
		    // remove it from the queue,
		    queue.removeElementAt(0);
		    // set its priority to 4 to run, and
		    current.setPriority(4);
		    // put the Scheduler to sleep
		    schedulerSleep();

		    // After the scheduler wakes up,
		    if ( (current != null) && (current.isAlive()) ) {
			// if the thread is still alive, set its priority
			// back to 2 and put it back on the queue,
			current.setPriority(2);
			queue.addElement(current);
			System.out.println("Stopping " + current.getName()
				       + " Count = "
				       + ((Counter) current).getCount()
				       + "; work = "
				       + ((Counter) current).getWork());
		    }
		}
		// If thread is dead on arrival, delete it
		else if ( (current != null) && (!current.isAlive()) ) {
		    queue.removeElementAt(0);
		    current = null;
		}
	    }
	}   
    }
    
    private Vector queue;
    private int timeSlice;
    private static final int DEFAULT_TIME_SLICE = 1000;
    private boolean done = false;
}
