pipeline {
    agent any

    stages {
        stage('Acessar Máquina Externa e Atualizar o Repositório') {
            steps {
                script {
                         sh "env"
                }
            }
        }

        stage('Buildando imagen da API') {
            steps {
                script {
                       echo 'Build'
                }
            }
        }

        stage('Subindo container') {
            steps {
                script {
                       echo 'Sub'
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
