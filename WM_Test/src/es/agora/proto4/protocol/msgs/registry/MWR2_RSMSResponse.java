package es.agora.proto4.protocol.msgs.registry;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MWR2_RSMSResponse implements Serializable
{
	@Expose private final String version= "0.2";
	@Expose private final String cmd= "RSmsResponse";
	
	@Expose private final int reqId;
	@Expose private final int activationCode;
	@Expose private final int verificationCode;

	public MWR2_RSMSResponse(int reqId, int activationCode, int verificationCode)
	{
		this.reqId= reqId;
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

	public int getActivationCode()
	{
		return activationCode;
	}

	public int getVerificationCode()
	{
		return verificationCode;
	}
}
