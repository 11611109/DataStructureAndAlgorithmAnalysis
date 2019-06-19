package lab5;

import java.util.Scanner;

public class Abracadabra {

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

				char [] answer=new char[textLength];
				int [] nextall=new int[textLength];
				
				int [] next=next(patternArray,patternLength);
				int i=0,j=0,t=0;
				
				while(i<textLength){
					if(j==-1||textArray[i]==patternArray[j]){
						answer[t]=textArray[i];
					    nextall[t]=j;	
						i++;
						j++;
						t++;
					}else{
						j=next[j];
					}
					if(j==patternLength){						
						t=t-patternLength;
						if(t>0){
						j=nextall[t-1]+1;
						}else{
							j=0;
						}
					}
				}
				for(int a=0;a<t;a++){
					System.out.print(answer[a]);
				}
				System.out.println();
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
