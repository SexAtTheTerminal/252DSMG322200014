package com.example.lemonadetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadetest.ui.theme.LemonadeTestTheme
import com.example.lemonadetest.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTestTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeTextWithImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        AppHeader(
            text = "Lemonade",
            fontSize = 24.sp,
            align = TextAlign.Center
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onImageClick,
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            )
            {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier.wrapContentSize()
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(textLabelResourceId)
            )
        }
    }
}

@Composable
fun AppHeader(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            textAlign = align,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    Surface ( modifier = Modifier
        .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(currentStep){
            1 -> {
                LemonadeTextWithImage(
                    textLabelResourceId = R.string.lemonade_title_1,
                    drawableResourceId = R.drawable.lemon_tree,
                    contentDescriptionResourceId = R.string.lemonade_description_1,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                )
            }

            2 -> {
                LemonadeTextWithImage(
                    textLabelResourceId = R.string.lemonade_title_2,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId = R.string.lemonade_description_2,
                    onImageClick = {
                        squeezeCount --
                        if (squeezeCount == 0){
                            currentStep = 3
                        }
                    }
                )
            }

            3 -> {
                LemonadeTextWithImage(
                    textLabelResourceId = R.string.lemonade_title_3,
                    drawableResourceId = R.drawable.lemon_drink,
                    contentDescriptionResourceId = R.string.lemonade_description_3,
                    onImageClick = {
                        currentStep = 4
                    }
                )
            }

            4 -> {
                LemonadeTextWithImage(
                    textLabelResourceId = R.string.lemonade_title_4,
                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId = R.string.lemonade_description_4,
                    onImageClick = {
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTestTheme {
        LemonadeApp()
}
}