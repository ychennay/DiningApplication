package main.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ray Xiao on 4/18/17.
 */

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500

public class InternalErrorException extends RuntimeException {
    public InternalErrorException(String msg){
        super(msg);
    }
}