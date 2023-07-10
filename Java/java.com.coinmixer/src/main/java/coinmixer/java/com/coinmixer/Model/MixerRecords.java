package coinmixer.java.com.coinmixer.Model;

import java.util.Set;
import coinmixer.java.com.coinmixer.enums.Status;

public class MixerRecords {
	
	private String depositAddress; //this should be unique
	
    private Set<String> toAddressList;
    
    private Double balance;
    
    private Status status;
    
    private Double completion;

    public MixerRecords(String depositAddress, Set<String> toAddressList) {
        this.depositAddress = depositAddress;
        this.toAddressList = toAddressList;
        this.balance = 0.00;
        this.status = Status.AWAITING_DEPOSIT;
        this.completion = 0.00;

    }

	public String getDepositAddress() {
		return depositAddress;
	}

	public void setDepositAddress(String depositAddress) {
		this.depositAddress = depositAddress;
	}

	public Set<String> getToAddressList() {
		return toAddressList;
	}

	public void setToAddressList(Set<String> toAddressList) {
		this.toAddressList = toAddressList;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getCompletion() {
		return completion;
	}

	public void setCompletion(Double completion) {
		this.completion = completion;
	}
    
    
}
/*
 * Ignore Right Now
 * 
public class MixerRecords {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long transactionId;
	
	private String mixerAddress;
	private String userAddress;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date lastTransactionTime;
	
	public MixerRecords(Long transactionId, String mixerAddress, String userAddress, Date lastTransactionTime) {
		super();
		this.transactionId = transactionId;
		this.mixerAddress = mixerAddress;
		this.userAddress = userAddress;
		this.lastTransactionTime = lastTransactionTime;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getMixerAddress() {
		return mixerAddress;
	}

	public void setMixerAddress(String mixerAddress) {
		this.mixerAddress = mixerAddress;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getLastTransactionTime() {
		return lastTransactionTime;
	}

	public void setLastTransactionTime(Date lastTransactionTime) {
		this.lastTransactionTime = lastTransactionTime;
	}
	
	
}
*/