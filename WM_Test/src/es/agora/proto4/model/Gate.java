package es.agora.proto4.model;

import com.google.gson.annotations.Expose;

public class Gate
{
	@Expose private int gateId;
	@Expose private String name;
	@Expose private String mtxRele;
	@Expose private boolean enabled;
	public Gate(int gateId, String name, String mtxRele, boolean enabled)
	{
		super();
		this.gateId = gateId;
		this.name = name;
		this.mtxRele = mtxRele;
		this.enabled = enabled;
	}
	public int getId()
	{
		return gateId;
	}
	public String getName()
	{
		return name;
	}
	public String getMtxRele()
	{
		return mtxRele;
	}
	public boolean isEnabled()
	{
		return enabled;
	}
	
	@Override
	public String toString()
	{
        return String.format("{gateId:%d,name:%s,mtxRele:%s,enabled:%b}", gateId, name, mtxRele, enabled);
	}	
}
