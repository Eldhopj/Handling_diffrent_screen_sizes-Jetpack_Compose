package com.example.handlingdiffrentscreensizes_jetpackcomposeway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.ui.theme.AppTheme
import com.example.handlingdiffrentscreensizes_jetpackcomposeway.ui.theme.HandlingDiffrentScreenSizesJetpackComposeWayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowDimension()
            HandlingDiffrentScreenSizesJetpackComposeWayTheme(windowDimension = window) {
                if (AppTheme.orientation == Orientation.Portrait) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painterResource(id = androidx.core.R.drawable.ic_call_answer),
                                contentDescription = "img1",
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(
                                            bottomEnd = AppTheme.dimens.medium,
                                            bottomStart = AppTheme.dimens.medium
                                        )
                                    )
                                    .fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                            Text(
                                "Welcome",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.large)
                        ) {
                            Text(
                                "This Application supports all screen sizes and landscape mode",
                                style = MaterialTheme.typography.titleSmall,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                "You can have the maximum flexibility regarding your UI using this approach",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                        Button(
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(AppTheme.dimens.mediumLarge),
                            shape = CircleShape
                        ) {
                            Text(
                                text = "Lets go",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(AppTheme.dimens.medium)
                            )
                        }
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painterResource(id = androidx.core.R.drawable.ic_call_answer),
                                contentDescription = "img2",
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(
                                            topEnd = AppTheme.dimens.medium,
                                            bottomEnd = AppTheme.dimens.medium
                                        )
                                    )
                                    .fillMaxHeight(),
                                contentScale = ContentScale.FillHeight
                            )
                            Text(
                                "Welcome",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(2f)
                                .padding(AppTheme.dimens.mediumLarge),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "This Application supports all screen sizes and landscape mode",
                                style = MaterialTheme.typography.titleSmall,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                "You can have the maximum flexibility regarding your UI using this approach",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center
                            )
                            Button(
                                onClick = {

                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Blue,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(AppTheme.dimens.mediumLarge),
                                shape = CircleShape
                            ) {
                                Text(
                                    text = "Lets go",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(AppTheme.dimens.medium)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
