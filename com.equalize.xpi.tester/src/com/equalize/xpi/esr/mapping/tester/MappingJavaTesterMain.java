package com.equalize.xpi.esr.mapping.tester;

public class MappingJavaTesterMain {
	public static void main(String[] args) {
		try {
			// Sample arguments:-
			// arg0 - com.equalize.xpi.esr.mapping.CustomPlain2Plain
			// arg1 - TestData/Mapping/Java/Abstract/InputPlain.txt
			// arg2 - C:\Users\ksap086\Desktop\output.txt
			if(args.length < 3)
				throw new RuntimeException("Please enter arguments in Run Configuration");
			String mappingClass = args[0];
			String inputFile = args[1];
			String outputFile = args[2];

			MappingJavaTester tester = MappingJavaTester.newInstance(mappingClass, inputFile);
			tester.execute(outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}


