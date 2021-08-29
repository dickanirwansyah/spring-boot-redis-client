package com.core.be.appbe.service.transaction;

import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.model.entity.Transaction;
import com.core.be.appbe.model.request.TransactionRequest;
import com.core.be.appbe.model.response.TransactionResponse;
import com.core.be.appbe.repository.ProductRepository;
import com.core.be.appbe.repository.TransactionRepository;
import com.core.be.appbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class PostNewTransactionService implements BaseService<TransactionRequest, TransactionResponse> {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TransactionResponse execute(TransactionRequest request) {
        return null;
    }
}
