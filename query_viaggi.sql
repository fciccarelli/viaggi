
# query 1 Le città con un aeroporto di cui non è noto il numero di piste
select citta from aeroporto 
	where nPiste is not null;

# query 2 Le nazioni da cui parte e arriva il volo con codice 1
select a.nazione, aa.nazione from aeroporto as a
	
    inner join volo as v
    on v.aeroportoArr = a.id 
    
    inner join aeroporto as aa
    on v.aeroportoPart = aa.id
    
    where v.idVolo = 1;
    
# query 3	I tipi di aereo usati nei voli che partono da Roma
select distinct a.tipoAereo, ae.citta from aeroporto as ae

	inner join volo as v
    on v.aeroportoPart = ae.id
    
    inner join aereo as a
    on v.tipoAereo = a.tipoAereo
    
    where ae.citta like 'Roma';
    
#query 4 I tipi di aereo e il corrispondente numero di passeggeri per i voli che partono da Roma
select distinct a.tipoAereo, a.nPass, v.aeroportoPart,v.aeroportoArr from aeroporto as ae

	inner join volo as v
    on v.aeroportoPart = ae.id
    
    inner join aereo as a
    on v.tipoAereo = a.tipoAereo
    
    where v.aeroportoPart = 'FCO';

# query 5 Le città da cui partono voli diretti ad Amsterdam, ordinate alfabeticamente
select distinct a.citta from aeroporto as a

	inner join volo as v 
    on v.aeroportoPart = a.id
    
    inner join aeroporto as aa
    on v.aeroportoArr = aa.id
    
    where aa.citta = 'Amsterdam'
    order by a.citta asc;
    
# query 6 Il numero di voli che partono il venerdì da Napoli
select count(v.idVolo), v.aeroportoArr from volo as v

	inner join aeroporto as a
    on v.aeroportoPart = a.id
    
	where v.giornoSett like 'Venerdì' and a.citta = 'Napoli';
    
# query 7 •	Le città italiane da cui partono almeno 2 voli alla settimana diretti in Olanda
select a.citta, count(v.idVolo) as count from volo as v 
	
    inner join aeroporto as a
    on v.aeroportoPart = a.id
    
    inner join aeroporto as b
    on v.aeroportoArr = b.id
    
    where a.nazione = 'Italia' and b.nazione = 'Olanda' 
    group by a.citta having count >=2;

# query 8 •	Le città da cui parte l'aereo caratterizzato dal massimo numero di passeggeri
select  a.citta, v.tipoAereo from volo as v

	inner join aereo as b
    on v.tipoAereo = b.tipoAereo

	inner join aeroporto as a
    on v.aeroportoPart = a.id
    
    where b.nPass in
	(select max(a.nPass) from aereo as a 
		inner join volo as v 
        on v.tipoAereo = a.tipoAereo)
        
        union

# query 9 •	Le città su cui è diretto l'aereo caratterizzato dal massimo numero di passeggeri
select  a.citta, v.tipoAereo from volo as v

	inner join aereo as b
    on v.tipoAereo = b.tipoAereo

	inner join aeroporto as a
    on v.aeroportoArr = a.id
    
    where b.nPass in 
    (select max(a.nPass) from aereo as a 
		inner join volo as v 
        on v.tipoAereo = a.tipoAereo);
    
# query 10•	Le città che sono servite dall'aereo caratterizzato dal massimo numero di passeggeri
/*select distinct a.citta, v.tipoAereo from volo as v

	inner join aereo as b
    on v.tipoAereo = b.tipoAereo

	inner join aeroporto as a
    on v.aeroportoPart = a.id or v.aeroportoArr = a.id
    
    where b.nPass = 
    (select max(a.nPass) from aereo as a 
		inner join volo as v 
        on v.tipoAereo = a.tipoAereo);*/
    
