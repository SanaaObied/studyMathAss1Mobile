package com.example.study_math;

public class Question {
    private String question; // Question text
    private String optionA; // Option A
    private String optionB; // Option B
    private String optionC; // Option C
    private String optionD; // Option D
    private String correctAnswer; // Correct answer
    private boolean answered; // Flag indicating if the question has been answered
    private String selectedAnswer; // User's selected answer

    // Constructor to initialize the question with options and correct answer
    public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.selectedAnswer = null; // Initialize selected answer as null
    }

    // Getters for question, options, and correct answer
    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Check if the question has been answered
    public boolean isAnswered() {
        return answered;
    }

    // Set the answered flag
    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    // Get the user's selected answer
    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    // Set the user's selected answer
    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
