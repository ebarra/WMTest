package es.agora.proto4.protocol.msgs.registry;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MWR0_RUserError implements Serializable
{
	@Expose private final String version= "0.2";
	@Expose private final String cmd= "RUserError";
	
	@Expose private final int reqId;
	@Expose private final int errCode;
	@Expose private final String reason;
	
	public MWR0_RUserError(int reqId, int errCode, String reason)
	{
		this.reqId= reqId;
		this.errCode= errCode;
		this.reason = reason;
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

	public String getReason()
	{
		return reason;
	}	
}
