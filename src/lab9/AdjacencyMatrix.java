package lab9;

import java.util.Scanner;

public class AdjacencyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,edge;
		int row,column;
			for(int m=0;m<testcases;m++){
				node=input.nextInt();
				edge=input.nextInt();
				int [][] AM=new int [node][node];
				if(edge!=0){
					for(int i=0;i<edge;i++){
						row=input.nextInt();
						column=input.nextInt();
						AM[row-1][column-1]=1;
					}
				}
				if(edge!=0){
					for(int j=0;j<node;j++){
						for(int k=0;k<node;k++){
							System.out.print(AM[j][k]+" ");
						}
						System.out.println( );
					}
				}else{
					System.out.println(0);
				}
				
			}
	}

}
