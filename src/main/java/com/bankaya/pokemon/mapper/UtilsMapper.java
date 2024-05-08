package com.bankaya.pokemon.mapper;

public class UtilsMapper {

	static public Boolean isValidString(String string) {
		return string != null && !string.isEmpty();
	}

	static public Boolean isValidInteger(Integer integer) {
		return integer != null;
	}

	static public Boolean isValidBoolean(Boolean booleanValue) {
		return booleanValue != null;
	}
}
