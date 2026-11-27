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
private val CardDark = Color(0xFF151B24)
private val Gold = Color(0xFFFFC857)
private val Green = Color(0xFF20D68A)
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

            Text(
                "SELECT MARKET",
                color = Grey,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                MarketButton("OTC", market == "OTC") { market = "OTC" }
                MarketButton("LIVE", market == "LIVE") { market = "LIVE" }
            }

            Spacer(Modifier.height(25.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = CardDark
                ),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "AI SIGNAL",
                        color = Grey,
                        fontSize = 13.sp
                    )

                    Spacer(Modifier.height(15.dp))

                    Text(
                        signal,
                        color = Gold,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        "1 MINUTE TIMEFRAME",
                        color = Grey,
                        fontSize = 11.sp
                    )

                    Spacer(Modifier.height(20.dp))

                    Button(
                        onClick = { signal = "WAIT" },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Gold
                        )
                    ) {
                        Text("RESET SIGNAL", color = Dark)
                    }
                }
            }

            Spacer(Modifier.height(25.dp))

            Text(
                "MARKET ANALYSIS",
                color = Gold,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(12.dp))

            InfoCard("Market", market)
            InfoCard("Timeframe", "1 Minute")
            InfoCard("Trend", "Not analyzed")
            InfoCard("Support / Resistance", "Not detected")

            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                SignalButton("BUY", Green) { signal = "BUY" }
                SignalButton("SELL", Red) { signal = "SELL" }
                SignalButton("WAIT", Gold) { signal = "WAIT" }
            }

            Spacer(Modifier.weight(1f))

            Text(
                "Educational analysis only • No guaranteed profits",
                color = Grey,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun MarketButton(
    name: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Gold else CardDark
        ),
        modifier = Modifier.weight(1f)
    ) {
        Text(
            name,
            color = if (selected) Dark else White
        )
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 9.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardDark
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, color = Grey, fontSize = 12.sp)
            Text(value, color = White, fontSize = 12.sp)
        }
    }
}

@Composable
fun RowScope.SignalButton(
    name: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.weight(1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        Text(name, color = Dark, fontSize = 11.sp)
    }
}
