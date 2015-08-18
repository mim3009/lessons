package sadasssdasd;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MaxWithFJ{
	  static final ForkJoinPool mainPool = new ForkJoinPool(); 
	   
	   public static void main(String[] args) {
	    	long[] anArray = new long [500000];
	    	RecursiveAction mainTask = new IncrementTask (anArray, 0, anArray.length);
	   	mainPool.invoke(mainTask);
			
	    	RecursiveTask<Long> maxTask = new MaxTask(anArray, 0, anArray.length);    	 
	    	Long max= mainPool.invoke(maxTask);
	    	System.out.println(max);
		}
	}
