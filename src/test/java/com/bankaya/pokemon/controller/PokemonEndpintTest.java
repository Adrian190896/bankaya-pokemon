package com.bankaya.pokemon.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import com.bankaya.pokemon.common.Constants;
import com.bankaya.pokemon.exception.PokemonException;
import com.bankaya.pokemon.service.PokemonService;
import com.bankaya.pokemon.xml.GetXml;
import com.bankaya.pokemon.xsd.BaseExperience;
import com.bankaya.pokemon.xsd.GetAbilityRequest;
import com.bankaya.pokemon.xsd.GetAbilityResponse;
import com.bankaya.pokemon.xsd.GetBaseExperienceRequest;
import com.bankaya.pokemon.xsd.GetBaseExperienceResponse;
import com.bankaya.pokemon.xsd.GetHeldItemsRequest;
import com.bankaya.pokemon.xsd.GetHeldItemsResponse;
import com.bankaya.pokemon.xsd.GetIdRequest;
import com.bankaya.pokemon.xsd.GetIdResponse;
import com.bankaya.pokemon.xsd.GetLocationAreaEncounterRequest;
import com.bankaya.pokemon.xsd.GetLocationAreaEncounterResponse;
import com.bankaya.pokemon.xsd.GetNameRequest;
import com.bankaya.pokemon.xsd.GetNameResponse;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPException;

@SpringBootTest
public class PokemonEndpintTest {

	@Mock
	private PokemonService pokemonService;

	@Mock
	private MessageContext messageContext;

	@InjectMocks
	private PokemonEndpoint pokemonEndpoint;
	
	@InjectMocks
	private GetXml pokemonXml;

	@Before(value = "")
	public void setup() {
		 MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAbility() throws PokemonException, SOAPException, IOException {
		when(pokemonService.getPokemonAbility(any(String.class), any(String.class))).thenReturn(pokemonXml.getAbility());
		when(messageContext.getRequest()).thenReturn(getRequest(Constants.NAME_METHOD_ABILITY));
		GetAbilityRequest request = new GetAbilityRequest();
		request.setPokemonName(Constants.POKEMON);
		GetAbilityResponse response = pokemonEndpoint.getAbility(request, messageContext);
		assertEquals(2, response.getAbility().size());
		assertEquals(Constants.POKEMON, response.getAbility().get(0).getPokemon().get(0).getPokemon().getName());
	}
	
	@Test
	public void getBaseExperience() throws PokemonException, SOAPException, IOException {
		when(pokemonService.getPokemonBaseExperience(any(String.class), any(String.class))).thenReturn(pokemonXml.getBaseExperience());
		when(messageContext.getRequest()).thenReturn(getRequest(Constants.NAME_METHOD_BASE_EXPERIENCE));
		GetBaseExperienceRequest request = new GetBaseExperienceRequest();
		request.setPokemonName(Constants.POKEMON2);
		GetBaseExperienceResponse response = pokemonEndpoint.getBaseExperience(request, messageContext);
		assertEquals(Constants.POKEMON2, response.getBaseExperience().getName());
	}
	
	@Test
	public void getHeldItems() throws PokemonException, SOAPException, IOException {
		when(pokemonService.getPokemonHeldItems(any(String.class), any(String.class))).thenReturn(pokemonXml.getPokemonHeldItems());
		when(messageContext.getRequest()).thenReturn(getRequest(Constants.NAME_METHOD_HELD_ITEMS));
		GetHeldItemsRequest request = new GetHeldItemsRequest();
		request.setPokemonName(Constants.POKEMON);
		GetHeldItemsResponse response = pokemonEndpoint.getHeldItems(request, messageContext);
		assertEquals(Constants.ITEM, response.getHeldItems().get(0).getItem().getName());
	}
	
	@Test
	public void getLocationAreaEncounters() throws PokemonException, SOAPException, IOException {
		when(pokemonService.getLocationAreaEncounters(any(String.class), any(String.class))).thenReturn(pokemonXml.getLocationAreaEncounters());
		when(messageContext.getRequest()).thenReturn(getRequest(Constants.NAME_METHOD_LOCATION));
		GetLocationAreaEncounterRequest request = new GetLocationAreaEncounterRequest();
		request.setPokemonName(Constants.POKEMON);
		GetLocationAreaEncounterResponse response = pokemonEndpoint.getLocationAreaEncounters(request, messageContext);
		assertEquals(Constants.LOCATION_AREA, response.getLocationAreaEncounters().get(0).getLocationArea().getName());
	}

	@Test
	public void getNameResponse() throws PokemonException, SOAPException, IOException {
		when(pokemonService.getName(any(String.class), any(String.class))).thenReturn(pokemonXml.getName());
		when(messageContext.getRequest()).thenReturn(getRequest(Constants.NAME_METHOD_NAME));
		GetNameRequest request = new GetNameRequest();
		request.setPokemonName(Constants.POKEMON3);
		GetNameResponse response = pokemonEndpoint.getName(request, messageContext);
		assertEquals(Constants.POKEMON3, response.getName().getName());
	}
	
	@Test
	public void getIdResponse() throws PokemonException, SOAPException, IOException {
		when(pokemonService.getName(any(String.class), any(String.class))).thenReturn(pokemonXml.getName());
		when(messageContext.getRequest()).thenReturn(getRequest(Constants.NAME_METHOD_ID));
		GetIdRequest request = new GetIdRequest();
		request.setPokemonName(Constants.POKEMON3);
		GetIdResponse response = pokemonEndpoint.getId(request, messageContext);
		assertEquals(Constants.POKEMON3, response.getName().getName());
	}
	
	public SaajSoapMessage getRequest(String method) throws SOAPException {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SaajSoapMessageFactory soapMessageFactory = new SaajSoapMessageFactory(messageFactory);
		SaajSoapMessage soapMessage = soapMessageFactory.createWebServiceMessage();
		SOAPBody soapBody = soapMessage.getSaajMessage().getSOAPBody();
		QName bodyName = new QName(Constants.NAME_SPACE_URI, method);
		soapBody.addChildElement(bodyName);
		return soapMessage;
	}

}
