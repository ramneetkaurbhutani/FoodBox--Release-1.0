import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Food } from '../common/food';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private baseUrl = 'http://localhost:8094/api/foods';

  constructor(private httpClient: HttpClient) { }

  getFoodList(): Observable<Food[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.foods)
    );
  }
}

interface GetResponse {
  _embedded: {
      foods: Food[];
  }
}
