package lab1csharp;

import java.lang.reflect.Field;

public class ClassDetail {

	private ClassDetail() {
	}
	
	public static String getInfo(Class clazz){
		StringBuffer buf = new StringBuffer();
		if (clazz.isAnnotation())
			buf.append("Annotation ");
		else if(clazz.isInterface())
			buf.append("Interface ");
		else if(clazz.isEnum())
			buf.append("Enum ");
		else 
			buf.append("Class ");
		buf.append(clazz.getName()+" ");
		if (clazz.isArray())
			buf.append("array");
		if (clazz.isLocalClass())
			buf.append("local");
		buf.append("\n");
		buf.append(getFieldNames(clazz));  
		return buf.toString();
	}
	
	public static String getFieldNames(Class clazz) {
		StringBuffer buf = new StringBuffer();
		try{
			Field[] publicFields = clazz.getDeclaredFields();
			for (int i = 0; i < publicFields.length; i++) {
				try{
					String fieldName = publicFields[i].getName();
					buf.append("Name: " + fieldName);
					Class typeClass = publicFields[i].getType();
					String fieldType = typeClass.getName();
					buf.append(", Type: " + fieldType+"\n");
				}catch(Exception e){
					buf.append("\n");
				}
			}
		}catch(Throwable e){
			
		}
	    return buf.toString();
	}

}
