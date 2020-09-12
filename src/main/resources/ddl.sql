create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null, primary key (grupo_id, permissao_id)) engine=InnoDB
create table item_pedido (id bigint not null auto_increment, observacao varchar(255), preco_total decimal(19,2) not null, preco_unitario decimal(19,2) not null, quantidade integer not null, pedido_id integer not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6), data_criacao datetime(6) not null, data_entrega datetime(6), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status integer, subtotal decimal(19,2) not null, taxa_frete decimal(19,2) not null, valor_total decimal(19,2) not null, cliente_id bigint not null, endereco_cidade_id bigint, forma_pagamento_id bigint not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, aberto bit not null, ativo bit not null, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null, primary key (restaurante_id, forma_pagamento_id)) engine=InnoDB
create table restaurante_usuario_responsavel (restaurante_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
create table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null, primary key (usuario_id, grupo_id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FK37ms39e5dvx6m05hftvx9uavk foreign key (cliente_id) references usuario (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table restaurante_usuario_responsavel add constraint FKp5xoqly0jvjow2qtvsc6m2a8x foreign key (usuario_id) references usuario (id)
alter table restaurante_usuario_responsavel add constraint FKb6qllil4954tf7wg9x5xj3weo foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null, primary key (grupo_id, permissao_id)) engine=InnoDB
create table item_pedido (id bigint not null auto_increment, observacao varchar(255), preco_total decimal(19,2) not null, preco_unitario decimal(19,2) not null, quantidade integer not null, pedido_id integer not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6), data_criacao datetime(6) not null, data_entrega datetime(6), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status integer, subtotal decimal(19,2) not null, taxa_frete decimal(19,2) not null, valor_total decimal(19,2) not null, cliente_id bigint not null, endereco_cidade_id bigint, forma_pagamento_id bigint not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, aberto bit not null, ativo bit not null, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null, primary key (restaurante_id, forma_pagamento_id)) engine=InnoDB
create table restaurante_usuario_responsavel (restaurante_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
create table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null, primary key (usuario_id, grupo_id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FK37ms39e5dvx6m05hftvx9uavk foreign key (cliente_id) references usuario (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table restaurante_usuario_responsavel add constraint FKp5xoqly0jvjow2qtvsc6m2a8x foreign key (usuario_id) references usuario (id)
alter table restaurante_usuario_responsavel add constraint FKb6qllil4954tf7wg9x5xj3weo foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null, primary key (grupo_id, permissao_id)) engine=InnoDB
create table item_pedido (id bigint not null auto_increment, observacao varchar(255), preco_total decimal(19,2) not null, preco_unitario decimal(19,2) not null, quantidade integer not null, pedido_id integer not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6), data_criacao datetime(6) not null, data_entrega datetime(6), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status integer, subtotal decimal(19,2) not null, taxa_frete decimal(19,2) not null, valor_total decimal(19,2) not null, cliente_id bigint not null, endereco_cidade_id bigint, forma_pagamento_id bigint not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, aberto bit not null, ativo bit not null, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null, primary key (restaurante_id, forma_pagamento_id)) engine=InnoDB
create table restaurante_usuario_responsavel (restaurante_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
create table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null, primary key (usuario_id, grupo_id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FK37ms39e5dvx6m05hftvx9uavk foreign key (cliente_id) references usuario (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table restaurante_usuario_responsavel add constraint FKp5xoqly0jvjow2qtvsc6m2a8x foreign key (usuario_id) references usuario (id)
alter table restaurante_usuario_responsavel add constraint FKb6qllil4954tf7wg9x5xj3weo foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null, primary key (grupo_id, permissao_id)) engine=InnoDB
create table item_pedido (id bigint not null auto_increment, observacao varchar(255), preco_total decimal(19,2) not null, preco_unitario decimal(19,2) not null, quantidade integer not null, pedido_id integer not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6), data_criacao datetime(6) not null, data_entrega datetime(6), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status integer, subtotal decimal(19,2) not null, taxa_frete decimal(19,2) not null, valor_total decimal(19,2) not null, cliente_id bigint not null, endereco_cidade_id bigint, forma_pagamento_id bigint not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, aberto bit not null, ativo bit not null, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null, primary key (restaurante_id, forma_pagamento_id)) engine=InnoDB
create table restaurante_usuario_responsavel (restaurante_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
create table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null, primary key (usuario_id, grupo_id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FK37ms39e5dvx6m05hftvx9uavk foreign key (cliente_id) references usuario (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table restaurante_usuario_responsavel add constraint FKp5xoqly0jvjow2qtvsc6m2a8x foreign key (usuario_id) references usuario (id)
alter table restaurante_usuario_responsavel add constraint FKb6qllil4954tf7wg9x5xj3weo foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null, primary key (grupo_id, permissao_id)) engine=InnoDB
create table item_pedido (id bigint not null auto_increment, observacao varchar(255), preco_total decimal(19,2) not null, preco_unitario decimal(19,2) not null, quantidade integer not null, pedido_id integer not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6), data_criacao datetime(6) not null, data_entrega datetime(6), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status integer, subtotal decimal(19,2) not null, taxa_frete decimal(19,2) not null, valor_total decimal(19,2) not null, cliente_id bigint not null, endereco_cidade_id bigint, forma_pagamento_id bigint not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, aberto bit not null, ativo bit not null, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null, primary key (restaurante_id, forma_pagamento_id)) engine=InnoDB
create table restaurante_usuario_responsavel (restaurante_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
create table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null, primary key (usuario_id, grupo_id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FK37ms39e5dvx6m05hftvx9uavk foreign key (cliente_id) references usuario (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table restaurante_usuario_responsavel add constraint FKp5xoqly0jvjow2qtvsc6m2a8x foreign key (usuario_id) references usuario (id)
alter table restaurante_usuario_responsavel add constraint FKb6qllil4954tf7wg9x5xj3weo foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null, primary key (grupo_id, permissao_id)) engine=InnoDB
create table item_pedido (id bigint not null auto_increment, observacao varchar(255), preco_total decimal(19,2) not null, preco_unitario decimal(19,2) not null, quantidade integer not null, pedido_id integer not null, produto_id bigint not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, data_cancelamento datetime(6), data_confirmacao datetime(6), data_criacao datetime(6) not null, data_entrega datetime(6), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status integer, subtotal decimal(19,2) not null, taxa_frete decimal(19,2) not null, valor_total decimal(19,2) not null, cliente_id bigint not null, endereco_cidade_id bigint, forma_pagamento_id bigint not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit not null, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, aberto bit not null, ativo bit not null, data_atualizacao datetime not null, data_cadastro datetime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null, primary key (restaurante_id, forma_pagamento_id)) engine=InnoDB
create table restaurante_usuario_responsavel (restaurante_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255) not null, nome varchar(255) not null, senha varchar(255) not null, primary key (id)) engine=InnoDB
create table usuario_grupo (usuario_id bigint not null, grupo_id bigint not null, primary key (usuario_id, grupo_id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id)
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto (id)
alter table pedido add constraint FK37ms39e5dvx6m05hftvx9uavk foreign key (cliente_id) references usuario (id)
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade (id)
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
alter table restaurante_usuario_responsavel add constraint FKp5xoqly0jvjow2qtvsc6m2a8x foreign key (usuario_id) references usuario (id)
alter table restaurante_usuario_responsavel add constraint FKb6qllil4954tf7wg9x5xj3weo foreign key (restaurante_id) references restaurante (id)
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id)
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id)
