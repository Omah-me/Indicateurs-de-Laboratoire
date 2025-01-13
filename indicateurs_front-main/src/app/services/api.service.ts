import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Article } from '../models/article.model';
import { Conference } from '../models/conference.model';
import { Livre } from '../models/livre.model';
import { Personne } from '../models/personne.model';
import { Personnel } from '../models/personnel.model';
import { Projet } from '../models/projet.model';
import { Revue } from '../models/revue.model';
import { Chercheur } from '../models/chercheur.model';
import { Doctorant } from '../models/doctorant.model';
import { AutrePoste } from '../models/autrePoste.model';




@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private api_url_local = 'http://localhost:8080/api';
  private api_url_dev = 'http://172.31.60.56:8080/api';
  private api_url_prod = 'http://172.31.60.57:8080/api';

  private api_url = this.getApiUrl();

  private getApiUrl(): string {
    const hostname = window.location.hostname;
    if (hostname === 'localhost') {
      return this.api_url_local;
    } else if (hostname === '172.31.60.56') {
      return this.api_url_dev;
    } else if (hostname === '172.31.60.57') {
      return this.api_url_prod;
    } else {
      throw new Error('Unknown environment');
    }
  }

  constructor(private http: HttpClient) { }

  getArticle(): Observable<Article> {
    const url = `${this.api_url}/articles`;
    return this.http.get<Article>(url);
  }

  getConference(): Observable<Conference> {
    const url = `${this.api_url}/conferences`;
    return this.http.get<Conference>(url);
  }

  getLivre(): Observable<Livre> {
    const url = `${this.api_url}/livres`;
    return this.http.get<Livre>(url);
  }

  getPersonne(): Observable<Personne> {
    const url = `${this.api_url}/personnes`;
    return this.http.get<Personne>(url);
  }

  getPersonnel(): Observable<Personnel[]> {
    const url = `${this.api_url}/personnels`;
    return this.http.get<Personnel[]>(url);
  }

  getProjet(): Observable<Projet> {
    const url = `${this.api_url}/projects`;
    return this.http.get<Projet>(url);
  }

  getRevue(): Observable<Revue> {
    const url = `${this.api_url}/revues`;
    return this.http.get<Revue>(url);
  }
  
  

  searchPersonneByNom(nom: string): Observable<Personne[]> {
    const url = `${this.api_url}/personnes?nom=${encodeURIComponent(nom)}`;
    return this.http.get<Personne[]>(url);
  }
  
  
  searchChercheur(query: string): Observable<Chercheur[]> {
    const url = `${this.api_url}/chercheurs?nom=${encodeURIComponent(query)}&prenom=${encodeURIComponent(query)}`;
    return this.http.get<Chercheur[]>(url);
  }
  
  searchDoctorant(query: string): Observable<Doctorant[]> {
    const url = `${this.api_url}/doctorants?nom=${encodeURIComponent(query)}&prenom=${encodeURIComponent(query)}`;
    return this.http.get<Doctorant[]>(url);
}

searchAutrePoste(query: string): Observable<AutrePoste[]> {
  const url = `${this.api_url}/autrepostes?nom=${encodeURIComponent(query)}&prenom=${encodeURIComponent(query)}`;
  return this.http.get<AutrePoste[]>(url);
}

searchArticle(query: string): Observable<Article[]> {
  const url = `${this.api_url}/articles?titre=${encodeURIComponent(query)}`;
  return this.http.get<Article[]>(url);
}

searchRevue(query: string): Observable<Revue[]> {
  const url = `${this.api_url}/revues?titre=${encodeURIComponent(query)}&domaine=${encodeURIComponent(query)}`;
  return this.http.get<Revue[]>(url);
}

searchConference(query: string): Observable<Conference[]> {
  const url = `${this.api_url}/conferences?titre=${encodeURIComponent(query)}&classe=${encodeURIComponent(query)}`;
  return this.http.get<Conference[]>(url);
}

}
