package com.eventmanagement.controller;

public class GetAppTestHarnessDriver {
	public static void main(String[] args) {
	    System.out.println("\n GetAppTestHarnessDriver::main()");
	    
	    /**
	     * Here is the expected format of the supplied command line arg:  
	     *     $TEST_HARNESS_CONFIG_FILE_PATH  - The canonical path name of the Test harness config file  (eg: /scratch/test_properties.xml)
	     */
	    
	    if (args == null) {
		    System.out.println("\n args is null");
	    } else {
	    	int i = 0;
	    	for (String arg : args) {
			    System.out.println("\n arg[" + i++ + "]: " + arg);
	    	}
	    }
	    
	    /**
	     * PSEUDO CODE:
	     * 
	     * 1.  Parse the xml file
	     * 2.  Get all the config parameters about the environment and components
	     * 3.  Invoke the pertinent Test suite(s)
	     */
	}
}
