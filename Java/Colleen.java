/*
	Comment1
*/

public class Colleen {

	public static void main(String[] args) {
		/*
			Comment2
		*/
		String s = "/*%2$c%3$cComment1%2$c*/%2$c%2$cpublic class Colleen {%2$c%2$c%3$cpublic static void main(String[] args) {%2$c%3$c%3$c/*%2$c%3$c%3$c%3$cComment2%2$c%3$c%3$c*/%2$c%3$c%3$cString s = %4$c%s%4$c;%2$c%3$c%3$cprint(s);%2$c%3$c}%2$c%2$c%3$cpublic static void print(String s) {%2$c%3$c%3$cSystem.out.printf(s, s, 10, 9, 34);%2$c%3$c}%2$c}%2$c";
		print(s);
	}

	public static void print(String s) {
		System.out.printf(s, s, 10, 9, 34);
	}
}
