package coinmixer.java.com.coinmixer.Controller;

import java.util.*;
//import java.util.logging.Logger;

import javax.ws.rs.QueryParam;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import coinmixer.java.com.coinmixer.Dto.MixerResponse;
import coinmixer.java.com.coinmixer.Service.ServiceInterface.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addService;
	
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	@GetMapping("/addresses/{address}")
	public MixerResponse getDeposits(@QueryParam("addresses") List<String> address) {

		logger.info("Checking whether All User Address are ");
		Set<String> invalidAddress = addService.getValidAddresses(address);
		if(invalidAddress.equals(Collections.EMPTY_SET)) {
			logger.info("All user addresses are valid");
			return new MixerResponse("OK",Optional.of(addService.createDepositAddress(address)), Optional.empty());
        } else {
        	logger.error("Invalid user addresses have been found");
            return new MixerResponse("ERROR", Optional.empty(), Optional.of(invalidAddress));
        
        }
	}
	
}
