pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
    }
    //parameters {
    //    booleanParam(name: 'DEPLOYMENT', defaultValue: false, description: 'Would you like to deploy')
    //    password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password for deployment')
    //}
    stages {
        stage('GetProject') {
            steps {
                git 'https://github.com/BartoszPerepeczo/bartspetitions'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean:clean"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package"
            }
        }
        stage('InteractWithUser') {
            script {
              env.DEPLOYMENT = input message: 'Please Confirm if you want to Deploy the App:',
                                 parameters: [booleanParam(defaultValue: false,
                                              description: 'Confirmation of deployment.',
                                              name: 'Deployment')]
              env.PASSWORD = input message: 'Please enter the password',
                                 parameters: [password(defaultValue: '',
                                              description: '',
                                              name: 'Password')]
            }
        }
        stage('Deploy') {
            when {
                equals expected: true, actual: "${env.DEPLOYMENT}"
            }
            steps {
                sh 'echo ${env.PASSWORD} | sudo -S chmod 666 /var/run/docker.sock'
                //sh 'sudo chmod 666 /var/run/docker.sock'
                sh 'docker build -f Dockerfile -t myapp .'
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 8081:8080 --detach myapp:latest'
            }
        }

    }
    post {
        success {
             archiveArtifacts allowEmptyArchive: true,
             artifacts: '**/bartspetitions*.war'
        }
    }
}