package gui;
import java.awt.*;
import javax.swing.*;
public class OnlineQuiz {
JFrame f;
JPanel p;
int currentQuestion = 0;
int score = 0;
String username;
// Questions and Answers
private String[][] questions = {
{"Question 1: Which of the following is not a feature?","Dynamic","Architecture Netural","Use of pointers","Object-Oriented"},
{"Question 2: Which is used to find and fix bugs in the Java Programs?","JVM","JRE","JDK","JDB"},
{"Question 3: Which Package contains the Random class?","java.util package","java.lang package","java.awt package","java.io package"},
{"Question 4: An interface with no fields or methods is known as a ____?","Runnable Interface","Marker Interface","Abstract Interface","CharSequence Interface"},
{"Question 5: Which of the following is reversed Keyword in Java?","object","strictfp","main","system"},
{"Question 6: Who Invented Java Programming?","Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup"},
{"Question 7: Which environment Variable is used to set java path?","Maven_Path","JavaPath","JAVA","JAVA_HOME"},
{"Question 8: Which of the folloeing is not an access modifier ?","Protected","Void","Public","Private"},
{"Question 9: What is the numerical range of a char data type in java?","0 to 256","-128 to 127","0 to 65535","0 to 32767"},
{"Question 10: What is the return type of the hashCode() method in the Object class?","Object","int","long","void"}
};
public static void main(String[] args) {
new OnlineQuiz().welcomeScreen(); // Start the quiz on welcome screen
}
// Welcome Screen
private void welcomeScreen() {
f = new JFrame("Welcome");
p = new JPanel();
p.setLayout(null);
JLabel title = new JLabel("ONLINE QUIZ");
title.setBounds(120, 20, 200, 30);
title.setFont(new Font("Arial", Font.BOLD, 24));
title.setForeground(Color.black);
p.add(title);
JLabel nameLabel = new JLabel("Enter Name:");
nameLabel.setBounds(100, 70, 100, 30);
p.add(nameLabel);
JTextField nameField = new JTextField();
nameField.setBounds(200, 70, 150, 30);
p.add(nameField);
JButton nextButton = new JButton("Next");
nextButton.setBounds(150, 120, 100, 30);
nextButton.setBackground(Color.BLUE);
nextButton.setForeground(Color.WHITE);
p.add(nextButton);
nextButton.addActionListener(e -> {
username = nameField.getText();
if (username.isEmpty()) {
JOptionPane.showMessageDialog(f, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
} else {
f.dispose(); // Close welcome screen
rulesScreen(); // Open rules screen
}
});
f.add(p);
f.setSize(400, 250);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
// Rules Screen
private void rulesScreen() {
f = new JFrame("Rules");
p = new JPanel();
p.setLayout(null);
JLabel title = new JLabel("Rules:");
title.setBounds(20, 20, 100, 30);
title.setFont(new Font("Arial", Font.BOLD, 18));
title.setForeground(Color.BLUE.darker());
p.add(title);
JTextArea rulesText = new JTextArea(
"1. Each question carries 5 marks.\n" +
"2. No negative marking.\n" +
"3. Skip questions if unsure.\n" +
"4. Submit at the end.\n" +
"5. Have fun learning!"
);
rulesText.setBounds(20, 60, 300, 100);
rulesText.setEditable(false);
p.add(rulesText);
JButton startButton = new JButton("Start");
startButton.setBounds(150, 180, 100, 30);
startButton.setBackground(Color.ORANGE);
startButton.setForeground(Color.WHITE);
p.add(startButton);
startButton.addActionListener(e -> {
f.dispose(); // Close rules screen
quizScreen(); // Open quiz screen
});
f.add(p);
f.setSize(400, 250);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
// Quiz Screen
private void quizScreen() {
if (currentQuestion < questions.length) {
f = new JFrame("Quiz");
p = new JPanel();
p.setLayout(null);
JLabel questionLabel = new JLabel(questions[currentQuestion][0]);
questionLabel.setBounds(20, 20, 350, 30);
p.add(questionLabel);
ButtonGroup optionsGroup = new ButtonGroup();
JRadioButton[] options = new JRadioButton[4];
for (int i = 0; i < 4; i++) {
options[i] = new JRadioButton(questions[currentQuestion][i + 1]);
options[i].setBounds(20, 60 + (i * 30), 300, 30);
optionsGroup.add(options[i]);
p.add(options[i]);
}
JButton nextButton = new JButton("Next");
nextButton.setBounds(50, 200, 100, 30);
nextButton.setBackground(Color.ORANGE);
nextButton.setForeground(Color.WHITE);
p.add(nextButton);
JButton skipButton = new JButton("Skip");
skipButton.setBounds(200, 200, 100, 30);
skipButton.setBackground(Color.ORANGE);
skipButton.setForeground(Color.WHITE);
p.add(skipButton);
nextButton.addActionListener(e -> {
for (int i = 0; i < 4; i++) {
if (options[i].isSelected() && Integer.toString(i + 1).equals(questions[currentQuestion][5])) {
score += 5; // Increment score if correct answer is selected
}}
currentQuestion++;
f.dispose(); // Close current question screen
quizScreen(); // Show next question
});
skipButton.addActionListener(e -> {
currentQuestion++;
f.dispose(); // Close current question screen
quizScreen(); // Show next question
});
f.add(p);
f.setSize(400, 300);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
} else {
submitScreen(); // Show results when all questions are done
}
}
// Submit Screen
private void submitScreen() {
f = new JFrame("Result");
p = new JPanel();
p.setLayout(null);
JLabel nameLabel = new JLabel("Name: " + username);
nameLabel.setBounds(20, 20, 300, 30);
p.add(nameLabel);
JLabel scoreLabel = new JLabel("Score: " + score);
scoreLabel.setBounds(20, 60, 300, 30);
p.add(scoreLabel);
JLabel messageLabel = new JLabel();
messageLabel.setBounds(20, 100, 300, 30);
if (score >= 40) {
messageLabel.setText("Excellent!");
} else {
messageLabel.setText("Congrats :)");
}
p.add(messageLabel);
f.add(p);
f.setSize(400, 200);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
}
