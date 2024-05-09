package com.bankaya.pokemon.xml;

import java.util.List;

import com.bankaya.pokemon.xsd.BaseExperience;
import com.bankaya.pokemon.xsd.GetAbilityResponse;
import com.bankaya.pokemon.xsd.GetHeldItemsResponse.HeldItems;
import com.bankaya.pokemon.xsd.GetLocationAreaEncounterResponse.LocationAreaEncounters;
import com.bankaya.pokemon.xsd.Name;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class GetXml {

	public String getMethodString(String filePath) throws IOException {
		ClassPathResource resource = new ClassPathResource(filePath);
		try (InputStream inputStream = resource.getInputStream()) {
			byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
			return new String(bytes, StandardCharsets.UTF_8);
		}
	}

	public List<GetAbilityResponse.Ability> getAbility() throws IOException {
		String pokemonAbility = getMethodString("pokemonAbility.txt");
		ObjectMapper objectMapperXml = new ObjectMapper();
		return objectMapperXml.readValue(pokemonAbility, new TypeReference<List<GetAbilityResponse.Ability>>() {
		});
	}

	public BaseExperience getBaseExperience() throws IOException {
		String pokemonBaseExperience = getMethodString("pokemonBaseExperience.txt");
		ObjectMapper objectMapperXml = new ObjectMapper();
		return objectMapperXml.readValue(pokemonBaseExperience, new TypeReference<BaseExperience>() {
		});
	}

	public List<HeldItems> getPokemonHeldItems() throws IOException {
		String pokemonHeldItems = getMethodString("pokemonHeldItems.txt");
		ObjectMapper objectMapperXml = new ObjectMapper();
		return objectMapperXml.readValue(pokemonHeldItems, new TypeReference<List<HeldItems>>() {
		});
	}

	public List<LocationAreaEncounters> getLocationAreaEncounters() throws IOException {
		String pokemonLocation = getMethodString("pokemonLocation.txt");
		ObjectMapper objectMapperXml = new ObjectMapper();
		return objectMapperXml.readValue(pokemonLocation, new TypeReference<List<LocationAreaEncounters>>() {
		});
	}

	public Name getName() throws IOException {
		String pokemonLocation = getMethodString("pokemonName.txt");
		ObjectMapper objectMapperXml = new ObjectMapper();
		return objectMapperXml.readValue(pokemonLocation, new TypeReference<Name>() {
		});
	}
	
}
