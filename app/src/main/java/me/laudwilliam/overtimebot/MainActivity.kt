package me.laudwilliam.overtimebot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.laudwilliam.overtimebot.datatypes.CardTheme
import me.laudwilliam.overtimebot.ui.components.MainActivityCard
import me.laudwilliam.overtimebot.ui.theme.Black_15161A
import me.laudwilliam.overtimebot.ui.theme.Blue_3128CC
import me.laudwilliam.overtimebot.ui.theme.Grey_B0B0B0
import me.laudwilliam.overtimebot.ui.theme.Grey_F8F8F8
import me.laudwilliam.overtimebot.ui.theme.OvertimeBotTheme
import me.laudwilliam.overtimebot.ui.theme.White_FFFFFF

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OvertimeBotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    HeaderRow(modifier = Modifier)
                    TitleRow(modifier = Modifier)
                    CardRow(modifier = Modifier)
                    BottomNavRow(modifier = Modifier)
                }
            }
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

@Composable
fun HeaderRow(modifier: Modifier) {
    Row (modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Grey_B0B0B0)
        Box(modifier = Modifier
            .width(30.dp)
            .aspectRatio(1f)
            .background(White_FFFFFF, RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center)
        {
            Image(painter = painterResource(id = R.drawable.icons8_bell),
                contentDescription = "Notifications", alignment = Alignment.Center, modifier = Modifier
                    .width(15.dp)
                    .aspectRatio(1f) )
        }
    }
}

@Composable
fun TitleRow(modifier: Modifier)
{
    Row (modifier = modifier, verticalAlignment = Alignment.Bottom){
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Grey_B0B0B0)) {
                append("Hi, ")
            }
            withStyle(style = SpanStyle(color = Black_15161A)) {
                append(stringResource(id = R.string.user_name))
            }
        }, style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun CardRow(modifier: Modifier)
{
    Row(modifier = modifier) {
        Column (modifier = Modifier
            .fillMaxHeight()
            .weight(1f)){
            CardComponent(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f),
                "10",
                "Shifts Available",
                CardTheme.BLACK
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            CardComponent(
                Modifier.weight(1f),
                "101",
                "Time Blocks",
                CardTheme.WHITE
            )
        }
        Spacer(modifier = Modifier
            .fillMaxHeight()
            .width(10.dp))
        Spacer(modifier = Modifier
            .fillMaxHeight()
            .width(10.dp))
        Column (modifier = Modifier
            .fillMaxHeight()
            .weight(1f)){
            CardComponent(
                Modifier.fillMaxHeight(),
                "2",
                "Shifts Taken",
                CardTheme.BLUE
            )
        }
    }
}


@Composable
fun BottomNavRow(modifier: Modifier)
{
    Row (modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly){
        Box(modifier = Modifier)
        {
            Image(painter = painterResource(id = R.drawable.noun_column), contentDescription = "View Timeline")
        }
        Box(modifier = Modifier)
        {
            Image(painter = painterResource(id = R.drawable.noun_plus), contentDescription = "Add time block")
        }
        Box(modifier = Modifier)
        {
            Image(painter = painterResource(id = R.drawable.icons8_settings), contentDescription = "Settings")
        }
    }
}

@Composable
fun CardComponent(modifier: Modifier, header: String, body: String, theme: CardTheme, )
{
    Card(modifier = modifier) {
        Column (modifier = Modifier.padding(10.dp)) {
            Text(text = header, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .weight(1f))
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.40f),
                verticalAlignment = Alignment.Bottom) {
                Text(text = body, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight())
                Text(text = ">", style = MaterialTheme.typography.bodySmall)
            }
        }

    }
}
@Preview(showBackground = true, widthDp = 437, heightDp = 936)
@Composable
fun GreetingPreview() {
    OvertimeBotTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 30.dp)
                .background(color = Grey_F8F8F8),
        ) {
            HeaderRow(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            TitleRow(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            CardRow(modifier = Modifier.weight(.7f))
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            BottomNavRow(modifier = Modifier.fillMaxWidth())
        }
    }
}