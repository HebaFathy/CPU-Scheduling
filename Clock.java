import java.util.*;

public class Clock {

    private int   tics;
    private double guess = 0.0;
    private double alpha;
    private double alphaI;

    private Vector clockTics;
    private Vector ticGuesses;

    public Clock(Vector ct, Vector tg, double a) {
	tics = 0;
	clockTics  = ct;
	ticGuesses = tg;
	alpha      = a;
	alphaI     = 1.0 - a;

	ticGuesses.addElement(new Integer(0)); // add the initial guess
	                          // others will be computed!
    }

    public void processTics(int c) {
	clockTics.addElement(new Integer(tics));
	//guess = 0;
	guess =(alpha*tics)+(alphaI*guess); 
	ticGuesses.addElement(new Integer((int)guess));
	tics = c;
    }

    public void tic() { tics++; }

    public int getTics() { return tics; }

    public int getGuess() { return (int)guess; }
}
