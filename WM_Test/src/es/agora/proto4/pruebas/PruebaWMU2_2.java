package es.agora.proto4.pruebas;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.model.Access;
import es.agora.proto4.model.Building;
import es.agora.proto4.model.Config;
import es.agora.proto4.model.Gate;
import es.agora.proto4.model.License;
import es.agora.proto4.model.Mtx;
import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.licenses.WMU2_UUpdateSuccess;

public class PruebaWMU2_2
{
	private final static String WMU2_Str=			
			"{\"version\":\"0.1\","+
			 "\"cmd\":\"LicenseActivationResponse\","+
			 "\"reqId\":559638,"+
			 "\"licenses\":"+
			 "["+
			 "{\"licenseId\":3,"+
	            "\"name\":\"l113\","+
	            "\"userName\":\"Carlos\","+
	            "\"active\":\"true\","+          
	            "\"building\":"+
	               "{\"buildingId\":1,"+
	                "\"name\":\"Madrid11\","+
	                "\"mtxes\":"+
	                	"[" +
	                        "{\"mtxId\":1,"+
	                         "\"name\":\"mtx111\","+
	                         "\"config\":"+
	                         "{"+
	                         	"\"bluetooth\":{\"enabled\":\"false\",\"name\":\"bn_mtx112\",\"pin\":\"p_mtx111\"},"+
	                         	"\"wifi\":{\"enabled\":false,\"ip\":\"1.1.1.1\",\"ssid\":\"ssid11\",\"password\":\"1234\"},"+
	                         	"\"gsm\":{\"enabled\":false},"+
	                         	"\"ip\":{\"enabled\":false}"+
	                         "},"+
	                         "\"gates\":"+
	                         "["+
	                        	"{\"gateId\":1,\"name\":\"g1111\",\"mtxRele\":1,\"enabled\":true},"+
	                        	"{\"gateId\":2,\"name\":\"g1112\",\"mtxRele\":2,\"enabled\":true}"+	                	     
	                         "]" +
	                       	"},"+
	                        "{\"mtxId\":2,"+
	                         "\"name\":\"mtx112\","+
	                         "\"config\":"+
	                        	"{"+
	                        		"\"bluetooth\":{\"enabled\":\"false\",\"name\":\"bn_mtx112\",\"pin\":\"p_mtx112\"},"+
	                        		"\"wifi\":{\"enabled\":false,\"ip\":\"1.1.1.1\",\"ssid\":\"ssid11\",\"password\":\"1234\"},"+
	                        		"\"gsm\":{\"enabled\":false},"+
	                        		"\"ip\":{\"enabled\":false}"+
	                        	"},"+
	                        	"\"gates\":"+
	                        	"["+
	                        		"{\"gateId\":3,\"name\":\"g1121\",\"mtxRele\":1,\"enabled\":true},"+
	                        		"{\"gateId\":4,\"name\":\"g1122\",\"mtxRele\":2,\"enabled\":true}"+	                	     
	                        	"]" +
	                        "}"+
	                    "]," +
	                    "\"accesses\":"+
	                         "["+
	                        	"{\"accessId\":1,\"name\":\"garage acc111\",\"gateIds\":[1]},"+
	                        	"{\"accessId\":3,\"name\":\"ocio acc113\",\"gateIds\":[4]},"+
	                        	"{\"accessId\":2,\"name\":\"salida acc112\",\"gateIds\":[2,3]}"+
	                         "]"+
	               "}"+
	            "},"+
	          "{\"licenseId\":11,"+
	            "\"name\":\"l211\","+
	            "\"userName\":\"Carlos\","+
	            "\"active\":\"true\","+          
	            "\"building\":"+
	               "{\"buildingId\":3,"+
	                "\"name\":\"Burgos21\","+
	                "\"mtxes\":"+
	                  "["+
	                  	"{\"mtxId\":4,"+
	                      "\"name\":\"mtx211\","+
 	                 	  "\"config\":"+
		                	 "{"+
		                	    "\"bluetooth\":{\"enabled\":\"false\",\"name\":\"bn_mtx211\",\"pin\":\"p_mtx211\"},"+
		                	    "\"wifi\":{\"enabled\":false,\"ip\":\"1.1.1.1\",\"ssid\":\"ssid11\",\"password\":\"1234\"},"+
		                	    "\"gsm\":{\"enabled\":false},"+
		                	    "\"ip\":{\"enabled\":false}"+
		                	 "},"+
		                	 "\"gates\":"+
		                	 "["+
		                	     "{\"id\":6,\"name\":\"g2111\",\"mtxRele\":1,\"enabled\":true},"+
		                	     "{\"id\":7,\"name\":\"g2112\",\"mtxRele\":2,\"enabled\":true}"+	                	     
		                	 "]" +
	                	 "}"+
	                  "],"+
	                  "\"accesses\":"+
		               "["+
		               	   "{\"accessId\":5,\"name\":\"entrada acc211\",\"gateIds\":[6]},"+
		               	   "{\"accessId\":6,\"name\":\"salida acc212\",\"gateIds\":[7]}"+
		               "]"+
	               "}"+
		      "}"+
	         "]"+
		     "}";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
		
		Gate g1= new Gate(1, "g1111", "1", true);
		Gate g2= new Gate(2, "g1112", "2", true);
		List<Gate> lgs1= new ArrayList<Gate>();
		lgs1.add(g1);
		lgs1.add(g2);
		Config cfg1= new Config(false, "bn_mtx111", "p_mtx111", false, "1.1.1.1", "ssid11", "1234", false, false);
		Mtx m1= new Mtx(1, "mtx111", cfg1, lgs1);
		
		Gate g3= new Gate(3, "g1121", "1", true);
		Gate g4= new Gate(4, "g1122", "2", true);
		List<Gate> lgs2= new ArrayList<Gate>();
		lgs2.add(g3);
		lgs2.add(g4);
		Config cfg2 = new Config(false, "bn_mtx112", "bp_mtx112", false, "1.1.1.1", "ssid11", "1234", false, false);
		Mtx m2= new Mtx(1, "mtx112", cfg2, lgs2);
		
		List<Mtx> mtxlist1= new ArrayList<Mtx>();
		mtxlist1.add(m1);
		mtxlist1.add(m2);

		List<Integer> gateIds1=  new ArrayList<Integer>();
		gateIds1.add(1);
		Access a1= new Access(1, "garage acc111", gateIds1);
		List<Integer> gateIds2=  new ArrayList<Integer>();
		gateIds2.add(4);
		Access a2= new Access(3, "ocio acc113", gateIds2);
		List<Integer> gateIds3=  new ArrayList<Integer>();
		gateIds3.add(2);
		gateIds3.add(3);
		Access a3= new Access(2, "salida acc112", gateIds3);
		List<Access> accessList1= new ArrayList<Access>();
		accessList1.add(a1);
		accessList1.add(a2);
		accessList1.add(a3);
		
		Building b1= new Building(1, "Madrid11", mtxlist1, accessList1);
		License l1= new License(2, "l113", b1);
		
		Gate g6= new Gate(6, "g2111", "1", true);
		Gate g7= new Gate(7, "g2112", "2", true);
		List<Gate> lgs3= new ArrayList<Gate>();
		lgs3.add(g6);
		lgs3.add(g7);
		Config cfg3= new Config(false, "bn_mtx211", "bp_mtx211",false, "1.1.1.1", "ssid11", "1234", false, false);
		Mtx m4= new Mtx(4, "mtx211", cfg3, lgs3);
		
		List<Mtx> mtxlist2= new ArrayList<Mtx>();
		mtxlist2.add(m4);

		List<Integer> gateIds4= new ArrayList<Integer>();
		gateIds4.add(6);
		Access a4= new Access(5, "entrada acc211", gateIds4);
		List<Integer> gateIds5= new ArrayList<Integer>();
		gateIds5.add(7);
		Access a5= new Access(6, "salida acc212", gateIds5);
		List<Access> accessList2= new ArrayList<Access>();
		accessList2.add(a4);
		accessList2.add(a5);
		
		Building b2= new Building(3, "Burgos21", mtxlist2, accessList2);
		License l2= new License(11, "l211", b2);

		List<License> licList= new ArrayList<License>();
		licList.add(l1);
		licList.add(l2);
		
		WMU2_UUpdateSuccess w8=
			new WMU2_UUpdateSuccess("0", "UUpdateSuccess", 559638, licList);
		
		System.out.println("Primitiva: " + w8);

		String str1= gson.toJson(w8);
		System.out.println("JSON:" + str1);
		
		System.out.println("DESERIALIZADOR DE GSON:");
		WMU2_UUpdateSuccess data = gson.fromJson(str1, WMU2_UUpdateSuccess.class);
		System.out.println("JSON:\n" + data);
		
		System.out.println("DESERIALIZADOR DE WMJsonParser");		
		WM_Message wm= WMJsonParser.Json2WM(str1);
		WMU2_UUpdateSuccess wm8= (WMU2_UUpdateSuccess)wm;
		
		System.out.println("DESERIALIZADO:\n" + wm8);
		
		// Now do the magic.
		System.out.println("DESERIALIZADOR a partir de String sintética");		

		WMU2_UUpdateSuccess d2= gson.fromJson(WMU2_Str, WMU2_UUpdateSuccess.class);
        
        Object o= WMJsonParser.Json2WM(WMU2_Str);

        // Show it.
        System.out.println("DATA: " + d2);
        System.out.println("OBJECT" + o);
        
        System.out.println("JSON:\n" + gson.toJson(d2));
	}

}
