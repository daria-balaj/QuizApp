import { HttpHandlerFn, HttpInterceptorFn } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

export function tokenInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn) : Observable<HttpEvent<unknown>> {
  // Get the auth token from the service.
  return next(req).pipe(
    tap((event: HttpEvent<any>) => {
      console.log('Incoming HTTP response', event);
    })
  );
  // return next(req);
};
