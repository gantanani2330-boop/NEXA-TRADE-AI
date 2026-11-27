package com.nexatrade.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Dark = Color(0xFF080B10)
private val Gold = Color(0xFFFFC857)
private val White = Color(0xFFF5F5F5)
private val Grey = Color(0xFF9299A5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexaDashboard()
        }
    }
}

@Composable
fun NexaDashboard() {
    var market by remember { mutableStateOf("OTC") }
    var signal by remember { mutableStateOf("WAIT") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Dark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                "NEXA TRADE AI",
                color = Gold,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "SMART MARKET ANALYSIS",
                color = Grey,
                fontSize = 11.sp
            )

            Spacer(Modifier.height(28.dp))

            Text("SELECT MARKET", color = Grey)

            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = { market = "OTC" }) {
                    Text("OTC")
                }
                Button(onClick = { market = "LIVE" }) {
                    Text("LIVE")
                }
            }

            Spacer(Modifier.height(25.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF151B24)
                ),
                shape = RoundedCornerShape(18.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("AI SIGNAL", color = Grey)

                    Spacer(Modifier.height(15.dp))

                    Text(
                        signal,
                        color = Gold,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text("1 MINUTE TIMEFRAME", color = Grey)

                    Spacer(Modifier.height(15.dp))

                    Button(onClick = { signal = "WAIT" }) {
                        Text("RESET SIGNAL")
                    }
                }
            }

            Spacer(Modifier.height(25.dp))

            Text("MARKET ANALYSIS", color = Gold)

            Spacer(Modifier.height(15.dp))

            Text("Market: $market", color = White)
            Text("Timeframe: 1 Minute", color = White)
            Text("Trend: Not analyzed", color = White)
            Text("Support / Resistance: Not detected", color = White)

            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { signal = "BUY" }) {
                    Text("BUY")
                }

                Button(onClick = { signal = "SELL" }) {
                    Text("SELL")
                }

                Button(onClick = { signal = "WAIT" }) {
                    Text("WAIT")
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                "Educational analysis only. No guaranteed profits.",
                color = Grey,
                fontSize = 10.sp
            )
        }
    }
}
