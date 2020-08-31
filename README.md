## Speaker Command API

This project is build using spring boot. 
### Build
mvn clean install
 
### Run speaker command API
#### Using IDE
Go to SpeakerCommandApplication class in src folder and run the main method.

#### Using Maven
mvn spring-boot:run

#### Using Docker 
docker-compose up --build

### Testing speaker command API
#### Sample curl command to run on the terminal
curl -X POST \
  http://localhost:8080/top-commands \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
  "alabama": [
    {
      "speaker ": "Fred Zhang ",
      "command": "CNN"
    },
    {
      "speaker ": "Fred Zhang ",
      "command": "NBC"
    },
    {
      "speaker ": "Fred Zhang ",
      "command": "CNN"
    }
  ],
  "florida": [
    {
      "speaker ": "Thomas Brown",
      "command": "Show me movies "
    },
    {
      "speaker ": " Alisha Brown",
      "command": "Stranger Things"
    },
    {
      "speaker ": "Marcus Brown",
      "command": "GAme oF Thrones"
    },
    {
      "speaker ": "Missy Brown",
      "command": "TurN off the TV"
    },
    {
      "speaker ": "Missy Brown",
      "command": "Turn off the TV"
    }
  ],
  "maryland": [
    {
      "speaker ": "Thomas Black ",
      "command": "Show me comedies "
    },
    {
      "speaker ": " Alisha Black ",
      "command": "Game of Thrones"
    },
    {
      "speaker ": "Marcus Black ",
      "command": "Game o f Thrones "
    },
    {
      "speaker ": "Missy Black ",
      "command": "Game of Thrones"
    },
    {
      "speaker ": "Missy Black ",
      "command": "Turn off the TV"
    }
  ]
}'

#### Sample out put
{"alabama":{"mostFrequentCommand":"CNN","startProcessTime":1598887868512,"stopProcessTime":1598887868512},"florida":{"mostFrequentCommand":"Turn off the TV","startProcessTime":1598887868512,"stopProcessTime":1598887868512},"maryland":{"mostFrequentCommand":"Game of Thrones","startProcessTime":1598887868512,"stopProcessTime":1598887868512},"topCommandsNationally":["GAme oF Thrones","TurN off the TV","CNN"]}

