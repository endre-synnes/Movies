# Simple REST Api for Movies

This is a simple REST api for creating movies and getting them, also based on age limit.


## sample requests

#### Create movie (POST)
```
    localhost:8080/movies
```
body
```
    {
        "title" : "Inception",
        "ageLimit" : "13"
    }
```

#### Get Movies (GET)
```
    localhost:8080/movies
```

Request with query parameter:
```
    localhost:8080/movies?age=13
```
