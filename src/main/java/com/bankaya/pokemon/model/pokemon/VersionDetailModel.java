package com.bankaya.pokemon.model.pokemon;

import com.bankaya.pokemon.model.common.CommonModel;

public class VersionDetailModel {

	private Integer rarity;
	private CommonModel version;

	public Integer getRarity() {
		return rarity;
	}

	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}

	public CommonModel getVersion() {
		return version;
	}

	public void setVersion(CommonModel version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VersionDetail [rarity=" + rarity + ", version=" + version + "]";
	}

}
