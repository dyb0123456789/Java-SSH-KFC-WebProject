package com.dyb.kfc.dao;

import java.util.List;

import com.dyb.kfc.entity.Meal;

public interface MealDAO {
	List<Meal> findMealByType(int typeId);

	List<Meal> findMealByKeyword(String str);

	Meal findMeal(int mid);
}
