Latinoware 2012
==================

Essa é uma aplicação não-oficial para exibir em dispositivos Android a grade de palestras da Latinoware 2012. No momento é uma aplicação simples e com poucos recursos, se você gostaria de contribuir ou fazer alguma sugestão veja a seção "Como Contribuir" logo abaixo.

Play Store
=================

A aplicação pode ser instalada a partir da Play Store: [https://play.google.com/store/apps/details?id=com.fernandomantoan.latinoware](https://play.google.com/store/apps/details?id=com.fernandomantoan.latinoware)

Changelogs
==================

## Versão 1.0 (beta)
* Faz a listagem das palestras dos três dias de evento (17/10/2012, 18/10/2012, 19/10/2012), apresentando o nome da palestra, o palestrante e a hora da palestra.

Criado por
==================

Anderson Rodrigo Davi - <andersonrdavi@gmail.com>

Fernando Geraldo Mantoan - <contato@fernandomantoan.com>

Webservice
==================

Para criar a aplicação foi necessário desenvolver um webservice que fornece uma API JSON para que as palestras possam ser exibidas na aplicação Android. Esse webservice **não** foi liberado como open-source, ele envolve uma boa complexidade, e para que não seja usado para outros fins senão a aplicação Android, está **restrito** somente ao nosso uso. Ele é uma aplicação PHP e faz a leitura diretamente da grade do LAPSI.

Como Contribuir
==================

Para contribuir pedimos que, primeiramente, você crie uma tarefa na aba [https://github.com/fernandomantoan/android-latinoware/issues](Issues), independente se for bug, sugestões ou novas funcionalidades. Para testar a aplicação você pode instalar em seu computador o Ruby e o Sinatra e executar o arquivo **server/json.rb**.

    ruby server/json.rb

Este servidor irá fornecer rapidamente um serviço contendo dois exemplos de palestras para cada dia de evento. Para apontar a aplicação para o endereço, basta alterar a classe **FetchSpeechs** deixando o atributo **endpoint** com o seu IP apontando para a porta **4567** padrão do Sinatra. Ficaria algo similar ao seguinte:

    private final String endpoint = "http://localhost:4567";

Após criar a funcionalidade que deseja implementar aqui nas Issues do GitHub e ter seu ambiente funcionando, não esqueça de fazer o fork e submeter um Pull Request. Agradecemos sua colaboração!


Licença
==================

    Copyright 2012 Fernando Geraldo Mantoan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

