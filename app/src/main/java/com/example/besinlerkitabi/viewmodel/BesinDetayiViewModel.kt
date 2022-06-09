package com.example.besinlerkitabi.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.service.BesinDatabase
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class BesinDetayiViewModel(application: Application) : BaseViewModel(application) {

    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl(uuid :Int){
       launch {
           val dao = BesinDatabase(getApplication()).besinDao()
           val besin = dao.getBesin(uuid)
           besinLiveData.value = besin
       }
    }

}