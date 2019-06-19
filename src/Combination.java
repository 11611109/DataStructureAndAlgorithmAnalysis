import java.util.Scanner;

public class Combination {
static int size;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		for(int i=0;i<testcases;i++){
			int k,sum=0;
			size=input.nextInt();
			k=input.nextInt();
			Node [] array=new Node[size];
			for(int j=0;j<size;j++){
				array[j]=new Node(input.nextInt());
			}
			min_heap(array);
			while(size!=1){
				for(int x=0;x<k;x++){
					sum+=delete_min(array);
					min_heap(array);
				}
				System.out.println(sum);
				add(array,sum);
				min_heap(array);
			}
			System.out.println(sum);
		}
	}
	public static void min_heap(Node [] a){
		for(int m=(size-1)/2;m>=0;m--){
			for(int n=m;n<=(size-1)/2;n++){
				adjust(n,a);
			}

		}
	}
	public static void adjust(int father,Node [] a){
		int c1,c2;
			int faValue=a[father].value;
			if((father*2+1)<size&&(father*2+2)<size){
				c1=a[father*2+1].value;
				c2=a[father*2+2].value;
				
				if(faValue>c1||faValue>c2){
					if(c2<c1){
						a[father].value=c2;
						a[father*2+2].value=faValue;
					}else{
						a[father].value=c1;
						a[father*2+1].value=faValue;
					}
				}
			}else if((father*2+1)<size&&(father*2+2)>=size){
				c1=a[father*2+1].value;
				if(faValue>c1){
					a[father].value=c1;
					a[father*2+1].value=faValue;
				}
			}
	}
	public static int delete_min(Node [] a){
		int tmp=a[0].value;
		a[0].value=a[size-1].value;
		a[size-1].value=0;
		size--;
		return tmp;
	}
	public static void add(Node [] a,int b){
		a[size].value=b;
		size++;
	}
}
class Node{
	int value;
	public Node(int a){
		this.value=a;
	}
}