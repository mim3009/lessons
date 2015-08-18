package sadasssdasd;

import java.util.concurrent.RecursiveTask;

public class MaxTask extends RecursiveTask<Long> {
	final long[] array; final int low; final int high;	 
   public MaxTask(long[] array2, int low2, int mid) {
		this.array = array2;
		this.low = low2;
		this.high = mid;
	}
protected Long compute() {


	    if (high - low < 2) {
	    	long n, max = Long.MIN_VALUE;
	    for (int i = low; i < high; ++i){
	       n = array[i]; if (n > max) max = n; }
	    return max;


	    } else {
	       int mid = (low + high) >>> 1;
RecursiveTask<Long> left = new MaxTask(array, low, mid);
RecursiveTask<Long> right = new MaxTask(array, mid, high);
	       right.fork();
	       Long s = Math.max(left.invoke(),right.join());
	       return s; 
	    }
	}  
}
