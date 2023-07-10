package coinmixer.java.com.coinmixer.Model;

public class Transactions {
	
	private String timeStamp;
	
	private String toAddress;
	
	private String fromAddress;
	
	private double amount;

	
	public Transactions(String timeStamp, String toAddress, double amount) {
		super();
		this.timeStamp = timeStamp;
		this.toAddress = toAddress;
		this.amount = amount;
	}


	public Transactions(String timeStamp, String toAddress, String fromAddress, double amount) {
		super();
		this.timeStamp = timeStamp;
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.amount = amount;
	}


	public String getTimeStamp() {
		return timeStamp;
	}

	public String getToAddress() {
		return toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public double getAmount() {
		return amount;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Transactions [timeStamp=" + timeStamp + ", toAddress=" + toAddress + ", fromAddress=" + fromAddress
				+ ", amount=" + amount + "]";
	}

	
	
}
