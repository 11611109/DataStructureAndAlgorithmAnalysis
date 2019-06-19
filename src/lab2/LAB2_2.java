package lab2;
import java.util.Scanner;
public class LAB2_2 {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int arrayLength;
		int key;
		int left,right;
		
		if(100<=testcases&&testcases<=1000){
			for(int i=0;i<testcases;i++){
				arrayLength=input.nextInt();
				if(arrayLength<=Math.pow(10, 6)&&arrayLength>=0){
				key=input.nextInt();
				int [] array=new int[arrayLength];
				for(int j=0;j<arrayLength;j++){
					array[j]=input.nextInt();
				}
				left=0;
				right=arrayLength-1;
				if(find(left,right,key,array)==0)
				System.out.print("YES");
				else System.out.print("NO");
			}
				else System.out.print("Input error");
			}
		}
		else System.out.print("Test cases should be in 100-1000");
	}


	public static int find(int left,int right,int key,int [] array){
		
		while(left<=right){//添加了等于
		int mid=(left+right)/2;
			
		if(key>array[mid]){
			left=mid+1;
		}
		else if(key<array[mid]){
			right=mid-1;
		}
		else {
		    return 0;
		    }
		}
		return 1;			
	}
}
