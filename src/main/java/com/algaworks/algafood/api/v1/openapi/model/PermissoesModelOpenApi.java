package com.algaworks.algafood.api.v1.openapi.model;

import com.algaworks.algafood.api.v1.model.PermissaoModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("PermissoesModel")
@Data
public class PermissoesModelOpenApi {

    private PermissoesModelOpenApi.PermissaoEmbeddedModelOpenApi _embedded;
    private Links _links;

    @ApiModel("PermissoesEmbeddedModel")
    @Data
    private static class PermissaoEmbeddedModelOpenApi {

        private List<PermissaoModel> permissoes;
    }
}
