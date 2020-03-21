package com.ackee.retrofitexceptionsmapping.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ackee.retrofitexceptionsmapping.R
import com.ackee.retrofitexceptionsmapping.di.viewModelsFactory
import com.ackee.retrofitexceptionsmapping.domain.AsyncState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> { viewModelsFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindUiEvents()
        observeViewModelStates()
    }

    private fun bindUiEvents() {
        btn_fetch_recipes.setOnClickListener {
            viewModel.fetchRecipes()
        }
        btn_fetch_recipe_detail.setOnClickListener {
            viewModel.fetchRecipeDetail(edit_recipe_id.text.toString())
        }
    }

    private fun observeViewModelStates() {
        viewModel.recipesLoadingState.observe(this, Observer { state ->
            when (state) {
                is AsyncState.Loading -> txt_recipes.text = "Loading"
                is AsyncState.Error -> txt_recipes.text = state.exception.toString()
                is AsyncState.Loaded -> txt_recipes.text = state.data.joinToString(separator = "\n") { it.name }
            }
        })

        viewModel.recipeDetailLoadingState.observe(this, Observer { state ->
            when (state) {
                is AsyncState.Loading -> txt_recipe_detail.text = "Loading"
                is AsyncState.Error -> txt_recipe_detail.text = state.exception.toString()
                is AsyncState.Loaded -> txt_recipe_detail.text = state.data.toString()
            }
        })
    }
}