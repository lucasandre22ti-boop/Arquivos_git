-- Visitas por cidade e estado

SELECT 
      first_name,state,city,
    COUNT(f.visit_page_date) AS visitas
FROM 
    sales.customers c
LEFT JOIN 
    sales.funnel f ON f.customer_id = c.customer_id
GROUP BY 	 
    c.first_name,c.state,c.city
ORDER BY visitas,c.first_name
     asc
limit 30

--Resultado Da Query

"first_name",,"state","city","visitas"
"Abel",    "SP", "SÃO PAULO","1"
"ABIGAEL", "SP",  "SÃO PAULO","1"
"ABIGAIl", "RS", "IGREJINHA","1"
"ABILHO",  "GO", "GOIÂNIA","1"
"ABIMELEQUE","SP", "SÃO PAULO","1"
"ABIdAL",  "PR", "MARECHAL CÂNDIDO RONDON","1"
"ABIO",    "SP", "SUZANO","1"
"ISMAEL",  "SP","MAUÁ","1"
"MARCELO", "SP", "SÃO PAULO","1"
"ABNER",   "SP", "SÃO PAULO","1"
"ABRAHIM", "SP", "BARUERI","1"
"ABEL",    "SP", "FRANCISCO MORATO","1"
"ARLINDA", "SP", "TATUÍ","1"
"LAURA",   "SP", "SÃO PAULO","1"
"CAIO",   "SP", "SÃO PAULO","1"
"ACCACIO","SP", "SÃO PAULO","1"
"CASSIO", "SP", "CHAVANTES","1"
"ALINE",  "MG", "BELO HORIZONTE","1"
"CARLOS", "ES", "CACHOEIRO DE ITAPEMIRIM","1"
"ACENOR", "SP", "PORTO FELIZ","1"
"ACIELE", "PR", "RIO NEGRO","1"
"ACIELE", "SC", "INDAIAL","1"
"ACILINA","SP", "SUZANO","1"
"ACINO",  "MG", "UBERABA","1"
"ALCINO", "ES", "VILA VELHA","1"
"ALCIONI","SP", "SAO PAULO","1"
"JACKSON","SP", "SÃO PAULO","1"
"ISAURA"  "MG", "CONTAGEM","1"
"ADRIANA","SP", "NEVES PAULISTA","1"
"LIZETE", "SP", "MAUÁ","1"
