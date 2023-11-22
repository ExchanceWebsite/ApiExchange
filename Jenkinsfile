pipeline {
    agent any // Define onde o pipeline será executado (em qualquer agente disponível)

    stages {
        stage('Etapa 1') {
            steps {
                // Adicione os comandos ou scripts que deseja executar nesta etapa
                echo 'Executando a Etapa 1'
            }
        }

        stage('Etapa 2') {
            steps {
                // Adicione os comandos ou scripts que deseja executar nesta etapa
                echo 'Executando a Etapa 2'
            }
        }
    }

    post {
        success {
            // Este bloco será executado se o pipeline for bem-sucedido
            echo 'Pipeline bem-sucedido!'
        }
        failure {
            // Este bloco será executado se o pipeline falhar
            echo 'Pipeline falhou!'
        }
    }
}
