package com.bankaya.pokemon.model.location_area_encounters;

import java.io.Serializable;
import java.util.List;

public class ListEncounter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6665237117578501522L;
	private List<LocationAreaEncountersModel> list;

	public List<LocationAreaEncountersModel> getList() {
		return list;
	}

	public void setList(List<LocationAreaEncountersModel> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ListEncounter [list=" + list + "]";
	}

}
