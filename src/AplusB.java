import java.util.Scanner;

public class AplusB {

public static void main(String []args) {
	Scanner scanner = new Scanner(System.in);
	
	while(scanner.hasNext()){
		
	String s1=null;
	String s2=null;
	String s3=null;
	
	s1=scanner.next();
	
	s2=scanner.next();
	
	        
	if(s1.length()<s2.length()){
	s3=s2;
	s2=s1;
	s1=s3;
	}
	int len1=s1.length();
	int len2=s2.length();

	StringBuffer re1 = new StringBuffer(s1);
	StringBuffer re2 = new StringBuffer(s2);

	s1=re1.reverse().toString();
	s2=re2.reverse().toString();

	char [] A=s1.toCharArray();
	char [] B=s2.toCharArray();

	int maxLength=Math.max(len1,len2);
	int [] a=new int[len1];
	int [] b=new int[len2];
	int [] sum=new int[maxLength+1];
	

	        
	for(int i=0;i<len1;i++){
	a[i]=Integer.parseInt(String.valueOf(A[i]));
	}
	for(int j=0;j<len2;j++){
	b[j]=Integer.parseInt(String.valueOf(B[j]));
	}
	    

	if(len1==len2){
	for(int k=0;k<len1;k++){
	if(a[k]+b[k]+sum[k]<10)
	    sum[k]=a[k]+b[k]+sum[k];
	else{
	sum[k]=(a[k]+b[k]+sum[k])%10;
	sum[k+1]=1;
	}
	}
	}

	if(len1>len2){
	for(int m=0;m<len2;m++){
	if(a[m]+b[m]+sum[m]<10)
	    sum[m]=a[m]+b[m]+sum[m];
	else{
	sum[m]=(a[m]+b[m]+sum[m])%10;
	sum[m+1]=1;
	}
	}
	for(int n=len2;n<len1;n++){
	sum[n]=sum[n]+a[n];
	}
	}
	if(sum[maxLength]==0){
	for(int o=0;o<maxLength;o++)
	System.out.print(sum[maxLength-o-1]);       
	}
	else{
	for(int p=0;p<maxLength+1;p++)
	System.out.print(sum[maxLength-p]); 
	}
	System.out.println( );
	}
	scanner.close();
	
}
}