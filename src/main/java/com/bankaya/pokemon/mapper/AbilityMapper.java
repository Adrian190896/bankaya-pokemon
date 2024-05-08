package com.bankaya.pokemon.mapper;

import java.util.ArrayList;
import java.util.List;

import com.bankaya.pokemon.model.ability.AbilityModel;
import com.bankaya.pokemon.model.ability.EffectEntriesModel;
import com.bankaya.pokemon.model.ability.AbilityPokemonModel;
import com.bankaya.pokemon.model.common.ConstantsModel;
import com.bankaya.pokemon.xsd.Common;
import com.bankaya.pokemon.xsd.GetAbilityResponse;

public class AbilityMapper {

	public static GetAbilityResponse.Ability MapAbility(AbilityModel abilityModel) {
		GetAbilityResponse.Ability abilityResponse = new GetAbilityResponse.Ability();
		abilityResponse.getEffectEntries().addAll(mapEffectEntries(abilityModel.getEffect_entries()));
		abilityResponse.setIsMainSeries(abilityModel.getIs_main_series());
		if (UtilsMapper.isValidString(abilityModel.getName())) {
			abilityResponse.setName(abilityModel.getName());
		}
		if (UtilsMapper.isValidInteger(abilityModel.getId())) {
			abilityResponse.setId(abilityModel.getId());
		}
		abilityResponse.getPokemon().addAll(mapPokemon(abilityModel.getPokemon()));
		return abilityResponse;
	}

	public static List<GetAbilityResponse.Ability.EffectEntries> mapEffectEntries(List<EffectEntriesModel> effectEntriesModelList) {
		List<GetAbilityResponse.Ability.EffectEntries> effective = new ArrayList<>();
		if (effectEntriesModelList != null) {
			for (EffectEntriesModel effectEntriesModel : effectEntriesModelList) {
				GetAbilityResponse.Ability.EffectEntries effectEntries = new GetAbilityResponse.Ability.EffectEntries();
				effectEntries.setEffect(
						effectEntriesModel.getEffect().replaceAll(ConstantsModel.REPLACE, ConstantsModel.EMPTY));
				Common common = new Common();
				if (UtilsMapper.isValidString(effectEntriesModel.getLanguage().getName())) {
					common.setName(effectEntriesModel.getLanguage().getName());
				}
				if (UtilsMapper.isValidString(effectEntriesModel.getLanguage().getUrl())) {
					common.setUrl(effectEntriesModel.getLanguage().getUrl());
				}
				effectEntries.setLanguage(common);
				if (UtilsMapper.isValidString(effectEntriesModel.getShort_effect())) {
					effectEntries.setShortEffect(effectEntriesModel.getShort_effect());
				}
				effective.add(effectEntries);
			}
		}
		return effective;
	}

	public static List<GetAbilityResponse.Ability.Pokemon> mapPokemon(List<AbilityPokemonModel> pokemonModels) {
		List<GetAbilityResponse.Ability.Pokemon> pokemonList = new ArrayList<>();
		if (pokemonModels != null) {
			for (AbilityPokemonModel pokemonModel : pokemonModels) {
				GetAbilityResponse.Ability.Pokemon pokemon = new GetAbilityResponse.Ability.Pokemon();
				if (UtilsMapper.isValidBoolean(pokemonModel.getIs_hidden())) {
					pokemon.setIsHidden(pokemonModel.getIs_hidden());
				}
				if (UtilsMapper.isValidInteger(pokemonModel.getSlot())) {
					pokemon.setSlot(pokemonModel.getSlot());
				}
				Common childPokemon = new Common();
				if (UtilsMapper.isValidString(pokemonModel.getPokemon().getName())) {
					childPokemon.setName(pokemonModel.getPokemon().getName());
				}
				if (UtilsMapper.isValidString(pokemonModel.getPokemon().getUrl())) {
					childPokemon.setUrl(pokemonModel.getPokemon().getUrl());
				}
				pokemon.setPokemon(childPokemon);
				pokemonList.add(pokemon);
			}
		}
		return pokemonList;
	}
}
