package sort;

import java.util.Random;

public class sortAll{

	public static void main(String[] args) {
		int mas[] = {6, 8, 10, 2, 11, 5, 1, 9, 18, 7};
		
		bubl(mas);
		
		for(int i = 0; i<mas.length; i++){
			System.out.print(mas[i] + " ");
		}
		
	}

	public static void bubl(int mas[]){
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas.length - i - 1; j++){
				if(mas[j]> mas[j+1]){
					int buf = mas[j];
					mas[j] = mas[j+1];
					mas[j+1] = buf;
				}
			}
		}
	}
	
	public static void selectionSort(int mas[]){
		for(int i = 0; i < mas.length; i++){
			int min_i = i;
			int min = mas[i];
			for(int j = i+1; j < mas.length; j++){
				if(mas[j] < min){
					min = mas[j];
					min_i = j;
				}
			}
			if(i != min_i){
				int tmp = mas[i];
				mas[i] = mas[min_i];
				mas[min_i] = tmp;
			}
		}
	}
	
	public static void bubbleSort(int mas[]){
		for(int i = mas.length - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(mas[j] > mas[j+1]){
					int tmp = mas[j];
					mas[j] = mas[j+1];
					mas[j+1] = tmp;
				}
			}
		}
	}
	
	public static void insertSort(int mas[]){
		int value = 0;
		int j;
		int i;
		for(i = 1; i < mas.length; i++){
			value = mas[i];
			for(j = i-1; j >=0 && mas[j] > value; j--){
				mas[j+1] = mas[j];
			}
			mas[j+1] = value;
		}
	}
	
	 	static int partition (int[] array, int start, int end){
	       int marker = start;
	       for ( int i = start; i <= end; i++ ){
	           if ( array[i] <= array[end] ){
	               int temp = array[marker];
	               array[marker] = array[i];
	               array[i] = temp;
	               marker += 1;
	           }
	       }
	       return marker - 1;
	   }
	 
	   public static void quicksort (int[] array, int start, int end){
	       if ( start >= end ){
	           return;
	       }
	       int pivot = partition (array, start, end);
	       quicksort (array, start, pivot-1);
	       quicksort (array, pivot+1, end);
	   }

}
