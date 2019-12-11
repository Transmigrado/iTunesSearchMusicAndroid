package com.blueprint.itunes

import android.app.Application
import com.blueprint.itunes.di.myModule
import org.koin.core.context.startKoin

open class application : Application(){

    override fun onCreate(){
        super.onCreate()

        startKoin {
            modules(myModule)
        }


    }

}