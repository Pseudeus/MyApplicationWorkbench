package com.example.myapplication.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(modifier = modifier, expanded = expanded, onExpandedChange = { expanded = !expanded }) {

        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text("Idioma") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier
                .menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryEditable
                )
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = 12.dp, y = 12.dp)
        ) {
            DropdownMenuItem(text = { Text("Opción 1") }, onClick = {
                selection = "Opción 1"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 2") }, onClick = {
                selection = "Opción 2"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 3") }, onClick = {
                selection = "Opción 3"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 4") }, onClick = {
                selection = "Opción 4"
                expanded = false
            })
        }
    }
}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        Button(onClick = { expanded = true }) {
            Text("Ver opciones")
        }

        DropdownMenu(
            expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = 12.dp, y = 12.dp)
        ) {
            DropdownMenuItem(text = { Text("Opción 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opción 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opción 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opción 4") }, onClick = { expanded = false })
        }
    }
}

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(text = { Text("Ejepmlo 1") }, onClick = {})
    }
}