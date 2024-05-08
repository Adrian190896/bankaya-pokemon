package com.bankaya.pokemon.model.machine;

import java.io.Serializable;

import com.bankaya.pokemon.model.common.CommonModel;

public class MachineModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5332304306937680815L;
	private String id;
	private CommonModel item;
	private CommonModel move;
	private CommonModel version_group;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CommonModel getItem() {
		return item;
	}

	public void setItem(CommonModel item) {
		this.item = item;
	}

	public CommonModel getMove() {
		return move;
	}

	public void setMove(CommonModel move) {
		this.move = move;
	}

	public CommonModel getVersion_group() {
		return version_group;
	}

	public void setVersion_group(CommonModel version_group) {
		this.version_group = version_group;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", item=" + item + ", move=" + move + ", version_group=" + version_group + "]";
	}

}
