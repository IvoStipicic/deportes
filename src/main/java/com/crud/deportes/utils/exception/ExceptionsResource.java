package com.crud.deportes.utils.exception;

import com.crud.deportes.utils.response.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionsResource {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionsResource.class);



    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> ApiResponse captureHttpException(String responseString, String metodo) {
        ObjectMapper mapper = new ObjectMapper();
        ApiResponse<T> result = new ApiResponse<T>();
        try {
            result = mapper.readValue(responseString, ApiResponse.class);
            logger.info("Captura respuesta error de servicio {}: {}" , metodo,result.toString());
        } catch (JsonMappingException e1) {
            logger.error("JsonMappingException ERROR: {}" , e1.getStackTrace().toString());
            //result.setGlosa(Constants.ERROR_INTERNO.concat(metodo.concat(": ")).concat(e1.getMessage()));
            result.setDetailMsg(e1.getMessage());
            ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
        } catch (JsonProcessingException e1) {
            logger.error("JsonProcessingException ERROR: {}" , e1.getStackTrace().toString());
           // result.setGlosa(Constants.ERROR_INTERNO.concat(metodo.concat(": ")).concat(e1.getMessage()));
            result.setDetailMsg(e1.getMessage());
            ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
        }
        return result;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> ApiResponse  captureHttpExceptionGlobal(String responseString, String metodo) {
        ObjectMapper mapper = new ObjectMapper();
        ApiResponse<T> result = new ApiResponse<T>();
        try {
            result = mapper.readValue(responseString, ApiResponse.class);
            logger.info("Captura respuesta error de servicio {}: {}" , metodo,result.toString());
        } catch (JsonMappingException e1) {
            logger.error("JsonMappingException ERROR: {}" , e1.getStackTrace().toString());
            //result.setGlosa(Constants.ERROR_INTERNO.concat(metodo.concat(": ")).concat(e1.getMessage()));
            result.setDetailMsg(e1.getMessage());
            ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
        } catch (JsonProcessingException e1) {
            logger.error("JsonProcessingException ERROR: {}" , e1.getStackTrace().toString());
            //result.setGlosa(Constants.ERROR_INTERNO.concat(metodo.concat(": ")).concat(e1.getMessage()));
            result.setDetailMsg(e1.getMessage());
            ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
        }
        return result;
    }


    @SuppressWarnings("rawtypes")
    public static <T> ApiResponse  captureDbException(T result, Exception e){
        ApiResponse<T> apiResponse = new ApiResponse<T>();

        apiResponse.setData(result);
        //apiResponse.setGlosa(Constants.ERROR.concat(Constants.ERROR_DATABASE.concat(e.getCause().getMessage())));
        apiResponse.setDetailMsg(e.getCause().toString());
        return apiResponse;
    }

}
