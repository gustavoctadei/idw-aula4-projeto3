create table categoria (
	id_categoria int not null auto_increment,
	descricao varchar(50) not null,
	primary key (id_categoria)
);

create table filme (
	id_filme int not null auto_increment,
	id_categoria int not null,
	descricao varchar(50) not null,
	ano date null,
	primary key (id_filme),
	
	foreign key (id_categoria)
		references categoria(id_categoria)
);

create table midia (
	id_midia int not null auto_increment,
	id_filme int not null,
	inutilizada bool not null,
	primary key (id_midia),
	
	foreign key (id_filme)
		references filme(id_filme)
);

create table endereco (
	id_endereco int not null auto_increment,
	rua varchar(100) not null,
	numero varchar(50) not null,
	bairro varchar(100) not null,
	cidade varchar(100) not null,
	estado char(2) not null,
	cep varchar(10) not null,
	complemento text null,
	primary key (id_endereco)
);

create table cliente (
	id_cliente int not null auto_increment,
	nome varchar(100) not null,
	telefone varchar(50) null,
	celular varchar(50) null,
	email varchar(255) not null,
	id_endereco int null,
	primary key (id_cliente),
	
	foreign key (id_endereco)
		references endereco(id_endereco)
);

create table locacao (
	id_locacao int not null auto_increment,
	id_cliente int not null,
	id_midia int not null,
	data_emprestimo timestamp not null,
	data_devolucao date not null,
	observacao text null,
	primary key (id_locacao),
	
	foreign key (id_cliente)
		references cliente(id_cliente),
	
	foreign key (id_midia)
		references midia(id_midia)
);
