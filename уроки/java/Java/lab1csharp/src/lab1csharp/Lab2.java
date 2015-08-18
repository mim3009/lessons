package lab1csharp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.lang.ClassLoader;
public class Lab2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ClassLoader loader = new MyClassLoader(args[0]);
		JarFile f = new  JarFile(args[0]);
		Enumeration<JarEntry> enumiration = f.entries(); 
		String s;
		Class c;
		JarEntry e;
		while(enumiration.hasMoreElements()){
			e = enumiration.nextElement();						
			if (e.getName().contains(".class")) {
				System.out.print(e.getName()+":");				
				s = e.getName().replaceAll("/", ".");
				s = s.substring(0, s.length()-6);
				try{
					c = Class.forName(s, false, loader);				
					if (c!=null){
						System.out.println(":"+ClassDetail.getInfo(c));					
					}
				}catch(Exception e2){
					System.out.println("Error:"+e2.getMessage());
				}
			}else{
				//System.out.println(e.getName());
			}
		}
		f.close();
	}
}
