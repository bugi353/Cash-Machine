package cashMachine.logicClasses;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import cashMachine.dataClasses.AccountData;
import cashMachine.dataClasses.Transaction;

public class CashOperation {
	
	private EntityManager em = DBConfig.getEntityManager();
	
	private AccountData account;
	
	public static CashOperation createCashOperationSystem()
	{	
		CashOperation cashOperation = new CashOperation();
		return cashOperation;
	}
	
	public Boolean putInCash(BigDecimal value, String idNumber)
	{
		account = (AccountData)em.createQuery("SELECT account from AccountData account WHERE account.idNumber = :idNumber").setParameter("idNumber", idNumber).getSingleResult();
		Transaction t = new Transaction();
		Timestamp time = new Timestamp(new Date().getTime());
		t.setData(time);
		t.setKonto(account);
		t.setTransValue(value);
				
		EntityTransaction et = em.getTransaction();
			try {
				et.begin();
				account.setAccountAmount(account.getAccountAmount().add(value));
				em.persist(t);
				et.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				et.rollback();
				return false;
			}	
	}
	
	public String getCash(BigDecimal value, String idNumber)
	{
		account = (AccountData)em.createQuery("SELECT account from AccountData account WHERE account.idNumber = :idNumber").setParameter("idNumber", idNumber).getSingleResult();
		Transaction t = new Transaction();
		Timestamp time = new Timestamp(new Date().getTime());
		t.setData(time);
		t.setKonto(account);
		t.setTransValue(value.negate());
		String cond;
		
		if(value.compareTo(account.getAccountAmount())<=0)
		{
			EntityTransaction et = em.getTransaction();
			try {
				et.begin();
				account.setAccountAmount(account.getAccountAmount().subtract(value));
				em.persist(t);
				et.commit();
				
				return cond = "true";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				et.rollback();
				return cond = "false";
			}
			
		}
		
		else
		{
			return cond = "NEM";	
		}
		
	}
	
	public Transaction getTransactions(String idNumber, int id)
	{
		account = (AccountData)em.createQuery("SELECT account from AccountData account WHERE account.idNumber = :idNumber").setParameter("idNumber", idNumber).getSingleResult();
		System.out.println("1");
		List<Transaction> transactions = account.getTransactionArray();
		System.out.println("2");
		Transaction transaction = transactions.get(transactions.size()-id-1);
		return transaction;
	}
}
