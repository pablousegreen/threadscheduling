package intelmas.app.retriever.test;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.json.JSONObject;

public class App {	
	
	private String documentoParse = "<!doctype html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <title>FrontConnections</title>\r\n" + 
			"  <base href=\"/\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<style type='text/css'>\r\n" + 
			".display4{\r\n" + 
			"		font-size:800px;\r\n" + 
			"	}\r\n" + 
			".welcome {\r\n" + 
			"	background: #DCDCDC;\r\n" + 
			"	 width: 800px;\r\n" + 
			"	 margin: 0 auto;\r\n" + 
			"	 padding-top: 2rem;\r\n" + 
			"}\r\n" + 
			".welcome .titleCons{\r\n" + 
			"	  background: linear-gradient(to right, #FF640C 50%, #FF640C 50%);\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".welcome .titleCons h1{\r\n" + 
			"	color: #FFFFFF;\r\n" + 
			"	font-weight: 400;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".welcome p {\r\n" + 
			"	z-index: 100;\r\n" + 
			"	font-weight: 400;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".welcome h2 {\r\n" + 
			"	font-weight: 200;\r\n" + 
			"}\r\n" + 
			"</style>\r\n" + 
			"<div class='container-fluid padding' style=\"padding: 100px; background: #DCDCDC;\">\r\n" + 
			"	<div class='row welcome text-center' style=\text-align: center;  width: 800px; margin: 0 auto; padding-left: 2rem; position: relative;\">\r\n" + 
			"		<div class='col-12 titleCons' style=\"background: #FF640C;\">\r\n" + 
			"			<h1 class='display-4' style=\"font-size:300%; font-family:Arial, Helvetica, sans-serif; transform: translate(-50%, -50%);\">Unete a la Red Construrama.</h1>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead'style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">NOMBRE*</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$nombre</h2>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">CORREO ELECTRONICO*</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$email</h2>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">¿Actualmente ya comercializas material para la construcci&oacute;n?</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$comercializas</h2>\r\n" + 
			"		</div>;\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead'style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">CUIDAD</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$ciudad</h2>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">ESTADO</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$estado</h2>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">C&Oacute;DIGO POSTAL</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$cp</h2>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">TEL&Eacute;FONO</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$telefono</h2>\r\n" + 
			"		</div>\r\n" + 
			"		<div class='col-12'>\r\n" + 
			"			<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; left: 50%;\">MENSAJE*</p>\r\n" + 
			"			<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; left: 50%;\">$mensaje</h2>\r\n" + 
			"		</div>\r\n" + 
			"		</div>\r\n" + 
			"			<hr class='my-4'></hr>\r\n" + 
			"	</div>\r\n" + 
			"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
			"	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\r\n" + 
			"	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n" + 
			"</body>\r\n" + 
			"</html>";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public String buildingHTMLMail(String data) {
		String dataHtml = "document:{"+data+"}";
		System.out.println("2000: "+dataHtml);
		Map<String, String> variables = null;
		try {
//	        Object obj = new JSONParser().parse(dataHtml); 
	        // typecasting obj to JSONObject 
	        JSONObject jo = new JSONObject(dataHtml);  
	        System.out.println("20001: "+jo);
	        String nombre = (String) jo.get("nombre"); 
	        System.out.println("nombre: "+nombre);
	        String email = (String) jo.get("email");
	        System.out.println("email: "+email);
	        String comercializas = (String) jo.get("comercializas"); 
	        System.out.println("comercializas: "+comercializas); 
	        String ciudad = (String) jo.get("ciudad");
	        System.out.println("ciudad: "+ciudad);
	        String estado = (String) jo.get("estado"); 
	        System.out.println("estado: "+estado); 
	        String cp = (String) jo.get("cp");
	        System.out.println("cp: "+cp);
	        String telefono = (String) jo.get("telefono"); 
	        System.out.println("telefono: "+telefono);
	        String mensaje = (String) jo.get("mensaje");	          
	        System.out.println("mensaje: "+mensaje); 
	        variables = new HashMap<String, String>();
	        variables.put("nombre", nombre);
	        variables.put("email", email);
	        variables.put("comercializas", comercializas);
	        variables.put("ciudad", ciudad);
	        variables.put("estado", estado);
	        variables.put("cp", cp);
	        variables.put("telefono", telefono);
	        variables.put("mensaje", mensaje);
	        getHTMLDocument(variables);
		}catch(Exception ex) {
			
		}
		return dataHtml;
	}
	
	public String buildingHTMLMailArray(String data) {
		String htmlDoc = "";
		String[] dataHtml = null;
		Stream<String> stream = null;
//		System.out.println("2000: "+data);
		final Map<String, String> variables = new HashMap<String, String>();
		try {
			if(data != null) {
				dataHtml =data.split(",");
			}
			if(dataHtml != null) {
				stream = Arrays.stream(dataHtml);
				//'nombre': 'GOROASNDAKS191'				
				stream.forEach(var ->{
					if(var.indexOf(":")!= -1)
						variables.put(var.substring(0, var.indexOf(":")), var.substring(var.indexOf(":")+1));
				});
			}
			htmlDoc = getHTMLDocument(variables).toString();
		}catch(Exception ex) {
			
		}
		return htmlDoc;
	}
	
	public StringBuffer getHTMLDocument(Map<String, String> items) {
		StringBuffer stringbuffer = new StringBuffer();
//		  String newDocument = documentoParse;
		 
		if(items!= null) {
			items.forEach((k, v) ->{				
				if(k.indexOf("'nombre'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse =documentoParse.replace("$nombre", v);
				}
				if(k.indexOf("'email'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse = documentoParse.replace("$email", v);
				}
				if(k.indexOf("'comercializas'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse= documentoParse.replace("$comercializas", v);
				}
				if(k.indexOf("'ciudad'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse = documentoParse.replace("$ciudad", v);
				}
				if(k.indexOf("'estado'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse = documentoParse.replace("$estado", v);
				}
				if(k.indexOf("'cp'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse= documentoParse.replace("$cp", v);
				}
				if(k.indexOf("'telefono'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse= documentoParse.replace("$telefono", v);
				}
				if(k.indexOf("'mensaje'")!=-1) {
					System.out.println("20050: "+k + "value: "+v);
					documentoParse = documentoParse.replace("$mensaje", v);
				}
			}); 
		}
		System.out.println(documentoParse);
		stringbuffer.append(documentoParse);		
		return stringbuffer;
	}

}
