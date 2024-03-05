package view;

import controller.ComplexCalculator;
import model.ComplexNumber;
import model.Operation;
import main.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The view.ComplexCalculatorUI class represents the user interface for a complex number calculator application.
 * It creates a JFrame with components for performing complex number calculations.
 */
public class ComplexCalculatorUI {
    private JFrame jFrame;
    private GridBagLayout gridBagLayout;
    private JTextField realPart1 = new JTextField(8);
    private JTextField imaginaryPart1 = new JTextField(8);
    private JTextField realPart2 = new JTextField(8);
    private JTextField imaginaryPart2 = new JTextField(8);
    private JTextField resultReal = new JTextField(8);
    private JTextField resultImaginary = new JTextField(8);
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");
    private JButton clearButton = new JButton("Clear");

    /**
     * Constructor for the view.ComplexCalculatorUI class.
     * Creates a new JFrame, sets its title, layout, size, and other properties.
     * Adds components like buttons, text fields, and labels to the frame.
     * Adds action listeners to the components for handling user interactions.
     * Also adds a WindowListener to the JFrame to log a message before closing the application.
     */
    public ComplexCalculatorUI() {
        jFrame = new JFrame(); // create new frame
        jFrame.setTitle("Complex Number Calculator"); // set frame's title
        gridBagLayout = new GridBagLayout(); // create layout
        jFrame.setLayout(gridBagLayout); // set frame's layout

        addComponents(); // add buttons, text fields, labels
        addActionListeners(); // add listeners to components

        // Adding WindowListener to JFrame
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Action before closing JFrame
                App.logger.info("Complex Number Calculator closed.");
                super.windowClosing(e);
            }
        });
        jFrame.setSize(500, 300); // set size of the frame
        jFrame.setResizable(false); // forbid resizing frame
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit application on closing frame
        jFrame.setVisible(true); // show frame
    }

    /**
     * Adds components like labels, text fields, and buttons to the JFrame for the complex number calculator.
     */
    private void addComponents() {
        // Initialize constraints for gridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(3,1,3,1);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridheight = 1;

        // Add components for the first complex number
        jFrame.add(new JLabel("First Complex Number: "));
        jFrame.add(realPart1);
        jFrame.add(new JLabel("+ i *"));
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(imaginaryPart1, constraints);
        jFrame.add(imaginaryPart1);

        // Add components for the second complex number
        jFrame.add(new JLabel("Second Complex Number: "));
        jFrame.add(realPart2);
        jFrame.add(new JLabel("+ i *"));
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(imaginaryPart2, constraints);
        jFrame.add(imaginaryPart2);

        // Create a row panel for operation buttons
        JPanel rowPanel = new JPanel(new GridLayout(1, 4)); // one line, four columns
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(rowPanel, constraints);
        rowPanel.add(addButton);
        rowPanel.add(subtractButton);
        rowPanel.add(multiplyButton);
        rowPanel.add(divideButton);
        jFrame.add(rowPanel);

        // Add components for displaying the result
        jFrame.add(new JLabel("Result: "));
        jFrame.add(resultReal);
        jFrame.add(new JLabel("+ i *"));
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(resultImaginary, constraints);
        jFrame.add(resultImaginary);

        gridBagLayout.setConstraints(clearButton, constraints);
        jFrame.add(clearButton);
    }

    /**
     * Performs the specified operation on the two complex numbers entered by the user.
     *
     * @param operation The operation to perform (ADD, SUBTRACT, MULTIPLY, DIVIDE)
     */
    private void performOperation(Operation operation) {
        try {
            // Parse the real and imaginary parts of the two complex
            double real1 = Double.parseDouble(realPart1.getText());
            double imaginary1 = Double.parseDouble(imaginaryPart1.getText());
            double real2 = Double.parseDouble(realPart2.getText());
            double imaginary2 = Double.parseDouble(imaginaryPart2.getText());

            // Create model.ComplexNumber objects for the two input numbers
            ComplexNumber num1 = new ComplexNumber(real1, imaginary1);
            ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

            // Determine the operation to perform and calculate the result
            ComplexNumber result;
            String operationSymbol = switch (operation) {
                case ADD -> {
                    result = ComplexCalculator.add(num1, num2);
                    yield "+";
                }
                case SUBTRACT -> {
                    result = ComplexCalculator.subtract(num1, num2);
                    yield "-";
                }
                case MULTIPLY -> {
                    result = ComplexCalculator.multiply(num1, num2);
                    yield "*";
                }
                case DIVIDE -> {
                    result = ComplexCalculator.divide(num1, num2);
                    yield "/";
                }
            };

            // Set the text fields to display the real and imaginary parts of the result
            resultReal.setText(String.valueOf(result.getRealPart()));
            resultImaginary.setText(String.valueOf(result.getImaginaryPart()));

            // Log the operation performed with the input numbers and the result
            App.logger.info("Performed " + operation + ": " + num1 + " " + operationSymbol + " " + num2 + " = " + result);
        } catch (NumberFormatException e) {
            // Show an error message if there is a NumberFormatException (wrong input)
            JOptionPane.showMessageDialog(jFrame, "Wrong input or not all fields are filled in.");
            App.logger.warning(e.getMessage());
        }
    }

    /**
     * Adds listeners to buttons
     */
    private void addActionListeners() {
        addButton.addActionListener(e -> performOperation(Operation.ADD));
        subtractButton.addActionListener(e -> performOperation(Operation.SUBTRACT));
        multiplyButton.addActionListener(e -> performOperation(Operation.MULTIPLY));
        divideButton.addActionListener(e -> performOperation(Operation.DIVIDE));

        // clear all text fields on clicking clear button
        clearButton.addActionListener(e -> {
            realPart1.setText("");
            imaginaryPart1.setText("");
            realPart2.setText("");
            imaginaryPart2.setText("");
            resultReal.setText("");
            resultImaginary.setText("");
        });
    }
}
