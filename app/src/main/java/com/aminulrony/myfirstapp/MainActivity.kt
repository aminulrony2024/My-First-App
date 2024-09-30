package com.aminulrony.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aminulrony.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Aminul()
                }
            }
        }
    }
}
@Composable
fun Aminul(){
    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Centimeter")}
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Text is working")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "outlined text field", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            Box {
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select the button")
                }
                DropdownMenu(expanded = true, onDismissRequest = {}) {
                    DropdownMenuItem(text = { Text("Aminul")}, onClick = {})
                    DropdownMenuItem(text = { Text("Islam")}, onClick = {})
                    DropdownMenuItem(text={Text("Rony")}, onClick = {})
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select the button")
                }
                DropdownMenu(expanded = true, onDismissRequest = {}) {
                    DropdownMenuItem(text = { Text("Aminul")}, onClick = {})
                    DropdownMenuItem(text = { Text("Islam")}, onClick = {})
                    DropdownMenuItem(text={Text("Rony")}, onClick = {})
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AminulPreview(){
    Aminul()
}