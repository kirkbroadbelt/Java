import java.util.Scanner; 
public class phnum {
	public static void main (String[] args){
		System.out.println("Enter phone number");
		Scanner console = new Scanner (System.in);
		String in = console.nextLine();
		if(in.length()==7){
			System.out.println("(919) "+in.substring(0, 3) + "-" + in.substring(3, in.length()));
		}
		else if(in.length()==10){
			System.out.println('('+ in.substring(0,3) + ") " + in.substring(3,6) + "-" + in.substring(6, in.length()));
		}
		else if(in.length()==11){
			System.out.println( "(919) "+in.substring(0,3) + "-" + in.substring(3,7) + " ext " + in.substring(7, in.length()));
		}
		else if(in.length()==14){
			System.out.println("("+ in.substring(0,3) + ") " + in.substring(3,6) + "-" + in.substring(6,10) + " ext " + in.substring(10, in.length()));
		}
		else if(in.length()==15){
			System.out.println("1 ("+in.substring(1,4) + ") " + in.substring(4,7) + "-" + in.substring(7,11) + " ext " + in.substring(11, in.length()));
		}
	}
}