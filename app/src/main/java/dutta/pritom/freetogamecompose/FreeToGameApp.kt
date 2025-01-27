package dutta.pritom.freetogamecompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FreeToGameApp: Application(){
    override fun onCreate() {
        super.onCreate()
    }
}