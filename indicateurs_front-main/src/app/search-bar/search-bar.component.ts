import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { Chercheur } from '../models/chercheur.model';
import { Doctorant } from '../models/doctorant.model';
import { AutrePoste } from '../models/autrePoste.model';
import { Article } from '../models/article.model';
import { Conference } from '../models/conference.model';
import { Revue } from '../models/revue.model';
import { CommonModule } from '@angular/common';
import { forkJoin } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [FormsModule, CommonModule,HttpClientModule],
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss']
})
export class SearchBarComponent {
  searchQuery: string = '';
  searchType: string = 'chercheurs';
  chercheurList: Chercheur[] = [];
doctorantList: Doctorant[] = [];
autrePosteList: AutrePoste[] = [];
articleList: Article[] = [];
revueList: Revue[] = [];
conferenceList: Conference[] = [];


  constructor(private apiService: ApiService) {}

  onSearch() {
    if (this.searchQuery.trim().length > 0) {
      // Ajuster la recherche selon le type sélectionné
      if (this.searchType === 'articles') {
        this.searchArticles();
      } else if (this.searchType === 'revues') {
        this.searchRevues();
      } else if (this.searchType === 'conferences') {
        this.searchConferences();
      } else if (this.searchType === 'chercheurs') {
        this.searchChercheursDoctorantsAutres();
      }
    } else {
      // Réinitialiser les listes
      this.clearLists();
    }
  }

  searchArticles() {
    this.apiService.searchArticle(this.searchQuery).subscribe({
      next: (data) => {
        this.articleList = data;
      },
      error: (err) => {
        console.error('Erreur lors de la recherche d\'articles :', err);
        this.articleList = [];
      }
    });
  }

  searchRevues() {
    this.apiService.searchRevue(this.searchQuery).subscribe({
      next: (data) => {
        this.revueList = data;
      },
      error: (err) => {
        console.error('Erreur lors de la recherche de revues :', err);
        this.revueList = [];
      }
    });
  }

  searchConferences() {
    this.apiService.searchConference(this.searchQuery).subscribe({
      next: (data) => {
        this.conferenceList = data;
      },
      error: (err) => {
        console.error('Erreur lors de la recherche de conférences :', err);
        this.conferenceList = [];
      }
    });
  }

  searchChercheursDoctorantsAutres() {
    const chercheurSearch = this.apiService.searchChercheur(this.searchQuery);
    const doctorantSearch = this.apiService.searchDoctorant(this.searchQuery);
    const autrePosteSearch = this.apiService.searchAutrePoste(this.searchQuery);

    forkJoin([chercheurSearch, doctorantSearch, autrePosteSearch]).subscribe({
      next: ([chercheursData, doctorantsData, autresPostesData]) => {
        this.chercheurList = chercheursData;
        this.doctorantList = doctorantsData;
        this.autrePosteList = autresPostesData;
      },
      error: (err) => {
        console.error('Erreur lors de la recherche des chercheurs/doctorants/autres postes :', err);
        this.chercheurList = [];
        this.doctorantList = [];
        this.autrePosteList = [];
      }
    });
  }

  clearLists() {
    this.chercheurList = [];
    this.doctorantList = [];
    this.autrePosteList = [];
    this.articleList = [];
    this.revueList = [];
    this.conferenceList = [];
  }

  clearSearch() {
    this.searchQuery = '';
    this.clearLists();
  }
  
  onKeydown(event: KeyboardEvent) {
    if (event.key === "Enter") {
      event.preventDefault();
      this.onSearch(); 
    }
  } 


}

