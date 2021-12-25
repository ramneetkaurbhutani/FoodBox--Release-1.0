import { Component, OnInit } from '@angular/core';
import { Food } from 'src/app/common/food';
import { FoodService } from 'src/app/services/food.service';

@Component({
  selector: 'app-food-list',
  templateUrl: './food-list-table.component.html',
  //templateUrl: './food-list.component.html',
  styleUrls: ['./food-list.component.css']
})
export class FoodListComponent implements OnInit {

  foods: Food[];

  constructor(private foodService: FoodService) { }

  ngOnInit(): void {
    this.listFoods();
  }

  listFoods() {
    this.foodService.getFoodList().subscribe(
      data => {
        this.foods = data;
      }
    );
  }
}
