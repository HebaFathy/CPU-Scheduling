import java.util.*;

public class RandomV {

    private int blBase;

    private int burstL;
    private int numBursts;

    private int countB;

    private double blMargin = 2900000.0;
    private double blMin    = 500000.0;

    private Random rGen = new Random();

    public RandomV() { 
	numBursts = 0; 
	countB    = 0;
    }

    public int getBurstLength() {

	if (countB == numBursts) {
	    blBase    = (int) computeBurstBase();
	    numBursts = computeNumBursts();
	    countB    = 0;
	}
	countB++;
        return (int) computeBurstLength();
    }

    private int computeNumBursts() {
	return 2+(rGen.nextInt(6));
    }

    private double computeBurstLength() {
	return ((double) blBase) + 
	        (rGen.nextDouble() * 0.3 * ((double) blBase) );
    }

    private double computeBurstBase() {
	return rGen.nextDouble() * blMargin + blMin;
    }

}
