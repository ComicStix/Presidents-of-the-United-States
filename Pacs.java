import java.io.*;
import java.util.*;

// N O   C O M M A N D  L I N E   A R G S!
// A L L   F I L E N A M E S  M U S T  B E  H A R D C O D E D

public class Pacs
{
	public static void main( String args[] ) throws Exception
	{
			BufferedReader pacsFile = new BufferedReader( new FileReader( "pacs.txt" ) );
			BufferedReader membersFile = new BufferedReader( new FileReader( "members.txt" ) );
			TreeMap<String, ArrayList<String>> memberToPacs = new TreeMap<String,ArrayList<String>>();
			TreeMap<String,ArrayList<String>> pacToMembers = new TreeMap<String,ArrayList<String>>();
			ArrayList<String> valueOfMemberKey = new ArrayList<String>();
			ArrayList<String> pacsFileArray = new ArrayList<String>();
			
			while( membersFile.ready() )
			{
				String [] pacAndMember = membersFile.readLine().split(" ");
				ArrayList<String> pacsArray = new ArrayList<String>(Arrays.asList( pacAndMember ));
				String key = pacsArray.get(0);
				pacsArray.remove(0);
				Collections.sort(pacsArray);
				memberToPacs.put( key, pacsArray);
			}

			

			while ( pacsFile.ready() ){
				
				pacsFileArray.add(pacsFile.readLine()); 
			}
			
			

			for (String s: memberToPacs.keySet())
			{
				valueOfMemberKey = memberToPacs.get(s);
				
				for (int i = 0; i < pacsFileArray.size();i++)
				{
					for (int j = 0; j < valueOfMemberKey.size();j++)
					{
						if (pacsFileArray.get(i).equals(valueOfMemberKey.get(j)))
						{
							if (!pacToMembers.containsKey(pacsFileArray.get(i)))
							{
								pacToMembers.put(pacsFileArray.get(i),new ArrayList<String>());
							}
							pacToMembers.get(pacsFileArray.get(i)).add(s);
						}
					}
					if (!pacToMembers.containsKey(pacsFileArray.get(i)))
						pacToMembers.put(pacsFileArray.get(i),new ArrayList<String>());
				}
			}



			for (String s: pacToMembers.keySet())
			{
				System.out.print(s + " ");
				for (String v: pacToMembers.get(s))
				{
					System.out.print(v + " ");
				}
				System.out.println();
			}



	} // END MAIN

} // CLASS
