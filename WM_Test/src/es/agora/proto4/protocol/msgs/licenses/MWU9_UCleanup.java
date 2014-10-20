package es.agora.proto4.protocol.msgs.licenses;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWU9_UCleanup extends MW_Message
{
	private static final String version= "0.2";
	private static final String cmd= "RCleanup";
	
	public MWU9_UCleanup(int reqId)
	{
		super(MW_ID.MWG9_GCleanUp, version, cmd, reqId);
		this.reqId= reqId;
	}

}
