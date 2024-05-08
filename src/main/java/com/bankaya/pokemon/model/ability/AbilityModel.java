package com.bankaya.pokemon.model.ability;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokemon.model.common.CommonModel;

public class AbilityModel extends CommonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1392260366889980137L;

	private Boolean is_main_series;

	private List<EffectEntriesModel> effect_entries;

	private List<AbilityPokemonModel> pokemon;

	public Boolean getIs_main_series() {
		return is_main_series;
	}

	public void setIs_main_series(Boolean is_main_series) {
		this.is_main_series = is_main_series;
	}

	public List<EffectEntriesModel> getEffect_entries() {
		return effect_entries;
	}

	public void setEffect_entries(List<EffectEntriesModel> effect_entries) {
		this.effect_entries = effect_entries;
	}

	public List<AbilityPokemonModel> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<AbilityPokemonModel> pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Ability [is_main_series=" + is_main_series + ", effect_entries=" + effect_entries + ", pokemon="
				+ pokemon + "]";
	}

}
