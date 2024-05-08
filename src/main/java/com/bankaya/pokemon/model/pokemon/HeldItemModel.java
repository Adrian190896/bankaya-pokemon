package com.bankaya.pokemon.model.pokemon;

import java.io.Serializable;
import java.util.List;

import com.bankaya.pokemon.model.common.CommonModel;

public class HeldItemModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8967267167522657963L;
	private CommonModel item;
	private List<VersionDetailModel> version_details;

	public CommonModel getItem() {
		return item;
	}

	public void setItem(CommonModel item) {
		this.item = item;
	}

	public List<VersionDetailModel> getVersion_details() {
		return version_details;
	}

	public void setVersion_details(List<VersionDetailModel> version_details) {
		this.version_details = version_details;
	}

	@Override
	public String toString() {
		return "HeldItemModel [item=" + item + ", version_details=" + version_details + "]";
	}

}
