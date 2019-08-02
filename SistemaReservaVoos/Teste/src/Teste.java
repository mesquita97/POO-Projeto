import java.util.ArrayList;

public class Teste {
//	   public static void vowelsubstring(String s) {
//	        ArrayList<Character> vowels = new ArrayList<Character>();
//	        vowels.add('a');
//	        vowels.add('e');
//	        vowels.add('i');
//	        vowels.add('o');
//	        vowels.add('u');
//
//	        int nSubstrings=0;
//
//	        for(int i=0; i<s.length(); i++){
//	            String substring="x";
//	            while(! vowels.contains(s.charAt(i))){
//	                substring.concat(Character.toString(s.charAt(i)));
//	                i++;
//	                if(substring.contains("aeiou")) nSubstrings++;       
//	                System.out.print(substring);
//	            }
//	        }  
//	    }


	public static void main(String[] args) {
		String s = "abcde";
		s.concat((Character.toString('a')));
		System.out.print(s);
	}

}

