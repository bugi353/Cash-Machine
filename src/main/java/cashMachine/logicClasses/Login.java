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
	//rozbudowa� logowanie w taki spos�b �eby logowa� si� za pomoc� pinu oraz identyfikatora, kt�ry b�dzie unikalny
	// i po��czy� kod z baz� danych za pomoc� encji, doda� biblioteki odpowiednie od menad�era encji, i dowiedzie� si� jak 
	// ma si� ��czy� z baz� danych
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
