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
VALUES (1,4,'mala kuća',3,1,1,3);
INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (2,3,'mali stan',3,1,1,2);
INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (3,12,'hotel na obali mora',3,5,1,1);
INSERT INTO `smestaj`(`id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (4,2,'apartman u centru',4,1,2,3);

INSERT INTO `rezervacija`(`id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(1,false,'nama je bilo super',3,'20181015',true,'20181025',false,1,1);
INSERT INTO `rezervacija`(`id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(2,false,'nama je bilo srednje',2,'20180215',true,'20180225',true,2,1);

INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(1,'20181025',10,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(2,'20181125',20,1);
INSERT INTO `cena`(`id`,`mesec`,`vrednost`,`smestaj_id`)VALUES(3,'20181225',10,1);
