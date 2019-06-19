package lab7;

import java.util.ArrayList;
import java.util.Scanner;
public class Heap {
	static int setSize;
	static ArrayList<Integer> sequence=new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();

			for(int m=0;m<testcases;m++){
				setSize=input.nextInt();
				for(int i=0;i<setSize;i++){
					sequence.add(input.nextInt());
				}
				BinaryHeap();
				//System.out.println(sequence.toString());
				int allOrder=input.nextInt();
				int order;
				for(int k=0;k<allOrder;k++){
					order=input.nextInt();
					switch(order){
					case 1:
						int addNumber=input.nextInt();
						add(addNumber);
						BinaryHeap();
						//System.out.println(sequence.toString());
						break;
					case 2:
						delete();
						BinaryHeap();
						//System.out.println(sequence.toString());
						break;
					case 3:
						query();
						//System.out.println(sequence.toString());
						break;
					}
				}
				sequence.clear();
			}
	}
	public static void add(int x){
		sequence.add(x);
		setSize++;
	}
	public static void delete(){
		sequence.set(0, sequence.get(setSize-1));
		sequence.remove(setSize-1);
		setSize--;	
	}
	public static void query(){
		System.out.println(Integer.valueOf(sequence.get(0).toString()));
	}
	public static void BinaryHeap(){
		for(int j=(setSize-1)/2;j>=0;j--){//-1or-2?
			adjust(j);
		}
	}
	public static void adjust(int father){
		int tmp,child1,child2;
		if(father<=(setSize-1)/2){
		int Father=Integer.valueOf(sequence.get(father).toString());
		if((father*2+1)<setSize&&(father*2+2)<setSize){
			child1=Integer.valueOf(sequence.get(father*2+1).toString());
		    child2=Integer.valueOf(sequence.get(father*2+2).toString());
			
				if(Father>=child1&&Father<=child2){
					sequence.set(father, child1);
					sequence.set(father*2+1, Father);
				}else if(Father<=child1&&Father>=child2){
					sequence.set(father, child2);
					sequence.set(father*2+2, Father);
				}else if(Father>=child1&&Father>=child2){
					if(child1>child2){
						sequence.set(father, child2);
						sequence.set(father*2+2, Father);
					}else{
						sequence.set(father, child1);
						sequence.set(father*2+1, Father);
					}
				}
				adjust(father*2+1);
				adjust(father*2+2);
		}else if((father*2+1)<setSize&&(father*2+2)>=setSize){
			child1=Integer.valueOf(sequence.get(father*2+1).toString());
			if(Father>=child1){
				tmp=Father;
				sequence.set(father, child1);
				sequence.set(father*2+1, tmp);
			}
			adjust(father*2+1);
		}
		
		}
	}
}
