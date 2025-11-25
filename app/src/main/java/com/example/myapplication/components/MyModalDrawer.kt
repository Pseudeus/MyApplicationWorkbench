package com.example.myapplication.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.components.model.NavigationDrawerItemModel

@Composable
fun MyModalDrawer(paddingValues: PaddingValues, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedId by remember { mutableIntStateOf(0) }

    val myItems = listOf(
        NavigationDrawerItemModel("Opcion 1", Icons.Default.Home, 3),
        NavigationDrawerItemModel("Opcion 2", Icons.Default.Person, 1),
        NavigationDrawerItemModel("Opcion 3", Icons.Default.Favorite, 0),
        NavigationDrawerItemModel("Opcion 4", Icons.Default.Build, 5),
    )

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(Modifier.padding(top = paddingValues.calculateTopPadding())) {
                myItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(item.title) },
                        selected = selectedId == index,
                        onClick = { selectedId = index },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        badge = { if (item.notification > 0) Badge { Text(item.notification.toString()) } }
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        content()
    }
}