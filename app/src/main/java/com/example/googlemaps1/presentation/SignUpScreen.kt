package com.example.googlemaps1.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.googlemaps1.domain.model.PhoneAuthActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val message = remember { mutableStateOf("") }
        OutlinedTextField(
            message.value,
            { message.value = it },
            label = { Text(text = "Phone number") },
            placeholder = { Text(text = "Phone number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,

            )
        Spacer(modifier = Modifier.size(26.dp))

        Button(onClick = { PhoneAuthActivity() }) {

        }
    }
}