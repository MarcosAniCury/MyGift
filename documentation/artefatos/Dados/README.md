# Artefatos relativos à modelagem de dados do projeto

Este diretório mantém os artefatos relatório à modelagem de dados do projeto. 

Os principais documentos a serem produzidos são:


* `script_de_banco.sql`
	* Script de criação do banco de dados.

* `diagrama entidade relacionamento`
	* Apresentar o DER em imagem vetorial para eviar perda de qualidade com renderização em resolução específica.
	* Arquivo DiagramaEntidadeRelacionamentos.png

Demais artefatos que julgar pertinentes.

* `Modelo Relacional`
	* Arquivo ModeloRelacional.png

* `Dicionário de Dados`
	* Arquivo DicionárioDeDados.csv

 # Declaração do Minimundo

No site teremos usuários que deverão informar o seu nome, idade, genêro, e-mail, os seus hobbies, sua data de nascimento sendo que por fora será retirado a idade desse usuário,um atributo do tipo boolean que indicará se será um usuário administrador ou não e não pode ter valor null, a senha de seu cadastro, será gerado automaticamente um id única(será a Primary key) e é armazenada a resposta da pergunta de segurança. A entidade produto terá os atributos nome, hobbies, id(será a Primary Key), preço, faixa etária e o nome do arquivo da imagem do produto. Os hobbies estarão ligados a todos as outras entidades e é feito relacionamentos de cardinalidade N:N entre produto para hobbies, presenteado para hobbies e usuário para hobbies.
