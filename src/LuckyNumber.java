import java.util.Scanner;

public class LuckyNumber {

	static int Count;
	static Long L=new Long("0");
	static Long R=new Long("0");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			Count=0;
		L=scanner.nextLong();
		R=scanner.nextLong();
		int len2=R.toString().length();
		if(L==0){
			Count=1;
		}
		if(L>R){
			System.out.print("The left number should be smaller than the right number");
		}
		else if(L.equals(R)){
			System.out.print("0");
		}
		else{
		String a="8";
		String b="1";
		String c="0";
		String d="11";
		String e="88";
		String f="69";
		String g="96";
		String h="00";
		
		generate(a,len2);
		generate(b,len2);
		generate(c,len2);
		generate(d,len2);
		generate(e,len2);
		generate(f,len2);
		generate(g,len2);
		generate(h,len2);
		
		System.out.print(Count);
		}
		}
		scanner.close();
	}
	
	public static void generate(String s,int len2){
		int len=s.length();
		int maxLength=len2;
		if(len<=len2){
		if(Long.parseLong(s)<=R&&Long.parseLong(s)>=L){
			if(Integer.parseInt(String.valueOf(s.charAt(0)))!=0){
			Count++;
			}
			
			generate(generate1(s),maxLength);
			
			generate(generate2(s),maxLength);
			
			generate(generate3(s),maxLength);
			
			generate(generate4(s),maxLength);
		
			generate(generate5(s),maxLength);
			
		}
		else if(Long.parseLong(s)<L){
            generate(generate1(s),maxLength);
			
			generate(generate2(s),maxLength);
			
			generate(generate3(s),maxLength);
		
			generate(generate4(s),maxLength);
		
			generate(generate5(s),maxLength);
		}
		else{
			
		}
		}
	}
	
	 public static String generate1(String str){
		
		 str="1"+str+"1";
		 
		 return str;
	    }
	 public static String generate2(String str){
		 str="8"+str+"8";
		 return str;
	    }

	 public static String  generate3(String  str){
		 str="6"+str+"9";
		 return str;
	    }

	 public static String generate4(String str){
		 str="9"+str+"6";
		 return str;
	    }

	 public static String generate5(String str){
		 str="0"+str+"0";
		 return str;
	    }



}
   