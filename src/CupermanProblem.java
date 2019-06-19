
import java.util.Scanner;
public class CupermanProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			String s1=null;
			String s2=null;
			String farmer="Farmer";
			String dizhu="Dizhu";
			
		    s1=scanner.nextLine();
			System.out.println( );
			s2=scanner.nextLine();
			String [] cards=s2.split(" ");
			
			if(s1.equals(farmer)&&cards.length==17||s1.equals(dizhu)&&cards.length==20){
				int [] countResult=count(cards);
				
				if(countResult[0]==1)
					System.out.print("RJ ");
				if(countResult[1]==1)
					System.out.print("WJ ");
				for(int j=4;j>0;j--){
					for(int k=2;k<15;k++){
						if(countResult[k]==j)
							for(int l=0;l<j;l++){
							printCard(k);
							}
					}
				}
				
			}
			else System.out.print("There is something wrong with the format of input.");
		}

	}
	public static int[] count(String [] s){
		int [] countCards=new int[15];
		for(int i=0;i<s.length;i++){
			switch(s[i]){
			case "RJ":
				countCards[0]++;
				break;
			case "WJ":
				countCards[1]++;
				break;
			case "2":
				countCards[2]++;
				break;
			case "A":
				countCards[3]++;
				break;
			case "K":
				countCards[4]++;
				break;
			case "Q":
				countCards[5]++;
				break;
			case "J":
				countCards[6]++;
				break;
			case "10":
				countCards[7]++;
				break;
			case "9":
				countCards[8]++;
				break;
			case "8":
				countCards[9]++;
				break;
			case "7":
				countCards[10]++;
				break;
			case "6":
				countCards[11]++;
				break;
			case "5":
				countCards[12]++;
				break;
			case "4":
				countCards[13]++;
				break;
			case "3":
				countCards[14]++;
				break;
			default:
				System.out.print("There is something wrong with the format of input.");
				break;
			}
		
		}
		return countCards;
		}
	public static void printCard(int k){
		switch(k){
		case 2:
			System.out.print("2");
			break;
		case 3:
			System.out.print("A");
			break;
		case 4:
			System.out.print("K");
			break;
		case 5:
			System.out.print("Q");
			break;
		case 6:
			System.out.print("J");
			break;
		case 7:
			System.out.print("10");
			break;
		case 8:
			System.out.print("9");
			break;
		case 9:
			System.out.print("8");
			break;
		case 10:
			System.out.print("7");
			break;
		case 11:
			System.out.print("6");
			break;
		case 12:
			System.out.print("5");
			break;
		case 13:
			System.out.print("4");
			break;
		case 14:
			System.out.print("3");
			break;
		}
		System.out.print(" ");
	}
}
