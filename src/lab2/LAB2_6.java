package lab2;

import java.util.Arrays;
import java.util.Scanner;

public class LAB2_6 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int N,K;
		int biggest;
		
				
		if(1<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				N=input.nextInt();
				int [] differ=new int[N*(N-1)/2]; 
				int [] positions=new int[N];
				K=input.nextInt();
				if(2 <= K&K <= N &N<=50000){
					for(int j=0;j<N;j++){
						positions[j]=input.nextInt();
						if(0>positions[j]||positions[j]>Math.pow(10, 9)){
					         System.out.print("Wrong input!");
					         System.exit(0);
						}
					}			
					Arrays.sort(positions);//排序
					biggest=(positions[positions.length-1]-positions[0])/(K-1);//最大最小距离
					
					int p=0;
					for(int m=0;m<N-1;m++){
						for(int n=m+1;n<N;n++){
							differ[p]=positions[n]-positions[m];
							p++;
						}
					}//储存所有的差值				
					System.out.println(find(biggest,K,differ));
				}
				else System.out.print("Wrong input!");
			}
		}
		else System.out.print("Test cases should be in 0-100");
    }
    public static int find(int BIGGEST,int K,int [] ARRAY){//找最大的差
    	int good=0;
    	for(int test=BIGGEST;test>0;test--){
			if(times(ARRAY,test)>=(K-1)){
			good=test;
			break;
			}
		}
		return good;
	}
    public static int times(int [] array,int current){//看某个差出现几次
    	int count=0;
    	for(int q=0;q<array.length;q++){
    		if(array[q]>=current){
    			count++;
    		}
    	}
    	return count;
    }
}
