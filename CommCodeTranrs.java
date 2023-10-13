package com.example.Pawsome.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CommCodeTranrs {

    /** MWHEADER */
    @JsonProperty("MWHEADER")
    @Valid
    private TranrsMwheader mwheader;

    /** TRANRS */
    @JsonProperty("TRANRS")
    @Valid
    private CommCodeTranrsTranrs tranrs;

}
