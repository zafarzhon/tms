package com.teachmeskills.il_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teachmeskills.il_service.dto.ErrorDto;
import com.teachmeskills.il_service.exception.BicycleException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> {

            try (InputStream inputStream = response.body().asInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                ErrorDto errorDto = objectMapper.readValue(inputStream, ErrorDto.class);
                return new BicycleException(errorDto.getCode(),
                        errorDto.getMessage());
            } catch (IOException e) {
                return new BicycleException(500, "unexpected error");
            }

        };
    }
}
