package com.bankaya.pokemon.service;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.bankaya.pokemon.exception.PokemonException;
import com.bankaya.pokemon.mapper.AbilityMapper;
import com.bankaya.pokemon.mapper.BaseExperienceMapper;
import com.bankaya.pokemon.mapper.HeldItemsMapper;
import com.bankaya.pokemon.mapper.UtilsMapper;
import com.bankaya.pokemon.model.ability.AbilityModel;
import com.bankaya.pokemon.model.common.ConstantsModel;
import com.bankaya.pokemon.model.location_area_encounters.LocationAreaEncountersModel;
import com.bankaya.pokemon.model.pokemon.PokemonAbility;
import com.bankaya.pokemon.model.pokemon.PokemonModel;
import com.bankaya.pokemon.model.record.RecordModel;
import com.bankaya.pokemon.repository.RecordRepository;
import com.bankaya.pokemon.xsd.BaseExperience;
import com.bankaya.pokemon.xsd.GetAbilityResponse;
import com.bankaya.pokemon.xsd.GetHeldItemsResponse.HeldItems;
import com.bankaya.pokemon.xsd.GetLocationAreaEncounterResponse.LocationAreaEncounters;
import com.bankaya.pokemon.xsd.Name;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@Service
public class PokemonService {

	@Autowired
	private Environment env;

	@Autowired
	private RecordRepository recordRepository;

	RestClient restClient = RestClient.create();

	private static Logger log = LoggerFactory.getLogger(PokemonService.class);

	public List<GetAbilityResponse.Ability> getPokemonAbility(String id, String method) throws PokemonException {

		Pattern paterValidator = Pattern.compile(ConstantsModel.PATTER_SPECIAL_CHARACTERS);
		Matcher macherValidator = paterValidator.matcher(id);
		if (id == null || id.isEmpty() || macherValidator.find()) {
			throw new PokemonException(ConstantsModel.ERROR_INVALID_CHARACTERS + id);
		}

		List<GetAbilityResponse.Ability> responseAbilities = new ArrayList<>();

		PokemonModel resultPokemon = getPokemon(id);

		List<String> pokemonAbilities = new ArrayList<>();

		for (PokemonAbility pokemonAbility : resultPokemon.getAbilities()) {
			pokemonAbilities.add(pokemonAbility.getAbility().getUrl());
		}

		for (String uriAbility : pokemonAbilities) {
			GetAbilityResponse.Ability responseAbility = null;
			try {
				AbilityModel result = restClient.get().uri(uriAbility).retrieve().body(AbilityModel.class);
				responseAbility = AbilityMapper.MapAbility(result);
			} catch (Exception e) {
				throw new PokemonException(e.getMessage());
			}
			responseAbilities.add(responseAbility);
		}
		recodRequest(method);
		return responseAbilities;
	}

	public PokemonModel getPokemon(String pokemon) throws PokemonException {

		String scheme = env.getProperty("api.scheme");
		String host = env.getProperty("api.pokemon.host");
		String path = env.getProperty("api.pokemon.base-experience");
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(scheme).host(host).path(path)
				.buildAndExpand(pokemon);
		PokemonModel result = null;
		try {
			result = restClient.get().uri(uriComponents.toString()).retrieve().body(PokemonModel.class);
		} catch (Exception e) {
			throw new PokemonException(e.getMessage());
		}
		return result;

	}

	public BaseExperience getPokemonBaseExperience(String id, String method) throws PokemonException {

		Pattern paterValidator = Pattern.compile(ConstantsModel.PATTER_SPECIAL_CHARACTERS);
		Matcher macherValidator = paterValidator.matcher(id);
		if (id == null || id.isEmpty() || macherValidator.find()) {
			throw new PokemonException(ConstantsModel.ERROR_INVALID_CHARACTERS + id);
		}
		String scheme = env.getProperty("api.scheme");
		String host = env.getProperty("api.pokemon.host");
		String path = env.getProperty("api.pokemon.base-experience");
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(scheme).host(host).path(path)
				.buildAndExpand(id);
		BaseExperience responseBaseExperience = null;
		try {
			PokemonModel result = restClient.get().uri(uriComponents.toString()).retrieve().body(PokemonModel.class);
			responseBaseExperience = BaseExperienceMapper.MapBaseExperience(result);
		} catch (Exception e) {
			throw new PokemonException(e.getMessage());
		}
		recodRequest(method);
		return responseBaseExperience;
	}

	public List<HeldItems> getPokemonHeldItems(String id, String method) throws PokemonException {

		Pattern paterValidator = Pattern.compile(ConstantsModel.PATTER_SPECIAL_CHARACTERS);
		Matcher macherValidator = paterValidator.matcher(id);
		if (id == null || id.isEmpty() || macherValidator.find()) {
			throw new PokemonException(ConstantsModel.ERROR_INVALID_CHARACTERS + id);
		}
		String scheme = env.getProperty("api.scheme");
		String host = env.getProperty("api.pokemon.host");
		String path = env.getProperty("api.pokemon.base-experience");
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(scheme).host(host).path(path)
				.buildAndExpand(id);
		List<HeldItems> heldItems = null;
		try {
			PokemonModel result = restClient.get().uri(uriComponents.toString()).retrieve().body(PokemonModel.class);
			if (result != null && result.getHeld_items() != null && !result.getHeld_items().isEmpty()) {
				heldItems = HeldItemsMapper.MapHeldItems(result);
			} else {
				throw new PokemonException(ConstantsModel.NOT_FOUND_HELD_ITEMS + id);
			}
		} catch (Exception e) {
			throw new PokemonException(e.getMessage());
		}
		recodRequest(method);
		return heldItems;
	}

	public List<LocationAreaEncounters> getLocationAreaEncounters(String id, String method) throws PokemonException {

		Pattern paterValidator = Pattern.compile(ConstantsModel.PATTER_SPECIAL_CHARACTERS);
		Matcher macherValidator = paterValidator.matcher(id);
		if (id == null || id.isEmpty() || macherValidator.find()) {
			throw new PokemonException(ConstantsModel.ERROR_INVALID_CHARACTERS + id);
		}
		String scheme = env.getProperty("api.scheme");
		String host = env.getProperty("api.pokemon.host");
		String path = env.getProperty("api.pokemon.location-area-encounters");
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(scheme).host(host).path(path)
				.buildAndExpand(id);
		List<LocationAreaEncounters> locationAreaEncounters = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(Include.NON_NULL);

			objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.NamingBase() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 2725132950726961766L;

				@Override
				public String translate(String propertyName) {
					StringBuilder resultado = new StringBuilder();
					boolean flag = false;

					for (int i = 0; i < propertyName.length(); i++) {
						char caracter = propertyName.charAt(i);

						if (caracter == '_') {
							flag = true;
						} else {
							if (flag) {
								resultado.append(Character.toUpperCase(caracter));
								flag = false;
							} else {
								resultado.append(caracter);
							}
						}
					}
					return resultado.toString();
				}
			});
			List<LocationAreaEncountersModel> result = restClient.get().uri(uriComponents.toString()).retrieve()
					.body(new ParameterizedTypeReference<>() {
					});
			String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			ObjectMapper objectMapperXml = new ObjectMapper();
			locationAreaEncounters = objectMapperXml.readValue(jsonOutput,
					new TypeReference<List<LocationAreaEncounters>>() {
					});
		} catch (Exception e) {
			throw new PokemonException(e.getMessage());
		}
		recodRequest(method);
		return locationAreaEncounters;
	}

	public Name getName(String pokemonName, String method) throws PokemonException, JsonProcessingException {
		PokemonModel resultPokemon = getPokemon(pokemonName);
		Name name = new Name();
		if (UtilsMapper.isValidString(resultPokemon.getName())) {
			name.setName(resultPokemon.getName());
		}
		if (UtilsMapper.isValidInteger(resultPokemon.getId())) {
			name.setId(resultPokemon.getId());
		}
		recodRequest(method);
		return name;
	}

	public void recodRequest(String method) {
		try {
			String ipAddress = InetAddress.getLocalHost().getHostAddress();
			recordRepository.save(new RecordModel(ipAddress, new Date(), getMethod(method)));
		} catch (Exception e) {
			log.error("It can't retrieve ip");
		}
	}

	public String getMethod(String method) {
		int lastIndex = method.lastIndexOf("}");
		if (lastIndex != -1) {
			return method.substring(lastIndex + 1).trim();
		} else {
			return "";
		}
	}

}
