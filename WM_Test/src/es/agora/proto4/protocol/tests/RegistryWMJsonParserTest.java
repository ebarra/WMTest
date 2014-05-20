package es.agora.proto4.protocol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.registry.WMR0_RServerError;
import es.agora.proto4.protocol.msgs.registry.WMR2_RSMSRequest;
import es.agora.proto4.protocol.msgs.registry.WMR3_RRegisterSuccess;

public class RegistryWMJsonParserTest
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
		  "\"cmd\":\"RServerError\"," + 
		  "\"reqId\":10," +
		  "\"errCode\":100," +
		  "\"reason\":\"He fallado sin saber\" }";
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);
		
		assertTrue(o instanceof WMR0_RServerError);
		// not the same as:
		assertEquals(WMR0_RServerError.class, o.getClass());
		
		WM_Message wm= (WM_Message)o;
		assertEquals(WM_ID.WMR0_RServerError, wm.getWMId());
		String s1= gson.toJson(wm);
		WM_Message o2= gson.fromJson(s1, WMR0_RServerError.class);
		
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
	// WM2  Test cases
	//
	@Test
	public void WM2_test1()
	{
		String WM_str= 
		"{\"version\":\"0.2\","+
		 "\"cmd\":\"RSmsRequest\","+
		 "\"reqId\":559638"+
		 "}";
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);
		
		assertTrue(o instanceof WMR2_RSMSRequest);
		// not the same as:
		assertEquals(WMR2_RSMSRequest.class, o.getClass());
		
		WMR2_RSMSRequest wm= (WMR2_RSMSRequest)o;
		assertEquals(WM_ID.WMR2_RSMSRequest, wm.getWMId());
		
		String s1= gson.toJson(o);
		WMR2_RSMSRequest o2= gson.fromJson(s1, WMR2_RSMSRequest.class);
		assertEquals(s1, gson.toJson(o2));
	}

	//
	// WM9  Test cases
	//
	@Test
	public void WM9_test1()
	{
		String WM_str= 
		"{\"version\":\"0.2\","+
		 "\"cmd\":\"RRegisterSuccess\","+
		 "\"reqId\":559638}";
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);

		assertTrue(o instanceof WMR3_RRegisterSuccess);
		// not the same as:
		assertEquals(WMR3_RRegisterSuccess.class, o.getClass());
		
		WMR3_RRegisterSuccess wm= (WMR3_RRegisterSuccess)o;
		assertEquals(WM_ID.WMR3_RegisterSuccess, wm.getWMId());
		
		String s1= gson.toJson(o);
		WMR3_RRegisterSuccess o2= gson.fromJson(s1, WMR3_RRegisterSuccess.class);
		assertEquals(s1, gson.toJson(o2));
	}
}
