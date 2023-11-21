package web.app.mapper;

import org.springframework.stereotype.Component;
import web.app.domain.Transaction;
import web.app.dto.TransactionRequest;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomTransactionMapperImpl implements TransactionMapper{
    @Override
    public Transaction transactionRequestToTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
//        transaction.setId(transactionRequest.getTransactionId());
        transaction.setUserId(transactionRequest.getUserId());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setDescription(transactionRequest.getDescription());
        transaction.setTimestamp(transactionRequest.getTimestamp());
        return transaction;
    }

    @Override
    public TransactionRequest transactionToTransactionRequest(Transaction transaction) {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setTransactionId(transaction.getId());
        transactionRequest.setAmount(transaction.getAmount());
        transactionRequest.setDescription(transaction.getDescription());
        transactionRequest.setTimestamp(transaction.getTimestamp());
        transactionRequest.setUserId(transaction.getUserId());
        return transactionRequest;
    }

    @Override
    public List<TransactionRequest> transactionListToTransactionRequestList(List<Transaction> transactionList) {
        return transactionList
                .stream()
                .map(this::transactionToTransactionRequest)
                .collect(Collectors.toList());
    }
}
