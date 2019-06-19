package lab8;

import java.util.Scanner;

public class Judgement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rootId=0;
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		for(int i=0;i<testcases;i++){
			int flag=0,nodeNm=0;
			nodeNm=input.nextInt();
			int [] inorder=new int[nodeNm];
			myNode [] array=new myNode[nodeNm+1];
			
			array[0]=new myNode();
			for(int j=1;j<nodeNm+1;j++){
				array[j]=new myNode();
				array[j].value=input.nextInt();
			}
			int father,child;
			for(int k=0;k<nodeNm-1;k++){
				father=input.nextInt();
				child=input.nextInt();
				if(array[child].value>array[father].value&&array[father].right==0){
					array[father].right=child;
					array[child].root=false;
				}else if(array[child].value<array[father].value&&array[father].left==0){
					array[father].left=child;
					array[child].root=false;
				}else if(array[father].right!=0&&array[father].left!=0){
					System.out.println("Case #"+(i+1)+":NO");
					flag=1;
				}
			}
			if(flag==0){
				for(int m=1;m<nodeNm+1;m++){
					if(array[m].root==true){
						rootId=m;
					}
				}
		
				inTranverse(inorder,rootId,array,nodeNm);	
				int start=0,count=0;
				while(start<(nodeNm-1)){
					if(inorder[start]<inorder[start+1]){
						count++;
						start++;
					}else{
						break;
					}
				}
				if(count==nodeNm-1){
					System.out.println("Case #"+(i+1)+":YES");
				}else{
					System.out.println("Case #"+(i+1)+":NO");
				}
			}
		}
	}
	public static void inTranverse(int [] a,int rootId,myNode [] b,int nodeNm){
		if(b[rootId].value==0)return;
		int id=0;
		myStack s=new myStack(nodeNm+1);
		while(b[rootId].value!=0||!s.isEmpty()){
			while(b[rootId].value!=0){
				s.push(rootId);
				rootId=b[rootId].left;
			}
			rootId=s.pop();
			a[id]=b[rootId].value;
			id++;
			rootId=b[rootId].right;
		}
	}
	
}
class myStack {
	int [] stack;
	int capacity;
	private int top=-1;
	public myStack(int c){
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
}
class myNode{
	int value;
	boolean root;
	int left;
	int right;
	public myNode(){
		this.value=0;
		this.left=0;
		this.right=0;
		this.root=true;
	}
}
