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
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aminulrony.myfirstapp.ui.theme.MyFirstAppTheme
import kotlin.math.roundToInt

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
    var inputUnit by remember { mutableStateOf("Meter")}
    var outputUnit by remember { mutableStateOf("Meter")}
    var iExpanded by remember { mutableStateOf(false)}
    var oExpanded by remember { mutableStateOf(false)}
    val conversionFactor = remember { mutableDoubleStateOf(1.0) }
    val oConversionFactor = remember { mutableDoubleStateOf(1.0) }
    fun convertUnit()
    {00
        // ?: elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull()?: 0.0
        val result = (inputValueDouble * conversionFactor.doubleValue * 100.0 / oConversionFactor.doubleValue).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
            convertUnit()
        },label = { Text("Enter value :")})
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            Box {
                //Input Button
                Button(onClick = {iExpanded = true}) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select the button")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = {iExpanded = false}) {
                    DropdownMenuItem(text = { Text("Centimeter")}, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeter"
                        conversionFactor.doubleValue = 0.01
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text("Meter")}, onClick = {
                        iExpanded = false
                        inputUnit = "Meter"
                        conversionFactor.doubleValue = 1.0
                        convertUnit()
                    })
                    DropdownMenuItem(text={Text("Feet")}, onClick = {
                        iExpanded =false
                        inputUnit = "Feet"
                        conversionFactor.doubleValue = 0.3048
                        convertUnit()
                    })
                    DropdownMenuItem(text={Text("Milimeter")}, onClick = {
                        iExpanded = false
                        inputUnit = "Milimeter"
                        conversionFactor.doubleValue = 0.001
                        convertUnit()
                    })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Button
            Box {
                Button(onClick = { oExpanded = true}) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select the button")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {oExpanded = false}) {
                    DropdownMenuItem(text = { Text("Centimeter")}, onClick = {
                        oExpanded = false
                        outputUnit = "Centimeter"
                        oConversionFactor.doubleValue = 0.01
                        convertUnit()
                    })
                    DropdownMenuItem(text = { Text("Meter")}, onClick = {
                        oExpanded = false
                        outputUnit = "Meter"
                        oConversionFactor.doubleValue = 1.0
                        convertUnit()
                    })
                    DropdownMenuItem(text={Text("Feet")}, onClick = {
                        oExpanded = false
                        outputUnit = "Feet"
                        oConversionFactor.doubleValue = 0.3048
                        convertUnit()
                    })
                    DropdownMenuItem(text={Text("Milimeter")}, onClick = {
                        oExpanded = false
                        outputUnit = "Milimeter"
                        oConversionFactor.doubleValue = 0.001
                        convertUnit()
                    })
                }
            }
        }
        Text(text = "Result : $outputValue")
    }
}


@Preview(showBackground = true)
@Composable
fun AminulPreview(){
    Aminul()
}