package coinmixer.java.com.coinmixer.Service.ServiceInterface;

import coinmixer.java.com.coinmixer.Model.MixerRecords;

public interface MixerService {

	public void transfer(MixerRecords mixerRecord);
	
	public void checkForDeposits();
}
