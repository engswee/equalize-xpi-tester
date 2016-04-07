package com.equalize.xpi.af.modules.tester;

import java.util.Hashtable;

import com.equalize.xpi.tester.util.ParameterHelper;

public class ModuleTesterMain {

	public static void main(String[] args) {
		try {
			// Default files
			String inputFile = "TestData/Module/input.txt";
			String paramFile = "TestData/Module/parameter.txt";
			String outFile = "TestData/Module/output.txt";
			
			// Module to be tested
			String module = "com.equalize.xpi.af.modules.CustomModuleBean";

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
