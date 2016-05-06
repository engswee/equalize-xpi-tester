package com.equalize.xpi.af.modules.tester;

import java.util.Hashtable;

import com.equalize.xpi.tester.util.ParameterHelper;

public class ModuleTesterMain {

	public static void main(String[] args) {
		try {
			// Default files
			String inputFile = "C:\\Users\\ksap086\\Desktop\\Excel2XML_Scenario1.xlsx";
			String paramFile = "C:\\Users\\ksap086\\Desktop\\Excel2XML_Scenario1_param.txt";
			String outFile = "C:\\Users\\ksap086\\Desktop\\output.txt";
			
			// Module to be tested
			String module = "com.equalize.xpi.af.modules.FormatConversionBean";

			// Get module parameters and initialize tester
			Hashtable<String, String> contextData = ParameterHelper.newInstance(paramFile).getParams();
			ModuleTester tester = ModuleTester.newInstance(module, inputFile, contextData);

			// Add dynamic configuration
			tester.addDynCfg("http://sap.com/xi/XI/System/File", "FileName", "FileA.txt");	

			// Execute processing
			tester.getDynCfg("before");
			tester.execute(outFile);
			tester.getDynCfg("after");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
