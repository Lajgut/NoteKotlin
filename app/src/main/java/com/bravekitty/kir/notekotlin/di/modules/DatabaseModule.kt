package com.bravekitty.kir.notekotlin.di.modules

import com.bravekitty.kir.notekotlin.data.database.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(): NoteRepository = NoteRepository()
}