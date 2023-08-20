package me.laudwilliam.overtimebot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import me.laudwilliam.overtimebot.MainActivity
import me.laudwilliam.overtimebot.R
import me.laudwilliam.overtimebot.ui.theme.OvertimeBotTheme

@Preview(widthDp = 437, heightDp = 936, showBackground = true)
@Composable
fun MainActivityHeaderPreview()
{
    OvertimeBotTheme {
        MainActivityHeader()
    }
}

@Composable
fun MainActivityHeader()
{
    Row {
        Text(text  = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.tertiary)) {
                append("Hi,")
            }
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.tertiary)) {
                append(stringResource(id = R.string.user_name))
            }
        })
        Spacer(modifier = Modifier)
        Box(modifier = Modifier)
        {
            Image(painter = painterResource(id = R.drawable.icons8_bell), contentDescription = "Notification")
        }
    }
}