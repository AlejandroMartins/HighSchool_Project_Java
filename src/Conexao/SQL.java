drop database restaurante;
create database restaurante;
use restaurante;

create table usuario(
name varchar(50),
password varchar(50)
);

insert into usuario values ('Ale', '1310');

create table MetodoPagamento(
id_metodopagamento integer (5) auto_increment not null,
tipo varchar (50),
primary key (id_metodopagamento)
);

/*Pessoas*/

create table Funcionario (
  id_funcionario integer(5) auto_increment primary key,
  nome varchar(100),
  cpf varchar (20),
  usuario varchar(50),
  senha varchar(50),
  salario decimal(10,2),
  celular varchar(30),
  cep varchar(100),
  rua varchar (255),
  numero integer(5),
  complemento varchar (200),
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2),
   cargo varchar(100)
);


create table Fornecedor(
id_fornecedor integer (5) auto_increment not null,
nome varchar (20) not null,
cnpj varchar(14) not null,
email varchar (50) not null,
celular varchar(30),
cep varchar(100),
rua varchar (255),
numero integer(5),
complemento varchar (200),
bairro varchar (100),
cidade varchar (100),
estado varchar (50),
primary key (id_fornecedor)
);

/* Grupos */

create table GrupoProduto(
id_GrupoProduto integer(5)  auto_increment not null,
nome varchar(30) not null,
primary key(id_GrupoProduto)
);

create table SubGrupoProduto(
id_subGrupoProduto integer(5)  auto_increment not null,
GrupoProduto_id integer (5) not null,
nome varchar(30) not null,
primary key (id_subGrupoProduto),
foreign key (GrupoProduto_id) references GrupoProduto(id_GrupoProduto)
); 

create table GrupoIngrediente(
id_GrupoIngrediente integer(5) not null auto_increment,
nome varchar(30) not null, 
primary key (id_GrupoIngrediente)
);

create table SubGrupoIngrediente(
id_subGrupoIngrediente integer(5) not null auto_increment,
GrupoIngrediente_id integer (5) not null,
nome varchar(30) not null,
primary key (id_subGrupoIngrediente),
foreign key (GrupoIngrediente_id) references GrupoIngrediente(id_GrupoIngrediente)
); 

/* Produtos */

create table Ingrediente(
id_ingrediente integer (5) auto_increment not null,
fornecedor_id integer (5) not null,
nome varchar (20) not null,
unid varchar (5) not null,
estoque float (6) not null,
valor float (6) not null,
foreign key (fornecedor_id) references Fornecedor(id_fornecedor),
primary key (id_ingrediente)
);

create table Produto(
id_produto integer (5) auto_increment not null,
fornecedor_id integer (5),
nome varchar (20) not null,
unid varchar (5) not null,
estoque float (6) not null,
valor float (6) not null,
foreign key (fornecedor_id) references Fornecedor(id_fornecedor),
primary key (id_produto)
);

create table ItemProduto(
id_itemproduto integer (5) auto_increment not null,
ingrediente_id integer (5) not null,
produto_id integer (5)not null,
quantidade integer(5) not null,
foreign key (produto_id) references Produto(id_produto),
foreign key (ingrediente_id) references ingrediente(id_ingrediente),
primary key (id_itemproduto)
);

/* Funcionamento */

create table Mesa(
id_mesa integer (5) auto_increment not null,
estado boolean not null,
primary key (id_mesa)
);

create table Pedido(
id_pedido integer (5) auto_increment not null,
mesa_id integer (5) not null,
funcionario_id integer (5) not null,
metodopagamento_id integer (5) not null,
valortotal float (10) not null,
hora varchar (20) not null,
dia varchar (20) not null,
primary key (id_pedido),
foreign key (metodopagamento_id) references MetodoPagamento(id_metodopagamento),
foreign key (mesa_id) references Mesa (id_mesa),
foreign key (funcionario_id) references Funcionario (id_funcionario)
);

create table ItemPedido(
id_itempedido integer (5) auto_increment not null,
pedido_id integer (5) not null,
produto_id integer (5) not null,
primary key (id_itempedido),
foreign key (pedido_id) references Pedido(id_pedido),
foreign key (produto_id) references Produto(id_produto)
);

create table Compra(
id_compra integer (5) auto_increment not null,
valortotal float (10) not null,
hora varchar(20) not null,
dia varchar(20) not null,
total float(10) not null,
metodopagamento_id integer (5) not null,
foreign key (metodopagamento_id) references MetodoPagamento(id_metodopagamento),
primary key (id_compra)
);

create table ItemCompra(
id_itemcompra integer (5) auto_increment not null,
compra_id integer (5) not null,
produto_id integer (5),
ingrediente_id integer (5),
quantidade integer (5) not null,
subtotal float (5) not null,
primary key (id_itemcompra),
foreign key (compra_id) references Compra(id_compra),
foreign key (produto_id) references Produto(id_produto),
foreign key (ingrediente_id) references Ingrediente(id_ingrediente)
);

/*Milhões de Insert*/

Insert into MetodoPagamento (id_metodopagamento, tipo)
value (null, 'Cartão de Credito'),
(null, 'Cartão de Debito'),
(null, 'Pix'),
(null, 'A vista'),
(null, 'Boleto');

Insert into GrupoProduto
value (null, ' Bebida'),
(null, 'Prato');

Insert into SubGrupoProduto
value (1, 1,'Refrigerante'),
(2, 1,'Suco'),
(3, 2,'Entrada'),
(4, 2,'Principal'),
(5, 1,'Vinho');

Insert into GrupoIngrediente
value (1, ' Carne'),
(2, 'Vegetal'),
(3, 'Tempero');

Insert into SubGrupoIngrediente
value (1, 1,'Frango'),
(2, 1,'Boi'),
(3, 1,'Porco'),
(4, 2,'Grão'),
(5, 2,'Folha'),
(6, 2,'Fruta'),
(7, 2,'Raiz'),
(8, 2,'Forte'),
(9, 2,'Fraco');

Insert into Mesa
value (1, true),
 (2, true),
 (3, true),
 (4, true),
 (5, true),
 (6, true),
 (7, true),
 (8, true),
 (9, true),
 (10, true),
 (11, true),
 (12, true),
 (13, true),
 (14, true),
 (15, true),
 (16, true),
 (17, true),
 (18, true),
 (19, true),
 (20, true),
 (21, true),
 (22, true),
 (23, true),
 (24, true),
 (25, true);
 

Insert into  funcionario (id_funcionario, nome,cpf,usuario,senha,salario,celular,cep,rua,numero,complemento,bairro,cidade,estado,cargo)
value (1,"Cara Hull",9115186560,"Cyrus","Melanie",149,"(53)91642-6287","39746333","R. Eric Surrame",28,"","Kay","Feira de Santana","RJ","Vendedor"),
  (2,"Hunter Church",48032986794,"Sydney","Ramona",149,"(72)98359-4813","73738-666","R. Gloria Surrame",20,"","Elaine","Belford Roxo","RJ","Peão"),
  (3,"Amos Gardner",85194603166,"Inez","Iris",151,"(44)98790-6466","43522-742","R. Desirae Surrame",872,"","Gage","Rio Grande","SP","Vendedor"),
  (4,"Sarah Mcdaniel",91984989594,"Plato","Keelie",139,"(24)94979-5472","67303-621","R. Irene Surrame",799,"","Keith","Campinas","CE","Vendedor"),
  (5,"Denise Gamble",73644738544,"Mercedes","Ann",114,"(34)96375-5717","61647-266","R. Austin Surrame",778,"","Alexander","Ribeirão Preto","GO","Peão"),
  (6,"Destiny Holder",38342480906,"Melyssa","Justine",144,"(14)98875-4443","65166-322","R. Moses Surrame",757,"","Cairo","Paço do Lumiar","CE","Recepcionista"),
  (7,"Wyatt Baker",81443056206,"Carson","Sandra",143,"(54)93347-8850","50077-775","R. Dale Surrame",297,"","Daquan","Caxias","RJ","Recepcionista"),
  (8,"Tashya Roberson",22498822835,"Hedley","Minerva",149,"(56)92864-5664","68348-936","R. Camille Surrame",491,"","Cameron","Vitória da Conquista","GO","Vendedor"),
  (9,"Drake Gomez",40925806698,"Yeo","Kiayada",121,"(76)96804-7554","37801651","R. Veronica Surrame",48,"","Gray","Florianópolis","CE","Vendedor"),
  (10,"Courtney Cortez",96436159296,"Richard","Minerva",121,"(87)98208-2629","22286-871","R. Dustin Surrame",109,"","Chandler","Sobral","PR","Peão"),
  (11,"Craig Olsen",17101396727,"Illana","Lara",115,"(37)97957-8068","25948-404","R. Rama Surrame",728,"","Moana","Jundiaí","SP","Peão"),
  (12,"Dillon Marquez",33279516951,"Unity","Cara",107,"(62)97658-1732","13306-655","R. Jane Surrame",246,"","Alexander","Cascavel","CE","Recepcionista"),
  (13,"Liberty Fuller",57161369193,"Chava","Latifah",108,"(53)96523-4071","60292-661","R. Hannah Surrame",48,"","Rhona","Cabo de Santo Agostinho","PB","Peão"),
  (14,"Jacob Campos",32140188600,"Winter","Adele",110,"(71)96169-8233","83203-718","R. Lacey Surrame",267,"","Garrison","Maranguape","CE","Recepcionista"),
  (15,"Zeus Wilkinson",46500150815,"Callie","Summer",131,"(97)94753-3103","63653-187","R. Whilemina Surrame",39,"","Allen","Piracicaba","SP","Recepcionista");

INSERT INTO Fornecedor (id_fornecedor,nome,cnpj,email,celular,cep,rua,numero,complemento,bairro,cidade,estado)
VALUES
  (1,"Tatyana Holmes",83026279270490,"semper@protonmail.org","(82) 92487-0388","80537-591","R. Chantale Patel",872,"","Dominic","Curitiba","Rio Grande do Sul"),
  (2,"Jolene Bartlett",17734622054322,"dis.parturient@icloud.org","(58) 98473-6071","62621-825","R. Eagan Alston",873,"","Daria","Jundiaí","Pernambuco"),
  (3,"Autumn Wolf",27290237833999,"ut.lacus@aol.net","(23) 96719-6794","65172-220","R. Jermaine Barnett",152,"","Cassidy","Cametá","Paraná"),
  (4,"Daquan Warner",33094627901357,"dapibus.id@aol.ca","(75) 95424-5664","65611-137","R. Tiger Patterson",509,"","Margaret","Osasco","Rio de Janeiro"),
  (5,"Rafael Herrera",56947984055101,"duis.mi.enim@google.couk","(82) 99378-1978","61875-805","R. Quyn Alexander",444,"","Rashad","João Pessoa","Maranhão"),
  (6,"Lesley Rasmussen",67392367212953,"pede.nunc.sed@aol.net","(82) 95488-3776","81826-832","R. Hedwig Church",415,"","Hillary","Diadema","São Paulo"),
  (7,"Wyatt Johnston",90694796524219,"elit.sed@icloud.net","(88) 91483-8505","74784-832","R. Britanney Conrad",738,"","Kay","Feira de Santana","Paraná"),
  (8,"Harrison Cunningham",67970175642674,"ipsum.ac.mi@icloud.net","(94) 95648-3270","58675-230","R. Aretha Thornton",987,"","Tad","Belém","Rio de Janeiro"),
  (9,"Hayley Patterson",99289039160348,"dignissim@icloud.org","(62) 92472-2691","16561-325","R. Amal Watson",526,"","Jin","Sobral","Bahia"),
  (10,"Chanda Waters",37072750222400,"felis.purus@yahoo.org","(95) 93842-7092","58392-960","R. Nomlanga Wagner",151,"","Erasmus","Rio Grande","Minas Gerais"),
  (11,"Lana Frye",17550992319882,"augue@protonmail.ca","(49) 94854-7296","89772-467","R. Mari Bell",452,"","Stone","Anápolis","Santa Catarina"),
  (12,"Barbara Battle",71551759358406,"integer.sem@outlook.couk","(00) 91958-2809","55528-743","R. Roth Hendricks",621,"","Kyle","Marabá","Pernambuco"),
  (13,"Jameson Mann",13573606137027,"non.egestas@protonmail.edu","(22) 98459-3629","52646-511","R. Raja Rutledge",76,"","Ivy","Caruaru","Maranhão"),
  (14,"Hunter Rogers",87459221995870,"quisque.varius@icloud.edu","(23) 90175-6263","65585-568","R. Craig Thomas",258,"","Lisandra","Criciúma","São Paulo"),
  (15,"Mohammad Cline",65897675892825,"diam@icloud.couk","(42) 95749-5654","44223-788","R. Shelley Wilkinson",780,"","Damian","Cabo de Santo Agostinho","Santa Catarina");

INSERT INTO Produto (id_produto,fornecedor_id,nome,unid,estoque,valor)
VALUES
  (1,2,"Porção Picanha","g",87,6.5),
  (2,3,"Frango a passarinho","g",4,5.5),
  (3,1,"Porção Tilapia","g",84,21.5),
  (4,4,"Coca 600","ml",85,2.5),
  (5,6,"Fanta 350","g",30,16.5),
  (6,5,"Arroz e feijão","ml",77,2.5),
  (7,4,"Sprite 350","ml",97,67.5),
  (8,7,"Coca 2L","L",39,52.5),
  (9,8,"Coca 1L","L",82,62.5),
  (10,1,"Bife acebolado","g",11,2.5),
  (11,9,"Pizza Calabresa","L",67,32.5),
  (12,4,"Pizza a moda","ml",90,47.5),
  (13,1,"Suco laranja","ml",35,72.5),
  (14,11,"Suco limão","ml",37,65.5),
  (15,12,"Caipirinha","ml",47,33.5),
  (16,13,"Mojito","ml",41,29.5),
  (17,14,"Feijoada","Kg",30,6.5),
  (18,11,"Strogonoff","L",97,52.5),
  (19,7,"Muceca","Kg",59,85.5),
  (20,2,"Lasanha","Kg",41,69.5);


INSERT INTO Ingrediente (id_ingrediente,fornecedor_id,nome,unid,estoque,valor)
VALUES
  (1,1,"Tomate","Kg",31,16.5),
  (2,2,"Abobrinha","Kg",0,87.5),
  (3,3,"Limão","Kg",32,68.5),
  (4,4,"Laranja","Kg",49,50.5),
  (5,5,"Peito de Frango","g",55,66.5),
  (6,6,"Coxa frango","L",41,65.5),
  (7,7,"Contra coxa frango","Kg",65,92.5),
  (8,8,"Costelinha porco","L",17,7.5),
  (9,9,"Alface","u",3,60.5),
  (10,14,"Vodka","ml",13,48.5),
  (11,11,"Queijo","g",80,22.5),
  (12,12,"Pimentão","g",62,71.5),
  (13,13,"Paprica","ml",94,69.5),
  (14,14,"Cebolinha","g",99,49.5),
  (15,15,"Oregano","g",29,43.5),
  (16,6,"Picanha","Kg",37,92.5),
  (17,11,"Chedar","Kg",64,71.5),
  (18,1,"Barbecue","L",93,34.5),
  (19,3,"Pão","ml",91,19.5),
  (20,7,"Bife","Kg",64,41.5);
   
INSERT INTO Pedido (id_pedido,mesa_id,funcionario_id,metodopagamento_id,valortotal,hora,dia)
VALUES
  (1,24,2,3,42.5,"9:10","23/Jul/2022"),
  (2,8,4,1,92.5,"9:47","7/Jan/2022"),
  (3,7,4,1,133.5,"8:08","20/Aug/2022"),
  (4,17,3,2,105.5,"8:33","9/Jun/2022"),
  (5,18,8,1,67.5,"9:50","22/Jan/2022"),
  (6,5,1,1,83.5,"11:28","3/Sep/2022"),
  (7,15,6,1,128.5,"9:16","24/Apr/2022"),
  (8,9,1,1,87.5,"9:57","17/Mar/2022"),
  (9,19,9,1,114.5,"7:48","6/Sep/2022"),
  (10,19,9,1,2.5,"9:48","6/Sep/2022"),
  (11,22,3,2,8.5,"8:55","11/May/2022"),
  (12,24,2,2,126.5,"11:49","16/Jun/2022"),
  (13,10,2,3,190.5,"7:55","23/Feb/2022"),
  (14,17,1,1,59.5,"9:56","19/Oct/2022"),
  (15,11,6,1,57.5,"11:59","19/Mar/2022"),
  (16,9,5,2,31.5,"7:54","9/Aug/2022"),
  (17,23,4,3,99.5,"11:43","17/Mar/2022"),
  (18,22,5,1,114.5,"7:30","12/May/2022"),
  (19,3,9,1,102.5,"11:31","20/Nov/2022"),
  (20,23,4,3,168.5,"7:22","7/Oct/2022");
 
INSERT INTO ItemPedido (id_itempedido,pedido_id,produto_id)
VALUES
  (1,7,15),
  (2,14,13),
  (3,5,2),
  (4,8,8),
  (5,9,4),
  (6,18,4),
  (7,7,9),
  (8,9,13),
  (9,1,17),
  (10,4,13),
  (11,5,16),
  (12,2,19),
  (13,8,18),
  (14,19,14),
  (15,11,20),
  (16,12,20),
  (17,8,16),
  (18,20,2),
  (19,2,14),
  (20,19,4),
  (21,1,2),
  (22,14,4),
  (23,2,4),
  (24,2,12),
  (25,12,16),
  (26,6,15),
  (27,14,14),
  (28,1,14),
  (29,17,20),
  (30,17,2);

INSERT INTO Compra (id_compra,valortotal,hora,total,dia,metodopagamento_id)
VALUES
  (1,8.5,"10:19",123.2,"16/Apr/2022",2),
  (2,3.5,"11:04",132.1,"5/Oct/2022",3),
  (3,3.5,"10:39",234.1,"14/Jun/2022",1),
  (4,13.5,"2:41",23.2,"28/Dec/2022",4),
  (5,22.5,"12:41",121.2,"28/Mar/2022",2),
  (6,20.5,"1:39",12.4,"16/Apr/2022",1),
  (7,24.5,"1:46",32.2,"10/Mar/2022",4),
  (8,12.5,"2:00",323.2,"15/May/2022",1),
  (9,12.5,"9:54",423.2,"27/Aug/2022",1),
  (10,18.5,"2:08",213.2,"25/Feb/2022",3),
  (11,19.5,"3:29",93,"11/Sep/2022",3),
  (12,18.5,"3:44",13.2,"9/Jul/2022",4),
  (13,2.5,"11:11",243,"4/Oct/2022",3),
  (14,9.5,"10:15",353,"18/Aug/2022",2),
  (15,13.5,"11:52",121.5,"27/Nov/2022",3),
  (16,23.5,"9:36",113.7,"26/Dec/2022",2),
  (17,16.5,"9:09",45,"1/Jun/2022",3),
  (18,22.5,"11:17",123.2,"18/Nov/2022",1),
  (19,17.5,"10:40",143.2,"2/Apr/2022",2),
  (20,11.5,"5:47",131.3,"28/Oct/2022",3); 
 
 INSERT INTO ItemCompra (id_itemcompra,compra_id,produto_id,ingrediente_id,quantidade,subtotal)
VALUES
  (1,14,7,null,19,21),
  (2,7,7,null,47,47),
  (3,10,19,null,21,21),
  (4,1,2,null,68,22),
  (5,4,7,null,20,12),
  (6,8,16,null,15,13),
  (7,18,16,null,87,14),
  (8,15,18,null,74,124),
  (9,7,6,null,46,10),
  (10,15,15,null,34,67),
  (11,12,3,null,33,29),
  (12,15,10,null,87,10),
  (13,10,11,null,11,11),
  (14,16,12,null,66,66),
  (15,9,null,9,36,20),
  (16,16,null,8,92,89),
  (17,9,null,17,46,11),
  (18,12,null,10,95,90),
  (19,14,null,18,24,24),
  (20,18,null,7,42, 56),
  (21,8,null,19,81,10),
  (22,12,null,19,10,81),
  (23,20,null,10,21,50),
  (24,2,null,1,50,90),
  (25,18,null,4,34,78),
  (26,7,null,12,89,12),
  (27,14,null,2,83,2),
  (28,1,null,10,52,23),
  (29,17,null,5,90,10),
  (30,2,null,2,55,9);


INSERT INTO ItemProduto (id_itemproduto,ingrediente_id,produto_id,quantidade)
VALUES
  (1,6,6,30),
  (2,4,16,31),
  (3,11,18,43),
  (4,13,11,84),
  (5,13,13,67),
  (6,2,11,92),
  (7,10,1,35),
  (8,6,18,16),
  (9,8,9,87),
  (10,15,5,69),
  (11,2,19,26),
  (12,18,20,44),
  (13,10,18,79),
  (14,8,13,49),
  (15,9,18,85),
  (16,7,5,25),
  (17,17,9,54),
  (18,3,5,54),
  (19,3,16,9),
  (20,5,13,26),
  (21,19,9,57),
  (22,11,18,59),
  (23,15,12,50),
  (24,2,19,58),
  (25,13,4,62),
  (26,8,11,55),
  (27,2,10,4),
  (28,4,5,96),
  (29,5,11,86),
  (30,1,16,58);


