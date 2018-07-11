package cashMachine.logicClasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConfig {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CashMachine");
	
	private static EntityManager em = emf.createEntityManager();
	
	public static EntityManager getEntityManager()
	{
		return em;
	}
}
