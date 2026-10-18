package franco.dahina.cartelera

data class Pelicula(
    val id: Int,
    val titulo: String,
    val anio: Int,
    val duracionMin: Int,
    val genero: String,
    val director: String,
    val sinopsis: String,
    val imagen: Int
)


val peliculas = listOf(
    Pelicula(
        id = 1,
        titulo = "Toy Story 2",
        anio = 1999,
        duracionMin = 92,
        genero = "Animación",
        director = "John Lasseter",
        sinopsis = "Woody es secuestrado por un coleccionista y descubre que es un juguete muy valioso. Buzz y sus amigos emprenden una aventura para rescatarlo.",
        imagen = R.drawable.ts
    ),
    Pelicula(
        id = 2,
        titulo = "Megamente",
        anio = 2010,
        duracionMin = 95,
        genero = "Animación y comedia",
        director = "Tom McGrath",
        sinopsis = "Un supervillano consigue derrotar a su enemigo, pero descubre que su vida ya no tiene sentido sin un héroe al que enfrentar.",
        imagen = R.drawable.megamind
    ),
    Pelicula(
        id = 3,
        titulo = "Shrek 2",
        anio = 2004,
        duracionMin = 93,
        genero = "Animación y aventura",
        director = "Andrew Adamson, Kelly Asbury y Conrad Vernon",
        sinopsis = "Shrek y Fiona visitan a los padres de ella en Muy Muy Lejano, donde tendrán que enfrentar nuevos problemas y aventuras.",
        imagen = R.drawable.shrek
    ),
    Pelicula(
        id = 4,
        titulo = "La hermanastra fea",
        anio = 2025,
        duracionMin = 109,
        genero = "Terror y comedia negra",
        director = "Emilie Blichfeldt",
        sinopsis = "Elvira compite por conquistar a un príncipe en un reino donde la belleza se convierte en una obsesión peligrosa.",
        imagen = R.drawable.stepsis
    ),
    Pelicula(
        id = 5,
        titulo = "Ponyo",
        anio = 2008,
        duracionMin = 101,
        genero = "Animación y fantasía",
        director = "Hayao Miyazaki",
        sinopsis = "Una pequeña criatura marina desea convertirse en humana después de conocer a un niño llamado Sosuke.",
        imagen = R.drawable.ponyo
    ),
    Pelicula(
        id = 6,
        titulo = "Gnomeo y Julieta",
        anio = 2011,
        duracionMin = 84,
        genero = "Animación y romance",
        director = "Kelly Asbury",
        sinopsis = "Dos gnomos de jardín pertenecientes a familias rivales se enamoran y luchan por mantener su relación.",
        imagen = R.drawable.gaj
    )
)
