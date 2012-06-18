package edu.unt.mgsv.uploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.GZIPInputStream;

import javax.xml.ws.BindingProvider;

import edu.unt.mgsv.client.MGSVService;
import edu.unt.mgsv.client.MGSVServiceService;
import edu.unt.mgsv.client.WSDLLocation;

public class UploadFile {
	public static void main(String[] args) throws Exception {

		if (args.length < 1) {
			System.out.println("Running a demo mode with a.gz and s.gz in current dir if they exist");
			args = new String[] { "s.gz", "a.gz" };

		}
		
		String remote = null ;
		String wsdl = null;
		
		
		// Alternate remote url if it exists
		if (new File("config.properties").exists()) {
			Properties config = new Properties();
			config.load(new FileInputStream("config.properties"));
			remote = config.getProperty("remote");
			wsdl = config.getProperty("wsdl");			
		}		
		
		if(wsdl != null){
			WSDLLocation.WSDL = wsdl;
		}	
		
		MGSVServiceService service = new MGSVServiceService();
		MGSVService impl = service.getMGSVServicePort();
		
		
		if(remote != null){
			((BindingProvider) impl).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, remote);
		}

		
		

		String result = "-1";

		if (args[0].startsWith("http")) {
			// URL
			String synteny = args[0];
			String annotation = (args.length > 1) ? args[1] : null;
			String email = (args.length > 2) ? args[2] : null;

			result = impl.uploadURL(synteny, annotation, email);

		} else {
			// File
			String synteny = fileToString(new File(args[0]));
			String annotation = null;
			String email = null;

			if (args.length > 1) {
				annotation = fileToString(new File(args[1]));;
			}

			if (args.length > 2) {
				email = args[2];
			}

			result = (impl.uploadData(synteny, annotation, email));
		}

		System.out.println(result);

	}

	private static String fileToString(File file) throws Exception {
		final InputStream in;
		final String fileName = file.getName();

		if (fileName.endsWith(".gz")) {
			in = new GZIPInputStream(new FileInputStream(file));
		} else {
			in = new FileInputStream(file);
		}

		StringBuffer buffer = new StringBuffer();

		byte data[] = new byte[1024];
		int lastRead = 0;
		while ((lastRead = in.read(data)) != -1) {
			buffer.append(new String(data, 0, lastRead, "utf-8"));
		}

		in.close();
		return buffer.toString();

	}
}
