package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
    @ExceptionHandler
    public ResponseEntity<?> runtimeException(RuntimeException runtimeException) {
        String massage = "Сотрудник не найден";
        return new ResponseEntity<>(massage, HttpStatus.BAD_REQUEST);
    }

}
