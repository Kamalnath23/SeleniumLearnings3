package BasicsJava;
import java.util.*;
public class JavaBasicArrayList {

	public static void main(String[] args) {
	
		System.out.println("Array List");
		ArrayList<String> a=new ArrayList<String>();
			//create object of the class -object.method
		a.add("Kamal");
		a.add("Thanisha");
		a.add("love");
		a.add("learning");
		a.add("null");
		a.remove(4);
		a.get(1);
		System.out.println(a.get(1));
	}
}
