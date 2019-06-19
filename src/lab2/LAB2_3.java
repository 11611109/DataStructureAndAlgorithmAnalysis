package lab2;
import java.util.Scanner;
public class LAB2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int arrayLength,target;
		
		
		if(1<testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				int count=0;
				arrayLength=input.nextInt();
				target=input.nextInt();
				if(arrayLength>=1&&arrayLength<=5000&&target>=1&&target<=Math.pow(10, 8)){
				int [] array=new int[arrayLength];
				for(int j=0;j<arrayLength;j++){
					array[j]=input.nextInt();
					if(array[j]<1&&array[j]>Math.pow(10, 6)){
						System.out.print("Input out of bound");
						System.exit(0);
						}
				}
				for(int k=0;k<arrayLength;k++){
					for(int p=k+1;p<arrayLength;p++){
					if(array[k]+array[p]==target)
						count++;
					}
				}
				System.out.println(count);
			}
				else System.out.print("Input error");
			}
		}
		else System.out.print("Test cases should be in 2-10");
	}
    public static int find(int left,int right,int key,int [] array){
		
		while(left<right){
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
