package es.agora.proto4.protocol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.licenses.WMU0_UServerError;
import es.agora.proto4.protocol.msgs.licenses.WMU2_UUpdateSuccess;

public class LicensesWMJsonParserTest
{
	private static Gson gson;
	
    @Before
    public void setup()
    {
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
    }
    
	//
	// WM1  Test cases
	//
	@Test
	public void WM0_test1()
	{
		
		String WM_str= 
		"{\"version\":\"0.2\"," +
		  "\"cmd\":\"UServerError\"," + 
		  "\"reqId\":10," +
		  "\"errCode\":100," +
		  "\"reason\":\"He fallado sin saber\" }";
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);
		
		assertTrue(o instanceof WMU0_UServerError);
		// not the same as:
		assertEquals(WMU0_UServerError.class, o.getClass());
		
		WM_Message wm= (WM_Message)o;
		assertEquals(WM_ID.WMU0_UServerError, wm.getWMId());
		String s1= gson.toJson(wm);
		WM_Message o2= gson.fromJson(s1, WMU0_UServerError.class);
		
		assertEquals(s1, gson.toJson(o2));
	}

	@Test
	public void WM0_test2()
	{
		// bad message, lacks cmd
		String WMBad_str= 
		"{\"version\":\"0.2\"," +
		  "\"reqId\":10," +
		  "\"errCode\":100," +
		  "\"reason\":\"He fallado sin saber\" }";
		
		assertNull(WMJsonParser.Json2WM(WMBad_str));
	}

	//
	// WM5 Test cases
	//
	@Test
	public void WM2_test1()
	{
		String WM_str= 
		"{\"version\":\"0.2\","+
		 "\"cmd\":\"UUpdateSuccess\","+
		 "\"reqId\":559638,"+
		 "licenses:[]}"; // Syntactically legal, but never sent
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);

		assertTrue(o instanceof WMU2_UUpdateSuccess);
		// not the same as:
		assertEquals(WMU2_UUpdateSuccess.class, o.getClass());
		
		WMU2_UUpdateSuccess wm= (WMU2_UUpdateSuccess)o;
		assertEquals(WM_ID.WMU2_UUpdateSuccess, wm.getWMId());
		
		String s1= gson.toJson(o);
		WMU2_UUpdateSuccess o2= gson.fromJson(s1, WMU2_UUpdateSuccess.class);
		assertEquals(s1, gson.toJson(o2));
	}

	
	//
	// Test cases
	//
	@Test
	public void WM2_test2()
	{
		String WM_Str= 
				"{\"version\":\"0\","+
						 "\"cmd\":\"UUpdateSuccess\","+
						 "\"reqId\":559638,"+
						 "\"licenses\":"+
						 "["+
						 "{\"licenseId\":3,"+
				            "\"name\":\"l113\","+
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
		Object o= WMJsonParser.Json2WM(WM_Str);
		assertNotNull(o);
		
		assertTrue(o instanceof WMU2_UUpdateSuccess);
		// not the same as:
		assertEquals(WMU2_UUpdateSuccess.class, o.getClass());
		
		WMU2_UUpdateSuccess wm= (WMU2_UUpdateSuccess)o;
		assertEquals(WM_ID.WMU2_UUpdateSuccess, wm.getWMId());
		
		String s1= gson.toJson(o);
		WMU2_UUpdateSuccess o2= gson.fromJson(s1, WMU2_UUpdateSuccess.class);
		assertEquals(s1, gson.toJson(o2));
	}
}
