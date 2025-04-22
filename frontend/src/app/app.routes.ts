import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { ResultsComponent } from './components/results/results.component';

export const routes: Routes = [
    { path: 'start-page', component: HomeComponent, pathMatch: 'full' },
    { path: 'quiz/:matchId', component: QuizComponent },
    { path: 'results/:matchId', component: ResultsComponent },
    { path: '**', redirectTo: 'start-page' }
];
