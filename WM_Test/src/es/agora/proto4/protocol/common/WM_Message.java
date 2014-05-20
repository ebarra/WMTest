package es.agora.proto4.protocol.common;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class WM_Message implements Serializable
{
	private final WM_ID wm_id;
	
	@Expose protected String version;
	@Expose protected String cmd;
	@Expose protected int reqId;

	public WM_Message(WM_ID wm_id, String version, String cmd, int reqId)
	{
		super();
		this.wm_id = wm_id;
		this.version = version;
		this.cmd = cmd;
		this.reqId = reqId;
	}

	public WM_ID getWMId()
	{
		return wm_id;
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