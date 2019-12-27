package araikovich.inc.sales.luxhome

import android.app.Application
import araikovich.inc.sales.luxhome.di.itemsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(itemsModule)
        }
    }
}