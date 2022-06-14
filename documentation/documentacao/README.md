# MyGift, Relatório Final

**Guilherme Rodrigues Viana Saraiva, guilhermesaraiva1.gs@gmail.com**

**Marcos Ani Cury Vinagre Silva, curymarcos@live.com**

**Letícia Americano Lucas, leticia.americano.lucas@gmail.com**

**Samuel Soares Macedo Leão e Silva, samuca.smals02@gmail.com**

---

_Curso de Ciência da Computação, Unidade Coração Eucarístico_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**Resumo**. O projeto consiste em um portal aonde o usuário poderá acessar, e preenchendo um formulário sobre uma pessoa pra quem você deseja comprar presente uma IA irá escolher com base no perfil o melhor presente possível, além disso o site terá um sistema de chatbot para poder poder tirar dúvidas do cliente, além de catálogos com diversos produtos._

---



**1. Introdução**

Hodiernamente, tem-se o costume de presentear alguém em datas comemorativas, como o natal, aniversário, dia das mães, dos pais e das crianças, ou em momentos de comemoração. No Brasil, esse costume é muito valorizado e presente em diversas comunidades e famílias, assim, há o hábito de comprar presentes para seus parceiros, parentes, familiares e amigos. 
Dessa maneira, é de conhecimento geral que fortemente vigente na sociedade brasileira, a falta de uma lembrança quando algo é comemorado é até visto com maus olhos, dessa forma é de vontade da maioria agradar o presenteado. Porém, como acontece com qualquer indivíduo, é difícil agradar o gosto ou saber o que comprar, assim tentamos prover uma solução para tal problema.


    1.1 Contextualização
    
Quem nunca passou pelo desafio de presentear alguém, ou teve que disfarçar o constrangimento ao ganhar algo do qual não gostou muito? Mesmo em conhecendo a pessoa a muito tempo, é muito comum ter dificuldades para encontrar algo que agrade e surpreenda.

    1.2 Problema
    
Não é incomum encontrar algumas pessoas que têm uma extrema dificuldade de dar presentes em épocas de festividades. 
 
    1.3 Objetivo geral

O nosso objetivo geral é criar um portal com uma API ao qual vai ajudar as pessoas a comprarem presentes ideal para presentear alguém. Assim, coletando informações dos presenteados pelo usuário e do próprio, poderemos aumentar a resposta da API para ser mais especifica e certa. 

    1.3.1 Objetivos específicos

•	Um portal que ajuda o usuário na escolha dos presentes;\
•	Utilizar um chatbot para ajudar o usuário;\
•	Uma IA que consiga acertar com uma certa precisão com base no perfil de uma pessoa;

    1.4 Justificativas

Os membros do grupo no momento em que se reuniram para discutir sobre o tema, perceberam em seus ciclos de amizade e em seus ambientes familiares, que uma vasta quantidade de pessoas perde um longo tempo pensando o que dar para quem se deseja presentear em alguma ocasião.
Posteriormente, foi executada uma pesquisa de mercado para coletar informações com o propósito de identificar oportunidades e problemas inerentes à área de atuação do grupo e dos seus serviços.

    1.4.1 Questionário Realizado
    
As seguintes perguntas foram elaboradas com o objetivo de adquirir um maior embasamento sobre o contexto do projeto. Além disso, com a análise das perguntas foi possível comprovar a necessidade da elaboração do produto no mercado atual.
Por fim, as entrevistas foram realizadas diretamente com os amigos e familiares da equipe (cerca de 34 pessoas) com a finalidade de se obter as informações com a maior veracidade possível, sendo eles possíveis usuários da aplicação em estado de aperfeiçoamento.
As perguntas foram efetuadas nesta ordem, utilizando como plataforma o Google Forms.

| No.           | Pergunta                       |
|:------------- |:-------------------------------|
|01|Seu nome|
|02|Gênero|
|03|Idade|
|04|Ocupação|
|05|Média de salário|
|06|Quais aplicativos que você geralmente usa?|
|07|Quais são seus hobbies?|
|08|Você costuma fazer compras online?|
|09|Qual sua maior frustração ao fazer uma compra online?|
|10|Quando você faz uma compra online qual sua principal preocupação?|
|11|Você costuma presentear outras pessoas em datas comemorativas?|
|12|Você tem dificuldade em presentear outras pessoas?|
|13|Quais tipos de pessoas você tem mais dificuldade de presentear?|
|14|Quanto você estaria disposto a gastar em um presente?|
|15|Você usaria um site que escolhe o melhor presente para presentear alguém?|

    1.5 Público alvo

Embora todas as pessoas que buscam comprar um presente sejam adequadas para a aplicação, o nosso público alvo escolhido foi mulheres com em média 20 há 45 anos pois elas têm o costuma maior de comprar presentes.

**2. Especificação do projeto**

A definição exata do problema e os pontos mais relevantes a serem tratados neste projeto foi consolidada com a participação dos usuários em uma pesquisa sobre pessoas que necessitavam de ajuda para comprar presentes. Os detalhes levantados nesse processo foram consolidados na forma de personas e histórias de usuários.

* **Personas**

As personas levantadas durante o processo de entendimento do problema são apresentadas nas Figuras que se seguem.

* **Histórias de usuários**

A partir da compreensão do dia a dia das personas identificadas para o projeto, foram registradas as seguintes histórias de usuários.


| Eu como …  [PERSONA]    | Descrição                       | … quero/desejo … [O QUE] |
|:------------- |:-------------------------------|:-------------------------------|
|Mariana Scaldeferri|Marcas renomadas ou recomendadas por vários usuários em sites confiáveis |Evitar que os produtos sejam entregues com defeitos|
|Olga Camargos|Sites bem avaliados em entregas|Que o produto seja entregue um produto conforme descrito no site|
|Felipe Cassimiro|Comprar em sites com transportadoras confiáveis|Evitar que os produtos sejam entregues com deformidades ou quebrados|
|Mariana Scaldeferri|Sites com classificações de entregas de produtos elevadas|Que seja garantido a entrega do produto|
|Olga Camargos|Comprar em sites com transportadoras seguras|Que os produtos sejam entregues com segurança|
|Felipe Cassimiro|Sites bem avaliados em entregas|Evitar que os produtos não sejam entregues|
|Mariana Scaldeferri|Dicas sobre o que comprar|Comprar presentes certos para amigos|
|Olga Camargos|Site que ajude a comprar presentes ideais|Comprar presentes que agradem a família|
|Felipe Cassimiro|Site que sugira um presente de acordo com características do individuo|Conseguir escolher rápido presentes para amigos e parceiro|


**3. Projeto da Solução**

    3.1 Requisitos funcionais
	
A tabela a seguir apresenta os requisitos do projeto, identificando a prioridade em que os mesmos devem ser entregues.

| No.           | Descrição                       | Prioridade |
|:------------- |:-------------------------------|:----------|
| RF-01         | O site deve apresentar na página principal um menu com opções de ações para o usuário e outras opções nas suas atividades | Alta      |
| RF-02    | O site deve permitir ao usuário realizar um cadastro | Média     |
| RF-03 |  O Site deve apresentar o uso de um API com AI para que escolha opções de presentes para o usuário | Alta  | 
|RF-04|O site deve apresentar o chatbot para auxiliar no atendimento ao usuário, respondendo questionamentos e duvidas|Média|
|RF-05|O site deve apresentar o SAC (Serviço de Atendimento ao Consumidor) para auxiliar no atendimento ao usuário|Média|
|RF-06|O site deve permitir visualizar as informações de contatos do mantenedor do site.|Média|
|RF-07|O site deve permitir ao usuário participar de comentários sobre produtos e auxiliar outras pessoas|Baixa|
|RF-08|O site deve permitir visualizar as informações sobre os seus mantedores|Baixa|
|RF-09|O site deve permitir login de administrador |Média|
|RF-10|O site deve apresentar e permitir o perfil do próprio usuário|Média|

    3.2 Tecnologias

Nesta seção são apresentados os detalhes técnicos da solução criada pela equipe, tratando da Arquitetura da Solução, as estruturas de dados e as telas já implementadas.
A solução implementada conta com os seguintes módulos:
    
 * **Front-end** - Parte responsável pelo designer da aplicação. Conjunto de arquivos HTML, CSS, JavaScript e imagens que implementam as funcionalidades do sistema.
 * **Back-and** – Parte do sistema programado em java contendo algumas das funcionalidades.
 * **Banco de Dados** – Parte do sistema que armazena todos os dados gerados e utilizados pelo Porta.
 * **Sistemas inteligentes** - Parte do sistema responsável por solucionar e auxiliar problemas que exigem inteligência para serem resolvidos, apresentado no portal como chatbot e API.

![Módulos solução implementada](https://github.com/icei-pucminas/Magenta-Team/blob/master/documentacao/imagens/Tecnologias.png)

    3.2.1 Front-end

O front-end foi desenvolvido com o intuito de propor um sistema intuitivo de operação, sendo que o projeto tem uma identidade visual padronizada em todas as telas que são projetadas para funcionamento em desktops e dispositivos móveis, como dito anteriormente.

* **HTML**
O HTML é a base de toda a aplicação, sendo usada para criar os principais elementos, como rodapé, cabeçalho, menus, barra lateral etc. 

* **CSS**
Usada para organizar sessões, criar efeitos de transição e definir o design de uma página, como fontes, cores e estilo. 

* **JavaScript**
Responsável por comandos e comportamentos que melhoram a usabilidade de um site, deixando-o mais dinâmico.

    3.2.2 Back- and

O Back-and possui as funcionalidades do sistema e está dividido em 4 classes.
* **DAO**
* **MyIO**
* **Produtos**
* **Usuário**

      3.2.3 Banco de Dados
* **Etapa Conceitual (DER)**

Com base nisso nós criamos o nosso modelo Conceitual do Banco de Dados (DER)

![Modelo Conceitual do Banco de Dados (DER)](https://github.com/icei-pucminas/Magenta-Team/blob/master/artefatos/dados/DiagramaEntidadeRelacionamento.png)

* **Etapa Lógica (Modelo Relacional)**
  
O modelo Relacional foi desenvolvido adaptando o DER
Nessa etapa se representa as estruturas de dados a serem implementadas e suas características considerando os limites impostos pelo modelo de dados usado para implementação do banco de dados.
![Modelo Relacional](https://github.com/icei-pucminas/Magenta-Team/blob/master/artefatos/dados/ModeloRelacional.png)

* **Etapa Física (SQL)**
   
Este modelo representa a implementação do modelo lógico considerando algum tipo particular de tecnologia de banco de dados e os requisitos não funcionais (desempenho, disponibilidade, segurança), no nosso caso nos utilizamos o PostegreSQL e com as linhas de código.    
![sql](https://github.com/icei-pucminas/Magenta-Team/blob/master/documentacao/imagens/sql.png)

    3.2.4 Sistemas inteligentes
 
 Foram utilizados no portal uma API e um chatbot no portal e estão descritos a seguir
 
 * **API**
 
Foi desenvolvida com a intenção de acertar o presente, com um menor erro amostral, com base no perfil de uma pessoa.
Essa API funciona do seguinte modo: pega todas os ids dos hobbies e também todos os produtos, logo após, pega todos os produtos e escolhe o que tem o maior número de hobbies  de iguais dentro de uma faixa etária.

* **Chatbot**

O chatbot tem a intenção de ser um espaço para que o usuário possa estar entrando em contato com a empresa para dúvidas e reclamações como podemos ver no fluxo a seguir.
Primeiramente o chatbot envia uma saudação ao usuário e propõe duas escolhas sugestão ou pergunta.  Em seguida se o usuário escolher sugestões exibe uma mensagem com o email da equipe do suporte técnico da aplicação.  Caso escolha pergunta, exibirá as seguintes opções “Como é feita as escolhas do presente? ”, “Quem são os criadores do site? ”, “Qual o nome do robô? ”, “ O que é o site? ” e “Deseja entrar em contato conosco?”.

**4. Projeto de Interface**

Dentre as preocupações para a montagem da interface do sistema um dos fundamentos é propor um sistema intuitivo de operação, estabelecendo foco em questões como agilidade, acessibilidade e usabilidade. Desta forma, o projeto tem uma identidade visual padronizada em todas as telas que são projetadas para funcionamento em desktops e dispositivos móveis.

    4.1.Fluxo do Usuário

O diagrama apresentado na figura mostra o fluxo de interação do usuário pelas telas do sistema. Cada uma das telas deste fluxo é detalhada na seção de Wireframes que se segue. 

    4.2.Wireframes
Conforme fluxo de telas do projeto juntamente do fluxo de usuário, apresentado no item anterior, as telas do sistema são apresentadas em detalhes nos itens que se seguem. Nesta estrutura, existem 2 grandes blocos, entretanto para chegar até eles é necessário fazer login para visualiza-los. Todas as telas estão descritas a seguir de acordo com seus segmentos.
            
* **Tela de login**
Exige inserção de campo de e-mail e senha para acesso ao sistema. Caso o usuário não seja cadastrado, deverá clicar em “Cadastre-se”.

- **Login**
O usuário deverá inserir seus dados para ser redirecionado a Tela de administrador ou a Tela de usuário 

- **Cadastre-se**
Se o usuário não for cadastrado ele deverá entrar nessa tela e inserir seus dados para ser redirecionado a tela de Login e ter acesso a outras telas da aplicação.

- **Esqueceu sua senha?**

Caso o usuário esqueça sua senha, terá a opção de redefini-la nesta tela, e após, será redirecionado para a tela de Login

* **Tela de administrador**

Utilizada pelo administrador gerenciar os produtos exibidos como sugestão no site. Esse bloco é dividido em outros três apresentados abaixo:

- **Produtos**
Exibe todos os produtos existentes no site e possui a opção de editar e deletar os mesmos.

- **Adicionar**

Opção para o administrador adicionar novos produtos no site e automaticamente no banco de dados.

* **Tela do usuário**

Utilizada pelo usuário para usufruir das opções oferecidas pela aplicação. Esse bloco é dividido em outros quatro apresentados abaixo:

- **Home**

A página é composta uma barra de navegação rápida onde se pode acessar Menu, Questionário, Sobre, SAC e Sair.

- **Questionário**

É dividido em duas opções: presentear outra pessoa ou presentear o próprio usuário. Entretanto, independente da alternativa escolhida é necessário preencher o questionário para retornar o presente ideal na tela.

- **Sobre**
Apresenta um breve resumo sobre o objetivo do site e também dos seus criadores.

- **SAC**
A página apresenta um espaço para que o usuário possa estar entrando em contato com a empresa para dúvidas e reclamações.


**5. Metodologia**
A metodologia contempla as definições de ferramental utilizado pela equipe tanto para a manutenção dos códigos e demais artefatos quanto para a organização do time na execução das tarefas do projeto.

**Ambientes de Trabalho**
Os artefatos do projeto são desenvolvidos a partir de diversas plataformas e a relação dos ambientes com seu respectivo propósito é apresentada na tabela que se segue.

|Artefato|Ambiente|Link|
|:----------|:-------------|:------|
| Repositório de código fonte | GitHub |https://github.com/icei-pucminas/ti2-cc-magenta/tree/master/codigo |
| Documentos do projeto | GitHub e Word |https://github.com/icei-pucminas/ti2-cc-magenta/tree/master/documentacao |
| Projeto de Interface e  Wireframes |Bootstrap | https://getbootstrap.com/ |
| Gerenciamento do Projeto | Trello |https://trello.com/b/AMXSOxOV/ti-2 |

**Hospedagem**
O site já se encontra hospedado de forma local.

**Gerenciamento do Projeto**
A equipe utiliza metodologias ágeis, tendo escolhido o Trello como base para definição do processo de desenvolvimento.
A equipe está organizada da seguinte maneira:
 * **Banco de dados**: Victor Leite de Andrade
 * **Documentação**: Marcos Ani Cury Vinagre Silva, Ludmila Bruna Santos Nascimento
 * **Teste do sistema**: Marcos Ani Cury Vinagre Silva
 * **Gerenciamento do projeto**: Marcos Ani Cury Vinagre Silva
 * **Projeto de interface**: Leticia Americano Lucas
 * **Programação de funcionalidades (Back-and e Front-end)**: Leticia Americano Lucas, Ludmila Bruna Santos Nascimento
 * **Apresentação**: Marcos Ani Cury Vinagre Silva
 
 
 Apesar da organização pré-estabelecida os integrantes poderão alterna suas funções de acordo com as entregas parciais do trabalho.
Para organização e distribuição das tarefas do projeto, a equipe está utilizando o Trello estruturado com as seguintes listas: 

* **Prévia 1**: Nesta etapa, a lista com as tarefas foi dívida com base na facilidade individual e preferência de escolhas, porém todos ajudam e todas as áreas.
* **O que vamos fazer?**: O nosso projeto é baseado em uma forma de facilitar a aquisição de presentes pelo usuário, nosso trello contém todas as ideias que o grupo teve a respeito de temas para o projeto em si.
* **Início do projeto:** No início do projeto, todos os integrantes tiveram que baixar uma série de aplicações para facilitar o desenvolvimento do projeto
* **Concluído**: esta lista apresenta todas as tarefas já concluídas no site e documentos (sprints) que estão totalmente completas.

1.	Algumas páginas do portal.
2.	Modelo Conceitual do Banco de Dados do projeto
3.	Hospedagem do projeto
4.	Fluxograma do usuário
5.	Requisitos Funcionais
6.	Personas
7.	Objetivo
8.	Justificativa
9.	Público Alvo

* **Prévia 2**: Nesta etapa, nós estamos implementando algumas funcionalidades básicas do projeto, ajuste da documentação, redefinindo os requisitos do projeto, além de montar uma apresentação para demonstração da nossa ideia.
* **O que temos**: Temos tudo o que já tínhamos na prévia 1, porém sempre fazendo correções e melhorias.
* **Concluído**: esta lista apresenta todas as tarefas já concluídas no site e documentos (sprints) que estão totalmente completas.

1.	Algumas páginas do portal.
2.	Modelo Conceitual do Banco de Dados do projeto
3.	Hospedagem do projeto
4.	Fluxograma do usuário
5.	Requisitos Funcionais
6.	Personas
7.	Objetivo
8.	Justificativa
9.	Público Alvo
10.	Modelo Relacional do Banco de Dados
11.	Classe Produto do Back-and
12.	Integração Back-and com o Banco de Dados
13.	Integração Back-and com o Portal
14.	Criação do Banco de Dados
15.	Criação da Tabela Produtos no Banco de Dados
16.	Teste de Integração de informações do Banco de Dados direto para o Portal

* **Prévia 3**: Nesta etapa, nós estamos implementando algumas funcionalidades básicas do projeto, ajuste da documentação, redefinindo os requisitos do projeto, além de montar uma apresentação para demonstração da nossa ideia.
* **O que temos**: Temos tudo o que já tínhamos na prévia 2, porém sempre fazendo correções e melhorias.
* **Concluído**: esta lista apresenta todas as tarefas já concluídas no site e documentos (sprints) que estão totalmente completas.
1.	Algumas páginas do portal.
2.	Modelo Conceitual do Banco de Dados do projeto
3.	Hospedagem do projeto
4.	Fluxograma do usuário
5.	Requisitos Funcionais
6.	Personas
7.	Objetivo
8.	Justificativa
9.	Público Alvo
10.	Modelo Relacional do Banco de Dados
11.	Classe Produto do Back-and
12.	Integração Back-and com o Banco de Dados
13.	Integração Back-and com o Portal
14.	Criação do Banco de Dados
15.	Criação da Tabela Produtos no Banco de Dados
16.	Teste de Integração de informações do Banco de Dados direto para o Portal
17.	Dicionário de dados
18.	Classe Usuario do Back-and
19.	Classe ProdutoServices do Back-and

* **Apresentação final**: Nesta etapa, nós estamos implementando algumas funcionalidades básicas do projeto, ajuste da documentação, redefinindo os requisitos do projeto, além de montar uma apresentação para demonstração da nossa ideia.
* **O que temos**: Temos tudo o que já tínhamos na prévia 3, porém sempre fazendo correções e melhorias.
* **Concluído**: esta lista apresenta todas as tarefas já concluídas no site e documentos (sprints) que estão totalmente completas.

1.	Todas as páginas do portal.
2.	Modelo Conceitual do Banco de Dados do projeto
3.	Hospedagem do projeto
4.	Fluxograma do usuário
5.	Requisitos Funcionais
6.	Personas
7.	Objetivo
8.	Justificativa
9.	Público Alvo
10.	Modelo Relacional do Banco de Dados
11.	Classe Produto do Back-and
12.	Integração Back-and com o Banco de Dados
13.	Integração Back-and com o Portal
14.	Criação do Banco de Dados
15.	Criação da Tabela Produtos no Banco de Dados
16.	Teste de Integração de informações do Banco de Dados direto para o Portal
17.	Dicionário de dados
18.	Classe Usuario do Back-and
19.	Classe ProdutoServices do Back-and
20.	API 
21.	Chatbot

**6. Avaliação**
O processo de realização dos testes da solução desenvolvida está documentado na seção que se segue e traz o plano de testes.

**Plano de Teste**

Foram realizados testes funcinais na aplicação, levando em conta Item, Condições, Resultado Esperado e Resultado Obtido.
Todas as páginas avaliadas: Home-Page,Tela de Login e cadastro , Formulário e SAC, tiveram o resultado obtido como o esperado.

**7. Conclusão**




**REFERÊNCIAS**


**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._
