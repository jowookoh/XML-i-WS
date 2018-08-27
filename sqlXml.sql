delete from rezervacija;
delete from smestaj;
delete from lokacija;
delete from tip_smestaja;
delete from kategorija_smestaja;

INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (1, '0');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (2, '1');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (3, '2');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (4, '3');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (5, '4');
INSERT INTO `kategorija_smestaja` (`id`, `naziv`) VALUES (6, '5');

INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(1,'Hungary','Pecs');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(2,'Hungary','Szeged');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(3,'Hungary','Debrecen');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(4,'Spain','Alkala');
INSERT INTO `lokacija`(`id`,`drzava`,`mesto`)VALUES(5,'Belgium','Charleroi');

INSERT INTO `tip_smestaja`(`id`,`naziv`)VALUES(1,'hotel');
INSERT INTO `tip_smestaja`(`id`,`naziv`)VALUES(2,'bad&breakfast');
INSERT INTO `tip_smestaja`(`id`,`naziv`)VALUES(3,'apartman');

INSERT INTO `szynka`.`smestaj`(`id`,`broj_osoba`,`opis`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (1,4,'mala kuća',1,1,3);
INSERT INTO `szynka`.`smestaj`(`id`,`broj_osoba`,`opis`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (2,3,'mali stan',1,1,2);
INSERT INTO `szynka`.`smestaj`(`id`,`broj_osoba`,`opis`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (3,12,'hotel na obali mora',5,1,1);
INSERT INTO `szynka`.`smestaj`(`id`,`broj_osoba`,`opis`,`kategorija_smestaja_id`,`lokacija_id`,`tip_smestaja_id`)
VALUES (4,2,'apartman u centru',1,2,3);

INSERT INTO `rezervacija`(`id`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`smestaj_id`)
VALUES(1,'nama je bilo super',3,'20181015',true,'20181025',false,1);
INSERT INTO `rezervacija`(`id`,`komentar`,`ocena`,`od`,`odobren_komentar`,`pa_onda_do`,`realizovana`,`smestaj_id`)
VALUES(2,'nama je bilo srednje',2,'20180215',true,'20180225',true,1);

