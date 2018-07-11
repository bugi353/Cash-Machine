package cashMachine.logicClasses;

import javax.persistence.EntityManager;

import cashMachine.Controller.LoginScreenController;
import cashMachine.dataClasses.AccountData;

public class Login {
	private LoginScreenController loginController;
	
	private EntityManager em;
	
		public Login()
		{
			this.em = DBConfig.getEntityManager();
		}
	//rozbudowaæ logowanie w taki sposób ¿eby logowaæ siê za pomoc¹ pinu oraz identyfikatora, który bêdzie unikalny
	// i po³¹czyæ kod z baz¹ danych za pomoc¹ encji, dodaæ biblioteki odpowiednie od menad¿era encji, i dowiedzieæ siê jak 
	// ma siê ³¹czyæ z baz¹ danych
	public String findIdNumber(String idNumber)
	{
		AccountData account;
		try {
			account = (AccountData)em.createQuery("SELECT account from AccountData account WHERE account.idNumber = :idNumber").setParameter("idNumber", idNumber).getSingleResult();
			return account.getPin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "badId";
		}
		
	}
		
	public String login(String id, String pin)
	{
		String cond;
		
		if(pin.equals(this.findIdNumber(id)))
		{
			cond = "OK";
			return cond;
		}
		
		if(this.findIdNumber(id).equals("badId"))
		{
			cond = "badId";
			return cond;
		}
		
		else
		{
			cond = "badPIN";
			return cond;
		}
	}
	
	public static Login createLoginSystem()
	{	
		Login login = new Login();
		return login;
	}
}
