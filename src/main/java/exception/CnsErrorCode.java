package main.java.exception;

/**
 * Created by Ray Xiao on 4/21/17.
 */
public enum CnsErrorCode {

        AUTH_TOKEN_INVALID("UAT0001","Provided Auth Token is invalid"),
        AUTH_TOKEN_EXPIRED("UAT0002","Provided Auth Token expired");

        private String errorId;
        private String msg;

        CnsErrorCode(String errorId,String msg){
            this.errorId=errorId;
            this.msg=msg;

        }
    }

