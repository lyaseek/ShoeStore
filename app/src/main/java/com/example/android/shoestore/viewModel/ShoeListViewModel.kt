package com.example.android.shoestore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    var description = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var size = MutableLiveData<Double>()
    var company = MutableLiveData<String>()
    val shoesArray = MutableLiveData<MutableList<Shoe>>()

    init {
        shoesArray.value = ArrayList()
    }

    fun addShoe() {
        val shoe = Shoe(
            this.name.value.orEmpty(),
            this.size.value!!,
            this.company.value.orEmpty(),
            this.description.value.orEmpty()
        )
        shoesArray.value?.add(shoe)
        shoesArray.value = shoesArray.value
    }
}