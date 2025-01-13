import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './services/api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterModule,
    HeaderComponent,
    FooterComponent,
    HttpClientModule
  ],
  providers: [ApiService],
  templateUrl: './app.component.html'
})
export class AppComponent {}