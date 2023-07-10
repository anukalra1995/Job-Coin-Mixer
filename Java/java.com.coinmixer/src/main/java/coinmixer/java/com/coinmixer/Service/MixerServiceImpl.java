package coinmixer.java.com.coinmixer.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import coinmixer.java.com.coinmixer.Model.AddressInformation;
import coinmixer.java.com.coinmixer.Model.MixerRecords;
import coinmixer.java.com.coinmixer.Model.Transactions;
import coinmixer.java.com.coinmixer.Repository.MixerRepository;
import coinmixer.java.com.coinmixer.Service.ServiceInterface.MixerService;
import coinmixer.java.com.coinmixer.enums.Status;

@Service
public class MixerServiceImpl implements MixerService {
	
//	@Value("${apiBaseUrl}")
	public String URI = "http://jobcoin.gemini.com/hazard-antacid/api";
	
//	@Value("${fromAddress}")
	public String From_Home_Address="Home Address";
	
	@Autowired
	private MixerRepository mixerRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(MixerServiceImpl.class);
	
	
	/**
     * completes the transactions for the records that are ready to be transferred and updates their status to complete
     * @param mixerRecord the record containing where the transaction comes from, where it's going, and the amount of coins being transferred
     */
	@Override
	public void transfer(MixerRecords mixerRecord) {
		logger.info("Beginning transfer of prepared records");
		double percentChange = 100.00 / mixerRepository.getRecordsInProgress().size();
        double amount = (percentChange * mixerRecord.getBalance()) / mixerRecord.getToAddressList().size();
        
        mixerRecord.getToAddressList().forEach(address -> {
            Transactions transaction = new Transactions(From_Home_Address, address, amount);
            restTemplate.postForObject(URI + "/transactions", transaction, Transactions.class);
            double completion = mixerRecord.getCompletion() + percentChange;
            
            Status status = (completion >= 99.99) ? Status.COMPLETE : Status.TRANSFERRING;
            
            mixerRecord.setCompletion(completion);
            mixerRecord.setStatus(status);
            mixerRepository.updateRecord(mixerRecord.getDepositAddress(), mixerRecord);
            
            logger.info("Record has been successfully transferred, process is {}% complete", completion);
        });
	}

	/**
     * looks for records awaiting to be deposited and progresses them to the beginning of the transfer process
     */
	@Override
	public void checkForDeposits() {
		
		logger.info("Checking for records awaiting deposit");
        List<MixerRecords> mixerRecords = mixerRepository.getRecordsAwaitingDeposit();
        mixerRecords.forEach(record -> {
            AddressInformation addressInfo = restTemplate.getForObject(URI + "/addresses/" + record.getDepositAddress(), AddressInformation.class);
            
            if(addressInfo != null) {
            	logger.info("Preparing records for transfer");
                addressInfo.getTransactions().forEach(transaction -> {
                    if (transaction.getAmount() > 0.00) {
                        Transactions deposit = new Transactions(transaction.getToAddress(), From_Home_Address, transaction.getAmount());
                        restTemplate.postForObject(URI + "/transactions", deposit, Transactions.class);
                        
                        MixerRecords newRecord = mixerRepository.getRecord(record.getDepositAddress());
                        newRecord.setBalance(transaction.getAmount());
                        newRecord.setStatus(Status.TRANSFERRING);
                        
                        mixerRepository.updateRecord(record.getDepositAddress(), newRecord);
                    }
                });
            }
        });

	}

}
