package es.agora.proto4.protocol.msgs.licenses;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWU0_UUserError extends MW_Message
{
	private static final String VERSION= "0.2";
	private static final String CMD= "UUserError";
	
	@Expose private final int errCode;
	@Expose private final String reason;
	
	public MWU0_UUserError(int reqId, int errCode, String reason)
	{
		super(MW_ID.MWU0_UUserError,VERSION,CMD,reqId);
		this.errCode= errCode;
		this.reason = reason;
	}

	public String getReason()
	{
		return reason;
	}	
}
