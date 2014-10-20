package es.agora.proto4.protocol.msgs.gates;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWG1_GOpenRequest extends MW_Message 
{
	
	private static final String VERSION= "0.2";
	private static final String CMD= "GOpenRequest";
	
	private final long date; //miliseconds from 01/01/1970
	private final String phoneNumber;
	private final String simNumber;
	private final int activationCode;
	private final int verificationCode;
	private final int licenseId;
	private final int gateId;
	
	
	public MWG1_GOpenRequest(int reqId, long date, String phoneNumber, String simNumber,
			int activationCode, int verificationCode, int licenseId, int gateId)
	{
		super(MW_ID.MWG1_GOpenRequest,VERSION,CMD,reqId);
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.simNumber=simNumber;
		this.activationCode = activationCode;
		this.verificationCode = verificationCode;
		this.licenseId = licenseId;
		this.gateId = gateId;
	}


	public long getDate() {
		return date;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public String getSimNumber() {
		return simNumber;
	}
	
	
	public int getActivationCode() {
		return activationCode;
	}


	public int getVerificationCode() {
		return verificationCode;
	}


	public int getLicenseId() {
		return licenseId;
	}


	public int getGateId() {
		return gateId;
	}
	
	
}
