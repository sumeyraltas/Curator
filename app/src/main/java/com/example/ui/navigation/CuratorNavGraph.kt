package com.example.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesomeMotion
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AutoAwesomeMotion
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.screens.ArtworkDetailScreen
import com.example.ui.screens.CollectionScreen
import com.example.ui.screens.DiscoverScreen
import com.example.ui.screens.SearchScreen
import com.example.ui.viewmodel.ArtworkDetailViewModel
import com.example.ui.viewmodel.CuratorViewModel

sealed class Screen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    data object Discover : Screen("discover", "Discover", Icons.Filled.Explore, Icons.Outlined.Explore)
    data object Search : Screen("search", "Search", Icons.Filled.Search, Icons.Outlined.Search)
    data object Collection : Screen("collection", "Collection", Icons.Filled.AutoAwesomeMotion, Icons.Outlined.AutoAwesomeMotion)
    data object Detail : Screen("detail/{artworkId}", "Detail", Icons.Filled.Explore, Icons.Outlined.Explore) {
        fun createRoute(artworkId: String) = "detail/$artworkId"
    }
}

@Composable
fun CuratorApp() {
    val navController = rememberNavController()
    val curatorViewModel: CuratorViewModel = viewModel()
    val detailViewModel: ArtworkDetailViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavItems = listOf(
        Screen.Discover,
        Screen.Search,
        Screen.Collection
    )

    val showBottomBar = currentRoute in bottomNavItems.map { it.route }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.95f),
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.testTag("bottom_navigation_bar")
                ) {
                    bottomNavItems.forEach { screen ->
                        val selected = currentRoute == screen.route
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (selected) screen.selectedIcon else screen.unselectedIcon,
                                    contentDescription = screen.title
                                )
                            },
                            label = {
                                Text(
                                    text = screen.title,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.secondary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                unselectedTextColor = MaterialTheme.colorScheme.secondary,
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f)
                            ),
                            modifier = Modifier.testTag("nav_item_${screen.route}")
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Discover.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Discover.route) {
                DiscoverScreen(
                    viewModel = curatorViewModel,
                    onArtworkClick = { artwork ->
                        navController.navigate(Screen.Detail.createRoute(artwork.id))
                    },
                    onSearchClick = {
                        navController.navigate(Screen.Search.route)
                    }
                )
            }

            composable(Screen.Search.route) {
                SearchScreen(
                    viewModel = curatorViewModel,
                    onArtworkClick = { artwork ->
                        navController.navigate(Screen.Detail.createRoute(artwork.id))
                    }
                )
            }

            composable(Screen.Collection.route) {
                CollectionScreen(
                    viewModel = curatorViewModel,
                    onArtworkClick = { artwork ->
                        navController.navigate(Screen.Detail.createRoute(artwork.id))
                    }
                )
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("artworkId") { type = NavType.StringType })
            ) { backStackEntry ->
                val artworkId = backStackEntry.arguments?.getString("artworkId") ?: ""
                ArtworkDetailScreen(
                    artworkId = artworkId,
                    viewModel = detailViewModel,
                    onBackClick = { navController.popBackStack() },
                    onRelatedArtworkClick = { artwork ->
                        navController.navigate(Screen.Detail.createRoute(artwork.id))
                    }
                )
            }
        }
    }
}
