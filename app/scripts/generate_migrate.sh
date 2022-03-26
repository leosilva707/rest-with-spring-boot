#!/usr/bin/env bash
echo "Digite o nome da sua migration."
echo "Exemplo: CREATE_TABLE_USER"

read name

fullname=V$(date +%s)__$name #junta nome com timestamp
fullname=${fullname^^} #converte letras para maiusculo

echo "" >> ../src/main/resources/db/migration/$fullname.sql

echo o arquivo $fullname foi criado no diretorio /src/main/resources/db/migration