package com.core.be.appbe.service.user;

import com.core.be.appbe.common.service.BasePageableService;
import com.core.be.appbe.common.util.PageableUtil;
import com.core.be.appbe.model.entity.User;
import com.core.be.appbe.model.request.FindUserByParamRequest;
import com.core.be.appbe.model.response.ListUserResponse;
import com.core.be.appbe.model.response.UserResponse;
import com.core.be.appbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetAllUserService extends BasePageableService<FindUserByParamRequest, ListUserResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ListUserResponse execute(FindUserByParamRequest request) {
        Page<User> userPage = listUser(request);
        ListUserResponse listUserResponse = new ListUserResponse();
        List<UserResponse> userResponses = userPage.getContent()
                .stream()
                .map(user -> UserResponse.builder()
                        .username(user.getUsername())
                        .status(user.getStatus())
                        .role(user.getRole().name())
                        .id(user.getId())
                        .build()).collect(Collectors.toList());

        listUserResponse.setContent(userResponses);
        listUserResponse.setPagination(PageableUtil.pageToPagination(userPage));
        return listUserResponse;
    }

    private Page<User> listUser(FindUserByParamRequest paramRequest){
        String sortBy = paramRequest.getSortBy() != null && !paramRequest.getSortBy().isEmpty() ? paramRequest.getSortBy() : "id";
        Pageable userPageable = PageableUtil.createPageRequest(paramRequest, getPageSize(), getPageNumber(), sortBy, getSortType());
        Page<User> userPage;

        if (paramRequest.getUsername() != null || paramRequest.getStatus() != null || paramRequest.getRole() != null ){
            userPage = userRepository.getUserByParam(
                    paramRequest.getUsername() == null ? "" : paramRequest.getUsername(),
                    paramRequest.getStatus() == null ? "" : paramRequest.getStatus() ,
                    paramRequest.getRole() == null ? "" : paramRequest.getRole(), userPageable);
        }else{
            userPage = userRepository.getAllUsers(userPageable);
        }
        return userPage;
    }
}
