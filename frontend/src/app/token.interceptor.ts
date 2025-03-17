import { HttpEventType, HttpHandlerFn, HttpInterceptorFn } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { AuthenticationService } from './services/authentication.service';

export function tokenInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn): Observable<HttpEvent<unknown>> {
  
  const token = inject(AuthenticationService).getToken(); 

  const clonedRequest = req.clone({
    headers: req.headers.set('Authorization', `Bearer ${token}`)
  });
  return next(clonedRequest).pipe(
    tap((event: HttpEvent<any>) => {
      if (event.type === HttpEventType.Response) {
        console.log('Incoming HTTP response', event);
      }
    })
  );
}