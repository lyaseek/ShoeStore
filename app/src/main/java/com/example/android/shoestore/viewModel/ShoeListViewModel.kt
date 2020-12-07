package com.example.android.shoestore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    val shoesArray = MutableLiveData<MutableList<Shoe>>()

    init {
        shoesArray.value = ArrayList()
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        shoesArray.value?.add(shoe)
        shoesArray.value = shoesArray.value
    }
}