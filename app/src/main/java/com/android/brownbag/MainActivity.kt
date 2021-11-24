package com.android.brownbag

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.brownbag.ui.theme.BrownbagTheme
import androidx.compose.ui.platform.LocalContext
import com.android.feature1.Feature1Activity
import com.android.feature2.Feature2Activity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrownbagTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val context = LocalContext.current
    Column {
        SimpleButtonComponent(text = "Feature1", onClick = {
            Intent(context, Feature1Activity::class.java).apply {
                context.startActivity(this)
            }
        })
        Divider(color = Color.Gray)
        SimpleButtonComponent("Feature2", onClick = {
            Intent(context, Feature2Activity::class.java).apply {
                context.startActivity(this)
            }
        })
        Divider(color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BrownbagTheme {
        Main()
    }
}

/*@Composable
fun SimpleButtonComponent(text: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Button", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(text)
    }
}*/

@Composable
fun SimpleButtonComponent(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(text)
    }
}