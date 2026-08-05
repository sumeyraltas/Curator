package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.data.model.ArtMovement
import com.example.data.model.Artwork
import com.example.data.model.Museum
import com.example.ui.components.ArtworkCard
import com.example.ui.components.ArtworkCardShimmer
import com.example.ui.viewmodel.CuratorViewModel
import com.example.ui.viewmodel.UiState

@Composable
fun DiscoverScreen(
    viewModel: CuratorViewModel,
    onArtworkClick: (Artwork) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val masterpiece by viewModel.masterpiece.collectAsState()
    val artworksState by viewModel.artworksState.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("discover_screen"),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        // Minimal Top Bar Header
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Curator",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.testTag("app_brand_title")
                )
                IconButton(
                    onClick = { /* User Account Profile */ },
                    modifier = Modifier.testTag("account_button")
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = "Account Profile",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }

        // Masterpiece of the Day Section
        if (masterpiece != null) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .testTag("masterpiece_section")
                ) {
                    Text(
                        text = "MASTERPIECE OF THE DAY",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                elevation = 6.dp,
                                shape = RoundedCornerShape(12.dp),
                                spotColor = Color(0x14561922)
                            )
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.outlineVariant,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { onArtworkClick(masterpiece!!) }
                            .testTag("masterpiece_card"),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(4f / 3f)
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(masterpiece!!.imageUrl)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = masterpiece!!.title,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }

                            Column(modifier = Modifier.padding(20.dp)) {
                                Text(
                                    text = masterpiece!!.title,
                                    style = MaterialTheme.typography.headlineLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "${masterpiece!!.artistName}, ${masterpiece!!.creationYear}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                                Spacer(modifier = Modifier.height(16.dp))

                                Button(
                                    onClick = { onArtworkClick(masterpiece!!) },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp)
                                        .testTag("view_analysis_button"),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.primary,
                                        contentColor = MaterialTheme.colorScheme.onPrimary
                                    ),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Outlined.AutoAwesome,
                                            contentDescription = null,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "View Analysis",
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Section Divider
        item {
            Divider(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 36.dp),
                color = MaterialTheme.colorScheme.outlineVariant,
                thickness = 1.dp
            )
        }

        // Art Movements Section
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Art Movements",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewModel.artMovements) { movement ->
                        ArtMovementCard(
                            movement = movement,
                            onMovementClick = {
                                viewModel.onFilterSelected(movement.name)
                                onSearchClick()
                            }
                        )
                    }
                }
            }
        }

        // Section Divider
        item {
            Divider(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp),
                color = MaterialTheme.colorScheme.outlineVariant,
                thickness = 1.dp
            )
        }

        // Explore by Museum Section
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Explore by Museum",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(viewModel.museums) { museum ->
                        MuseumCircleCard(
                            museum = museum,
                            onMuseumClick = {
                                viewModel.onSearchQueryChanged(museum.name)
                                onSearchClick()
                            }
                        )
                    }
                }
            }
        }

        // Curated Works Stream
        item {
            Text(
                text = "Curated Gallery Stream",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 36.dp, bottom = 16.dp)
            )
        }

        when (val state = artworksState) {
            is UiState.Loading -> {
                items(2) {
                    ArtworkCardShimmer(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp))
                }
            }
            is UiState.Error -> {
                item {
                    Text(
                        text = state.message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }
            is UiState.Success -> {
                items(state.data) { artwork ->
                    ArtworkCard(
                        artwork = artwork,
                        onArtworkClick = onArtworkClick,
                        onFavoriteClick = { viewModel.toggleFavorite(it) },
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtMovementCard(
    movement: ArtMovement,
    onMovementClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(260.dp)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp))
            .clickable { onMovementClick() }
            .testTag("movement_card_${movement.id}"),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movement.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = movement.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = movement.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movement.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun MuseumCircleCard(
    museum: Museum,
    onMuseumClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(140.dp)
            .clickable { onMuseumClick() }
            .testTag("museum_card_${museum.id}")
    ) {
        Surface(
            modifier = Modifier
                .size(100.dp)
                .shadow(4.dp, CircleShape, spotColor = Color(0x14561922))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surface
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(museum.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = museum.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = museum.name,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${museum.city}, ${museum.country}",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
