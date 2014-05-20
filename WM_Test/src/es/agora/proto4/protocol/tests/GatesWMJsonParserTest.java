package es.agora.proto4.protocol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.agora.proto4.protocol.common.WMJsonParser;
import es.agora.proto4.protocol.common.WM_ID;
import es.agora.proto4.protocol.common.WM_Message;
import es.agora.proto4.protocol.msgs.gates.WMG0_GServerError;
import es.agora.proto4.protocol.msgs.gates.WMG2_GOpenSuccess;

public class GatesWMJsonParserTest
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
		  "\"cmd\":\"GServerError\"," + 
		  "\"reqId\":10," +
		  "\"errCode\":100," +
		  "\"reason\":\"He fallado sin saber\" }";
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);
		
		assertTrue(o instanceof WMG0_GServerError);
		// not the same as:
		assertEquals(WMG0_GServerError.class, o.getClass());
		
		WM_Message wm= (WM_Message)o;
		assertEquals(WM_ID.WMG0_GServerError, wm.getWMId());
		String s1= gson.toJson(wm);
		WM_Message o2= gson.fromJson(s1, WMG0_GServerError.class);
		
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
		 "\"cmd\":\"GOpenSuccess\","+
		 "\"reqId\":559638"+
		 "}";
		
		Object o= WMJsonParser.Json2WM(WM_str);
		assertNotNull(o);
		
		assertTrue(o instanceof WMG2_GOpenSuccess);
		// not the same as:
		assertEquals(WMG2_GOpenSuccess.class, o.getClass());
		
		WMG2_GOpenSuccess wm= (WMG2_GOpenSuccess)o;
		assertEquals(WM_ID.WMG2_GOpenSuccess, wm.getWMId());
		
		String s1= gson.toJson(o);
		WMG2_GOpenSuccess o2= gson.fromJson(s1, WMG2_GOpenSuccess.class);
		assertEquals(s1, gson.toJson(o2));
	}
}
