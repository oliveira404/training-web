package br.com.treinaweb.ediaristas.api.handlers;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

import br.com.treinaweb.ediaristas.api.dtos.responses.ErrorResponse;
import br.com.treinaweb.ediaristas.core.services.consultaendereco.exceptions.EnderecoServiceException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private SnakeCaseStrategy camelCaseToSnakeCase = new SnakeCaseStrategy();

    @ExceptionHandler(EnderecoServiceException.class)
    public ResponseEntity<Object> handleEnderecoServiceException(EnderecoServiceException ex, HttpServletRequest request) {
        var errorResponse = ErrorResponse.builder()
        .status(HttpStatus.BAD_REQUEST.value())
        .timeStamp(LocalDateTime.now())
        .mensagem(ex.getLocalizedMessage())
        .path(request.getRequestURI())
        .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
            
                var body = new HashMap<String, List<String>>();   
            
                ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
                var field = camelCaseToSnakeCase.translate(fieldError.getField());
                
                if (!body.containsKey(field)) {
                    var fieldErros = new ArrayList<String>();
                    fieldErros.add(fieldError.getDefaultMessage());
                    body.put(field, fieldErros); 
                } else {
                    body.get(field).add(fieldError.getDefaultMessage());
                }
            }); 
            return ResponseEntity.badRequest().body(body);
    }
}