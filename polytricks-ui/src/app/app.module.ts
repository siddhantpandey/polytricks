import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginsuccessComponent } from './components/loginsuccess/loginsuccess.component';
import { UserComponent } from './components/user/user.component';
import { Routes, RouterModule } from '@angular/router';


import { CustomMaterialModule } from './core/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { UserService } from './app.service';
import { AuthService } from './core/auth.service';

import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';
import { Interceptor } from './core/interceptor.service';



import { LandingPageComponent } from "./component/landing-page/landing-page.component";
import { DashboardComponent } from "./component/dashboard/dashboard.component";
import { ProfileComponent } from "./component/profile/profile.component";
import { StatisticksComponent } from "./component/statisticks/statisticks.component";
import { NavigationComponent } from "./component/navigation/navigation.component";
import { ActivityComponent } from "./component/activity/activity.component";
import { MatNativeDateModule } from '@angular/material';
import { DemoMaterialModule } from 'src/material-module';
import { TokenStorage } from './core/token.sotrage.service';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AngularFontAwesomeModule } from "angular-font-awesome";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FooterComponent } from './components/footer/footer.component';

const paths: Routes = [
  { path: "", component: LandingPageComponent },
  { path: "dashboard/:state", component: DashboardComponent },
  { path: "profile/:pId", component: ProfileComponent },
  { path: "activity/:pId", component: ActivityComponent },
  { path: "comment/:pId", component: StatisticksComponent },
  { path: 'user', component: UserComponent },
  { path: 'login', component: LoginComponent },
  { path: 'loginSuccess', component: LoginsuccessComponent },
  { path: 'register', component: RegisterComponent },
  { path: "dashboard/:field/:srchVal", component: DashboardComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    DashboardComponent,
    ProfileComponent,
    StatisticksComponent,
    NavigationComponent,
    ActivityComponent,
    LoginComponent,
    LoginsuccessComponent,
    RegisterComponent,
    UserComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(paths),
    AngularFontAwesomeModule,
    DemoMaterialModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    CustomMaterialModule,
  ],
  providers: [UserService, AuthService, TokenStorage, TokenStorage,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent],
  entryComponents: [AppComponent]
})
export class AppModule { }

platformBrowserDynamic().bootstrapModule(AppModule);
