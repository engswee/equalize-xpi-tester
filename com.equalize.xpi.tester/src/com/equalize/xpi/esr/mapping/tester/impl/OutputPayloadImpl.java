package com.equalize.xpi.esr.mapping.tester.impl;

import java.io.OutputStream;

import com.sap.aii.mapping.api.OutputPayload;

public class OutputPayloadImpl extends OutputPayload {
	OutputStream ou;

	public OutputPayloadImpl (OutputStream ou) {
		this.ou = ou;
	}
	@Override
	public OutputStream getOutputStream() {
		return this.ou;
	}
}