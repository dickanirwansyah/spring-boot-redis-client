package com.core.be.appbe.service.user;

import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.model.entity.Role;
import com.core.be.appbe.model.entity.User;
import com.core.be.appbe.model.request.UserRequest;
import com.core.be.appbe.model.response.ValidResponse;
import com.core.be.appbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostNewUserService implements BaseService<UserRequest, ValidResponse> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ValidResponse execute(UserRequest request) {
        log.info("PostNewUserService : {}", request);
        User responseUser = userRepository.save(User.builder()
                .password(request.getPassword())
                .username(request.getUsername())
                .role(request.getRole().equals(Role.ADMIN.name()) ? Role.ADMIN : Role.USER)
                .status(request.getStatus())
                .build());

        return ValidResponse.builder()
                .response(responseUser)
                .build();
    }
}
