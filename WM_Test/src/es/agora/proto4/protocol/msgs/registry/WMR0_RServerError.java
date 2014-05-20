package es.agora.proto4.protocol.msgs.registry;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;

public class WMR0_RServerError extends WM_Message
{
	@Expose private int errCode;
	@Expose private String reason;

	public WMR0_RServerError(String version, String cmd, int reqId, int errCode, String reason)
	{
		super(WM_ID.WMR0_RServerError, version, cmd, reqId);
		
		this.reason = reason;
	}

	public String getReason()
	{
		return reason;
	}
	
	@Override
	public String toString()
	{
	    return String.format("%s,reason:%s", super.toString(), reason);
	}
}
