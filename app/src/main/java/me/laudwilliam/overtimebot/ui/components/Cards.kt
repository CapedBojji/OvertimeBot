package me.laudwilliam.overtimebot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.laudwilliam.overtimebot.datatypes.CardTheme
import me.laudwilliam.overtimebot.ui.theme.CardTypography

@Preview(widthDp = 437, heightDp = 936)
@Composable
fun CardColumnPreview()
{
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CardColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.8f)
        )
    }
}

@Composable
fun CardColumn(modifier: Modifier)
{
    Row(modifier = modifier) {
        Column(
            modifier = Modifier.padding(20.dp).weight(1f)

        ) {
            val shiftsAvailableModifier = Modifier.fillMaxHeight(.4f)
                .fillMaxWidth()
            val timeBlocksLeftModifier = Modifier.weight(1f)
                .fillMaxWidth()
            CustomCard(header = "7", body = "Shifts available",
                modifier = shiftsAvailableModifier, colorType = CardTheme.WHITE)
            CustomCard(header = "10", body = "Blocks available",
                modifier = timeBlocksLeftModifier, colorType = CardTheme.BLUE)
        }
        Divider(color = Color.Red,
                    modifier = Modifier
                        .fillMaxHeight()  //fill the max height
                        .width(1.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            val shiftsTakenModifier = Modifier.fillMaxHeight()
                .fillMaxWidth()
            CustomCard(
                header = "101",
                body = "Shifts selected",
                modifier = shiftsTakenModifier,
                colorType = CardTheme.BLACK
            )
        }
    }
}

data class ThemeInfo (val background : Color, val onBackground: Color)
@Composable
fun CustomCard(header: String, body: String, modifier: Modifier, colorType: CardTheme)
{
    val theme : ThemeInfo = when (colorType) {
        CardTheme.BLACK -> ThemeInfo(MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.onTertiary)
        CardTheme.BLUE -> ThemeInfo(MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimary)
        CardTheme.WHITE -> ThemeInfo(MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.onSecondary)
    }
    Card(
        modifier = modifier
            .background(theme.background, RoundedCornerShape(10.dp))
    ){
        Text(
            text = header,
            style = MaterialTheme.typography.headlineSmall,
            color = theme.onBackground
            )
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Text(text = body, style = MaterialTheme.typography.bodySmall,
                color = theme.onBackground)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = ">", style = MaterialTheme.typography.bodySmall,
                color = theme.onBackground)
        }
    }
}