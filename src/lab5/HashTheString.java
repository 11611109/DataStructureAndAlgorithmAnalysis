package lab5;

import java.util.Scanner;

public class HashTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		long result=0;
		if(0<=testcases&&testcases<=10){
			for(int m=0;m<testcases;m++){				
				int textLength=input.nextInt();
				String text=input.next();
				char [] textArray=text.toCharArray();
				int [] next=next(textArray,textLength);
				
				long [] map=new long[textLength+1];
				for(int j=0;j<=textLength;j++){
					map[j]=1;
				}
				for(int i=textLength;i>0;i--){
					map[next[i]]+=map[i];
				}
				for(int k=1;k<=textLength;k++){
					result+=k*map[k];
				}
				System.out.println(result);
			}
		}
	}
	public static int [] next(char [] a,int length){
		int p=0;
		int [] nextArray=new int[length+1];
		int k=-1;
		nextArray[0]=-1;
		while(p<length){
			if(k==-1||a[p]==a[k]){
				p++;
				k++;
				nextArray[p]=k;
			}else{
				k=nextArray[k];
			}
		}
		return nextArray;
	}

}
