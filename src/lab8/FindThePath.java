package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindThePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		long node,k;
		
		for(int i=0;i<testcases;i++){
			ArrayList<Integer> a=new ArrayList<Integer>();
			node=input.nextLong();
			k=input.nextLong();
			if(k!=0){
				findP(node,k);
				System.out.println( );
			}
		}
	}
	public  static void findP(long node,long k){
		if(node==1){
			System.out.print(node+" ");
		}else{
			findP((node-2)/k+1,k);
			System.out.print(node+" ");
		}
	}

}
