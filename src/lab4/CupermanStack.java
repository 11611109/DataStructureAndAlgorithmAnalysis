package lab4;

import java.util.Scanner;

public class CupermanStack {//����ջ�����������ͼ�<T>  stack<T> ����ʱ����Object���õ�ʱ��Ҫ��������ͶԻ�ɶ���У�Ҫ���˾�ֻ�ܴ���һ������
	//Ҳ������ϵͳ���ջ��Import

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
	public int pop(){//��ջ���ز���	
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

