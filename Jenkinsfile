pipeline {
    agent any

    stages {
        stage('Etapa 1 - Atualizando ') {
            steps {
                script {
                        sh "pwd'"
                }
            }
        }

        stage('Buildando imagen da API') {
            steps {
                script {
                        sh "Build"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline bem-sucedido!'
        }
        failure {
            echo 'Pipeline falhou!'
        }
    }
}
