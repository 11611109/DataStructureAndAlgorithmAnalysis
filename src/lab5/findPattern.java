package lab5;

import java.util.Scanner;

public class findPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		if(0<=testcases&&testcases<=10){
			for(int m=0;m<testcases;m++){
				int textLength=input.nextInt();
				String text=input.next();
				int patternLength=input.nextInt();
				String pattern=input.next();
				
				char [] textArray=text.toCharArray();
				char [] patternArray=pattern.toCharArray();
				int [] next=next(patternArray,patternLength);
				int count=0,i=0;
				int j=0;
				while(i<textLength){
					if(j==-1||textArray[i]==patternArray[j]){
						i++;
						j++;
					}else{
						j=next[j];
					}
					if(j==patternLength){
						count++;
						j=next[j];
					}
				}
				System.out.println(count);
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
