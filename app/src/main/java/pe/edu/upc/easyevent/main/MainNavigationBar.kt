package pe.edu.upc.main

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun MainNavigationBar() {
    BottomAppBar {

        NavigationItem.entries.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = { /* Handle navigation item click */ },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.label)
                    )
                },
                label = {
                    Text(text = stringResource(item.label))
                }
            )

        }
    }
}