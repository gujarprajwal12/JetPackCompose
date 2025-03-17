package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicTheme() {
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        BusinessCard()
                    }
                }
        }
    }
}




@Composable
fun BusinessCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with your image
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Prajwal Shekhar Gujar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Android Developer",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            ContactInfoRow(Icons.Default.Email, "prajwal@gmail.com")
            ContactInfoRow(Icons.Default.Phone, "+91 7040452312")
            ContactInfoRow(Icons.Default.LocationOn, "Shevgaon, India")
        }
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp), tint = Color.Black)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCard()
}

