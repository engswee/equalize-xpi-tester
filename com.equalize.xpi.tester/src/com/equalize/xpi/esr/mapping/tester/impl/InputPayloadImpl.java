package com.equalize.xpi.esr.mapping.tester.impl;

import java.io.InputStream;

import com.sap.aii.mapping.api.InputPayload;

public class InputPayloadImpl extends InputPayload {
	InputStream in;

	public InputPayloadImpl(InputStream in) {
		this.in = in;
	}
	@Override
	public InputStream getInputStream() {
		return this.in;
	}
}