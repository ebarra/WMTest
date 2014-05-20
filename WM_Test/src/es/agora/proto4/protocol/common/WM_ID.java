package es.agora.proto4.protocol.common;

public enum WM_ID
{
	// Server-Mobile Registering Protocol
	WMR0_RServerError,
	WMR2_RSMSRequest,
	WMR3_RegisterSuccess,
	
	// Server-Mobile License Update Protocol
	WMU0_UServerError,
	WMU2_UUpdateSuccess,
	
	// Widget Gate Opening Protocol
	WMG0_GServerError,
	WMG2_GOpenSuccess;
}
