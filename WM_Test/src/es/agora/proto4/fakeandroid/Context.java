package es.agora.proto4.fakeandroid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Context
{

	public static final String MODE_PRIVATE = null;

	public static FileInputStream openFileInput(String nombreFichero)
	{
		try
		{
			return new FileInputStream(nombreFichero);
		}
		catch (FileNotFoundException e)
		{
			return null;
		}
	}

	public FileOutputStream openFileOutput(String ficheroLicencias,
			String modePrivate)
	{
		try
		{
			return new FileOutputStream(ficheroLicencias);
		} catch (FileNotFoundException e)
		{
			return null;
		}
	}

}
