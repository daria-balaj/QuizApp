import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { QuizService } from '../../../services/quiz.service';
import { MatIconModule } from '@angular/material/icon';

interface ConfettiPiece {
  x: number;
  y: number;
  size: number;
  color: string;
  rotation: number;
  speed: number;
  rotationSpeed: number;
  swingRange: number;
  swingSpeed: number;
}

@Component({
  selector: 'app-singleplayer-results',
  imports: [
    MatIconModule
  ],
  templateUrl: './singleplayer-results.component.html',
  styleUrl: './singleplayer-results.component.css'
})
export class SingleplayerResultsComponent {
  constructor(private readonly quizService: QuizService, private readonly elementRef: ElementRef) {}

  @Input() matchId?: string;
  correctAnswers?: number;
  score?: number;
  time: any;
  @ViewChild('confettiCanvas', { static: true }) confettiCanvas!: ElementRef<HTMLCanvasElement>;

  private ctx!: CanvasRenderingContext2D;
  private readonly confetti: Array<ConfettiPiece> = [];
  private animationId: number = 0;
  private readonly colors: string[] = [
    '#f94144', '#f3722c', '#f8961e', 
    '#f9c74f', '#90be6d', '#43aa8b', 
    '#577590', '#9b5de5', '#00bbf9'
  ];

  ngOnInit(): void {
    this.quizService.getQuizResults(this.matchId!).subscribe(result => {
      this.correctAnswers = result.correctAnswers;
      this.score = result.score;
      this.time = result.time;
    });
    this.initConfetti();
    this.generateConfetti();
    this.animateConfetti();
  }

  private initConfetti(): void {
    const canvas = this.confettiCanvas.nativeElement;
    const container = this.elementRef.nativeElement.querySelector('.single-player-summary');
    canvas.width = container.offsetWidth;
    canvas.height = container.offsetHeight + 200;
    this.ctx = canvas.getContext('2d')!;
    
    window.addEventListener('resize', () => {
      canvas.width = container.offsetWidth;
      canvas.height = container.offsetHeight + 200;
    });
  }

  private generateConfetti(): void {
    const canvas = this.confettiCanvas.nativeElement;
    const confettiCount = 150;
    
    for (let i = 0; i < confettiCount; i++) {
      this.confetti.push({
        x: Math.random() * canvas.width,
        y: Math.random() * canvas.height - canvas.height,
        size: Math.random() * 6 + 4,
        color: this.colors[Math.floor(Math.random() * this.colors.length)],
        rotation: Math.random() * 360,
        speed: Math.random() * 3 + 1,
        rotationSpeed: Math.random() * 2 - 1,
        swingRange: Math.random() * 4 - 2,
        swingSpeed: Math.random() * 0.02 + 0.01
      });
    }
  }

  private animateConfetti(): void {
    const canvas = this.confettiCanvas.nativeElement;
    this.ctx.clearRect(0, 0, canvas.width, canvas.height);
    
    let stillActive = false;
    for (const c of this.confetti) {
      c.x += Math.sin(c.y * c.swingSpeed) * c.swingRange;
      c.y += c.speed;
      c.rotation += c.rotationSpeed;
    
      this.ctx.save();
      this.ctx.translate(c.x, c.y);
      this.ctx.rotate(c.rotation * Math.PI / 180);
      this.ctx.fillStyle = c.color;
      this.ctx.fillRect(-c.size / 2, -c.size / 2, c.size, c.size);
      this.ctx.restore();
    
      if (c.y < canvas.height + c.size) {
        stillActive = true;
      }
    }
    
    
    if (stillActive) {
      this.animationId = requestAnimationFrame(() => this.animateConfetti());
    } else {
      canvas.style.display = 'none';
    }
  }

  ngOnDestroy(): void {
    if (this.animationId) {
      cancelAnimationFrame(this.animationId);
    }
  }
}
