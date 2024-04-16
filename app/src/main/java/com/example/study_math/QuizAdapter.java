package com.example.study_math;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizAdapter extends ArrayAdapter<Question> {
    private Context mContext;

    QuizAdapter(Context context, ArrayList<Question> questionList) {
        super(context, 0, questionList);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            // Inflate the layout if the view is null
            LayoutInflater inflater = LayoutInflater.from(mContext);
            listItemView = inflater.inflate(R.layout.list_item_question, parent, false);
        }

        // Get the current question from the list
        Question currentQuestion = getItem(position);

        if (currentQuestion != null) {
            // Populate the views with data from the currentQuestion
            TextView questionText = listItemView.findViewById(R.id.question);
            RadioGroup optionsRadioGroup = listItemView.findViewById(R.id.optionsRadioGroup);
            RadioButton optionA = listItemView.findViewById(R.id.optionA);
            RadioButton optionB = listItemView.findViewById(R.id.optionB);
            RadioButton optionC = listItemView.findViewById(R.id.optionC);
            RadioButton optionD = listItemView.findViewById(R.id.optionD);

            questionText.setText(currentQuestion.getQuestion());
            optionA.setText(currentQuestion.getOptionA());
            optionB.setText(currentQuestion.getOptionB());
            optionC.setText(currentQuestion.getOptionC());
            optionD.setText(currentQuestion.getOptionD());

            // Set a tag to identify the question position in the radio group
            optionsRadioGroup.setTag(position);

            // Set listeners for radio button clicks
            optionsRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                int itemPosition = (int) group.getTag(); // Get the position from the tag
                Question selectedQuestion = getItem(itemPosition);
                if (selectedQuestion != null) {
                    RadioButton selectedRadioButton = group.findViewById(checkedId);
                    if (selectedRadioButton != null) {
                        String selectedAnswer = selectedRadioButton.getText().toString();
                        if (!selectedQuestion.isAnswered()) {
                            selectedQuestion.setAnswered(true); // Mark the question as answered
                            checkAnswer(selectedQuestion, selectedAnswer); // Call checkAnswer from EasyActivity
                        }
                    }
                }
            });

            // Set listeners for radio buttons individually
            optionA.setOnClickListener(v -> onRadioButtonClicked(optionA, currentQuestion));
            optionB.setOnClickListener(v -> onRadioButtonClicked(optionB, currentQuestion));
            optionC.setOnClickListener(v -> onRadioButtonClicked(optionC, currentQuestion));
            optionD.setOnClickListener(v -> onRadioButtonClicked(optionD, currentQuestion));
        } else {
            // Handle the case where currentQuestion is null (no data available)
            // For example, hide the listItemView or set default text
            listItemView.setVisibility(View.GONE); // Hide the item
        }

        return listItemView;
    }

    // Method to handle radio button clicks
    private void onRadioButtonClicked(RadioButton radioButton, Question question) {
        String selectedAnswer = radioButton.getText().toString();
        String correctAnswer = question.getCorrectAnswer();
        if (selectedAnswer.equals(correctAnswer)) {
            Toast.makeText(mContext, "Correct answer!", Toast.LENGTH_SHORT).show();
        } else {
            String message = "Incorrect answer. The correct answer is: " + correctAnswer;
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }

    // Method to check the selected answer against the correct answer
    private void checkAnswer(Question question, String selectedAnswer) {
        String correctAnswer = question.getCorrectAnswer();
        if (selectedAnswer.equals(correctAnswer)) {
            Toast.makeText(mContext, "Correct answer!", Toast.LENGTH_SHORT).show();
        } else {
            String message = "Incorrect answer. The correct answer is: " + correctAnswer;
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }
}
