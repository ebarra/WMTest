package es.agora.proto4.model;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Building
{
	@Expose private int buildingId;
	@Expose private String name;
	@Expose List<Mtx> mtxes;
	@Expose List<Access> accesses;
	
	public Building(int buildingId,
			String name,
			List<Mtx> mtxes,
			List<Access> accesses)
	{
		super();
		this.buildingId = buildingId;
		this.name = name;
		this.mtxes= mtxes;
		this.accesses = accesses;
	}
	
	public int getId()
	{
		return buildingId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<Mtx> getMtxes()
	{
		return mtxes;
	}

	public List<Access> getAccesses()
	{
		return accesses;
	}	
	
	@Override
	public String toString()
	{
        return String.format("{buildingId:%d,name:%s,mtxes:[%s],accesses:[%s]}",
        		buildingId, name, mtxes, accesses);
	}


}
