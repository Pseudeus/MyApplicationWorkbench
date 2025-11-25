package com.example.myapplication.components

import android.icu.util.Calendar
import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.YearMonth

@Preview(showBackground = true)
@Composable
fun MyAlertDialog(modifier: Modifier = Modifier) {
    var status by remember { mutableStateOf(true) }

    if (status) {
        AlertDialog(
            onDismissRequest = { status = false },
            confirmButton = { OutlinedButton(onClick = { status = false }) { Text("Entiendo") } },
            text = { Text("Esta es mi descripción maafaka.") },
            title = { Text("Holiwi") },
            icon = {
                Icon(
                    modifier = Modifier.size(56.dp),
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            dismissButton = { TextButton(onClick = { status = false }) { Text("Cancelar") } },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyDateDialog() {
    var showDialog by remember { mutableStateOf(true) }

    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, 1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = null,
        yearRange = 2024..2025,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filteredCalendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filteredCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }
    )

    val otherDatePickerState = rememberDatePickerState(
        initialSelectedDate = LocalDate.now(),
        initialDisplayedMonth = YearMonth.of(2024, Month.AUGUST),
        yearRange = 2024..2025,

        )

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis
                    if (result != null) {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH) + 1
                        val month = newCalendar.get(Calendar.MONTH) + 1

                        Log.i("SELECTED DATE", "DAY: $day MONTH: $month")
                    }
                }) { Text("Confirmar") }
            }) {
            DatePicker(otherDatePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyTimePicker() {
    var showDialog by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        initialHour = LocalTime.now().hour,
        initialMinute = LocalTime.now().minute,
        is24Hour = false
    )

    if (showDialog) {
        TimePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { TextButton(onClick = {
                showDialog = false
                val minutes = timePickerState.minute
                val hours = timePickerState.hour
                timePickerState.is24hour
                Log.i("TIME PICKER", "HOUR: $hours MINUTES: $minutes")
            }) { Text("Set") } },
            title = { Text("Current time") }) {

            TimePicker(timePickerState, layoutType = TimePickerLayoutType.Vertical)
        }
    }
}