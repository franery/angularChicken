import 'core-js/es7/reflect';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { DepositoModule } from './app/depositos/deposito.module';

platformBrowserDynamic().bootstrapModule(DepositoModule);