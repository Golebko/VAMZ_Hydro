package com.example.vamzhydro

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.example.vamzhydro.navigation.HydroNavHost
import com.example.vamzhydro.R.string


@Composable
fun HydroApp(navController: NavHostController = rememberNavController()) {
    //HydroNavHost(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack,
                        contentDescription = stringResource(string.button_back)
                    )
                }
            }
        }
    )
}

data class NavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

val items = listOf(
    NavItem(
        title = "home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home

    ),
    NavItem(
        title = "history",
        unselectedIcon = Icons.Outlined.DateRange,
        selectedIcon = Icons.Filled.DateRange

    ),
    NavItem(
        title = "settings",
        unselectedIcon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings

    )
)
@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,

    ) {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar {
        items.forEachIndexed { index, navItem ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    //navigateToItemEntry
                },
                label = {
                    Text(text = navItem.title)
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            navItem.selectedIcon
                        } else navItem.unselectedIcon,
                        contentDescription = navItem.title
                    )
                })
        }
    }
}