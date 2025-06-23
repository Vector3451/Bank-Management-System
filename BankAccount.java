package Bank;

public class BankAccount {
	String bname;
	String accno;
	String isfc;
	String accholder;
	double balance;
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getIsfc() {
		return isfc;
	}
	public void setIsfc(String isfc) {
		this.isfc = isfc;
	}
	public String getAccholder() {
		return accholder;
	}
	public void setAccholder(String accholder) {
		this.accholder = accholder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(String bname, String accno, String isfc, String accholder, double balance) {
		super();
		this.bname = bname;
		this.accno = accno;
		this.isfc = isfc;
		this.accholder = accholder;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "-----BankAccount-----\nBank Name : " + bname + "\nAccount Number : " + accno + "\nISFC Code : " + isfc + "\nAccount Holder : " + accholder
				+ "\nBalance : " + balance;
	}
}