package com.example.myapplication.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.components.state.CheckboxState

@Preview
@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue
            )
        )
    }
}

@Preview
@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var checkState by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier.clickable { checkState = !checkState },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checkState, onCheckedChange = { checkState = !checkState })
            Spacer(Modifier.width(8.dp))
            Text("Acepto los términos y condiciones.")
        }
    }
}

@Composable
fun ParentCheckboxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckboxState(
                    id = "terms",
                    label = "Aceptar los términos y condiciones."
                ),
                CheckboxState(
                    id = "newsletter",
                    label = "Recibir newsletter",
                    checked = true
                ),
                CheckboxState(
                    id = "updates",
                    label = "Recibir actualizaciones"
                )
            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckboxWithText(state = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        it.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckboxWithText(
    modifier: Modifier = Modifier,
    state: CheckboxState,
    onCheckChanged: (CheckboxState) -> Unit
) {
    Row(
        modifier = Modifier.clickable { onCheckChanged(state) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state.checked, onCheckedChange = { onCheckChanged(state) })
        Spacer(Modifier.width(8.dp))
        Text(state.label)
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }

    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = newState
            })
            Text("Ejemplo 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child1, onCheckedChange = { child1 = it })
            Text("Ejemplo 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Ejemplo 1")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var state by remember { mutableStateOf(false) }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = state, onClick = { state = !state }, enabled = true)
            Text("Ejemplo 1")
        }
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        RadioButtonComponent(name = "El GG", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "El PP", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "El OG", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "El SA", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "El ED", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "El AG", selectedName = selectedName) { selectedName = it }
    }
}

@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { onItemSelected(name) }) {
        RadioButton(selected = name == selectedName, onClick = { onItemSelected(name) })
        Text(name)
    }
}