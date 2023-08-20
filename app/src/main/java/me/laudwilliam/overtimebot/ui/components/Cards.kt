package me.laudwilliam.overtimebot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.laudwilliam.overtimebot.datatypes.CardTheme
import me.laudwilliam.overtimebot.ui.theme.CardTypography
import me.laudwilliam.overtimebot.ui.theme.JostFontFamily
import me.laudwilliam.overtimebot.ui.theme.OvertimeBotTheme

@Preview(widthDp = 437, heightDp = 936)
@Composable
fun CardColumnPreview()
{
    OvertimeBotTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            MainActivityCardColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f)
                    .padding(20.dp)
            )
        }
    }

}

@Composable
fun MainActivityCardColumn(modifier: Modifier)
{
    Row(modifier = modifier) {
        Column (modifier = Modifier
            .fillMaxHeight()
            .weight(1f)){
            MainActivityCard(
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
            MainActivityCard(
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
            MainActivityCard(
                Modifier.fillMaxHeight(),
                "2",
                "Shifts Taken",
                CardTheme.BLUE
            )
        }
    }
}

@Composable
fun MainActivityCard(modifier: Modifier, header: String, body: String, theme: CardTheme, )
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