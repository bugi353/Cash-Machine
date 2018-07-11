package cashMachine.dataClasses;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;
	private Timestamp data;
	private BigDecimal transValue;
	
	@ManyToOne
	@JoinColumn(name="konto")  //pózniej przetestowaæ dla innej nazwy ¿eby sprawdziæ czy jest to powi¹zane z nazwa
	private AccountData konto; // tabeli czy te¿ kolumny w tabeli

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public AccountData getKonto() {
		return konto;
	}

	public void setKonto(AccountData konto) {
		this.konto = konto;
	}

	public BigDecimal getTransValue() {
		return transValue;
	}

	public void setTransValue(BigDecimal transValue) {
		this.transValue = transValue;
	}
	
	
}
