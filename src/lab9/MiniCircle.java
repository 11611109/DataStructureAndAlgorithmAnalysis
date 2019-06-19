package lab9;

import java.util.Scanner;

public class MiniCircle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int testcases=input.nextInt();
		int node,line,query;
			for(int i=0;i<testcases;i++){
				node=input.nextInt();
				line=input.nextInt();
				query=input.nextInt();
				int row,column;
				int [][] AM=new int [node+1][node+1];
				
				int c;
				for(int j=0;j<line;j++){
					c=input.nextInt();
					row=input.nextInt();
					column=input.nextInt();
					AM[row][column]=1;
					for(int k=0;k<c-2;k++){
						row=column;
						column=input.nextInt();
						AM[row][column]=1;
					}
				}
				///³õÊ¼»¯/graph build.
				
				//Floyd 
				for(int p=1;p<node+1;p++){
					for(int q=1;q<node+1;q++){
						for(int r=1;r<node+1;r++){
							if(AM[q][r]==0&&AM[q][p]!=0&&AM[p][r]!=0){
								AM[q][r]=(AM[q][p]+AM[p][r]);
							}else{
								if(AM[q][r]>(AM[q][p]+AM[p][r])&&AM[q][p]!=0&&AM[p][r]!=0){
								AM[q][r]=(AM[q][p]+AM[p][r]);
							}
							}
							
						}
					}
				}
				
				int q;
				for(int z=0;z<query;z++){
					q=input.nextInt();
					if(AM[q][q]!=0){
						System.out.println(AM[q][q]);
					}else{
						System.out.println(-1);
					}
					
				}
			}
	}
	
}
