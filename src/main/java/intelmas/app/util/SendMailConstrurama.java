package intelmas.app.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SendMailConstrurama {	
	
	public static final String RED_CONSTRURAMA = "Unete a la Red Construrama";
	public static final String CONTACTO_CONSTRURAMA="Contacto Construrama";
	public static final String ID_CONTACT_CONSTRURAMA="contact";
	public static final String ID_JOINUP_CONSTRURAMA="joinup";
	
	private String template;
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	private String base_document_joinup = "<!doctype html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <title></title>\r\n" + 
			"  <base href=\"/\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"</head>\r\n" + 
			"<body style=\"padding: 100px; background: #DCDCDC; height: 1000px;\">\r\n" + 
			"\r\n" + 
			"<div class='container-fluid padding' style=\"width: 100%; padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto; \r\n" + 
			"										padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px\">\r\n" + 
			"	<div class='row welcome text-center'  style=\"background: #DCDCDC; width: 800px; margin: 0 auto; padding-top: 2rem;\">\r\n" + 
			"		<div class='col-12 titleCons' style=\"padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px; \r\n" + 
			"										background: #FF640C;\">\r\n" + 
			"			<h1 style=\"font-size:40px; text-align: center; font-family:Arial, Helvetica, sans-serif;\">$idtienda</h1>		\r\n" + 
			"		</div>\r\n" + 
			"		</div>\r\n" + 
			"			<hr class='my-4'></hr>\r\n" + 
			"		</div>\r\n" + 
			"		<div style=\"width: 1000px; padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px;\">\r\n" + 
			"		\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">NOMBRE*</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$nombre</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">CORREO ELECTRONICO*</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$email</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">¿Actualmente ya comercializas material para la construcci&oacute;n?</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$comercializas</h2>\r\n" + 
			"			</div>;\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">CUIDAD</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$ciudad</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">ESTADO</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$estado</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">C&Oacute;DIGO POSTAL</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$cp</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">TEL&Eacute;FONO</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$telefono</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">MENSAJE*</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$mensaje</h2>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"		</div>\r\n" + 
			"			<hr class='my-4'></hr>\r\n" + 
			"	</div>\r\n" + 
			"	</div>\r\n" + 
			"</div>\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n";
	
	private String base_document_contact = "<!doctype html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <title>Construrama</title>\r\n" + 
			"  <base href=\"/\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"</head>\r\n" + 
			"<body style=\"padding: 100px; background: #DCDCDC; height: 1000px;\">\r\n" + 
			"\r\n" + 
			"<div class='container-fluid padding' style=\"width: 100%; padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto; \r\n" + 
			"										padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px\">\r\n" + 
			"	<div class='row welcome text-center'  style=\"background: #DCDCDC; width: 800px; margin: 0 auto; padding-top: 2rem;\">\r\n" + 
			"		<div class='col-12 titleCons' style=\"padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px; \r\n" + 
			"										background: #FF640C;\">\r\n" + 
			"			<h1 style=\"font-size:40px; text-align: center; font-family:Arial, Helvetica, sans-serif;\">$idtienda</h1>		\r\n" + 
			"		</div>\r\n" + 
			"		</div>\r\n" + 
			"			<hr class='my-4'></hr>\r\n" + 
			"		</div>\r\n" + 
			"		<div style=\"width: 1000px; padding-top: 20px; padding-right: 20px; padding-bottom: 20px; padding-left: 20px;\">\r\n" + 
			"		\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">NOMBRE*</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 400; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$nombre</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">CORREO ELECTRONICO*</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$email</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">TEL&Eacute;FONO</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$telefono</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">CUIDAD</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$ciudad</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">ESTADO</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$estado</h2>\r\n" + 
			"			</div>\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">Asunto</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$asunto</h2>\r\n" + 
			"			</div>			\r\n" + 
			"			<div class='col-12'>\r\n" + 
			"				<p class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">MENSAJE*</p>\r\n" + 
			"				<h2 class='lead' style=\"font-weight: 200; font-family:Arial, Helvetica, sans-serif; text-align: left;\">$mensaje</h2>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"		</div>\r\n" + 
			"			<hr class='my-4'></hr>\r\n" + 
			"	</div>\r\n" + 
			"	</div>\r\n" + 
			"</div>\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n";
	
	public String buildingHTMLMailArray(String mailId, String data) throws Exception {
		String htmlDoc = "";
		String[] dataHtml = null;
		Stream<String> stream = null;
		final Map<String, String> variables = new HashMap<String, String>();
		try {
			if(data != null) {
				dataHtml =data.split(",");
			}
			if(dataHtml != null) {
				stream = Arrays.stream(dataHtml);
				stream.forEach(var ->{
					if(var.indexOf(":")!= -1)
						variables.put(var.substring(0, var.indexOf(":")), var.substring(var.indexOf(":")+1));
				});
			}
			htmlDoc = getHTMLDocument(mailId, variables).toString();
		}catch(Exception ex) {
			throw ex;
		}
		return htmlDoc;
	}
	
	public StringBuffer getHTMLDocument(String mailId, Map<String, String> items) throws Exception{
		StringBuffer stringbuffer = new StringBuffer();
		if(mailId != null && mailId.equalsIgnoreCase(ID_CONTACT_CONSTRURAMA)) {
			setTemplate(base_document_contact);
			setTemplate(getTemplate().replace("$idtienda", CONTACTO_CONSTRURAMA));
		}
		if(mailId != null && mailId.equalsIgnoreCase(ID_JOINUP_CONSTRURAMA)) {
			setTemplate(base_document_joinup);
			setTemplate(getTemplate().replace("$idtienda", RED_CONSTRURAMA));
		}
		if(items!= null) {
			items.forEach((k, v) ->{	
				if(k.indexOf("'nombre'")!=-1) {
					setTemplate(getTemplate().replace("$nombre", v));
				}
				if(k.indexOf("'email'")!=-1) {
					setTemplate(getTemplate().replace("$email", v));
				}
				if(mailId.equals(ID_JOINUP_CONSTRURAMA) && k.indexOf("'comercializas'")!=-1) {
					setTemplate(getTemplate().replace("$comercializas", v));
				}
				if(k.indexOf("'ciudad'")!=-1) {
					setTemplate(getTemplate().replace("$ciudad", v));
				}
				if(k.indexOf("'estado'")!=-1) {
					setTemplate(getTemplate().replace("$estado", v));
				}
				if(mailId.equals(ID_JOINUP_CONSTRURAMA) && k.indexOf("'cp'")!=-1) {
					setTemplate(getTemplate().replace("$cp", v));
				}
				if(k.indexOf("'telefono'")!=-1) {
					setTemplate(getTemplate().replace("$telefono", v));
				}
				if(mailId.equals(ID_CONTACT_CONSTRURAMA) && k.indexOf("'asunto'")!=-1) {
					setTemplate(getTemplate().replace("$asunto", v));
				}
				if(k.indexOf("'mensaje'")!=-1) {
					setTemplate(getTemplate().replace("$mensaje", v));
				}
			}); 
		}
		stringbuffer.append(getTemplate());		
		return stringbuffer;
	}

}
