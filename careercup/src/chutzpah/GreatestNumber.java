package chutzpah;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class GreatestNumber {

	public static void main(String[] args) {
		
//		// Create a new trust manager that trust all certificates
//		TrustManager[] trustAllCerts = new TrustManager[]{
//		    new X509TrustManager() {
//		        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//		            return null;
//		        }
//		        public void checkClientTrusted(
//		            java.security.cert.X509Certificate[] certs, String authType) {
//		        }
//		        public void checkServerTrusted(
//		            java.security.cert.X509Certificate[] certs, String authType) {
//		        }
//		    }
//		};
//
//		// Activate the new trust manager
//		try {
//		    SSLContext sc = SSLContext.getInstance("SSL");
//		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
//		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//		} catch (Exception e) {
//		}
		
		try {
//			URL url = new URL("https://labs.siddharthgoel.com/randomdata/"
//					+ "set1-random-2-power-30-longs.txt");
			Scanner s = new Scanner(new File("numbers.txt"));
			
			long max = Long.MIN_VALUE;
			
			long startTime = System.currentTimeMillis();
			while(s.hasNext()) {
				long number = s.nextLong();
				if (max < number) {
					max = number;
				}
			}
			long endTime = System.currentTimeMillis();
			
			System.out.println("Biggest number is " + max);
			System.out.println("Time taken = " + ( (endTime-startTime)/1000) + " seconds");
			
			s.close();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
