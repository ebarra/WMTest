package es.agora.proto4.protocol.msgs.gates;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;

public class WMG0_GServerError extends WM_Message{

	@Expose private String reason;
	
	public WMG0_GServerError(String version, String cmd, int reqId, String reason) {

		//super(WM_ID.WMG2_GOpenSuccess, version, cmd, reqId);
		super(WM_ID.WMG0_GServerError,version, cmd, reqId);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String toString()
	{
	    return String.format("%s,reason:%s", super.toString(), reason);
	}
}
