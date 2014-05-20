package es.agora.proto4.model;

import com.google.gson.annotations.Expose;

public class Config
{
	@Expose private BluetoothAccess bluetooth;
	@Expose private WifiAccess wifi;
	@Expose private GsmAccess gsm;
	@Expose private IpAccess ip;
	
	
    public Config(boolean btEnabled, String btName, String btPin,
    		boolean wifiEnabled, String wifiIp, String wifiSsid, String wifiPassword,
    		boolean gsmEnabled,
    		boolean ipEnabled)
	{
		this.bluetooth = new BluetoothAccess(btEnabled, btName, btPin);
		this.wifi = new WifiAccess(wifiEnabled, wifiIp, wifiSsid, wifiPassword);
		this.gsm = new GsmAccess(gsmEnabled);
		this.ip = new IpAccess(ipEnabled);
	}
    
	class BluetoothAccess {
		@Expose private boolean enabled;
		@Expose private String name;
		@Expose private String pin;
    	
		public BluetoothAccess(boolean enabled, String name, String pin)
		{
			this.enabled = enabled;
			this.name= name;
			this.pin= pin;
		}
		@Override
		public String toString()
		{
			return String.format("{enabled:%b,name:%s,pin:%s}",enabled, name, pin);
		}
    }

    class WifiAccess {
    	@Expose private boolean enabled;
    	@Expose private String ip;
    	@Expose private String ssid;
    	@Expose private String password;
    	
		public WifiAccess(boolean enabled, String ip, String ssid, String password)
		{
			this.enabled = enabled;
			this.ip = ip;
			this.ssid = ssid;
			this.password = password;
		}
		@Override
		public String toString()
		{
			return String.format("{enabled:%b,ip:%s,ssid:%s,password:%s}",
					enabled, ip, ssid, password);
		}
    }
    class GsmAccess {
    	@Expose private boolean enabled;
    	
		public GsmAccess(boolean enabled)
		{
			this.enabled = enabled;
		}
		@Override
		public String toString()
		{
			return String.format("{enabled:%b}",enabled);
		}
    }
    class IpAccess {
    	@Expose private boolean enabled;
    	
		public IpAccess(boolean enabled)
		{
			this.enabled = enabled;
		}
		@Override
		public String toString()
		{
			return String.format("{enabled:%b}",enabled);
		}
    }
	@Override
	public String toString()
	{
		return String.format("{bluetooth:%s,wifi:%s,gsm:%s,ip_%s}", bluetooth, wifi, gsm, ip);
	}

    
}
