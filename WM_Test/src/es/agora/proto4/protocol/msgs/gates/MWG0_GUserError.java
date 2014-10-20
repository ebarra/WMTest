package es.agora.proto4.protocol.msgs.gates;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWG0_GUserError extends MW_Message
{

	private static final String VERSION= "0.2";
	private static final String CMD = "GUserError";
	
	private final int errCode;
	private final String reason;
	
	public MWG0_GUserError(int reqId, int errCode, String reason)
	{
		super(MW_ID.MWG0_GUserError,VERSION,CMD,reqId);
		this.errCode= errCode;
		this.reason = reason;
	}

	public String getReason()
	{
		return reason;
	}	
}
