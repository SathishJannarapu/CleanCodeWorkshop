package com.evoke.cleancode.advanced.others;

import java.io.FileInputStream;
import java.io.IOException;

public class FreeResources {

	private static void printFileJava7() throws IOException {
	    try(FileInputStream input = new FileInputStream("file.txt")) {
	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	}

}
