rem @echo off

set dd=%DATE%
set tt=%TIME%

set /a ddd=%dd:~0,2%
IF %ddd% LSS 10 (
  SET day=0%ddd%) else (
  SET day=%ddd%)
set month=%dd:~3,2%
set year=%dd:~6,4%

set /a ttt=%tt:~0,2%

IF %ttt% LSS 10 (
  SET hour=0%ttt%) else (
  SET hour=%ttt%)

SET minute=%tt:~3,2%
SET sec=%tt:~6,2%

SET date=%day%_%month%_%year%-%hour%_%minute%_%sec%

docker exec -t memorizing-core-db-1 pg_dump -U root -E UTF-8 -c memorizing-core -f backup_%date%.sql
docker cp memorizing-core-db-1:backup_%date%.sql ./memorizing-core/dbbackup/

docker exec -t memorizing-telegram-bot-db-1 pg_dump -U root -E UTF-8 -c memorizing-telegram-bot -f backup_%date%.sql
docker cp memorizing-telegram-bot-db-1:backup_%date%.sql ./memorizing-telegram-bot/dbbackup/