package com.example.Pawsome.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pawsome.dto.CommCodeTranrq;
import com.example.Pawsome.dto.CommCodeTranrs;
import com.example.Pawsome.dto.CommCodeTranrsTranrs;
import com.example.Pawsome.dto.CommCodeTranrsTranrsItems;
import com.example.Pawsome.dto.TranrsMwheader;
import com.example.Pawsome.entity.PsCommCodeEntity;
import com.example.Pawsome.enums.ReturnCodeAndDescEnum;
import com.example.Pawsome.exception.DataNotFoundException;
import com.example.Pawsome.repository.PsCommCodeEntityRepository;
import com.example.Pawsome.service.CommCodeSvc;

@Service
public class CommCodeSvcImpl implements CommCodeSvc {

	@Autowired
	private PsCommCodeEntityRepository commCodeRepo;

	/** COMMCODEMSG COMMCODE資料查詢服務 */
	private static final String COMMCODEMSG = "PAWSOME-COMMCODEMSG";

	/** 交易成功代碼 */
	private static final String SUCCESSCODE = ReturnCodeAndDescEnum.SUCCESS.getCode();

	/** 交易成功訊息 */
	private static final String SUCCESSDESC = ReturnCodeAndDescEnum.SUCCESS.getDesc();

	/** 查無資料代碼 */
	private static final String DATANOTFOUND = "E702";

	/** queryCommCodeMsg COMMCODE資料查詢服務 */
	@Override
	public CommCodeTranrs queryCommCodeMsg(CommCodeTranrq request) throws DataNotFoundException {

		List<PsCommCodeEntity> queryEntitys = commCodeRepo.findByType(request.getTranrq().getType());

		if (queryEntitys.isEmpty()) {
			throw new DataNotFoundException(COMMCODEMSG, DATANOTFOUND);
		}

		List<CommCodeTranrsTranrsItems> itemsList = new ArrayList<>();
        for (PsCommCodeEntity queryEntity : queryEntitys) {
        	CommCodeTranrsTranrsItems items = new CommCodeTranrsTranrsItems();
            items.setCommCode(queryEntity.getCommCode());
            items.setMsg(queryEntity.getMsg());
            itemsList.add(items);
        }

        CommCodeTranrsTranrs commCodeTranrsTranrs = new CommCodeTranrsTranrs();
        commCodeTranrsTranrs.setItems(itemsList);

        TranrsMwheader commCodeTranrsMwheader = new TranrsMwheader();
        commCodeTranrsMwheader.setMsgid(COMMCODEMSG);
        commCodeTranrsMwheader.setReturnCode(SUCCESSCODE);
        commCodeTranrsMwheader.setReturnDesc(SUCCESSDESC);

        CommCodeTranrs commCodeTranrs = new CommCodeTranrs();
        commCodeTranrs.setMwheader(commCodeTranrsMwheader);
        commCodeTranrs.setTranrs(commCodeTranrsTranrs);

        return commCodeTranrs;
	}

}
