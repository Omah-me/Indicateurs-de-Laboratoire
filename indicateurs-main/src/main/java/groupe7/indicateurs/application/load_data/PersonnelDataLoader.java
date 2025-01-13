// package groupe7.indicateurs.application.load_data;

// import java.io.IOException;
// import java.io.InputStream;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// import org.apache.poi.ss.usermodel.CellType;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.ss.usermodel.Sheet;
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import groupe7.indicateurs.domain.autre_poste.model.AutrePoste;
// import groupe7.indicateurs.domain.autre_poste.repository.AutrePosteRepository;
// import groupe7.indicateurs.domain.chercheur.model.Chercheur;
// import groupe7.indicateurs.domain.chercheur.repository.ChercheurRepository;
// import groupe7.indicateurs.domain.doctorant.model.Doctorant;
// import groupe7.indicateurs.domain.doctorant.repository.DoctorantRepository;
// import groupe7.indicateurs.domain.personne.model.Personne;
// import groupe7.indicateurs.domain.personne.repository.PersonneRepository;
// import groupe7.indicateurs.domain.personnel.model.Personnel;
// import groupe7.indicateurs.domain.personnel.repository.PersonnelRepository;
// import jakarta.annotation.PostConstruct;

// @Service
// public class PersonnelDataLoader {

//     @Autowired
//     private PersonnelRepository personnelRepository;

//     @Autowired
//     private ChercheurRepository chercheurRepository;

//     @Autowired
//     private DoctorantRepository doctorantRepository;

//     @Autowired
//     private AutrePosteRepository autrePosteRepository;

//     @Autowired
//     private PersonneRepository personneRepository;

//     // Chemin relatif au fichier dans resources
//     private final String filePath = "Personnel_2024-09-25.xlsx";

//     @PostConstruct
//     public void init() {
//         System.out.println("Chargement des données du personnel au démarrage...");
//         loadPersonnelData(filePath);
//     }

//     @Transactional
//     public void loadPersonnelData(String filePath) {
//         try {
//             // Charger le fichier depuis le classpath
//             ClassPathResource resource = new ClassPathResource(filePath);
//             InputStream inputStream = resource.getInputStream();

//             try (Workbook workbook = new XSSFWorkbook(inputStream)) {
//                 for (Sheet sheet : workbook) { // Parcours de chaque feuille
//                     for (Row row : sheet) { // Parcours de chaque ligne
//                         if (row.getRowNum() == 0) { // Ignorer la ligne d'entête
//                             continue;
//                         }

//                         // Lecture des cellules
//                         String nom = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
//                         String prenom = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "";
//                         Boolean hdr = row.getCell(5) != null;

//                         LocalDate dateDebut = null;
//                         if (row.getCell(6) != null && row.getCell(6).getCellType() == CellType.NUMERIC) {
//                             LocalDateTime localDateTime = row.getCell(6).getLocalDateTimeCellValue();
//                             dateDebut = localDateTime.toLocalDate();
//                         }

//                         LocalDate dateFin = null;
//                         if (row.getCell(7) != null && row.getCell(7).getCellType() == CellType.NUMERIC) {
//                             LocalDateTime localDateTime2 = row.getCell(7).getLocalDateTimeCellValue();
//                             dateFin = localDateTime2.toLocalDate();
//                         }

//                         String statut = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : "";
//                         Boolean titulaire = row.getCell(9) != null && "Titulaire".equalsIgnoreCase(row.getCell(9).getStringCellValue());
//                         String equipe = row.getCell(11) != null ? row.getCell(11).getStringCellValue() : "";

//                         LocalDate dateSoutenance = null;
//                         if (row.getCell(12) != null && row.getCell(12).getCellType() == CellType.NUMERIC) {
//                             LocalDateTime localDateTime3 = row.getCell(12).getLocalDateTimeCellValue();
//                             dateSoutenance = localDateTime3.toLocalDate();
//                         }

//                         // Création et sauvegarde des entités
//                         Personne personne = new Personne();
//                         personne.setNom(nom);
//                         personne.setPrenom(prenom);
//                         personne.setHdr(hdr);


//                         Personnel personnel = new Personnel(statut, equipe, titulaire, dateDebut, dateFin);
//                         personnel.setPersonne(personne); // Associer à Personne
                        

//                         // Sauvegarde d'autres entités si nécessaire
//                         if (personnel.getStatut().equalsIgnoreCase("Enseignant chercheur"))
//                         {
//                             Chercheur chercheur = new Chercheur();
//                             chercheur.setPersonnel(personnel);
//                             chercheurRepository.save(chercheur);
//                         }
                        
//                         if (personnel.getStatut().equalsIgnoreCase("Doctorant"))
//                         {
//                             Doctorant doctorant = new Doctorant(dateSoutenance,null,personnel);
//                             doctorantRepository.save(doctorant);
//                         }

//                         if (personnel.getStatut().equalsIgnoreCase("Post-doctorant"))
//                         {
//                             AutrePoste autrePoste = new AutrePoste();
//                             autrePoste.setPersonnel(personnel);
//                             autrePoste.setTitre(personnel.getStatut());
//                             autrePosteRepository.save(autrePoste);
//                         }    
//                         personnelRepository.save(personnel);
//                         personneRepository.save(personne);

//                     }
//                 }

//                 System.out.println("Données insérées avec succès dans la base de données.");
//             }
//         } catch (IOException e) {
//             System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
//         }

//         try {
//             // Charger le fichier depuis le classpath
//             ClassPathResource resource = new ClassPathResource(filePath);
//             InputStream inputStream = resource.getInputStream();

//             try (Workbook workbook = new XSSFWorkbook(inputStream)) {
//                 for (Sheet sheet : workbook) { // Parcours de chaque feuille
//                     for (Row row : sheet) { // Parcours de chaque ligne
//                         if (row.getRowNum() == 0) { // Ignorer la ligne d'entête
//                             continue;
//                         }

//                         if (row.getCell(8) != null && "Doctorant".equals(row.getCell(8).getStringCellValue())) {
//                             // Vérifier si la cellule 13 contient des données
//                             if (row.getCell(13) != null && row.getCell(13).getCellType() == CellType.STRING) {
//                                 String cellValue = row.getCell(13).getStringCellValue().trim();
//                                 String nomEncadrant = extractFirstEncadrantName(cellValue);

//                                 if (nomEncadrant != null && !nomEncadrant.isEmpty()) {
//                                     List<Long> idEncadrant = personneRepository.findIdsByNom(nomEncadrant);
//                                     List<Long> idDoctorant = personneRepository.findIdsByNom(
//                                         row.getCell(1) != null ? row.getCell(1).getStringCellValue().trim() : ""
//                                     );

//                                     if (!idEncadrant.isEmpty() && !idDoctorant.isEmpty()) {
//                                         doctorantRepository.updateIdEncadrant(idDoctorant.get(0), idEncadrant.get(0));
//                                     }
//                                 }
//                             }
//                         }
//                     }
//                 }
//             }
//         } catch (IOException e) {
//             System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
//         }
//     }

//     /**
//      * Extrait le nom du premier encadrant d'une chaîne donnée.
//      * @param cellValue La valeur de la cellule.
//      * @return Le nom du premier encadrant, ou null si aucun n'est trouvé.
//      */
//     private String extractFirstEncadrantName(String cellValue) {
//         if (cellValue == null || cellValue.trim().isEmpty()) {
//             return null; // Retourne null si la cellule est vide ou nulle
//         }

//         // Expression régulière pour capturer un nom compatible avec les cas fournis
//         Pattern pattern = Pattern.compile(
//             "([A-Z][A-Z\\s'-]*[A-Z]||[A-Z][a-z]+)\\s+(?:[A-Z][a-z]*||[A-Z]\\.?)\\s+(?:Co-encadrant||Directeur||Co-directeur)",
//             Pattern.UNICODE_CHARACTER_CLASS
//         );
//         Matcher matcher = pattern.matcher(cellValue.trim());

//         if (matcher.find()) {
//             return matcher.group(1).trim(); // Retourner uniquement le nom complet du premier encadrant
//         }

//         return null; // Aucun nom trouvé
//     }
// }
