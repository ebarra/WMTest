package es.agora.proto4.protocol.msgs.licenses;

import java.util.List;

import com.google.gson.annotations.Expose;

import es.agora.proto4.model.License;
import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;

public class WMU2_UUpdateSuccess extends WM_Message
{
	@Expose private List<License> licenses;

	public WMU2_UUpdateSuccess(String version,
							String cmd,
							int reqId,
							List<License> licenses)
	{
		super(WM_ID.WMU2_UUpdateSuccess, version, cmd, reqId);

		this.licenses= licenses;
	}

	public List<License> getLicenses()
	{
		return licenses;
	}
	
	@Override
	public String toString()
	{
        return String.format("%s,licenses:[%s]", super.toString(), licenses);
	}	

}
