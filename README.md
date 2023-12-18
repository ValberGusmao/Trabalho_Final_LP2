Linguagem de Programação II – 2023.2 
Trabalho final

• Equivale às segunda e terceira avaliações 

• Pode ser feito em dupla

• Deve ser enviado no SIGAA dentro de uma pasta zipada (zip) o Códigos o Link para vídeo com o teste da aplicação e explicação do código (pode ser em qualquer lugar, contando que abra)

o [Opcional] Link do Repl.it com o projeto, caso fique na dúvida se  vai rodar na minha máquina

• Todo o projeto deve ser implementado em Java

• [Opcional] Interface gráfica com Java Swing (5pt a mais)

• Critérios de avaliação:
o Implementação das funcionalidades conforme descrito
o Clareza do código (se necessário documentar com comentários)
o Uso e organização dos conceitos de Orientação à objetos
o Uso de conceitos de arquivos, coleções e exceções

Escreva um programa para auxiliar um departamento no problema de alocar 
salas e espaços compartilhados. Esses espaços são usados de maneira fixa, se 
forem aulas de uma {disciplina, curso} ou esporádicos se forem eventos
(seminários, defesas TCC, palestras, provas). 
O departamento recebe solicitações que informam:
Se solicitação fixa:
• Ano/Semestre/Curso/Disciplina/Vagas/Horários no formato SIGAA semanal

Se solicitação eventual:
• Ano/Semestre/Curso/Finalidade/Vagas/ Horário no formato SIGAA/DataInício/Data Fim

o Tipo pode ser seminário, defesa de TCC, palestra, prova
O trabalho do departamento consiste em alocar os espaços físicos nas 
solicitações. Esses espaços podem ser salas de aula e auditórios. Ambos 
possuem uma capacidade, nome e localização dentro do prédio.
O chefe do departamento precisa de uma implementação sua para:
1. Ler de um arquivo formatado todas as novas solicitações. O arquivo vem 
com várias solicitações, uma por linha, sendo que possui o seguinte 
cabeçalho:
TIPO_SOLICITACAO*;ANO;SEMESTRE;CURSO;DADO*;QTD_V
AGAS;HORARIO;ADICIONAL**
*Quando TIPO_SOLICITACAO=”FIXA” então DADO será uma 
disciplina
*Quando TIPO_SOLICITACAO=”EVENTUAL” então DADO será 
uma Finalidade={Seminário, TCC, Palestra, Prova}
**Quando TIPO_SOLICITACAO=”EVENTUAL” então ADICIONAL 
terá os campos DATA_INICIO;DATA_FIM
2. Alocar cada solicitação: o sistema deve guiar o usuário, solicitação por 
solicitação, para buscar qual o espaço físico que melhor atende em 
termos de capacidade a solicitação.
a. Não se pode alocar um espaço ao mesmo tempo para duas 
solicitações – não pode haver conflitos
b. Se a solicitação for eventual, só se pode alocar auditórios
c. Se a solicitação for fixa, pode-se alocar salas de aula e auditórios
d. O usuário deve poder parar o trabalho a qualquer momento. O 
sistema deve salvar em arquivos tudo que foi feito para continuar 
depois o trabalho
3. Gerar um relatório de alocações, com os seguintes filtros:
a. Curso (vem com todas as informações da solicitação filtradas por 
curso adicionadas da sala)
b. Espaço Físico (por sala/auditório, aparecem todas as solicitações 
alocadas ao longo da semana)
4. Gravar em arquivos todas as decisões de alocação de tal maneira que ao 
fechar o programa o mesmo mantenha os dados salvos, e ao abrir o 
programa, todas as alocações previamente realizadas sejam resgatadas
