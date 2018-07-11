package cashMachine.dataClasses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name="konto")
public class AccountData {
	
	@Id
	@GeneratedValue
	private int accountId;
	
	private String ownerName;

	private String ownerSecondName;
	
	private String idNumber;
	
	private String pin;

	private BigDecimal accountAmount;
	
	
	
	@OneToMany(mappedBy="konto", fetch = FetchType.EAGER)
	private List<Transaction> transactionArray = new ArrayList<Transaction>();
	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerSecondName() {
		return ownerSecondName;
	}

	public void setOwnerSecondName(String ownerSecondName) {
		this.ownerSecondName = ownerSecondName;
	}
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public BigDecimal getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}


	public List<Transaction> getTransactionArray() {
		return transactionArray;
	}

	public void setTransactionArray(List<Transaction> transactionArray) {
		this.transactionArray = transactionArray;
	}
	
}
