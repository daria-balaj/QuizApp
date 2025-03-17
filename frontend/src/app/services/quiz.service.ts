import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private httpClient: HttpClient) { }

  quizSettings: { mode: string, categories: string[], difficulty: string, questionCount: number } = {
    mode: 'single',
    categories: [],
    difficulty: '',
    questionCount: 0
  }

  getQuizSettings() {
    return this.quizSettings;
  }

 setQuizSettings(mode: string, categories: string[], difficulty: string, count: number ) {
    this.quizSettings = {
      mode: mode,
      categories: categories,
      difficulty: difficulty,
      questionCount: count
    }
 } 

 getMode() : string {
  return this.quizSettings.mode;
 }

  getCategories() {
    return this.httpClient.get<string[]>('/api/categories');
  }

  getQuestions() {
    return this.httpClient.get<Question[]>('/api/get-question-set');
  }

  pickOption() {
    // return this.httpClient.post<string>(`${environment.quizApiUrl}/pick-option`)
  }
}
