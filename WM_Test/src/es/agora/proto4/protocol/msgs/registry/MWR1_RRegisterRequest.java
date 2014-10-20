package es.agora.proto4.protocol.msgs.registry;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWR1_RRegisterRequest extends MW_Message
{
	private static final String VERSION = "0.2";
	private static final String CMD = "RRegisterRequest";
	
	@Expose private final String rsaPublic;
	@Expose private final String phoneNumber;
	@Expose private final String simNumber;
	
	public MWR1_RRegisterRequest(int reqId,
							String rsaPublic,
							String phoneNumber,
							String simNumber)
	{
		super(MW_ID.MWR1_RRegisterRequest,VERSION,CMD,reqId);
		this.rsaPublic= rsaPublic;
		this.phoneNumber = phoneNumber;
		this.simNumber = simNumber;
	}

	public String getRsaPublic()
	{
		return rsaPublic;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public String getSimNumber()
	{
		return simNumber;
	}
	
}
