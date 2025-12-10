SELECT
	C.FIRST_NAME as nome, C.last_name as sobrenome,C.CPF,C.EMAIL,C.CITY,C.STATE,
	
	P.BRAND as marca,p.model,p.price AS preco,
	COUNT(*) AS quantidade
FROM
	SALES.FUNNEL AS F
	JOIN SALES.CUSTOMERS AS C 
	ON F.CUSTOMER_ID = C.CUSTOMER_ID
	JOIN SALES.PRODUCTS AS P
	ON F.PRODUCT_ID = P.PRODUCT_ID
GROUP BY
	C.FIRST_NAME,last_name,p.model,
	P.BRAND,p.price ,C.CPF ,C.EMAIL,C.CITY,C.STATE

limit 10

--VEÍCULOS ADQUIRIDOS POR CLIENTES


"nome","sobrenome","cpf","email","city","state","marca","model","preco","quantidade"

"MARCELO","DUARTE","61522225618","missilane.duarte816522@gmail.com","SANTA CECÍLIA","SC","VOLKSWAGEN","GOL","51000","1"

"ENZO","RODRIGUES","43428483400","dalmar.ivna063406@gmail.com","GOIÂNIA","GO","VOLKSWAGEN","FOX","45000","1"

"LAURA","OLIVEIRA","33698078232","arailda.duarte565942@gmail.com","LAGES","SC","CHEVROLET","PRISMA","43500","1"

"IVETE","DUARTE","04738962348","iveta.shenia341146@gmail.com","SÃO PAULO","SP","HYUNDAI","HB20S","65850","1"

"ISMAEL","SILVA","80840121068","raid.genai701424@gmail.com","LAGES","SC","VOLKSWAGEN","GOLF","118350","1"

"NESTOR","GONÇALVES","09235773792","laurivalda.ludmile750248@gmail.com","SÃO PAULO","SP","CHEVROLET","CORSA","30000","1"

"DANIEL","LIMA","38616956348","suyla.deusidete452962@gmail.com","SOROCABA","SP","VOLKSWAGEN","VOYAGE","44985","1"

"MOACIR","ALVARES","20092917540","netor.ivine645312@gmail.com","SANTO ANDRÉ","SP","CITROEN","C3","54000","1"

"ELIANA","ALVES","62962406110","izaurino.dionario494068@gmail.com","SÃO PAULO","SP","HYUNDAI","HB20S","65850","2"

"IVAN","MOREIRA","73939138604","mecilene.shanon346700@gmail.com","SÃO PAULO","SP","CHEVROLET","SPIN","59850","1"


