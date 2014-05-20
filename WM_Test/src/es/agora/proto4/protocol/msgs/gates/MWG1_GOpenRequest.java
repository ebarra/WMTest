package es.agora.proto4.protocol.msgs.gates;

import java.io.Serializable;
import java.util.List;

import es.agora.proto4.model.Gate;

public class MWG1_GOpenRequest implements Serializable {
	
	private final String version= "0.2";
	private final String cmd= "GOpenRequest";
	
	private final int reqId;
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
		this.reqId = reqId;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.simNumber=simNumber;
		this.activationCode = activationCode;
		this.verificationCode = verificationCode;
		this.licenseId = licenseId;
		this.gateId = gateId;
	}


	public String getVersion() {
		return version;
	}


	public String getCmd() {
		return cmd;
	}


	public int getReqId() {
		return reqId;
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
