package web.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.app.domain.Transaction;
import web.app.dto.TransactionRequest;
import web.app.mapper.TransactionMapper;
import web.app.repository.TransactionRepository;
import web.app.service.TransactionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionRequest addTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = transactionMapper.transactionRequestToTransaction(transactionRequest);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.transactionToTransactionRequest(savedTransaction);
    }

    @Override
    public List<TransactionRequest> viewTransactionHistory(String userId) {
        List<Transaction> returnedTransactionsByUserId = transactionRepository.findByUserId(userId);
        return transactionMapper.transactionListToTransactionRequestList(returnedTransactionsByUserId);
    }
}
