package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pago extends JFrame {
    public Pago() {
        setTitle("Pago");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BorderLayout());
        detailPanel.setBorder(BorderFactory.createTitledBorder("Detalle de la compra"));

        JTextArea purchaseDetails = new JTextArea();
        purchaseDetails.setEditable(false);
        purchaseDetails.setText("1x Menu Ejecutivo - $3.500");
        JScrollPane scrollPane = new JScrollPane(purchaseDetails);

        detailPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel pinPanel = new JPanel();
        pinPanel.setLayout(new GridLayout(2, 2, 5, 5));
        pinPanel.setBorder(BorderFactory.createTitledBorder("Finalizar Pago"));

        JLabel pinLabel = new JLabel("Ingrese PIN:");
        JPasswordField pinField = new JPasswordField();
        JButton payButton = new JButton("Pagar");

        JLabel messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);

        pinPanel.add(pinLabel);
        pinPanel.add(pinField);
        pinPanel.add(new JLabel());
        pinPanel.add(payButton);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pin = new String(pinField.getPassword());
                if (pin.equals("1234")) { //Un pin de validacion
                    messageLabel.setText("Pago realizado con éxito.");
                    messageLabel.setForeground(Color.GREEN);
                } else {
                    messageLabel.setText("PIN incorrecto. Ingrese de nuevo el PIN.");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        add(detailPanel, BorderLayout.CENTER);
        add(pinPanel, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Pago::new);
    }
}
