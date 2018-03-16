package io.louvre.templater.groovy

import com.google.common.io.Files
import org.apache.commons.ssl.util.UTF8

import java.nio.charset.Charset
import java.nio.file.Path
import java.nio.file.Paths

import static java.util.UUID.*

class TemplateGen {

    def static main (File templateFile, File templateMethods, File elementOrder, log) {

/*        def fileContents = getFile(definitionUrl, log)
        def methods = getMethods(definitionType, fileContents, log)
        def sortedMethods = sortMethods(methods)
        updateElementOrderFile(sortedMethods)*/
        createTemplates(templateFile, templateMethods, elementOrder)

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


    def static createTemplates(projectDirectory, methodListFile, templateFile, testSuiteName, context, log) {
        def line
        def source = new File(projectDirectory+templateFile)
        def elementSource = new File(projectDirectory+methodListFile)
        def fileExtension = ".xml"
        def elementOrderFile = "element.order"

        def elementFile = new File(projectDirectory+testSuiteName+elementOrderFile)
        elementFile << elementSource.text + fileExtension

        File file = new File(projectDirectory+methodListFile)
        file.withReader { reader ->
            while ((line = reader.readLine())!=null) {

                def propertyMap = [
                        testcase_name: ['${TESTCASE_NAME}', line],
                        testcase_uuid: ['${TESTCASE_UUID}', randomUUID()],
                        datasource_uuid: ['${DATASOURCE_UUID}', randomUUID()],
                        switch_on_uuid: ['${SWITCH_ON_UUID}', randomUUID()],
                        data_gen_uuid: ['${DATA_GEN_UUID}', randomUUID()],
                        boundary_gen_uuid: ['${BOUNDARY_GEN_UUID}', randomUUID()],
                        jdbc_assertions_uuid: ['${JDBC_ASSERTIONS_UUID}', randomUUID()],
                        script_assertions_uuid: ['${SCRIPT_ASSERTIONS_UUID}', randomUUID()],
                        switch_off_uuid: ['${SWITCH_OFF_UUID}', randomUUID()],
                        datasource_loop_uuid: ['${DATASOURCE_LOOP_UUID}', randomUUID()],
                ]

                def destination = new File(projectDirectory+testSuiteName+line+fileExtension)
                destination << source.text

                propertyMap.each {
                    destination.text = destination.text.replace(it.value[0].toString(), it.value[1].toString())
                }
            }
        }
    }
}

