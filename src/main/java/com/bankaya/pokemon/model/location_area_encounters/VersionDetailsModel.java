package com.bankaya.pokemon.model.location_area_encounters;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokemon.model.common.CommonModel;

public class VersionDetailsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1093025092844607905L;
	
	private List<EncounterDeatilModel> encounter_details;
	private Integer max_chance;
	private CommonModel version;

	public List<EncounterDeatilModel> getEncounter_details() {
		return encounter_details;
	}

	public void setEncounter_details(List<EncounterDeatilModel> encounter_details) {
		this.encounter_details = encounter_details;
	}

	public Integer getMax_chance() {
		return max_chance;
	}

	public void setMax_chance(Integer max_chance) {
		this.max_chance = max_chance;
	}

	public CommonModel getVersion() {
		return version;
	}

	public void setVersion(CommonModel version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VersionDetailsModel [encounter_details=" + encounter_details + ", max_chance=" + max_chance
				+ ", version=" + version + "]";
	}

}
