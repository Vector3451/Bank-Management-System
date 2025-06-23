package Bank;
import java.time.LocalDateTime;
public class Transaction {
	String tid;
	String accno;
	double amount;
	String type;
	LocalDateTime timestamp;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = LocalDateTime.now();
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String accountNumber, double amount, String type) {
	    this.accno = accountNumber;
	    this.amount = amount;
	    this.type = type;
	    this.timestamp = LocalDateTime.now();
	}
	@Override
	public String toString() {
		return "-----Transaction-----\nTransaction ID : " + tid + "\nAccount Number : " + accno + "\nAmount : " + amount + "\nType : " + type;
	}
}
