package es.agora.proto4.fakeandroid;

public class Log
{

	public static void v(String tag, String string)
	{
		System.out.println("V " + tag + ": " + string);
	}

	public static void e(String tag, String string)
	{
		System.out.println("E " + tag + ": " + string);
	}

}
