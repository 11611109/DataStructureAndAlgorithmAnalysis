package lab2;

import java.util.Scanner;
public class LAB2_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		long sum;
		long N;
		int scoop=(int)Math.pow(10, 6);
		if(testcases>1&&testcases<=1000){
		for(int j=0;j<testcases;j++){
			sum=0;
			N=input.nextInt();
			if(1<=N&&N<=scoop){
				sum=N*(N+1)*(2*N+1)/6;
				System.out.println(sum);}
			else System.out.printf("The test number in line %s is not in the field\n",j+1);
			
		}
	}
	
	else System.out.print("Test cases should be in 2-1000");
	}
}
