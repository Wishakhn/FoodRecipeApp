package com.kmm.foodrecipeapp.android.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kmm.foodrecipeapp.domain.model.RecipeInfoModel
import kotlinx.coroutines.flow.map

class FoodAppPreference(val context: Context) {
    companion object Keys {
        val RECIPE_ID = intPreferencesKey("SelectedRecipeId")
        val BRAND_ID = intPreferencesKey("brandId")
        val NO_OF_SERVINGS = intPreferencesKey("numServings")
        val PREP_TIME = intPreferencesKey("prepTimeMinutes")
        val COUNTRY = stringPreferencesKey("country")
        val URL = stringPreferencesKey("thumbnailUrl")
        val NUTRITIONS = stringPreferencesKey("nutritionVisibility")
        val NAME = stringPreferencesKey("name")
        val DESCRIPTION = stringPreferencesKey("description")
        private const val USER_DATASTORE = "FoodApp-Data-Store-Preferences"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

    }

    suspend fun saveSelectedRecipe(recipe: RecipeInfoModel) {
        context.dataStore.edit {
            it[RECIPE_ID] = recipe.id ?: 0
            it[BRAND_ID] = recipe.brandId ?: 0
            it[NO_OF_SERVINGS] = recipe.numServings ?: 0
            it[PREP_TIME] = recipe.prepTimeMinutes ?: 0
            it[COUNTRY] = recipe.country ?: ""
            it[URL] = recipe.thumbnailUrl ?: ""
            it[NUTRITIONS] = recipe.nutritionVisibility ?: ""
            it[NAME] = recipe.name ?: ""
            it[DESCRIPTION] = recipe.description ?: ""
        }
    }

    fun getRecipeModel() = context.dataStore.data.map {
        RecipeInfoModel(
            id = it[RECIPE_ID],
            brandId = it[BRAND_ID],
            numServings = it[NO_OF_SERVINGS],
            prepTimeMinutes = it[PREP_TIME],
            country = it[COUNTRY],
            thumbnailUrl = it[URL],
            nutritionVisibility = it[NUTRITIONS],
            name = it[NAME],
            description = it[DESCRIPTION],
        )
    }


}
