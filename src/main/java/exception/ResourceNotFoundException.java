package main.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ray Xiao on 4/18/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)  // 404

public class ResourceNotFoundException extends RuntimeException {

}