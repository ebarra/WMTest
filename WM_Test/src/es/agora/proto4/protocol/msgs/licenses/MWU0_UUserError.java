package es.agora.proto4.protocol.msgs.licenses;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MWU0_UUserError implements Serializable
{
	@Expose private final String version= "0.2";
	@Expose private final String cmd= "UUserError";
	
	@Expose private final int reqId;
	@Expose private final String reason;
	
	public MWU0_UUserError(int reqId, String reason)
	{
		this.reqId= reqId;
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
