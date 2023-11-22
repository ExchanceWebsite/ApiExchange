pipeline {
    agent any

    stages {
        stage('Etapa 1 - Atualizando ') {
            steps {
                script {
                    sshagent(credentials: ['privateKey-AllMachines']) {
                        sh "ssh ubuntu@3.221.247.133 'cd VmConfig/ && git pull'"
                    }
                }
            }
        }

        stage('Buildando imagen da API') {
            steps {
                script {
                    sshagent(credentials: ['privateKey-AllMachines']) {
                        sh "ssh ubuntu@3.221.247.133 'cd Api/'"
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
