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
    https://github.com/mateus00000/Estacionamento.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd Estacionamento
    ```
3. Instale as dependências e inicie o servidor.

## Uso

Utilize ferramentas como Postman para interagir com a API. Abaixo estão exemplos de requisições.

## API

### Veículos

- **POST /veiculos**: Adiciona um novo veículo.
- **GET /veiculos**: Retorna todos os veículos.
- **GET /veiculos/{id}**: Retorna um veículo específico.
- **PUT /veiculos/{id}**: Atualiza um veículo existente.
- **DELETE /veiculos/{id}**: Remove um veículo.

### Tipos de Veículos

- **POST /tipos**: Adiciona um novo tipo de veículo.
- **GET /tipos**: Retorna todos os tipos de veículos.
- **GET /tipos/{id}**: Retorna um tipo específico.
- **PUT /tipos/{id}**: Atualiza um tipo existente.
- **DELETE /tipos/{id}**: Remove um tipo.

### Status

- **POST /status**: Adiciona um novo status.
- **GET /status**: Retorna todos os status.
- **GET /status/{id}**: Retorna um status específico.
- **PUT /status/{id}**: Atualiza um status existente.
- **DELETE /status/{id}**: Remove um status.

### Modelos

- **POST /modelos**: Adiciona um novo modelo.
- **GET /modelos**: Retorna todos os modelos de veículos.
- **GET /modelos/{id}**: Retorna um modelo específico.
- **PUT /modelos/{id}**: Atualiza um modelo existente.
- **DELETE /modelos/{id}**: Remove um modelo.
  
### Fabricantes

- **POST /fabricantes**: Adiciona um novo fabricante.
- **GET /fabricantes**: Retorna todos os fabricantes.
- **GET /fabricantes/{id}**: Retorna um fabricante específico.
- **PUT /fabricantes/{id}**: Atualiza um fabricante existente.
- **DELETE /fabricantes/{id}**: Remove um fabricante.
