delete from rezervacija;
delete from smestaj;
delete from lokacija;
delete from tip_smestaja;
delete from kategorija_smestaja;
delete from usluga;
delete from korisnik;

INSERT INTO `korisnik`(`id`,`bekend_id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(1,1,'mare','marisa','klijent');
INSERT INTO `korisnik`(`id`,`bekend_id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(2,1,'zare','zarisa','klijent');
INSERT INTO `korisnik`(`id`,`bekend_id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(3,1,'pero','peron','agent');
INSERT INTO `korisnik`(`id`,`bekend_id`,`kime`,`lozinka`,`tip_korisnika`)VALUES(4,1,'sero','seron','agent');

INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(1,1,"tv");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(2,1,"parking");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(3,1,"wifi");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(4,1,"dorucak");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(5,1,"polupanison");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(6,1,"pansion");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(7,1,"kuhinja");
INSERT INTO `usluga`(`id`,`bekend_id`,`naziv`)VALUES(8,1,"privatno kupatilo");

INSERT INTO `kategorija_smestaja` (`id`,`bekend_id`, `naziv`) VALUES (1,1, 'nekategorisan');
INSERT INTO `kategorija_smestaja` (`id`,`bekend_id`, `naziv`) VALUES (2,1, 'jedna zvezdica');
INSERT INTO `kategorija_smestaja` (`id`,`bekend_id`, `naziv`) VALUES (3,1, 'dve zvezdice');
INSERT INTO `kategorija_smestaja` (`id`,`bekend_id`, `naziv`) VALUES (4,1, 'tri zvezdice');
INSERT INTO `kategorija_smestaja` (`id`,`bekend_id`, `naziv`) VALUES (5,1, 'cetiri zvezdice');
INSERT INTO `kategorija_smestaja` (`id`,`bekend_id`, `naziv`) VALUES (6,1, 'pet zvezdica');

INSERT INTO `lokacija`(`id`,`bekend_id`,`drzava`,`mesto`)VALUES(1,1,'Hungary','Pecs');
INSERT INTO `lokacija`(`id`,`bekend_id`,`drzava`,`mesto`)VALUES(2,1,'Hungary','Szeged');
INSERT INTO `lokacija`(`id`,`bekend_id`,`drzava`,`mesto`)VALUES(3,1,'Hungary','Debrecen');
INSERT INTO `lokacija`(`id`,`bekend_id`,`drzava`,`mesto`)VALUES(4,1,'Spain','Alkala');
INSERT INTO `lokacija`(`id`,`bekend_id`,`drzava`,`mesto`)VALUES(5,1,'Belgium','Charleroi');

INSERT INTO `tip_smestaja`(`id`,`bekend_id`,`naziv`)VALUES(1,1,'hotel');
INSERT INTO `tip_smestaja`(`id`,`bekend_id`,`naziv`)VALUES(2,1,'bad&breakfast');
INSERT INTO `tip_smestaja`(`id`,`bekend_id`,`naziv`)VALUES(3,1,'apartman');

INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (1,1,4,'mala kuća',1,1,1,3);
INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (2,1,3,'mali stan',1,1,1,2);
INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (3,1,12,'hotel na obali mora',1,5,1,1);
INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (4,1,2,'apartman u centru',2,1,2,3);

INSERT INTO `rezervacija`(`id`,`bekend_id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(1,1,false,'nama je bilo super',3,'20181015',true,'20181025',false,1,1);
INSERT INTO `rezervacija`(`id`,`bekend_id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(2,1,false,'nama je bilo srednje',2,'20180215',true,'20180225',true,2,1);