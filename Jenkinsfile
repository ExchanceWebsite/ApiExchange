pipeline {
    agent any

    stages {
        stage('Etapa 1 - Atualizando ') {
            steps {
                script {
                    sshagent(credentials: ['privateKey-AllMachines']) {
                        sh "pwd'"
                    }
                }
            }
        }

        stage('Buildando imagen da API') {
            steps {
                script {
                    sshagent(credentials: ['privateKey-AllMachines']) {
                        sh ""
                    }
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
