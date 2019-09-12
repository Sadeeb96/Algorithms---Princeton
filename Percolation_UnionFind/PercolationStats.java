/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;

/**
 *
 * @author User
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    double[] values;
    public PercolationStats(int N, int T){
        values = new double[T];
        for(int k=0;k<T;k++)
        {
            Percolation p = new Percolation(N);
        
        int c = 0;
        while(p.percolates()==false){
            int i = StdRandom.uniform(1, N+1);
            int j = StdRandom.uniform(1, N+1);
            if(p.isOpen(i, j))continue;
            else{
                p.open(i, j);
                c++;
            }
        }
        values[k]=c;
       // System.out.println(c);
        
        }
    }
    public double mean()
    {
        return StdStats.mean(values);
    }
    public double stddev() 
    {
        return StdStats.stddev(values);
    }
}
