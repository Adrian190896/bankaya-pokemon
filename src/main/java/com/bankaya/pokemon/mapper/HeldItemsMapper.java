package com.bankaya.pokemon.mapper;

import java.util.ArrayList;
import java.util.List;

import com.bankaya.pokemon.model.common.CommonModel;
import com.bankaya.pokemon.model.pokemon.HeldItemModel;
import com.bankaya.pokemon.model.pokemon.PokemonModel;
import com.bankaya.pokemon.model.pokemon.VersionDetailModel;
import com.bankaya.pokemon.xsd.Common;
import com.bankaya.pokemon.xsd.GetHeldItemsResponse.HeldItems;
import com.bankaya.pokemon.xsd.GetHeldItemsResponse.HeldItems.VersionDetails;

public class HeldItemsMapper {

	public static List<HeldItems> MapHeldItems(PokemonModel heldItems) {

		List<HeldItems> heldItemsResponseList = new ArrayList<>();
		
		for (HeldItemModel heldItem : heldItems.getHeld_items()) {
			HeldItems heldItemsResponse = new HeldItems();
			setItem(heldItem.getItem(), heldItemsResponse);
			setVersionDetails(heldItem.getVersion_details(), heldItemsResponse);
			heldItemsResponseList.add(heldItemsResponse);
		}

		return heldItemsResponseList;
	}

	private static void setVersionDetails(List<VersionDetailModel> versionDetailsModel, HeldItems heldItemsResponse) {

		if (versionDetailsModel != null) {
			List<VersionDetails> versionDetailsList = new ArrayList<>();
			for (VersionDetailModel versionDetail : versionDetailsModel) {
				VersionDetails versionDetails = new VersionDetails();
				if (UtilsMapper.isValidInteger(versionDetail.getRarity())) {
					versionDetails.setRarity(versionDetail.getRarity());
				}
				setVersion(versionDetail.getVersion(), versionDetails);
				versionDetailsList.add(versionDetails);
			}
			heldItemsResponse.getVersionDetails().addAll(versionDetailsList);
		}
	}

	public static void setItem(CommonModel itemModel, HeldItems heldItemsResponse) {
		if (itemModel != null) {
			Common item = new Common();
			if (UtilsMapper.isValidString(itemModel.getName())) {
				item.setName(itemModel.getName());
			}

			if (UtilsMapper.isValidString(itemModel.getUrl())) {
				item.setUrl(itemModel.getUrl());
			}
			heldItemsResponse.setItem(item);
		}
	}

	public static void setVersion(CommonModel versionModel, VersionDetails versionDetails) {
		if (versionModel != null) {
			Common version = new Common();
			if (UtilsMapper.isValidString(versionModel.getName())) {
				version.setName(versionModel.getName());
			}

			if (UtilsMapper.isValidString(versionModel.getUrl())) {
				version.setUrl(versionModel.getUrl());
			}
			versionDetails.setVersion(version);
		}
	}
}
