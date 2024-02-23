import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public QuizQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class QuizApplication {
    private static int score = 0;
    private static int questionNumber = 0;
    private static QuizQuestion[] questions;

    public static void main(String[] args) {
        // Sample quiz questions
        questions = new QuizQuestion[]{
                new QuizQuestion("What is the capital of France?",
                        new String[]{"A. London", "B. Paris", "C. Berlin", "D. Rome"}, 1),
                new QuizQuestion("What is 2 + 2?",
                        new String[]{"A. 3", "B. 4", "C. 5", "D. 6"}, 1),
                new QuizQuestion("What is the largest planet in our solar system?",
                        new String[]{"A. Earth", "B. Jupiter", "C. Mars", "D. Saturn"}, 1)
        };

        startQuiz();
    }

    public static void startQuiz() {
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");

        for (QuizQuestion question : questions) {
            questionNumber++;
            System.out.println("\nQuestion " + questionNumber + ": " + question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up!");
                    askForAnswer(question.getCorrectOptionIndex());
                }
            };

            timer.schedule(task, 10000); // 10 seconds timer

            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            timer.cancel(); // Cancel the timer

            int chosenOptionIndex = -1;
            switch (answer.toUpperCase()) {
                case "A":
                    chosenOptionIndex = 0;
                    break;
                case "B":
                    chosenOptionIndex = 1;
                    break;
                case "C":
                    chosenOptionIndex = 2;
                    break;
                case "D":
                    chosenOptionIndex = 3;
                    break;
                default:
                    break;
            }
            askForAnswer(chosenOptionIndex);
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.length);
    }

    public static void askForAnswer(int correctOptionIndex) {
        if (correctOptionIndex == -1) {
            System.out.println("Invalid answer!");
        } else if (correctOptionIndex == -2) {
            System.out.println("No answer provided!");
        } else if (correctOptionIndex == -3) {
            System.out.println("Time's up!");
        } else if (correctOptionIndex == -4) {
            System.out.println("Quiz completed!");
        } else if (correctOptionIndex == -5) {
            System.out.println("Quiz has not started yet!");
        } else if (correctOptionIndex == -6) {
            System.out.println("Quiz stopped!");
        } else if (correctOptionIndex == -7) {
            System.out.println("The quiz has already ended!");
        } else if (correctOptionIndex == -8) {
            System.out.println("Quiz was paused!");
        } else if (correctOptionIndex == -9) {
            System.out.println("Invalid timer task!");
        } else {
            if (correctOptionIndex == -10) {
                System.out.println("Invalid number of times to execute the quiz!");
            } else {
                if (correctOptionIndex < 0) {
                    System.out.println("An exception occurred!");
                } else {
                    if (correctOptionIndex == -1) {
                        System.out.println("Invalid answer!");
                    } else if (correctOptionIndex == -2) {
                        System.out.println("No answer provided!");
                    } else if (correctOptionIndex == -3) {
                        System.out.println("Time's up!");
                    } else if (correctOptionIndex == -4) {
                        System.out.println("Quiz completed!");
                    } else if (correctOptionIndex == -5) {
                        System.out.println("Quiz has not started yet!");
                    } else if (correctOptionIndex == -6) {
                        System.out.println("Quiz stopped!");
                    } else if (correctOptionIndex == -7) {
                        System.out.println("The quiz has already ended!");
                    } else if (correctOptionIndex == -8) {
                        System.out.println("Quiz was paused!");
                    } else if (correctOptionIndex == -9) {
                        System.out.println("Invalid timer task!");
                    } else {
                        if (correctOptionIndex == -10) {
                            System.out.println("Invalid number of times to execute the quiz!");
                        } else {
                            if (correctOptionIndex < 0) {
                                System.out.println("An exception occurred!");
                            } else {
                                if (correctOptionIndex == 1) {
                                    score++;
                                    System.out.println("Correct!");
                                } else {
                                    System.out.println("Incorrect!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
