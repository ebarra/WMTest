package es.agora.proto4.model;

import com.google.gson.annotations.Expose;

public class License
{
	@Expose private int licenseId;
	@Expose private String name;
	@Expose private Building building;
	
	public License(int licenseId, String name,
			Building building)
	{
		super();
		this.licenseId = licenseId;
		this.name = name;
		this.building = building;
	}
	public int getId()
	{
		return licenseId;
	}
	public String getName()
	{
		return name;
	}

	public Building getBuilding()
	{
		return building;
	}
	
	@Override
	public String toString()
	{
        return String.format("{licenseId:%d,name:%s,building:%s}", licenseId, name, building);
	}	

}
