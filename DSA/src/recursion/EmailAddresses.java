package recursion;

import java.util.*;

/** Maintain email addresses, with aliases.
 * @author (sdb)
 * @author (Matthew Cipriotti)
 */
public class EmailAddresses
{
  // The keys are strings, such as "alsFriends"
  // The corresponding values are Lists of Strings, such as
  //  ["joe@yahoo.com","bill@gmail.com"]
  private Map <String, List <String>>  book;

  public EmailAddresses ()
  {  book = new HashMap <String, List <String>> ();  }

  /** Associate the given alias with the given people */
  public void add (String alias, List <String> people)
  // Add this entry to the map
  {	
	  book.put(alias, people);
    }

  
  /** @return All the email addresses corresponding to
   * the given alias, in a List.
   */
  public List <String> expandAlias (String alias)
  {	
	  List<String> result = new ArrayList<String>();
	  
	  if(!book.containsKey(alias)) {
		  result.add(alias);
		  return result;
	  }
	  
	  for(String s : book.get(alias))
		  result.addAll(expandAlias(s));
	  return result;
		  
      
   }	
}
