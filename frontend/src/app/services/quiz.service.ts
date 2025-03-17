import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private httpClient: HttpClient) { }

  getCategories() {
    return this.httpClient.get<string[]>('/api/categories');
  }

  getQuestions() {
    return this.httpClient.get<Question[]>('/api/get-question-set');
  }
}
