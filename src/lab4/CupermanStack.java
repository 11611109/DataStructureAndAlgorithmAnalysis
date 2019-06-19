package lab4;

import java.util.Scanner;

public class CupermanStack {//范型栈所有数据类型加<T>  stack<T> 声明时可以Object，用的时候不要求对象类型对话啥都行，要求了就只能存哪一种类型
	//也可以用系统里的栈，Import

	int [] stack;
	int capacity;
	int top=-1;
	public CupermanStack(int c){
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
	    int operations,ins;
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				CupermanStack myStack=new CupermanStack(input.nextInt());
				operations=input.nextInt();
				for(int j=0;j<operations;j++){
					ins=input.nextInt();
					if(ins==1){
						if(myStack.isFull()){
							System.out.println(input.nextInt());
						}else{
							myStack.push(input.nextInt());
						}
					}else if(ins==2){
						if(myStack.isEmpty()){
							System.out.println("The stack is empty");
						}else{
							System.out.println(myStack.top());
							myStack.pop();
						}
					}else{
						System.out.print("Wrong input!");
					}
				}
				if(myStack.top!=-1){
					for(int k=myStack.top;k>-1;k--){
						System.out.println(myStack.stack[k]);
				    }
				}
				}
			}
		}
	}

