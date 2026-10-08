package pe.edu.upc.main

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import pe.edu.upc.core.designsystems.favorite
import pe.edu.upc.core.designsystems.favoriteOutlined
import pe.edu.upc.core.designsystems.home
import pe.edu.upc.core.designsystems.homeOutlined
import pe.edu.upc.easyevent.R

enum class NavigationItem(
    val route: @Serializable Any,
    val icon: ImageVector,
    val outlinedIcon: ImageVector,
    val label: Int
) {
    HOME(
        route = HomeRoute,
        icon = home,
        outlinedIcon = homeOutlined,
        label = R.string.tab_home
    ),
    FAVORITES(
        route = FavoritesRoute,
        icon = favorite,
        outlinedIcon = favoriteOutlined,
        label = R.string.tab_favorites
    )
}