package coinmixer.java.com.coinmixer.Dto.ControllerDto;

public class BalanceHistoryDto {
	
	String userId;
	String address;
	
	public BalanceHistoryDto(String userId, String address) {
		super();
		this.userId = userId;
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
