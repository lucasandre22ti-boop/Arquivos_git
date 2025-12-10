SELECT
	C.FIRST_NAME as nome, C.last_name as sobrenome,C.CPF,C.EMAIL,C.CITY,C.STATE,
	
	P.BRAND as marca,p.price AS preco,
	COUNT(*) AS quantidade
FROM
	SALES.FUNNEL AS F
	JOIN SALES.CUSTOMERS AS C 
	ON F.CUSTOMER_ID = C.CUSTOMER_ID
	JOIN SALES.PRODUCTS AS P
	ON F.PRODUCT_ID = P.PRODUCT_ID
GROUP BY
	C.FIRST_NAME,last_name,
	P.BRAND,p.price ,C.CPF ,C.EMAIL,C.CITY,C.STATE

limit 10

--VEÍCULOS ADQUIRIDOS POR CLIENTES

"nome","sobrenome","cpf","email","city","state","marca","preco","quantidade"

"MARCELO","DUARTE","29687379920","nobuhiro.duarte464912@gmail.com","GUARULHOS","SP","FIAT","52500","1"

"ENZO","RODRIGUES","62333571370","ezo.jonival078868@gmail.com","EMBU DAS ARTES","SP","VOLKSWAGEN","44985","1"

"LAURA","OLIVEIRA","34879428220","lauralice.areci045580@gmail.com","SÃO PAULO","SP","FIAT","52500","1"

"ADEIS","DUARTE","22343560712","adeis.duarte570906@gmail.com","CURITIBA","PR","FORD","35850","1"

"ISMAEL","SILVA","74636598474","neidilson.duarte131860@gmail.com","CARAPICUÍBA","SP","CHEVROLET","60000","1"

"NESTOR","GONÇALVES","83752241026","laudiseia.duarte407762@gmail.com","SUZANO","SP","FORD","35850","1"

"DANIEL","LIMA","38545029540","noecir.gumercina510406@gmail.com","ITAQUAQUECETUBA","SP","FORD","27000","1"

"MOACIR","ALVARES","27877551366","jonieli.lauricio760422@gmail.com","SÃO PAULO","SP","PEUGEOT","47850","1"

"ELIANA","ALVES","17507383282","jeneroso.adeildo948048@gmail.com","JARDINÓPOLIS","SP","CHEVROLET","49350","1"

"IVAN","MOREIRA","11449959162","iyan.duarte310460@gmail.com","RIBEIRÃO DAS NEVES","MG","VOLKSWAGEN","51000","1"
