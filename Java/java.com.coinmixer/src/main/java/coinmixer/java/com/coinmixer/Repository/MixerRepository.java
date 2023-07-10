package coinmixer.java.com.coinmixer.Repository;

import java.util.*;
import coinmixer.java.com.coinmixer.enums.*;
import coinmixer.java.com.coinmixer.Model.MixerRecords;

public class MixerRepository {
	
	private Map<String,MixerRecords> storeData = new HashMap<>();
	
	/**
	 * Add Records to Map
	 * @param depostiAddress
	 * @param record
	 */
	public void addRecords(String depositAddress,MixerRecords record) {
		storeData.put(depositAddress, record);
	}
	
	/**
	 * Get DepositAddress with MixedRecords
	 * @param depositAddress
	 * @return
	 */
	public MixerRecords getRecord(String depositAddress) {
		return storeData.get(depositAddress);
	}
	
	/**
	 * Remove Records from Map with DepositAddress
	 * @param depositAddress
	 */
	public void remove(String depositAddress) {
		storeData.remove(depositAddress);
	}
	
	/**
	 * Update Records with DepositAddress and MixRecords
	 * @param depositAddress
	 * @param mixRecord
	 */
	public void updateRecord(String depositAddress,MixerRecords mixRecord) {
		storeData.replace(depositAddress, mixRecord);
	}
	
	/**
	 * List of Records which are in Progress
	 * @return
	 */
	public List<MixerRecords> getRecordsInProgress() {
        List<MixerRecords> records = new ArrayList<>();
        storeData.forEach((s, mixerRecord) -> {
            if (mixerRecord.getStatus().equals(Status.TRANSFERRING)) {
                records.add(mixerRecord);
            }
        });
        return records;
    }

	/**
	 * Get Records which are Waiting for Deposits
	 * @return
	 */
    public List<MixerRecords> getRecordsAwaitingDeposit() {
        List<MixerRecords> records = new ArrayList<>();
        storeData.forEach((s, mixerRecord) -> {
            if (mixerRecord.getStatus().equals(Status.AWAITING_DEPOSIT)) {
                records.add(mixerRecord);
            }
        });
        return records;
    }
}
