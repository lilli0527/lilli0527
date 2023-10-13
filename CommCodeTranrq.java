package com.example.Pawsome.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CommCodeTranrq {

	/** MWHEADER */
	@Valid
	@JsonProperty("MWHEADER")
	private TranrqMwheader mwheader;

	/** TRANRQ */
	@Valid
	@JsonProperty("TRANRQ")
	private CommCodeTranrqTranrq tranrq;

}
