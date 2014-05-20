package es.agora.proto4.protocol.msgs.gates;

import java.io.Serializable;

public class MWG9_GCleanup implements Serializable{

	private final String version= "0.2";
	private final String cmd= "GCleanup";
	
	private final int reqId;
	

	public MWG9_GCleanup(int reqId)
	{
		this.reqId= reqId;
	}


	public String getVersion() {
		return version;
	}


	public String getCmd() {
		return cmd;
	}


	public int getReqId() {
		return reqId;
	}
	
	
	
}
