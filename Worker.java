public class Worker extends Thread {
    
    private Clock   tic;
    private RandomV rv;
    private int     count;

    public Worker (Clock tic, int c) { 
        this.tic   = tic; // Assert: tic initialized
	this.rv    = new RandomV();  
        this.count = c;

    }

    public void run () {
	int K;

	for (int J = 0; J < count; J++) {
	    K = rv.getBurstLength();
	    //System.out.print ("Burst = " + K + "\t");
	    // for (int I = 0; I <= K; I++);
	    try {this.sleep(K/7000);} catch (Exception e) {}
	    System.out.print (tic.getTics());
	    //System.out.println("guess = " + tic.getGuess());
	    System.out.println("\t" + tic.getGuess());
	    tic.processTics(tic.getTics());
	}
    }
    
}
