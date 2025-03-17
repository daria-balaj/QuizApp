import { Component } from '@angular/core';
import { MultiplayerResultsComponent } from './multiplayer-results/multiplayer-results.component';
import { NavComponent } from "../nav/nav.component";
import { QuizService } from '../../services/quiz.service';
import { SingleplayerResultsComponent } from './singleplayer-results/singleplayer-results.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-results',
  imports: [
    CommonModule,
    SingleplayerResultsComponent,
    MultiplayerResultsComponent,
    NavComponent
],
  templateUrl: './results.component.html',
  styleUrl: './results.component.css'
})
export class ResultsComponent {
  constructor(public quizService: QuizService) {}
  
}
