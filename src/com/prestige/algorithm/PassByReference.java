package com.prestige.algorithm;

/**
 * Created by prest on 6/3/2019.
 */
public class PassByReference {

    public void changeOption(Option option){

        option.setAnswer("Obi");
    }


    public static void main(String[] args) {

        PassByReference passByReference = new PassByReference();

        Option option = new Option();
        option.setAnswer("Ada");
        passByReference.changeOption(option);

        System.out.println("Option: " + option);
    }


}

class Option {

    String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Option{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
