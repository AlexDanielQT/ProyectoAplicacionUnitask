package com.example.proyect.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(taskName: String, subject: String, isChecked: Boolean) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(Color(0xFFF3E3FA), shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = taskName, modifier = Modifier.weight(1f), color = Color(0xFF1D1B20))
            Text(text = subject, color = Color(0xFF49454F))
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(checked = isChecked, onCheckedChange = { /* Acción del checkbox */ })
        }
    }
    Divider(color = Color.Gray, thickness = 1.dp)
}
