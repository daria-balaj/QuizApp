import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

interface Player {
  id: number;
  username: string;
  score: number;
  correct: number;
  totalQuestions: number;
  averageTime: number;
  rank?: number;
  profileImg?: string
}

@Component({
  selector: 'app-multiplayer-results',
  imports: [
    CommonModule
  ],
  templateUrl: './multiplayer-results.component.html',
  styleUrl: './multiplayer-results.component.css'
})


export class MultiplayerResultsComponent {
  players: Player[] = [];
  totalQuestions: number = 15;
  totalPlayers: number = 8;
  totalTime: string = '4:32';
  
  constructor(private readonly router: Router) { }

  ngOnInit(): void {
    this.players = [
      { 
        id: 1, 
        username: 'Jacob', 
        score: 940, 
        correct: 14, 
        totalQuestions: 15, 
        averageTime: 3.2 
      },
      { 
        id: 2, 
        username: 'Emma', 
        score: 820, 
        correct: 13, 
        totalQuestions: 15, 
        averageTime: 3.6 
      },
      { 
        id: 3, 
        username: 'Sophia', 
        score: 755, 
        correct: 12, 
        totalQuestions: 15, 
        averageTime: 4.1 
      },
      { 
        id: 4, 
        username: 'Noah', 
        score: 720, 
        correct: 12, 
        totalQuestions: 15, 
        averageTime: 4.5 
      },
      { 
        id: 5, 
        username: 'Olivia', 
        score: 685, 
        correct: 11, 
        totalQuestions: 15, 
        averageTime: 3.9 
      },
      { 
        id: 6, 
        username: 'Liam', 
        score: 640, 
        correct: 10, 
        totalQuestions: 15, 
        averageTime: 3.7 
      },
      { 
        id: 7, 
        username: 'Ava', 
        score: 615, 
        correct: 10, 
        totalQuestions: 15, 
        averageTime: 4.2 
      },
      { 
        id: 8, 
        username: 'William', 
        score: 580, 
        correct: 9, 
        totalQuestions: 15, 
        averageTime: 4.0 
      }
    ];
    
    // Sort players by score (descending) and assign ranks
    this.players.sort((a, b) => b.score - a.score);
    this.players.forEach((player, index) => {
      player.rank = index + 1;
    });
  }
  
  topThreePlayers(): Player[] {
    return this.players.slice(0, 3);
  }
  
  firstPlacePlayer(): Player {
    return this.players[0];
  }
  
  secondPlacePlayer(): Player {
    return this.players[1];
  }
  
  thirdPlacePlayer(): Player | undefined {
    return this.players.length > 2 ? this.players[2] : undefined;
  }
  
  formatCorrect(player: Player): string {
    return `${player.correct}/${player.totalQuestions}`;
  }
  
  /**
   * Formats the average time as a string with "s" suffix
   */
  formatTime(time: number): string {
    return `${time.toFixed(1)}s`;
  }
  
  /**
   * Returns the appropriate CSS class for a player's rank
   */
  getRankClass(rank: number): string {
    if (rank === 1) return 'first';
    if (rank === 2) return 'second';
    if (rank === 3) return 'third';
    return '';
  }
  
  /**
   * Navigate back to the home page
   */
  goToHome(): void {
    this.router.navigate(['/']);
  }
  
  playAgain(): void {
    // In a real app, you would preserve the quiz settings and start a new game
    // For now, we'll just navigate to the home page
    this.router.navigate(['/']);
  }
}
