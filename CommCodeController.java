package com.example.Pawsome.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pawsome.dto.CommCodeTranrq;
import com.example.Pawsome.dto.CommCodeTranrs;
import com.example.Pawsome.exception.DataNotFoundException;
import com.example.Pawsome.exception.ErrorInputException;
import com.example.Pawsome.service.CommCodeSvc;

@RestController
@CrossOrigin("http://localhost:4200")
public class CommCodeController {

	/** CommCodeSvc */
	@Autowired
	private CommCodeSvc commCodeSvc;

	/** COMMCODEMSG COMMCODE資料查詢服務 */
	private static final String COMMCODEMSG = "PAWSOME-COMMCODEMSG";

	/** 必填欄位不完整 */
	private static final String ERRORINPUT = "E001";

	/**
	 * queryCommCodeMsg COMMCODE資料查詢服務 PAWSOME-COMMCODEMSG
	 * 
	 * @param request
	 * @param errors
	 * @return
	 * @throws ErrorInputException
	 * @throws DataNotFoundException
	 */
	@PostMapping(value = "/commCodeMsg")
	public CommCodeTranrs queryCommCodeMsg(@Valid @RequestBody CommCodeTranrq request, Errors errors)
			throws ErrorInputException, DataNotFoundException {
		// 檢查上行 Errors 是否有錯
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (ObjectError error : errors.getAllErrors()) {
				sb.append(error.getDefaultMessage()).append("; ");
			}
			throw new ErrorInputException(COMMCODEMSG + sb, ERRORINPUT);
		}
		return commCodeSvc.queryCommCodeMsg(request);
	}

}
