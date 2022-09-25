package map;

import set.*;
import list.*;
import java.io.*;
import sort.*;

/** Use a list of English words to unscramble
 *  the enemies messages.
 *  @author (sdb & Matthew Cipriotti)
 *  @version (Apr 2019)
 */
public class CodeBreakerHelp
{
    static List<String> list = new ArrayList<String>();
    static Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) {
    	
    	list = getWords();
    	
    	for(int i = 0; i < list.size(); i++) {
    		String w = list.get(i);
    		String s = sort(w);
    		
    		if(map.get(s) != null) {
    			map.get(s).add(w);
    		}
    		else {
    			map.put(s, new ArrayList<String>());
        		map.get(s).add(w);
    		}
    	}
    	
    	String s1 = sort("niaiuanmrisotzrtiiocm");
    	String s2 = sort("fo");
    	String s3 = sort("uealcisonlesm");
    	String s4 = sort("npesoaw");
    	String s5 = sort("tpso");
    	String s6 = sort("nialtrenosotiaertuc");
    	
    	
    	System.out.println(map.get(s1) + " " + map.get(s2) + " " + map.get(s3) + " " + map.get(s4) + " " + map.get(s5) + " " + map.get(s6));
    }
     
   // get a list of English words from a text file
    private static List <String> getWords ()
    {
    List <String> strings = new ArrayList <String> ();
    try
    {
    File wordFile = new File ("words.txt");
    java.util.Scanner scanner = new java.util.Scanner (wordFile);
    String word;
    while (scanner.hasNextLine())
        strings.add (scanner.nextLine());
    scanner.close();
    }
   catch (FileNotFoundException fnfe)
    {   System.err.println (fnfe);   }
    return strings;
    }
    

    /** @return the given string, with letters in alphabetic order
     *  If str is "pots" the result should be "opst"
     */
    private static String sort (String str)
    {   List <Character> chars = new ArrayList <Character> ();
    for (int i=0; i<str.length(); i++)
        chars.add (str.charAt(i));
     
    Sorter<Character> sorter = new HeapSort<Character>();
    sorter.sort(chars);
    
    String result = "";
    Iterator <Character> itty = chars.iterator();
    while (itty.hasNext())
        result += itty.next();
    return result;
    }

}
