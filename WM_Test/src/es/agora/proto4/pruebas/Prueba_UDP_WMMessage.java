package es.agora.proto4.pruebas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.protocol.common.UDP_WMMessage;
import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.registry.WMR0_RServerError;
import es.agora.proto4.protocol.msgs.registry.WMR2_RSMSRequest;


public class Prueba_UDP_WMMessage {

	public static void main (String [] args)
	{
		Gson gson = new GsonBuilder()
							.excludeFieldsWithoutExposeAnnotation()
							.serializeNulls()
							.setPrettyPrinting()
							.create();
		
		//New WM_Message
		WMR2_RSMSRequest msg = new WMR2_RSMSRequest("0.2", "RSmsRequest", 1234);
		
		//New UDP_WMMessage
		UDP_WMMessage udp_msg = new UDP_WMMessage("1", msg, "");
		
		//Print WM_Message
		System.out.println("Primitiva: " + msg);
		
		//Print gson.toJson(WM_Message)
		System.out.println("M: " + gson.toJson(msg));
		
		//Print UDP_Message
		System.out.println("UDP: " + udp_msg);
		
		//Print gson.toJson(UDP_WMMessage)
		System.out.println("(JSON) UDP: " + gson.toJson(udp_msg));
		
		
		//Manual JSON
		String WMR0Str= 
			"{\"version\":\"0.2\"," +
			"\"cmd\":\"RServerError\"," + 
			"\"reqId\":\"44345\"," +
			"\"errCode\":\"10\"," +
			"\"reason\":\"K'apasao?\"}";
		
		System.out.println("JSON string: " + WMR0Str);
        
        WM_Message data = gson.fromJson(WMR0Str, WMR0_RServerError.class);
        System.out.println("DATA: " + data);
        
        Object o= WMJsonParser.Json2WM(WMR0Str);
        System.out.println("OBJECT: " + o);
        
        System.out.println("__________________________________________________________________________________________");
        System.out.println();
        
		String udp_WMR0Str = 
			"{\"V\":\"1\"," +
			"\"M\": "+WMR0Str+","+
			"\"S\":\"\"}";
		System.out.println("UDP Json string: " + udp_WMR0Str);
		
		UDP_WMMessage udp_data = gson.fromJson(udp_WMR0Str, UDP_WMMessage.class);
		System.out.println("UDP DATA: " + udp_data);
		
		Object udp_o = WMJsonParser.Json2UDP_WM(udp_WMR0Str);
		System.out.println("UDP OBJECT: " + udp_o);
		
	}
	
}
