package com.equalize.xpi.esr.mapping.tester.impl;

import com.sap.aii.mapping.api.InputAttachments;
import com.sap.aii.mapping.api.InputHeader;
import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.api.InputPayload;
import com.sap.aii.mapping.api.TransformationInput;

public class TransformationInputImpl  extends TransformationInput {

	InputPayload payload;

	public TransformationInputImpl(InputPayload payload) {
		this.payload = payload;
	}

	@Override
	public InputAttachments getInputAttachments() {
		return null;
	}

	@Override
	public InputHeader getInputHeader() {
		return null;
	}

	@Override
	public InputParameters getInputParameters() {
		return null;
	}

	@Override
	public InputPayload getInputPayload() {
		return this.payload;
	}
}