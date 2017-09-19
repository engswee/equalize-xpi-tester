package com.equalize.xpi.esr.mapping;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sap.aii.mapping.api.AbstractTransformation;
import com.sap.aii.mapping.api.StreamTransformationException;
import com.sap.aii.mapping.api.TransformationInput;
import com.sap.aii.mapping.api.TransformationOutput;

public class CustomPlain2Plain extends AbstractTransformation {

	@Override
	public void transform(TransformationInput input, TransformationOutput output)
			throws StreamTransformationException {
	
		InputStream is = input.getInputPayload().getInputStream();
		OutputStream os = output.getOutputPayload().getOutputStream();
		try {		
			// Read input plain file
			LineNumberReader br = new LineNumberReader(new InputStreamReader(is));		
			String lineContent;
			ArrayList<String> contents = new ArrayList<String>(10);
			while ((lineContent = br.readLine()) != null) {
				contents.add(lineContent);
			}
			br.close();
			
			StringBuilder sb = new StringBuilder(); 
			int count = 0;			
			for (String line : contents) {
				if (count == 0) {
					sb.append("HD");
				} else if (count == contents.size()-1) {
					sb.append("FT");
				} else {
					sb.append("IT");
				}
				sb.append(line);
				sb.append("\n");
				count++;
			}
			os.write(sb.toString().getBytes("UTF-8"));
			
		} catch (Exception e) {
			throw new StreamTransformationException("Mapping Exception: " + e.getMessage(), e);
		}	
	}
}
