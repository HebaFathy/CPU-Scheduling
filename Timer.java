public class Timer extends Thread {

    private Clock   clock;
    private int     sleepTime;
    private boolean goon;

    public Timer(Clock cl) { 
	sleepTime = 20; // experiment with this value
	clock     = cl;
	goon      = true;
    }

    public void setStop() { goon = false; }

    public void run() {
        try {
	    while (goon) { 
		this.sleep(sleepTime);
		clock.tic();
	    }
	}
	catch (Exception e) {}
    }

}
