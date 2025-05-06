use Mercearia;
set session sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select Nome from Cliente;

select Nome,Localidade,Rua from Cliente
    where Localidade in ("Aguada do Queixo");

select Profissao from Cliente;

select Designacao,Preco from Produto
    order by Designacao ASC;

select Nome,sum(V.Total) as Total from Cliente
    inner join Venda V on Cliente.Numero = V.Cliente
    group by Nome
    order by Total DESC;

select * from Venda
    where Data in ('2017-10-05');

select sum(Quantidade) as Volume,P.Designacao,WEEKOFYEAR(V.Data) from VendaProduto
    inner join Produto P on VendaProduto.Produto = P.Numero
    inner join Venda V on VendaProduto.Venda = V.Numero
    where 40 = WEEKOFYEAR(V.Data)
    group by P.Designacao
    order by Volume DESC;

SELECT Venda.Numero,weekday(Venda.Data) as WD,AVG(Venda.Total) from Venda
        group by WD;

SELECT * from Cliente;

INSERT INTO Mercearia.Cliente (Numero, Nome, DataNascimento, Profissao, Rua, Localidade, CodPostal, Contribuinte, eMail, Compras, RecomendadoPor)
VALUES (8,"António Gomes",'1964-10-16',"Músico","Avenida 20 de Maio","Paços de Ferreira","4590-182",123813313,"to@gmail.com",0,null);
UPDATE Cliente set rua = "Dão Joao" where Numero = 8;

Update Produto set Preco = Preco *1.1 where Tipo = "Peixe";

INSERT INTO Mercearia.Venda (Numero, Data, Estado, Total, Cliente) VALUES (6,"2017-10-10","S",22.10,8);
INSERT INTO Mercearia.VendaProduto(Venda, Produto, Quantidade, Preco, Valor) VALUES (6,1,5,1,5);
INSERT INTO Mercearia.VendaProduto(Venda, Produto, Quantidade, Preco, Valor) VALUES (6,7,5,0.5,2.5);
INSERT INTO Mercearia.VendaProduto(Venda, Produto, Quantidade, Preco, Valor) VALUES (6,2,5,0.6,3);
INSERT INTO Mercearia.VendaProduto(Venda, Produto, Quantidade, Preco, Valor) VALUES (6,3,5,0.25,1.25);



DELETE from Cliente
    where Numero = 8;

DELETE  from Venda
    where Numero = 6;

DELETE  from VendaProduto
    where Venda = 6;

-- Quais produtos que não foram vendidos

SELECT DISTINCT Numero,Designacao from Produto
    Where Numero not in (SELECT Produto from VendaProduto);

drop procedure if exists aniversario;

DELIMITER $$
CREATE PROCEDURE aniversario (in dataAniversario DATE)
    BEGIN
        select C.Nome from Cliente as C
            where c.DataNascimento= dataAniversario;
    end
$$
