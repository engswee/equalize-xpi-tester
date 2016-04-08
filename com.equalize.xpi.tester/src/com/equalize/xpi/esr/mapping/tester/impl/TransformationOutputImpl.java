package com.equalize.xpi.esr.mapping.tester.impl;

import com.sap.aii.mapping.api.OutputAttachments;
import com.sap.aii.mapping.api.OutputHeader;
import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mapping.api.OutputPayload;
import com.sap.aii.mapping.api.TransformationOutput;

public class TransformationOutputImpl extends TransformationOutput {

	OutputPayload payload;

	public TransformationOutputImpl(OutputPayload payload) {
		this.payload = payload;
	}
	@Override
	public void copyInputAttachments() {
	}
	@Override
	public OutputAttachments getOutputAttachments() {
		return null;
	}
	@Override
	public OutputHeader getOutputHeader() {
		return null;
	}
	@Override
	public OutputParameters getOutputParameters() {
		return null;
	}
	@Override
	public OutputPayload getOutputPayload() {
		return this.payload;
	}
}