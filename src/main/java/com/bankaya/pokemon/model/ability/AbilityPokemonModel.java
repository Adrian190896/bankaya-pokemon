package com.bankaya.pokemon.model.ability;

import java.io.Serializable;

import com.bankaya.pokemon.model.common.CommonModel;

public class AbilityPokemonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5027170629055597942L;
	private Boolean is_hidden;
	private Integer slot;
	private CommonModel pokemon;

	public Boolean getIs_hidden() {
		return is_hidden;
	}

	public void setIs_hidden(Boolean is_hidden) {
		this.is_hidden = is_hidden;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public CommonModel getPokemon() {
		return pokemon;
	}

	public void setPokemon(CommonModel pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Pokemon [is_hidden=" + is_hidden + ", slot=" + slot + ", pokemon=" + pokemon + "]";
	}

}
