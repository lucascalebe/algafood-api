package com.algaworks.algafood.core.email;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Getter
@Setter
@Component
@ConfigurationProperties("algafood.email")
public class EmailProperties {

	@NotNull
	private String remetente;
	
	private Implementacao impl = Implementacao.FAKE;
	
	private Sandbox sandbox = new Sandbox();
	
	@Getter
	@Setter
	public class Sandbox {
		private String destinatario;
	}
	
	public enum Implementacao {
		FAKE,SMTP,SANDBOX;
	}
}
