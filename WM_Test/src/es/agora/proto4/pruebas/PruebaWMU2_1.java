package es.agora.proto4.pruebas;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.model.Building;
import es.agora.proto4.model.License;
import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.licenses.WMU2_UUpdateSuccess;

public class PruebaWMU2_1
{
	private final static String WMU2_Str=			
			"{\"version\":\"0.2\","+
			 "\"cmd\":\"UUpdateSuccess\","+
			 "\"reqId\":559638,"+
			 "\"licenses\":"+
			 "[{\"licenseId\":3,"+
	            "\"name\":\"l113\","+
	            "\"building\":"+
	               "{\"buildingId\":1,"+
	                "\"name\":\"Madrid11\","+
	                "}},"+
	          "{\"licenseId\":11,"+
	            "\"name\":\"l211\","+
	            "\"building\":"+
	               "{\"buildingId\":3,"+
	                "\"name\":\"Burgos21\","+
	                "}}"+
	         "]}";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
		
		Building b1= new Building(1, "Madrid11", null, null);
		License l1= new License(2, "l113", b1);

		Building b2= new Building(3, "Burgos21", null, null);
		License l2= new License(11, "l211", b2);

		List<License> licList= new ArrayList<License>();
		licList.add(l1);
		licList.add(l2);
		
		WMU2_UUpdateSuccess w2=
				new WMU2_UUpdateSuccess("0", "UUpdateSuccess", 559638, licList);
		
		System.out.println("Primitiva: " + w2);
		
		System.out.println("JSON:" + gson.toJson(w2));
		
		System.out.println("JSON string: " + WMU2_Str);
		
        // Now do the magic.
		WMU2_UUpdateSuccess data = gson.fromJson(WMU2_Str, WMU2_UUpdateSuccess.class);
        
        WM_Message o= WMJsonParser.Json2WM(WMU2_Str);

        // Show it.
        System.out.println("DATA: " + data);
        System.out.println("OBJECT" + o);        
	}
}
