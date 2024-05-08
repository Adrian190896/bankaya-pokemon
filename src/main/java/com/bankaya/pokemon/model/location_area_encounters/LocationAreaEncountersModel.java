package com.bankaya.pokemon.model.location_area_encounters;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokemon.model.common.CommonModel;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationAreaEncountersModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3585141210115007137L;
	
	private CommonModel location_area;

	private List<VersionDetailsModel> version_details;

	public CommonModel getLocation_area() {
		return location_area;
	}

	public void setLocation_area(CommonModel location_area) {
		this.location_area = location_area;
	}

	public List<VersionDetailsModel> getVersion_details() {
		return version_details;
	}

	public void setVersion_details(List<VersionDetailsModel> version_details) {
		this.version_details = version_details;
	}

	@Override
	public String toString() {
		return "LocationAreaEncountersModel [location_area=" + location_area + ", version_details=" + version_details
				+ "]";
	}



}
