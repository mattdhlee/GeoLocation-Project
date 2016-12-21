
public class Tester {

	
	
	public static void main(String[] args) {
		String m = "(212) 564-7333";
		String[] temp = m.split("\\s+|\\(|\\)|\\-");
		String a= "";
		for (String s: temp) {
			a+= s;
	
		}
		System.out.println(a);
		
	}
}
