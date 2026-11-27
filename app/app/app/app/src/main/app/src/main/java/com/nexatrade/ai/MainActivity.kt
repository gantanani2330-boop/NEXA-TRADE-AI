
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
private val Green = Color(0xFF19C37D)
private val Red = Color(0xFFFF5555)
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
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(20.dp))

            Text(
                "NEXA TRADE AI",
                color = Gold,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "SMART MARKET ANALYSIS",
                color = Grey,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(30.dp))

            Text("SELECT MARKET", color = Grey)

            Spacer(Modifier.height(12.dp))

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
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("CURRENT SIGNAL", color = Grey)

                    Spacer(Modifier.height(15.dp))

                    Text(
                        signal,
                        color = when (signal) {
                            "BUY" -> Green
                            "SELL" -> Red
                            else -> Gold
                        },
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text("1 MINUTE TIMEFRAME", color = Grey)

                    Spacer(Modifier.height(15.dp))

                    Button(onClick = { signal = "WAIT" }) {
                        Text("RESET")
                    }
                }
            }

            Spacer(Modifier.height(25.dp))

            Text(
                "MARKET ANALYSIS",
                color = Gold,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(15.dp))

            AnalysisRow("Market", market)
            AnalysisRow("Timeframe", "1 Minute")
            AnalysisRow("Trend", "Not analyzed")
            AnalysisRow("Support", "Not detected")
            AnalysisRow("Resistance", "Not detected")

            Spacer(Modifier.height(25.dp))

            Text("MANUAL SIGNAL", color = Grey)

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { signal = "BUY" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green
                    )
                ) {
                    Text("BUY")
                }

                Button(
                    onClick = { signal = "SELL" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Red
                    )
                ) {
                    Text("SELL")
                }

                Button(
                    onClick = { signal = "WAIT" }
                ) {
                    Text("WAIT")
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                "Educational demo only. No guaranteed profits.",
                color = Grey,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun AnalysisRow(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, color = Grey)
        Text(
            value,
            color = White,
            fontWeight = FontWeight.Medium
        )
    }
}
