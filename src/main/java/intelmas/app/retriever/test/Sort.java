package intelmas.app.retriever.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {10, -3, -2, 4, 8, 3, 1 ,0};
		//Sort.inserctionSort(input);
		for(int nums: input) {
//			System.out.println("FINAL: "+nums);
		}
		
		int [] in = {10, -3, -2, 4, 8, 3, 1 ,0};
		Sort.inserctionsSortDesc(in);
		for(int nums: in) {
			System.out.println("FINAL DESC: "+nums);
		}
		
		IntStream intStream = Arrays.stream(in);
		intStream.forEach(intElem ->{
			System.out.println("FInal is: "+intElem);
		});
		
	}
	
	public static int[] inserctionSort(int[] input) {
		int temp;
		for(int  i = 1; i < input.length; i++) {
			System.out.println("--Element: "+input[i]);
			for(int j=i; j> 0; j--) {
				System.out.println(input[j] +" < "+input[j-1]);
				if(input[j]<input[j-1]) {
					temp = input[j];
					input[j]=input[j-1];
					input[j-1]=temp;
				}				
			}
		}
		return input;
	}
	
	public static int[] inserctionsSortDesc(int[] in) {		
		for (int i =0; i < in.length-1; i++) {
//			System.out.println("--Element: "+in[i]);
			for(int j =i; j< in.length-1; j++) {
				System.out.println("--Element: "+in[i] +", vs: "+in[j+1]);
				if(in[j+1]<in[i]) {
					int tempMenor = in[j+1];
					in[j+1] = in[i];
					in[i] = tempMenor;
					System.out.println("--Then Element: "+in[i] +", vs: "+in[j+1]);
				}
			}
		}
		return in;
	}

}
