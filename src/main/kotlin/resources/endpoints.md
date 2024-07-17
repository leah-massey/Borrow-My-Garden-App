## - API Docs:
Below are example request/response scenarios for all endpoints created for this project.

### Get all todos:

```GET /gardens```

Response:

```
 {
    id: "12e3527e-1933-407e-84ef-58bb35088e3e",
    createdTimestamp: "31081988",
    title: "Garden with good soil",
    description: "Everything grows fast in this garden", 
    gardenOwderFirstName: "John",
    gardenOwnerId: "ddbe7790-40ef-41c0-80a9-f14755851301",
    gardenStatus: "AVAILABLE"
},
{
    "id": "47e4622b-845d-4f1f-9e1d-2994e5937c1c",
    "createdTimestamp": "15051992",
    "title": "Sunny Garden",
    "description": "Perfect for sunflowers",
    "gardenOwnerFirstName": "Alice",
    "gardenOwnerId": "fa3a9c6d-9d2d-4a3c-ae97-4a763d5c9b08",
    "gardenStatus": "AVAILABLE"
}

```

--------------