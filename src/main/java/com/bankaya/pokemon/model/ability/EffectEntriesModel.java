package com.bankaya.pokemon.model.ability;

import java.io.Serializable;

import com.bankaya.pokemon.model.common.CommonModel;

public class EffectEntriesModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4850082946350194159L;

	private String effect;

	private CommonModel language;

	private String short_effect;

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public CommonModel getLanguage() {
		return language;
	}

	public void setLanguage(CommonModel language) {
		this.language = language;
	}

	public String getShort_effect() {
		return short_effect;
	}

	public void setShort_effect(String short_effect) {
		this.short_effect = short_effect;
	}

	@Override
	public String toString() {
		return "EffectEntriesModel [effect=" + effect + ", language=" + language + ", short_effect=" + short_effect
				+ "]";
	}

}
