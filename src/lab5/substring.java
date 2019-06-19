package lab5;

import java.util.Scanner;

public class substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		String a;
		int length,result;
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				a=input.next();
				length=a.length();
				result=(length+1)*length/2;
				System.out.println(result);
			}
		}
	}

}
