package coinmixer.java.com.coinmixer;

import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import coinmixer.java.com.coinmixer.Model.*;
import coinmixer.java.com.coinmixer.Repository.MixerRepository;
import coinmixer.java.com.coinmixer.Service.AddressServiceImpl;
import coinmixer.java.com.coinmixer.Service.ServiceInterface.AddressService;

@RunWith(MockitoJUnitRunner.class)
class CoinMixerApplicationTests {

	@Mock
	private MixerRepository mixRepo;
	
	@Mock
	private RestTemplate restTemplate;
	
	private AddressService addService;
	
	private AddressInformation addInfo;
	
	private List<Transactions> transactions;
	
	@BeforeEach
	private void setUp() {
	
		MockitoAnnotations.openMocks(this);

		addService = new AddressServiceImpl(mixRepo,restTemplate);
		Transactions transaction1 = new Transactions("NOW", "Bob's Account", "Stan's Account", Double.valueOf(100));
        transactions = new ArrayList<>();
        transactions.add(transaction1);
        addInfo = new AddressInformation(0L, transactions);
		
	}
	
	@Test
    public void testCreateDepositAddress() {
        UUID address = UUID.fromString("da5a204a-9224-4831-bc17-0341690d4049");

        MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class);
        mockedUuid.when(UUID::randomUUID).thenReturn(address);
        
        List<String> as = new ArrayList<>();
        as.add("String");
        String result = addService.createDepositAddress(as);
        Assert.assertEquals("da5a204a-9224-4831-bc17-0341690d4049", result);
    }

    @Test
    public void testGetInvalidAddresses_invalidAddressesFound() throws Exception {
        Transactions transaction2 = new Transactions("NOW", "address1", "Stan's Account", Double.valueOf(100));
        transactions.add(transaction2);
        addInfo.setTransactions(transactions);

        when(restTemplate.getForObject("http://jobcoin.gemini.com/violate-shucking/api/addresses/address1", AddressInformation.class)).thenReturn(addInfo);
        Set<String> result = addService.getValidAddresses(List.of("address1"));

        Assert.assertEquals(new HashSet<>(Collections.emptySet()), result);
    }

}
