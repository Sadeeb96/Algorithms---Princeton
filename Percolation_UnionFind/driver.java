package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class driver {
    public static void main(String[] args) {
        // TODO code application logic here
        int N=200;
        int T=100;
        Stopwatch sw = new Stopwatch();
        PercolationStats  ps  = new PercolationStats(N,T);
        System.out.println("Time: "+sw.elapsedTime());
        System.out.println("mean                    = "+ps.mean()/(N*N));
        System.out.println("stddev                  = "+ps.stddev()/(N*N));
        
        

        
    }
}
