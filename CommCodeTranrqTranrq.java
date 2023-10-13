package com.example.Pawsome.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommCodeTranrqTranrq {

	/** Type */
    @NotBlank(message = "不得為空")
    @Size(message = "Type 長度不得超過20", max = 20)
    private String type;

}
