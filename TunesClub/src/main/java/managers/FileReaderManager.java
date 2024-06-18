package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {

	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

//	private FileReaderManager() {
//	}

	 public static FileReaderManager getInstance() {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }

	
}



/* It is the singleton object class. All class object would be create there
 */
