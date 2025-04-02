# Desafio de 7 Dias Consumindo a PokéAPI em Java

## Visão Geral
Este repositório contém um desafio de 7 dias explorando a **PokéAPI** utilizando **Java**. Durante esse desafio, diferentes funcionalidades foram implementadas para consumir, processar e exibir dados de Pokémon de forma estruturada.

## Tecnologias Utilizadas
- **Java** (versão 8+)
- **Gson** (para manipulação de JSON)
- **PokéAPI** (https://pokeapi.co/)
- **HTML + Bootstrap** (para exibição dos dados)

---

## Estrutura do Desafio

### **Dia 1 - Consumindo a API**
Criamos a classe `PokemonDia1_ConsumindoApi`, que faz uma requisição HTTP para a PokéAPI, obtendo os primeiros 700 Pokémon e salvando os detalhes em uma lista de objetos `Pokemon`. Os dados são renderizados em um arquivo HTML (pokedex.html) com design responsivo.

### **Dia 2 - Extraindo Informações**
A classe `PokemonDia2_ExtraindoInformacoes` reutiliza o código do primeiro dia para processar e estruturar os dados recebidos da API.

### **Dia 3 - Criando a Classe `Pokemon`**
Para organizar melhor os dados, foi criada a classe `Pokemon`, contendo os atributos:
- `id` (identificação do Pokémon)
- `name` (nome do Pokémon)
- `type` (tipo do Pokémon)
- `sprite` (imagem do Pokémon)

### **Dia 4 - Gerando HTML Dinâmico**
A classe `PokemonDia4_GerandoHTML` gera um arquivo HTML responsivo, permitindo visualizar os Pokémon listados com um campo de pesquisa dinâmico.

### **Dia 5 - Encapsulando Código em Classes**
Refatoramos o código para melhorar a organização, separando a lógica de busca em `PokemonDia5_Servico`, tornando o código mais modular e reutilizável.

### **Dia 6 - Tornando o Código Genérico com Interfaces**
Foi implementada a interface `PokemonInterface`, permitindo que diferentes classes possam buscar Pokémon de formas distintas, garantindo maior flexibilidade e expansibilidade no projeto.

### **Dia 7 - Ordenando os Pokémon**
Implementamos a ordenação dos Pokémon pelo ID antes de gerar o HTML. Agora, os Pokémon são apresentados de forma organizada na Pokédex.

---

## Como Executar o Projeto

1. **Clone o repositório**
   ```sh
   git clone https://github.com/Contagiovaneines/desafio-pokeapi-java.git
   ```
2. **Acesse a pasta do projeto**
   ```sh
   cd desafio-pokeapi-java
   ```
3. **Compile e execute a aplicação**
   ```sh
   javac -cp gson-2.8.9.jar com/desafiosJava/*.java
   java -cp .:gson-2.8.9.jar com.desafiosJava.PokemonDia1_ConsumindoApi
   ```
4. **Abra o arquivo `pokedex.html`** no navegador para visualizar os resultados.

---

## Melhorias Futuras
- Adicionar paginação para exibir todos os Pokémon de forma mais organizada.
- Implementar buscas mais detalhadas por atributos como tipo e habilidades.
- Criar uma versão utilizando uma biblioteca como Spring Boot para facilitar a estrutura da aplicação.

---

🚀 **Desafio concluído!**

