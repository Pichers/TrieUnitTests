package startup;

import java.io.*;
import java.util.*;

import sut.TST;

public class Run {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("data/someWords.txt"));
			
		TST<Integer> st = new TST<>();
		
		int i=0;
		while(sc.hasNextLine()) {
			String[] keys = sc.nextLine().split(" ");
			for(String key : keys)
				st.put(key, ++i);
		}
		
		for (String key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
		
		System.out.println("longestPrefixOf(\"shellsort\"):");
		System.out.println(st.longestPrefixOf("shellsort"));
		
		System.out.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
        	System.out.println(s);
        
        System.out.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
        	System.out.println(s);
		
		sc.close();
	}

}
