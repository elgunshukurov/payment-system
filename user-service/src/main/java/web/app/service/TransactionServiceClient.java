package web.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.app.dto.request.TransactionRequest;

import java.util.List;

@FeignClient(name = "transaction-service", url = "http://localhost:8081")
public interface TransactionServiceClient {

    @GetMapping("/api/transactions/{userId}")
    List<TransactionRequest> getTransactionsForUser(@PathVariable String userId);

    @PostMapping("/api/transactions/add")
    void addTransaction(@RequestBody TransactionRequest transaction);

}
