package com.example.mobile_labs_20521247

import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.Dp
import com.example.mobile_labs_20521247.ui.theme.Mobile_labs_20521247Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile_labs_20521247Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun RowLayout(){
    Column(){
        Text(
            text = "Row"
        )
        Row(){
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(color = Color.Blue)
            ){}
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(color = Color.Green)
            ){}
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(color = Color.Red)
            ){}
        }
    }

}
@Composable
fun ColumnLayout(){
    Column() {
        Text("Column")
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(color = Color.Blue)
        ){}
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(color = Color.Green)
        ){}
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(color = Color.Red)
        ){}

    }
}
@Composable
fun ListLayout(){
    LazyColumn {
        val colorList: List<Color> = listOf(Color.Blue, Color.Green, Color.Red)
        // Add 5 items
        item {
            Text(text = "List")
        }
        items(colorList){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = it)
            ){}
        }

        }
    }

@Composable
fun GridLayoutView(){
    val content: List<String> = listOf(
        "He'd have you all unravel at the",
        "Heed not the rabble",
        "Sound of screams but the",
        "Who scream",
    )
    val defaultColor = Color.Magenta
    var defaultAlpha = 0.2f
    Text(text = "Grid")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(10.dp)

    ){
        items(content.size){ index->
            CustomItemBox(
                color = defaultColor.copy(defaultAlpha),
                content = content[index],
                modifier = Modifier,
                widthSize = 40.dp,
                heightSize = 200.dp)
            defaultAlpha += 0.2f
        }
    }
}

@Composable
fun CustomItemBox(
    color: Color,
    content: String,
    modifier: Modifier,
    widthSize: Dp,
    heightSize : Dp,
){
    Box(
        modifier
            .width(widthSize)
            .height(heightSize)
            .background(color = color)
            .padding(10.dp)
    ){
        Text(
            text = content
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mobile_labs_20521247Theme {
        Column(modifier = Modifier.fillMaxSize()) {
            RowLayout()
            ColumnLayout()
            ListLayout()
            GridLayoutView()
        }

    }
}