/*
	Création de la table Médecin
*/
create table MEDECIN(
	num_med int primary key,
	nom_med varchar(10),
	prenom_med varchar(10),
	tel_med numeric(10),
	specialite varchar(10),
	ville varchar(10));
	
/*
	Population de la table Médecin
*/
INSERT INTO MEDECIN VALUES (1,'med1','Amine', 0550527510, 'pediatre', 'Oran');
INSERT INTO MEDECIN VALUES (2,'med2','Amel', 0550631001, null,'Tlemcen');
INSERT INTO MEDECIN VALUES (3,'med2','Amina', 0555983200, 'chirurgie', 'Tlemcen');
INSERT INTO MEDECIN VALUES (4,'med4','Anouar', 0554102030, 'pediatre', 'Tlemcen');
INSERT INTO MEDECIN VALUES (5,'med5','Mohamed', 0556456789, 'interne', NULL);
INSERT INTO MEDECIN VALUES (6,'med6','Aïcha', 0558124376, NULL, NULL);
INSERT INTO MEDECIN VALUES (7,'med7','Isaâ', 0558124376, NULL, NULL);

/*
	Création de la table Médecin
*/
create table PATIENT(
num_pat int primary key,
nom_pat varchar(10),
prenom_pat varchar(10),
datenaiss_pat date,
age_pat int,
sexe char);
/*
	Population de la table Patient
*/
INSERT INTO PATIENT VALUES (1,'pat1','Amine', TO_DATE('02/04/1983', 'DD/MM/YYYY'),33, 'M');
INSERT INTO PATIENT VALUES (2,'pat2','Mohammed', TO_DATE('23/12/1943', 'DD/MM/YYYY'),74, 'M');
INSERT INTO PATIENT VALUES (3,'pat3','Ahmed', TO_DATE('12/10/2000', 'DD/MM/YYYY'),21, 'M');
INSERT INTO PATIENT VALUES (4,'pat4','Meriem', TO_DATE('12/10/1978', 'DD/MM/YYYY'),39, 'F');
/*
	Création de la table Consultation
*/
create table CONSULTATION(
num_consult int primary key,
date_consult date,
prix_consult int,
code_med int references MEDECIN(num_med),
code_pat int references PATIENT(num_pat));
/*
	Population de la table Consultation
*/
INSERT INTO CONSULTATION VALUES (1,TO_DATE('2017/02/12', 'YYYY/MM/DD'), 1500,1,1);
INSERT INTO CONSULTATION VALUES (2,TO_DATE('2017/02/12', 'YYYY/MM/DD'), 1500,1,2);
INSERT INTO CONSULTATION VALUES (3,TO_DATE('2017/02/12', 'YYYY/MM/DD'), 1500,1,3);
INSERT INTO CONSULTATION VALUES (4,TO_DATE('2017/01/12', 'YYYY/MM/DD'), 1500,2,1);
INSERT INTO CONSULTATION VALUES (5,TO_DATE('2017/01/12', 'YYYY/MM/DD'), 1500,3,1);
INSERT INTO CONSULTATION VALUES (6,TO_DATE('2008/10/14', 'YYYY/MM/DD'), 1500,4,1);
INSERT INTO CONSULTATION VALUES (7, CURRENT_DATE, 1500,3,2);
/*
	Création de la table Médicament
*/
create table MEDICAMENT(
code_medoc int primary key,
libelle_medoc varchar(10),
type varchar(10),
prix number(5,2));
/*
	Population de la table Médicament
*/
INSERT INTO MEDICAMENT VALUES (1,'Doliprane', 'comp',164.8);
INSERT INTO MEDICAMENT VALUES (2,'Doliprane', 'efferv',65);
INSERT INTO MEDICAMENT VALUES (3,'Doliprane', 'suppo',123.76);
INSERT INTO MEDICAMENT VALUES (4,'Amoxil', 'comp',254.8);
INSERT INTO MEDICAMENT VALUES (5,'Votrex', 'comp',364.7);
INSERT INTO MEDICAMENT VALUES (5432,'Aspirine', 'comp',115.05);
/*
	Création de la table Maladie
*/
create table MALADIE
(num_mal int primary key,
nom_mal varchar(10));
/*
	Population de la table Maladie
*/
INSERT INTO MALADIE VALUES (1, 'Grippe');
INSERT INTO MALADIE VALUES (2, 'Angine');
INSERT INTO MALADIE VALUES (3, 'Pharyngite');
/*
	Création de la table Préscrire
*/
create table PRESCRIRE(
code_medoc int references MEDICAMENT(code_medoc),
num_consult int references CONSULTATION(num_consult),
nb_prises int,
primary key (num_consult,code_medoc));
/*
	Population de la table Préscrire
*/
INSERT INTO PRESCRIRE VALUES (1,1,3);
INSERT INTO PRESCRIRE VALUES (1,4,2);
INSERT INTO PRESCRIRE VALUES (1,5,2);
INSERT INTO PRESCRIRE VALUES (3,5,1);
INSERT INTO PRESCRIRE VALUES (4,5,4);
/*
	Création de la table Diagnostiquer
*/
create table DIAGNOSTIQUER(
code_consult int references CONSULTATION(num_consult),
num_mal int references MALADIE(num_mal),
primary key (code_consult,num_mal));
/*
	Population de la table Diagnostiquer
*/
INSERT INTO DIAGNOSTIQUER VALUES (1,3);
INSERT INTO DIAGNOSTIQUER VALUES (2,1);
INSERT INTO DIAGNOSTIQUER VALUES (3,2);
INSERT INTO DIAGNOSTIQUER VALUES (4,2);
INSERT INTO DIAGNOSTIQUER VALUES (2,2);
INSERT INTO DIAGNOSTIQUER VALUES (2,3);
/*
	Validation des changements
*/

Commit;