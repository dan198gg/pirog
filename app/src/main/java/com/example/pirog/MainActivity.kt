package com.example.pirog

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pirog.ui.theme.PirogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            pirog()
        }
    }
}

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

//    @Preview(showBackground = true)
//    @Composable
//    fun GreetingPreview() {
//        PirogTheme {
//            Greeting("Android")
//        }
//    }
@Composable
fun pirog(){
    Box(modifier = Modifier.fillMaxSize()){
        kuskiPiroga()
    }
}

@Composable
fun kuskiPiroga(kuski:Int=4) {
    val listImg= arrayListOf(painterResource(id = R.drawable.pirog1),painterResource(id = R.drawable.pirog2),painterResource(id = R.drawable.pirog3),painterResource(id = R.drawable.pirog4))
    var context = LocalContext.current
    var kolvoKuskov by remember {
        mutableStateOf<Int>(1)
    }
    Button(onClick = {
        if (kolvoKuskov < kuski) kolvoKuskov += 1 else Toast.makeText(
            context,
            "А фсё", Toast.LENGTH_SHORT
        ).show()
        Log.i("R",kolvoKuskov.toString())
    }, modifier = Modifier.offset(20.dp,500.dp)) {
        Text(text = "Положить", fontSize = 25.sp)
    }
    Button(onClick = {
        if (kolvoKuskov > 0) kolvoKuskov -= 1 else Toast.makeText(
            context,
            "А фсё",
            Toast.LENGTH_SHORT
        ).show()
    }, modifier = Modifier.offset(250.dp, 500.dp)) {
        Text(text = "Съесть", fontSize = 25.sp)
    }
    var t=0
    var s=0
    Box(modifier = Modifier.padding(125.dp)){
        repeat(kolvoKuskov) { kolvoKuskov ->
            Image(
                painter = listImg[kolvoKuskov],
                contentDescription = "efgsesf",
                modifier = Modifier.offset(t.dp, s.dp)
            )
            if (kolvoKuskov == 0) {
                t += 25
                s -= 23
            }
            if (kolvoKuskov == 1) {
                t += 53
                s += 25
            }
            if (kolvoKuskov == 2) {
                t -=55
                s +=50
            }
        }
    }

}


