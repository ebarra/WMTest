package es.agora.proto4.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import es.agora.proto4.fakeandroid.Context;
import es.agora.proto4.fakeandroid.Log;
import es.agora.proto4.fakeandroid.MainActivity;
import es.agora.proto4.protocol.common.WMJsonParser;

public class LicenseManager
{
	private static final String FICHERO_LICENCIAS = "licencias.txt";

	private List<License> licenses;
	
	private static LicenseManager instance= null;
	
	public synchronized static LicenseManager getInstance()
	{
		if (instance == null)
		{
			instance= new LicenseManager();		

		}
		return instance;
	}
	
	
	private LicenseManager()
	{
		licenses= new ArrayList<License>();
	}
	
	public boolean isEmpty()
	{
		return licenses.isEmpty();
	}
		
	public List<License> getLicenses()
	{
		return licenses;
	}

	public void setLicenses(List<License> licenses)
	{
		this.licenses= licenses;
	}

	public void readLicenseFile(Context ctx)
	{
		try
		{
			FileInputStream fis= ctx.openFileInput(FICHERO_LICENCIAS);
			
			InputStreamReader isr= new InputStreamReader(fis);

			BufferedReader inputReader = new BufferedReader(isr);

			String inputString;
			StringBuffer stringBuffer = new StringBuffer();                

			while ((inputString = inputReader.readLine()) != null)
			{
				stringBuffer.append(inputString + "\n");
			}
			inputReader.close();

			//Log.v(MainActivity.TAG, "FICHERO leido: " + stringBuffer);
			
			String json= stringBuffer.toString();
			
			//Log.v("Licenses",json);
			
			List<License> licenses= WMJsonParser.parseLicenses(json);

			if (licenses != null)
			{
				Log.v(MainActivity.TAG, "LICENCIAS parseadas");

				this.licenses= licenses;
			}
			
			// Log.d(MainActivity.TAG, "\"" + WMJsonParser.toJson(licenses)+"\"");
		}
		catch (IOException e)
		{
			Log.v(MainActivity.TAG, "NO HAY FICHERO DE LICENCIAS");
		}
	}

	public void writeLicenseFile(Context ctx)
	{
        try
        {
    		String json=  WMJsonParser.toJson(licenses);
    		
        	FileOutputStream fos = ctx.openFileOutput(FICHERO_LICENCIAS, Context.MODE_PRIVATE);

        	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(json);
            outputStreamWriter.close();
        }
        catch (IOException e)
        {
            Log.e(MainActivity.TAG, "File write failed: " + e.toString());
        }

	}

}
