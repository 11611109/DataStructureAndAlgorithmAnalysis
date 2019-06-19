import java.util.Scanner;
public class Gametest {

//两个石头属性可以一样吗

		static int size;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner input=new Scanner(System.in);
			int testcases=input.nextInt();
			int distance=0;
			for(int i=0;i<testcases;i++){
				size=input.nextInt();
				node [] array=new node [size];
				for(int j=0;j<size;j++){
					array[j]=new node();
				}
				for(int k=0;k<size;k++){
					array[k].p=input.nextInt();
					array[k].d=input.nextInt();
					//System.out.println(k+":"+array[k].p+" "+array[k].d);
				}
				min_heap(array);
				/*for(int l=0;l<size;l++){
					System.out.println(l+":"+array[l].p+" "+array[l].d);
				}*/
				int count=1;
				int t;
				while(size!=0){
					//System.out.println(count);
					//System.out.println("min:"+array[0].p);
					if(count%2==0){
						t=delete_min(array);
						if(array[0].p==0){
							distance=t;
						}
						min_heap(array);
					}else{
						throwStone(array);
						//System.out.println("flag"+count);
						min_heap(array);
					}
					count++;
				}
				System.out.println(distance);
			}
		}
		public static void min_heap(node [] a){
			for(int m=(size-1)/2;m>=0;m--){
				for(int n=m;n<=(size-1)/2;n++){
					adjust(n,a);
				}

			}
		}
		public static void adjust(int father,node [] a){
			int pc1,dc1,pc2,dc2;
				int pf=a[father].p;
				int df=a[father].d;
				if((father*2+1)<size&&(father*2+2)<size){
					pc1=a[father*2+1].p;
					dc1=a[father*2+1].d;
					pc2=a[father*2+2].p;
					dc2=a[father*2+2].d;
					
					if(pf>pc1||pf>pc2){
						if(pc2<pc1||(pc2==pc1&&dc2<dc1)){
							a[father].setp(pc2);
							a[father].setd(dc2);
							a[father*2+2].setp(pf);
							a[father*2+2].setd(df);
						}else{
							a[father].setp(pc1);
							a[father].setd(dc1);
							a[father*2+1].setp(pf);
							a[father*2+1].setd(df);
						}
					}
				}else if((father*2+1)<size&&(father*2+2)>=size){
					pc1=a[father*2+1].p;
					dc1=a[father*2+1].d;
					if(pf>pc1||(pf==pc1&&df>dc1)){
						a[father].setp(pc1);
						a[father].setd(dc1);
						a[father*2+1].setp(pf);
						a[father*2+1].setd(df);
					}
				}
		}
		public static int delete_min(node [] a){
			int tmp=a[0].p;
			a[0].setp(a[size-1].p);
			a[0].setd(a[size-1].d);
			a[size-1].setp(0);
			a[size-1].setd(0);
			size--;
			return tmp;
		}
		public static void throwStone(node a []){
			a[0].setp(a[0].p+a[0].d);
		}

	}
	class node{
		int p;
		int d;
		public node(){
			this.p=0;
			this.d=0;
		}
		public void setp(int a){
			p=a;
		}
		public void setd(int b){
			d=b;
		}



}
