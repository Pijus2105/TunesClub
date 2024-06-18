package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	//Intialized properties. Private because properties can be access only this class
		private final Properties properties;
		
		//Create a no args constructor
		public ConfigFileReader() {
			
			//Will be read from fileread
			BufferedReader buffer;
			FileReader fileread;
			String property = "C:\\Users\\Elphill\\eclipse-workspace\\TunesClub\\Config\\configuration.properties";
			
			try {
				fileread = new FileReader(property);
				buffer = new BufferedReader(fileread);
				properties = new Properties();
				
				try {
					properties.load(buffer);
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
					//It makes it difficult for the calling code to catch it. so if any difficulties of the path. it can handle
					throw new RuntimeException("configuration.properties not found at " + property);
				}
			}
		
		//Create method for URL
		public String getUrl() {
			String URL = properties.getProperty("url");
			
			if(URL != null) return URL;
			
			else {
				 throw new RuntimeException("timeout not specified in the config file.");
			}
		}
		
		
		
		//Create method for timeout
			public long getTime() {
				String timeout = properties.getProperty("timeout");
				
				if(timeout != null) {
					return Long.parseLong(timeout);
				} else {
					 throw new RuntimeException("timeout not specified in the config file.");
				}
				
			}
			
			
			//Create method for getBrowser
			public DriverType getBrowser() {
				
				String browserName = properties.getProperty("browser");
				
				switch (browserName) {
				
				case "chrome":
					return DriverType.CHROME;
				
				
				
				case "FireFox":
					return DriverType.FIREFOX;
					
				 default:
		                throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
				}
			}
			
			//Create method for getEnvironment
			
			public EnvironmentType getEnvironment() {
				String environment = properties.getProperty("environment");
				
				switch(environment) {
									
				case "local":
				   return EnvironmentType.lOCAL;
				case "remote":
					   return EnvironmentType.REMOTE;
				
				   
				default:
	                throw new RuntimeException("Environment type key value in configuration file is not matched: " + environment);
				}
			}
		}
		

	/* a.) Buffereader - It is used to read characters from any type of character input stream
	 * b.) Filereader - It can be used only for reading files
	 */