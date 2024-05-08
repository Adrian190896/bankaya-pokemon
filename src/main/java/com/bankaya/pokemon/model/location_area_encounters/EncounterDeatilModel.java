package com.bankaya.pokemon.model.location_area_encounters;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokemon.model.common.CommonModel;

public class EncounterDeatilModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2293285297831125128L;
	
	private Integer chance;
	private List<CommonModel> condition_values;
	private CommonModel method;
	private Integer max_level;
	private Integer min_level;

	public Integer getChance() {
		return chance;
	}

	public void setChance(Integer chance) {
		this.chance = chance;
	}

	public List<CommonModel> getCondition_values() {
		return condition_values;
	}

	public void setCondition_values(List<CommonModel> condition_values) {
		this.condition_values = condition_values;
	}

	public CommonModel getMethod() {
		return method;
	}

	public void setMethod(CommonModel method) {
		this.method = method;
	}

	public Integer getMax_level() {
		return max_level;
	}

	public void setMax_level(Integer max_level) {
		this.max_level = max_level;
	}

	public Integer getMin_level() {
		return min_level;
	}

	public void setMin_level(Integer min_level) {
		this.min_level = min_level;
	}

	@Override
	public String toString() {
		return "EncounterDeatilModel [chance=" + chance + ", condition_values=" + condition_values + ", method="
				+ method + ", max_level=" + max_level + ", min_level=" + min_level + "]";
	}

}
