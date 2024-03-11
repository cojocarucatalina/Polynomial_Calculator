package GUI;

import org.polinom.Operatii;
import org.polinom.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private JTextField polinom1;
    private JTextField polinom2;
    private static JTextField resultArea;

    public MainFrame(){

        polinom1= new JTextField(20);
        polinom2= new JTextField(20);
        resultArea = new JTextField(20);
        resultArea.setEditable(false);

        JButton addButton = new JButton("Adunare");
        addButton.addActionListener(this);
        addButton.setBackground(Color.PINK);

        JButton subButton = new JButton("Scadere");
        subButton.addActionListener(this);
       // subButton.setActionCommand("Scadere");
        subButton.setBackground(Color.PINK);

        JButton inmButton = new JButton("Inmultire");
        inmButton.addActionListener(this);
        inmButton.setBackground(Color.PINK);

        JButton divButton = new JButton("Impartire");
        divButton.addActionListener(this);
      //  divButton.setActionCommand("Impartire");
        divButton.setBackground(Color.PINK);

        JButton deriv = new JButton("Derivare");
        deriv.addActionListener(this);
        deriv.setBackground(Color.PINK);

        JButton integrare = new JButton("Integrare");
        integrare.addActionListener(this);
        integrare.setBackground(Color.PINK);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setBackground(Color.PINK);

        JPanel POL = new JPanel(new GridLayout(3,2));
        POL.add(new JLabel("POLINOMUL 1:"));
        POL.add(polinom1);
        POL.add(new JLabel("POLINOMUL 2:"));
        POL.add(polinom2);

        JPanel panel = new JPanel(new GridLayout(2,3));
        panel.add(addButton);
        panel.add(subButton);
        panel.add(inmButton);
        panel.add(divButton);
        panel.add(deriv);
        panel.add(integrare);

        JPanel panelrez= new JPanel(new FlowLayout(2));
        panelrez.add(new JLabel("REZULTAT"));
        panelrez.add(resultArea);
        panelrez.add(clear);

        ///////////////////////////////////////////////////////////////

        setLayout(new BorderLayout());
        add(POL, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panelrez, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);////////////////////////////////////////////////
    }

    public void actionPerformed(ActionEvent event){

        String s1=polinom1.getText();
        String s2=polinom2.getText();

        Polinom p1= new Polinom(s1);
        Polinom p2= new Polinom(s2);

        String operation = event.getActionCommand();
        switch(operation){
            case "Adunare":
                Operatii.Adunare(p1,p2);
                break;
            case "Scadere":
                Operatii.Scadere(p1,p2);
                break;
            case "Inmultire":
                Operatii.Inmultire(p1,p2);
                break;
            case "Impartire":
                Operatii.Impartire(p1,p2);
                break;
            case "Derivare":
                Operatii.Derivare(p1);
                break;
            case "Integrare":
                Operatii.Integrare(p1);
                break;
            case "Clear":
                polinom1.setText("");
                polinom2.setText("");
                resultArea.setText("");
                break;

        }
    }

    public static void set(Polinom poli){

        try{
         resultArea.setText(poli.toString());}
        catch (NullPointerException e){}
    }

    public static void set(String poli) {
       try{ resultArea.setText(poli);}
       catch (NullPointerException e){}
    }
}
