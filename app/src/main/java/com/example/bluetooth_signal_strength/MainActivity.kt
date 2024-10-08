package com.example.bluetooth_signal_strength

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bluetooth_signal_strength.ui.theme.Bluetooth_Signal_StrengthTheme
import android.graphics.Color
import android.widget.LinearLayout

class MainActivity : ComponentActivity() {

    private lateinit var signalTextView: TextView
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signalTextView = findViewById(R.id.signalTextView)
        rootLayout = findViewById(R.id.rootLayout)

        displaySignalStrength(-42)
    }

    private fun displaySignalStrength(rssi: Short) {
        val signalStrengthText = "Signalstärke: $rssi dBm"
        signalTextView.text = signalStrengthText

        // Verändere die Farbe basierend auf der Signalstärke
        when {
            rssi > -20 -> rootLayout.setBackgroundColor(Color.parseColor("#FF0000"))  // Starkes Signal (Rot)
            rssi > -25 -> rootLayout.setBackgroundColor(Color.parseColor("#FF4000"))  // Sehr gutes Signal (Dunkelorange)
            rssi > -30 -> rootLayout.setBackgroundColor(Color.parseColor("#FF7F00"))  // Gutes Signal (Orange)
            rssi > -35 -> rootLayout.setBackgroundColor(Color.parseColor("#FFBF00"))  // Akzeptables Signal (Hellorange)
            rssi > -40 -> rootLayout.setBackgroundColor(Color.parseColor("#FFFF00"))  // Mittleres Signal (Gelb)
            rssi > -45 -> rootLayout.setBackgroundColor(Color.parseColor("#BFFF00"))  // Schwaches Signal (Gelbgrün)
            rssi > -50 -> rootLayout.setBackgroundColor(Color.parseColor("#7FFF00"))  // Sehr schwaches Signal (Hellgrün)
            rssi > -55 -> rootLayout.setBackgroundColor(Color.parseColor("#3FFF00"))  // Sehr schwaches Signal (Grün)
            rssi > -60 -> rootLayout.setBackgroundColor(Color.parseColor("#00FF00"))  // Sehr schwaches Signal (Dunkelgrün)
            else -> rootLayout.setBackgroundColor(Color.parseColor("#0000FF"))        // Schwaches Signal (Blau)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bluetooth_Signal_StrengthTheme {
        Greeting("Android")
    }
}