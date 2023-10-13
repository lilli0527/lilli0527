package com.example.Pawsome.dto;

import java.util.List;

import javax.validation.Valid;

import lombok.Data;

@Data
public class CommCodeTranrsTranrs {

    /** items */
    @Valid
    private List<CommCodeTranrsTranrsItems> items;

}
