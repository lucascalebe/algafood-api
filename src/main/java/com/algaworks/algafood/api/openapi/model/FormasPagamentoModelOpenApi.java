package com.algaworks.algafood.api.openapi.model;

import com.algaworks.algafood.api.model.FormaPagamentoModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("FormasPagamentoModel")
@Data
public class FormasPagamentoModelOpenApi {

    private FormasPagamentoModelOpenApi.FormaPagamentoEmbeddedModelOpenApi _embedded;
    private Links _links;

    @ApiModel("FormasPagamentoEmbeddedModel")
    @Data
    private static class FormaPagamentoEmbeddedModelOpenApi {

        private List<FormaPagamentoModel> formasPagamento;
    }
}
