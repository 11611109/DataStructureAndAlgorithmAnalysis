package lab2;

import java.util.Scanner;

public class LAB2_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		
		
		if(0<=testcases&&testcases<=100){
			for(int i=0;i<testcases;i++){
				int hourse=input.nextInt();
				int steps=input.nextInt();
				int start=input.nextInt();
				if(hourse>=1&&hourse<=1000&&steps>=0&&steps<=Math.pow(10, 5)&&start>=0&&start<=hourse){
				int [] income=new int[hourse];
				int [] forture=new int[hourse];
				for(int l=0;l<hourse;l++){
					income[l]=input.nextInt();
				}
				for(int m=0;m<hourse;m++){
					forture[m]=1;
				}
				for(int j=0;j<steps;j++){
					forture[start]=forture[start]*income[start];
					start++;
					if(start==hourse)
						start=0;
				}
				for(int k=0;k<hourse;k++){
				System.out.print(forture[k]+" ");
				}
			}
			}
		}
		else System.out.print("Test cases should be in 0-100");

	}
}
