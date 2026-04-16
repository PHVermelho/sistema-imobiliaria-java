create database DBImobiliariaMorarBem;

use DBImobiliariaMorarBem;

create table funcionario(
	id_funcionario int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(50) not null,
    telefone varchar(20) not null,
    senha varchar(100) not null,
    cargo enum('ADMINISTRADOR', 'CORRETOR') not null,
    id_administrador int,
    foreign key (id_administrador) references funcionario(id_funcionario)
);

create table cliente(
	id_cliente int primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(20),
    email varchar(50) not null,
    telefone varchar(20) not null,
    id_funcionario int,
    foreign key (id_funcionario) references funcionario(id_funcionario)
);

create table imovel(
	id_imovel int primary key auto_increment,
    endereco varchar(100) not null,
    descricao varchar(255) not null,
    tipo enum('CASA', 'APARTAMENTO', 'LOJA', 'GALPÃO', 'PREDIO COMERCIAL') not null,
    preco decimal(10,2) not null,
    intencao enum('VENDA', 'ALUGUEL'),
    status_imovel enum('DISPONIVEL', 'VENDIDO', 'ALUGADO') not null,
    id_proprietario int,
    foreign key (id_proprietario) references cliente(id_cliente)
);

create table contrato(
	id_contrato int primary key auto_increment,
    id_funcionario int,
    id_imovel int,
    id_vendedor int,
    id_comprador int,
    tipo enum('VENDA', 'ALUGUEL') not null,
    preco decimal(10,2) not null,
    data_inicio date not null,
    data_fim date,
    foreign key (id_funcionario) references funcionario(id_funcionario),
    foreign key (id_imovel) references imovel(id_imovel),
    foreign key (id_comprador) references cliente(id_cliente),
    foreign key (id_vendedor) references cliente(id_cliente)
);

select * from funcionario;

select * from cliente;

select * from imovel;

select * from contrato;