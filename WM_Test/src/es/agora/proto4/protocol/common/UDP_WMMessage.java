package es.agora.proto4.protocol.common;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class UDP_WMMessage implements Serializable {

	@Expose private String V; //Version
	@Expose protected WM_Message M; //Message
	@Expose private String S; //Signature
	
	public UDP_WMMessage(String v, WM_Message m, String s)
	{
		super();
		this.V = v;
		this.M = m;
		this.S = s;
	}

	public String getV() {
		return V;
	}

	public WM_Message getM() {
		return M;
	}

	public String getS() {
		return S;
	}
	
	@Override
	public String toString()
	{
		return String.format("V:%s,M:{%s},S:%s",V,M.toString(),S);
	}
	
}
