package org.example;

import org.antlr.v4.runtime.misc.NotNull;
import sootup.core.Project;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.basic.Immediate;
import sootup.core.jimple.common.expr.AbstractInvokeExpr;
import sootup.core.jimple.common.stmt.JAssignStmt;
import sootup.core.jimple.common.stmt.JInvokeStmt;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootClass;
import sootup.core.model.SootMethod;
import sootup.core.signatures.MethodSignature;
import sootup.core.views.View;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaProject;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootClassSource;
import sootup.java.core.language.JavaLanguage;
import sootup.java.core.views.JavaView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class SourcesAndSinksAnalysis {

    public static @NotNull Dictionary<String, String> SourcesSinks(String className) {
        Dictionary<String, String> dict
                = new Hashtable<>();
        Dictionary<String, String> methodMappings
                = new Hashtable<>();
        try {
            File myObj = new File("src/main/java/org/example/textfiles/SourcesAndSinks.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("->")) {
                    String[] listOfStr = data.split("->");
                    dict.put(listOfStr[0], listOfStr[1]);
                }
            }
            myReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        AnalysisInputLocation<JavaSootClass> inputLocation =
                new JavaClassPathAnalysisInputLocation("src/main/java/org/example/" + className);
        JavaLanguage language = new JavaLanguage(8);

        Project<JavaSootClass, JavaView> project =
                JavaProject.builder(language)
                        .addInputLocation(inputLocation).build();
        View<JavaSootClass> view = project.createView();

        for (SootClass<JavaSootClassSource> classes : view.getClasses()) {
            for (SootMethod method : classes.getMethods()) {
                for (Stmt stmt : method.getBody().getStmts()) {
                    if (stmt.containsInvokeExpr()) {
                        if (stmt instanceof JInvokeStmt || stmt instanceof JAssignStmt) {
                            AbstractInvokeExpr actualExpr = stmt.getInvokeExpr();
                            List<Immediate> argsOfInv = actualExpr.getArgs();
                            MethodSignature sign = actualExpr.getMethodSignature();
                            System.out.println((sign + " "));
                            String sourceOrSink = dict.get((sign + " "));
                            if (sourceOrSink != null) {
                                if (sourceOrSink.contains("_SOURCE_")) {
                                    System.out.println("SOURCE: " + sign + "\n");
                                    methodMappings.put(sign.toString(), "SOURCE");
                                } else if (sourceOrSink.contains("_SINK_")) {
                                    System.out.println("SINK: " + sign + "\n");
                                    methodMappings.put(sign.toString(), "SINK");
                                }
                            }
                        }
                    }
                }
            }
        }
        return methodMappings;
    }

    public static void main(String[] args) {
        System.out.println(SourcesSinks(""));
    }

}