package es.agora.proto4.protocol.msgs.registry;

import com.google.gson.annotations.Expose;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWR2_RSMSResponse extends MW_Message
{
	private static final String VERSION = "0.2";
	private static final String CMD = "RSmsResponse";

	@Expose private final int activationCode;
	@Expose private final int verificationCode;

	public MWR2_RSMSResponse(int reqId, int activationCode, int verificationCode)
	{
		super(MW_ID.MWR2_RSMSResponse,VERSION,CMD,reqId);
		this.activationCode = activationCode;
		this.verificationCode = verificationCode;
	}

	public int getActivationCode()
	{
		return activationCode;
	}

	public int getVerificationCode()
	{
		return verificationCode;
	}
}
