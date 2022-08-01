package com.cvd.calendartransfer.host.controller;

import java.util.List;
import javax.validation.Valid;
import com.cvd.calendartransfer.host.converter.TransferRequestConverter;
import com.cvd.calendartransfer.host.converter.TransferResponseConverter;
import com.cvd.calendartransfer.host.data.TransferRequest;
import com.cvd.calendartransfer.host.data.TransferResponse;
import com.cvd.calendartransfer.useCase.CreateTransferCase;
import com.cvd.calendartransfer.useCase.GetAllTransferCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("transfers")
public class TransferController {
	
	@Autowired
	private CreateTransferCase createTransferCase;
	@Autowired
	private GetAllTransferCase getAllTransferCase;
	@Autowired
	private TransferRequestConverter transferRequestConverter;
	@Autowired
	private TransferResponseConverter transferResponseConverter;


	@GetMapping("/")
    public @ResponseBody String home() {
        return "Teste";
    }
	
	
	@PostMapping
    public ResponseEntity<TransferResponse> create(@Valid @RequestBody TransferRequest transfer) {
		return ResponseEntity.ok(
				transferResponseConverter.convert(
						createTransferCase.execute(transferRequestConverter.convert(transfer))));
    }
	
	@GetMapping
    public ResponseEntity<List<TransferResponse>> find() {
		return ResponseEntity.ok(
				transferResponseConverter.convert(getAllTransferCase.execute()));
    }

}
