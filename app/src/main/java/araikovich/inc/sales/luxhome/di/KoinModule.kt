package araikovich.inc.sales.luxhome.di

import araikovich.inc.sales.luxhome.domain.repository.ItemsRepository
import araikovich.inc.sales.luxhome.domain.repository.impl.ItemsRepositoryImpl
import araikovich.inc.sales.luxhome.ui.items.StoreItemsViewModel
import org.koin.dsl.module

val itemsModule = module {
    single { StoreItemsViewModel(get()) }
    single { ItemsRepositoryImpl() as ItemsRepository }
}