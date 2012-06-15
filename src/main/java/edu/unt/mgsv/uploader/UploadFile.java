package edu.unt.mgsv.uploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import edu.unt.mgsv.client.MGSVService;
import edu.unt.mgsv.client.MGSVServiceService;

public class UploadFile {
	public static void main(String[] args) throws Exception {
		
		
		
		if (args.length < 1){
			System.out.println("Running a demo mode with a.gz and s.gz in current dir if they exist");
			args = new String[]{"s.gz", "a.gz"};			
			
		}
			

		String synteny = fileToString(new File(args[0]));
		String annotation = null;
		String email = null;

		if (args.length > 1) {
			annotation = fileToString(new File(args[1]));;
		}

		if (args.length > 2) {
			email = args[2];
		}

		MGSVServiceService service = new MGSVServiceService();
		MGSVService impl = service.getMGSVServicePort();

		System.out.println(impl.uploadData(synteny, annotation, email));

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
