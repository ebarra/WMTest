package es.agora.proto4.protocol.msgs.gates;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;

public class WMG2_GOpenSuccess extends WM_Message {


	@Expose private String reason;

	public WMG2_GOpenSuccess(String version, String cmd, int reqId)
	{
		//Create id's
		super(WM_ID.WMG2_GOpenSuccess, version, cmd, reqId);
	}
 /*
	
	@Override
	public String toString()
	{
	    return String.format("%s,reason:%s", super.toString(), reason);
	}
	
	
	*/
}
