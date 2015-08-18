	package org.exampleforlab3;
	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

	import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.example.Lab3;

	public class JaxbBookTransformer {

		public final String PACKAGE_NAME = 
	                      "org.exampleforlab3";
		private JAXBContext jc = null;
		private static Laba3 lab3 = new Laba3();
		private static Laba3 l3 = new Laba3();
		private static List<Polka> polka;
		
		public JaxbBookTransformer()throws JAXBException {
			jc = JAXBContext.newInstance(PACKAGE_NAME);
		}

		
		public void unmarshall(String fileName)
	                                    throws Exception{
			Unmarshaller u = jc.createUnmarshaller();
			l3.getPolka().clear();
			l3 = (Laba3)u.unmarshal(
	                         new FileInputStream(fileName));
		}
		
		public void marshall(String fileName) 
	                                    throws Exception{
			Marshaller m = jc.createMarshaller();
			m.marshal(lab3, 
	                   new FileOutputStream(fileName));	
		}
		
	   
	   public Laba3 getLab3(){
		   return lab3;
	   }
	   
	   public static void main(String[] args) throws Exception{
		   Book b = new Book();
		   b.setName("The King");
		   b.setKolstr(451);
		   
		   Book b1 = new Book();
		   b1.setName("The King IIppp");
		   b1.setKolstr(401);
		   
		   Polka p = new Polka();
		   p.setNomer(3);
		   p.setRiad(15);
		   
		   p.getBook().add(b);
		   p.getBook().add(b1);
		   
		   JaxbBookTransformer j = new JaxbBookTransformer();
		   j.getLab3().getPolka().add(p);
		   j.marshall("p.xml");   
	   }
}
