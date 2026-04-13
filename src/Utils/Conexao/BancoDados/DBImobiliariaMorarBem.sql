create database DBImobiliariaMorarBem;

use DBImobiliariaMorarBem;

create table usuario(
	id_usuario int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(50) not null,
    telefone varchar(20) not null,
    senha varchar(100) not null,
    tipo enum('ADMINISTRADOR', 'CORRETOR') not null,
    data_admissao date not null,
    id_administrador int,
    foreign key (id_administrador) references Usuario(id_administrador)
);

create table cliente(
	id_cliente int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(50) not null,
    telefone varchar(20) not null
);

create table imovel(
	id_imovel int primary key auto_increment,
    titulo varchar(255) not null,
    endereco varchar(100) not null,
    descricao varchar(255) not null,
    tipo enum('CASA', 'APARTAMENTO', 'LOJA', 'GALPÃO', 'PREDIO COMERCIAL') not null,
    preco decimal(10,2) not null,
    intencao enum('VENDA', 'ALUGUEL'),
    status_imovel enum('DISPONIVEL', 'VENDIDO', 'ALUGADO') not null,
    id_cliente int,
    foreign key (id_cliente) references cliente(id_cliente)
);

create table contrato(
	id_contrato int primary key auto_increment,
    id_cliente int,
    id_imovel int,
    id_usuario int,
    tipo enum('VENDA', 'ALUGUEL') not null,
    preco decimal(10,2) not null,
    data_inicio date not null,
    data_fim date,
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_imovel) references imovel(id_imovel),
    foreign key (id_usuario) references usuario(id_usuario)
);

select * from Usuario;

select * from Imovel;

alter table Usuario add id_administrador int;

alter table Imovel add intencao varchar(20);