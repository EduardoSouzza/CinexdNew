
CREATE TABLE Cliente (
id_cliente BIGSERIAL PRIMARY KEY,
Nome VARCHAR(254),
Senha VARCHAR(254),
Email VARCHAR(254)
)

CREATE TABLE Filme (
id_filme BIGSERIAL PRIMARY KEY,
Nome VARCHAR(254),
Diretor VARCHAR(254),
Elenco VARCHAR(254),
Classificacao INTEGER,
Sinopse VARCHAR(5000),
Duracao INTEGER,
DataLancamento VARCHAR(254),
Genero VARCHAR(254)
);
﻿CREATE TABLE Perfil (
	id_perfil  BIGSERIAL PRIMARY KEY,
	id_filme INTEGER,
	Acao INTEGER,
	Terror INTEGER,
	Suspense INTEGER,
	Animacao INTEGER,
	Documentario INTEGER,
	Comedia INTEGER,
	Romance INTEGER,
	FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
);
CREATE TABLE Cinema (
id_cinema BIGSERIAL PRIMARY KEY,
Nome VARCHAR(254),
Endereco VARCHAR(254),
Cidade VARCHAR(254),
Telefone varchar(254)
)

CREATE TABLE Ingresso (
id_engresso BIGSERIAL PRIMARY KEY,
id_filme INTEGER,
Data_filme VARCHAR(254),
Valor DECIMAL,
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
)

CREATE TABLE Compras (
id_compras BIGSERIAL PRIMARY KEY,
id_cliente INTEGER,
Data_Compra VARCHAR(254),
Total DECIMAL,
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente)
)

CREATE TABLE Produto (
idProduto  BIGSERIAL PRIMARY KEY,
NomeProduto VARCHAR(254),
TipoProduto VARCHAR(254),
PrecoProduto DECIMAL,
QtdProduto INTEGER
)

Create TABLE Perfil_cliente(
id_perfil  BIGSERIAL PRIMARY KEY,
id_cliente INTEGER,
Acao INTEGER,
Terror INTEGER,
Suspense INTEGER,
Animacao INTEGER,
Documentario INTEGER,
Comedia INTEGER,
Romance INTEGER,
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente))


CREATE TABLE Salas (
id_sala BIGSERIAL PRIMARY KEY,
id_cinema INTEGER,
Nome VARCHAR(254),
FOREIGN KEY(id_cinema) REFERENCES Cinema (id_cinema)
)

CREATE TABLE Filmes_Cinemas (
id_cinema BIGSERIAL,
id_filme INTEGER,
FOREIGN KEY(id_cinema) REFERENCES Cinema (id_cinema),
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
)

CREATE TABLE Ingresso_Compras (
id_compras BIGSERIAL,
id_engresso INTEGER,
Quantidade INTEGER,
FOREIGN KEY(id_compras) REFERENCES Compras (id_compras),
FOREIGN KEY(id_engresso) REFERENCES Ingresso (id_engresso)
)

CREATE TABLE Compras_Produto (
id_compras INTEGER,
id_produto  INTEGER,
Quantidade INTEGER,
FOREIGN KEY(id_compras) REFERENCES Compras (id_compras),
FOREIGN KEY(id_produto) REFERENCES Produto (idProduto)
)
