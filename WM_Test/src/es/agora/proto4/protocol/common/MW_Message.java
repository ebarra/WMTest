package es.agora.proto4.protocol.common;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class MW_Message implements Serializable {

	private final MW_ID mw_id;
	
	@Expose protected String version;
	@Expose protected String cmd;
	@Expose protected int reqId;
	
	
	public MW_Message(MW_ID mw_id, String version, String cmd, int reqId)
	{
		super();
		this.mw_id = mw_id;
		this.version = version;
		this.cmd = cmd;
		this.reqId = reqId;
	}

	public MW_ID getMWId()
	{
		return mw_id;
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

	@Override
	public String toString()
	{
	    return String.format("version:%s,cmd:%s,reqId:%s", version, cmd, reqId);
	}
	
}
