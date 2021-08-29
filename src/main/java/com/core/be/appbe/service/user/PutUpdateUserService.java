package com.core.be.appbe.service.user;

import com.core.be.appbe.common.exception.GlobalErrorException;
import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.common.util.Constants;
import com.core.be.appbe.model.entity.Role;
import com.core.be.appbe.model.entity.User;
import com.core.be.appbe.model.request.UserRequest;
import com.core.be.appbe.model.response.ValidResponse;
import com.core.be.appbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class PutUpdateUserService implements BaseService<UserRequest, ValidResponse> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ValidResponse execute(UserRequest request) {
        AtomicReference<User> responseUser = new AtomicReference<>();
        userRepository.findById(request.getId())
                .ifPresentOrElse(user -> {
                    user.setPassword(request.getPassword());
                    user.setRole(request.getRole().equals(Role.ADMIN) ? Role.ADMIN : Role.USER);
                    user.setUsername(request.getUsername());
                    user.setStatus(request.getStatus());
                    responseUser.set(userRepository.save(user));
                }, () -> {
                    throw new GlobalErrorException(Constants.MSG_NOTFOUND);
                });

        return ValidResponse.builder()
                .response(responseUser.get())
                .build();
    }
}
