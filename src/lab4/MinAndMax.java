package lab4;

import java.util.Scanner;

public class MinAndMax {
	int size;
	int front;
	int rear;
	int [] queue;
	
	public MinAndMax(int c){
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
	public void deQueueRear(){
		if(isEmpty()){
		}
		else{
			if(rear!=0){
				rear=(rear+size-1)%size;
			}else{
				rear=size;
			}
		
		}
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
	    int length=0,arraySize=0;

	    int x=0,y=0;
		if(0<=testcases&&testcases<=10){
			for(int i=0;i<testcases;i++){
				arraySize=input.nextInt();
				length=input.nextInt();
			    
			    int [] min=new int[arraySize-length+1];
			    int [] max=new int[arraySize-length+1];
				int [] element=new int [arraySize];
				
				MinAndMax myqueue=new MinAndMax(length);
				for(int j=0;j<arraySize;j++){
					element[j]=input.nextInt();
				}
				
				for(int k=0;k<arraySize;k++){//k代表index,element[k]代表相应元素
					if((k-myqueue.getFront())!=3){
						while(element[myqueue.getFront()]>element[k]&&!myqueue.isEmpty()){
							myqueue.pop();
						}
						while(element[myqueue.getRear()]>element[k]&&!myqueue.isEmpty()){
							myqueue.deQueueRear();
						}
						myqueue.push(k);	
					}else{
						myqueue.pop();
						while(element[myqueue.getFront()]>element[k]&&!myqueue.isEmpty()){
							myqueue.pop();
						}
						while(element[myqueue.getRear()]>element[k]&&!myqueue.isEmpty()){
							myqueue.deQueueRear();
						}
						myqueue.push(k);
					}
					if(k>=length-1){
						min[x]=element[myqueue.getFront()];
						System.out.print(min[x]+" ");
						x++;
					}	
				}
				System.out.println( );
				for(int k=0;k<arraySize;k++){//k代表index,element[k]代表相应元素
					if((k-myqueue.getFront())!=3){
						while(element[myqueue.getFront()]<element[k]&&!myqueue.isEmpty()){
							myqueue.pop();
						}
						while(element[myqueue.getRear()]<element[k]&&!myqueue.isEmpty()){
							myqueue.deQueueRear();
						}
						myqueue.push(k);	
					}else{
						myqueue.pop();
						while(element[myqueue.getFront()]<element[k]&&!myqueue.isEmpty()){
							myqueue.pop();
						}
						while(element[myqueue.getRear()]<element[k]&&!myqueue.isEmpty()){
							myqueue.deQueueRear();
						}
						myqueue.push(k);
					}
					if(k>=length-1){
						max[y]=element[myqueue.getFront()];
						System.out.print(max[y]+" ");
						y++;
					}
				}
				
			}
		}
	}
}
