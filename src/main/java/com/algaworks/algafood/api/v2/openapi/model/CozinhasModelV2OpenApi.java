package com.algaworks.algafood.api.v2.openapi.model;

import com.algaworks.algafood.api.v2.model.CozinhaModelV2;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("CozinhasModel")
@Setter
@Getter
public class CozinhasModelV2OpenApi {

    private CozinhasEmbeddedModelOpenApi _embedded;
    private Links _links;
    private PageModelV2OpenApi page;

    @ApiModel("CozinhasEmbeddedModel")
    @Data
    public static class CozinhasEmbeddedModelOpenApi {

        private List<CozinhaModelV2> cozinhas;

    }

}
