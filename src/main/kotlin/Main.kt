// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch

@Composable
fun TrackerView(helper: TrackerViewHelper, removeMessage: () -> Unit) {
    Surface(elevation = 1.dp, modifier = Modifier.padding(8.dp)
        .width(1000.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(helper.numSecondsPassed.toString())
            Row {
                Column(modifier = Modifier.width(700.dp)) {
                    Text("Tracking Shipment: " + helper.shipmentId.toString())
                }
                Column {
                    Button(removeMessage) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        var shipmentSearch by remember { mutableStateOf("") }
        val viewHelpers = remember { mutableStateListOf<TrackerViewHelper>() }
        val coroutineScope = rememberCoroutineScope()

        Column {
            Row {
                TextField(shipmentSearch, onValueChange = {shipmentSearch = it}, modifier = Modifier.width(700.dp))
                Button({
                    val viewHelper: TrackerViewHelper = TrackerViewHelper(shipmentSearch)
                    viewHelpers.add(viewHelper)
                    shipmentSearch = "";

                    coroutineScope.launch {
                        viewHelper.start()
                    }
                }, modifier = Modifier.height(57.dp)) {
                    Text("Track")
                }
            }

            Row {
                LazyColumn {
                    items(viewHelpers.reversed()) { helper ->
                        TrackerView(helper) { viewHelpers.remove(helper) }
                    }
                }
            }
        }
    }
}

fun main() = application {
    rememberCoroutineScope().launch { TrackingSimulator.runSimulation() }
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
