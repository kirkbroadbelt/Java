import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//75,7,3,8,8,7,T,5,9,A,6
//80,9,T,7,8,K,A,3,5,Q,T
//94,4,2,2,7,T,3,A,5,J,K
//80,6,6,4,T,9,8,6,5,Q,K
//90,T,8,5,9,9,Q,K,A,J,8
public class acsl {
	   public static int getValue(String val){
		   if(val.equals("T")){
			   return 10;
		   }
		   else if(val.equals("J")){
			   return 11;
		   }
		   else if(val.equals("Q")){
			   return 12;
		   }
		   else if(val.equals("K")){
			   return 13;
		   }
		   else if(val.equals("A")){
			   return 14;
		   }
		   else{
			   return Integer.valueOf(val);
		   }
	   }
	   public static int getScore(String fix){
		 
		   if(fix.equals("J")){
			   return 11;
		   }
		   else if(fix.equals("Q")){
			   return 12;
		   }
		   else if(fix.equals("K")){
			   return 13;
		   }
		   else{
			   return 0;
		   }
	   }
	public static void main(String[] args) {
        String csvFile = "H://Desktop/input.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
        	
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	int score=0;
                // use comma as separator
                String[] input = line.split(cvsSplitBy);
                score = Integer.parseInt(input[0]);
                String temp;
//                System.out.print("\n");
//                for(int x=0;x<11;x++){
//                	System.out.print(input[x]+" ");
//                }
                int timecounterP=4,timecounterD=5,turnint=0;
                while(score<100){
//                	System.out.println(score+ "  " + turnint);
                	turnint=0;
                    for(int x=1;x<4;x++){
                    	for(int a=x+1;a<4;a++){
                    		if(getValue(input[x])<getValue(input[a])){
                   			temp=input[x];
                    		input[x]=input[a];
                   			input[a]=temp;
                    		}
                    	}
                    }
//                    System.out.print("\n");
//                    for(int x=0;x<11;x++){
//                    	System.out.print(input[x]+" ");
//                    }
                	if(getValue(input[1])!=9 && getValue(input[1])!=10 && getValue(input[1])!=14){
                		if(getScore(input[1])>10){
                			score=score+getScore(input[1]);
                		}
                		else{
                 		score=score+getValue(input[1]);
                		}
                	}
                	else if(getValue(input[1])==10){
                		score=score-10;
                	}
                	else if(getValue(input[1])==14){
//                		System.out.println("HERE");
                		if(score+14<100){
                			score=score+14;
                		}
                		else{
                			++score;
                		}
                	}
                	input[1]=input[timecounterP];
                	timecounterP=timecounterP+2;
                	if(score>99){
                		break;
                	}
                	else{
                	turnint=1;
//                	if(timecounterD>9){
//                		timecounterD=9;
//                	}
//                	System.out.println(score+ "  " + turnint);
                 	if(getValue(input[timecounterD])!=9 && getValue(input[timecounterD])!=10 && getValue(input[timecounterD])!=14){
                		if(getScore(input[timecounterD])>10){
                			score=score+getScore(input[timecounterD]);
                		}
                		else{
                 		score=score+getValue(input[timecounterD]);
                		}
                	}
                	else if(getValue(input[timecounterD])==10){
                		score=score-10;
                	}
                	else if(getValue(input[timecounterD])==14){
                		
                		if(score+14<100){
                			score=score+14;
                		}
                		else{
                			++score;
                		}
                	}
                 	timecounterD=timecounterD+2;
                	}
                }
                if(turnint==1){
                	System.out.println(score+", player");
                }
                else if (turnint==0){
                	System.out.println(score+", dealer");
                }
                else{
                	System.out.print("error");
                }
//                c=c+1;
//                System.out.print("["+ c +"]");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
