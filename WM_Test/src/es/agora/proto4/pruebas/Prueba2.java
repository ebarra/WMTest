package es.agora.proto4.pruebas;
import java.util.List;

import es.agora.proto4.model.License;
import es.agora.proto4.protocol.common.WMJsonParser;

public class Prueba2
{
	public static void main(String[] args)
	{
		String json= "[{\"building\":{\"accesses\":[{\"name\":\"garage acc111\",\"gateIds\":[1],\"accessId\":1},{\"name\":\"ocio acc113\",\"gateIds\":[4],\"accessId\":3},{\"name\":\"salida acc112\",\"gateIds\":[2,3],\"accessId\":2}],\"name\":\"Madrid11\",\"mtxes\":[{\"config\":{\"bluetooth\":{\"name\":\"bn_mtx111\",\"pin\":\"bp_mtx111\",\"enabled\":false},\"gsm\":{\"enabled\":false},\"ip\":{\"enabled\":true},\"wifi\":{\"ip\":\"1.1.1.1\",\"password\":\"12345678901234567890123456789012\",\"ssid\":\"ssid11\",\"enabled\":false}},\"gates\":[{\"name\":\"g1111\",\"mtxRele\":\"1\",\"gateId\":1,\"enabled\":true},{\"name\":\"g1112\",\"mtxRele\":\"2\",\"gateId\":2,\"enabled\":true}],\"name\":\"mtx111\",\"mtxId\":1},{\"config\":{\"bluetooth\":{\"name\":\"bn_mtx112\",\"pin\":\"bp_mtx112\",\"enabled\":false},\"gsm\":{\"enabled\":false},\"ip\":{\"enabled\":true},\"wifi\":{\"ip\":\"1.1.1.1\",\"password\":\"12345678901234567890123456789012\",\"ssid\":\"ssid11\",\"enabled\":false}},\"gates\":[{\"name\":\"g1121\",\"mtxRele\":\"1\",\"gateId\":3,\"enabled\":true},{\"name\":\"g1122\",\"mtxRele\":\"2\",\"gateId\":4,\"enabled\":true}],\"name\":\"mtx112\",\"mtxId\":2}],\"buildingId\":1},\"name\":\"l113\",\"licenseId\":3,\"active\":false},{\"building\":{\"accesses\":[{\"name\":\"entrada acc211\",\"gateIds\":[6],\"accessId\":5},{\"name\":\"salida acc212\",\"gateIds\":[7],\"accessId\":6}],\"name\":\"Burgos21\",\"mtxes\":[{\"config\":{\"bluetooth\":{\"name\":\"bn_mtx211\",\"pin\":\"bp_mtx211\",\"enabled\":false},\"gsm\":{\"enabled\":false},\"ip\":{\"enabled\":true},\"wifi\":{\"ip\":\"1.1.1.1\",\"password\":\"12345678901234567890123456789012\",\"ssid\":\"ssid11\",\"enabled\":false}},\"gates\":[{\"name\":\"g2111\",\"mtxRele\":\"1\",\"gateId\":6,\"enabled\":true},{\"name\":\"g2112\",\"mtxRele\":\"2\",\"gateId\":7,\"enabled\":true}],\"name\":\"mtx211\",\"mtxId\":4}],\"buildingId\":3},\"name\":\"l211\",\"licenseId\":11,\"active\":false}]";
		
		List<License> licenses= WMJsonParser.parseLicenses(json);
		
		System.out.println("He conseguido:");
		System.out.println(WMJsonParser.toJson(licenses));
	}

}
