package com.ltkordov.decisionmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ltkordov.decisionmaker.ui.theme.DecisionMakerTheme
import kotlin.random.Random

val HIGH_PROBABILITY = 0.8
val HIGH_LABEL = (HIGH_PROBABILITY * 100).toString() + "%\nChance"
val MED_PROBABILITY = 0.4
val MED_LABEL = (MED_PROBABILITY * 100).toString() + "%\nChance"
val LOW_PROBABILITY = 0.2
val LOW_LABEL =  (LOW_PROBABILITY * 100).toString() + "%\nChance"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionMakerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        StudentInfoHeader()
                        MainContentDisplay()
                    }

                }
            }
        }
    }
}

@Composable
fun StudentInfoHeader() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Created By:", fontSize = 28.sp)
        Text("Logan Kordov")
        Text("Student ID: 1844555")
        Text(text = "CCID: ltkordov", fontFamily = FontFamily.Monospace)
    }
}

class Randomizer() {
    private fun randomBool(probability: Double): Boolean {
        // If we want an ~80% change, probability = 0.8, we just check that nextDouble (a random number between 0 and 1) is <= 0.8
        val zeroToOne = Random.nextDouble()
        return zeroToOne <= probability
    }

    fun highProb(): Boolean {
        return randomBool(HIGH_PROBABILITY)
    }

    fun medProb(): Boolean {
        return randomBool(MED_PROBABILITY)
    }

    fun lowProb(): Boolean {
        return randomBool(LOW_PROBABILITY)
    }

    fun randomColor(dependencyInt: Int): Color {
        dependencyInt + 1; // This is purely so that I can pass in 'clicks' here, so that, everytime clicks updates, even if randomBool doesn't, it forces a new color
        val red = Math.floor(Random.nextDouble() * 200).toInt()
        val green = Math.floor(Random.nextDouble() * 200).toInt()
        val blue = Math.floor(Random.nextDouble() * 200).toInt()
        return Color(red, green, blue)
    }
}

@Composable
fun InputButtons(
    onResult: (result: Boolean) -> Unit,
    onAnyClick: () -> Unit
) {
    val randomizer = Randomizer()

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        SingleInput(
            modifier = Modifier.weight(1f),
            onClick = {
                onAnyClick()
                onResult(randomizer.highProb())
            },
            buttonLabel = "Really want to",
            subTitle = HIGH_LABEL,
        )
        SingleInput(
            modifier = Modifier.weight(1f),
            onClick = {
                onAnyClick()
                onResult(randomizer.medProb())
            },
            buttonLabel = "Kinda want to",
            subTitle = MED_LABEL,
        )
        SingleInput(
            modifier = Modifier.weight(1f),
            onClick = {
                onAnyClick()
                onResult(randomizer.lowProb())
            },
            buttonLabel = "Barely want to",
            subTitle = LOW_LABEL,
        )
    }
}
@Composable
fun SingleInput(
    onClick: () -> Unit,
    buttonLabel: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {onClick()}) {
            Text(text = buttonLabel, textAlign = TextAlign.Center)
        }
        Text(text = subTitle, textAlign = TextAlign.Center)
    }
}

@Composable
fun ClickCounter(
    clicks: Int
) {
    Text(modifier = Modifier.fillMaxWidth(), text = "Clicks: $clicks", textAlign = TextAlign.Center)
}

@Composable
fun ResultDisplay(
    clicks: Int,
    resultBool: Boolean?
) {
    val randomizer = Randomizer()
    var text = if (resultBool == null) "Make a choice" else if (resultBool) "You should go!" else "Don't go."
    Text(modifier = Modifier.fillMaxWidth(), text = text, color = randomizer.randomColor(clicks), textAlign = TextAlign.Center, fontSize = 36.sp)
}

@Composable
fun MainContentDisplay() {
    var clicks by remember { mutableStateOf(0) }
    var currentResult by remember {mutableStateOf<Boolean?>(null)}

    Column(modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically)) {
        ResultDisplay(resultBool = currentResult, clicks = clicks)
        InputButtons(
            onResult = {currentResult = it},
            onAnyClick = {clicks++}
        )
        ClickCounter(clicks = clicks)

    }
}