package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbStudentTransformer {

	public final String PACKAGE_NAME = 
                      "org.example";
	private JAXBContext jc = null;
	private Lab3 lab3 = new Lab3();
	
	public JaxbStudentTransformer()throws JAXBException {
		jc = JAXBContext.newInstance(PACKAGE_NAME);
	}

	
	public void unmarshall(String fileName)
                                    throws Exception{
		Unmarshaller u = jc.createUnmarshaller();
		lab3.getGroup().clear();
		lab3 = (Lab3)u.unmarshal(
                         new FileInputStream(fileName));
	}
	
	public void marshall(String fileName) 
                                    throws Exception{
		Marshaller m = jc.createMarshaller();
		m.marshal(lab3, 
                   new FileOutputStream(fileName));	
	}
	
   
   public Lab3 getLab3(){
	   return lab3;
   }
   
   public static void main(String[] args){
	   Student s = new Student();
	   s.setAge(22);
	   s.setName("Vasia");
	   
	   Group gr = new Group();
	   gr.setId(3);
	   gr.setName("asd");
	   gr.getStudent().add(s);
	   
	   JaxbStudentTransformer j;
	try {
		j = new JaxbStudentTransformer();
		  j.getLab3().getGroup().add(gr);
		   try {
			j.marshall("aaa.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	   
   }
   
}