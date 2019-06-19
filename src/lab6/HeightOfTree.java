package lab6;

import java.util.Scanner;
import java.lang.Math;
public class HeightOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,height;
		if(1<=testcases&&testcases<=1024){
			for(int m=0;m<testcases;m++){
				node=input.nextInt();
				height=(int)(Math.log(node)/Math.log(2));
				System.out.println(height);
			}
		}
	}

}
