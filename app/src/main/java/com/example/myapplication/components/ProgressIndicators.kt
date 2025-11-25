package com.example.myapplication.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myapplication.R

@Preview
@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(140.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator(
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
    }
}

@Preview
@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0f) }
    var isLoading by remember { mutableStateOf(false) }

    val animatedProgress by animateFloatAsState(targetValue = progress)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.size(140.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Round
            )
            Spacer(Modifier.height(24.dp))
            LinearProgressIndicator(
                progress = { animatedProgress },
                color = Color.Red,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Round
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { progress -= 0.1f }) { Text("<-") }
                Button(onClick = { progress += 0.1f }) { Text("->") }
            }
        }
        Button(onClick = { isLoading = !isLoading }) { Text("show/hide") }
    }
}

@Preview
@Composable
fun ProgressAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.sandy_loading))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}