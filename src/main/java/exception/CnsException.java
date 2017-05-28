package main.java.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ray Xiao on 4/21/17.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
public class CnsException extends RuntimeException{
    @Getter
    final private CnsErrorCode errorCode;
    @Getter
    final private String sessionId;

    public CnsException(CnsErrorCode errorCode, String errorMessage, String sessionId){
        super(errorMessage);
        this.errorCode=errorCode;
        this.sessionId = sessionId;
    }
}