Hola GEmini, aqui te indicaré el plan de estrcutura que deseo crear


Este apartado es de lo más general 
Configuración del Proyecto y Reglas Generales:
- Orientación de la App: Forzar y bloquear estrictamente en modo Horizontal (Landscape). El modo Vertical (Portrait) debe estar deshabilitado.
- Reutilización de Datos: Usar los mismos personajes y datos del parcial anterior.
- Calidad Visual: El diseño debe ser muy atractivo, cuidando precisión en detalles de pantallas y fondos personalizados.

Pantalla 1: Selección de Película / Personaje
- Fondo: Debe incluir un fondo personalizado.
- Buscador: Campo de búsqueda con escritura de usuario (TextField) y un botón de búsqueda para filtrar personajes por nombre.
- Contenedor Principal: Un Grid generado mediante LazyVerticalGrid (o LazyColumn con filas distribuidas, según la tecnología) que permita Scroll vertical.
- Requisito de Scroll: Debe haber un mínimo de 3 renglones de tarjetas para validar el correcto funcionamiento del scroll.

Pantalla 2: Detalle del Personaje
- Distribución: Rediseño drástico para aprovechar el modo Landscape. Área de visualización del personaje mucho más grande y un apartado de detalle a un lado.
- Interactividad (Intents/Funciones Nuevas): Accesos directos y botones funcionales para las acciones requeridas en el boceto (Intent de llamada con número registrado, Intent de compartir e Intent de ubicación).
- Galería: Un slider de variaciones de imágenes del personaje en la parte inferior.

genera la pantalla de selección con un LazyVerticalGrid de 3 o 4 columnas. Crea una lista con 10 películas de Pixar para que se formen al menos 3 filas y se active el scroll vertical obligatoriamente. Cada tarjeta dentro del grid debe mantener la estética visual de mi boceto (estilo carta flotante con marco blanco y sombras).