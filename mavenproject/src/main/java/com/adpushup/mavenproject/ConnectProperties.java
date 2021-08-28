package com.adpushup.mavenproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectProperties {
		

	private static Properties props;

	static {
		String dir = System.getProperty("user.dir");
		File file = new File(dir+ "/src/main/resources/config.properties");
		FileInputStream is = null;
		try {
			props = new Properties();
			 is = new FileInputStream(file);
		//	is = ClassLoader.class.getResourceAsStream("/Config.properties");
			props.load(is);
		} catch (IOException exep) {
			exep.printStackTrace();
		}
	}
	
	
	
/*	static {
		// connect property file
				InputStream is = null;
				try {
					props = new Properties();
					is = ClassLoader.class.getResourceAsStream("/Config.properties");
					//is = ClassLoader.class.getResourceAsStream("/Dev-Env-Config.properties");
					//is = ClassLoader.class.getResourceAsStream("/Staging-Env-Config.properties");
					//is = ClassLoader.class.getResourceAsStream("/QA-Env-Config.properties");
					props.load(is);
				} catch (IOException exep) {
					exep.printStackTrace();
				}
			} */
	
	public static String getConnectProperty(String key){
        return props.getProperty(key);
    }

	}



