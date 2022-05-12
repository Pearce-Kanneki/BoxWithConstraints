package com.kanneki.boxwithconstraints

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CustomCard(data: CustomData) {
    Row(modifier = Modifier.border(width = 1.dp, color = Color.LightGray)) {

        AsyncImage(
            modifier = Modifier.weight(.5f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = data.image)
                .crossfade(true)
                .build(),
            contentDescription = "Card Image",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        BoxWithConstraints(
            modifier = Modifier
                .weight(1.5f)
                .padding(12.dp)
        ) {
            AdapterContent(data = data)
        }
    }
}

@Composable
fun BoxWithConstraintsScope.AdapterContent(data: CustomData) {

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = data.title,
            style = MaterialTheme.typography.subtitle2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = data.description,
            style = MaterialTheme.typography.subtitle1,
            maxLines = if (this@AdapterContent.maxWidth > 250.dp) 10 else 2,
            overflow = TextOverflow.Ellipsis
        )
    }

}