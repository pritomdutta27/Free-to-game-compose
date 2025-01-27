package dutta.pritom.gamelist.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dutta.pritom.gamelist.data.repository.FreeToGameListRepositoryImp
import dutta.pritom.gamelist.domain.repository.FreeToGameListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideFreeToGameListRepository(api: FreeToGameListRepositoryImp): FreeToGameListRepository
}