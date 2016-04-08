package com.equalize.xpi.esr.mapping.tester;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.equalize.xpi.esr.mapping.tester.impl.InputPayloadImpl;
import com.equalize.xpi.esr.mapping.tester.impl.OutputPayloadImpl;
import com.equalize.xpi.esr.mapping.tester.impl.TransformationInputImpl;
import com.equalize.xpi.esr.mapping.tester.impl.TransformationOutputImpl;
import com.equalize.xpi.util.converter.Converter;
import com.sap.aii.mapping.api.AbstractTransformation;
import com.sap.aii.mapping.api.StreamTransformationException;

public class MappingJavaTester {

	private final AbstractTransformation transformation;
	private final String fileName;
	private TransformationInputImpl transformIn;
	private TransformationOutputImpl transformOut;
	
	public static MappingJavaTester newInstance(String className, String fileName) {
		return new MappingJavaTester(className, fileName);
	}

	private MappingJavaTester(String className, String fileName) {
		try {
			this.fileName = fileName;
			Class<?> mappingClass = Class.forName(className);
			this.transformation = (AbstractTransformation) mappingClass.getConstructor().newInstance();
			initialize();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void initialize() throws IOException {
		// Get the input payload
		InputStream inpStr = new FileInputStream(new File(this.fileName)); 
		OutputStream outStr = new ByteArrayOutputStream();
		// Set the input and output to the transformation in/out
		this.transformIn = new TransformationInputImpl(new InputPayloadImpl(inpStr));
		this.transformOut = new TransformationOutputImpl(new OutputPayloadImpl(outStr));
	}

	public void execute(String outputFile) throws StreamTransformationException, IOException {
		// Execute mapping logic
		this.transformation.transform(this.transformIn, this.transformOut);
		
		ByteArrayOutputStream baos = (ByteArrayOutputStream) this.transformOut.getOutputPayload().getOutputStream();
		FileOutputStream fileOutStr = new FileOutputStream(new File(outputFile));
		baos.writeTo(fileOutStr);
		fileOutStr.close();
	}
	
	public String execute() throws StreamTransformationException, UnsupportedEncodingException {
		// Execute mapping logic
		this.transformation.transform(this.transformIn, this.transformOut);
		
		ByteArrayOutputStream baos = (ByteArrayOutputStream) this.transformOut.getOutputPayload().getOutputStream();
		return Converter.toString(baos.toByteArray());
	}
}
