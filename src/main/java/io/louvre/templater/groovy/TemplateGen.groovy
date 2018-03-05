package io.louvre.templater.groovy


class TemplateGen {

    def static main (String definitionUrl, log) {
        getFile(definitionUrl, log)
    }

    def static getFile(String definitionUrl, log) {
        String fileContents = new URL(definitionUrl).text

//        log.info(fileContents)
        return fileContents
    }









    // 2.0: parse file for method names and store in memory
    // 3.0: update element.order with methodNames.xml
        //3.1: order defined with substring with array
        //3.2: Efficient string sort used to re-allocate
    // 4.0: loop
        // 4.1 make file for each method name: something.xml
        // 4.2: copy paste template into each file
        // 4.3: replace {} bracket variables
            // 4.3.1: create uuid for testCase id's ( ${=java.util.UUID.randomUUID()} )
            // 4.3.2: input variables provided by property file
            // 4.3.3: input properties hardcoded
}
