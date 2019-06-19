package lab4;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Iterator;

public class magicQueue {
	
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int testcases=input.nextInt();
    int operations,ins1,ins2,ins3;
    ArrayDeque<Integer> magicqueue=new ArrayDeque<Integer>();
	if(0<=testcases&&testcases<=10){
		for(int i=0;i<testcases;i++){
			operations=input.nextInt();
			for(int j=0;j<operations;j++){
				ins1=input.nextInt();
				ins2=input.nextInt();
				
				if(ins1==1){
					if(ins2==1){
						ins3=input.nextInt();
						magicqueue.addFirst(ins3);
					}else if(ins2==2){
						magicqueue.pollFirst();
					}
				}else if(ins1==2){
					if(ins2==1){
						ins3=input.nextInt();
						magicqueue.addLast(ins3);
					}else if(ins2==2){
						magicqueue.pollLast();
					}
				}else{
					System.out.print("Wrong input!");
				}
			}
			Integer a;
				if(!magicqueue.isEmpty()){
					Iterator iter=magicqueue.iterator();
					while(iter.hasNext()){
						a=(Integer)iter.next();
						System.out.println(a);
					}
				}
			}
		}
	}
}
