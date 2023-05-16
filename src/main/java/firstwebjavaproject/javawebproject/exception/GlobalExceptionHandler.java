package firstwebjavaproject.javawebproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LeagueNotEmptyException.class)
    public ResponseEntity<?> handleLeagueNotEmptyException(LeagueNotEmptyException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message" , exception.getMessage()));
    }
}
