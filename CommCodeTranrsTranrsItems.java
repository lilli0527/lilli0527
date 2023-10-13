package com.example.Pawsome.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommCodeTranrsTranrsItems {

    /** commCode 代號 */
    @NotBlank
    private String commCode;
    
    /** msg 代號描述 */
    @NotBlank
    @Size(message = "代號描述長度不得超過20", max = 20)
    private String msg;

}
