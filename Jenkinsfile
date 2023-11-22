pipeline {
    agent any

    stages {
        stage('Etapa 1 - Atualizando ') {
            steps {
                script {
                       sshagent(credentials: ['privateKey-AllMachines']) {
                        sh "ssh -i /home/ubuntu/key.pem ubuntu@ec2-3-221-247-133.compute-1.amazonaws.com 'cd VmConfig/ && git pull'"
                    }
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
