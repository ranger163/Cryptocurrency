package me.inassar.cryptocurrency.presentation

/**
 * Created by Nassar on 03,November,2021
 */
sealed class ScreenRout(val route: String) {
    object CoinListScreen : ScreenRout("coin_list_screen")
    object CoinDetailScreen : ScreenRout("coin_detail_screen")
}
