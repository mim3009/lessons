package nnnn;
import javax.swing.JTree;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.swing.JProgressBar;


public class JarViewer implements Runnable {
	private String path;
	private JarTree tree;
	private JTree tr;

	public JarTree getTree() {
		return tree;
	}

	public JarViewer(String path, JTree tr) {
		this.path = path;
		this.tr = tr;
		tree = new JarTree(new JarNode("JAR Archive", path, ""));
	}

	@Override
	public void run() {
		JarFile f;
		try {
			f = new JarFile(path);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		ClassLoader loader = new MyClassLoader(path);
		Enumeration<JarEntry> enumeration = f.entries();
		JarEntry e;
		String s, spath;
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement();
		}
		enumeration = f.entries();
		while (enumeration.hasMoreElements()) {
			Class c = null;
			String data = "";
			e = enumeration.nextElement();
			spath = e.getName();
			if (spath.indexOf("$") >= 0)
				continue;
			if (spath.endsWith(".class")) {
				s = spath.replaceAll("/", ".");
				s = s.substring(0, s.length() - 6);
				try {
					c = Class.forName(s, false, loader);
					if (c != null)
						data = getInformation(c);
				} catch (Exception e2) {
				}
				tree.createPath(spath, data);
			} else {
				data = "FILE: " + spath;
				data += "\n\tSize: " + e.getSize() + " bytes";
				Date d = new Date(e.getTime());
				data += "\n\tDate of modification: " + d.toString();
				tree.createPath(spath, data);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
			}
		}
		tr.updateUI();
	}

	private String getModifiers(int m) {
		StringBuilder str = new StringBuilder();
		if (Modifier.isPublic(m))
			str.append("\tPUBLIC\n");
		if (Modifier.isPrivate(m))
			str.append("\tPRIVATE\n");
		if (Modifier.isProtected(m))
			str.append("\tPROTECTED\n");
		if (Modifier.isAbstract(m))
			str.append("\tABSTRACT\n");
		if (Modifier.isFinal(m))
			str.append("\tFINAL\n");
		if (Modifier.isStatic(m))
			str.append("\tSTATIC\n");
		if (Modifier.isInterface(m))
			str.append("\tINTERFACE\n");
		if (Modifier.isNative(m))
			str.append("\tNATIVE\n");
		if (Modifier.isStrict(m))
			str.append("\tSTRICT\n");
		if (Modifier.isSynchronized(m))
			str.append("\tSYNCHRONIZED\n");
		return str.toString();
	}

	private String getInformation(Class c) {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append(" Name: " + c.getName() + "\n");
		str.append("Modifiers: \n" + getModifiers(c.getModifiers()) + "\n");
		try {
			Field[] fields = c.getDeclaredFields();
			str.append("Fields:\n");
			for (Field f : fields) {
				try {
					str.append("\t" + f.toGenericString() + "\n");
				} catch (Exception e) {
				}
			}
			Constructor<?>[] constructors = c.getConstructors();
			str.append("Constructors:\n");
			for (Constructor<?> k : constructors) {
				try {
					str.append("\t" + k.toGenericString() + "\n");
				} catch (Exception e) {
				}
			}
			Method[] methods = c.getDeclaredMethods();
			str.append("Methods:\n");
			for (Method m : methods) {
				try {
					str.append("\t" + m.toGenericString() + "\n");
				} catch (Exception e) {
				}
			}
			Class[] classes = c.getDeclaredClasses();
			for (Class m : classes) {
				try {
					str.append(getInformation(m));
				} catch (Exception e) {
				}
			}
		} catch (Throwable e) {
			str.append("Error!");
		}
		return str.toString();
	}
}