package es.agora.proto4.pruebas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.protocol.common.UDP_MWMessage;
import es.agora.proto4.protocol.msgs.registry.MWR1_RRegisterRequest;

public class Prueba_UDP_MWMessage {

	public static void main (String[] args)
	{
		Gson gson = new GsonBuilder()
							.excludeFieldsWithoutExposeAnnotation()
							.serializeNulls()
							.setPrettyPrinting()
							.create();
		
		//New MW_Message
		MWR1_RRegisterRequest msg = new MWR1_RRegisterRequest(1234, "", "639285783", "1");
	
		//New UDP_MWMessage
		UDP_MWMessage udp_msg = new UDP_MWMessage("1", msg, "");
		
		//Print MW_Message
		System.out.println("Primitiva: " + msg);
		
		//Print gson.toJson(MW_Message)
		System.out.println("M: " + gson.toJson(msg));
		
		//Print UDP_Message
		System.out.println("UDP: " + udp_msg);
		
		//Print gson.toJson(UDP_MWMessage)
		System.out.println("((JSON) UDP: " + gson.toJson(udp_msg));
	}
	
}
