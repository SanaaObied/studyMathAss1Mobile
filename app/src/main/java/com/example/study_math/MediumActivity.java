package com.example.study_math;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MediumActivity extends AppCompatActivity {

    // SharedPreferences for storing quiz preferences
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "QuizPreferences";
    private static final String ANSWER_KEY = "answer";

    // List to hold the quiz questions
    private ArrayList<Question> questionList;
    private ListView quizListView;
    private QuizAdapter quizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        quizListView = findViewById(R.id.quizListView);

        // Initialize the question list
        questionList = new ArrayList<>();
        // Add questions to the quiz
        questionList.add(new Question("What is 100 - 75?", "25", "24", "10", "19", "25")); // Correct: 25
        questionList.add(new Question("What is 16 * 3?", "38", "34", "48", "81", "48")); // Correct: 48
        questionList.add(new Question("What is 120 / 20?", "10", "5", "15", "6", "6")); // Correct: 6
        questionList.add(new Question("What is 18 + 70?", "91", "83", "88", "100", "88")); // Correct: 88
        questionList.add(new Question("What is 100 % 5?", "0", "20", "1", "4", "0")); // Correct: 0

        // Create and set the adapter for the ListView
        quizAdapter = new QuizAdapter(this, questionList);
        quizListView.setAdapter(quizAdapter);

        // Button for submitting answers
        Button submitButton = findViewById(R.id.bottomButton);
        // Set OnClickListener to handle button click
        submitButton.setOnClickListener(v -> submitAnswers());
    }

    // Method to handle submitting answers
    private void submitAnswers() {
        Log.d("SubmitButton", "Submit button clicked");

        int unansweredCount = 0;
        for (Question question : questionList) {
            if (!question.isAnswered()) {
                unansweredCount++;
                continue; // Skip to the next question if unanswered
            }

            String selectedAnswer = question.getSelectedAnswer();
            if (selectedAnswer.equals(question.getCorrectAnswer())) {
                // Correct answer logic - Example: Increase score
            } else {
                String message = "Incorrect. The correct answer is: " + question.getCorrectAnswer();
                Toast.makeText(MediumActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }

        if (unansweredCount > 0) {
            Toast.makeText(MediumActivity.this, "Please answer all questions.", Toast.LENGTH_SHORT).show();
            return; // Exit if there are unanswered questions
        }

        // Show completion message
        Toast.makeText(MediumActivity.this, "Quiz submitted!", Toast.LENGTH_SHORT).show();

        // Navigate to MainActivity
        Intent intent = new Intent(MediumActivity.this, MainActivity.class);
        startActivity(intent);
    }
}