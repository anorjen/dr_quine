import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Sully {
	public static void main (String[] args) {
		int i = 5;

		String s = "import java.io.*;%2$c%2$cpublic class Sully_%5$d {%2$c%3$cpublic static void main (String[] args) {%2$c%3$c%3$cint i = %5$d;%2$c%2$c%3$c%3$cString s = %4$c%s%4$c;%2$c%3$c%3$cString r = String.format(s, s, 10, 9, 34, i - 1);%2$c%3$c%3$cString name = %4$cSully_%4$c + (i - 1);%2$c%3$c%3$ctry (FileWriter writer = new FileWriter(name + %4$c.java%4$c, false)) {%2$c%3$c%3$c%3$cwriter.write(r);%2$c%3$c%3$c%3$cProcess process = Runtime.getRuntime().exec(new String[]{%4$cjavac%4$c, name + %4$c.java%4$c});%2$c%3$c%3$c%3$cif (i > 0) {%2$c%3$c%3$c%3$c%3$cprocess = Runtime.getRuntime().exec(new String[]{%4$cjava%4$c, name});%2$c%3$c%3$c%3$c}%2$c%3$c%3$c} catch (Exception e) {%2$c%3$c%3$c%3$ce.printStackTrace();%2$c%3$c%3$c}%2$c%3$c}%2$c}%2$c";
		String r = String.format(s, s, 10, 9, 34, i - 1);
		String name = "Sully_" + (i - 1);
		try (FileWriter writer = new FileWriter(new File(name + ".java"), false)) {
			writer.write(r);
			writer.flush();
			writer.close();
			Process process = Runtime.getRuntime().exec(new String[]{"javac", name + ".java"});
//			Thread.sleep(10000);
			process.waitFor();
			if (i > 0) {
//				String dir = System.getProperty("user.dir");
				byte[] compiledCode = Files.readAllBytes(Paths.get(name + ".class"));
				ClassLoader loader = new ClassLoader() {
					@Override
					protected Class<?> findClass(String name) throws ClassNotFoundException {
						return defineClass(name, compiledCode,0, compiledCode.length);
					}
				};
				Class<?> clazz= Class.forName(name, true, loader);
//				System.out.println(dir);

//				ProcessBuilder builder = new ProcessBuilder("java", "-cp", ".", name);
//				builder.directory(new File(dir));
//				process = builder.start();

//				Thread.sleep(10000);
				process = Runtime.getRuntime().exec(new String[]{"java", name});
				System.out.println(process.waitFor());
				new BufferedReader(new InputStreamReader(process.getErrorStream())).lines().forEach(System.out::println);


				//Загружаем класс с именем className
//				Class<?> targetClass = Class.forName(name);
//
//				//Находим метод с именем "main" и списком параметров String[]
//				Class[] argTypes = new Class[]{String[].class};
//				Method mainMethod = targetClass.getDeclaredMethod("main", argTypes);
//
//				//В качестве параметра передаем пустой массив
//				Object[] arguments = new Object[]{new String[0]};
//				mainMethod.invoke(null, arguments);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
