package es.agora.proto4.protocol.msgs.registry;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;

public class WMR3_RRegisterSuccess extends WM_Message
{
	public WMR3_RRegisterSuccess(String version, String cmd, int reqId)
	{
		super(WM_ID.WMR3_RegisterSuccess, version, cmd, reqId);
	}
}
