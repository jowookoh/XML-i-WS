delete from poruka;
delete from rezervacija;
delete from smestaj;
delete from lokacija;
delete from tip_smestaja;
delete from kategorija_smestaja;
delete from usluga;
delete from korisnik;

INSERT INTO `korisnik`(`id`,`bekend_id`,`adresa`,`ime`,`kime`,`lozinka`,`poslovni_maticni_broj`,`prezime`,`tip_korisnika`)
VALUES(1,1,'mitra mirica 3','mare','mare93','marisa','1234','maric','klijent');
INSERT INTO `korisnik`(`id`,`bekend_id`,`adresa`,`ime`,`kime`,`lozinka`,`poslovni_maticni_broj`,`prezime`,`tip_korisnika`)
VALUES(2,1,'zitra zirica 3','zare','zare93','zarisa','2234','zaric','klijent');
INSERT INTO `korisnik`(`id`,`bekend_id`,`adresa`,`ime`,`kime`,`lozinka`,`poslovni_maticni_broj`,`prezime`,`tip_korisnika`)
VALUES(3,1,'peta srpska kolona 3','petarko','pero','peron','3234','peric','agent');
INSERT INTO `korisnik`(`id`,`bekend_id`,`adresa`,`ime`,`kime`,`lozinka`,`poslovni_maticni_broj`,`prezime`,`tip_korisnika`)
VALUES(4,1,'vetra mirica 3','sero','sero','seron','4234','saric','agent');

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
VALUES (1,1,4,'mala kuća',3,1,1,3);
INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (2,1,3,'mali stan',3,1,1,2);
INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (3,1,12,'hotel na obali mora',3,5,1,1);
INSERT INTO `smestaj`(`id`,`bekend_id`,`broj_osoba`,`opis`,`agent_id`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (4,1,2,'apartman u centru',4,1,2,3);

INSERT INTO `rezervacija`(`id`,`bekend_id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(1,1,false,'nama je bilo super',3,'20160215',true,'1818-10-25',false,1,1);
INSERT INTO `rezervacija`(`id`,`bekend_id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(2,1,false,'nama je bilo srednje',2,'2016-02-15',true,'1718-02-25',false,2,1);
INSERT INTO `rezervacija`(`id`,`bekend_id`,`fejk`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`klijent_id`,`smestaj_id`)
VALUES(3,1,false,'nama nista nije bilo',3,'2016-02-15',true,'1718-02-25',false,2,4);

INSERT INTO `poruka`(`id`,`bekend_id`,`po_redu`,`tekst`,`posiljalac_id`,`rezervacija_id`)
VALUES(1,1,1,'cao kako ste',1,1);
INSERT INTO `poruka`(`id`,`bekend_id`,`po_redu`,`tekst`,`posiljalac_id`,`rezervacija_id`)
VALUES(2,1,2,'cao sta ima novo',1,1);
INSERT INTO `poruka`(`id`,`bekend_id`,`po_redu`,`tekst`,`posiljalac_id`,`rezervacija_id`)
VALUES(3,1,3,'postovani',2,2);
