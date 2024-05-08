package com.bankaya.pokemon.model.record;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "T_RECORD_REQUEST")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7633376030272585938L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "origin_ip")
	private String originIp;
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "execution_method")
	private String executionMethod;

	
	public RecordModel(String originIp, Date date, String executionMethod) {
		super();
		this.originIp = originIp;
		this.creationDate = date;
		this.executionMethod = executionMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginIp() {
		return originIp;
	}

	public void setOriginIp(String originIp) {
		this.originIp = originIp;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getExecutionMethod() {
		return executionMethod;
	}

	public void setExecutionMethod(String executionMethod) {
		this.executionMethod = executionMethod;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", originIp=" + originIp + ", creationDate=" + creationDate + ", executionMethod="
				+ executionMethod + "]";
	}

}
