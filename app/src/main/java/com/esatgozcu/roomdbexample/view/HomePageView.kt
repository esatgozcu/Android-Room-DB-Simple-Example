package com.esatgozcu.roomdbexample.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esatgozcu.roomdbexample.database.Car
import com.esatgozcu.roomdbexample.utils.PopupResultType
import com.esatgozcu.roomdbexample.viewModel.HomePageViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageView(viewModel: HomePageViewModel) {

    var text by remember { mutableStateOf("") }
    var popup by remember { mutableStateOf(false) }
    val carList = viewModel.carList.observeAsState().value
    var selectedCar by remember {mutableStateOf(Car(0,""))}

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
                        viewModel.addCar(Car(carName = text))
                        text = ""
                    }) {
                    Text(text = "ADD")
                }
            }
            Text(text = "Database Items", fontSize = 20.sp)
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(1),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top
                ) {
                    items(carList?.size ?: 0) { i ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                                .clickable {
                                    selectedCar = carList?.get(i)!!
                                    popup = true
                                    //CHECK LOG -- TAG: CLICKED_ITEM
                                    viewModel.findCarById(carList[i].id)
                                },
                            shape = RoundedCornerShape(10.dp),
                            backgroundColor = Color.White,
                            elevation = 2.dp
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(20.dp)
                            ) {
                                Text(text = carList?.get(i)?.carName ?: "Null")
                            }
                        }
                    }
                }
            }
        }
        if (popup){
            PopupView(car = selectedCar) {
                popup = false
                if (it.type == PopupResultType.DELETE) {
                    viewModel.deleteCar(selectedCar)
                } else if (it.type == PopupResultType.UPDATE) {
                    viewModel.updateCar(it.car!!)
                }
            }
        }
    }
}