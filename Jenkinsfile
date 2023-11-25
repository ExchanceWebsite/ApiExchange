pipeline {
    agent any

    environment {
        REMOTE_USER = 'ubuntu'
        REMOTE_HOST = 'ec2-3-221-247-133.compute-1.amazonaws.com'
        REMOTE_DIR = '/home/ubuntu/VmConfig/'
    }

    stages {
        stage('Acessar Máquina Externa e Atualizar o Repositório') {
            steps {
                script {
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'cd ${REMOTE_DIR} && git pull'"
                }
            }
        }

        stage('Buildando imagem da API') {
            steps {
                script {
                    echo 'Build'
                    sh"sudo ssh -i /home/ubuntu/key-2210.pem ${REMOTE_USER}@${REMOTE_HOST} 'sudo docker images'"
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

