package com.core.be.appbe.service.user;


import com.core.be.appbe.common.exception.GlobalErrorException;
import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.common.util.Constants;
import com.core.be.appbe.model.request.FindUserByParamRequest;
import com.core.be.appbe.model.response.UserResponse;
import com.core.be.appbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetUserbyUsernameService implements BaseService<FindUserByParamRequest, UserResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse execute(FindUserByParamRequest request) {
        log.info("request by username : {} ",request.getUsername());
        return userRepository.findByUsername(request.getUsername())
                .map(user -> UserResponse
                        .builder()
                        .id(user.getId())
                        .role(user.getRole().name())
                        .status(user.getStatus())
                        .username(user.getUsername())
                        .build())
                .orElseThrow(() -> new GlobalErrorException(Constants.MSG_NOTFOUND));
    }
}
