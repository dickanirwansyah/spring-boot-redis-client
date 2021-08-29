package com.core.be.appbe.controller;

import com.core.be.appbe.common.model.RestResponse;
import com.core.be.appbe.model.request.FindByIdRequest;
import com.core.be.appbe.model.request.FindUserByParamRequest;
import com.core.be.appbe.model.request.UserRequest;
import com.core.be.appbe.service.user.GetAllUserService;
import com.core.be.appbe.service.user.GetUserByIdService;
import com.core.be.appbe.service.user.PostNewUserService;
import com.core.be.appbe.service.user.PutUpdateUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.core.be.appbe.common.util.Constants.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class RestUserController {


    private PostNewUserService postNewUserService;
    private PutUpdateUserService putUpdateUserService;
    private GetUserByIdService getUserByIdService;
    private GetAllUserService getAllUserService;

    public RestUserController(PostNewUserService postNewUserService,
                              PutUpdateUserService putUpdateUserService,
                              GetUserByIdService getUserByIdService,
                              GetAllUserService getAllUserService){

        this.postNewUserService = postNewUserService;
        this.putUpdateUserService = putUpdateUserService;
        this.getUserByIdService = getUserByIdService;
        this.getAllUserService = getAllUserService;
    }

    @PostMapping(value = "/new-user")
    public ResponseEntity<RestResponse> newUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok()
                .body(RestResponse.builder()
                        .message(MSG_SUCCESS)
                        .data(postNewUserService.execute(userRequest))
                        .status(CODE_SUCCESS)
                        .build());
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity<RestResponse> updateUser(@PathVariable("id")Long id,
                                                   @RequestBody UserRequest userRequest){
        userRequest.setId(id);
        return ResponseEntity.ok()
                .body(RestResponse.builder()
                        .message(MSG_SUCCESS)
                        .data(putUpdateUserService.execute(userRequest))
                        .status(CODE_SUCCESS)
                        .build());
    }

    @GetMapping(value = "/get-by-id/{id}")
    public ResponseEntity<RestResponse> getById(@PathVariable("id")Long id){
        FindByIdRequest findByIdRequest = new FindByIdRequest();
        findByIdRequest.setId(id);
        return ResponseEntity.ok()
                .body(RestResponse.builder()
                        .message(MSG_SUCCESS)
                        .status(CODE_SUCCESS)
                        .data(getUserByIdService.execute(findByIdRequest))
                        .build());
    }

    @GetMapping(value = "/get-all-users")
    public ResponseEntity<RestResponse> getAllUsers(FindUserByParamRequest paramRequest){
        return ResponseEntity.ok()
                .body(RestResponse.builder()
                        .status(CODE_SUCCESS)
                        .message(MSG_SUCCESS)
                        .data(getAllUserService.execute(paramRequest))
                        .build());
    }

}
