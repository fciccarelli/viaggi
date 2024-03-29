# riempimento tipi aereo
insert into aereo (tipoAereo, nPass, quantitaMerci) values
	('Airbus A340-300', 295, 10),
	('Airbus A340-500', 372, 20),
	('Airbus A340-600', 420, 30),
	('Boeing 777-200', 440, 50),
	('Airbus A380-700', 525, 60),
	('Boeing 777-300', 550, 10),
	('Boeing 747-400', 624, 60),
	('Boeing 747-8', 700, 70),
	('Airbus A380-800', 853, 80),
	('Airbus A380-900', 900, 80);

# riempimento aeroporti
insert into aeroporto (id, citta, nazione, npiste) values
	('AMS', 'Amsterdam', 'Olanda', 12),
	('NAP', 'Napoli', 'Italia', 22),
	('FCO', 'Roma', 'Italia', 10),
	('JFK', 'New York', 'Stati Uniti', 20),
	('CDG', 'Parigi', 'Francia', 15),
	('BCN', 'Barcellona', 'Spagna', 11),
	('SXF', 'Berlino', 'Germania', 13),
	('CPH', 'Copenaghen', 'Danimarca', 15),
	('IST', 'Instanbul', 'Turchia', 8),
	('MOW', 'Mosca', 'Russia', 10),
	('HND', 'Tokyo', 'Giappone', 14),
	('AHO', 'Alghero', 'Italia',12),
	('AOI', 'Ancona', 'Italia',5),
	('BRI', 'Bari','Italia',6),
	('BGY', 'Bergamo', 'Italia',7),
	('BLQ', 'Bologna', 'Italia',6),
	('BZO', 'Bolzano', 'Italia',8),
	('VBS', 'Brescia', 'Italia',4),
	('BDS', 'Brindisi', 'Italia',6),
	('CTA', 'Catania', 'Italia',7),
	('CAG', 'Cagliari' , 'Italia',5),
	('CRV', 'Crotone', 'Italia',6),
	('CUF', 'Cuneo', 'Italia',4),
	('FLR', 'Firenze', 'Italia',5),
	('FOG', 'Foggia', 'Italia',7),
	('FRL', 'Forlì', 'Italia',2),
	('GOA', 'Genova', 'Italia',9),
	('GRS', 'Grosseto', 'Italia',2),
	('SUF', 'Lamezia', 'Italia',5),
	('MXP', 'Milano', 'Italia',7),
	('LIN', 'Milano', 'Italia',4),
	('OLB', 'Olbia', 'Italia',8),
	('QPA', 'Padova', 'Italia',4),
	('PMO', 'Palermo', 'Italia',4),
	('PMF', 'Parma', 'Italia',6),
	('PEG', 'Perugia', 'Italia',4),
	('PSR', 'Pescara', 'Italia',5),
	('PSA', 'Pisa', 'Italia',6),
	('REG', 'Reggio Calabria', 'Italia',8),
	('RMI', 'Rimini', 'Italia',3),
	('CIA', 'Roma', 'Italia',2),
	('TAR', 'Taranto', 'Italia',8),
	('TRN', 'Torino', 'Italia',9),
	('TPS', 'Trapani', 'Italia',3),
	('ZIA', 'Trento', 'Italia',4),
	('TSF', 'Treviso', 'Italia',5),
	('TRS', 'Trieste', 'Italia',6),
	('VCE', 'Venezia', 'Italia',7),
	('VRN', 'Verona', 'Italia',4),
	('VIC', 'Vicenza', 'Italia',3);

# riempimento tabella volo
insert into volo (giornoSett, aeroportoPart, aeroportoArr, tipoAereo, oraPartenza, oraArrivo) values
	('Lunedì', 'MOW', 'HND', 'Boeing 747-400', '18:25:00', '04:00:00'),
    ('Martedì', 'MOW', 'HND', 'Boeing 747-400', '18:25:00', '04:00:00'),
    ('Mercoledì', 'MOW', 'HND', 'Boeing 747-400', '08:25:00', '18:00:00'),
    ('Giovedì', 'MOW', 'HND', 'Boeing 747-8', '06:35:00', '16:10:00'),
    ('Venerdì', 'MOW', 'HND', 'Boeing 747-8', '06:35:00', '16:10:00'),
    ('Sabato', 'MOW', 'HND', 'Boeing 777-300', '12:25:00', '22:00:00'),
    ('Domenica', 'MOW', 'HND', 'Boeing 777-300', '12:25:00', '22:00:00'),
    ('Lunedì', 'HND', 'MOW', 'Boeing 747-400', '18:25:00', '04:00:00'),
    ('Martedì', 'HND', 'MOW', 'Boeing 747-400', '18:25:00', '04:00:00'),
    ('Mercoledì', 'HND', 'MOW', 'Boeing 747-400', '08:25:00', '18:00:00'),
    ('Giovedì', 'HND', 'MOW', 'Boeing 747-8', '06:35:00', '16:10:00'),
    ('Venerdì', 'HND', 'MOW', 'Boeing 747-8', '06:35:00', '16:10:00'),
    ('Sabato', 'HND', 'MOW', 'Boeing 777-300', '12:25:00', '22:00:00'),
    ('Domenica', 'HND', 'MOW', 'Boeing 777-300', '12:25:00', '22:00:00'),
	('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '10:30:00', '13:05:00'),
    ('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '07:20:00', '09:45:00'),
    ('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '16:30:00', '18:50:00'),
    ('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '14:35:00', '19:45:00'),
    ('martedì', 'FCO', 'AMS', 'Airbus A340-500', '07:20:00', '09:45:00'),
    ('martedì', 'FCO', 'AMS', 'Airbus A340-500', '16:30:00', '18:50:00'),
    ('martedì', 'FCO', 'AMS', 'Airbus A340-500', '14:35:00', '19:45:00'),
	('mercoledì', 'FCO', 'AMS', 'Airbus A340-600', '10:30:00', '13:05:00'),
    ('mercoledì', 'FCO', 'AMS', 'Airbus A340-600', '16:30:00', '18:50:00'),
    ('mercoledì', 'FCO', 'AMS', 'Airbus A340-600', '14:35:00', '19:45:00'),
    ('giovedì', 'FCO', 'AMS', 'Airbus A340-300', '16:30:00', '18:50:00'),
    ('giovedì', 'FCO', 'AMS', 'Airbus A340-300', '14:35:00', '19:45:00'),
	('venerdì', 'FCO', 'AMS', 'Airbus A340-500', '10:30:00', '13:05:00'),
    ('venerdì', 'FCO', 'AMS', 'Airbus A340-500', '07:20:00', '09:45:00'),
	('sabato', 'FCO', 'AMS', 'Airbus A340-300', '10:30:00', '13:05:00'),
    ('domenica', 'FCO', 'AMS', 'Airbus A340-600', '14:35:00', '19:45:00'),
    ('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '10:30:00', '13:05:00'),
    ('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '07:20:00', '09:45:00'),
    ('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '16:30:00', '18:50:00'),
    ('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '14:35:00', '19:45:00'),
	('martedì', 'AMS', 'FCO', 'Airbus A340-500', '10:30:00', '13:05:00'),
    ('martedì', 'AMS', 'FCO', 'Airbus A340-500', '07:20:00', '09:45:00'),
    ('martedì', 'AMS', 'FCO', 'Airbus A340-500', '16:30:00', '18:50:00'),
    ('martedì', 'AMS', 'FCO', 'Airbus A340-500', '14:35:00', '19:45:00'),
	('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '10:30:00', '13:05:00'),
    ('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '07:20:00', '09:45:00'),
    ('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '16:30:00', '18:50:00'),
    ('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '14:35:00', '19:45:00'),
    ('giovedì', 'AMS', 'FCO', 'Airbus A340-300', '16:30:00', '18:50:00'),
    ('giovedì', 'AMS', 'FCO', 'Airbus A340-300', '14:35:00', '19:45:00'),
	('venerdì', 'AMS', 'FCO', 'Airbus A340-500', '10:30:00', '13:05:00'),
    ('venerdì', 'AMS', 'FCO', 'Airbus A340-500', '14:35:00', '19:45:00'),
	('sabato', 'AMS', 'FCO', 'Airbus A340-300', '10:30:00', '13:05:00'),
    ('sabato', 'AMS', 'FCO', 'Airbus A340-300', '14:35:00', '19:45:00'),
	('domenica', 'AMS', 'FCO', 'Airbus A340-600', '10:30:00', '13:05:00'),
	('Domenica','FCO','JFK','Boeing 777-200','08:00:00','22:00:00'),
	('Domenica','NAP','AMS','Airbus A380-700','08:00:00','12:00:00'),
    ('Venerdì','NAP','AMS','Airbus A380-700','10:00:00','13:00:00'),
    ('Venerdì','NAP','AMS','Airbus A380-700','14:00:00','18:00:00'),
    ('lunedì','NAP','AMS','Airbus A380-700','08:00:00','12:00:00'),
	('Domenica','AMS','NAP','Airbus A380-700','15:00:00','19:00:00'),
	('Lunedi','JFK','FCO','Boeing 747-400','08:00:00','22:00:00'),
	('Lunedi','CPH','IST','Airbus A340-300','10:00:00','16:00:00'),
	('Lunedi','IST','CPH','Airbus A340-300','18:00:00','24:00:00'),
	('Martedi','SXF','BCN','Airbus A380-700','08:00:00','11:00:00'),
	('Martedi','BCN','SXF','Airbus A380-700','13:00:00','14:00:00'),
	('Mercoledi','CDG','NAP','Airbus A340-500','08:00:00','10:00:00'),
	('Mercoledi','NAP','CDG','Airbus A340-500','12:00:00','14:00:00'),
	('Giovedi','IST','AMS','Airbus A340-300','08:00:00','12:00:00'),
	('Giovedi','AMS','IST','Airbus A340-300','14:00:00','16:00:00');