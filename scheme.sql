# cancellazione di database viaggi se esiste
drop database if exists viaggi;

# creazione database viaggi
create database viaggi
	default character set utf8
    default collate utf8_unicode_ci;
    
# utilizza il database viaggi
use viaggi;
    
# creazione tabella aereo
create table if not exists Aereo(
	tipoAereo varchar(16) primary key,
    nPass int not null,
	quantitaMerci int not null);

# creazione tabella aeroporto
create table if not exists Aeroporto(
	id varchar(4) primary key,
    citta varchar(64) not null,
    nazione varchar(64) not null,
    nPiste int not null);
    
# creazione tabella volo
CREATE TABLE IF NOT EXISTS Volo (
    idVolo INT PRIMARY KEY AUTO_INCREMENT,
    giornoSett VARCHAR(16) not null,
    aeroportoPart VARCHAR(4) not null,
    aeroportoArr VARCHAR(4) not null,
    tipoAereo VARCHAR(16) not null,
    oraPartenza TIME not null,
    oraArrivo TIME not null,
    CONSTRAINT fk_part FOREIGN KEY (aeroportoPart) REFERENCES aeroporto (id) on update cascade on delete restrict,
    CONSTRAINT fk_arr FOREIGN KEY (aeroportoArr) REFERENCES aeroporto (id) on update cascade on delete restrict,
    CONSTRAINT fk_tipoAereo FOREIGN KEY (tipoAereo) REFERENCES aereo (tipoAereo) on update cascade on delete restrict);

