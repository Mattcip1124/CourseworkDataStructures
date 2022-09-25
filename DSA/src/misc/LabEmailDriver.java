package misc;

import recursion.*;
import java.util.*;
 
public class LabEmailDriver
{  public static void main (String [] args)
   { EmailAddresses buddies = new EmailAddresses();

   List <String> folks;

   folks = new LinkedList <String> ();
   folks.add ("pat@ex.edu");
   folks.add ("chris@ez.edu");
   buddies.add ("techstaff", folks);

   folks = new LinkedList <String> ();
   folks.add ("bobby");
   folks.add ("ana");
   folks.add ("sam@ez.edu");
   buddies.add ("faculty", folks);

   folks = new LinkedList <String> ();
   folks.add ("bob@cs.org");
   buddies.add ("bobby", folks);

   folks = new LinkedList <String> ();
   folks.add ("ana@ez.edu");
   buddies.add ("ana", folks);

   folks = new LinkedList <String> ();
   folks.add ("phil@ez.edu");
   folks.add ("faculty");
   folks.add ("techstaff");
   buddies.add ("all", folks);
System.out.println ("techstaff: " + buddies.expandAlias ("techstaff"));
System.out.println ("faculty: " + buddies.expandAlias ("faculty"));
System.out.println ("bobby: " + buddies.expandAlias ("bobby"));
System.out.println ("ana: " + buddies.expandAlias ("ana"));
System.out.println ("all: " + buddies.expandAlias ("all"));
   } 

}
