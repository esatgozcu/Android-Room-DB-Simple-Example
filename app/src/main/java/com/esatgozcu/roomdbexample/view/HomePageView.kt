package com.esatgozcu.roomdbexample.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esatgozcu.roomdbexample.ui.theme.RoomDBExampleTheme
import com.esatgozcu.roomdbexample.utils.PopupResultType
import com.esatgozcu.roomdbexample.viewModel.HomePageViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageView(viewModel: HomePageViewModel = viewModel()) {

    var text by remember { mutableStateOf("") }
    var popup by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    singleLine = true,
                    onValueChange = { text = it },
                )
                Button(modifier = Modifier.width(100.dp),
                    onClick = {

                    }) {
                    Text(text = "ADD")
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Database Items", fontSize = 20.sp)
                LazyVerticalGrid(
                    cells = GridCells.Fixed(1),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top
                ) {
                    items(5) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                                .clickable {
                                    popup = true
                                },
                            shape = RoundedCornerShape(10.dp),
                            backgroundColor = Color.White,
                            elevation = 2.dp
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(20.dp)
                            ) {
                                Text(text = "Name")
                            }
                        }
                    }
                }
            }
        }

        if (popup){
            PopupView(value = text, onDismiss = {
                popup = false
                if (it.type == PopupResultType.DELETE){
                    //DELETE
                }
                else if (it.type == PopupResultType.UPDATE){
                    //UPDATE
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomDBExampleTheme {
        HomePageView()
    }
}