package com.bankaya.pokemon.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://localhost:8080/ws}001_NOT_FOUND")
public class PokemonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8445701426478152291L;

	public PokemonException(String message) {
		super(message);
	}
}
