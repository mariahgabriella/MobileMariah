package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

// Classe de dados para representar uma mensagem
data class Message(val author: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Column(modifier = Modifier.padding(16.dp)) {
                    MessageCard(Message("Fluttershy", "Olá!"))
                    Spacer(modifier = Modifier.height(16.dp))
                    Contador()
                }
            }
        }
    }
}
@Composable
fun Contador() {
    var contador by remember { mutableStateOf(0) }

    // Botão que incrementa o contador a cada clique
    Button(onClick = { contador += 1 }) {
        Text("Cliquei $contador vezes")
    }
}
@Composable
fun MessageCard(msg: Message) {
    // Linha para colocar imagem e textos lado a lado
    Row(modifier = Modifier.padding(8.dp)) {
        // Imagem circular de perfil
        Image(
            painter = painterResource(id = R.drawable.fluttershy),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        // Coluna para empilhar autor e corpo da mensagem
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = msg.author, style = MaterialTheme.typography.titleMedium)
            Text(text = msg.body, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    // Preview para visualizar no Android Studio sem rodar o app
    MyApplicationTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            MessageCard(Message("Fluttershy", "Olá!"))
            Spacer(modifier = Modifier.height(16.dp))
            Contador()
        }
    }
}
