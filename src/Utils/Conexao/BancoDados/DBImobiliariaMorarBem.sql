create database DBImobiliariaMorarBem;

use DBImobiliariaMorarBem;

create table Usuario(
	id_usuario int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(50) not null,
    telefone varchar(20) not null,
    senha varchar(100) not null,
    tipo enum('ADMINISTRADOR', 'CORRETOR') not null,
    data_admissao date not null
);

create table Cliente(
	id_cliente int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(50) not null,
    telefone varchar(20) not null
);

create table Imovel(
	id_imovel int primary key auto_increment,
    titulo varchar(255) not null,
    endereco varchar(100) not null,
    descricao varchar(255) not null,
    tipo enum('CASA', 'APARTAMENTO', 'LOJA', 'GALPÃO', 'PREDIO COMERCIAL') not null,
    preco decimal(10,2) not null,
    status_imovel enum('DISPONIVEL', 'VENDIDO', 'ALUGADO') not null
);

create table contrato(
	id_contrato int primary key auto_increment,
    id_cliente int,
    id_imovel int,
    id_usuario int,
    tipo enum('VENDA', 'ALUGUEL') not null,
    preco decimal(10,2) not null,
    data_inicio date not null,
    data_fim date not null,
    foreign key (id_cliente) references Cliente(id_cliente),
    foreign key (id_imovel) references Imovel(id_imovel),
    foreign key (id_usuario) references Usuario(id_usuario)
);