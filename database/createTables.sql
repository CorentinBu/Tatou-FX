-- Table: public.Administrateur

DROP TABLE IF EXISTS public."Administrateur";
DROP TABLE IF EXISTS public."Categorie";
DROP TABLE IF EXISTS public."Commentaire";
DROP TABLE IF EXISTS public."Publication";
DROP TABLE IF EXISTS public."Structure";
DROP TABLE IF EXISTS public."Utilisateur";

CREATE TABLE IF NOT EXISTS public."Administrateur"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    mail text COLLATE pg_catalog."default",
    mdp text COLLATE pg_catalog."default",
    CONSTRAINT "Administrateur_pkey" PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public."Categorie"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "nomCategorie" text COLLATE pg_catalog."default",
    CONSTRAINT "Categorie_pkey" PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public."Utilisateur"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "nomUtilisateur" text COLLATE pg_catalog."default" NOT NULL,
    "prenomUtilisateur" text COLLATE pg_catalog."default" NOT NULL,
    "ageUtilisateur" integer,
    "photoProfil" text COLLATE pg_catalog."default",
    formation text COLLATE pg_catalog."default",
    universite text COLLATE pg_catalog."default",
    "adresseMail" text COLLATE pg_catalog."default",
    "motDePasse" text COLLATE pg_catalog."default",
    "villeLogement" text COLLATE pg_catalog."default",
    "ListeFavorisPub" text[] COLLATE pg_catalog."default",
    "ListeStrucSuivie" text[] COLLATE pg_catalog."default",
    CONSTRAINT "Utilisateur_pkey" PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public."Structure"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "numRNA" integer NOT NULL,
    "nomStructure" text COLLATE pg_catalog."default" NOT NULL,
    "adresseMail" text COLLATE pg_catalog."default",
    "logoAsso" text COLLATE pg_catalog."default",
    "motDePasse" text COLLATE pg_catalog."default",
    localisation text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    "typeStructure" integer,
    "listePub" text[] COLLATE pg_catalog."default",
    "listeUtilisateur" text[] COLLATE pg_catalog."default",
    CONSTRAINT "Structure_pkey" PRIMARY KEY (id),
    CONSTRAINT "categorie_FK" FOREIGN KEY ("typeStructure")
        REFERENCES public."Categorie" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE IF NOT EXISTS public."Publication"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "titulairePub" text COLLATE pg_catalog."default" NOT NULL,
    "descriptionPub" text COLLATE pg_catalog."default" NOT NULL,
    "dataPub" date,
    "listeImg" path[],
    "idStructure" integer,
    CONSTRAINT "Publication_pkey" PRIMARY KEY (id),
    CONSTRAINT "idStructure_FK" FOREIGN KEY ("idStructure")
        REFERENCES public."Structure" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE IF NOT EXISTS public."Commentaire"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    texte text COLLATE pg_catalog."default",
    "idUtilisateur" integer,
    "idPublication" integer,
    CONSTRAINT "Commentaire_pkey" PRIMARY KEY (id),
    CONSTRAINT "Publication_FK" FOREIGN KEY ("idPublication")
        REFERENCES public."Publication" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "Utilisateur_FK" FOREIGN KEY ("idUtilisateur")
        REFERENCES public."Utilisateur" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)


