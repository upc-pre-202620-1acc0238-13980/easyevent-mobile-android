package pe.edu.upc.main

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

@Composable
fun MainNavigationBar() {

    var selectedItem by rememberSaveable {
        mutableStateOf(NavigationItem.entries.first())
    }

    BottomAppBar {

        NavigationItem.entries.forEach { item ->
            val selected = selectedItem == item
            NavigationBarItem(
                selected = selected,
                onClick = {
                    selectedItem = item
                },
                icon = {
                    Icon(
                        imageVector = if (selected) item.icon else item.outlinedIcon,
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