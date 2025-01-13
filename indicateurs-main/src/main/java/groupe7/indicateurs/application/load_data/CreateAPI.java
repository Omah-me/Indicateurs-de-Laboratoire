// package groupe7.indicateurs.application.load_data;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.time.LocalDate;
// import java.time.Year;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import groupe7.indicateurs.domain.article.model.Article;
// import groupe7.indicateurs.domain.article.repository.ArticleRepository;
// import groupe7.indicateurs.domain.conference.model.Conference;
// import groupe7.indicateurs.domain.conference.repository.ConferenceRepository;
// import groupe7.indicateurs.domain.revue.model.Revue;
// import groupe7.indicateurs.domain.revue.repository.RevueRepository;
// import jakarta.annotation.PostConstruct;

// @Service
// public class CreateAPI {

//     @Autowired
//     private ConferenceRepository conferenceRepository;

//     @Autowired
//     private ArticleRepository articleRepository;

//     @Autowired
//     private RevueRepository revueRepository;

//     private final String bibTexFilePath = "results.txt";



//     @PostConstruct
//     public void init() {
//         loadDataArticle(bibTexFilePath);
//     }

//     @Transactional
//     public void loadDataArticle(String path) {
//         ClassPathResource resource = new ClassPathResource(path);
//         try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
//             String line;
//             String titre = null;
//             LocalDate date = null;
//             Year dateConf= null;
//             Year dateRevue= null;
//             String booktitle= null;
//             //String auteurs= null;
//             String domaine= null;
//             String publisher= null;

//             while ((line = reader.readLine()) != null) {
//                 if (line.startsWith("@article") /*|| line.startsWith("@inproceedings") || line.startsWith("@incollection")*/) {
                    
//                     while ((line = reader.readLine()) != null && !line.startsWith("}")) {
//                         if (line.contains("TITLE")) {
//                             titre = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                         } 
//                         if (line.contains("YEAR")) {
//                             try {
//                                 String year = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                                 date = LocalDate.of(Integer.parseInt(year), 1, 1);
//                                 dateRevue =Year.of(Integer.parseInt(year));
//                             } catch (NumberFormatException e) {
//                                 System.err.println("Erreur lors de l'analyse de l'année : " + line);
//                                 date = null;
//                                 dateRevue = null;
//                             }
//                         }
//                         if (line.contains("JOURNAL")) {
//                             domaine = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                         }
//                         if (line.contains("BOOKTITLE")) {
//                             booktitle = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                         }
//                         if (line.contains("PUBLISHER")) {
//                             publisher = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                         }

//                         // if (line.contains("AUTHOR")) {
//                         //     String[] authors = line.split("=", 2)[1].replaceAll("[{,}]", "").trim().split(" and ");
//                         //     StringBuilder auteursBuilder = new StringBuilder();
//                         //     for (String author : authors) {
//                         //         String firstName = author.trim().split(" ")[0];
//                         //         auteursBuilder.append(firstName).append(",");
//                         //     }
//                         //     auteurs = auteursBuilder.length() > 0 ? auteursBuilder.toString().replaceAll(",$", "") : null;
//                         // }
//                     }

//                     if (titre != null && date != null && publisher !=null && dateRevue != null && domaine != null/*auteurs != null*/) {
//                         Article article = new Article();
//                         article.setTitre(titre);
//                         article.setDate(date);
//                         articleRepository.save(article);

//                         Revue revue= new Revue();
//                         revue.setAnnee(dateRevue);
//                         revue.setClassement(publisher);
//                         revue.setTitre(domaine);
//                         revue.setDomaine(domaine);
//                         revueRepository.save(revue);
//                     }
//                 }

//                 if (line.startsWith("@inproceedings")) {
//                     while ((line = reader.readLine()) != null && !line.startsWith("}")) {
//                         if (line.contains("YEAR")) {
//                             try {
//                                 String year = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                                 dateConf =Year.of(Integer.parseInt(year));
//                             } catch (NumberFormatException e) {
//                                 System.err.println("Erreur lors de l'analyse de l'année : " + line);
//                                 dateConf = null;
//                             }
//                         }
//                         if (line.contains("BOOKTITLE")) {
//                             booktitle = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                         }
//                         if (line.contains("PUBLISHER")) {
//                             publisher = line.split("=", 2)[1].replaceAll("[{,}]", "").trim();
//                         }
//                     }


//                     if (booktitle != null && dateConf != null && publisher!=null) {
//                         Conference conference = new Conference();
//                         conference.setTitre(booktitle);
//                         conference.setClasse(publisher);
//                         conference.setAnnee(dateConf);
//                         conferenceRepository.save(conference);
//                     }

//                 }
//             }
//         } catch (IOException e) {
//             System.err.println("Une erreur s'est produite : " + e.getMessage());
//             e.printStackTrace();
//         }
//     }
// }
