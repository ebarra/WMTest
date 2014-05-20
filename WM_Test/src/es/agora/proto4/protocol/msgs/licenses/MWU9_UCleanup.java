package es.agora.proto4.protocol.msgs.licenses;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MWU9_UCleanup implements Serializable
{
	@Expose private final String version= "0.2";
	@Expose private final String cmd= "RCleanup";
	
	@Expose private final int reqId;

	public MWU9_UCleanup(int reqId)
	{
		this.reqId= reqId;
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
}
