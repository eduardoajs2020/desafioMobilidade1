# O "desafioMobilidade" é uma aplicação móvel desenvolvida para Android utilizando a linguagem de programação Kotlin e o framework #Android SDK. O objetivo do aplicativo é permitir que os usuários insiram um apelido e um PAT (Personal Access Token) em uma tela e #salvem esses dados em um banco de dados local. Além disso, o aplicativo é capaz de receber um link com um esquema personalizado e #exibir o PAT presente nesse link.

### Funcionalidades

#O aplicativo possui as seguintes funcionalidades:

#1. Tela de Entrada de Dados:** Esta tela permite que o usuário insira um apelido em um campo de texto e visualize o PAT (se #presente) em uma label acima do campo de texto. O usuário pode então salvar o apelido e o PAT clicando em um botão.

#2. Salvamento de Dados:** Quando o usuário clica no botão "Salvar", o aplicativo valida o apelido inserido e, se válido, salva o #apelido e o PAT no banco de dados local.

#3. Recebimento de Link com Esquema Personalizado:** O aplicativo é capaz de ser acionado por um link com o esquema personalizado #`caixa.gov.br://meupat?pat=<valor>`. Se presente, o valor do PAT é extraído do link e exibido na tela de entrada de dados.

#4. Exibição de Dados Salvos:** O aplicativo possui uma segunda tela que exibe a lista de apelidos e PATs salvos no banco de dados #local. O usuário pode navegar entre esta tela e a tela de entrada de dados.

### Estrutura do Código

#O código do aplicativo está estruturado em conformidade com o padrão de arquitetura MVC (Model-View-Controller), onde:

#- Model: Representado pelas classes `User`, e `AppDatabase`, que são responsáveis pelo armazenamento e manipulação dos #dados no banco de dados local.
#- View:** Representado pelas classes de layout XML (`activity_main.xml` e `activity_api.xml`), que definem a aparência das telas do #aplicativo.
#- Controller:** Representado pelas classes de atividade (`MainActivity` e `APIActivity`), que controlam a lógica de apresentação e #interação com o usuário.

### Como Executar o Aplicativo

#Para executar o aplicativo, siga as seguintes instruções:

#1. Clone ou faça o download do repositório do aplicativo do [GitHub](https://github.com/eduardoajs2020/desafioMobilidade).
#2. Abra o projeto em sua IDE preferida (recomendado: Android Studio).
#3. Certifique-se de que as dependências do projeto foram resolvidas.
#4. Execute o aplicativo em um emulador Android ou em um dispositivo físico conectado.
#5. Navegue pelas telas do aplicativo e teste suas funcionalidades.

### Conclusão

#O aplicativo "desafioMobilidade" demonstra o uso de várias funcionalidades do Android SDK, como entrada de dados, manipulação de #banco de dados local, tratamento de links com esquemas personalizados, entre outros. Esperamos que esta documentação forneça uma #compreensão clara do funcionamento e estrutura do aplicativo. Para mais detalhes, consulte o código-fonte disponível no repositório #do GitHub.
