package Palantir;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anhtran on 10/1/17.
 *
 * Stack that does this
 *
 * 2 5 + 10 *
 *
 * (2+5)*10
 *
 * push
 * 2
 * push
 * 5
 * add
 *
 *
 * Instruction list: push, add, sub, mult, div, print
 *
 *
 */
public class StackMath {
    private static class Operator {
        long firstNum;
        long secondNum;

        //assumes inputs are integers
        public Operator(long firstNum, long secondNum){
            this.firstNum = firstNum;
            this.secondNum = secondNum;
        }

        public long add() {
            return (long) this.firstNum + this.secondNum;
        }
        //assumes inputs and outputs are non-negative integers
        //handles Integer.min - 1
        public long sub() {
            return (long) Math.abs(this.firstNum - this.secondNum);
        }
        public long mult() {
            return (long) this.firstNum*this.secondNum;
        }
        public double div() {
            if(this.firstNum > this.secondNum) {
                return (double) this.firstNum / this.secondNum;
            }
            else {
                return (double) this.secondNum / this.firstNum;
            }
        }

    }
    private static class StackInterpreter {
        //long, double, int values
        Stack<String> stack;

        public StackInterpreter(){
            stack = new Stack();
        }
        public void push(String val) {
            stack.push(val);
        }
        public String pop(){
            return stack.pop();
        }
        public void print() {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StackInterpreter stack = new StackInterpreter();
        Operator ops;
        //assuming input is always correct
        while(sc.hasNext()){
            String cur = sc.next();
            if(cur.equals("add")) {
                long a = Long.parseLong(stack.pop());
                long b = Long.parseLong(stack.pop());
                ops = new Operator(a,b);
                stack.push(String.valueOf(ops.add()));

            }
            else if(cur.equals("sub")) {
                long a = Long.parseLong(stack.pop());
                long b = Long.parseLong(stack.pop());
                ops = new Operator(a,b);
                stack.push(String.valueOf(ops.sub()));
            }
            else if(cur.equals("mult")) {
                long a = Long.parseLong(stack.pop());
                long b = Long.parseLong(stack.pop());
                ops = new Operator(a,b);
                stack.push(String.valueOf(ops.mult()));

            }
            else if(cur.equals("div")) {
                long a = Long.parseLong(stack.pop());
                long b = Long.parseLong(stack.pop());
                ops = new Operator(a,b);
                stack.push(String.valueOf(ops.div()));
            }
            else if(cur.equals("print")) {
                System.out.println(stack.pop());
            }
            else if(!cur.equals("push")){
                stack.push(cur);
            }
        }
    }


}
