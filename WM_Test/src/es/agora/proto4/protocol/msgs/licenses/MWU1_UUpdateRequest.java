package es.agora.proto4.protocol.msgs.licenses;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWU1_UUpdateRequest extends MW_Message
{
	private static final String VERSION = "0.2";
	private static final String CMD = "UUpdateRequest";
	
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
		super(MW_ID.MWU1_UUpdateRequest,VERSION,CMD,reqId);
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.simNumber = simNumber;
		this.activationCode = activationCode;
		this.verificationCode = verificationCode;
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
