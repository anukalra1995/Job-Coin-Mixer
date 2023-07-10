package coinmixer.java.com.coinmixer.Service.ServiceInterface;

import java.util.*;

import coinmixer.java.com.coinmixer.Model.AddressInformation;

public interface AddressService {
	
	public String createDepositAddress(List<String> toAddresses);
	
	public Set<String> getValidAddresses(List<String> addresses);
	
	public AddressInformation getAddressData(String address);
}
