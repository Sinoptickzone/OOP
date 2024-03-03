import Domen.Bottle;
import Domen.HotDrink;
import Domen.Product;
import Services.CoinDispenser;
import Services.Display;
import Services.Holder;
import Services.VendingMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class MainFrame extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    JList<Product> lbAssort;


    JLabel lbWelcome;

    public void initialize() {


        JLabel lbFirstName = new JLabel("Credit:");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Buy");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JList<String> lbAssort = getStringJList();
        //JScrollPane scrollPane = new JScrollPane(lbAssort);
        JPanel formPanel = new JPanel();
        //formPanel.add(scrollPane);
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        //formPanel.add(lbLastName);
        formPanel.add(lbAssort);


        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);


        JButton btnOk = new JButton("Buy");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                String firstName = tfFirstName.getText();
                String lastName = tfFirstName.getText();
                lbWelcome.setText("Hello " + firstName + " " + lastName);


            }

        });


        JButton btnClear = new JButton("Cancel");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tfFirstName.setText("");
                tfFirstName.setText("");
                lbWelcome.setText("");

            }

        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(btnOk);
        buttonPanel.add(btnClear);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));

        mainPanel.add(formPanel, BorderLayout.NORTH);

        mainPanel.add(lbWelcome, BorderLayout.CENTER);


        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        add(mainPanel);


        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);


        setTitle("VendingMachines");
        setSize(500, 600);
        setMaximumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static JList<String> getStringJList() {
        List<Product> assort = new ArrayList<>();
        Product item1 = new Product(100, 1, "Lays");
        Product item2 = new Product(50, 2, "Cola");
        Product item3 = new Bottle(150, 3, "Mineral Water", 101, (float) 1.5);
        Product item4 = new HotDrink(100, 4, "Americano", 4, 95);
        Product item5 = new HotDrink(150, 5, "Capuchino", 5, 80);

        assort.add(item1);
        assort.add(item2);
        assort.add(item3);
        assort.add(item4);
        assort.add(item5);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Product item : assort) {
            listModel.addElement(item.getPlace() + " " + item.getName() + " " + item.getPrice());
        }

        JList<String> lbAssort = new JList<>(listModel);
        return lbAssort;
    }

    public static void main(String[] arg) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }

}
