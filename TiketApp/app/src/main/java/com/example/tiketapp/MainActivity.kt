package com.example.tiketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                TicketScreen()
            }
        }
    }
}

@Composable
fun TicketScreen() {

    val hargaTiket = 25000

    var jumlahTiket by remember {
        mutableStateOf(1)
    }

    val totalBayar = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F6FA))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(36.dp)
        )

        Text(
            text = "🎟️",
            fontSize = 48.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Pemesanan Tiket",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1687F8)
        )

        Text(
            text = "Pesan tiket dengan mudah!",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // Harga Tiket
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Harga Tiket",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = formatRupiah(hargaTiket),
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1687F8)
                )

                Text(
                    text = "per tiket",
                    color = Color.Gray
                )
            }
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // Jumlah Tiket
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Jumlah Tiket",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = {
                            if (jumlahTiket > 1) {
                                jumlahTiket--
                            }
                        },
                        shape = CircleShape
                    ) {
                        Text(
                            text = "−",
                            fontSize = 24.sp
                        )
                    }


                    Text(
                        text = jumlahTiket.toString(),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Button(
                        onClick = {
                            jumlahTiket++
                        },
                        shape = CircleShape
                    ) {
                        Text(
                            text = "+",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // Total Bayar
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Total Bayar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = formatRupiah(totalBayar),
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF008A45)
                )
            }
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // Reset
        Button(
            onClick = {
                jumlahTiket = 1
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF04444)
            ),
            shape = RoundedCornerShape(14.dp)
        ) {

            Text(
                text = "↻  RESET",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun formatRupiah(value: Int): String {

    val formatted = "%,d"
        .format(value)
        .replace(',', '.')

    return "Rp$formatted"
}