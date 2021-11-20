package com.algaworks.algafood.core.springfox;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.*;
import com.algaworks.algafood.api.v1.openapi.model.*;
import com.algaworks.algafood.api.v2.model.CidadeModelV2;
import com.algaworks.algafood.api.v2.model.CozinhaModelV2;
import com.algaworks.algafood.api.v2.openapi.model.CidadesModelV2OpenApi;
import com.algaworks.algafood.api.v2.openapi.model.CozinhasModelV2OpenApi;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig implements WebMvcConfigurer {

	
	//springFox escaneia todos controllers e gera JSON
	@Bean
	public Docket apiDocketV1() {
		var typeResolver = new TypeResolver();
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V1")
				.select()  
					.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
					.paths(PathSelectors.ant("/v1/**"))
					.build()
				.useDefaultResponseMessages(false)	
				.globalResponseMessage(RequestMethod.GET, globalGetResponseMessage())
				.globalResponseMessage(RequestMethod.POST, globalPostPutResponseMessage())
				.globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessage())
				.globalResponseMessage(RequestMethod.PUT, globalPostPutResponseMessage())
				.additionalModels(typeResolver.resolve(Problem.class))
				.ignoredParameterTypes(
						ServletWebRequest.class,
						URL.class,
						URI.class,
						URLStreamHandler.class,
						Resource.class,
						File.class,
						InputStream.class)
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.directModelSubstitute(Links.class, LinksModelOpenApi.class)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(PagedModel.class, CozinhaModel.class), CozinhasModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(PagedModel.class, PedidoResumoModel.class), PedidosResumoModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, CidadeModel.class), CidadesModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, EstadoModel.class), EstadosModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, FormaPagamentoModel.class), FormasPagamentoModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, GrupoModel.class), GruposModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, PermissaoModel.class), PermissoesModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, ProdutoModel.class), ProdutosModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, RestauranteBasicoModel.class),
						RestaurantesBasicoModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, UsuarioModel.class),
						UsuariosModelOpenApi.class))
				.apiInfo(apiInfoV1())
				.tags(new Tag("Cidades", "Gerencia as cidades"),
						new Tag("Grupos", "Gerencia os grupos"),
						new Tag("Formas de Pagamento", "Gerencia as formas de pagamento"),
						new Tag("Pedidos", "Gerencia os pedidos"),
						new Tag("Restaurantes", "Gerencia os restaurantes"),
						new Tag("Usuários", "Gerencia os usuários"),
						new Tag("Estados", "Gerencia os estados"),
						new Tag("Produtos", "Gerencia os produtos"),
						new Tag("Estatísticas", "Estatísticas da AlgaFood"),
						new Tag("Cozinhas", "Gerencia as cozinhas"),
						new Tag("Permissões", "Gerencia as permissões"));
	}


	@Bean
	public Docket apiDocketV2() {
		var typeResolver = new TypeResolver();

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V2")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
				.paths(PathSelectors.ant("/v2/**"))
				.build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, globalGetResponseMessage())
				.globalResponseMessage(RequestMethod.POST, globalPostPutResponseMessage())
				.globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessage())
				.globalResponseMessage(RequestMethod.PUT, globalPostPutResponseMessage())
				.additionalModels(typeResolver.resolve(Problem.class))
				.ignoredParameterTypes(
						ServletWebRequest.class,
						URL.class,
						URI.class,
						URLStreamHandler.class,
						Resource.class,
						File.class,
						InputStream.class)
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.directModelSubstitute(Links.class, LinksModelOpenApi.class)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(PagedModel.class, CozinhaModelV2.class),
						CozinhasModelV2OpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, CidadeModelV2.class),
						CidadesModelV2OpenApi.class))
				.apiInfo(apiInfoV2())

				.tags(new Tag("Cidades", "Gerencia as cidades"),
						new Tag("Cozinhas", "Gerencia as cozinhas"));
			}
	
	private List<ResponseMessage> globalPostPutResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(400)
					.message("Requisição inválida (erro do cliente)")
					.responseModel(new ModelRef("Problema"))
					.build(),
					
					new ResponseMessageBuilder()
					.code(500)
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
					
					new ResponseMessageBuilder()
					.code(406)
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
					
				new ResponseMessageBuilder()
					.code(415)
					.message("Requisição recusada porque o corpo está em um formato não suportado")
					.responseModel(new ModelRef("Problema"))
					.build()
				);
	}

	private List<ResponseMessage> globalDeleteResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(400)
					.message("Requisição inválida (erro do cliente)")
					.responseModel(new ModelRef("Problema"))
					.build(),
					
				new ResponseMessageBuilder()
					.code(500)
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build()
				);
	}

	private List<ResponseMessage> globalGetResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(500)
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
					
				new ResponseMessageBuilder()
					.code(406)
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build()
				);
	}
	
	// informações na pagina HTML do swagger UI
	private ApiInfo apiInfoV1() {
		return new ApiInfoBuilder()
				.title("Algafood API")
				.description("API aberta para clientes e restaurantes")
				.version("1")
				.contact(new Contact("Lucas Calebe","https://www.linkedin.com/in/lucas-calebe-73263290/",
						"lucascalebe07@hotmail.com"))
				.build();
	}


	private ApiInfo apiInfoV2() {
		return new ApiInfoBuilder()
				.title("Algafood API")
				.description("API aberta para clientes e restaurantes")
				.version("2")
				.contact(new Contact("Lucas Calebe","https://www.linkedin.com/in/lucas-calebe-73263290/",
						"lucascalebe07@hotmail.com"))
				.build();
	}

	//swagger ui gerar documentação HTML
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
