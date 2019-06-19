package lab8;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a={1,2,3};
		System.out.println(a[0]);
	    change(a);
	    System.out.println(a[0]);
	}

	public static void change(int []b){
		b[0]=99;
	}
}
