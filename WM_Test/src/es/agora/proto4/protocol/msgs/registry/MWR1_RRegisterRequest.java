package es.agora.proto4.protocol.msgs.registry;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MWR1_RRegisterRequest implements Serializable
{
	@Expose private final String version= "0.2";
	@Expose private final String cmd= "RRegisterRequest";
	
	@Expose private final int reqId;
	@Expose private final String rsaPublic;
	@Expose private final String phoneNumber;
	@Expose private final String simNumber;
	
	public MWR1_RRegisterRequest(int reqId,
							String rsaPublic,
							String phoneNumber,
							String simNumber)
	{
		this.reqId= reqId;
		this.rsaPublic= rsaPublic;
		this.phoneNumber = phoneNumber;
		this.simNumber = simNumber;
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
