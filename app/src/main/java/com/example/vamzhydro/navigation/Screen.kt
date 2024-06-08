package com.example.vamzhydro.navigation

sealed class Screen(val route: String ) {
    data object Home: Screen(route = "home_screen")
    data object AddRecord: Screen(route = "add_record_screen")
    data object EditRecord: Screen(route = "edit_record_screen")
}
