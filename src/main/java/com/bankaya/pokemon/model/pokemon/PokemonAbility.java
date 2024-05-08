package com.bankaya.pokemon.model.pokemon;

import java.io.Serializable;

import com.bankaya.pokemon.model.common.CommonModel;

public class PokemonAbility implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8483250580669171666L;
	
	private CommonModel ability;
	private Boolean is_hiden;
	private Integer slot;

	public CommonModel getAbility() {
		return ability;
	}

	public void setAbility(CommonModel ability) {
		this.ability = ability;
	}

	public Boolean getIs_hiden() {
		return is_hiden;
	}

	public void setIs_hiden(Boolean is_hiden) {
		this.is_hiden = is_hiden;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return "PokemonAbility [ability=" + ability + ", is_hiden=" + is_hiden + ", slot=" + slot + "]";
	}

}
