package lab4;

import java.util.Scanner;
import java.util.ArrayList;

public class beautifulNumber {
	int [] stack;
	int capacity;
	int top=-1;
	public beautifulNumber(int c){
		stack=new int [c];
		capacity=c;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top+1==capacity;
	}
	public void push(int e){
			stack[++top]=e;
	}
	public int pop(){//出栈返回参数	
			int e=stack[top];
			top--;
			return e;
	}
	public int top(){
		if(isEmpty()){
			return 0;
		}else{
			return stack[top];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int arraySize=0;
		int indexRecord=0;
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				arraySize=input.nextInt();
				int [] array=new int[arraySize];
				for(int j=0;j<arraySize;j++){
					array[j]=input.nextInt();
				}//数据读入
				
				beautifulNumber mystack=new beautifulNumber(arraySize);
				for(int k=arraySize-1;k>-1;k--){
					if(!mystack.isEmpty()){
						while(array[k]>=array[mystack.top()]&&!mystack.isEmpty()){
							mystack.pop();
						}
						if(!mystack.isEmpty()){
							result.add(mystack.top());
							mystack.push(k);
						}else{
							mystack.push(k);
							result.add(-1);
						}
					}else{
						mystack.push(k);
						result.add(-1);
					}
				}
				for(int n=arraySize-1;n>-1;n--){
					System.out.println(result.get(n)+1);
				}
			}
		}
	}
}
