package com.example.componentesestados

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestados.ui.theme.ComponentesEstadosTheme
import com.example.componentesestados.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    val textInput = remember {
        mutableStateOf("")
    }

    val quantidade = remember {
        mutableStateOf("")
    }

    Column (
        modifier = modifier.fillMaxSize()
            .background(Color(239, 247, 207))
    ) {
        Text(
            text = "Aulas android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            text = "com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        AndroidEnemy(
            modifier = Modifier.size(100.dp),
            color = Color.Red
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textInput.value,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)

                textInput.value = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            label = {
                Text("Nome e sobrenome")
            }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = quantidade.value,
            onValueChange = { novoValor ->
                Log.i("teste", novoValor)

                quantidade.value = novoValor
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text("Qual a quantidade?")
            }
        )
    }
}

@Composable
fun AndroidEnemy(
    modifier: Modifier = Modifier,
    color: Color
){
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy"
    )
}
