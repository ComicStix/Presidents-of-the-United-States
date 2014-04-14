import java.util.*;
import java.io.*;
import java.util.Collections.*;

// NO CMD ARGS - ALL FILENAMES MUST BE HARDOCDED AS I HAVE DONE FOR YOU HERE

public class Potus
{
	public static void main( String[] args )  throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader("state2Presidents.txt") );
		BufferedReader infile2 = new BufferedReader( new FileReader("allPresidents.txt") );
		BufferedReader infile3 = new BufferedReader( new FileReader("allStates.txt") );

		// YOUR CODE HERE TO DECLARE MAPS OR SETS TO HOLD THE DATA OF THESE THREE INPUT FILES

		TreeMap<String,ArrayList<String>> statesToPresidents = new TreeMap<String,ArrayList<String>>();
		TreeMap<String,String> reversedMap = new TreeMap<String,String>();
		TreeSet<String> presidentsWithoutStates = new TreeSet<String>();
		TreeSet<String>statesWithoutPresidents = new TreeSet<String>();

		// ################# STEP #1 worth 40% ###################

		// YOUR CODE HERE TO READ infile1 INTO A Map

		while ( infile1.ready() )
		{
				String [] split = infile1.readLine().split(" ");
				ArrayList<String> states = new ArrayList<String>( Arrays.asList(split));
				String key = states.get(0);
				states.remove(0);
				Collections.sort( states );
				statesToPresidents.put(key, states );
		}

		infile1.close();

		System.out.println( "The following states had these presidents born in them:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO *PRINT* THE MAP ACCORDING TO THe FORMAT SPECIFIED FOR STEP #1
		// DUMP IT LAZY = 60%  OR  PRINT IT FORMATTED = 70%

		for (String s: statesToPresidents.keySet()){
			System.out.print(s);
			for (String v: statesToPresidents.get(s)){
				System.out.print(" " + v);
			}
			System.out.println();
		}

		// ################# STEP #2 worth 20% ###################
		
		for (String s: statesToPresidents.keySet()){
			String value = s;
			ArrayList<String> keysOfStates = new ArrayList<String>();
			keysOfStates = statesToPresidents.get(s);
			for (int i = 0; i < keysOfStates.size();i++) {
				reversedMap.put(keysOfStates.get(i),s);
			}
		}

		System.out.println( "\nList of presidents and the state each was born in:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO PRINT THE INVERSION OF THE MAP worth 15%
		
		for (String q: reversedMap.keySet()){
			System.out.println( q + " " +  reversedMap.get(q));
		}

		// ################# STEP #3 worth 20% ###################

		while (infile2.ready())
		{
			String president = infile2.readLine();
			if (reversedMap.containsKey(president)==false)
				presidentsWithoutStates.add(president);
		}

		infile2.close();

		System.out.println( "\nThese presidents were born before the states were formed:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO PRINT THE NAME(S) Of ANY PRESIDENT(s)
		//  WHO WERE BORN BEFORE THE STATES WERE FORMED = 10%

		Iterator<String> iterator = presidentsWithoutStates.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		// ################# STEP #4 worth 20% ###################

		while (infile3.ready()){
			String state = infile3.readLine();
			if (statesToPresidents.containsKey(state)==false){
				statesWithoutPresidents.add( state );
			}
		}
		infile3.close();
		
		System.out.println( "\nThese states had no presidents were born in them:\n");

		// YOUR CODE HERE TO PRINT THE NAME(S) OF ANY STATE(s) WHICH HAD NO PRESIDENT BORN IN THEM 5%

		iterator = statesWithoutPresidents.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	} // END MAIN

	//              - - - - - - - - - - -  H E L P E R    M E T H O D S     D O W N    H E R E  - - - - - - - - - -
}	// END POTUS CLASS