pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -U'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
    post {
        success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
        }
    }
}