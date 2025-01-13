# Indicateurs Labo
Indicateurs Labo est une application web permettant d'analyser et de visualiser les données scientifiques des chercheurs, doctorants et enseignants du laboratoire IMVIA.

L'application propose des tableaux de bord interactifs, des graphiques et des indicateurs pour suivre les publications scientifiques et optimiser les performances du laboratoire.

# Technologies Utilisées
  # Backend
    Framework : Java Spring Boot
    Base de données :
    H2 (environnement de développement et test)
    MySQL (en production)
    API utilisée : HAL
  # Frontend
    Framework : Angular
    Outils Complémentaires
  # Tests : JUnit
    CI/CD : GitLab CI/CD (pipelines avancés pour le déploiement)
    
# Fonctionnalités
  Analyse des données HAL : Récupération et traitement des données via l’API HAL.
  Visualisation interactive : Création de tableaux de bord dynamiques pour suivre les performances des publications scientifiques (articles, conférences, etc.).
  Suivi des indicateurs : Génération de graphiques et de métriques clés pour faciliter la prise de décision.

# Installation et Déploiement
# Prérequis
  Java 11+
  Node.js et npm
  MySQL (pour l'environnement de production)
  Git

# Étapes d'installation
  # Cloner le dépôt :

    bash
    Copier le code
    git clone https://github.com/nom-utilisateur/nom-du-repo.git  
    cd nom-du-repo  

# Configurer la base de données :

  Modifier les paramètres dans le fichier application.properties (pour Spring Boot).

  # Lancer le backend :

    bash
    Copier le code
    ./mvnw spring-boot:run 
 
  # Lancer le frontend :

    bash
    Copier le code
    cd frontend  
    npm install  
    ng serve  
# Concepts Clés
  - Récupération des données : Exploitation de l’API HAL pour analyser les publications scientifiques.
  - Tableaux de bord interactifs : Suivi des métriques clés via des graphiques dynamiques.
  - Automatisation : Tests automatisés avec JUnit et pipelines CI/CD avancés sur GitLab.

# Licence
Ce projet est réalisé dans un cadre académique. Toute réutilisation ou modification est soumise à des conditions éducatives ou personnelles.
