package com.bankaya.pokemon.model.pokemon;

import java.io.Serializable;
import java.util.List;

public class PokemonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5048161441666494906L;
	
	private Integer id;
	private String name;
	private Integer base_experience;
	private List<HeldItemModel> held_items;
	private List<PokemonAbility> abilities;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBase_experience() {
		return base_experience;
	}

	public void setBase_experience(Integer base_experience) {
		this.base_experience = base_experience;
	}

	public List<HeldItemModel> getHeld_items() {
		return held_items;
	}

	public void setHeld_items(List<HeldItemModel> held_items) {
		this.held_items = held_items;
	}

	
	public List<PokemonAbility> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "PokemonModel [id=" + id + ", name=" + name + ", base_experience=" + base_experience + ", held_items="
				+ held_items + ", abilities=" + abilities + "]";
	}

}
