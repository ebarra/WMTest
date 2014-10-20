package es.agora.proto4.protocol.msgs.gates;

import es.agora.proto4.protocol.common.MW_ID;
import es.agora.proto4.protocol.common.MW_Message;

public class MWG9_GCleanup extends MW_Message
{

	private static final String VERSION= "0.2";
	private static final String CMD= "GCleanup";	

	public MWG9_GCleanup(int reqId)
	{
		super(MW_ID.MWG9_GCleanUp,VERSION,CMD,reqId);
	}

}
