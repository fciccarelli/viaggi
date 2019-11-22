# query 10 •	Le città da cui parte e arriva l'aereo caratterizzato dal massimo numero di passeggeri
select a.citta, v.tipoAereo from volo as v

	inner join aereo as b
    on v.tipoAereo = b.tipoAereo

	inner join aeroporto as a
    on v.aeroportoPart = a.id
    
    where b.nPass in
	(select max(a.nPass) from aereo as a 
		inner join volo as v 
        on v.tipoAereo = a.tipoAereo)
union
select a.citta, v.tipoAereo from volo as v

	inner join aereo as b
    on v.tipoAereo = b.tipoAereo

	inner join aeroporto as a
    on v.aeroportoArr = a.id
    
    where b.nPass in 
    (select max(a.nPass) from aereo as a 
		inner join volo as v 
        on v.tipoAereo = a.tipoAereo);