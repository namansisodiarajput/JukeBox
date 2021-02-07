# JukeBox Application for Music Album & Musician Management

## Running Instruction
1. Import Project On Eclipse
2. Create MySql Datababse juke_box
3. Set UserName & Password of Database in Application.properties file
4. Run Project


## Postman Response Api

## Add Or Update Musician Put Api - http://localhost:8080/jukebox/musician
![image](https://user-images.githubusercontent.com/19189211/107152104-0ed35180-698c-11eb-90d3-b548061bdc1d.png)

## Add Or Update Music Album Put Api - http://localhost:8080/jukebox/music-album
![image](https://user-images.githubusercontent.com/19189211/107152267-ec8e0380-698c-11eb-9d3e-abd2c8ddf10a.png)

## Get All Musical Album Sorted By Release Date Get Api - http://localhost:8080/jukebox/music-album
![image](https://user-images.githubusercontent.com/19189211/107152319-48f12300-698d-11eb-8fab-1929dbca2747.png)
### response json - 
```json
[
    {
        "musicAlbum": {
            "id": 9,
            "name": "siddu",
            "dateOfRelease": "2021-01-01T13:53:26.342+00:00",
            "genre": "COUNTRY_MUSIC",
            "price": 15000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 6,
            "name": "kishore",
            "dateOfRelease": "2021-01-08T13:53:26.342+00:00",
            "genre": "ELECTRONIC",
            "price": 500.0,
            "description": "king kong"
        },
        "musiciansList": []
    },
    {
        "musicAlbum": {
            "id": 28,
            "name": "harendra",
            "dateOfRelease": "2021-02-07T13:53:26.342+00:00",
            "genre": "ELECTRONIC",
            "price": 30000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 34,
            "name": "AAJA RE",
            "dateOfRelease": "2021-02-07T13:53:26.342+00:00",
            "genre": "ROCK_MUSIC",
            "price": 30000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 7,
            "name": "lata",
            "dateOfRelease": "2021-03-06T13:53:26.342+00:00",
            "genre": "FUNK",
            "price": 2000.0,
            "description": "marvelous movie"
        },
        "musiciansList": []
    },
    {
        "musicAlbum": {
            "id": 8,
            "name": "honey singh",
            "dateOfRelease": "2021-05-04T13:53:26.342+00:00",
            "genre": "LATIN_MUSIC",
            "price": 1500.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 5,
            "name": "arjit",
            "dateOfRelease": "2021-06-07T13:53:26.342+00:00",
            "genre": "ROCK_MUSIC",
            "price": 1000.0,
            "description": "nice song"
        },
        "musiciansList": []
    },
    {
        "musicAlbum": {
            "id": 14,
            "name": "naman",
            "dateOfRelease": "2021-12-07T13:53:26.342+00:00",
            "genre": "LATIN_MUSIC",
            "price": 10000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    }
]
```

## Get All Musical Album Filter By Musician Sorted By Price Get Api - http://localhost:8080/jukebox/music-album/{musician-id}/musician
![image](https://user-images.githubusercontent.com/19189211/107152426-c4eb6b00-698d-11eb-874c-3adad5a7801d.png)
### Response Json
```json
[
    {
        "musicAlbum": {
            "id": 8,
            "name": "honey singh",
            "dateOfRelease": "2021-05-04T13:53:26.342+00:00",
            "genre": "LATIN_MUSIC",
            "price": 1500.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 14,
            "name": "naman",
            "dateOfRelease": "2021-12-07T13:53:26.342+00:00",
            "genre": "LATIN_MUSIC",
            "price": 10000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 9,
            "name": "siddu",
            "dateOfRelease": "2021-01-01T13:53:26.342+00:00",
            "genre": "COUNTRY_MUSIC",
            "price": 15000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 28,
            "name": "harendra",
            "dateOfRelease": "2021-02-07T13:53:26.342+00:00",
            "genre": "ELECTRONIC",
            "price": 30000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    },
    {
        "musicAlbum": {
            "id": 34,
            "name": "AAJA RE",
            "dateOfRelease": "2021-02-07T13:53:26.342+00:00",
            "genre": "ROCK_MUSIC",
            "price": 30000.0,
            "description": "marvelous movie"
        },
        "musiciansList": [
            {
                "id": 2,
                "name": "harendra",
                "musicianType": "PLAYER"
            },
            {
                "id": 4,
                "name": "naman sisodia",
                "musicianType": "CONDUCTORS"
            },
            {
                "id": 3,
                "name": "nikhil",
                "musicianType": "COMPOSER"
            },
            {
                "id": 1,
                "name": "paul",
                "musicianType": "INSTRUMENTALIST"
            }
        ]
    }
]
```

## Get All Musicians Filter By Music Album Sorted By Name Get Api - http://localhost:8080/jukebox/musician/{album-id}/music-album
![image](https://user-images.githubusercontent.com/19189211/107152495-46db9400-698e-11eb-93cb-2db971d27cfe.png)
### Response -
```json
[
    {
        "id": 2,
        "name": "harendra",
        "musicianType": "PLAYER"
    },
    {
        "id": 4,
        "name": "naman sisodia",
        "musicianType": "CONDUCTORS"
    },
    {
        "id": 3,
        "name": "nikhil",
        "musicianType": "COMPOSER"
    },
    {
        "id": 1,
        "name": "paul",
        "musicianType": "INSTRUMENTALIST"
    }
]
```


## Naman Sisodia - Software Craftsman
### EmailId - namansisodia619@gmail.com

