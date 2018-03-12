package io.louvre.templater.groovy

class TemplateGen {

    def static main (String definitionUrl, String definitionType, log) {

        def fileContents = getFile(definitionUrl, log)
        def methods = getMethods(definitionType, fileContents, log)
/*        def sortedMethods = sortMethods(methods)
        updateElementOrderFile(sortedMethods)
        createTemplates()*/

    }

    def static getFile(String definitionUrl, log) {
        String fileContents = new URL(definitionUrl).text

        return fileContents
    }

    def static getMethods(definitionType, String fileContents, log) {
        //depends on definition file type search for methods in different places
        //using different parsing strategies [xml,json,text]

        def methods

        switch (definitionType) {
            case "wadl":
                def definitionFile = new XmlSlurper().parseText(fileContents)
                def hello = definitionFile.toString()
                log.info(hello)
                break
            case "wsdl":
                break
            case "swagger":
                break
            case "openApi":
                break
            default:
                log.info("Definition type not accepted. Valid options are wadl, wsdl, swagger or openApi.")
                break
        }

        if (methods != null) {
            return methods
        }
    }

    def static sortMethods(methods) {
        //take in unsorted methods
        //read in filter criteria from an enum [create, update, delete, gets, get, other]
        //sort according to enum

        def sortedMethods = 'hi'

        return sortedMethods
    }

    def static updateElementOrderFile(sortedMethods) {
        //take in sorted methods
        //find correct file
        //add method names and append .xml
        //return sorted method names with .xml appended
    }

    def static createTemplates() {
        //confirm sorted method == full method
        //loop through array of full method names (.xml) [Ideal world: See if method name file already exists]
        //create files
        //copy template over
        //generate uuid and set all properties with it
        //set input variables
    }
}

