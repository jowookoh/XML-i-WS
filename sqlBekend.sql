delete from cena;
delete from rezervacija;
delete from smestaj;
delete from lokacija;
delete from tip_smestaja;
delete from kategorija_smestaja;
delete from usluga;
delete from korisnik;

INSERT INTO `korisnik`(`id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(1,'mare','marisa','klijent');
INSERT INTO `korisnik`(`id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(2,'zare','zarisa','klijent');
INSERT INTO `korisnik`(`id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(3,'pero','peron','agent');
INSERT INTO `korisnik`(`id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(4,'sero','seron','agent');

INSERT INTO `usluga`(`id`,`naziv`)VALUES(1,"tv");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(2,"parking");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(3,"wifi");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(4,"dorucak");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(5,"polupanison");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(6,"pansion");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(7,"kuhinja");
INSERT INTO `usluga`(`id`,`naziv`)VALUES(8,"privatno kupatilo");

INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (1, 'nekategorisan');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (2, 'jedna zvezdica');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (3, 'dve zvezdice');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (4, 'tri zvezdice');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (5, 'cetiri zvezdice');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (6, 'pet zvezdica');

INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(1,'Hungary','Pecs');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(2,'Hungary','Szeged');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(3,'Hungary','Debrecen');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(4,'Spain','Alkala');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(5,'Belgium','Charleroi');

INSERT INTO `tip_smestaja`(`id`,`naziv`)VALUES(1,'hotel');
INSERT INTO `tip_smestaja`(`id`,`naziv`)VALUES(2,'bad&breakfast');
INSERT INTO `tip_smestaja`(`id`,`naziv`)VALUES(3,'apartman');

INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (1,4,'mala kuća',1,1,1,3);
INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (2,3,'mali stan',1,1,1,2);
INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (3,12,'hotel na obali mora',1,5,1,1);
INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (4,2,'apartman u centru',2,1,2,3);

INSERT INTO `rezervacija`(`id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(1,false,'nama je bilo super',3,'20181015',true,'20181025',false,1,1);
INSERT INTO `rezervacija`(`id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(2,false,'nama je bilo srednje',2,'20180215',true,'20180225',true,2,1);

INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(1,1,10,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(2,2,20,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(3,3,10,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(4,4,10,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(5,5,30,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(6,6,40,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(7,7,510,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(8,8,30,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(9,9,10,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(10,10,10,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(11,11,20,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(12,12,20,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(13,1,100,2);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(14,2,100,2);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(15,3,100,2);
