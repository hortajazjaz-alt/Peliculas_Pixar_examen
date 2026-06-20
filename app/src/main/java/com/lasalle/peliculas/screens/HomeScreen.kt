package com.lasalle.peliculas.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lasalle.peliculas.models.Movie
import com.lasalle.peliculas.R

// IA generated: Home Screen with strictly 8 Pixar movies and High-Quality image rendering to fix pixelation
@Composable
fun HomeScreen(onMovieClick: (Int) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current
    
    // IA generated: Keeping strictly the 8 established Pixar movies
    val allMovies = listOf(
        Movie(1, "Toy Story", R.drawable.stoooryyyyy_portada, tag = "New"),
        Movie(2, "Intensamente", R.drawable.intensamente_portada),
        Movie(3, "Los Increíbles", R.drawable.incre_portada),
        Movie(4, "Up", R.drawable.up_portada),
        Movie(5, "WALL-E", R.drawable.walle_portada),
        Movie(6, "Monster inc", R.drawable.inc_portada),
        Movie(7, "Cars", R.drawable.cars_portada, tag = "Bye"),
        Movie(8, "Bichos", R.drawable.bichos_portada)
    )

    val filteredMovies = allMovies.filter { 
        it.title.contains(searchQuery, ignoreCase = true) 
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // IA generated: Custom background covering the whole screen
        Image(
            painter = painterResource(id = R.drawable.fondopersonalizado),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // IA generated: Top section with Logo and Search
            HeaderSection(searchQuery) { searchQuery = it }

            Spacer(modifier = Modifier.height(20.dp))

            // IA generated: Grid with 4 columns for Landscape (2 rows for 8 items)
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 32.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(filteredMovies) { movie ->
                    MovieSolitaireStack(movie) { onMovieClick(movie.id) }
                }
            }
        }
    }
}

@Composable
fun HeaderSection(query: String, onQueryChange: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "PIXAR",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            letterSpacing = 2.sp
        )

        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = { Text("Buscador", color = Color.Gray) },
            modifier = Modifier
                .width(280.dp)
                .height(56.dp)
                .background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(17.dp)),
            shape = RoundedCornerShape(17.dp),
            trailingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Black)
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Transparent
            )
        )
    }
}

@Composable
fun MovieSolitaireStack(movie: Movie, onClick: () -> Unit) {
    val context = LocalContext.current
    // IA generated: Loading ImageBitmap with remember and FilterQuality.High to fix pixelation
    val bitmap = remember(movie.imageRes) {
        try {
            ImageBitmap.imageResource(context.resources, movie.imageRes)
        } catch (e: Exception) {
            null
        }
    }

    Box(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.TopCenter
    ) {
        // IA generated: Visual stack effect
        repeat(2) { index ->
            Box(
                modifier = Modifier
                    .offset(x = if(index == 0) (-15).dp else (-8).dp, y = if(index == 0) (-4).dp else 2.dp)
                    .width(110.dp)
                    .height(160.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray.copy(alpha = 0.5f), // Esto hace que el borde brille
                        shape = RoundedCornerShape(12.dp)
                    )
                    .shadow(4.dp, RoundedCornerShape(8.dp))
                    .background(
                        Brush.linearGradient(listOf(Color(0xFF560A23), Color(0xFF6E0A28))),
                        RoundedCornerShape(8.dp)
                    )
            )
        }

        // IA generated: Main Movie Card
        Card(
            modifier = Modifier
                .offset(x = 0.dp, y = 12.dp)
                .width(110.dp)
                .height(160.dp)
                .shadow(10.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(125.dp),
                        contentScale = ContentScale.Crop,
                        // IA generated: Setting FilterQuality.High is crucial for nitidez
                        filterQuality = FilterQuality.High
                    )
                } else {
                    Box(modifier = Modifier.fillMaxWidth().height(125.dp).background(Color.LightGray))
                }

                Box(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = movie.title,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color.Black,
                        maxLines = 2,
                        lineHeight = 13.sp
                    )
                }
            }
        }

        // IA generated: Dynamic Badges (New/Bye)
        movie.tag?.let { tag ->
            Surface(
                color = if (tag == "New") Color(0xFF43A047) else Color(0xFFE53935),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = -45.dp, y = 12.dp)
                    .shadow(8.dp)
            ) {
                Text(
                    text = tag,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }
    }
}
