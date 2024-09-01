# Sistema de Estacionamento

Este sistema permite gerenciar veículos, tipos de veículos, status, modelos e fabricantes em um estacionamento. A API fornece endpoints para realizar operações CRUD.

## Índice

- [Introdução](#introdução)
- [Instalação](#instalação)
- [Uso](#uso)
- [API](#api)
  - [Veículos](#veículos)
  - [Tipos de Veículos](#tipos-de-veículos)
  - [Status](#status)
  - [Modelos](#modelos)
  - [Fabricantes](#fabricantes)


## Introdução

Este projeto é um sistema de gerenciamento de estacionamento que utiliza uma API REST para gerenciar dados de veículos, tipos, status, modelos e fabricantes.

## Instalação

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/nome-do-repositorio.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd nome-do-repositorio
    ```
3. Instale as dependências e inicie o servidor.

## Uso

Utilize ferramentas como Postman para interagir com a API. Abaixo estão exemplos de requisições.

## API

### Veículos

- **GET /veiculos**: Retorna todos os veículos.
- **GET /veiculos/{id}**: Retorna um veículo específico.
- **POST /veiculos**: Adiciona um novo veículo.
- **PUT /veiculos/{id}**: Atualiza um veículo existente.
- **DELETE /veiculos/{id}**: Remove um veículo.

### Tipos de Veículos

- **GET /tipos**: Retorna todos os tipos de veículos.
- **POST /tipos**: Adiciona um novo tipo de veículo.

### Status

- **GET /status**: Retorna todos os status.
- **POST /status**: Adiciona um novo status.

### Modelos

- **GET /modelos**: Retorna todos os modelos de veículos.
- **POST /modelos**: Adiciona um novo modelo.

### Fabricantes

- **GET /fabricantes**: Retorna todos os fabricantes.
- **POST /fabricantes**: Adiciona um novo fabricante.
