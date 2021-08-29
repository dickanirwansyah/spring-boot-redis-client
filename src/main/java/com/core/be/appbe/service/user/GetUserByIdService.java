package com.core.be.appbe.service.user;

import com.core.be.appbe.common.exception.GlobalErrorException;
import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.common.util.Constants;
import com.core.be.appbe.model.request.FindByIdRequest;
import com.core.be.appbe.model.response.ValidResponse;
import com.core.be.appbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetUserByIdService implements BaseService<FindByIdRequest, ValidResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ValidResponse execute(FindByIdRequest request) {

        return userRepository.findById(request.getId())
                .map(user -> ValidResponse.builder()
                        .response(user)
                        .build())
                .orElseThrow(() -> new GlobalErrorException(Constants.MSG_NOTFOUND));

    }
}
