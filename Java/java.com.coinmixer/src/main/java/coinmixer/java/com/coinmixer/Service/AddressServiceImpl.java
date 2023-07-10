package coinmixer.java.com.coinmixer.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import coinmixer.java.com.coinmixer.Model.*;
import coinmixer.java.com.coinmixer.Repository.MixerRepository;
import coinmixer.java.com.coinmixer.Service.ServiceInterface.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

//	@Value("${apiBaseUrl}/${address}")
	public static String url = "http://jobcoin.gemini.com/hazard-antacid/api/address";
	
//	@Value("${fromAddress}")
	private static String Home_Address = "Home Address";
	
	@Autowired
	private MixerRepository mixerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	

	public AddressServiceImpl(MixerRepository mixerRepo, RestTemplate restTemplate) {
		super();
		this.mixerRepo = mixerRepo;
		this.restTemplate = restTemplate;
	}

	@Override
	public String createDepositAddress(List<String> toAddresses) {
		String depositAddress = UUID.randomUUID().toString();
		Set<String> toAddress = toAddresses.stream().collect(Collectors.toSet());
		
		MixerRecords mixRecord = new MixerRecords(depositAddress, toAddress);
		mixerRepo.addRecords(depositAddress, mixRecord);
		
		return depositAddress;
	}

	@Override
	public Set<String> getValidAddresses(List<String> addresses) {
		
		Set<String> uniqueAdd = new HashSet<>();
		addresses.forEach(address ->  {
            AddressInformation addressInfo = restTemplate.getForObject(url+"/" + address, AddressInformation.class);
            if(addressInfo != null) {
                uniqueAdd.addAll(addressInfo.getTransactions()
                        .stream()
                        .map(Transactions::getToAddress)
                        .collect(Collectors.toList()));
            }
        });
		return uniqueAdd;
	}

	@Override
	public AddressInformation getAddressData(String address) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
