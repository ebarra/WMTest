package es.agora.proto4.protocol.msgs.registry;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWR9_RCleanup extends MW_Message
{
	private static final String VERSION = "0.2";
	private static final String CMD = "RCleanup";

	
	public MWR9_RCleanup(int reqId)
	{
		super(MW_ID.MWR9_RCleanUp,VERSION,CMD,reqId);
	}

}
