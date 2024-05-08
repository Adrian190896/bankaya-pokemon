package com.bankaya.pokemon.model.common;

import java.io.Serializable;

public class CommonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6329260778832394803L;

	private String name;
	private Integer id;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Common [name=" + name + ", id=" + id + ", url=" + url + "]";
	}

}
