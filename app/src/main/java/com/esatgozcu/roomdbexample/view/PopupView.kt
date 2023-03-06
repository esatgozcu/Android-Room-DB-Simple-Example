package com.esatgozcu.roomdbexample.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.esatgozcu.roomdbexample.database.Car
import com.esatgozcu.roomdbexample.ui.theme.RoomDBExampleTheme
import com.esatgozcu.roomdbexample.utils.PopupResult
import com.esatgozcu.roomdbexample.utils.PopupResultType

@Composable
fun PopupView(car: Car, onDismiss: (PopupResult) -> Unit) {

    var text by remember { mutableStateOf(car.carName) }

    Dialog(
        onDismissRequest = {
            onDismiss(PopupResult(PopupResultType.CLOSE,null))
        },properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Box(
            contentAlignment= Alignment.Center,
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    singleLine = true,
                    onValueChange = { text = it },
                )
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(modifier = Modifier.width(100.dp),
                        onClick = {
                            onDismiss(
                                PopupResult(
                                    PopupResultType.UPDATE,
                                    Car(car.id,text)
                                )
                            )
                        }) {
                        Text(text = "UPDATE")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(modifier = Modifier.width(100.dp),
                        onClick = {
                            onDismiss(
                                PopupResult(
                                    PopupResultType.DELETE,
                                    car
                                )
                            )
                        }) {
                        Text(text = "DELETE")
                    }
                }
            }
        }
    }
}