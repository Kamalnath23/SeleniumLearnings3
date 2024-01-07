package Section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class javaStreamTest1 {

		//Count the no.of.names starting with Alphabet a in the list
		@Test
		public void regular() {
			System.out.println("Test 1");
			ArrayList<String> names = new ArrayList<String>();
			names.add("Abhishek");
			names.add("Don");
			names.add("Alekya");
			names.add("Adam");
			names.add("Ram");
			
			int count=0;
			for(int i=0;i<names.size();i++) {
				String name=names.get(i);
				if(name.startsWith("A")) {
					count++;
				}
			}
			System.out.println("Total names start with A is : "+count);
		}
		
		@Test
		public void streamFilter() {
			System.out.println("\nTest 2");
			ArrayList<String> names = new ArrayList<String>();
			names.add("Abhishek");
			names.add("Don");
			names.add("Alekya");
			names.add("Adam");
			names.add("Ram");
			
			Long c=names.stream().filter(s->s.startsWith("A")).count();
			// return type of count is Long - NB
			System.out.println(c);
			
			
			long d= Stream.of("Abhishek","Don","Alekya","Adam","Ram").filter(s->{
				
			s.startsWith("A");
			return true;
			}).count();
			
			System.out.println(d);
				
			
		}
		
		@Test
		public void streamFilter2() {
			System.out.println("\nTest 3");
			ArrayList<String> names = new ArrayList<String>();
			names.add("Abhishek");
			names.add("Don");
			names.add("Alekya");
			names.add("Adam");
			names.add("Ram");
			
			Long c=names.stream().filter(s->s.startsWith("A")).count();
			// return type of count is Long - NB
			System.out.println(c);
			
			names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
			System.out.println();
			names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));	
			
		}
		
		@Test
		public void streamMap() {
			// Map method is used for modification
			// Printing of names which has last letter a with upper case
			System.out.println("\nTest 4");
			Stream.of("Abhishek","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			// Printing of names which has first letter a with upper case and sorted
			// Convert arrays into array list
			// Arrays.asList(null);
			
			/* ArrayList<String> names = new ArrayList<String>();
			names.add("Abhishek");
			names.add("Don");
			names.add("Alekya");
			names.add("Adam");
			names.add("Ram"); */
		}
		
		@Test
		public void streamMap2() {

			System.out.println("\ntest 5");
			// Printing of names which has first letter a with upper case and sorted
			// Convert arrays into array list
			// Arrays.asList(null);
			
			
			List<String> names = Arrays.asList("Azhishek","Don","Alekya","Adam","Rama");
			names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
		}
		
		@Test
		public void streamMap3() {

			// Merging or Connecting 2 streams.
			
			System.out.println("\ntest 6");
			
			ArrayList<String> names = new ArrayList<String>();
			names.add("Man");
			names.add("Don");
			names.add("Woman");
			names.add("Warlock");
			names.add("Ramu");
			
			
			List<String> names1 = Arrays.asList("Azhishek","Don","Alekya","Adam","Rama");
			//names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			Stream<String> mergedStream =  Stream.concat(names.stream(), names1.stream());
			//mergedStream.sorted().forEach(s->System.out.println(s));  // Merging or Connecting 2 streams.
			
			// Finding any name is present in the merged arraylist
			boolean flag= mergedStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
			Assert.assertTrue(flag);
			System.out.println(flag);
			
		}
		
		@Test
		public void streamCollect() {
			//this method convert list to streams to manipulation into list
			System.out.println("\ntest 7");
			
			List<String> names = Arrays.asList("Azhishek","Don","Alekya","Adam","Rama");
			List<String> ls= names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
			.collect(Collectors.toList());
			ls.get(0);
			
			System.out.println(ls.get(0));
			
			// you can use limit as well for this test verification
			
		}
		
		@Test
		public void assignment() {
			System.out.println("\nTest 8");
			
			List<Integer> numbers= Arrays.asList(3,2,2,7,5,1,9,7);
			// print unique numbers from this array
			//sort the array		
			numbers.stream().distinct().forEach(i->System.out.println(i));
			
			System.out.println();
			// print unique numbers from this array
			//sort the array and show 3rd element
			List<Integer> ls = numbers.stream().distinct().sorted()
			.collect(Collectors.toList());
			
			System.out.println(ls.get(2));
			
			
		}
}
