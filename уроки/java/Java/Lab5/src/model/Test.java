package model;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;



public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab5");
		//saveEntities(emf);
		readEntities(emf);

	}

	private static void readEntities(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			
			Query q = em.createQuery("SELECT x FROM Klient x");
			List<?> list = q.getResultList();
			if(CollectionUtils.isNotEmpty(list)){
				for(Object object : list){
					Klient k = (Klient) object;
					System.out.println("Klient: "+k.getFio());
					
					
				}
			}
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}

		
	}

	private static void saveEntities(EntityManagerFactory emf) {
		EntityManager em =  emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			
//			Zakaz z = new Zakaz();
//			z.setId(1);
//			z.setCost(1111);
//			z.setNamezakazchik("Максим");
//			z.setNumzak(1);
//			
//			Parichmaher p = new Parichmaher();
//			p.setId(1);
//			p.setFio("Аносов");
//			p.setPay(102);
//			p.setStaj(5);
			
			
			Klient k = new Klient();
			k.setFio("Александра");
			k.setId(4);
			k.setPol("ж");
			
//			p.getZakazs().add(z);
//			z.setKlient(k);
//			z.setParichmaher(p);
//			k.getZakazs().add(z);
			
			em.persist(k);
//			em.persist(p);
//			em.persist(z);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		
	}

}
