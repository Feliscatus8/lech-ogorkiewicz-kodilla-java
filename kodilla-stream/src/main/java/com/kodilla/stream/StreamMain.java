package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumberGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionCalculator;

public class StreamMain {
    public static void main(String[] args){
        System.out.println("Welcome to module 7 - Stream\n");

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("This is an example text", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("This is an example text", (text) -> text.toUpperCase());
        poemBeautifier.beautify("This is an example text", (text) -> text.replace('s', 'n'));
        poemBeautifier.beautify("This is an example text", (text) -> text.replaceAll("text", "meow"));

        Processor processor = new Processor();
        processor.execute(() -> System.out.println("\nThis is an example text"));

        System.out.println("\nCalculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with method references");
        expressionExecutor.executeExpression(8, 2, FunctionCalculator::multiplyAByB);
        expressionExecutor.executeExpression(8, 2, FunctionCalculator::addAToB);
        expressionExecutor.executeExpression(8, 2, FunctionCalculator::subtractAFromB);
        expressionExecutor.executeExpression(8,2,FunctionCalculator::divideAByB);

        System.out.println("\nUsing Stream to generate even numbers from 1 to 20");
        NumberGenerator.generateEven(20);
    }
}