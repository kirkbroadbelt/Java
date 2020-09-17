
import java.util.Scanner;

public class phnumr {
	public static void main (String[] args){
        System.out.println("Enter phone number");
        Scanner console = new Scanner (System.in);
        String in = console.nextLine();
        in.trim();
        String sb="";
        for(int x=0;x<in.length();x++){
            if(in.charAt(x)!=' ' && in.charAt(x)!='(' && in.charAt(x)!=')' && in.charAt(x)!='-' && in.charAt(x)!='e' && in.charAt(x)!='x' && in.charAt(x)!='t'){
                sb= sb + in.charAt(x);
                System.out.println(sb);
            }
        }
        System.out.println(sb);
    }
}
