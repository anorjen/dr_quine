import java.io.*;

public class Sully {
	public static void main (String[] args) {
		int i = 5;

		--i;
		String s = "import java.io.*;%2$c%2$cpublic class Sully_%5$d {%2$c%3$cpublic static void main (String[] args) {%2$c%3$c%3$cint i = %5$d;%2$c%2$c%3$c%3$c--i;%2$c%3$c%3$cString s = %4$c%s%4$c;%2$c%3$c%3$cString r = String.format(s, s, 10, 9, 34, i);%2$c%3$c%3$cString name = %4$cSully_%4$c + i;%2$c%3$c%3$ctry (FileWriter writer = new FileWriter(new File(name + %4$c.java%4$c), false)) {%2$c%3$c%3$c%3$cwriter.write(r);%2$c%3$c%3$c%3$cwriter.close();%2$c%3$c%3$c%3$cProcess process = Runtime.getRuntime().exec(new String[]{%4$cjavac%4$c, name + %4$c.java%4$c});%2$c%3$c%3$c%3$cprocess.waitFor();%2$c%3$c%3$c%3$cif (i > 0)%2$c%3$c%3$c%3$c%3$cprocess = Runtime.getRuntime().exec(new String[]{%4$cjava%4$c, name});%2$c%3$c%3$c} catch (Exception e) {%2$c%3$c%3$c%3$ce.printStackTrace();%2$c%3$c%3$c}%2$c%3$c}%2$c}%2$c";
		String r = String.format(s, s, 10, 9, 34, i);
		String name = "Sully_" + i;
		try (FileWriter writer = new FileWriter(new File(name + ".java"), false)) {
			writer.write(r);
			writer.close();
			Process process = Runtime.getRuntime().exec(new String[]{"javac", name + ".java"});
			process.waitFor();
			if (i > 0)
				process = Runtime.getRuntime().exec(new String[]{"java", name});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
