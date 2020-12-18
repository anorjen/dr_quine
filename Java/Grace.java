import java.io.FileWriter;
import java.io.IOException;

public class Grace {
	static {
		String s = "import java.io.FileWriter;%2$cimport java.io.IOException;%2$c%2$cpublic class Grace {%2$c%3$cstatic {%2$c%3$c%3$cString s = %4$c%s%4$c;%2$c%3$c%3$cString r = String.format(s, s, 10, 9 ,34);%2$c%3$c%3$ctry (FileWriter writer = new FileWriter(%4$cGrace_kid.java%4$c, false)) {%2$c%3$c%3$c%3$cwriter.write(r);%2$c%3$c%3$c} catch (IOException e) {%2$c%3$c%3$c%3$ce.printStackTrace();%2$c%3$c%3$c}%2$c%3$c%3$cSystem.exit(0);%2$c%3$c}%2$c%2$c%3$cpublic static void main(String[] args) {%2$c%3$c}%2$c}%2$c";
		String r = String.format(s, s, 10, 9 ,34);
		try (FileWriter writer = new FileWriter("Grace_kid.java", false)) {
			writer.write(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main(String[] args) {
	}
}
