package es.agora.proto4.protocol.msgs.registry;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;

public class WMR2_RSMSRequest extends WM_Message
{
	public WMR2_RSMSRequest(String version, String cmd, int reqId)
	{
		super(WM_ID.WMR2_RSMSRequest, version, cmd, reqId);
	}
}
