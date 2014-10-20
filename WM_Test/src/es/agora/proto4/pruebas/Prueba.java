package es.agora.proto4.pruebas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.licenses.WMU0_UServerError;

public class Prueba
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Gson gson = new GsonBuilder()
						.excludeFieldsWithoutExposeAnnotation()
						.serializeNulls()
						.setPrettyPrinting()
						.create();
		

		WM_Message w1= new WMU0_UServerError("0", "UServerError", 44345, 10, "No tengo ni idea de lo que ha pasado");
		
		System.out.println("Primitiva: " + w1);
		
		System.out.println("JSON:" + gson.toJson(w1));
		
		String WMU0Str= 
		"{\"version\":\"0.2\"," +
			  "\"cmd\":\"UServerError\"," + 
			  "\"reqId\":\"44345\"," +
			  "\"errCode\":\"10\"," +
			  "\"reason\":\"He fallado sin saber\"}";
		
		System.out.println("JSON string: " + WMU0Str);
        // Now do the magic.
        WM_Message data = gson.fromJson(WMU0Str, WMU0_UServerError.class);
        
        Object o= WMJsonParser.Json2WM(WMU0Str);

        // Show it.
        System.out.println("DATA: " + data);
        System.out.println("OBJECT" + o);
        
        System.out.println(gson.toJson(data));
	}
}
