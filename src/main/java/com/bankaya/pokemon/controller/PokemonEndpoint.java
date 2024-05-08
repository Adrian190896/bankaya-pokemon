package com.bankaya.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankaya.pokemon.exception.PokemonException;
import com.bankaya.pokemon.service.PokemonService;
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
import com.fasterxml.jackson.core.JsonProcessingException;

@Endpoint
public class PokemonEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@Autowired
	private PokemonService pokemonService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilityRequest")
	@ResponsePayload
	public GetAbilityResponse getAbility(@RequestPayload GetAbilityRequest getAbilityRequest,
			MessageContext messageContext) throws PokemonException {
		GetAbilityResponse response = new GetAbilityResponse();
		response.getAbility().addAll((pokemonService.getPokemonAbility(getAbilityRequest.getPokemonName(),
				messageContext.getRequest().toString())));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
	@ResponsePayload
	public GetBaseExperienceResponse getBaseExperience(
			@RequestPayload GetBaseExperienceRequest getBaseExperienceRequest, MessageContext messageContext)
			throws PokemonException {
		GetBaseExperienceResponse response = new GetBaseExperienceResponse();
		response.setBaseExperience(pokemonService.getPokemonBaseExperience(getBaseExperienceRequest.getPokemonName(),
				messageContext.getRequest().toString()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
	@ResponsePayload
	public GetHeldItemsResponse getHeldItems(@RequestPayload GetHeldItemsRequest getHeldItemsRequest,
			MessageContext messageContext) throws PokemonException {
		GetHeldItemsResponse response = new GetHeldItemsResponse();
		response.getHeldItems().addAll((pokemonService.getPokemonHeldItems(getHeldItemsRequest.getPokemonName(),
				messageContext.getRequest().toString())));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncounterRequest")
	@ResponsePayload
	public GetLocationAreaEncounterResponse getLocationAreaEncounters(
			@RequestPayload GetLocationAreaEncounterRequest getLocationAreaEncounterRequest,
			MessageContext messageContext) throws PokemonException {
		GetLocationAreaEncounterResponse response = new GetLocationAreaEncounterResponse();
		response.getLocationAreaEncounters()
				.addAll((pokemonService.getLocationAreaEncounters(getLocationAreaEncounterRequest.getPokemonName(),
						messageContext.getRequest().toString())));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public GetNameResponse getName(@RequestPayload GetNameRequest getNameRequest, MessageContext messageContext)
			throws PokemonException, JsonProcessingException {
		GetNameResponse response = new GetNameResponse();
		response.setName(
				pokemonService.getName(getNameRequest.getPokemonName(), messageContext.getRequest().toString()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
	@ResponsePayload
	public GetIdResponse getId(@RequestPayload GetIdRequest getIdRequest, MessageContext messageContext)
			throws PokemonException, JsonProcessingException {
		GetIdResponse response = new GetIdResponse();
		response.setName(pokemonService.getName(getIdRequest.getPokemonName(), messageContext.getRequest().toString()));
		return response;
	}

}
