package coinmixer.java.com.coinmixer.Model;

import java.util.List;

public class AddressInformation {
	
	private Long accountBalance;
	
	private List<Transactions> transactions;

	public AddressInformation(Long accountBalance, List<Transactions> transactions) {
		super();
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AddressInformation [accountBalance=" + accountBalance + ", transactions=" + transactions + "]";
	}
	
	
}
