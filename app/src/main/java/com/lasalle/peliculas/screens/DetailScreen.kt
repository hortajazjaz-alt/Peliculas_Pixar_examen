package com.lasalle.peliculas.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lasalle.peliculas.models.Character
import com.lasalle.peliculas.R

// IA generated: Character Detail Screen with custom background and colors updated from Cyan to White/Black
@Composable
fun DetailScreen(movieId: Int, onBack: () -> Unit) {
    val context = LocalContext.current

    // IA generated: Character list linked by movieId
    val allCharacters = listOf(
        // Toy Story (movieId = 1)
        Character(1, 1, "Woody", "Un vaquero valiente y leal.", "Liderazgo, lazo", "Miedo a ser reemplazado", R.drawable.woody_toy, "5551234567", "geo:34.1341,-118.3215", "¡Mira, soy Woody!"),
        Character(2, 1, "Tiro al blanco", "Caballo fiel y energético.", "Velocidad, obediente", "Se distrae fácilmente", R.drawable.blanco_toy, "5551266567", "geo:35.6869,-105.9378", "¡Relincho emocionado!"),
        Character(3, 1, "Jessie", "Una vaquera entusiasta.", "Yodel, agilidad", "Claustrofobia", R.drawable.jessie_toy, "5550001111", "geo:34.1481,-118.3633", "¡Yee-haw!"),
        Character(4, 1, "Hamm", "Alcancía sarcástica.", "Guardar monedas.", "Lento", R.drawable.alcancia_toy, "5559876543", "geo:34.1481,-118.3633", "¿Alguien tiene una moneda?"),

        // Intensamente (movieId = 2)
        Character(5, 2, "Alegría", "Emoción optimista de Riley.", "Felicidad, brillo", "No entiende la tristeza", R.drawable.alegria_int, "5552222222", "geo:34.0522,-118.2437", "¡Hoy va a ser un gran día!"),
        Character(6, 2, "Tristeza", "Procesa la pérdida.", "Empatía", "Baja energía", R.drawable.tristeza_int, "5553333333", "geo:34.0522,-118.2437", "Todo está mal..."),
        Character(7, 2, "Furia", "Pequeño y explosivo.", "Determinación", "Poca paciencia", R.drawable.furia_int, "5554567890", "geo:37.7749,-122.4194", "¡Eso es injusto!"),
        Character(8, 2, "Desagrado", "Elegante y segura.", "Detecta peligros sociales.", "Juzga rápidamente.", R.drawable.desagrado_int, "5556789012", "geo:34.0522,-118.2437", "¡Qué asco!"),

        // Los Increíbles (movieId = 3)
        Character(9, 3, "Mr. Increíble", "Héroe con fuerza.", "Súper fuerza", "Problemas de espalda", R.drawable.bob_incre, "5554444444", "geo:34.0522,-118.2437", "Días de gloria."),
        Character(10, 3, "Dash", "Hiperactivo y veloz.", "Súper velocidad", "Impulsivo", R.drawable.dash_incre, "5553214567", "geo:37.3382,-121.8863", "¡Soy el más rápido!"),
        Character(11, 3, "Violeta", "Reservada.", "Invisibilidad", "Insegura", R.drawable.violeta_incre, "5556547890", "geo:47.6062,-122.3321", "Tal vez..."),
        Character(12, 3, "Elastigirl", "Valiente.", "Flexibilidad", "Preocupación familiar", R.drawable.elastigirl_incre, "5559873210", "geo:34.0195,-118.4912", "La familia primero."),

        // Up (movieId = 4)
        Character(13, 4, "Carl Fredricksen", "Anciano vendedor de globos.", "Determinación", "Terquedad", R.drawable.abuelito_up, "5555555555", "geo:34.0522,-118.2437", "La aventura está allá."),
        Character(14, 4, "Russell", "Explorador de naturaleza.", "Entusiasmo", "Inexperiencia", R.drawable.russell_up, "5556666666", "geo:34.0522,-118.2437", "¡Grau!"),
        Character(15, 4, "Charles Muntz", "Villano explorador.", "Piloto", "Desconfiado", R.drawable.abuelitodos_up, "5557418529", "geo:-3.4653,-62.2159", "¡Atrapenla!"),

        // WALL-E (movieId = 5)
        Character(16, 5, "WALL-E", "Amable.", "Compactar basura", "Antiguo", R.drawable.walle_wall, "5558002001", "geo:40.7128,-74.0060", "Waaall-E..."),
        Character(17, 5, "EVE", "Eficiente.", "Vuelo", "Sigue protocolos", R.drawable.eve_wa, "5558002002", "geo:28.5729,-80.6490", "Directiva..."),
        Character(18, 5, "M-O", "Trabajador.", "Limpieza", "Obsesivo", R.drawable.minirobot_wall, "5558002003", "geo:34.0522,-118.2437", "¡Contaminación!"),

        // Monsters Inc (movieId = 6)
        Character(19, 6, "Sullivan", "Monstruo azul.", "Fuerza", "Confiado", R.drawable.sullivan_inc, "5554001001", "geo:47.6062,-122.3321", "Todo bien."),
        Character(20, 6, "Mike", "Verde.", "Humor", "Impaciente", R.drawable.mike_inc, "5554001002", "geo:41.8781,-87.6298", "¡Soy Mike!"),
        Character(21, 6, "Boo", "Niña humana.", "Curiosidad", "Pequeña", R.drawable.boo_incre, "5554001003", "geo:34.0522,-118.2437", "¡Kitty!"),
        Character(22, 6, "Roz", "Encargada.", "Memoria", "Intimidante", R.drawable.papeleo_inc, "5554001004", "geo:38.5816,-121.4944", "Te observo."),

        // Cars (movieId = 7)
        Character(23, 7, "Rayo McQueen", "Auto veloz.", "Manejo", "Impulsivo", R.drawable.macqueen_cars, "5555001001", "geo:35.4720,-97.5171", "¡Ka-chow!"),
        Character(24, 7, "Sally", "Abogada.", "Liderazgo", "Exigente", R.drawable.sally_cars, "5556001002", "geo:35.1983,-111.6513", "Disfruta."),
        Character(25, 7, "Guido", "Montacargas.", "Pit stop", "Callado", R.drawable.fix_cars, "5556001003", "geo:44.4949,11.3426", "¡Pit stop!"),

        // Bichos (movieId = 8)
        Character(26, 8, "Flik", "Hormiga creativa e inteligente.", "Inventar herramientas.", "Incomprendido", R.drawable.bicho_bicho, "5557001001", "geo:36.7783,-119.4179", "Hay una manera."),
        Character(27, 8, "Atta", "Princesa de la colonia.", "Liderazgo.", "Nerviosa", R.drawable.bichomujer_bicho, "5557001002", "geo:36.7785,-119.4180", "Por la colonia."),
        Character(28, 8, "Dot", "Hermanita de Atta.", "Optimismo.", "Frágil", R.drawable.bebbicho_bicho, "5557001003", "geo:36.7787,-119.4182", "¡Puedo!"),
        Character(29, 8, "Francis", "Mariquita artista.", "Acrobacias", "Mal humor", R.drawable.francis_bichos, "5557001004", "geo:36.7790,-119.4185", "¡Soy hombre!")
    )

    val filteredCharacters = remember(movieId) {
        allCharacters.filter { it.movieId == movieId }
    }

    // IA generated: Correctly placed logic for current character selection
    if (filteredCharacters.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Sin personajes registrados.", color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onBack) { Text("Volver") }
            }
        }
        return
    }

    var currentIndex by remember(movieId) { mutableIntStateOf(0) }
    val character = filteredCharacters[currentIndex]

    Box(modifier = Modifier.fillMaxSize()) {
        // IA generated: 1. BACKGROUND IMAGE (Positioned as the base layer)
        Image(
            painter = painterResource(id = R.drawable.fondopersonalizado),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // IA generated: 2. MAIN CONTENT (3 columns)
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            
            // TERCIO IZQUIERDO: Información del personaje
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(top = 40.dp, bottom = 45.dp, start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = character.name, color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Black)
                Spacer(modifier = Modifier.height(12.dp))

                InfoSection("Descripción", character.description)
                InfoSection("Habilidades", character.skills)
                InfoSection("Desventajas", character.weaknesses)

                Spacer(modifier = Modifier.weight(1f))

                // IA generated: Intent buttons (Updated color from Cyan to White)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ActionButton(Icons.Default.Call) {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${character.phoneNumber}"))
                        context.startActivity(intent)
                    }
                    ActionButton(Icons.Default.Share) {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, character.shareText)
                        }
                        context.startActivity(Intent.createChooser(intent, "Compartir personaje"))
                    }
                    ActionButton(Icons.Default.LocationOn) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(character.location))
                        context.startActivity(intent)
                    }
                }
            }

            // TERCIO CENTRAL: Imagen del personaje (Nítida with FilterQuality.High)
            Box(
                modifier = Modifier
                    .weight(1.2f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .size(380.dp)
                        .shadow(20.dp),
                    color = Color.White,
                    border = BorderStroke(2.dp, Color.Black)
                ) {
                    val bitmap = ImageBitmap.imageResource(context.resources, character.imageRes)
                    Image(
                        bitmap = bitmap,
                        contentDescription = character.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit,
                        filterQuality = FilterQuality.High
                    )
                }
            }

            // TERCIO DERECHO: Mazo Solitario Interactivo
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxHeight()
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "", color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                
                val others = filteredCharacters.filter { it.id != character.id }
                Box(contentAlignment = Alignment.TopCenter) {
                    others.take(4).forEachIndexed { index, other ->
                        val otherBitmap = ImageBitmap.imageResource(context.resources, other.imageRes)
                        val rotation = when(index) {
                            0 -> -4f
                            1 -> 3f
                            2 -> -2f
                            3 -> -1f
                            else -> 0f
                        }
                        Card(
                            modifier = Modifier
                                .offset(y = (index * 20).dp)
                                .width(85.dp)
                                .height(125.dp)
                                .shadow(12.dp, RoundedCornerShape(10.dp))
                                .clickable { 
                                    currentIndex = filteredCharacters.indexOf(other)
                                },
                            colors = CardDefaults.cardColors(containerColor = Color.Black),
                            border = BorderStroke(2.dp, Color.White.copy(alpha = 0.8f))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Image(
                                    bitmap = otherBitmap,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Fit,
                                    alpha = 0.4f,
                                    filterQuality = FilterQuality.High
                                )
                                Text(text = "?", color = Color.White, fontSize = 45.sp, fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }
            }
        }

        // IA generated: Navigation Back Button (Top Left)
        IconButton(onClick = onBack, modifier = Modifier.align(Alignment.TopStart).padding(8.dp)) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar", tint = Color.White)
        }

        // IA generated: Navigation Buttons (Bottom Corners - Updated color to White)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentIndex > 0) currentIndex-- },
                enabled = currentIndex > 0,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.8f), contentColor = Color.Black)
            ) { Text("ANTERIOR", fontSize = 10.sp) }
            
            Button(
                onClick = { if (currentIndex < filteredCharacters.size - 1) currentIndex++ },
                enabled = currentIndex < filteredCharacters.size - 1,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.8f), contentColor = Color.Black)
            ) { Text("SIGUIENTE", fontSize = 10.sp) }
        }
    }
}

// IA generated: Helper Composable for info quadrants (Updated color from Cyan to White)
@Composable
fun InfoSection(title: String, content: String) {
    Column {
        Text(text = "$title:", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text(text = content, color = Color.White, fontSize = 14.sp)
    }
}

// IA generated: Helper Composable for Intent buttons (Updated color from Cyan to White)
@Composable
fun ActionButton(icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    FilledIconButton(
        onClick = onClick,
        modifier = Modifier.size(48.dp),
        colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.White)
    ) {
        Icon(icon, contentDescription = null, tint = Color.Black)
    }
}
