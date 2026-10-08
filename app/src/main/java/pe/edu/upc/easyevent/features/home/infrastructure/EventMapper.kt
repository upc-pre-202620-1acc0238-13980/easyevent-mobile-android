package pe.edu.upc.easyevent.features.home.infrastructure

import pe.edu.upc.easyevent.features.home.domain.Event


fun EventDto.toDomain(): Event {
    return Event(
        id = id,
        title = title,
        poster = poster,
        location = location,
        date = date,
        type = type,
        category = category,
        website = website,
        description = description,
        rating = rating,
        isFavorite = false ,
    )
}