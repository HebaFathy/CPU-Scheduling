import java.util.*;

public class Boss {

      public static void main (String args[]) {

	  int    count = 100;
	  double alpha = 0.5;

	  if ( (args.length > 2) || (args.length == 1) ) {
	     System.out.println("must have 2 arguments");
	     System.exit(-1);
	  }
	  else if (args.length == 2) { // got the two arguments
	     try {
                count = Integer.parseInt(args[0]);
	            alpha = Float.parseFloat(args[1]);
             }
	     catch (NumberFormatException e)
	           { System.out.println(e.toString()); 
		     System.exit(-1);
		   }
	  }
      /******************************************************************************************/
         
	  Vector burstTimes = new Vector();
	  Vector guesses    = new Vector();
	  Clock  clock      = new Clock(burstTimes, guesses, alpha);

	  Timer timer = new Timer(clock);
	  timer.setPriority(4);

	  Worker worker = new Worker(clock, count);
	  timer.setPriority(2);

	  timer.start();
	  worker.start();

	  try { 
	       worker.join(); timer.setStop(); }
	  catch (Exception e) { }
    }

}
