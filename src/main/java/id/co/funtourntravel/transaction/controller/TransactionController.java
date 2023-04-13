package id.co.funtourntravel.transaction.controller;

import id.co.funtourntravel.transaction.model.DTO.InputTransaction;
import id.co.funtourntravel.transaction.model.Transaction;
import id.co.funtourntravel.transaction.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("trx")
public class TransactionController {

    private  final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TransactionService transactionService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List getAll(){
        return transactionService.getAllTransaction();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public InputTransaction addTransaction(@RequestBody InputTransaction inputTransaction){
        transactionService.executePayment(inputTransaction.getUserId(), inputTransaction.getTourId(),
                inputTransaction.getPaymentId(), inputTransaction.getNoBayar());
        return inputTransaction;
    }

    @PostMapping("/getTrxUser")
    @ResponseStatus(HttpStatus.OK)
    public List getAllTransactionByUserId(@PathVariable("userName") String userName){
        List allTrx = transactionService.AllTransactionByUser(userName);
        return allTrx;
    }


}
