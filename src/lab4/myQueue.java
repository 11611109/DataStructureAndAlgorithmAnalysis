package lab4;

import java.util.Arrays;
import java.util.Scanner;

public class myQueue {

	int size;
	int front;
	int rear;
	int [] queue;
	
	public myQueue(int c){
		front=0;
		rear=0;
		size=c;
		queue=new int[c+1];
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	public boolean isFull(){
		if(rear==size){
			return rear%size==front;
		}else{
		return rear+1==front;
		}
	}
	
	public boolean push(int e){
			queue[rear]=e;
			rear=(rear+1)%(size+1);
			return true;
	}
	public int pop(){
			int e=queue[front];
			front=(front+1)%(size+1);
			return e;
	}
	public int getFront(){
			return queue[front];
	}
	public int getRear(){
			return queue[(rear+size-1)%size];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
	    int operations,ins;
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				myQueue newQueue=new myQueue(input.nextInt());
				operations=input.nextInt();
				for(int j=0;j<operations;j++){
					ins=input.nextInt();
					if(ins==1){
						if(newQueue.isFull()){
							System.out.println(input.nextInt());
						
						}else{
							newQueue.push(input.nextInt());

						}
					}else if(ins==2){
						if(newQueue.isEmpty()){
							System.out.println("The stack is empty");
						}else{
							System.out.println(newQueue.getFront());
							newQueue.pop();
						}
					}else{
						System.out.print("Wrong input!");
					}
				}
					int k=newQueue.front;
					while(k!=newQueue.rear){
						System.out.println(newQueue.queue[k]);
						k=(k+1)%(newQueue.size+1);
					}
				}
			}
		}
}

