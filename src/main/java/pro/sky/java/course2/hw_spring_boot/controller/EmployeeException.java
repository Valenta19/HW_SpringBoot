package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class EmployeeException {
    @ExceptionHandler
    public ResponseEntity<?> RuntimeException(RuntimeException runtimeException) {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> IOException(IOException ioException) {

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
