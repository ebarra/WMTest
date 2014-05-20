package es.agora.proto4.protocol.msgs.gates;

import java.io.Serializable;

public class MWG0_GUserError implements Serializable{

	private final String version= "0.2";
	private final String cmd= "GUserError";
	
	private final int reqId;
	private final String reason;
	//private final int errCode;
	
	public MWG0_GUserError(int reqId, String reason)
	{
		//this.errCode = errCode;
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
