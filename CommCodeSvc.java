package com.example.Pawsome.service;

import com.example.Pawsome.dto.CommCodeTranrq;
import com.example.Pawsome.dto.CommCodeTranrs;
import com.example.Pawsome.exception.DataNotFoundException;

public interface CommCodeSvc {

	/**
	 * COMMCODE資料查詢服務
	 * @param request
	 * @return
	 * @throws DataNotFoundException
	 */
	CommCodeTranrs queryCommCodeMsg(CommCodeTranrq request) throws DataNotFoundException;
}
