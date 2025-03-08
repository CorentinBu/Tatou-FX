/*Ajout dans la Table Utilisateur */
INSERT INTO public."Utilisateur"("nomUtilisateur", "prenomUtilisateur", "ageUtilisateur", "photoProfil", formation, universite, "adresseMail", "motDePasse", "villeLogement", "ListeFavorisPub", "ListeStrucSuivie")
	VALUES ('Marc', 'Evans', 17, 'https://i.pinimg.com/originals/11/82/3f/11823fc47ee87854d13a7c7f91ac435c.jpg', 'STAPS', 'Raimon', 'marcEvans@gmail.com', '14ViVe_LE_FoOT!', NULL, NULL, NULL);

	
INSERT INTO public."Utilisateur"(
	"nomUtilisateur", "prenomUtilisateur", "ageUtilisateur", "photoProfil", formation, universite, "adresseMail", "motDePasse", "villeLogement", "ListeFavorisPub", "ListeStrucSuivie")
	VALUES ('Eva', 'Martin', 20, 'https://us.123rf.com/450wm/serafimamanekina/serafimamanekina1805/serafimamanekina180500151/102019321-portrait-d-une-jeune-fille-de-profil-avec-ses-cheveux-vers-le-bas-et-avec-une-rose-%C3%A0-la-main-en.jpg', 'Art', 'Ynov', 'evaMartin45@gmail.com', '!JdEtg@Rfa', NULL, NULL, NULL);

/*Ajout dans la Table Catégorie */
INSERT INTO public."Categorie"("nomCategorie") VALUES ('Association');
INSERT INTO public."Categorie"("nomCategorie") VALUES ('Club');
INSERT INTO public."Categorie"("nomCategorie") VALUES ('Entreprise');

/*Ajout dans la Table Structure*/
INSERT INTO public."Structure"(
	"numRNA", "nomStructure", "adresseMail", "logoAsso", "motDePasse", localisation, description, "typeStructure", "listePub", "listeUtilisateur")
	VALUES (41654921, 'eco-vert', 'ecoVert@contact.fr', 'https://cdn-icons-png.flaticon.com/512/5688/5688994.png', 'JiA#z4feT!', '40-46 Bd du Montparnasse 75006 Paris', 'Pour protêger notre planête !', 1, NULL, NULL);

INSERT INTO public."Structure"(
	"numRNA", "nomStructure", "adresseMail", "logoAsso", "motDePasse", localisation, description, "typeStructure", "listePub", "listeUtilisateur")
	VALUES (91548315, 'Mairie Orsay', 'contact@marie-orsay.fr', 'https://www.fjps.fr/sites/default/files/articles/images/1/logo-mairie-orsay.fr.png', '4aHo?8fe4!', '2 Place du Général Leclerc 91400 Orsay', 'Utile pour pour toute demande d’acte de naissance, acte de décès, acte de mariage et recherche de jobs étudiant.', 3, NULL, NULL);

/*Ajout dans la table Publication*/
INSERT INTO public."Publication"(
	"titulairePub", "descriptionPub", "dataPub", "listeImg", "idUtilisateur")
	VALUES ('eco-vert', 'On se regroupe pour ramasser les déchêts. Hésitez pas à venir', '12/02/2025', NULL, 1);
	
INSERT INTO public."Publication"(
	"titulairePub", "descriptionPub", "dataPub", "listeImg", "idUtilisateur")
	VALUES ('eco-vert', 'On recherche activement des étudiants ! On participe au forum des associations.', '20/02/2025', NULL, 1);
	
INSERT INTO public."Publication"(
	"titulairePub", "descriptionPub", "dataPub", "listeImg", "idUtilisateur")
	VALUES ('eco-vert', 'On fait une manifestation contre le projet de loi.', '28/02/2025', NULL, 1);

INSERT INTO public."Publication"(
	"titulairePub", "descriptionPub", "dataPub", "listeImg", "idUtilisateur")
	VALUES ('Mairie Orsay', 'Nous avons des jobs étudiants pour ceux qui sont intéressés.', '05/03/2025', NULL, 5);
	
/*Ajout dans la table Commentaire*/
INSERT INTO public."Commentaire"(
	texte, "idUtilisateur", "idPublication")
	VALUES ('Super! je viendrai.', 5, 1);

INSERT INTO public."Commentaire"(
	texte, "idUtilisateur", "idPublication")
	VALUES ('Moi aussi, je viens avec des amis !', 3, 1);

INSERT INTO public."Commentaire"(
	texte, "idUtilisateur", "idPublication")
	VALUES ('Je vais aussi au forum', 5, 2);

INSERT INTO public."Commentaire"(
	texte, "idUtilisateur", "idPublication")
	VALUES ('Je suis intéressée !', 5, 4);
	
/*Affichage des Tables*/
SELECT * FROM public."Utilisateur";
SELECT * FROM public."Categorie";
SELECT * FROM public."Structure";
SELECT * FROM public."Publication";
SELECT * FROM public."Commentaire";