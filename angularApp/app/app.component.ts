import { Component } from '@angular/core';
@Component({
  selector: 'my-app',
  template: `
            <h1>Angular App</h1>
            <nav>
              <a routerLink="/depositos">depositos</a>
              <a routerLink="/usuarios">usuarios</a>
              <a routerLink="/gallineros">gallineros</a>
            </nav>
            <router-outlet></router-outlet>
            `
})
export class AppComponent { }
