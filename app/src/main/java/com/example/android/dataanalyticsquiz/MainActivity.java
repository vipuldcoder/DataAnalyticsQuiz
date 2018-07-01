package com.example.android.dataanalyticsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * This app is Data Analytics Quiz
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The number of correct answers
     */
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the end test button is clicked.
     */
    public void end_Test(View view) {
        EditText nameField = (EditText) findViewById(R.id.input_name_field);
        String name = nameField.getText().toString();

        //Called question checking methods
        question_1();
        question_2();
        question_3();
        question_4();
        question_5();

        // Display the test result on the screen
        String test_result = createTestResult(name, score);
        displayResult(test_result);

        // Disabled "End Test" button after clicking on it.
        Button endTestButton = (Button) findViewById(R.id.end_test_button);
        endTestButton.setEnabled(false);
    }

    /**
     * Create summary of the test result.
     *
     * @param name of the passing the test
     * @param score of the counting of right answers
     * @return text of the test result
     */
    private String createTestResult(String name, int score) {
        String test_result = getString(R.string.test_result_name) + name;
        test_result += "\n" + getString(R.string.test_result_score) + score;
        return test_result;
    }

    /**
     * This method counter correct answers in question 1
     * "Analysts engage in all of the following activities, except:"
     */
    public void question_1() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_1);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_1_4_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.answer_1_4_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer_1_1_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_1_2_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_1_3_radiobutton);
        }
    }

    /**
     * This method counter correct answers in question 2
     * "Data analysts work in a variety of different ways, depending on the project. Data analysts, at a minimum, do what for their data science team?"
     */
    public void question_2() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_2);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_2_4_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.answer_2_4_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer_2_1_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_2_2_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_2_3_radiobutton);
        }
    }

    /**
     * This method counter correct answers in question 3
     * "If you are a beginner to data analysis, what is the first thing you should check when you build data queries?"
     */
    public void question_3() {
        RadioButton answerRadio;
        RadioGroup answers = (RadioGroup) findViewById(R.id.question_3);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_3_1_radiobutton:
                answerRadio = (RadioButton) findViewById(R.id.answer_3_1_radiobutton);
                increment_score();
                break;
            default:
                answerRadio = (RadioButton) findViewById(R.id.answer_3_2_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_3_3_radiobutton);
                answerRadio = (RadioButton) findViewById(R.id.answer_3_4_radiobutton);
        }
    }

    /**
     * This method counter correct answers in question 4
     * "Using Above Images which graphs are match these options:"
     */
    public void question_4() {
        // Figure out if the user chose "Histogram" answer
        CheckBox HistogramCheckbox = (CheckBox) findViewById(R.id.histogram_checkbox);
        boolean hasHistogram = HistogramCheckbox.isChecked();

        if (hasHistogram) {
            increment_score();
        }

        // Figure out if the user chose "Piechart" answer
        CheckBox PiechartCheckbox = (CheckBox) findViewById(R.id.piechart_checkbox);
        boolean hasPiechart = PiechartCheckbox.isChecked();

        if (hasPiechart) {
            increment_score();
        }

    }

    /**
     * This method counter correct answers in question 5 which is entered by user
     * "Data ____ ensures that we have quality data." Error Please help
     */
    public void question_5() {
        String answer5;
        question5_answer = (EditText) this.findViewById(R.id.question_5_answer);
        answer5 = question5_answer.getText().toString().toLowerCase();
        if (answer5.equals("raw")) {
            answer5_score = increment_score();
        }

    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayResult(String result) {
        TextView testResultTextView = (TextView) findViewById(R.id.test_result_text_view);
        testResultTextView.setText(result);
    }

    /**
     * This method is called when user selected the correct answer.
     * Added +1 to score for each correct answer
     */
    private int increment_score() {
        score = ++score;
        return score;
    }
}
