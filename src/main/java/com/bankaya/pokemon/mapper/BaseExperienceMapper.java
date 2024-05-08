package com.bankaya.pokemon.mapper;

import com.bankaya.pokemon.model.pokemon.PokemonModel;
import com.bankaya.pokemon.xsd.BaseExperience;

public class BaseExperienceMapper {

	public static BaseExperience MapBaseExperience(PokemonModel baseExperience) {
		BaseExperience baseExperienceResponse = new BaseExperience();

		if (UtilsMapper.isValidInteger(baseExperience.getId())) {
			baseExperienceResponse.setId(baseExperience.getId());
		}

		if (UtilsMapper.isValidString(baseExperience.getName())) {
			baseExperienceResponse.setName(baseExperience.getName());
		}

		if (UtilsMapper.isValidInteger(baseExperience.getBase_experience())) {
			baseExperienceResponse.setBaseExperience(baseExperience.getBase_experience());
		}
		return baseExperienceResponse;
	}
}
