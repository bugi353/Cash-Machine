package cashMachine.Controller;

import java.math.BigDecimal;

import cashMachine.dataClasses.Transaction;
import cashMachine.logicClasses.CashOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class LastTransactionScreenController {
	
	private CashMachineController CMcontroller;
	
	CashOperation cashOperation = CashOperation.createCashOperationSystem();
	
	@FXML
    private Pane lastTransactionPane;

    @FXML
    private Label t1Label;

    @FXML
    private Label t2Label;

    @FXML
    private Label t3Label;

    @FXML
    private Label t4Label;

    @FXML
    private Label t5Label;
	
	@FXML
	void initialize()
	{
		lastTransactionPane.setStyle("-fx-background-color: RGB(57, 135, 201)");
		
	}

	public void setConfiguration()
	{
		CMcontroller.b1L.setOnAction(e->{});
		CMcontroller.b2L.setOnAction(e->{});
		CMcontroller.b3L.setOnAction(e->{});
		CMcontroller.b4L.setOnAction(e->{});
		CMcontroller.b1P.setOnAction(e->{});
		CMcontroller.b2P.setOnAction(e->{});
		CMcontroller.b3P.setOnAction(e->{});
		CMcontroller.b4P.setOnAction(e->{CMcontroller.loadActionScreen();});
		CMcontroller.buttonCancel.setOnAction(e->{});
		CMcontroller.buttonCorrect.setOnAction(e->{});
		CMcontroller.buttonAccept.setOnAction(e->{});
		t1Label.setText(getTransaction(CMcontroller.getIdNumber(),0));
		t2Label.setText(getTransaction(CMcontroller.getIdNumber(),1));
		t3Label.setText(getTransaction(CMcontroller.getIdNumber(),2));
		t4Label.setText(getTransaction(CMcontroller.getIdNumber(),3));
		t5Label.setText(getTransaction(CMcontroller.getIdNumber(),4)); //wykona� zabezpieczenie je�i mniej transakcji
	}
	
	public void setController(CashMachineController CMcontroller)
	{
		this.CMcontroller = CMcontroller;
	}
	
	public String getTransaction(String idNumber, int id)
	{
		Transaction transaction = cashOperation.getTransactions(idNumber, id);
		String trans = "Data: " + transaction.getData() + " Kwota transakcji:" + transaction.getTransValue();
		return trans;
	}
}
