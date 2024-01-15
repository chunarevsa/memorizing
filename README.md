# Memorizing
This service helps you to remember anything!
You can:

- Create sets of cards by topics. Modify and delete them.
- Add new cards in the set. Modify and delete them.
- Let's start with modes: "Testing", "Self-check" and "Memorizing".

You can try it in telegram [@memorizing_telegram_bot](https://t.me/memorizing_telegram_bot)
(This service usually works from 11:00 to 21:00. [Just ask me.](https://t.me/chunarevsa) )

This service consists of several microservices:

Services:
- [memorizing-core](https://github.com/chunarevsa/memorizing-core) - main service for working with cards. 
- [memorizing-telegram-bot](https://github.com/chunarevsa/memorizing-telegram-bot) - bot that allow to use core API

Environment:
- [config-server](https://github.com/chunarevsa/config-server) - cloud config
- [eureka-server](https://github.com/chunarevsa/eureka-server) - discovery server
- [api-gateway](https://github.com/chunarevsa/api-gateway) - getaway



## Launch by Docker ##

<h4> Downloading with submodules </h4>

```bash
git clone --recurse-submodules https://github.com/chunarevsa/memorizing.git
cd memorizing

```
<h4> Preparing </h4>

You need to create new telegram bot by using [@BotFather](https://t.me/BotFather)
After that, you should add telegram bot token and name to .env file.

If you have a problem with localhost You should add your local ip to LOCAL_HOST environment.
For example: LOCALHOST=192.168.1.76

<h4> Running </h4>

```bash
docker-compose --file docker-compose.yml --file docker-compose.dev.yml up -d

```

This command runs docker containers with Debug mode. You can connect to debug mode by using ports:
- for core service - 8000
- for telegram bot service - 7000