package BasicsJava;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsDemo d = new MethodsDemo();

		String name = d.getData();
		
		System.out.println(name);
		
		
		
		MethodsDemo d1 = new MethodsDemo();
		MethodsDemo d2 = new MethodsDemo();
		
		String nam=d1.getData2();
		System.out.println(nam);
	}
	public String getData()

	{

	System.out.println ("hello world1");

	return "rahul shetty1";

	}



	public static String getData2()

	{

	System.out.println ("hello world2");

	return "rahul shetty2";

	}



}
