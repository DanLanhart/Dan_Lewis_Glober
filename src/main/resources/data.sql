USE glober;

INSERT INTO player
VALUES('99','test@gmail.com','test','password','testPlayer');

/*This is the default list of locations that are present within the game and are tested inside of the
LocationServiceImplTest class. The tests associated with this data will FAIL unless these are inserted.*/

INSERT INTO locations
VALUES ('1','New York', '282809', 'New York'),('2','Los Angeles', '623636', 'California'),('3','Chicago', '207229', 'Illinois'),
       ('4','Houston', '752962', 'Texas'),('5','Phoenix', '099324', 'Arizona'),('6','Philadelphia', '814868', 'Pennsylvania'),
       ('7','San Antonio', '547667', 'Texas'),('8','San Diego', '821302', 'California'),('9','Dallas', '260294', 'Texas'),
       ('10','San Jose', '668557', 'California'),('11','Austin', '494764', 'Texas'),('12','Jacksonville', '006216', 'Florida'),
       ('13','Fort Worth', '942778', 'Texas'),('14','Columbus', '979370', 'Ohio'),('15','Indianapolis', '911470', 'Indiana'),
       ('16','Charlotte', '895316', 'North Carolina'),('17','San Francisco', '252188', 'California'),('18','Seattle', '409440', 'Washington'),
       ('19','Denver', '680488', 'Colorado'),('20','Washington', '174425', 'District of Columbia'),('21','Nashville', '869801', 'Tennessee'),
       ('22','Oklahoma City', '596253', 'Oklahoma'),('23','El Paso', '989611', 'Texas'),('24','Boston', '550196', 'Massachusetts'),
       ('25','Portland', '390170', 'Oregon'),('26','Las Vegas', '085414', 'Nevada'),('27','Detroit', '967469', 'Michigan'),
       ('28','Memphis', '408928', 'Tennessee'),('29','Louisville', '554672', 'Kentucky'),('30','Baltimore', '182554', 'Maryland'),
       ('31','Milwaukee', '612253', 'Wisconsin'),('32','Albuquerque', '335231', 'New Mexico'),('33','Tucson', '571872', 'Arizona'),
       ('34','Fresno', '394482', 'California'),('35','Sacramento', '135206', 'California'),('36','Kansas City', '343757', 'Missouri'),
       ('37','Mesa', '219270', 'Arizona'),('38','Atlanta', '490032', 'Georgia'),('39','Omaha', '426929', 'Nebraska'),
       ('40','Colorado Springs', '870276', 'Colorado'),('41','Raleigh', '064558', 'North Carolina'),('42','Long Beach', '109706', 'California'),
       ('43','Virginia Beach', '257468', 'Virginia'),('44','Miami', '602305', 'Florida'),('45','Oakland', '867722', 'California'),
       ('46','Minneapolis', '782142', 'Minnesota'),('47','Tulsa', '715851', 'Oklahoma'),('48','Bakersfield', '092246', 'California'),
       ('49','Wichita', '902081', 'Kansas'),('50','Arlington', '747617', 'Texas'),('51','Aurora', '271708', 'Colorado'),
       ('52','Tampa', '015198', 'Florida'),('53','New Orleans', '871942', 'Louisiana'),('54','Cleveland', '232114', 'Ohio'),
       ('55','Honolulu', '214280', 'Hawaii'),('56','Anaheim', '319034', 'California'),('57','Lexington', '713054', 'Kentucky'),
       ('58','Stockton', '617456', 'California'),('59','Corpus Christi', '648376', 'Texas'),('60','Henderson', '868340', 'Nevada'),
       ('61','Riverside', '192841', 'California'),('62','Newark', '509607', 'New Jersey'),('63','Saint Paul', '889980', 'Minnesota'),
       ('64','Santa Ana', '270806', 'California'),('65','Cincinnati', '960507', 'Ohio'),('66','Irvine', '621913', 'California'),
       ('67','Orlando', '986057', 'Florida'),('68','Pittsburgh', '991927', 'Pennsylvania'),('69','St. Louis', '902844', 'Missouri'),
       ('70','Greensboro', '198076', 'North Carolina'),('71','Jersey City', '070369', 'New Jersey'),('72','Anchorage', '127544', 'Alaska'),
       ('73','Lincoln', '475658', 'Nebraska'),('74','Plano', '334699', 'Texas'),('75','Durham', '134224', 'North Carolina'),
       ('76','Buffalo', '246797', 'New York'),('77','Chandler', '541217', 'Arizona'),('78','Chula Vista', '319424', 'California'),
       ('79','Toledo', '352337', 'Ohio'),('80','Madison', '868385', 'Wisconsin'),('81','Gilbert', '643813', 'Arizona'),
       ('82','Reno', '972729', 'Nevada'),('83','Fort Wayne', '123685', 'Indiana'),('84','North Las Vegas', '591381', 'Nevada'),
       ('85','St. Petersburg', '054216', 'Florida'),('86','Lubbock', '907673', 'Texas'),('87','Irving', '701785', 'Texas'),
       ('88','Laredo', '924148', 'Texas'),('89','Winston???Salem', '080405', 'North Carolina'),('90','Chesapeake', '662131', 'Virginia'),
       ('91','Glendale', '766285', 'Arizona'),('92','Garland', '667756', 'Texas'),('93','Scottsdale', '895938', 'Arizona'),
       ('94','Norfolk', '612984', 'Virginia'),('95','Boise', '078999', 'Idaho'),('96','Fremont', '745962', 'California'),
       ('97','Spokane', '706850', 'Washington'),('98','Santa Clarita', '300024', 'California'),('99','Baton Rouge', '106729', 'Louisiana'),
       ('100','Richmond', '205325', 'Virginia'),('101','Hialeah', '836624', 'Florida'),('102','San Bernardino', '375514', 'California'),
       ('103','Tacoma', '855364', 'Washington'),('104','Modesto', '948255', 'California'),('105','Huntsville', '328903', 'Alabama'),
       ('106','Des Moines', '010491', 'Iowa'),('107','Yonkers', '694880', 'New York'),('108','Rochester', '775354', 'New York'),
       ('109','Moreno Valley', '959960', 'California'),('110','Fayetteville', '642026', 'North Carolina'),('111','Fontana', '101472', 'California'),
       ('112','Columbus', '162050', 'Georgia'),('113','Worcester', '734441', 'Massachusetts'),('114','Port St. Lucie', '643627', 'Florida'),
       ('115','Little Rock', '623096', 'Arkansas'),('116','Augusta', '520301', 'Georgia'),('117','Oxnard', '012508', 'California'),
       ('118','Birmingham', '179832', 'Alabama'),('119','Montgomery', '492802', 'Alabama'),('120','Frisco', '205912', 'Texas'),
       ('121','Amarillo', '862192', 'Texas'),('122','Salt Lake City', '023538', 'Utah'),('123','Grand Rapids', '114666', 'Michigan'),
       ('124','Huntington Beach', '737986', 'California'),('125','Overland Park', '103298', 'Kansas'),('126','Glendale', '542687', 'California'),
       ('127','Tallahassee', '705622', 'Florida'),('128','Grand Prairie', '080167', 'Texas'),('129','McKinney', '187311', 'Texas'),
       ('130','Cape Coral', '732891', 'Florida'),('131','Sioux Falls', '116511', 'South Dakota'),('132','Peoria', '277432', 'Arizona'),
       ('133','Providence', '709149', 'Rhode Island'),('134','Vancouver', '370094', 'Washington'),('135','Knoxville', '680000', 'Tennessee'),
       ('136','Akron', '467166', 'Ohio'),('137','Shreveport', '704931', 'Louisiana'),('138','Mobile', '460776', 'Alabama'),
       ('139','Brownsville', '214867', 'Texas'),('140','Newport News', '029901', 'Virginia'),('141','Fort Lauderdale', '523873', 'Florida'),
       ('142','Chattanooga', '894489', 'Tennessee'),('143','Tempe', '325639', 'Arizona'),('144','Aurora', '445755', 'Illinois'),
       ('145','Santa Rosa', '356844', 'California'),('146','Eugene', '444822', 'Oregon'),('147','Elk Grove', '045000', 'California'),
       ('148','Salem', '946382', 'Oregon'),('149','Ontario', '167503', 'California'),('150','Cary', '301983', 'North Carolina');