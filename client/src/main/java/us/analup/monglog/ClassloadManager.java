package us.analup.monglog;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;

public class ClassloadManager {
	private URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
//	private Class sysclass = URLClassLoader.class;
	private Class<URLClassLoader> sysclass = URLClassLoader.class;
	private static final Class[] parameters = new Class[] { URL.class };
	private final String extDir = "lib";

	protected ClassloadManager(boolean verbose) {
		File workingDirectory = new File(extDir);

		if (workingDirectory.isDirectory()) {
			File[] fileArray = workingDirectory.listFiles();
			for (int i = 0; i < fileArray.length; i++) {
				File item = (File) fileArray[i];
				if (item.isFile() && item.getAbsolutePath().toUpperCase().endsWith(".JAR")
						|| item.getAbsolutePath().toUpperCase().endsWith(".ZIP")) {
					if (verbose)
						System.out.println("ADDING LIBRARY [" + item.getAbsoluteFile() + "]");
					try {
						Method method = sysclass.getDeclaredMethod("addURL", parameters);
						method.setAccessible(true);
						method.invoke(sysloader, new Object[] { item.toURL() });
					} catch (Throwable t) {
						System.err.println(
								"Error, could not add Jar File [" + item.getAbsoluteFile() + "] to the ClassLoader");
						t.printStackTrace();
					}
				}
			}
		}
	}

}