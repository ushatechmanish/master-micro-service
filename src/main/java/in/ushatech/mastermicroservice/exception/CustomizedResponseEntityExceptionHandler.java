package in.ushatech.mastermicroservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDetails> handleAllExceptions(
            Exception ex, WebRequest request)
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<ErrorDetails> handleUserNotFoundException(
            Exception ex, WebRequest request)
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
    {
        String message = "Error Count:"+Integer.toString(ex.getErrorCount());
        for(var error : ex.getFieldErrors())
        {
            message+=" "+error.getDefaultMessage();
        }

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),message,request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}

