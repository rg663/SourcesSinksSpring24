package org.example;

import sootup.core.Project;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootClass;
import sootup.core.model.SootMethod;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.core.views.View;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaProject;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootClassSource;
import sootup.java.core.language.JavaLanguage;
import sootup.java.core.views.JavaView;

import java.util.Collections;

public class HelloWorldAnalysis {
    public static void main(String[] args) {
        AnalysisInputLocation<JavaSootClass> inputLocation =
                new JavaClassPathAnalysisInputLocation("src/main/java/org/example/helloworld");
        JavaLanguage language = new JavaLanguage(8);

        Project<JavaSootClass, JavaView> project =
                JavaProject.builder(language)
                        .addInputLocation(inputLocation).build();

        ClassType classType =
                project.getIdentifierFactory().getClassType("HelloWorld");

        MethodSignature methodSignature = project.getIdentifierFactory().getMethodSignature(
                "main", String.valueOf(classType), "void",
                Collections.singletonList("java.lang.String[]"));

        View<JavaSootClass> view = project.createView();

        SootClass<JavaSootClassSource> sootClass = view.getClass(classType).get();

        SootMethod sootMethod =
                sootClass.getMethod(methodSignature.getSubSignature()).get();

        for (Stmt stmt : sootMethod.getBody().getStmts()) {
            System.out.println(stmt);
        }
    }
}