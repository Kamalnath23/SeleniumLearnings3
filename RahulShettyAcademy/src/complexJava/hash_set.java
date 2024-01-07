package complexJava;

import java.util.HashSet;
import java.util.Set;

public class hash_set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Demonstrating Set using HashSet
		// Declaring object of type String
		Set<String> hash_Set = new HashSet<String>();

		// Adding elements to the Set
		// using add() method
		hash_Set.add("Geeks");
		hash_Set.add("For");
		hash_Set.add("Geeks");
		hash_Set.add("Example");
		hash_Set.add("Set");

		// Printing elements of HashSet object
		System.out.println(hash_Set);
	}

}
