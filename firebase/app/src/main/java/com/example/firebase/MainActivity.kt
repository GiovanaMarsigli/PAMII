package com.example.firebase

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebase.ui.theme.FirebaseTheme
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(db)
        }
    }
}

@Composable
fun App(db: FirebaseFirestore) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var clientes by remember { mutableStateOf<List<Map<String, String>>>(emptyList()) }

    FirebaseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "App Firebase - Cadastrar",
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // Input fields
                InputField(label = "Nome", value = nome, onValueChange = { nome = it })
                Spacer(modifier = Modifier.height(16.dp))
                InputField(label = "Telefone", value = telefone, onValueChange = { telefone = it })

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val client = hashMapOf(
                            "nome" to nome,
                            "telefone" to telefone
                        )
                        db.collection("Clientes").add(client)
                            .addOnSuccessListener { documentReference ->
                                Log.d(TAG, "DocumentSnapshot written with ID ${documentReference.id}")
                                // Refresh the list after adding a new client
                                fetchClientes(db) { updatedClientes ->
                                    clientes = updatedClientes
                                }
                            }
                            .addOnFailureListener { e ->
                                Log.w(TAG, "Error writing document", e)
                            }
                    }
                ) {
                    Text(text = "Cadastrar")
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Lista de Clientes",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(clientes) { client ->
                        ClientRow(client)
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        fetchClientes(db) { updatedClientes ->
            clientes = updatedClientes
        }
    }
}

@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "$label:", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = value, onValueChange = onValueChange)
    }
}

@Composable
fun ClientRow(client: Map<String, String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(text = "Nome: ${client["nome"]}", fontSize = 16.sp)
        Text(text = "Telefone: ${client["telefone"]}", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(4.dp))
    }
}

private fun fetchClientes(db: FirebaseFirestore, onResult: (List<Map<String, String>>) -> Unit) {
    db.collection("Clientes")
        .get()
        .addOnSuccessListener { documents ->
            val clienteList = documents.map { document ->
                mapOf(
                    "nome" to (document.getString("nome") ?: ""),
                    "telefone" to (document.getString("telefone") ?: "")
                )
            }
            onResult(clienteList)
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents: ", exception)
            onResult(emptyList())
        }
}
