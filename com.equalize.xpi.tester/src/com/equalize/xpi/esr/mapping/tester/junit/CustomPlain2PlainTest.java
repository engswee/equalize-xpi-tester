package com.equalize.xpi.esr.mapping.tester.junit;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.equalize.xpi.esr.mapping.tester.MappingJavaTester;
import com.equalize.xpi.tester.util.ResultHelper;
import com.sap.aii.mapping.api.StreamTransformationException;

public class CustomPlain2PlainTest {

	@Test
	public void testScenario() throws UnsupportedEncodingException, StreamTransformationException {
		String className = "com.equalize.xpi.esr.mapping.CustomPlain2Plain";
		String inputFile = "TestData/Mapping/Java/Abstract/InputPlain.txt";
		String resultFile = "TestData/Mapping/Java/Abstract/Output_CustomPlain2Plain.txt";
		String results = ResultHelper.newInstance(resultFile).getResultContent();
		MappingJavaTester tester = MappingJavaTester.newInstance(className, inputFile);
		
		assertEquals("Error", results, tester.execute());		
	}
}
