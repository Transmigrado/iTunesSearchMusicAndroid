package com.blueprint.itunes.di

import com.blueprint.itunes.datasource.api.RestTrack
import com.blueprint.itunes.viewmodel.TracksModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val myModule : Module = module {
    viewModel { TracksModel(get()) }
    single { RestTrack() }
}