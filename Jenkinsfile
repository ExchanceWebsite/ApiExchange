pipeline {
    agent any

    stages {
        stage('Etapa 1 - Atualizando ') {
            steps {
                script {
                       withCredentials([sshUserPrivateKey(credentialsId: 'privateKey-AllMachines', keyFileVariable: 'SSH_KEY')]) {
                        sh "ssh -i \$SSH_KEY ubuntu@ec2-3-221-247-133.compute-1.amazonaws.com 'cd VmConfig/ && git pull'"
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
