package es.agora.proto4.model;

import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Access
{
	@Expose private int accessId;
	@Expose private String name;
	@Expose private List<Integer> gateIds;
	public Access(int accessId, String name, List<Integer> gateIds)
	{
		super();
		this.accessId = accessId;
		this.name = name;
		this.gateIds = gateIds;
	}
	public int getId()
	{
		return accessId;
	}
	public String getName()
	{
		return name;
	}
	public List<Integer> getGatesIds()
	{
		return gateIds;
	}
	@Override
	public String toString()
	{
        return String.format("accessId:%d,name:%s,gateIds:[%s]", accessId, name, gateIds);
	}
}
