package com.evoke.cleancode.advanced.others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class FreeResources {

	
	public static void main(String args[]) throws IOException, URISyntaxException {
		String str = "";
		URLConnection conn 
		= new URL("http://norvig.com/big.txt").openConnection();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

		while (br.readLine() != null) {
			str += br.readLine();
		} 

		//
		
//		try (BufferedReader br1 = new BufferedReader(
//				new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
//			// further implementation
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	private static void printFileJava7() throws IOException {
//	    try(FileInputStream input = new FileInputStream("bigFile.txt")) {
//	        int data = input.read();
//	        while(data != -1){
//	            System.out.print((char) data);
//	            data = input.read();
//	        }
//	    }

	
	}

}
