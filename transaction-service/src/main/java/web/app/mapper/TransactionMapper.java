package web.app.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.app.domain.Transaction;
import web.app.dto.TransactionRequest;

import java.util.List;

@Mapper
public interface TransactionMapper {

    Transaction transactionRequestToTransaction(TransactionRequest transactionRequest);
    TransactionRequest transactionToTransactionRequest(Transaction transaction);

    List<TransactionRequest> transactionListToTransactionRequestList(List<Transaction> transactionList);

}
