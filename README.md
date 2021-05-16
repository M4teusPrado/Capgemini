# Documentação

## Requisitos para compilação

Clonar repositorio

Clone [https://github.com/M4teusPrado/Capgemini.git](https://github.com/M4teusPrado/Capgemini.git)

- Instalar JDK

    Para instalar o JDK no Linux ou no Windows primeiramente é necessário efetuar o download do arquivo de instalação. Para isso deve-se acessar o site da Oracle (vide seção Links) e baixar versão do JDK correspondente ao sistema operacional e arquitetura (32 ou 64 bits) utilizada.

    Após o download do arquivo de instalação ter sido concluído, 

    Windows: 

    Executar o programa de instalação e clicar no botão Next em todas as telas apresentadas. 

    Linux: 

    ```python
    Estando no modo gráfico, abrir um Terminal e digitar os comandos abaixo

          $ sudo add-apt-repository ppa:webupd8team/java
          $ sudo apt-get update
          $ sudo apt-get install oracle-java8-installer
    ```

    **Configuração básica**

    A configuração básica do JDK consiste na criação das variáveis de ambiente *JAVA_HOME* e *CLASSPATH*. Estas variáveis são importantes para que os programas relacionados ao desenvolvimento de aplicações Java possam encontrar, no diretório onde o JDK foi instalado, as diversas bibliotecas para a construção de softwares Java.

    Windows:

    ```python
    - Abrir um Prompt do MS-DOS

        - Executar os comandos abaixo

          setx JAVA_HOME "<diretório-onde-jdk-foi-instalado>"
          setx CLASSPATH %JAVA_HOME%\lib
          setx PATH %PATH%;%JAVA_HOME%\bin

        - Fechar o Prompt do MS-DOS

    ```

    Linux:

    ```
    Estando no modo gráfico, abrir um Terminal

        - Editar o arquivo /etc/profile com o comando abaixo

          $ sudo gedit /etc/profile

        - Adicionar as linhas abaixo no inicio do arquivo /etc/profile

          JAVA_HOME=diretório-onde-jdk-foi-instalado
          CLASSPATH=.;$JAVA_HOME/lib
          PATH=$PATH:$JAVA_HOME/bin
          export JAVA_HOME
          export CLASSPATH
          export PATH

        - Salvar o arquivo e efetuar um logoff para que as variáveis de ambiente entrem em vigor.
    ```

- Instalação do Maven

    Downloading Apache Maven 3.8.1: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

Agora bastar apertar com o botão direito do mouse em sua interface, e clicar em run 

### Arquitetura do projeto

![Diagrama de camadas](https://user-images.githubusercontent.com/59894662/118381716-4e7d8b00-b5c4-11eb-91e3-1179abeaa625.png)

Controller: Recebe requisições do usuário e repassa ao service

Service: Service funciona como uma camada de serviços interagindo tanto com a entidades e também com o repository 

Model: Camada onde é possível criar as entidades

Repository: Tem como funcionalidade salvar armazenar entidades

### Relacionamento de entidades

![Modelo ER](https://user-images.githubusercontent.com/59894662/118381720-55a49900-b5c4-11eb-8cd8-ce4e67fb889f.png)


De forma pratica, cada anuncio possuiu um relatório com informações de visualizações, cliques e compartilhamentos.
