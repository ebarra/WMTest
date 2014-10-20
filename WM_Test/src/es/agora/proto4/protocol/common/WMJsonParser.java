package es.agora.proto4.protocol.common;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import es.agora.proto4.model.Building;
import es.agora.proto4.model.License;
import es.agora.proto4.protocol.msgs.gates.WMG0_GServerError;
import es.agora.proto4.protocol.msgs.gates.WMG2_GOpenSuccess;
import es.agora.proto4.protocol.msgs.licenses.WMU0_UServerError;
import es.agora.proto4.protocol.msgs.licenses.WMU2_UUpdateSuccess;
import es.agora.proto4.protocol.msgs.registry.WMR0_RServerError;
import es.agora.proto4.protocol.msgs.registry.WMR2_RSMSRequest;
import es.agora.proto4.protocol.msgs.registry.WMR3_RRegisterSuccess;

public class WMJsonParser
{
	private static Gson gson= new GsonBuilder()
                                     .excludeFieldsWithoutExposeAnnotation()
                                     .serializeNulls()
                                     // .setPrettyPrinting()
                                     .create();
	
	// Protocolo de Registro Web - M�vil  
	private static final String WMR0_RServerError="RServerError";
	private static final String WMR2_RSMSRequest="RSmsRequest";
	private static final String WMR3_RRegisterSuccess="RRegisterSuccess";

	// Protocolo de Actualizaci�n de Licencia Web - M�vil
	private static final String WMU0_UServerError= "UServerError";
	private static final String WMU2_UUpdateSuccess= "UUpdateSuccess";


	// Protocolo de Apertura de Puertas Web - M�vil
	private static final String WMG0_GServerError = "GServerError";
	private static final String WMG2_GOpenSuccess = "GOpenSuccess";

	public static String toJson(Object o)
	{
		return gson.toJson(o);
	}
	
	public static UDP_WMMessage Json2UDP_WM (String jsonStr)
	{
		JsonParser parser = new JsonParser();
		JsonElement je = parser.parse(jsonStr);
		
		if(!je.isJsonObject())
			return null;
		
		JsonObject jo = je.getAsJsonObject();
		
		if(!jo.has("V")) return null;
		String V = gson.fromJson(jo.get("V"), String.class);
		if(!jo.has("M")) return null;
		JsonObject strm = gson.fromJson(jo.get("M"), JsonObject.class);
		WM_Message M = Json2WM(strm.toString());
		
		if(!jo.has("S")) return null;
		String S = gson.fromJson(jo.get("S"), String.class);
		
		return new UDP_WMMessage(V, M, S);
	}
	
	public static WM_Message Json2WM (String jsonStr)
	{
		JsonParser parser = new JsonParser();
		JsonElement je= parser.parse(jsonStr);
		
		if ( ! je.isJsonObject())
			return null;
		
	    JsonObject jo = je.getAsJsonObject();
	    
	    if ( ! jo.has("version")) return null;
	    String version = gson.fromJson(jo.get("version"), String.class);
	    if ( ! jo.has("cmd")) return null;
	    String cmd = gson.fromJson(jo.get("cmd"), String.class);
	    if ( ! jo.has("reqId")) return null;
	    int reqId = gson.fromJson(jo.get("reqId"), int.class);
	    
	    
	    // Registry Protocol
	    if (cmd.equals(WMR0_RServerError))
	    {
		    if ( ! jo.has("errCode")) return null;
	    	int errCode = gson.fromJson(jo.get("errCode"), int.class);
		    if ( ! jo.has("reason")) return null;
	    	String reason = gson.fromJson(jo.get("reason"), String.class);
	    	return new WMR0_RServerError(version, cmd, reqId, errCode, reason);
	    }
	    else if (cmd.equals(WMR2_RSMSRequest))
	    {
	    	return new WMR2_RSMSRequest(version, cmd, reqId);
	    }
	    else if (cmd.equals(WMR3_RRegisterSuccess))
	    {
	    	return new WMR3_RRegisterSuccess(version, cmd, reqId);
	    }
	    
	    // License Activation Protocol
	    else if (cmd.equals(WMU0_UServerError))
	    {
		    if ( ! jo.has("errCode")) return null;
	    	int errCode = gson.fromJson(jo.get("errCode"), int.class);
		    if ( ! jo.has("reason")) return null;
	    	String reason = gson.fromJson(jo.get("reason"), String.class);
	    	return new WMU0_UServerError(version, cmd, reqId, errCode, reason);
	    }
	    else if (cmd.equals(WMU2_UUpdateSuccess))
	    {
		    if ( ! jo.has("licenses")) return null;
	    	//List<License> licenses= getLicenses(jo.getAsJsonArray("licenses"));
		    Type token= new TypeToken<ArrayList<License>>() {}.getType();
		    List<License> licenses = gson.fromJson(jo.get("licenses"), token);
	    	return new WMU2_UUpdateSuccess(version, cmd, reqId, licenses);	    		    	
	    }
	    
	    // Gate Opening Protocol
	    else if(cmd.equals(WMG0_GServerError)){
	    	if ( ! jo.has("reason")) return null;
	    	String reason = gson.fromJson(jo.get("reason"), String.class);
	    	return new WMG0_GServerError(version,cmd,reqId,reason);
	    }
	    else if(cmd.equals(WMG2_GOpenSuccess)){
	    	return new WMG2_GOpenSuccess(version,cmd,reqId);
	    }
	    else
	    	return null;
	    //Event event = gson.fromJson(array.get(2), Event.class);
	}
	
	public static List<License> parseLicenses(String jsonStr)
	{
		Type token= new TypeToken<ArrayList<License>>() {}.getType();
		List<License> licenses = gson.fromJson(jsonStr, token);
		
		return licenses;
	}

	private static List<License> getLicenses(JsonElement jeLicense)
	{
		List<License> licenses= new ArrayList<License>();
		
		JsonArray jaLic= jeLicense.getAsJsonArray();
		
		Iterator<JsonElement> it= jaLic.iterator();
		while (it.hasNext())
		{
			JsonElement je= it.next();
			
			if ( ! je.isJsonObject())
				return null;
			
			JsonObject jo= je.getAsJsonObject();
			
			if ( ! jo.has("id")) return null;
		    int id= gson.fromJson(jo.get("id"), int.class);
			if ( ! jo.has("name")) return null;
		    String name= gson.fromJson(jo.get("name"), String.class);
			if ( ! jo.has("building")) return null;
		    Building building= getBuilding(jo.get("building"));

		    licenses.add(new License(id, name, building));			
		}
		
		return licenses;
	}

	private static Building getBuilding(JsonElement jeBuilding)
	{
		//JsonObject jo= jeBuilding.getAsJsonObject();
		
		return null;
	}
}
