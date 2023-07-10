package coinmixer.java.com.coinmixer.Dto;

import java.util.Optional;
import java.util.Set;

public class MixerResponse {
	
	private String status;
    private Optional<String> depositAddress;
    private Optional<Set<String>> invalidAddress;
    
    
	public MixerResponse(String status, Optional<String> depositAddress, Optional<Set<String>> invalidAddress) {
		super();
		this.status = status;
		this.depositAddress = depositAddress;
		this.invalidAddress = invalidAddress;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Optional<String> getDepositAddress() {
		return depositAddress;
	}
	public void setDepositAddress(Optional<String> depositAddress) {
		this.depositAddress = depositAddress;
	}
	public Optional<Set<String>> getInvalidAddress() {
		return invalidAddress;
	}
	public void setInvalidAddress(Optional<Set<String>> invalidAddress) {
		this.invalidAddress = invalidAddress;
	}
    
    
}
