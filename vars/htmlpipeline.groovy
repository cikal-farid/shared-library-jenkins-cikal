def call() {
    pipeline {
    agent any

    environment {
        // Tambahkan npm global bin ke PATH
        PATH = "${PATH}:${WORKSPACE}/.npm-global/bin:/usr/local/bin:/usr/bin"
    }

    stages {

        stage("Library Resource") {
            steps {
                script {
                    def config = libraryResource("config/build.json")
                    echo(config)
                }
            }
        }

        stage("Hello Person") {
            steps {
                script {
                    hello.person([
                        firstName: "Cikal Muhammad Farid",
                        lastName: "Al Gifari"
                    ])
                }
            }
        }

        stage("Setup Tools") {
            steps {
                sh '''
                    echo "🔍 Checking if htmlhint is installed..."
                    if ! command -v htmlhint >/dev/null 2>&1; then
                      echo "⚡ Installing htmlhint..."
                      npm install -g htmlhint
                    else
                      echo "✅ htmlhint already installed"
                    fi

                    echo "📍 htmlhint global bin dir: $(npm bin -g)"
                    ls -l $(npm bin -g) || true
                '''
            }
        }

        stage("HTML Build") {
            steps {
                script {
                    // Jalankan html.sh dengan PATH yg sudah ditambahkan npm bin -g
                    sh '''
                        export PATH=$(npm bin -g):$PATH
                        chmod +x ./html.sh
                        ./html.sh test
                    '''
                }
            }
        }

        stage("Global Variable") {
            steps {
                script {
                    echo(author())
                    echo(author.myname())
                    echo(author.mywife())
                }
            }
        }

        stage("Hello Groovy") {
            steps {
                script {
                    Output.hello(this, "Groovy")
                }
            }
        }

        stage("Hello World") {
            steps {
                script {
                    echo "Hello World"
                }
            }
        }
    }
}
}