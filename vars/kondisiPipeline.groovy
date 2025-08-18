def call(Map config) {
    if (config.type == "html") {
        cikalPipeline()
    } else {
        pipeline {
        agent any    
        stages {
            stage("Unsupported Pipeline") {
                steps {
                    script {
                        echo("Unsupported Pipeline")
                    }
                }
            }

        }
    }
}
}