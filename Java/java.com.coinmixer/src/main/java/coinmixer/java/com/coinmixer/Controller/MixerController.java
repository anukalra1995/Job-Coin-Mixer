package coinmixer.java.com.coinmixer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import coinmixer.java.com.coinmixer.Model.MixerRecords;
import coinmixer.java.com.coinmixer.Service.ServiceInterface.MixerService;

@RestController
public class MixerController {
	
	
	@Autowired
	public MixerService mixService;
	
	@GetMapping("mixer/deposits")
	public void checkForDeposits() {
		
	}
	
	@PostMapping("")
	public void transfer(MixerRecords mixerRecord) {
		
	}
}
