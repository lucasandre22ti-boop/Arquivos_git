--visitas por dia da semana

select 
to_char(visit_page_date , 'dd/mm/yyyy') as data_visita,
count(*) 
from sales.funnel
where visit_page_date >= '01-08-2021' and visit_page_date <='31-08-2021'
group by data_visita
order by data_visita asc;


SELECT 
 
   CASE extract ('dow' from visit_page_date)
    WHEN 0 THEN 'Domingo'
    WHEN 1 THEN 'Segunda-feira'
    WHEN 2 THEN 'Terça-feira'
    WHEN 3 THEN 'Quarta-feira'
    WHEN 4 THEN 'Quinta-feira'
    WHEN 5 THEN 'Sexta-feira'
    WHEN 6 THEN 'Sábado'
  END AS dia_da_semana,
  count(*) as tota_visitas
FROM sales.funnel
group by  dia_da_semana
order by  dia_da_semana

--Resultado Da Query

"dia_da_semana","tota_visitas"
"Domingo",           "340"
"Quarta-feira",     "5371"
"Quinta-feira",     "5365"
"Sábado",           "3480"
"Segunda-feira",    "5316"
"Sexta-feira",      "4878"
"Terça-feira",      "5830"


