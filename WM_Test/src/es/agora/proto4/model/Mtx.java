package es.agora.proto4.model;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Mtx
{
	@Expose private int mtxId;
	@Expose private String name;
	@Expose private Config config;
	@Expose private List<Gate> gates;
	
	public Mtx(int mtxId, String name, Config config, List<Gate> gates)
	{
		super();
		this.mtxId = mtxId;
		this.name = name;
		this.config = config;
		this.gates = gates;
	}
	
	public int getId()
	{
		return mtxId;
	}

	public String getName()
	{
		return name;
	}

	public Config getConfig()
	{
		return config;
	}

	public List<Gate> getGates()
	{
		return gates;
	}

	@Override
	public String toString()
	{
        return String.format("{mtxId:%d,name:%s,config:%s,gates:[%s]}", mtxId, name, config, gates);
	}
}
