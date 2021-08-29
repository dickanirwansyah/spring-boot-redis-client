package com.core.be.appbe.common.util;

public class Constants {

    private Constants(){
        throw new IllegalArgumentException();
    }

    public static final String MSG_SUCCESS = "hooray..successfully";
    public static final String MSG_FAILED = "ups..failed";
    public static final String MSG_ERROR = "ups..something wrong";
    public static final String MSG_NOTFOUND = "ups..data not found";
    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_FAILED = 400;
    public static final Integer CODE_ERROR = 500;
    public static final Integer DELETED = 1;
}
