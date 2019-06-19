package lab4;

import java.util.Scanner;

public class bracketsStack {
	char [] stack;
	int capacity;
	private int top=-1;
	public bracketsStack(int c){
		stack=new char [c];
		capacity=c;
	}
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top+1==capacity;
	}
	public void push(char e){
			stack[++top]=e;
	}
	public char pop(){//��ջ���ز���	
			char e=stack[top];
			top--;
			return e;
	}
	public char top(){
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
	    int brackets;
	    String s;
	    char [] x;
	    char test;
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				brackets=input.nextInt();//�Ƿ���Ҫ����x��Ϊ����
				bracketsStack myStack=new bracketsStack(brackets);//����n�ν�ջ������ÿ�ν���֮�����Ƿ���ƥ��
				s=input.next();
				x=s.toCharArray();
		
				for(i=0;i<brackets;i++){
					test=x[i];
					switch(test){
					case ')':
						if(myStack.top()=='('){
							myStack.pop();
						}
						break;
					case ']':
						if(myStack.top()=='['){
							myStack.pop();
						}
						break;
					case '}':
						if(myStack.top()=='{'){
							myStack.pop();
						}
					    break;
					default:
						if(myStack.isFull()){
						}else{
							myStack.push(test);
						}
						break;
					}
					
				}
				if(myStack.isEmpty()){
					System.out.print("YES");
				}else{
					System.out.print("NO");
				}
			}
		}
	}

}
