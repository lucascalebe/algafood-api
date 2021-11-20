package com.algaworks.algafood.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

// Fonte: https://github.com/spring-projects/spring-hateoas/issues/263#issuecomment-358969098
@Component
public class HalCustomMediaTypeEnabler {

    //Ao mudar produces/accept do controller o formato hal do json é perdido, essa classe o recupera.

    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Autowired
    public HalCustomMediaTypeEnabler(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;
    }

    @PostConstruct
    public void enableVndHalJson() {
        for (HttpMessageConverter<?> converter : requestMappingHandlerAdapter.getMessageConverters()) {
            if (converter instanceof MappingJackson2HttpMessageConverter
                    && converter.getSupportedMediaTypes().contains(MediaTypes.HAL_JSON)) {

                MappingJackson2HttpMessageConverter messageConverter = (MappingJackson2HttpMessageConverter) converter;
                messageConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON,
                        AlgaMediaTypes.V1_APPLICATION_JSON,AlgaMediaTypes.V2_APPLICATION_JSON));
            }
        }
    }
}
