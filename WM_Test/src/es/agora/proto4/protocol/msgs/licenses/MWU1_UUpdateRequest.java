package es.agora.proto4.protocol.msgs.licenses;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MWU1_UUpdateRequest implements Serializable
{
	@Expose private final String version= "0.2";
	@Expose private final String cmd= "UUpdateRequest";
	
	@Expose private final int reqId;
	@Expose private final long date;
	@Expose private final String phoneNumber;
	@Expose private final String simNumber;
	@Expose private final int activationCode;
	@Expose private final int verificationCode;
	
	public MWU1_UUpdateRequest(int reqId,
			                   long date,
			                   String phoneNumber,
			                   String simNumber,
			                   int activationCode,
			                   int verificationCode
			                  )
	{
		this.reqId = reqId;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.simNumber = simNumber;
		this.activationCode = activationCode;
		this.verificationCode = verificationCode;
	}
	
	public String getVersion()
	{
		return version;
	}
	public String getCmd()
	{
		return cmd;
	}
	public int getReqId()
	{
		return reqId;
	}
	public long getDate()
	{
		return date;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getSimNumber()
	{
		return simNumber;
	}
	public int getActivationCode()
	{
		return activationCode;
	}
	public int getVerificationCode()
	{
		return verificationCode;
	}
}
