def call() {
    // Load pipeline deklaratif dari resources
    def pipelineScript = libraryResource('pipelines/htmlPipeline.groovy')
    evaluate(pipelineScript)
}
