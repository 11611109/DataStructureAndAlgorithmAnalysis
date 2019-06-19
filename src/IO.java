

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;


	public class IO {

	private static InputReader input;

	private static StringBuilder out=new StringBuilder();
	private static class InputReader { 

	public BufferedReader 	  reader;
	public StringTokenizer tokenizer;

	public InputReader (InputStream stream) { 
	reader = new BufferedReader (new InputStreamReader (stream) , 30000000) ;
	tokenizer = null;
	}

	public String next ( ) {
	while (tokenizer == null || ! tokenizer . hasMoreTokens ( ) ) {
	try { 
	tokenizer = new StringTokenizer (reader . readLine ( ) ) ;
	} catch (IOException e) {
	throw new RuntimeException (e) ;
	}
	}
	return tokenizer.nextToken ( ) ;
	}
	public int nextInt ( )	{
	return Integer.parseInt(next ( )) ;
	}

	}



	public static void main(String[] args) {
	input = new InputReader(System. in) ;
	int T = input.nextInt();
	while(T!=0) {

	T--;
	}
	System.out.print(out);
	}

}
