-- Table personne
CREATE TABLE personne (
  pe_id_personne INT PRIMARY KEY AUTO_INCREMENT,
  pe_nom VARCHAR(255),
  pe_prenom VARCHAR(255),
  pe_hdr BOOLEAN
);

-- Table personnel
CREATE TABLE personnel (
  pr_id_personnel INT PRIMARY KEY,
  pr_statut VARCHAR(255),
  pr_equipe VARCHAR(255),
  pr_titulaire BOOLEAN,
  pr_date_debut DATE,
  pr_date_fin DATE
);

-- Table chercheur
CREATE TABLE chercheur (
  ch_id_chercheur INT PRIMARY KEY
);

-- Table doctorant
CREATE TABLE doctorant (
  do_id_doctorant INT PRIMARY KEY,
  do_id_encadrant INT,
  do_date_de_soutenance DATE
);

-- Table autre_poste
CREATE TABLE autre_poste (
  ap_id_poste INT PRIMARY KEY,
  ap_titre VARCHAR(255)
);

-- Table projet
CREATE TABLE projet (
  pj_id_projet INT PRIMARY KEY AUTO_INCREMENT,
  pj_nom VARCHAR(255),
  pj_id_contributeurprojet INT,
  pj_date_debut DATE,
  pj_date_fin DATE,
  pj_type VARCHAR(255),
  pj_budget DECIMAL(15, 2),
  pj_partenariat BOOLEAN
);

-- Table liaison_personnel_projet
CREATE TABLE liaison_personnel_projet (
  lc_id_projet INT,
  lc_id_personnel INT,
  PRIMARY KEY (lc_id_projet, lc_id_personnel)
);

-- Table article
CREATE TABLE article (
  at_id_article INT PRIMARY KEY AUTO_INCREMENT,
  at_titre VARCHAR(255),
  at_date DATE
);

-- Table liaison_personne_article
CREATE TABLE liaison_personne_article (
  au_id_personne INT,
  au_id_article INT,
  au_isprincipal BOOLEAN,
  PRIMARY KEY (au_id_personne, au_id_article)
);

-- Table conference
CREATE TABLE conference (
  cf_id_conf INT PRIMARY KEY AUTO_INCREMENT,
  cf_titre VARCHAR(255),
  cf_classe VARCHAR(255),
  cf_annee INT
);

-- Table revue
CREATE TABLE revue (
  re_id_revue INT PRIMARY KEY AUTO_INCREMENT,
  re_annee INT,
  re_titre VARCHAR(255),
  re_classement VARCHAR(255),
  re_domaine VARCHAR(255)
);

-- Table liaison_article_conference
CREATE TABLE liaison_article_conference (
  ac_id_article INT,
  ac_id_conference INT,
  PRIMARY KEY (ac_id_article, ac_id_conference)
);

-- Table liaison_article_revue
CREATE TABLE liaison_article_revue (
  ar_id_article INT,
  ar_id_revue INT,
  PRIMARY KEY (ar_id_article, ar_id_revue)
);

-- Table livre
CREATE TABLE livre (
  li_id_livre INT PRIMARY KEY AUTO_INCREMENT,
  li_id_article INT,
  li_annee INT,
  li_titre VARCHAR(255)
);

-- Table liaison_livre_article
CREATE TABLE liaison_livre_article (
  la_id_livre INT,
  la_id_article INT,
  PRIMARY KEY (la_id_livre, la_id_article)
);

-- Foreign key references
ALTER TABLE personnel ADD CONSTRAINT fk_personnel_personne FOREIGN KEY (pr_id_personnel) REFERENCES personne(pe_id_personne);
ALTER TABLE chercheur ADD CONSTRAINT fk_chercheur_personnel FOREIGN KEY (ch_id_chercheur) REFERENCES personnel(pr_id_personnel);
ALTER TABLE doctorant ADD CONSTRAINT fk_doctorant_personnel FOREIGN KEY (do_id_doctorant) REFERENCES personnel(pr_id_personnel);
ALTER TABLE doctorant ADD CONSTRAINT fk_doctorant_encadrant FOREIGN KEY (do_id_encadrant) REFERENCES personnel(pr_id_personnel);
ALTER TABLE autre_poste ADD CONSTRAINT fk_autre_poste_personnel FOREIGN KEY (ap_id_poste) REFERENCES personnel(pr_id_personnel);
ALTER TABLE liaison_personnel_projet ADD CONSTRAINT fk_lc_projet FOREIGN KEY (lc_id_projet) REFERENCES projet(pj_id_projet);
ALTER TABLE liaison_personnel_projet ADD CONSTRAINT fk_lc_personnel FOREIGN KEY (lc_id_personnel) REFERENCES personnel(pr_id_personnel);
ALTER TABLE liaison_personne_article ADD CONSTRAINT fk_au_article FOREIGN KEY (au_id_article) REFERENCES article(at_id_article);
ALTER TABLE liaison_personne_article ADD CONSTRAINT fk_au_personne FOREIGN KEY (au_id_personne) REFERENCES personne(pe_id_personne);
ALTER TABLE liaison_article_conference ADD CONSTRAINT fk_ac_article FOREIGN KEY (ac_id_article) REFERENCES article(at_id_article);
ALTER TABLE liaison_article_conference ADD CONSTRAINT fk_ac_conference FOREIGN KEY (ac_id_conference) REFERENCES conference(cf_id_conf);
ALTER TABLE liaison_article_revue ADD CONSTRAINT fk_ar_article FOREIGN KEY (ar_id_article) REFERENCES article(at_id_article);
ALTER TABLE liaison_article_revue ADD CONSTRAINT fk_ar_revue FOREIGN KEY (ar_id_revue) REFERENCES revue(re_id_revue);
ALTER TABLE livre ADD CONSTRAINT fk_li_article FOREIGN KEY (li_id_article) REFERENCES article(at_id_article);