package utils;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;

public class ScenarioContext {
	
	 private Map<String, Object> scenarioContext;

        //Method will be create for set string and object skelton	 
	    public ScenarioContext(){
	        scenarioContext = new HashMap<String, Object>();
	    }

	    //Set the key for value
	    public void setContext(Context key, Object value) {
	        scenarioContext.put(key.toString(), value);
	    }

	    //Get the value
	    public Object getContext(Context key){
	        return scenarioContext.get(key.toString());
	    }

	    //Key will be contains
	    public Boolean isContains(Context key){
	        return scenarioContext.containsKey(key.toString());
	    }

}


/*
 * This class will be contains all scenario means which key will be put which value. 

    HashMap<String, Object> map=new HashMap<String, Object>();//Creating HashMap    
   map.put(1,"value");  //Put elements in Map  
   map.put(2,"value");    
   map.put(3,"value");   
   map.put(4,"value");    HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
   map.put(1,"value");  //Put elements in Map  
 
 */
