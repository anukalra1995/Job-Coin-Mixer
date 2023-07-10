package coinmixer.java.com.coinmixer.Dto.ControllerDto;

import java.math.BigDecimal;
import java.util.List;

public class UserDto {
	
	String userId;
	String srcAddress;
	List<String> dstAddressList;
	BigDecimal amount;
	
	public UserDto(String userId, String srcAddress, List<String> dstAddressList, BigDecimal amount) {
		super();
		this.userId = userId;
		this.srcAddress = srcAddress;
		this.dstAddressList = dstAddressList;
		this.amount = amount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSrcAddress() {
		return srcAddress;
	}

	public void setSrcAddress(String srcAddress) {
		this.srcAddress = srcAddress;
	}

	public List<String> getDstAddressList() {
		return dstAddressList;
	}

	public void setDstAddressList(List<String> dstAddressList) {
		this.dstAddressList = dstAddressList;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
