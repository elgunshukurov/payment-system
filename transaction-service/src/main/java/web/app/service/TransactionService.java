package web.app.service;

import web.app.dto.TransactionRequest;

import java.util.List;

public interface TransactionService {
    TransactionRequest addTransaction(TransactionRequest transaction);

    List<TransactionRequest> viewTransactionHistory(String userId);
}
