package intelmas.app.retriever.test;

import java.net.URLDecoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsMatch {
	
	public static final String EXAMPLE_TEST = "Pablo   ";
//            + "string which I'm going to " + "use for pattern matching. opASDJKjl#.-,;7&&&3%%{}[?'{}{}";
	/*public static final String EXAMPLE_TEST = "This is my small example, mi acción, comprensión "
            + "string which I'm going to " + "use for pattern matching. opASDJKjl#.-,;7&&&3%%{}[?'{}{}";*/
	public static void main(String[] args) {
		
	    System.out.println("A101: "+verifyString(EXAMPLE_TEST));
	    System.out.println("\n--------------------------------------------------------");
	    System.out.println("100: "+verifyPattern(EXAMPLE_TEST));
	    
	  }
	
	private static String verifyString(String cad) {		
		String res= "";
		try {
//			String pattern = "[^a-zA-Z0-9 ]*";
//			String pattern = "[^A-Za-z0-9áéíóú ]*$";
			String pattern = "[^A-Za-z0-9áéíóú ]*";
			
//			System.out.println("A100: "+cad.replaceAll(pattern, "")+"\n");
			 res = cad.replaceAll(pattern, "");
		     res = URLDecoder.decode(res, "UTF-8");
		}catch(Exception ex) {
		    	System.out.println("Errir in: "+ex.getMessage());
		}
		return res;
	}
	
	public static String verifyPattern(String cad) {
		Boolean res = false;
		String res1 = "";
		{
//			final Pattern p = Pattern.compile("[^a-zA-Z0-9 ]*");
			final Pattern p = Pattern.compile("^[a-zA-Z0-9áéíóú ]*$");
			final Matcher m = p.matcher(cad);
			res = m.matches();
			System.out.println("IS ok: "+res.toString().replaceAll("", arg1));
			res1 =m.replaceAll("");
		}
		return res1;
	}
	
}
