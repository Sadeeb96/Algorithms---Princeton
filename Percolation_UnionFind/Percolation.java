package percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;

public class Percolation {

    int[][] grid;
    int n;
    WeightedQuickUnionUF w;
    public Percolation(int x)
    {
        grid = new int[x+1][x+1];
        n = x;
        w = new WeightedQuickUnionUF((n*n)+2);
       // w.union(0, (n*n)+1);
        
        
        
    }
    public int add(int i,int j)
    {
        return (i-1)*this.n+j;
    }
    public void open(int i,int j)
    {
        int x=add(i,j);
      //  System.out.println("i:"+i+" j:"+j+" x:"+x);
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for(int k=0;k<4;k++){
            if( i+dx[k]<1 || i+dx[k]>n || j+dy[k]<1 || j+dy[k]>n)continue;
            if(grid[i+dx[k]][j+dy[k]]==0)continue;
            else{
            int y = add(i+dx[k],j+dy[k]);
            w.union(x, y);
            }
        }
        grid[i][j]=1;
        if(i==1){
            w.union(0, x);
        }
        if(i==n){
            w.union((n*n)+1, x);
        }
        
        
    }
    public boolean isOpen(int i,int j){
        return grid[i][j]==1;
    }
    public boolean isFull(int i,int j)
    {
        int x = add(i,j);
        return w.connected(0, x) && isOpen(i,j);
    }
    public boolean percolates()
    {
        return w.connected(0, (n*n)+1);
    }
    
}
